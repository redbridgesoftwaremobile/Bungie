<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.redbridge.entity.ProductoEntity"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="java.util.List"%>

<html>
<head>
<meta charset="utf-8">
<title>BUNGIE</title>
<link href="styles/tiendaVirtual.css" rel="stylesheet" type="text/css">
<!-- <link  href="styles/pagination.css" rel="stylesheet" type="text/css"> -->
<%-- <script src="scripts/pagination.js" type="text/javascript"></script> --%>
<script src="scripts/footer.js" type="text/javascript"></script>
<script src="scripts/detalle.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<%
ProductoEntity producto = (ProductoEntity)session.getAttribute("producto");
%>
<script>
$(document).ready(function(){

    $("#imagenfront").mouseover(function(){	
	    //alert($("#imagenDestino").attr("src"));
		$("#imagenDestino").attr("src","/bungie/CatalogoImagenConverter?tipo=imagen_front&id=<%=producto.getId()%>");  
    });
	
	$("#imagenback").mouseover(function(){	
	    //alert($("#imagenDestino").attr("src"));
		$("#imagenDestino").attr("src","/bungie/CatalogoImagenConverter?tipo=imagen_back&id=<%=producto.getId()%>");  
    });
	
	$("#imagenright").mouseover(function(){	
	    //alert($("#imagenDestino").attr("src"));
		$("#imagenDestino").attr("src","/bungie/CatalogoImagenConverter?tipo=imagen_right&id=<%=producto.getId()%>");  
    });
	
	$("#imagenleft").mouseover(function(){	
	    //alert($("#imagenDestino").attr("src"));
		$("#imagenDestino").attr("src","/bungie/CatalogoImagenConverter?tipo=imagen_left&id=<%=producto.getId()%>");  
    });
});
</script>

</head>

<body>

<form  method="post" name="cellularDetalle">
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
	     <s:text  name="detalle.Header" />
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
    <input type="hidden" name="keyProducto" id="keyProducto" value=""/>
    <table width="100%" border="0">
    <tr>
     <td valign="top">
         <table width="100%" border="0">  
         <tr>   
     		<td width="5%" align="left" valign="center">
	     		<table>
		     		<tr>		     		
				    <td align="center">
						<a href="#" id="imagenfront">
						  <img src="/bungie/CatalogoImagenConverter?tipo=icono_front&id=<%=producto.getId()%>" width="26" height="43"/>		  
						</a>
					</td>
				    </tr>
				    <tr>
				    <td align="center">
					    <a href="#" id="imagenback">
					       <img src="/bungie/CatalogoImagenConverter?tipo=icono_back&id=<%=producto.getId()%>" width="26" height="43"/>
						</a>
					</td>
				    </tr>
				    <tr>
				    <td align="center">
					    <a href="#" id="imagenright">
					       <img src="/bungie/CatalogoImagenConverter?tipo=icono_right&id=<%=producto.getId()%>" width="26" height="43"/>
						 </a>
					</td>		
				    </tr>
				    <tr>
				    <td align="center">
					    <a href="#" id="imagenleft">
					       <img src="/bungie/CatalogoImagenConverter?tipo=icono_left&id=<%=producto.getId()%>" width="26" height="43"/>
						</a>
					</td>
				    </tr>   		
	     		</table>    		
     		</td>
     		<td  with="20%" align="left" >
     		        
		     	<img src="/bungie/CatalogoImagenConverter?tipo=imagen_front&id=<%=producto.getId()%>" width="450" height="500" id="imagenDestino"/>
		            
		    </td>
            <td width="75%" align="left" valign="top">
			 <table width="100%" border="0">
              <tr>
                <td><span class="tituloTabla"><%=producto.getDescripcion()%></span></td>
              </tr>
              <tr>
                <p>&nbsp;</p><p>&nbsp;</p>
              </tr>
              <tr>
                <td><span class="detalleTabla"><s:text name="detalle.precio"/><%=producto.getPrecio()%></span></td>
              </tr>
              <tr>
                <td><span class="detalleTabla"><s:text name="detalle.color"/><%=producto.getColor()%></span></td>
              </tr> 
              <tr>
                <td><span class="detalleTabla"><s:text name="detalle.memoria"/><%=producto.getCapacidad()%></span></td>
              </tr>
              <tr>
                <td><p>&nbsp;</p></td>
                
              </tr>
              <tr>
                <td><ul>
                  <li class="subtituloTabla"><s:text name="detalle.notatecnica"/></li>
                  <p>&nbsp;</p>                 
                  <% 
                  String sb = (producto.getNotaTecnica()!=null)?producto.getNotaTecnica():"";                  
                  StringTokenizer st = new StringTokenizer(sb.toString(),",");
                  while (st.hasMoreTokens()){%>                  
                  <li class="detalleTabla"><%=st.nextToken()%></li>
                  <%}%>
                </ul>
                </td>
              </tr>
              <tr>
					<td>
					  <table width="81%" border="0">
					  <tr>
						<td width="39%" class="tituloBody"><s:text name="detalle.agregar"/></td>
						<td width="61%">
                        <a href="javascript:fnCompra('<%=producto.getId()%>');" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('carrito','','images/carrito2.png',1);">
		                   <img name="carrito" src="images/carrito1.png" border="0">
                        </td>
					  </tr>
					  </table>
					</td>
				  </tr> 
             </table>
            </td>
    
			
		</tr>
		</table>
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

