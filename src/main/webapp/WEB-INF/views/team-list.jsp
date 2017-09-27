<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div style="width:90%; margin:0 auto;">
	<c:forEach items="${teams}" var="team">
		<div class="responsive">
			<div class="gallery">
				<a target="_blank" href="<spring:url value="/teams/team?id=${ team.id }" />">
					<img src="<c:url value="/img/${ team.imagePath }" />" alt="image"  width="300" height="200" />
				</a>
				<div class="desc">
					<strong>${ team.name }</strong><br />
					${ team.description }
				</div>
			</div>
		</div>
	</c:forEach>
	
	<div class="clearfix"></div>
	
	<div style="float: left"><a class="player_add" href="teams/team-add">Add Team</a> </div>
</div>


