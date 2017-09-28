<div id="header">
<ul>
	<c:choose>
		<c:when test="${empty user}">
			<li><a href="<c:url value="/login"/>"><spring:message code="login.label"/></a></li>
		</c:when>
		<c:otherwise>
			<li><spring:message code="welcome.label"/> <strong> ${user.firstName} ${user.lastName} </strong>! </li>
			<li><a href="<c:url value="/logout"/>"><spring:message code="logout.label"/></a></li>
		</c:otherwise>
	</c:choose>
</ul>
</div>