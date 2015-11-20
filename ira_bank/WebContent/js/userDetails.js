$(document).ready(function() {

	$('#UserDetailsDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#userDetailsForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#userDetailsForm'));

			$(this).dialog('close');
		}
	});


});


	function editUser(id) {
	console.log("comes here")
	$.get("admin/get/" + id, function(result) {
		console.log("comes out");
		console.log(result);
		
		$("#UserDetailsDialog").html(result);

		$('#UserDetailsDialog').dialog("option", "title", 'Edit User Details');

		$("#UserDetailsDialog").dialog('open');

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

initializeDatePicker();
