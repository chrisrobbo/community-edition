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
package org.alfresco.benchmark.framework;


/**
 * @author Roy Wetherall
 */
public class LoadedData
{
    private String rootFolderReference;
    
    private int folderCount = 0;
    private int contentCount = 0;
    
    public LoadedData(String rootFolderReference)
    {
        this.rootFolderReference = rootFolderReference;
    }
    
    public String getRootFolder()
    {
        return rootFolderReference;
    }
    
    public void incrementFolderCount(int inc)
    {
        this.folderCount += inc;
    }
    
    public int getFolderCount()
    {
        return folderCount;
    }
    
    public void incrementContentCount(int inc)
    {
        this.contentCount += inc;
    }
    
    public int getContentCount()
    {
        return contentCount;
    }
    
}
