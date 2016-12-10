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
       <td><s:text name="label.busqueda"/></td>
       <td><input name="nombreProducto" size="50" id="nombreProductoID" type="text"></td>
	   <td>
		  <div id="_lupa" align="LEFT">
		  <a href="#" onclick="fnFiltra()" target="_lupa">					
		  <img src="images/lupa1.jpg" alt="Busqueda" width="39" height="22">
		  </a>
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
       <%@ include file="usercar.jsp" %>
    </td>
  </tr>
  
</table>
 
  </header>
   <aside>
  <div class="sidebar1">
    <ul class="nav">
					
	 <li class="detalleTabla">
	 <p>&nbsp;</p>
	 <s:text  name="label.mainFiltrado"/>
	 
	 </li>
	 
	 <li><p>&nbsp;</p><s:text name="label.marca"/></li>
      <li>       
        <table border="0">          
		  <s:select onchange="fnFiltra()" requiredLabel="false" id="selectMarcaID" name="selectMarca" list="marcas" listKey="nombre" listValue="descripcion"/>                     
        </table>
      </li>
      <li><p>&nbsp;</p><s:text name="label.displaysize"/></li>
      <li>
      <table border="0">         
	    <s:select onchange="fnFiltra()"  requiredLabel="false" id="selectDisplaySizeID" name="selectDisplaySize" list="displaySizes" listKey="nombre" listValue="descripcion"/>                    
      </table>
      </li>
      <li><p>&nbsp;</p><s:text name="label.capacidad"/></li>
      <li>
      <table border="0">        
			   <s:select onchange="fnFiltra()" requiredLabel="false" id="selectCapacidadID" name="selectCapacidad" list="capacidades" listKey="nombre" listValue="descripcion"/>                     
        </table>
      </li>
      <li><p>&nbsp;</p><s:text name="label.color"/></li>
      <li>
      <table border="0">          
			   <s:select onchange="fnFiltra()"  requiredLabel="false" id="selectColorID" name="selectColor" list="colores" listKey="nombre" listValue="descripcion"/>                    
        </table>
      </li>
    </ul>
   
      <p>&nbsp;</p>

  <!-- end .sidebar1 --></div>
  </aside>
  <article class="content">
    
    <section>
    <input type="hidden" name="keyProducto" id="keyProducto" value=""/>
    <table width="100%" border="0">
    <%
    Integer divisorImagen = 0; 
    List<ProductoEntity> productos = (List<ProductoEntity>)session.getAttribute("productosSession");
    ProductoEntity producto = null;
    Iterator iterator = productos.iterator();
   
    while(iterator.hasNext()){%>
        <tr>
        <% 
        if(iterator.hasNext()){
          producto = (ProductoEntity)iterator.next();
        //GENERA HTML%>       
        <td>
              <table width="100%" border="0">	    		
        		<tr>
          			<td class="detalleTablaCell">
          			<a href="#" onclick="javascript:fnDetalle('<%=producto.getId()%>');">
          			<img src="/bungie/CatalogoImagenConverter?tipo=imagen_front&id=<%=producto.getId()%>" width="250" height="250">
          			</a>
          			</td>
        		</tr>
        		<tr>
          		<td class="detalleTablaCell"><%=producto.getDescripcion()%></td>        
        		</tr>
        		<tr>
          		<td class="detalleTablaCell"><%="Precio: $"+producto.getPrecio()%></td>
        		</tr>        		       		
      		  </table>
        </td>
        <%}%>
        <% 
        if(iterator.hasNext()){
          producto = (ProductoEntity)iterator.next();
          //GENERA HTML%>
        <td>
              <table width="100%" border="0">	    		
        		<tr>
          			<td class="detalleTablaCell">
          			<a href="#" onclick="javascript:fnDetalle('<%=producto.getId()%>');">
          			<img src="/bungie/CatalogoImagenConverter?tipo=imagen_front&id=<%=producto.getId()%>" width="250" height="250">
          			</a>
          			</td>
        		</tr>
        		<tr>
          		<td class="detalleTablaCell"><%=producto.getDescripcion()%></td>        
        		</tr>
        		<tr>
          		<td class="detalleTablaCell"><%="Precio: $"+producto.getPrecio()%></td>
        		</tr>        		
      		  </table>
        </td>
        <%}%>
        <%  
        if(iterator.hasNext()){
          producto = (ProductoEntity)iterator.next();
          //GENERA HTML%>
        <td>
              <table width="100%" border="0">	    		
        		<tr>
          			<td class="detalleTablaCell">
          			<a href="#" onclick="javascript:fnDetalle('<%=producto.getId()%>');">
          			<img src="/bungie/CatalogoImagenConverter?tipo=imagen_front&id=<%=producto.getId()%>" width="250" height="250">
          			</a>
          			</td>
        		</tr>
        		<tr>
          		<td class="detalleTablaCell"><%=producto.getDescripcion()%></td>        
        		</tr>
        		<tr>
          		<td class="detalleTablaCell"><%="Precio: $"+producto.getPrecio()%></td>
        		</tr>        		
      		  </table>
        </td>
        <%}%>
        </tr>
    <%
    }  
    %>
	 </table> 
     
        <%@ include file="pagination.jsp" %>
     
	 <%-- <table width="100%" border="0">
	    <s:iterator value="productos" var=""   >
        <tr>
          <td><img src="/bungie/ImageConverter?id=<s:property value="id"/>" width="250" height="250"></td>
        </tr>
        <tr>
          <td><s:property value="descripcion"/></td>        
        </tr>
        <tr>
          <td><s:property value="precio"/></td>
        </tr>
        </s:iterator>
      </table> --%>
      
      
      
    </section>
    </article>
    
 
  <footer>    
     <%@ include file="footer.jsp" %>  
  </footer>
  <!-- end .container --></div>
  
  </form>
</body>
</html>

