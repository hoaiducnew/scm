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
@import url(../css/players.css);
</style>
</head>
<body>
	<table width="100%" border="1"
		style="margin-top: 50px; min-height: 400px">
		<tr>
			<td width="20%" valign="top">
				<table width="100%" border="1">
					<tr>
						<td class="header">Stadium</td>
					</tr>
				</table>
			</td>
			<td width="60%" valign="top">
			
				<form:form modelAttribute="newStadium" enctype="multipart/form-data">
				<form:errors path="*" cssStyle="Color:RED"></form:errors>
				
						<fieldset> <legend><h1>Add Stadium</h1></legend>
							<p>
								<label for="name">Name</label>
								<form:input path="name" id="name" />
								<form:errors path="name" cssStyle="alert"/>
							</p>
							<p>
								<label for="description">Description</label>
								<form:input path="description" id="description" />
							</p>
							<p>
								<label for="capacity">Capacity</label>
								<form:input path="capacity" id="capacity" />
							</p>
							
							<p>
								<label for="address">Address</label>
								<form:input path="address" id="address" />
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