function fnRegresar(){
	 document.datostarjeta.action="index.action"
	 document.datostarjeta.submit();
}
function fnSiguiente(){		 
	 document.datostarjeta.action="preparaorden.action"
	 document.datostarjeta.submit();
}

function validaVisa(){
	var visa = document.getElementById("tarjetaBean_numeroTarjeta");
	numero = visa.value;
    if (!numero.match(/^4\d{3}-?\d{4}-?\d{4}-?\d{4}$/)){
    	visa_error = "EL NUMERO DE SU TARJETA VISA ESTA INCORRECTO.";
        alert(visa_error);
        visa.focus();
    }     
}

function validaMasterCard(){
	var mastercard = document.getElementById("tarjetaBean_numeroTarjeta");
	numero = mastercard.value;
	if (!numero.match(/^5[1-5]\d{2}-?\d{4}-?\d{4}-?\d{4}$/)){
		mastercard_error = "EL NUMERO DE SU TARJETA MASTERCARD ESTA INCORRECTO.";
		alert(mastercard_error);
		mastercard.focus();
	}	
}