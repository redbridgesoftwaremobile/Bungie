<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.redbridge.entity.TarjetaClienteEntity"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="java.util.List"%>

<html>
<head>
<meta charset="utf-8">
<title>BUNGIE</title>
<link href="styles/tiendaVirtual.css" rel="stylesheet" type="text/css">
<!-- <link  href="styles/pagination.css" rel="stylesheet" type="text/css"> -->
<script src="scripts/datostarjeta.js" type="text/javascript"></script>
<script src="scripts/footer.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<%
TarjetaClienteEntity tarjeta = (TarjetaClienteEntity)request.getAttribute("tarjeta");
%>


</head>

<body>

<form  method="post" name="datostarjeta">
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
	     <s:text  name="tarjetaLabel.Header" />
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
	    <td colspan="2" align="left" valign="top" class="tituloTabla">
	    <s:text name="tarjetaLabel.subtitulo"/></td>
	    <td align="left" valign="top"><img src="images/seguridad1.jpg" width="127" height="56" /></td>
	  </tr>
	  <tr><td><s:fielderror/></td></tr>
	  <tr>
	    <%-- <td align="left" valign="top"><span class="subtituloTabla"><s:text name="tarjetaLabel.nombre"/></span><span class="detalleTabla"><s:text name="tarjetaLabel.nombreleyenda"/></span></td>
	    <td align="left" valign="top"><span class="subtituloTabla"><s:text name="tarjetaLabel.apellido"/></span></td>
	    <td align="left" valign="top">&nbsp;</td> --%>
	  </tr>
	  <tr>
	    <td align="left" valign="top"><!-- <label for="id_nombreTarjeta"></label> -->
	      <table>
           <s:textfield key="tarjetaBean.nombre" labelposition="top" maxLength="20" size="30" cssClass="detalleTabla"  errorPosition="Top" />
          </table>
	       
	      <!-- <input name="tarjeta_nombre" type="text" class="detalleTabla" id="tarjeta_nombre" size="30" /> --></td>
	    <td align="left" valign="top">
	      <table>
           <s:textfield key="tarjetaBean.apellidoPaterno" labelposition="top" maxLength="20" size="30" cssClass="detalleTabla"  errorPosition="Top" />
          </table>
	      <!-- <input name="tarjeta.apellidoPaterno" type="text" class="detalleTabla" id="tarjetaApellidoPaternoID" size="50" /> --></td>
	    <td align="left" valign="top">&nbsp;</td>
	  </tr>
	  <tr>
	    <%-- <td align="left" valign="top" class="subtituloTabla"><s:text name="tarjetaLabel.numeroTarjeta"/></td>
	    <td align="left" valign="top" class="subtituloTabla"><s:text name="tarjetaLabel.tipoTarjeta"/></td> --%>
	  </tr>
	  <tr>
	   <td>
	      <table width="100%" border="0">
	        <tr>
	          <td><!-- <input name="tarjeta.numeroTarjeta" type="text" class="detalleTabla" id="numeroTarjetaID" size="30" /> -->
	              <table>
                   <s:textfield key="tarjetaBean.numeroTarjeta" labelposition="top" maxLength="20" size="30" cssClass="detalleTabla"  errorPosition="Top" />
                  </table>
	          </td>
	          <td><img src="images/candadito.jpg" width="25" height="25" /></td>
	        </tr>
	    </table></td>
	    <td>
	    <table width="38%" border="0">
	        <tr>
	          <td>
	          <table>
	          <s:radio name="tarjeta.tipoTarjeta" onclick="javascript:validaVisa();" list="visa"><img src="images/visa.jpg" width="35" height="25"></s:radio>
	          </table>
	          
	          <!-- <input name="tarjeta.tipoTarjeta" value="visa" type="radio" checked="checked"><img src="images/visa.jpg" width="35" height="25"> -->
	          </td>
	          <td>
	          <table>
	          <s:radio name="tarjeta.tipoTarjeta" onclick="javascript:validaMasterCard();" list="mastercard"><img src="images/masterCard.jpg" width="35" height="25"></s:radio>
	          </table>
	          
	          <!-- <input name="tarjeta.tipoTarjeta" value="mastercard" type="radio"><img src="images/masterCard.jpg" width="35" height="25"> -->
	          </td>
	        </tr>
	    </table>
	    </td>
	    <td align="left" valign="top">&nbsp;</td>
	  </tr>
	  <tr>
	   <%--  <td align="left" valign="top" class="subtituloTabla"><s:text name="tarjetaLabel.fechaVencimiento"/></td>
	    <td align="left" valign="top" class="subtituloTabla"><s:text name="tarjetaLabel.codigoSeguridad"/></td>
	    <td align="left" valign="top">&nbsp;</td> --%>
	  </tr>
	  <tr>
	    <td width="30%" align="left" valign="top">
	      <table>
	      <s:select key="tarjetaBean.monthVencimiento" list="meses" listKey="mesAbbr" listValue="mesName"/>
	      </table>
	      
	      <table>
	      <s:select key="tarjetaBean.yearVencimiento" list="years" listKey="yearAbbr" listValue="yearName"/>
	      </table>
	      <%-- <select name="tarjeta.monthVencimiento" class="detalleTabla" id="monthVencimientoTarjetaID">
	        <option value="ENE" selected="selected">ENE(1)</option>
	        <option value="FEB">FEB(2)</option>
	        <option value="MAR">MAR(3)</option>
	        <option value="ABR">ABR(4)</option>
	        <option value="MAY">MAY(5)</option>
	        <option value="JUN">JUN(6)</option>
	        <option value="JUL">JUL(7)</option>
	        <option value="AGO">AGO(8)</option>
	        <option value="SEP">SEP(9)</option>
	        <option value="OCT">OCT(10)</option>
	        <option value="NOV">NOV(11)</option>
	        <option value="DEC">DEC(12)</option>
	      </select> --%>
	      
	      
	      
	      <%-- <select name="tarjeta.yearVencimiento" class="detalleTabla" id="yearVencimientoTarjetaID">
	        <option value="2015" selected="selected">2015</option>
	        <option value="2016">2016</option>
	        <option value="2017">2017</option>
	        <option value="2018">2018</option>
	        <option value="2019">2019</option>
	        <option value="2020">2020</option>
	        <option value="2021">2021</option>
	        <option value="2022">2022</option>
	        <option value="2023">2023</option>
	        <option value="2024">2024</option>
	        <option value="2025">2025</option>
	      </select> --%>
	      
	      
	      </td>
	    <td width="80%" align="left" valign="top">
	    <table width="50%" border="0">
	      <tr>
	          <td>	          
	          <table>
              <s:password key="tarjetaBean.codigoSeguridad" labelposition="top" maxLength="3" size="10" cssClass="detalleTabla"  errorPosition="Top" />
              </table>	          
	          <!-- <input name="tarjeta.codigoSeguridad" type="password" class="detalleTabla" id="codigoSeguridadTarjetaID" size="5" maxlength="3" /> -->
	          </td>
	          <td>
	          <img src="images/candadito.jpg" width="26" height="25" />
	          </td>
	        </tr>
	    </table>
	  </td>
	    <td width="30%" align="left" valign="top">&nbsp;</td>
	  </tr>
	 </table>
 </section>
 <section>
 <table width="100%" border="0">
  <tr>
  <td width="10%">&nbsp;</td>
  </tr>  
  <tr>
    <td colspan="3" align="left" valign="top" class="tituloTabla"><s:text name="domicilioLabel.subtitulo"/></td>  
  </tr>
  <tr>
  <td width="10%">&nbsp;</td>
  </tr>
  
  <%-- <tr>
    <td  style="text-align: left ; vertical-align: top;width: 50%">
	   <table style="width: 100%">
	   <tr>
	    <td style="text-align: left ; vertical-align: top;width: 53%" class="subtituloTabla"><s:text name="domicilioLabel.calle"/></td>
	    <td style="text-align: left ; vertical-align: top;width: 23%" class="subtituloTabla"><s:text name="domicilioLabel.numeroExt"/></td>
	    <td style="text-align: left ; vertical-align: top;width: 25%" class="subtituloTabla"><s:text name="domicilioLabel.numeroInt"/></td>
	   </tr>  
	   </table>
    </td >
    <td style="text-align: left ; vertical-align: top;width: 25%" class="subtituloTabla"><s:text name="domicilioLabel.colonia"/></td>
    <td style="text-align: left ; vertical-align: top;width: 25%"></td>      
  </tr> --%>
  
  <tr>
    <td style="text-align: left ; vertical-align: top;width: 50%">
    <table style="width: 100%">
	   <tr>
	     <td style="text-align: left ; vertical-align: top;width: 80%">
	     <table>
           <s:textfield key="domicilioBean.calle" labelposition="top" maxLength="20" size="30" cssClass="detalleTabla"  errorPosition="Top" />
          </table>
	      <!-- <input name="domicilio.calle" type="text" class="detalleTabla" id="calleID" size="25" /> -->
	      </td>	      
	    <td style="text-align: left ; vertical-align: top;width: 10%">
	      <table>
           <s:textfield key="domicilioBean.numeroExt" labelposition="top" maxLength="10" size="10" cssClass="detalleTabla"  errorPosition="Top" />
          </table>
	      <!-- <input name="domicilio.numeroExt" type="text" class="detalleTabla" id="numeroExtID" size="10" /> -->
	      </td>
	    <td style="text-align: left ; vertical-align: top;width: 10%">
	      <table>
           <s:textfield key="domicilioBean.numeroInt" labelposition="top" maxLength="10" size="10" cssClass="detalleTabla"  errorPosition="Top" />
          </table>
	      <!-- <input name="domicilio.numeroInt" type="text" class="detalleTabla" id="numeroIntID" size="10" /> -->
	      </td>
	   </tr>  
     </table> 
     </td>
     <td style="text-align: left ; vertical-align: top;width: 25%">
     <table>
           <s:textfield key="domicilioBean.colonia" labelposition="top" maxLength="20" size="25" cssClass="detalleTabla"  errorPosition="Top" />
     </table>
     <!-- <input name="domicilio.colonia" type="text" class="detalleTabla" id="coloniaID" size="25" /> -->
     </td>      
     <td style="text-align: left ; vertical-align: top;width: 25%"></td> 
  </tr>
 <%--  <tr> 
      <td style="text-align: left ; vertical-align: top;width: 50%;">
	      <table style="width: 100%">
			   <tr>
			     <td style="text-align: left ; vertical-align: top;width: 55%" class="subtituloTabla"><s:text name="domicilioLabel.delegacion"/></td>        
	             <td style="text-align: left ; vertical-align: top;width: 25%" class="subtituloTabla"><s:text name="domicilioLabel.ciudad"/></td>
	             <td style="text-align: left ; vertical-align: top;width: 20%" class="subtituloTabla">&nbsp;</td>
			   </tr>
		   </table>	     
      </td>
      <td style="text-align: left ; vertical-align: top;width: 25%;"/>
      <td style="text-align: left ; vertical-align: top;width: 25%;"/>    
  </tr> --%>
  
  <tr>
     <td style="text-align: left ; vertical-align: top;width: 50%;">
      <table style="width: 100%">
	   <tr>
	     <td style="text-align: left ; vertical-align: top;width: 25%;">
	     <table>
           <s:textfield key="domicilioBean.delegacion" labelposition="top" maxLength="20" size="25" cssClass="detalleTabla"  errorPosition="Top" />
          </table>
	     <!-- <input name="domicilio.delegacion" type="text" class="detalleTabla" id="delegacionID" size="25" /> -->
	     </td>	     
	     <td style="text-align: left ; vertical-align: top;width: 25%;">
	     <table>
           <s:textfield key="domicilioBean.ciudad" labelposition="top" maxLength="20" size="20" cssClass="detalleTabla"  errorPosition="Top" />
          </table>
	     <!-- <input name="domicilio.ciudad"     type="text" class="detalleTabla" id="ciudadID" size="20" /> -->
	     </td>
	                
	   </tr>
	   </table>	     
      </td>
      <td style="text-align: left ; vertical-align: top;width: 25%;"/> 
      <td style="text-align: left ; vertical-align: top;width: 25%;"/>   
  </tr>
  
   <tr>
     <td style="text-align: left ; vertical-align: top;width: 50%;">
      <table style="width: 100%">
	   <tr>
	     <td style="text-align: left ; vertical-align: top;width: 25%;">
	     <table>
           <s:textfield key="domicilioBean.estado" labelposition="top" maxLength="20" size="25" cssClass="detalleTabla"  errorPosition="Top" />
          </table>
	     <!-- <input name="domicilio.delegacion" type="text" class="detalleTabla" id="delegacionID" size="25" /> -->
	     </td>	     
	     <td style="text-align: left ; vertical-align: top;width: 25%;">
	     <table>
           <s:textfield key="domicilioBean.codigoPostal" labelposition="top" maxLength="8" size="8" cssClass="detalleTabla"  errorPosition="Top" />
          </table>
	     <!-- <input name="domicilio.ciudad"     type="text" class="detalleTabla" id="ciudadID" size="20" /> -->
	     </td>
	                
	   </tr>
	   </table>	     
      </td>
      <td style="text-align: left ; vertical-align: top;width: 25%;"/> 
      <td style="text-align: left ; vertical-align: top;width: 25%;"/>   
  </tr>
  
  <%-- <tr>  
    <td style="text-align: left ; vertical-align: top;width: 50%;">
      <table style="width: 100%">
	   <tr>
	     <td style="text-align: left ; vertical-align: top;">
	     <!-- <input name="domicilio.estado" type="text" class="detalleTabla" id="estadoID" size="20" /> -->
	     <table>
           <s:textfield key="domicilioBean.estado" labelposition="top" maxLength="20" size="20" cssClass="detalleTabla"  errorPosition="Top" />
          </table>
	     </td>
         <td/>
         <td style="text-align: left ; vertical-align: top;width: 25%;">
          <table>
           <s:textfield key="domicilioBean.codigoPostal" labelposition="top" maxLength="8" size="8" cssClass="detalleTabla"  errorPosition="Top" />
          </table>
     <!-- <input name="domicilio.codigoPostal" type="text" class="detalleTabla" id="codigopostalID" size="8" /> -->
         </td>      
	   </tr>
	   </table>	     
     </td>
    
     <td style="text-align: left ; vertical-align: top;width: 25%;"/>      
  </tr> --%>
  
  
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

