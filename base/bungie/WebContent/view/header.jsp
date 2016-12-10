<%@ taglib prefix="s" uri="/struts-tags"%> 

 <header>  
    <table width="100%">
    <tr>
    <td width="20%">
    <a href="#">
     <img src="images/logo.jpg"  width="180" height="90" style="background-color: #C6D580; display:block;" />
    </a>    
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
       <table>
        
        <tr>
        <td>
            <table>
             <tr><td class="detalleTablaHeader">
				 <s:text name="label.mainWelcome"/>
	    		 
	    	     </td>
	    	</tr>
             <tr><td class="detalleTablaHeader">
		    	<c:if  test="${!empty userSession}">
		         ${userSession.nombre} ${userSession.apellidoPaterno}     
				</c:if>
				
				</td>
			</tr>            
            </table>
										
    	</td>
        <td>
        <table>
         <tr>
           <td class="detalleTablaHeader"><div align="center">
        ${shoppingCartSession.cantidad}       
        </div></td>
         </tr>
         <tr>
           <td>
           <div align="center">          
            <img src="images/carrito1.jpg" width="30" height="33" alt="Carrito de Comp"/>
           </div>
           </td>
         </tr>
        </table>
        
        
        </td>
        </tr>
     </table>
    </td>
  </tr>  
  </table>
</header>