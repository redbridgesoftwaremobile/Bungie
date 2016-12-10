


function fnDetalle(id){
	 //alert("producto id...."+id);			
	 var oPage_number = document.getElementById("keyProducto");	 
	 oPage_number.value = id;
	 document.paginationForm.action="detalle.action"
	 document.paginationForm.submit();
}




