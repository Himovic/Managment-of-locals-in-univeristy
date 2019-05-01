$(document).ready(function(){
	$("#modifiercreneau").hide();
	var idCreneau =0;
	var HIDDEN_SHOW_CRENEAU ="hiddendetailcreneau";
	var HIDDEN_CONFIRME_CHANGE="hiddenconfirmechange";
	$("tbody tr").click(function(){
		$(this).find("td:eq(0)").each(function(){
			alert($(this).html());
			idCreneau = $(this).html();
			return false;
		});
		$.ajax({
			url : "http://localhost:8080/GestionLocal/CreneauCtrl",
        	method : "GET",
        	dataType : "json",
        	data : {
        		idCreneau : idCreneau,
        		HIDDEN_SHOW_CRENEAU : HIDDEN_SHOW_CRENEAU
        	},
        	success : function(result){
        		if(result != null){
        			$("#heuredebut").val(result.HeureDebut);
        			$("#heurefin").val(result.HeureFin);
        			$("#idCreneau").val(result.id);
        			$("#modifiercreneau").show();
        		}else{
        			showResult("Les données n'ont pas été récupérées!");
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
	
	$("#confirmechange").click(function(){
		var id=$("#idCreneau").val();
		var heuredebut=$("#heuredebut").val();
		var heurefin=$("#heurefin").val();
		$.ajax({
			url : "http://localhost:8080/GestionLocal/CreneauCtrl",
        	method : "GET",
        	dataType : "text",
        	data : {
        		HIDDEN_CONFIRME_CHANGE : HIDDEN_CONFIRME_CHANGE,
        		id : id,
        		heuredebut : heuredebut,
        		heurefin : heurefin
        	},
        	success : function(result){
        		if(result == "OK"){
        			showResult("Modification réussie");
        			location.reload();
        		}else{
        			showResult("Modification échouée!");
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
});