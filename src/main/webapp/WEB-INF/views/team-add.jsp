<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<form:form modelAttribute="team" enctype="multipart/form-data">
	<fieldset>
		 <legend>Add new team</legend>
	
		<form:errors path="*" class="w3-red" element="div"/>
		
		<p>
			<label for="name">Name *: </label>
			<form:input path="name" /> <br />
		</p>

		<p>
			<label for="description">Description: </label>
			<form:input path="description" />
		</p>
		
		<p>
			<label for="image" class="control-label col-lg-2">Logo: </label>
			<form:input path="image" type="file" />
			<form:errors path="image" class="w3-red" />
		</p>

		<p id="buttons">
			<input name="reset" type="reset"> 
			<input name="submit" type="submit" value="Add Team">
		</p>
	</fieldset>
</form:form>
</body>
</html>