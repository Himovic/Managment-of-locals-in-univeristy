$(document).ready(function(){
	var localName ="";
	var hiddenFirstModif="GET_LOCAL_MODIF_VALUE";
	$("tbody tr").click(function(){
		$(this).find("td:eq(0)").each(function(){
			alert($(this).html());
			localName = $(this).html();
			return false;
		});
		$.ajax({
			url : "http://localhost:8080/GestionLocal/LocalCtrl",
        	method : "GET",
        	dataType : "json",
        	data : {
        		localName : localName,
        		hiddenFirstModif : hiddenFirstModif
        	},
        	success : function(jsonResponse){
        		if(jsonResponse != null){
        			$("#name").val(jsonResponse.nom);
        			$("#nbrtable").val(jsonResponse.nbrtable);
        			$("#niveau").val(jsonResponse.priorite);
        			$("#etage").val(jsonResponse.etage);
        			$("#numero").val(jsonResponse.numero);
        			$("#equipement").val(jsonResponse.equipement);
        			$("#detailLocal").show();
        		}
    	},
    	error : function(jqXHR, exception){
    		var msg = '';
            if (jqXHR.status == 0) {
                msg = 'Not connect.\n Verify Network.';
            } else if (jqXHR.status == 404) {
                msg = 'Requested page not found. [404]';
            } else if (jqXHR.status == 500) {
                msg = 'Internal Server Error [500].';
            } else if (exception === 'parsererror') {
                msg = 'Requested JSON parse failed.';
            } else if (exception === 'timeout') {
                msg = 'Time out error.';
            } else if (exception === 'abort') {
                msg = 'Ajax request aborted.';
            } else {
                msg = 'Uncaught Error.\n' + jqXHR.responseText;
            }
            getError(msg);
    	}
		});
		return false;
});
	$("#detailLocal").hide();
});
function getError(msg){
	alert("The error is : "+msg);
}
