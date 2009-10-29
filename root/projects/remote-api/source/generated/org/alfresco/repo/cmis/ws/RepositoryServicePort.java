package org.alfresco.repo.cmis.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.1.2
 * Mon Oct 12 11:20:37 EEST 2009
 * Generated source version: 2.1.2
 * 
 */
 
@WebService(targetNamespace = "http://docs.oasis-open.org/ns/cmis/ws/200908/", name = "RepositoryServicePort")
@XmlSeeAlso({ObjectFactory.class})
public interface RepositoryServicePort {

    @ResponseWrapper(localName = "getRepositoriesResponse", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/", className = "org.alfresco.repo.cmis.ws.GetRepositoriesResponse")
    @RequestWrapper(localName = "getRepositories", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/", className = "org.alfresco.repo.cmis.ws.GetRepositories")
    @WebResult(name = "repositories", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
    @WebMethod
    public java.util.List<org.alfresco.repo.cmis.ws.CmisRepositoryEntryType> getRepositories(
        @WebParam(name = "extension", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        org.alfresco.repo.cmis.ws.CmisExtensionType extension
    ) throws CmisException;

    @ResponseWrapper(localName = "getTypeDefinitionResponse", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/", className = "org.alfresco.repo.cmis.ws.GetTypeDefinitionResponse")
    @RequestWrapper(localName = "getTypeDefinition", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/", className = "org.alfresco.repo.cmis.ws.GetTypeDefinition")
    @WebResult(name = "type", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
    @WebMethod
    public org.alfresco.repo.cmis.ws.CmisTypeDefinitionType getTypeDefinition(
        @WebParam(name = "repositoryId", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        java.lang.String repositoryId,
        @WebParam(name = "typeId", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        java.lang.String typeId,
        @WebParam(name = "extension", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        org.alfresco.repo.cmis.ws.CmisExtensionType extension
    ) throws CmisException;

    @ResponseWrapper(localName = "getTypeDescendantsResponse", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/", className = "org.alfresco.repo.cmis.ws.GetTypeDescendantsResponse")
    @RequestWrapper(localName = "getTypeDescendants", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/", className = "org.alfresco.repo.cmis.ws.GetTypeDescendants")
    @WebResult(name = "types", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
    @WebMethod
    public java.util.List<org.alfresco.repo.cmis.ws.CmisTypeContainer> getTypeDescendants(
        @WebParam(name = "repositoryId", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        java.lang.String repositoryId,
        @WebParam(name = "typeId", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        java.lang.String typeId,
        @WebParam(name = "depth", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        java.math.BigInteger depth,
        @WebParam(name = "includePropertyDefinitions", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        java.lang.Boolean includePropertyDefinitions,
        @WebParam(name = "extension", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        org.alfresco.repo.cmis.ws.CmisExtensionType extension
    ) throws CmisException;

    @ResponseWrapper(localName = "getTypeChildrenResponse", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/", className = "org.alfresco.repo.cmis.ws.GetTypeChildrenResponse")
    @RequestWrapper(localName = "getTypeChildren", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/", className = "org.alfresco.repo.cmis.ws.GetTypeChildren")
    @WebResult(name = "types", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
    @WebMethod
    public org.alfresco.repo.cmis.ws.CmisTypeDefinitionListType getTypeChildren(
        @WebParam(name = "repositoryId", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        java.lang.String repositoryId,
        @WebParam(name = "typeId", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        java.lang.String typeId,
        @WebParam(name = "includePropertyDefinitions", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        java.lang.Boolean includePropertyDefinitions,
        @WebParam(name = "maxItems", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        java.math.BigInteger maxItems,
        @WebParam(name = "skipCount", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        java.math.BigInteger skipCount,
        @WebParam(name = "extension", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        org.alfresco.repo.cmis.ws.CmisExtensionType extension
    ) throws CmisException;

    @ResponseWrapper(localName = "getRepositoryInfoResponse", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/", className = "org.alfresco.repo.cmis.ws.GetRepositoryInfoResponse")
    @RequestWrapper(localName = "getRepositoryInfo", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/", className = "org.alfresco.repo.cmis.ws.GetRepositoryInfo")
    @WebResult(name = "repositoryInfo", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
    @WebMethod
    public org.alfresco.repo.cmis.ws.CmisRepositoryInfoType getRepositoryInfo(
        @WebParam(name = "repositoryId", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        java.lang.String repositoryId,
        @WebParam(name = "extension", targetNamespace = "http://docs.oasis-open.org/ns/cmis/messaging/200908/")
        org.alfresco.repo.cmis.ws.CmisExtensionType extension
    ) throws CmisException;
}
