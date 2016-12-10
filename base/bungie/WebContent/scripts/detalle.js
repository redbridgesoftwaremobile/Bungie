function fnCompra(id){
	 //alert("cellularDetalle producto id...."+id);			
	 var oPage_number = document.getElementById("keyProducto");	 
	 oPage_number.value = id;
	 document.cellularDetalle.action="add2carrito.action"
	 document.cellularDetalle.submit();
}