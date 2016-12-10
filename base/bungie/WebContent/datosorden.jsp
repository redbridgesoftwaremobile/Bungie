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
<script src="scripts/datosorden.js" type="text/javascript"></script>
<script src="scripts/footer.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<%
ProductoEntity producto = (ProductoEntity)session.getAttribute("producto");
%>



</head>

<body>

<form  method="post" name="datosorden">
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
	     <s:text  name="ordenLabel.subtitulo" />
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
    <table width="100%" border="0">
      <tr>
        <td  style="text-align: left;">&nbsp;</td>
        <td  style="text-align: left;">&nbsp;</td>
      </tr>
      <tr>
        <td style="text-align: left;" class="detalleTablaTitle"><s:text name="ordenLabel.direccion"/></td>
        <td style="text-align: left;" class="detalleTablaTitle"><s:text name="ordenLabel.informacionpago"/></td>
        </tr>
      <tr> 
        <td>
        <table width="100%" border="0">
			<tr>
			<td style="text-align: left;" class="detalleTabla">
			<s:text name="ordenLabel.calle"/><s:property  value="domicilioBean.calle"/>
			<s:text name="ordenLabel.numExt"/><s:property value="domicilioBean.numeroExt"/>
			<s:text name="ordenLabel.numInt"/><s:property value="domicilioBean.numeroInt"/>			
			</td>
			<td></td>
			</tr>
		 </table> 
        </td>
        
        <td align="left" valign="top"><label for="id_apellidoTarjeta2"></label>
          <table width="100%" border="0">
            <tr>                       
              <td width="90%" class="detalleTabla"><s:text name="ordenLabel.tarjeta"/><img src="<s:property value="tipoTarjeta"/>" width="36" height="29" />
              <s:text name="ordenLabel.conterminacion"/><s:property value="terminacionTarjeta"/></td>
              <td width="10%"></td>               
              </tr>
          </table>
          </td>
        </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td style="width:50%; ">
         <table width="100%" border="0">
			<tr>
			<td style="text-align: left;" class="detalleTabla"><s:text name="ordenLabel.colonia"/>
			<s:property value="domicilioBean.colonia"/></td>
			<td style="text-align: left;" class="detalleTabla"></td>
			</tr>
		 </table>      
        </td>        
        <td style="width:50%;">
        <table width="100%" border="0">
          <tr>
            <td style="text-align: left;" class="detalleTabla"><s:text name="ordenLabel.numeroArticulos"/>
            <s:property value="numeroArticulos"/></td>
			<td style="text-align: left;" class="detalleTabla"></td>              
          </tr>
        </table>
        </td>
        </tr>
        <tr>
        <td>
        <table width="100%" border="0">
			<tr>
			<td style="text-align: left;" class="detalleTabla"><s:text name="ordenLabel.delegacion"/>
			<s:property value="domicilioBean.delegacion"/></td>
			<td style="text-align: left;" class="detalleTabla"></td>
			</tr>
		 </table>    
        </td>
        <td>
        <table width="100%" border="0">
			<tr>
				<td style="text-align: left;" class="detalleTabla">&nbsp;</td>
				<td style="text-align: left;" class="detalleTabla">&nbsp;</td>
			</tr>
		</table>
        </td>
        </tr>
      <tr>
        <td>
         <table width="100%" border="0">
			<tr>
			<td style="text-align: left;" class="detalleTabla"><s:text name="ordenLabel.ciudad"/>
			<s:property value="domicilioBean.ciudad"/></td>
			<td style="text-align: left;" class="detalleTabla"></td>
			</tr>
		 </table>
          
           
        </td>
        <td>
        <table width="100%" border="0">
		<tr>
		<td style="text-align: left;width: 40%;" class="detalleTabla"><s:text name="ordenLabel.costoEnvio"/></td>
		<td style="text-align: right;width: 20%;" class="detalleTabla"><s:text name="ordenLabel.simboloMoneda"/><td>
		<td style="text-align: right;width: 20%;" class="detalleTabla"><s:property value="costoEnvio"/></td>
		<td style="width: 20%"><td>
		</tr>
		</table>
        </td>
        </tr>
      <tr>
         <td>
          <table width="100%" border="0">
			<tr>
			<td style="text-align: left;" class="detalleTabla"><s:text name="ordenLabel.estado"/>
			<s:property value="domicilioBean.estado"/></td>
			<td style="text-align: left;" class="detalleTabla"></td>
			</tr>
		  </table>          
         </td>
        <td>
        <table width="100%" border="0">
		<tr>
		<td style="text-align: left;width: 40%;" class="detalleTabla"><s:text name="ordenLabel.costoArticulo"/></td>
		<td style="text-align: right;width: 20%;" class="detalleTabla"><s:text name="ordenLabel.simboloMoneda"/><td>
		<td style="text-align: right;width: 20%;" class="detalleTabla"><s:property value="costoArticulos" /></td>
		<td style="width: 20%"><td>
		</tr>
		</table>       
        </td>
        </tr>
      <tr>
        <td>
         <table width="100%" border="0">
			<tr>
			<td style="text-align: left;" class="detalleTabla"><s:text name="orderLabel.cp"/>
			<s:property value="domicilioBean.codigoPostal"/></td>
			<td style="text-align: left;" class="detalleTabla"></td>
			</tr>
		 </table>          
         </td>
        <td>
        <table width="100%" border="0">
		<tr>
		<td style="text-align: left;width: 40%;" class="detalleTabla"><s:text name="ordenLabel.TotalPlusIva"/></td>
		<td style="text-align: right;width: 20%;" class="detalleTabla"><s:text name="ordenLabel.simboloMoneda"/><td>
		<td style="text-align: right;width: 20%;" class="detalleTabla"><s:property value="costoTotalplusIva"/></td>
		<td style="width: 20%"><td>
		</tr>
		</table>        
        </td>
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

