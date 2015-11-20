function editTrans(id) {
	console.log("comes here")
	$.get("edit/" + id, function(result) {
		console.log("comes out");
		console.log(result);
		
		$("#requestDetailsDialog").html(result);

		$('#requestDetailsDialog').dialog("option", "title", 'Edit User Details');

		$("#requestDetailsDialog").dialog('open');

		initializeDatePicker();
	
	});
}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "mm-dd-yyyy",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#requestDetailsDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#requestDetailsForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#requestDetailsForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
