/*
 * Copyright (C) 2005 Alfresco, Inc.
 *
 * Licensed under the Mozilla Public License version 1.1 
 * with a permitted attribution clause. You may obtain a
 * copy of the License at
 *
 *   http://www.alfresco.org/legal/license.txt
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */
package org.alfresco.repo.search.impl.lucene;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.alfresco.repo.search.IndexerException;
import org.alfresco.repo.search.impl.lucene.index.IndexInfo;
import org.alfresco.repo.search.impl.lucene.index.TransactionStatus;
import org.alfresco.repo.search.impl.lucene.index.IndexInfo.LockWork;
import org.alfresco.service.cmr.dictionary.DictionaryService;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.StoreRef;
import org.apache.log4j.Logger;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Searcher;

/**
 * Common support for abstracting the lucene indexer from its configuration and management requirements.
 * 
 * <p>
 * This class defines where the indexes are stored. This should be via a configurable Bean property in Spring.
 * 
 * <p>
 * The default file structure is
 * <ol>
 * <li><b>"base"/"protocol"/"name"/</b> for the main index
 * <li><b>"base"/"protocol"/"name"/deltas/"id"</b> for transactional updates
 * <li><b>"base"/"protocol"/"name"/undo/"id"</b> undo information
 * </ol>
 * 
 * <p>
 * The IndexWriter and IndexReader for a given index are toggled (one should be used for delete and the other for write). These are reused/closed/initialised as required.
 * 
 * <p>
 * The index deltas are buffered to memory and persisted in the file system as required.
 * 
 * @author Andy Hind
 * 
 */

public abstract class LuceneBase2
{
    private static Logger s_logger = Logger.getLogger(LuceneBase2.class);

    private IndexInfo indexInfo;

    /**
     * The identifier for the store
     */

    protected StoreRef store;

    /**
     * The identifier for the delta
     */

    protected String deltaId;

    private LuceneConfig config;

    // "lucene-indexes";

    /**
     * Initialise the configuration elements of the lucene store indexers and searchers.
     * 
     * @param store
     * @param deltaId
     * @throws IOException
     */
    protected void initialise(StoreRef store, String deltaId, boolean createMain, boolean createDelta)
            throws LuceneIndexException
    {
        this.store = store;
        this.deltaId = deltaId;

        String basePath = getBasePath();
        File baseDir = new File(basePath);
        indexInfo = IndexInfo.getIndexInfo(baseDir);
        try
        {
            if (deltaId != null)
            {
                indexInfo.setStatus(deltaId, TransactionStatus.ACTIVE, null, null);
            }
        }
        catch (IOException e)
        {
            throw new IndexerException("Filed to set delta as active");
        }

    }

    /**
     * Utility method to find the path to the base index
     * 
     * @return
     */
    private String getBasePath()
    {
        if (config.getIndexRootLocation() == null)
        {
            throw new IndexerException("No configuration for index location");
        }
        String basePath = config.getIndexRootLocation()
                + File.separator + store.getProtocol() + File.separator + store.getIdentifier() + File.separator;
        return basePath;
    }

    /**
     * Get a searcher for the main index TODO: Split out support for the main index. We really only need this if we want to search over the changing index before it is committed
     * 
     * @return
     * @throws IOException
     */

    protected IndexSearcher getSearcher() throws LuceneIndexException
    {
        try
        {
            return new ClosingIndexSearcher(indexInfo.getMainIndexReferenceCountingReadOnlyIndexReader());
        }
        catch (IOException e)
        {
            s_logger.error("Error", e);
            throw new LuceneIndexException("Failed to open IndexSarcher for " + getBasePath(), e);
        }
    }

    protected ClosingIndexSearcher getSearcher(LuceneIndexer2 luceneIndexer) throws LuceneIndexException
    {
        // If we know the delta id we should do better

        try
        {
            if (luceneIndexer == null)
            {
                return new ClosingIndexSearcher(indexInfo.getMainIndexReferenceCountingReadOnlyIndexReader());
            }
            else
            {
                // TODO: Create appropriate reader that lies about deletions
                // from the first
                //
                luceneIndexer.flushPending();
                return new ClosingIndexSearcher(indexInfo.getMainIndexReferenceCountingReadOnlyIndexReader(deltaId,
                        luceneIndexer.getDeletions(), luceneIndexer.getDeleteOnlyNodes()));
            }

        }
        catch (IOException e)
        {
            s_logger.error("Error", e);
            throw new LuceneIndexException("Failed to open IndexSarcher for " + getBasePath(), e);
        }
    }

    /**
     * Get a reader for the on file portion of the delta
     * 
     * @return
     * @throws IOException
     * @throws IOException
     */

    protected IndexReader getDeltaReader() throws LuceneIndexException, IOException
    {
        return indexInfo.getDeltaIndexReader(deltaId);
    }

    /**
     * Close the on file reader for the delta if it is open
     * 
     * @throws IOException
     * 
     * @throws IOException
     */

    protected void closeDeltaReader() throws LuceneIndexException, IOException
    {
        indexInfo.closeDeltaIndexReader(deltaId);
    }

    /**
     * Get the on file writer for the delta
     * 
     * @return
     * @throws IOException
     * @throws IOException
     */
    protected IndexWriter getDeltaWriter() throws LuceneIndexException, IOException
    {
        return indexInfo.getDeltaIndexWriter(deltaId, new LuceneAnalyser(dictionaryService));
    }

    /**
     * Close the on disk delta writer
     * 
     * @throws IOException
     * 
     * @throws IOException
     */

    protected void closeDeltaWriter() throws LuceneIndexException, IOException
    {
        indexInfo.closeDeltaIndexWriter(deltaId);
    }

    /**
     * Save the in memory delta to the disk, make sure there is nothing held in memory
     * 
     * @throws IOException
     * 
     * @throws IOException
     */
    protected void saveDelta() throws LuceneIndexException, IOException
    {
        // Only one should exist so we do not need error trapping to execute the
        // other
        closeDeltaReader();
        closeDeltaWriter();
    }

    protected void setInfo(long docs, Set<NodeRef> deletions, boolean deleteNodesOnly) throws IOException
    {
        indexInfo.setPreparedState(deltaId, deletions, docs, deleteNodesOnly);
    }

    protected void setStatus(TransactionStatus status) throws IOException
    {
        indexInfo.setStatus(deltaId, status, null, null);
    }

    private DictionaryService dictionaryService;

    protected IndexReader getReader() throws LuceneIndexException, IOException
    {
        return indexInfo.getMainIndexReferenceCountingReadOnlyIndexReader();
    }

    public void setDictionaryService(DictionaryService dictionaryService)
    {
        this.dictionaryService = dictionaryService;
    }

    public DictionaryService getDictionaryService()
    {
        return dictionaryService;
    }

    public void setLuceneConfig(LuceneConfig config)
    {
        this.config = config;
    }

    public LuceneConfig getLuceneConfig()
    {
        return config;
    }

    public String getDeltaId()
    {
        return deltaId;
    }
    

    public <R> R doWithWriteLock(LockWork<R> lockWork)
    {
        return indexInfo.doWithWriteLock(lockWork);
    }

}
