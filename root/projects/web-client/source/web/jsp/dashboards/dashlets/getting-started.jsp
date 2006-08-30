<%--
  Copyright (C) 2006 Alfresco, Inc.
 
  Licensed under the Mozilla Public License version 1.1 
  with a permitted attribution clause. You may obtain a
  copy of the License at
 
    http://www.alfresco.org/legal/license.txt
 
  Unless required by applicable law or agreed to in writing,
  software distributed under the License is distributed on an
  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
  either express or implied. See the License for the specific
  language governing permissions and limitations under the
  License.
--%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="/WEB-INF/alfresco.tld" prefix="a" %>
<%@ taglib uri="/WEB-INF/repo.tld" prefix="r" %>

<%@ page import="org.alfresco.web.ui.common.PanelGenerator" %>

<f:verbatim>
<% PanelGenerator.generatePanelStart(out, request.getContextPath(), "yellow", "#ffffcc"); %>
</f:verbatim>
<h:panelGrid columns="2" cellpadding="2" cellspacing="2" border="0" width="100%" style="background-colour:##ffffcc" rowClasses="alignTop">
   <h:panelGrid columns="1" cellpadding="2" cellspacing="2" border="0">
      <h:outputText style="font-size: 11px; font-weight:bold; color:#4272B4" value="#{msg.product_name}" />
   
      <h:panelGrid columns="2" cellpadding="2" cellspacing="2" border="0">
         <h:graphicImage value="/images/icons/gettingstarted_demonstration.gif" width="32" height="32" />
         <h:panelGroup>
            <a:actionLink href="http://www.alfresco.com/products/ecm/demonstrations/" target="new" style="font-weight:bold" value="#{msg.gettingstarted_demonstration}" />
            <f:verbatim><br></f:verbatim>
            <h:outputText value="#{msg.gettingstarted_demonstration_desc}" />
         </h:panelGroup>
      </h:panelGrid>
   
      <h:panelGrid columns="2" cellpadding="2" cellspacing="2" border="0">
         <h:graphicImage value="/images/icons/gettingstarted_featuretour.gif" width="32" height="32" />
         <h:panelGroup>
            <a:actionLink href="http://www.alfresco.com/products/ecm/tour/" target="new" style="font-weight:bold" value="#{msg.gettingstarted_featuretour}" />
            <f:verbatim><br></f:verbatim>
            <h:outputText value="#{msg.gettingstarted_featuretour_desc}" />
         </h:panelGroup>
      </h:panelGrid>
      
      <h:panelGrid columns="2" cellpadding="2" cellspacing="2" border="0">
         <h:graphicImage value="/images/icons/gettingstarted_onlinehelp.gif" width="32" height="32" />
         <h:panelGroup>
            <a:actionLink href="#{NavigationBean.helpUrl}" target="help" style="font-weight:bold" value="#{msg.gettingstarted_onlinehelp}" />
            <f:verbatim><br></f:verbatim>
            <h:outputText value="#{msg.gettingstarted_onlinehelp_desc}" />
         </h:panelGroup>
      </h:panelGrid>
   </h:panelGrid>
   
   <h:panelGrid columns="1" cellpadding="2" cellspacing="2" border="0">
      <h:outputText style="font-size: 11px; font-weight:bold; color:#4272B4" value="#{msg.gettingstarted_commontasks}" />
      
      <h:panelGrid columns="2" cellpadding="2" cellspacing="2" border="0">
         <h:graphicImage value="/images/icons/gettingstarted_browse.gif" width="32" height="32" />
         <h:panelGroup>
            <a:actionLink style="font-weight:bold" value="#{msg.gettingstarted_browse}" action="#{GettingStartedBean.browseHomeSpace}" />
            <f:verbatim><br></f:verbatim>
            <h:outputText value="#{msg.gettingstarted_browse_desc}" />
         </h:panelGroup>
      </h:panelGrid>
      
      <h:panelGrid columns="2" cellpadding="2" cellspacing="2" border="0">
         <h:graphicImage value="/images/icons/create_space_large.gif" width="32" height="32" />
         <h:panelGroup>
            <a:actionLink style="font-weight:bold" value="#{msg.gettingstarted_createspace}" action="#{GettingStartedBean.createSpace}" />
            <f:verbatim><br></f:verbatim>
            <h:outputText value="#{msg.gettingstarted_createspace_desc}" />
         </h:panelGroup>
      </h:panelGrid>
      
      <h:panelGrid columns="2" cellpadding="2" cellspacing="2" border="0">
         <h:graphicImage value="/images/icons/add_content_large.gif" width="32" height="32" />
         <h:panelGroup>
            <a:actionLink style="font-weight:bold" value="#{msg.gettingstarted_addcontent}" action="#{GettingStartedBean.addContent}" actionListener="#{AddContentDialog.start}" />
            <f:verbatim><br></f:verbatim>
            <h:outputText value="#{msg.gettingstarted_addcontent_desc}" />
         </h:panelGroup>
      </h:panelGrid>
      
      <h:panelGrid columns="2" cellpadding="2" cellspacing="2" border="0">
         <h:graphicImage value="/images/icons/new_content_large.gif" width="32" height="32" />
         <h:panelGroup>
            <a:actionLink style="font-weight:bold" value="#{msg.gettingstarted_createcontent}" action="#{GettingStartedBean.createContent}" />
            <f:verbatim><br></f:verbatim>
            <h:outputText value="#{msg.gettingstarted_createcontent_desc}" />
         </h:panelGroup>
      </h:panelGrid>
   </h:panelGrid>
   
</h:panelGrid>
<f:verbatim>
<% PanelGenerator.generatePanelEnd(out, request.getContextPath(), "yellow"); %>
</f:verbatim>
