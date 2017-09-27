






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
<style type="text/css">
@import url(css/players.css);
</style>
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
			<td width="60%" valign="top">
			
				<form:form modelAttribute="playerForUpdated" method="POST" enctype="multipart/form-data" action="/scm/editPlayer/${playerForUpdated.id}">
				<form:errors path="*" cssStyle="Color:RED"></form:errors>
						<fieldset> <legend>Edit Player</legend>
						<div style="float: left">
							<p>Image:</p>
							<img
								src="<c:url value="/img/${playerForUpdated.firstName}.jpg"></c:url>"
								alt="image" style="width: 100%" />
						</div>
						<div>
							<p>
								<label for="firstName">first Name</label>
								<form:input path="firstName" id="firstName" />
							</p>
							<p>
								<label for="lastName">last Name</label>
								<form:input path="lastName" id="lastName" />
							</p>
							<p>
								<label for="biography">biography</label>
								<form:input path="biography" id="biography" />
							</p>
							<p>
								<label for="salary">salary</label>
								<form:input path="salary" id="salary" />
							</p>
							<p>
								<label for="birthday">birthday</label>
								<form:input path="birthday" id="birthday" />
							</p>
							<p>
								<label for="playerPosition.position">playerPosition</label>
								<form:input path="playerPosition.position"
									id="playerPosition.position" />
							</p>
							<p>
								<label for="name">Position Description</label>
								<form:input path="playerPosition.description"
									id="playerPosition.description" />
							</p>
						</div>



						<p id="buttons">
							<input name="submit" type="submit" value="Save">
						</p>
					</fieldset>
					</form:form> 
				
			</td>
		</tr>
	</table>
	
	<%@ include file="footerClient.jsp"%>
</body>
</html>