<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.redbridge.entity.ProductoEntity"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%!
 
%>
<html>
<head>
<meta charset="utf-8">
<title>BUNGIE</title>
<link href="styles/tiendaVirtual.css" rel="stylesheet" type="text/css">
<link  href="styles/pagination.css" rel="stylesheet" type="text/css">
<script src="scripts/pagination.js" type="text/javascript"></script>
<script src="scripts/footer.js" type="text/javascript"></script>
<script src="scripts/index.js" type="text/javascript"></script>
</head>

<body>
<!-- <form action="index.action" method="post" name="paginationForm"> -->
<form  method="post" name="paginationForm">
<div class="container">
  <header>
    
    <table width="100%" border="0">
  <tr>
    <td width="20%">
    <%@ include file="logotipoBungie.jsp" %>    
    </td>
    
    
    <td width="40%">
    
     <table>
     <tr>
     <td colspan="3" class="tituloAnuncioTienda">
     <s:text  name="label.tiendavirtual" />
     </td>     
     </tr>
     
     
     <tr>
       <td></td>
       <td></td>
	   <td>
		  <div id="_lupa" align="LEFT">
		  
		  </div>
	   </td>
     </tr> 
     
    <%--  <tr>
     <td>
     <!-- <div align="center"> -->
     <s:textfield     key="label.busqueda" size="50" name="nombreProducto" id="nombreProductoID"/>   
     <!--  </div> -->
     </td>
     <td>
     <div align="left" id="_lupa">
     <a href="#" onclick="fnFiltra()" target="_lupa">					
      <img src="images/lupa1.jpg" width="39" height="22" alt="Busqueda" >
      </a>
     </div>
	 </td>
     </tr> --%>
     </table>
	</td>
    
    <!-- <td width="10%">  
    <table>
    
    </td>
    <td><p>&nbsp;</p>
    </td> -->
    <td>
    <!-- <div align="center" >
     <a href="#" onclick="fnFiltra()">					
      <img src="images/lupa1.jpg" width="39" height="22" alt="Busqueda">
      </a>
      </div> -->
    </td> 
    
    <td width="30%">
       
    </td>
  </tr>
  
</table>
 
  </header>
   <aside>
  
  </aside>
  <article>
  <section>
  <table>
  <tr>
  <td class="detalleTabla">GRACIAS POR SU COMPRA</td>
  </tr>
  <tr>
  <td class="detalleTabla">SU NUMERO DE TICKET PARA CUALQUIER ACLARACION: #343434-544555</td>
  </tr>
  <tr>
  <td class="detalleTabla">EL TIEMPO EN QUE SU PAQUETE ESTARA LLEGANDO A DOMICILIO: 3DIAS</td>
  </tr>
  <tr>
  <td class="detalleTabla">TELEFONOS: 5567676767 y 5578787878</td>
  </tr>
  </table>
  </section>
  </article>
  <footer>    
     <%@ include file="footer.jsp" %>  
  </footer>
  <!-- end .container --></div>
  
  </form>
</body>
</html>

