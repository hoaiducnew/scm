<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Player List</title>
<script type="text/javascript"
	src="<spring:url value="/resource/js/cart.js"/>"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-alpha1/jquery.js"></script>
	<style type="text/css"> @import url(css/players.css); </style>
</head>
<body>
	<%@ include file="headerClient.jsp"%>

	<h2>List Player</h2>
	<table width="100%" border="1" style="margin-top: 50px; min-height: 400px">
		<tr>
			<td width="20%" valign="top"><table width="100%" border="1">
					<tr>
						<td class="header">Player</td>
					</tr>
				</table></td>
			<td width="60%" valign="top">
				<form id="players">

					<table>
						<tr class="player">
							<th>Full Name</th>
							<th>Position</th>
							<th>Action</th>
						</tr>
						<c:forEach var="player" items="${players}">
							<tr>
								<td><a href="detail/${player.id}">${player.firstName}  ${player.lastName}</a></td>
								<td>${player.playerPosition.position}</td>
								<td><a class="player_edit" href="editPlayer/${player.id}">Edit</a>  <a class="player_delete" href="deletePlayer/${player.id}">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
					<br>
					<div style="float: right"><a class="player_add" href="add">Add Player</a> </div>
					

				</form>
			</td>
		</tr>
	</table>



	<%@ include file="footerClient.jsp"%>
</body>
</html>


