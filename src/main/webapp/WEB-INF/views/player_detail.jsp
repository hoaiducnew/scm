<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Player List</title>
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-alpha1/jquery.js"></script>
		<link href="<c:url value="/css/players.css" />" rel="stylesheet">
	
	</head>
<body>
	<%@ include file="headerClient.jsp"%>

	<table width="100%" border="1"
		style="margin-top: 50px; min-height: 400px">
		<tr>
			<td width="20%" valign="top">
				<table width="100%" border="1">
					<tr>
						<td class="header">Player</td>
					</tr>
				</table>
			</td>
			<td width="60%" valign="top">

				<div style="float: left">
					<img id="myImg" class="player_img_edit"
						src="<c:url value="/img/${playerForUpdated.playerId}.jpg"></c:url>"
						alt="${playerForUpdated.firstName}" width="300" height="200">
					<!-- The Modal -->
					<div id="myModal" class="modal">
						<span class="close">�</span> <img class="modal-content" id="img01">
						<div id="caption"></div>
					</div>
				</div>
				<div>
					<h2>${playerForUpdated.firstName} Information:</h2>
					<div style="padding-left: 600px;">
						<table class="player-info">
							<tr>
								<td>Full Name</td>
								<td>${playerForUpdated.firstName}
									${playerForUpdated.lastName}</td>
							</tr>
							<tr>
								<td>Birthday</td>
								<td>${playerForUpdated.birthday}</td>
							</tr>
							<tr>
								<td>Biography</td>
								<td>${playerForUpdated.biography}</td>
							</tr>
							<tr>
								<td>Salary</td>
								<td>${playerForUpdated.salary}</td>
							</tr>
							<tr>
								<td>Position</td>
								<td>${playerForUpdated.playerPosition.position}</td>
							</tr>
							<tr>
								<td>Position Description:</td>
								<td>${playerForUpdated.playerPosition.description}</td>
							</tr>
						</table>

					</div>

				</div>



			</td>
		</tr>
	</table>
	<%@ include file="footerClient.jsp"%>
</body>

<script type="text/javascript" src="<spring:url value="/resource/js/player.js"/>"></script>
</html>