$(document).ready(function() {
	function deleteStadium(id) {
		var con=confirm("Are you sure you want to delet this stadium "+ id)
		if (con) {
			$.ajax({
	            type: "delete",
	            url: "/stadiums/delete/" + id,
	            contentType: 'application/json; charset=utf-8',
	            dataType: 'json',
	            success: function (response) {
	                alert(response.status);
	            },
	            error: function (data) {
	                alert("error");
	            }
	        });      
		}
		
	}
	
});