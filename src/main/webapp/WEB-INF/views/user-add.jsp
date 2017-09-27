<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<style type="text/css">
@import url(css/registration.css);
</style>
</head>
<body>
	<div class="wrapper">
		<form:form modelAttribute="user" action="/scm/users/save" method="POST">
			<fieldset>

				<legend>Registeration Form</legend>
				<div>
					<form:input path="username" />
				</div>

				<div>
					<form:input type="password" path="password" />
				</div>

				<div>
					<form:input path="firstName" />
				</div>

				<div>
					<form:input path="lastName" />
				</div>

				<form:hidden path="role" value="ROLE_USER" />
				<div>
					<input type="submit" id="submit" value="Register" />
				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>
