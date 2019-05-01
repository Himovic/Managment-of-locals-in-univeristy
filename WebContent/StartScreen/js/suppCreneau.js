$(document).ready(function(){
	var idCreneau =0;
	var HIDDEN_DELETE_CRENEAU="GET_CRENEAU_DELETE_VALUE";
	$("tbody tr").click(function(){
		$(this).find("td:eq(0)").each(function(){
			alert($(this).html());
			idCreneau = $(this).html();
			return false;
		});
		$.confirm({
			text: 'Vous etes de vouloir supprimer ce créneau ? ',
			confirm : function(){
				$.ajax({
					url : "http://localhost:8080/GestionLocal/CreneauCtrl",
	            	method : "GET",
	            	dataType : "text",
	            	data : {
	            		idCreneau : idCreneau,
	            		HIDDEN_DELETE_CRENEAU : HIDDEN_DELETE_CRENEAU
	            	},
	            	success : function(result){
	            		if(result == "OK"){
	            			showResult("Le créneau a été supprimer avec succées");
	            			location.reload();
	            		}else{
	            			showResult("Le créneau n'a pas été supprimer!");
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
			},
			cancel : function(){
				
			}
		});
	});
});

function getError(msg){
	alert("The error is : "+msg);
}
function showResult(msg){
	alert(msg);
}