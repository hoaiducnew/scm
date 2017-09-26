<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:forEach items="${teams}" var="team">
	<div class="responsive">
		<div class="gallery">
			<a target="_blank" href="<c:url value="/img/${ team.imagePath }"></c:url>">
				<img src="<c:url value="/img/${ team.imagePath }"></c:url>" alt="image"  width="300" height="200" />
			</a>
			<div class="desc">
				<strong>${ team.name }</strong><br />
				${ team.description }
			</div>
		</div>
	</div>
</c:forEach>

<div class="clearfix"></div>
