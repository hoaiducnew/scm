<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Manager List</title>
		
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
						<td class="header">Manager</td>
					</tr>
				</table>
			</td>
			<td width="60%" valign="top">

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
					<h2>${managerForUpdated.firstName} Information:</h2>
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
	<%@ include file="footerClient.jsp"%>
</body>

<script type="text/javascript" src="<spring:url value="/resource/js/player.js"/>"></script>
</html>