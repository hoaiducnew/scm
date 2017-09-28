<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
							<th>Biography</th>
							<th>Position</th>
							<th>Action</th>
						</tr>
						<c:forEach var="player" items="${players}">
							<tr>
								<td ><a class="player_fullname" href="detail/${player.id}">${player.firstName}  ${player.lastName}</a></td>
								<td style="width: 60%;">${player.biography}</td>
								<td>${player.playerPosition.position}</td>
								<td>
									<a class="player_edit" href="editPlayer/${player.id}">Edit</a>
									<button class="player_delete" onclick="deletePlayer(${player.id})">Delete</button>
								</td>
							</tr>	
						</c:forEach>
					</table>
					<br>
					<div style="float: right"><a class="player_add" href="add">Add Player</a> </div>
					

				</form>
			</td>
		</tr>
	</table>