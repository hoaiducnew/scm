<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/fanclubs" var="url" />
<table border="1" style="margin-top: 10px; min-height: 400px">
	<tr>
		<td width="20%" valign="top"><%@ include file="left-nav.jsp"%>
		</td>
		<td width="80%" valign="top">
			<div style="width: 90%; margin: 0 auto;">
				<c:forEach items="${fanclubs}" var="fanclub">
					<div class="responsive-player">
						<div class="gallery">
							<a href="detail/${fanclub.name}"> <img
								src="<c:url value="/img/fanclub-${fanclub.name}.jpg" />" alt="image"
								width="300" height="200" />
							</a>
							<div class="desc">
								<strong>${ fanclub.name }</strong><br /> ${fanclub.description}<br />
								<a class="player_edit" href="${url}/edit/${fanclub.id}">Edit</a>
								<a class="player_delete" href="${url }/delete/${fanclub.id}">Delete</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div style="float: right">
				<a class="fanclub_add" href="add">Add fanclub</a>
			</div>
		</td>
	</tr>
</table>