<div id="header">
<ul>
	<c:choose>
		<c:when test="${empty user}">
			<li><a href="<c:url value="/login"/>">Login</a></li>
		</c:when>
		<c:otherwise>
			<li>Welcome <strong> ${user.firstName} ${user.lastName} </strong>! </li>
			<li><a href="<c:url value="/logout"/>">Logout</a></li>
		</c:otherwise>
	</c:choose>
</ul>
</div>