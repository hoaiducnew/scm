<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/stadiums" var="url" />
<table border="1" style="margin-top: 10px; min-height: 400px">
	<tr>
		<td width="20%" valign="top">
			<%@ include file="header.jsp"%>
		</td>
		<td width="80%" valign="top">
			<div style="width:90%; margin:0 auto;">
			<c:forEach items="${stadiums}" var="stadium">
				<div class="responsive-player">
					<div class="gallery">
						<a href="detail/${stadium.id}">
							<img src="<c:url value="/img/${stadium.id}.jpg" />" alt="image"  width="300" height="200" />
						</a>
						<div class="desc">
							<strong>${ stadium.name }</strong><br />
							${stadium.description}<br />
							<a class="player_edit" href="${url}/edit/${stadium.id}">Edit</a>
							<a class="player_delete" onclick="delete(${stadium.id})">Delete</a>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
				<div style="float: right">
					<a class="stadium_add" href="add">Add stadium</a>
				</div>
		</td>
	</tr>
</table>