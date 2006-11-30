<%--
  Copyright (C) 2005 Alfresco, Inc.
 
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/alfresco.tld" prefix="a" %>
<%@ taglib uri="/WEB-INF/repo.tld" prefix="r" %>

<%@ page buffer="32kb" contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page import="org.alfresco.web.ui.common.PanelGenerator" %>

<r:page titleId="title_change_user_roles">

<f:view>
   
   <%-- load a bundle of properties with I18N strings --%>
   <f:loadBundle basename="alfresco.messages.webclient" var="msg"/>
   
   <h:form acceptCharset="UTF-8" id="invite-users">
   
   <%-- Main outer table --%>
   <table cellspacing="0" cellpadding="2">
      
      <%-- Title bar --%>
      <tr>
         <td colspan="2">
            <%@ include file="../parts/titlebar.jsp" %>
         </td>
      </tr>
      
      <%-- Main area --%>
      <tr valign="top">
         <%-- Shelf --%>
         <td>
            <%@ include file="../parts/shelf.jsp" %>
         </td>
         
         <%-- Work Area --%>
         <td width="100%">
            <table cellspacing="0" cellpadding="0" width="100%">
               <%-- Breadcrumb --%>
               <%@ include file="../parts/breadcrumb.jsp" %>
               
               <%-- Status and Actions --%>
               <tr>
                  <td style="background-image: url(<%=request.getContextPath()%>/images/parts/statuspanel_4.gif)" width="4"></td>
                  <td bgcolor="#EEEEEE">
                  
                     <%-- Status and Actions inner contents table --%>
                     <%-- Generally this consists of an icon, textual summary and actions for the current object --%>
                     <table cellspacing="4" cellpadding="0" width="100%">
                        <tr>
                           <td width="32">
                              <h:graphicImage id="wizard-logo" url="/images/icons/edituser_large.gif" />
                           </td>
                           <td>
                              <div class="mainTitle">
                                 <h:outputText value="#{msg.modify_user_roles}" />
                                 '<h:outputText value="#{SpaceUsersBean.personName}" />'
                              </div>
                              <div class="mainSubText"><h:outputText value="#{msg.modify_user_roles_description}" /></div>
                           </td>
                        </tr>
                     </table>
                     
                  </td>
                  <td style="background-image: url(<%=request.getContextPath()%>/images/parts/statuspanel_6.gif)" width="4"></td>
               </tr>
               
               <%-- separator row with gradient shadow --%>
               <tr>
                  <td><img src="<%=request.getContextPath()%>/images/parts/statuspanel_7.gif" width="4" height="9"></td>
                  <td style="background-image: url(<%=request.getContextPath()%>/images/parts/statuspanel_8.gif)"></td>
                  <td><img src="<%=request.getContextPath()%>/images/parts/statuspanel_9.gif" width="4" height="9"></td>
               </tr>
               
               <%-- Details --%>
               <tr valign=top>
                  <td style="background-image: url(<%=request.getContextPath()%>/images/parts/whitepanel_4.gif)" width="4"></td>
                  <td>
                     <table cellspacing="0" cellpadding="3" border="0" width="100%">
                        <tr>
                           <td width="100%" valign="top">
                              <% PanelGenerator.generatePanelStart(out, request.getContextPath(), "white", "white"); %>
                              <table cellpadding="2" cellspacing="2" border="0" width="100%">
                                 <tr>
                                    <td class="mainSubTitle"><h:outputText value="#{msg.change_user_roles}" /></td>
                                 </tr>
                                 <tr><td class="paddingRow"></td></tr>
                                 <tr>
                                    <td>1.&nbsp;<h:outputText value="#{msg.select_role}" /></td>
                                 </tr>
                                 <tr>
                                    <td>
                                       <h:selectOneListbox id="roles" style="width:250px" size="5">
                                          <f:selectItems value="#{InviteSpaceUsersWizard.roles}" />
                                       </h:selectOneListbox>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td>
                                       2.&nbsp;<h:commandButton value="#{msg.add_to_list_button}" actionListener="#{SpaceUsersBean.addRole}" />
                                    </td>
                                 </tr>
                                 <tr><td class="paddingRow"></td></tr>
                                 <tr>
                                    <td><h:outputText value="#{msg.selected_roles}" /></td>
                                 </tr>
                                 <tr>
                                    <td>
                                       <h:dataTable value="#{SpaceUsersBean.personRolesDataModel}" var="row"
                                                    rowClasses="selectedItemsRow,selectedItemsRowAlt"
                                                    styleClass="selectedItems" headerClass="selectedItemsHeader"
                                                    cellspacing="0" cellpadding="4" 
                                                    rendered="#{SpaceUsersBean.personRolesDataModel.rowCount != 0}">
                                          <h:column>
                                             <f:facet name="header">
                                                <h:outputText value="#{msg.name}" />
                                             </f:facet>
                                             <h:outputText value="#{row.role}" />
                                          </h:column>
                                          <h:column>
                                             <a:actionLink actionListener="#{SpaceUsersBean.removeRole}" image="/images/icons/delete.gif"
                                                           value="#{msg.remove}" showLink="false" style="padding-left:6px" />
                                          </h:column>
                                       </h:dataTable>
                                       <a:panel id="no-items" rendered="#{SpaceUsersBean.personRolesDataModel.rowCount == 0}">
                                          <table cellspacing='0' cellpadding='2' border='0' class='selectedItems'>
                                             <tr>
                                                <td colspan='2' class='selectedItemsHeader'><h:outputText id="no-items-name" value="#{msg.name}" /></td>
                                             </tr>
                                             <tr>
                                                <td class='selectedItemsRow'><h:outputText id="no-items-msg" value="#{msg.no_selected_items}" /></td>
                                             </tr>
                                          </table>
                                       </a:panel>
                                    </td>
                                 </tr>
                                 <tr><td colspan=2 class="paddingRow"></td></tr>
                              </table>
                              <% PanelGenerator.generatePanelEnd(out, request.getContextPath(), "white"); %>
                           </td>
                           
                           <td valign="top">
                              <% PanelGenerator.generatePanelStart(out, request.getContextPath(), "blue", "#D3E6FE"); %>
                              <table cellpadding="1" cellspacing="1" border="0">
                                 <tr>
                                    <td align="center">
                                       <h:commandButton value="#{msg.ok}" action="#{SpaceUsersBean.finishOK}" styleClass="wizardButton" />
                                    </td>
                                 </tr>
                                 <tr>
                                    <td align="center">
                                       <h:commandButton value="#{msg.cancel_button}" action="cancel" styleClass="wizardButton" />
                                    </td>
                                 </tr>
                              </table>
                              <% PanelGenerator.generatePanelEnd(out, request.getContextPath(), "blue"); %>
                           </td>
                        </tr>
                     </table>
                  </td>
                  <td style="background-image: url(<%=request.getContextPath()%>/images/parts/whitepanel_6.gif)" width="4"></td>
               </tr>
               
               <%-- Error Messages --%>
               <tr valign="top">
                  <td style="background-image: url(<%=request.getContextPath()%>/images/parts/whitepanel_4.gif)" width="4"></td>
                  <td>
                     <%-- messages tag to show messages not handled by other specific message tags --%>
                     <h:messages globalOnly="true" styleClass="errorMessage" layout="table" />
                  </td>
                  <td style="background-image: url(<%=request.getContextPath()%>/images/parts/whitepanel_6.gif)" width="4"></td>
               </tr>
               
               <%-- separator row with bottom panel graphics --%>
               <tr>
                  <td><img src="<%=request.getContextPath()%>/images/parts/whitepanel_7.gif" width="4" height="4"></td>
                  <td width="100%" align="center" style="background-image: url(<%=request.getContextPath()%>/images/parts/whitepanel_8.gif)"></td>
                  <td><img src="<%=request.getContextPath()%>/images/parts/whitepanel_9.gif" width="4" height="4"></td>
               </tr>
               
            </table>
          </td>
       </tr>
    </table>
    
    </h:form>
    
</f:view>

</r:page>