<strong> ${ team.name } </strong><br />

<a target="_blank" href="<spring:url value="/teams/team?id=${ team.id }" />">
	<img src="<c:url value="/img/${ team.imagePath }" />" alt="image" />
</a>
<br />

<a href="<spring:url value="/listPlayer" />">Players</a> <br />
<a href="<spring:url value="/listManager" />">Managers</a> <br />
<a href="<spring:url value="/fanclubs/list" />">Fan Club</a> <br />
<a href="<spring:url value="/stadiums/list" />">Stadium</a> <br />