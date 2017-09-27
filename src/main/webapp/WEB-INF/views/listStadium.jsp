<%@ include file="header.jsp" %>


<section class="container">
		<div class="row">
			<table width=97%  border="1"  style="margin:20px">
			<tr>
			<td>Name</td>
			<td>Capacity</td>
			<td>Picture</td>
			<td>Action</td>
			
			</tr>
			<c:forEach items="${stadiums}" var="stadium">
				<tr>
					
					<td>${stadiums.name}</td>
					<td>${stadiums.capacity}</td>
					<td><img src='data:image/jpg;base64,${product.imageFile}' /></td>
					<td><a href="editStadium/${stadium.id}">Edit</a> | 
					<a href="deleteProduct/${stadium.id}">Delete</a> |
					<a href="#" onclick="makeAjaxCall(${stadium.id})">Details</a>
					</td>
					
		
				</tr>
			</c:forEach>
			</table>
		</div>
	</section>
<%@ include file="footer.jsp" %>