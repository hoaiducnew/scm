<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link href="<c:url value="/css/players.css"/>" rel="stylesheet">
<table border="1" style="margin-top: 10px; min-height: 400px">
	<tr>
		<td width="20%" valign="top"><%@ include file="left-nav.jsp"%>
		</td>
		<td width="80%" valign="top">

			<div style="float: left">
				<img id="myImg" class="player_img_edit"
					src="<c:url value="/img/${playerForUpdated.playerId}.jpg"></c:url>"
					alt="${playerForUpdated.firstName}" width="300" height="200">
				<!-- The Modal -->
				<div id="myModal" class="modal">
					<span class="close">×</span> <img class="modal-content" id="img01">
					<div id="caption"></div>
				</div>
			</div>
			<div>
				<h2 style=" padding-left: 600px;">${playerForUpdated.firstName}Information:</h2>
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

<script type="text/javascript" src="<spring:url value="/resource/js/player.js"/>"></script>