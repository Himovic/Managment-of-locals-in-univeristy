$(document).ready(function(){
	var localName ="";
	var HIDDEN_DELETE="GET_LOCAL_DELETE_VALUE";
	$("tbody tr").click(function(){
		$(this).find("td:eq(0)").each(function(){
			alert($(this).html());
			localName = $(this).html();
			return false;
		});
		$.confirm({
			text: 'Vous etes sur de vouloir supprimer ce local ?',
			confirm : function(){
				$.ajax({
					url : "http://localhost:8080/GestionLocal/LocalCtrl",
	            	method : "GET",
	            	dataType : "text",
	            	data : {
	            		localName : localName,
	            		HIDDEN_DELETE : HIDDEN_DELETE
	            	},
	            	success : function(result){
	            		if(result == "OK"){
	            			showResult("Le local est supprimé avec succées");
	            			location.reload();
	            		}else{
	            			showResult("Le local n'a pas été supprimer!");
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