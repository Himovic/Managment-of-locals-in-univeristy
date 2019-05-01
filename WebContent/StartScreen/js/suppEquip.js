/**
 * 
 */

$(document).ready(function(){
	
	var testCode = null;
	$("tbody").click(function(){
		var hiddensupprime = "hiddenSupprime";
		$(this).find("td:eq(0)").each(function(){
			testCode = $(this).html();
			//return false;
			$.confirm({
			    text: 'Vous etes sur de vouloir supprimer cet équipement ?',
			    	confirm : function(){
			    		$.ajax({
			    			url : "http://localhost:8080/GestionLocal/EquipCtrl",
			            	method : "POST",
			            	dataType : "text",
			            	data : {
			            		testCode : testCode,
			            		hiddensupprime : hiddensupprime
			            	},
			            	success : function(result){
			            		if(result == "OK"){
			            			showResult("L'équipement est supprimé avec succées");
			            			location.reload();
			            		}else{
			            			showResult("L'équipement n'est pas supprimée!");
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
});
function getError(msg){
	alert("The error is : "+msg);
}
function showResult(msg){
	alert(msg);
}