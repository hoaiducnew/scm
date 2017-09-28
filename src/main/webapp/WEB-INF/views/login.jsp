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
	<form action="<spring:url value="/postLogin"></spring:url>" method="post">
		<div class="imgcontainer">
			<img src="<c:url value="/img/avatar.png" />" alt="Avatar" class="avatar" />
		</div>

		<div class="container">
			<label><b>Username</b></label> <input type="text" placeholder="Enter Username" name="username" required> 
			<label><b>Password</b></label> <input type="password" placeholder="Enter Password" name="password" required>

			<button type="submit">Login</button>
			<spring:url value="/user-register" var="newUser"></spring:url>
			<span class="psw"><a href="${newUser}">Register New User</a></span>
		</div>
	</form>
</body>
</html>
