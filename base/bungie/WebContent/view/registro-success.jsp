<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



  
       <table style="text-align: left; width: 100%">
       <tr>
       <td style="width: 30%"/>
       <td style="width: 70%">
       <s:textfield name="nombre" label="Nombre"></s:textfield>
       </td>
       </tr>
       <tr>
       <td style="width: 30%"/>
       <td style="width: 70%">
       <s:password name="password" label="Password"></s:password>
       </td>
       </tr>
       <tr>
       <td style="width: 30%"/>
       <td style="width: 70%">
       <s:textfield name="email" label="Email"></s:textfield>
       </td>
       </tr>
       <tr>
       <td style="width: 30%"/>
       <td style="width: 70%">
       <s:radio list="{'male','female'}" name="sexo"></s:radio>
       </td>
       </tr>
       <tr>
       <td style="width: 30%"/>
       <td style="width: 70%">
       <s:submit value="register"></s:submit>
       </td>
       </tr>
       </table>
   