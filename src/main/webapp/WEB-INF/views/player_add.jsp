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
			
				<form:form modelAttribute="addPlayer" enctype="multipart/form-data">
						<fieldset> <legend><h1>Add Player</h1></legend>
							<p>
								<label for="playerId">Player Id</label>
								<form:input path="playerId" id="playerId" />
								<form:errors path="playerId" cssStyle="Color:RED"></form:errors>
								
							</p>
							<p>
								<label for="firstName">First Name</label>
								<form:input path="firstName" id="firstName" />
								<form:errors path="firstName" cssStyle="Color:RED"></form:errors>
							</p>
							<p>
								<label for="lastName">Last Name</label>
								<form:input path="lastName" id="lastName" />
								<form:errors path="lastName" cssStyle="Color:RED"></form:errors>
							</p>
							<p>
								<label for="biography">Biography</label>
								<form:input path="biography" id="biography" />
								<form:errors path="biography" cssStyle="Color:RED"></form:errors>
							</p>
							<p>
								<label for="salary">Salary</label>
								<form:input path="salary" id="salary" />
								<form:errors path="salary" cssStyle="Color:RED"></form:errors>
							</p>
							<p>
								<label for="birthday">Birthday</label>
								<form:input path="birthday" id="birthday" />
								<form:errors path="birthday" cssStyle="Color:RED"></form:errors>
							</p>
							<p>
								<label for="playerPosition.position">Position</label>
								<form:select path="playerPosition.position">
									<form:options items="${positions}" />
								</form:select>
							</p>
							<p>
								<label for="name">Description</label>
								<form:input path="playerPosition.description" id="playerPosition.description" />
								<form:errors path="playerPosition.description" cssStyle="Color:RED"></form:errors>
							</p>
							<p>
								<label for="image" class="control-label col-lg-2">Images: </label>
								<form:input path="image" type="file" />
							</p>

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