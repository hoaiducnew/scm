<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Archify Online Store</title>

</head>
<body>
	${ team.name }
	${ team.description } <br />
	<img src="<c:url value="/img/${team.name}.jpg"></c:url>" alt="image" style="width:100%" />
</body>
</html>