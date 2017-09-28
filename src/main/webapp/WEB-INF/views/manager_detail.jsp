<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table border="1" style="margin-top: 10px; min-height: 400px">
	<tr>
		<td width="20%" valign="top"><%@ include file="left-nav.jsp"%>
		</td>
		<td width="80%" valign="top">
			<div style="float: left">
				<img id="myImg" class="Manager_img_edit"
					src="<c:url value="/img/${managerForUpdated.managerId}.jpg"></c:url>"
					alt="${managerForUpdated.firstName}" width="300" height="200">
				<!-- The Modal -->
				<div id="myModal" class="modal">
					<span class="close">×</span> <img class="modal-content" id="img01">
					<div id="caption"></div>
				</div>
			</div>
			<div>
				<h2>${managerForUpdated.firstName}Information:</h2>
				<div style="padding-left: 600px;">
					<table class="Manager-info">
						<tr>
							<td>Full Name</td>
							<td>${managerForUpdated.firstName}
								${managerForUpdated.lastName}</td>
						</tr>
						<tr>
							<td>Birthday</td>
							<td>${managerForUpdated.birthday}</td>
						</tr>
						<tr>
							<td>Biography</td>
							<td>${managerForUpdated.biography}</td>
						</tr>
						<tr>
							<td>Salary</td>
							<td>${managerForUpdated.salary}</td>
						</tr>
					</table>

				</div>

			</div>

		</td>
	</tr>
</table>