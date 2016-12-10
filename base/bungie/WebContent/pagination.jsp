<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.redbridge.dto.Pagination"%>
<%
     Pagination pagination = (Pagination) session.getAttribute("pagination");
     boolean previous = false;
     if(pagination.getPage_number() > 1){
      previous = true;
     }
     boolean next = true;
     if(pagination.getTotal_pages() == pagination.getPage_number()){
      next = false;
     }
%>

<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
  <link  href="styles/pagination.css" rel="stylesheet" type="text/css">
  <script src="scripts/pagination.js" type="text/javascript"></script>
  </head>
  
  <body> -->
    
 <%--  <input type="text" style="display: none;" name="pagination.sortColumn" id="sortColumn" value="<%=pagination.getSortColumn()%>"/>
  <input type="text" style="display: none;" name="pagination.sortOrder" id="sortOrder" value="<%=pagination.getSortOrder()%>"/> --%>
  <table width="50%" align="center">
   <tr>
     <%-- <td class="pagination-label" width="100%" nowrap="nowrap"><%=pagination.getPage_records() %> Items
     </td> --%>
     <td>
      <%if(previous){%>
      <a href="#" onclick="fnPagination(4,<%=pagination.getTotal_pages()%>);">
       <img src="images/first.png" alt="Go to first page" width="20'" height="25"/>
      </a>
      <%}else{ %>
       <img src="images/first.png" alt="Go to first page" width="20'" height="25"/>
      <%} %>
     </td>
     <td>
      <%if(previous){%>
      <a href="#" onclick="fnPagination(3,<%=pagination.getTotal_pages()%>);">
       <img src="images/before.png" alt="Go to first page" width="20'" height="25"/>
      </a>
      <%}else{ %>
       <img src="images/before.png" alt="Go to first page" width="20'" 
height="25"/>
      <%} %>
     </td>
     <td class="pagination-label" nowrap="nowrap"><s:text name="label.pagina"/></td>
     <td>
      <input name="page_number" id="page_numberID" class="pagination-textbox" 
      <%if(!previous && !next) {%>readonly="readonly"<%}%>
      style="width: 10px;" maxlen="1" value="<%=pagination.getPage_number()%>" 
type="text" onclick="fnPagination(7,<%=pagination.getTotal_pages()%>);"/></td>
     <td class="pagination-label" nowrap="nowrap"><s:text name="label.of"/> 
<%=pagination.getTotal_pages()%></td>
     <td>
      <% if(next){ %>
      <a href="#" onclick="fnPagination(1,<%=pagination.getTotal_pages()%>);">
       <img src="images/next.png" alt="Go to next page" border="0" width="20'" 
height="25"/>
      </a>
      <%}else{ %>
       <img src="images/next.png" alt="Go to next page" border="0" 
width="20'" height="25"/>
      <%} %>
     </td>
     <td><% if(next){ %>
      <a href="#" onclick="fnPagination(2,<%=pagination.getTotal_pages()%>);">
       <img src="images/last.png" alt="Go to next page" border="0" width="20'" 
height="25"/>
      </a>
      <%}else{ %>
       <img src="images/last.png" alt="Go to next page" border="0" 
width="20'" height="25"/>
      <%} %>
     </td>
     <td>&nbsp;</td>
     <td class="pagination-label" nowrap="nowrap"><s:text name="label.muestraPaginas"/></td>
     <td class="pagination-linkoff" style="" nowrap="nowrap">
      <s:select onchange="fnPagination(5,0);" 
list="#{'6':'6','12':'12','0':'All'}" theme="simple" 
name="page_size" id="page_sizeID" value="#session.pagination.page_size"/>
     </td>
   </tr>
  </table>
  
  <!-- </body>
</html> -->
