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
<script type="text/javascript"
	src="<spring:url value="/resource/js/cart.js"/>"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-alpha1/jquery.js"></script>

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
			<td width="60%" valign="top"><form:form
					modelAttribute="playerForUpdated" method="POST"
					enctype="multipart/form-data"
					action="/scm/editPlayer/${playerForUpdated.id}">
					<form:errors path="*" cssStyle="Color:RED"></form:errors>
					<fieldset>
						<legend>Edit Player</legend>
						<div style="float: left">
							<img id="myImg" class="player_img_edit"
								src="<c:url value="/img/${playerForUpdated.playerId}.jpg"></c:url>"
								alt="image" />
						</div>
						<div class = "form_playerEdit">

							<h2>${playerForUpdated.firstName} Information:</h2>
							<div style="padding-left: 600px;">
								<p>
									<label class="label" for="firstName">First Name</label>
									<form:input type="text" class="textbox" path="firstName" id="firstName" />
								</p>
								<p>
									<label class="label" for="lastName">Last Name</label>
									<form:input type="text" class="textbox" path="lastName" id="lastName" />
								</p>
								<p>
									<label class="label" for="biography">Biography</label>
									<form:input type="text" class="textbox" path="biography" id="biography" />
								</p>
								<p>
									<label class="label" for="salary">Salary</label>
									<form:input type="text" class="textbox" path="salary" id="salary" />
								</p>
								<p>
									<label class="label" for="birthday">Birthday</label>
									<form:input type="text" class="textbox" path="birthday" id="birthday" />
								</p>
								<p>
									<label for="playerPosition.position">Position</label>
									<form:select path="playerPosition.position" id="playerPosition.position">
										<form:options path="playerPosition.position" items="${positions}" />
									</form:select>
								</p>
								<p>
									<label class="label" for="name">Position Description</label>
									<form:input type="text" class="textbox" path="playerPosition.description"
										id="playerPosition.description" />
								</p>
								<p id="buttons">
									<input type="submit" name="submit" type="submit" value="Save">
								</p>
							</div>

						</div>



						
					</fieldset>
				</form:form></td>
		</tr>
	</table>

	<%@ include file="footerClient.jsp"%>
</body>
</html>