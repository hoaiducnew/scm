<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table border="1" style="margin-top: 10px; min-height: 400px">
	<tr>
		<td width="20%" valign="top"><%@ include file="left-nav.jsp"%>
		</td>
		<td width="80%" valign="top">
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
								<a class="player_delete" href="deleteManager/${Manager.id}">Delete</a>
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

