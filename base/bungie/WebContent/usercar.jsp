<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
