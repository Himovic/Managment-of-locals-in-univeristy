$(document).ready(function(){
	$("h4").hide();
	$("#myTable").hide();
	var HiddenReserveLocal = "HiddenReserveLocal";
	var HiddenShowAllLocal = "HiddenShowAllLocal";
	var HiddenConfirmeReserveLocal = "HiddenConfirmeReserveLocal";
	/*
	 * Start declaration of the return type
	 * */
		
	var CreneauError = "Créneau complé ! Esseayer un autre créneau.";
	var PlaceError = "Il n'y'a pas un local qui corréspond a le nombre de place entrée";
	var EquipementError = "Il n'y'a pas un local qui contien tous les équipements sélectionnés";
	/*
	 * End declaration of the return type
	 * */
	
	var EquipementList = [];
	var CreneauSelected = [];
	var AllLocals = [];
	var AllLocalsTable = [];
	var AllLocalsEtage = [];
	var date ="";
	var allCreneau="";
	$("#submit").click(function(){
		var nbrPlace = $("#nbrplace").val(); 
		date = $("#dateres").val();
		$('input[name="equipement"]:checked').each(function() {
			   EquipementList.push(this.value);
		});
		$('input[name="creneau"]:checked').each(function() {
			   CreneauSelected.push(this.value);
		});
		var allEquipement = EquipementList.toString();
		allCreneau = CreneauSelected.toString();
		$.ajax({
			url : "http://localhost:8080/GestionLocal/ReservationCtrl",
        	method : "GET",
        	dataType : "text",
        	data : {
        		HiddenReserveLocal : HiddenReserveLocal,
        		nbrPlace : nbrPlace,
        		date : date,
        		allEquipement : allEquipement,
        		allCreneau : allCreneau
        	},
        	success : function(results){
        				if(results == CreneauError){
            				showMessage(results);
    	                }else if(results == PlaceError){
    	                	showMessage(results);
    	                }else if(results == EquipementError){
    	                	showMessage(results);
    	                }else{
    	                	$.ajax({
            					url : "http://localhost:8080/GestionLocal/ReservationCtrl",
            			    	method : "GET",
            			    	dataType : "text",
            			    	data :{
            			    		HiddenShowAllLocal : HiddenShowAllLocal,
            			    		results : results
            			    	},
            			    	success : function(data){
            			    		//showMessage(data);
            			    		var obj = $.parseJSON(data);
            			    		var count = Object.keys(obj).length;
            			    		for(var i=0 ; i<count ; i++){
            			    			//showMessage(obj[i].Nom);
            			    			AllLocals.push(obj[i].Nom);
            			    			AllLocalsTable.push(obj[i].nbrtable);
            			    			AllLocalsEtage.push(obj[i].Etage);
            			    		}
            			    		for(var k=0 ; k<AllLocals.length ; k++){
            			    			var name = AllLocals[k].toString();
            			    			var table = AllLocalsTable[k].toString();
            			    			var etage = AllLocalsEtage[k].toString();
            			    			var makeup = "<tr><td>"+name+"</td><td>"+table+"</td><td>"+etage+"</td></tr>";
            			    			$("#myTable tbody").append(makeup);
            			    		}
            			    		$("h4").show();
            			    		$("table").show();
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
                    msg = 'Requested JSON parse failed.'+jqXHR.responseText;
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
	
	/*
	 * Cliquer sur le tableau pour confirmer la reservation du local
	 * */
	var localName="";
	$("#myTable").click(function(){
		$(this).find("td:eq(0)").each(function(){
			alert($(this).html());
			localName = $(this).html();
			//return false;
			$.confirm({
				text : "Vous voulez réserver ce local : "+localName,
				confirm : function(){
					$.ajax({
						url : "http://localhost:8080/GestionLocal/ReservationCtrl",
			        	method : "GET",
			        	dataType : "text",
			        	data : {
			        		localName : localName,
			        		date : date,
			        		allCreneau : allCreneau,
			        		HiddenConfirmeReserveLocal : HiddenConfirmeReserveLocal
			        	},
			        	success : function(results){
			        		if(results == "La reservation est confirmée"){
			        			showMessage(results);
			        			location.reload();
			        		}else if(results == "La reservation n'est pas confirmée"){
			        			showMessage(results);
			        		}else{
			        			showMessage("Error server!");
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
			                    msg = 'Requested JSON parse failed.'+jqXHR.responseText;
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
	alert(msg);
}
function showMessage(msg){
	alert(msg);
}