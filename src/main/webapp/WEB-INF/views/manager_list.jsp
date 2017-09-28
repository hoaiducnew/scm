<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manager List</title>
<script type="text/javascript"
	src="<spring:url value="/resource/js/cart.js"/>"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-alpha1/jquery.js"></script>
<style type="text/css">
@import url(css/players.css);
</style>

</head>
<body>
	<%@ include file="headerClient.jsp"%>

	<h2>List Manager</h2>
	<table width="100%" border="1"
		style="margin-top: 50px; min-height: 400px">
		<tr>
			<td width="20%" valign="top"><table width="100%" border="1">
					<tr>
						<td class="header">Manager</td>
					</tr>
				</table></td>
			<td width="60%" valign="top">
				<form id="Managers">

					<table>
						<tr class="Manager">
							<th>Full Name</th>
							<th>Biography</th>
							<th>Action</th>
						</tr>
						<c:forEach var="Manager" items="${Managers}">
							<tr>
								<td><a class="player_fullname"
									href="detail_manager/${Manager.id}">${Manager.firstName}
										${Manager.lastName}</a></td>
								<td style="width: 60%;">${Manager.biography}</td>
								<td><a class="player_edit" href="editManager/${Manager.id}">Edit</a>
									<a class="player_delete" href="deleteManager/${Manager.id}">Edit</a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<br>
					<div style="float: right">
						<a class="player_add" href="addManager">Add Manager</a>
					</div>


				</form>
			</td>
		</tr>
	</table>



	<%@ include file="footerClient.jsp"%>
</body>


<script type="text/javascript"
	src="<spring:url value="/resource/js/player.js"/>"></script>
</html>


