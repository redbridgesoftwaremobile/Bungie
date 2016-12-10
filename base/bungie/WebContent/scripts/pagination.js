function fnPagination(type,param){
	
 //alert("PAGINANDO....");	
	
 var oPage_number = document.getElementById("page_numberID");
 var page_number = parseInt(oPage_number.value);
 switch (type)
 {
 case 1://Next
  oPage_number.value = (page_number+1);
  break;
 case 2://Last
  oPage_number.value = param;
  break;
 case 3://Previous
  oPage_number.value = (page_number-1);
  break;
 case 4://First
  oPage_number.value = 1;
  break;
 case 5://Page size change
  oPage_number.value = 1;
  break;
 
 }
 document.paginationForm.action="index.action";
 document.paginationForm.submit();
}


function fnFiltra(){
	
	 //alert("FILTRANDO....");			
	 var oPage_number = document.getElementById("page_numberID");
	 
	 oPage_number.value = 1;
	 document.paginationForm.action="filtra.action"
	 document.paginationForm.submit();
}




