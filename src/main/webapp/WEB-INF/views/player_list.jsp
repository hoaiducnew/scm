<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table border="1" style="margin-top: 10px; min-height: 400px">
	<tr>
		<td width="20%" valign="top">
			<%@ include file="left-nav.jsp"%>
		</td>
		<td width="80%" valign="top">
			<div style="width:90%; margin:0 auto;">
			<c:forEach items="${players}" var="player">
				<div class="responsive-player">
					<div class="gallery">
						<a href="detail/${player.id}">
							<img src="<c:url value="/img/${player.firstName}.jpg" />" alt="image"  width="300" height="200" />
						</a>
						<div class="desc">
							<strong>${ player.firstName } ${player.lastName}</strong><br />
							${player.position.description}<br />
							<a class="player_edit" href="editPlayer/${player.id}">Edit</a>
							<a class="player_delete" href="deletePlayer/${player.id}">Delete</a>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
				<div style="float: right">
					<a class="player_add" href="add">Add Player</a>
				</div>
		</td>
	</tr>
</table>
