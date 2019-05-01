/**
 * 
 */
$(document).ready(function(){
	$("#confirmer").click(function(){
		var ALL_EQUIP="";
		var ALL_NIV="";
		var SelectedEquip = [];         
		var SelectedNiv = [];
		var NOM_LOCAL = $("#nomlocal").val();
		var NBR_TABLE = $("#nbrtable").val();
		var NUMERO = $("#numero").val();
		var ETAGE = $("#etage").val();
		var HIDDENADD = $("#hiddenajoutlocal").val();
        $.each($("input[name='equipement']:checked"), function(){
        	SelectedEquip.push($(this).val());
        });
        $.each($("input[name='niveau']:checked"), function(){
        	SelectedNiv.push($(this).val());
        });
        ALL_EQUIP = SelectedEquip.toString();
        ALL_NIV = SelectedNiv.toString();
        $.ajax({
        	url : "http://localhost:8080/GestionLocal/LocalCtrl",
        	method : "GET",
        	dataType : "text",
        	data : {
        		ALL_EQUIP : ALL_EQUIP,
        		ALL_NIV : ALL_NIV,
        		NOM_LOCAL : NOM_LOCAL,
        		NBR_TABLE : NBR_TABLE,
        		NUMERO : NUMERO,
        		ETAGE : ETAGE,
        		HIDDENADD : HIDDENADD
        	},
        	success : function(results){
        		if(results =! 0){
        			showMessage("Le local est ajoutée avec succées");
        			location.reload();
        		}else{
        			showMessage("Le local n'est pas ajoutée avec succées");
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
function showMessage(msg){
	alert(msg);
}