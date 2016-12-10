function fnRegresar(){
	 document.detallecompra.action="index.action"
	 document.detallecompra.submit();
}
function fnSiguiente(){
	 document.detallecompra.action="datostarjeta.action"
	 document.detallecompra.submit();
}
function fnEliminar(id){
	 //alert("producto id...."+id);			
	 var oPage_number = document.getElementById("index");	 
	 oPage_number.value = id;
	 document.detallecompra.action="delete2carrito.action"
	 document.detallecompra.submit();
}