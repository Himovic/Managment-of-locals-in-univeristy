/**
 * 
 */

$(document).ready(function(){
	$("#submit").click(function(){
		var EquipName = $("#nomequipement").val();
		var hiddenajoutequip = "caseAjoutEquipement";
		$.ajax({
			url : "http://localhost:8080/GestionLocal/EquipCtrl",
        	method : "POST",
        	dataType : "text",
        	data : {
        		EquipName : EquipName,
        		hiddenajoutequip : hiddenajoutequip
        	},
        	success : function(result){
        		if(result == "OK" ){
        			showResult("L'équipement est ajouté avec succées");
        			location.reload();
        		}else{
        			showResult("L'équipement n'est pas ajouté ! ");
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
function getError(msg){
	alert("The error is : "+msg);
}
function showResult(msg){
	alert(msg);
}