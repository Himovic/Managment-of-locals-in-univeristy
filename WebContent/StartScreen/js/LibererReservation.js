/**
 * 
 */

$(document).ready(function(){
	var numeroReservation ="";
	var HIDDEN_LIBERER_RESERVATION = "";
	$("tbody tr").click(function(){
		$(this).find("td:eq(0)").each(function(){
			alert($(this).html());
			numeroReservation = $(this).html();
			return false;
		});
	
		$.confirm({
			text : "Etes-vous sur de libérer cette réservation ?",
			confirm : function(){
				$.ajax({
					url : "http://localhost:8080/GestionLocal/ReservationCtrl",
		        	method : "GET",
		        	dataType : "text",
		        	data : {
		        		HIDDEN_LIBERER_RESERVATION : HIDDEN_LIBERER_RESERVATION,
		        		numeroReservation : numeroReservation
		        	},
				success : function(results){
					if(results == "Reservation libérer avec succées"){
						showResult(results);
						location.reload();
					}else if(results == "La réservation n'est pas libérée"){
						showResult(results);
						location.reload();
					}else{
						showResult("Error server");
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