<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.redbridge.entity.ProductoEntity"%>
<%@ page import="com.redbridge.dto.ShoppingCartSession"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>

<html>
<head>
<meta charset="utf-8">
<title>BUNGIE</title>
<link href="styles/tiendaVirtual.css" rel="stylesheet" type="text/css">
<!-- <link  href="styles/pagination.css" rel="stylesheet" type="text/css"> -->
<script src="scripts/footer.js" type="text/javascript"></script>
<script src="scripts/detallecompra.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>

<body>

<form  method="post" name="detallecompra">
<div class="container">
  <header>
    
    <table width="100%">
    <tr>
    <td width="20%">
    <%@ include file="logotipoBungie.jsp" %>    
    </td>
    
    
    <td width="40%">
       <table>
	     <tr>
	     <td  class="tituloAnuncioTienda">
	     <s:text  name="label.tiendavirtual" />
	     </td>     
	     </tr>
	     <tr>
	     <td  class="tituloAnuncioTienda">
	     <s:text  name="detalleCompra.Header" />
	     </td> 
	     </tr>
	    </table>     
	</td>
    
    
    <td>
    
    </td> 
    
    <td width="30%">
       <%@ include file="usercar.jsp" %>
    </td>
  </tr>
  
</table>
 
  </header>
  <aside>
    
  </aside>
  <article class="content">
   <section>
   <%
   ShoppingCartSession shoppingcart = (ShoppingCartSession)session.getAttribute("shoppingCartSession");
   List<ProductoEntity>  listaProducto = shoppingcart.getProductos();
   %>
   <input type="hidden" name="index" id="index" value=""/>
   <table width="100%" border="0">
  <tr class="tituloTabla">
    <td width="20%" style = "text-align: center;" class="tituloTabla"><s:text name="detallecompra.producto"></s:text></td>
    <td width="20%" style = "text-align: left;"   class="tituloTabla"><s:text name="detallecompra.descripcion"></s:text></td>
    <td width="20%" style = "text-align: center;" class="tituloTabla"><s:text name="detallecompra.precio"></s:text></td> 
    <td width="40%" style = "text-align: center;" class="tituloTabla"></td>
  </tr>
  <%
  int indice = 0;
  for(ProductoEntity producto:listaProducto) {%>
  
   <tr class="detalleTabla">
    <td width="20%" style = "text-align: center;"><img src="/bungie/CatalogoImagenConverter?tipo=icono_front&id=<%=producto.getId()%>" width="26" height="43"/></td>
    <td width="20%" align="left" valign="top">
    <table  border="0">
      <tr>
        <td class="detalleTabla"><%=producto.getDescripcion()%></td>
      </tr>
      <tr>
        <td><s:text name="detallecompra.capacidad"/><%=producto.getCapacidad()%></td>
      </tr>
      <tr>
        <td><s:text name="detallecompra.color"/><%=producto.getColor()%></td>
      </tr>
    </table></td>
    <td width="20%" style = "text-align: right;vertical-align:middle;" class="detalleTabla">
      $<%=producto.getPrecio()%>
    </td>
    <td width="40%" style = "text-align: left;vertical-align:middle;">    
      <a href="javascript:fnEliminar('<%=indice%>');"onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('botebasura<%=indice%>','','images/botebasura2.png',1);">
	         <img name="botebasura<%=indice%>" src="images/botebasura1.png" border="0">
      </a>
      
    </td>
  </tr>
  <%++indice;} %>
  
  <tr class="detalleTabla">  
    <td width="20%">&nbsp;</td>
    <td width="20%" style = "text-align: right;" class="detalleTabla"><s:text name="detallecompra.subtotal"/></td>
    <td width="20%" style = "text-align: right;" class="detalleTabla">$<%=shoppingcart.getSubtotal()%></td>
    <td width="40%"></td>
  </tr>
  </table>
  </section> 
  <section>
   <nav>
    <%@ include file="navegacion.jsp" %>
	</nav>
   </section>    
  </article>
    
 
  <footer>
    <%@ include file="footer.jsp" %> 
  </footer>
  <!-- end .container --></div>
  
  </form>
</body>
</html>

