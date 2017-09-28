<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
@import url(css/login.css);
</style>
</head>
<body>
	<form:form modelAttribute="user" method="POST">
		<div class="container">
			<label><b>Username</b></label> <form:input type="text" path="username" placeholder="Enter Username" /> 
			<label><b>Password</b></label> <form:input type="password" path="password" />
			<label><b>First Name</b></label> <form:input type="text" path="firstName" placeholder="Enter First Name" />
			<label><b>Last Name</b></label> <form:input type="text" path="lastName" placeholder="Enter Last Name" />
			<form:hidden path="role" value="ROLE_USER" />
			<button type="submit">Register</button>
		</div>
	</form:form>
</body>
</html>
