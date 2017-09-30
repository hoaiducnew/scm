<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table border="1" style="margin-top: 10px; min-height: 400px">
	<tr>
		<td width="20%" valign="top"><%@ include file="left-nav.jsp"%>
		</td>
		<td width="80%" valign="top">
			<form id="players">
				<table>
					<tr class="player">
						<th>Full Name</th>
						<th>Position</th>
						<th>Action</th>
					</tr>
					<c:forEach var="player" items="${players}">
						<tr>
							<td><a class="player_fullname" href="detail/${player.id}">${player.firstName}
									${player.lastName}</a></td>
							<td>${player.playerPosition.position}</td>
							<td><a class="player_edit" href="editPlayer/${player.id}">Edit</a>
							
							<a class="player_delete" href="deletePlayer/${player.id}">Delete</a>
						</tr>
					</c:forEach>
				</table>
				<br>
				<div style="float: right">
					<a class="player_add" href="add">Add Player</a>
				</div>
			</form>
		</td>
	</tr>
</table>