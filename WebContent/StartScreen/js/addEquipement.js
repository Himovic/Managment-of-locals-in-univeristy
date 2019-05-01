/**
 * 
 */
$(document).ready(function(){
	var submitequi = 0;
	var INT=0;
	var ClickLocal=0;
	$("#formequipement").hide();
	$("#ajoutequip").click(function(){
        $("#formequipement").toggle();
    });
	
	
	$("#submitequip").click(function(){
			var nbrtable = $("#nombretable").val();
			var hiddenequip = $("#hiddenajoutequip").val();
			if(nbrtable != 0){
				var ALL_EQUIP="";
				var SelectedEquip = [];                                       
		        $.each($("input[name='equipement']:checked"), function(){
		        	SelectedEquip.push($(this).val());
		        });
		        ALL_EQUIP = SelectedEquip.toString();
		        $.ajax({
		        	url : "http://localhost:8080/GestionLocal/EquipCtrl",
		        	method : "GET",
		        	dataType : "text",
		        	data : {
		        		ALL_EQUIP : ALL_EQUIP,
		        		hiddenequip : hiddenequip
		        	},
		        	success : function(results){
		        		
		        			if(results != null && results != 0){
			        			TestResult();
			        			$("#testkey").text(results);
			        			AttributResult(results);
			        			
			                }else{
			                	TestResult1();
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
				$("#formequipement").hide();
				 return false;
			}else{
				alert("Vous devez entrer un minimum d'équipement");
			}
			window.setTimeout(LocalNotAdded($("#equipkey").val()),30000);
	});
		
	
	$("#confirmelocal").click(function(){
		var confirmeequip = $("#confirmeequip").val();
		if(confirmeequip == 1 ){
			alert("Equipement ajouté");
			alert($("#equipkey").val());
			var DIS = 0;
			$("#confirmeequip").val(DIS);
			ClickLocal = 1;
		}else{
			alert("Equipement Non ajouté");
		}
	});
});
function TestResult(){
	alert("Funtion success passed");
}
function getError(msg){
	alert("The error is : "+msg);
}
function TestResult1(){
	alert("Funtion success not passed");
}
function EquipementDelete(){
	alert("L'équipement ajouté est supprimé en raison de temps mort");
}
function AttributResult(result){
	$("#equipkey").val(result);
	var CONFIRME = 1;
	$("#confirmeequip").val(CONFIRME);
	submitequi =1;
	alert("Résultat est : "+result);
}
function LocalNotAdded(idEquip) {
	var confirmeequip = $("#confirmeequip").val();
	var hiddendeleteequip = "hiddendeleteequip";
	alert("Function local not added passed");
	if(ClickLocal == 0 && confirmeequip == 1){
		$.ajax({
			url : "http://localhost:8080/GestionLocal/EquipCtrl",
        	method : "GET",
        	dataType : "text",
        	data : {
        		idEquip : idEquip,
        		hiddendeleteequip : hiddendeleteequip
        	},
        	success : function(results){
        		
        			if(results == "DONE"){
	        				EquipementDelete();
        			}else{
	                	TestResult1();
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
	}
}