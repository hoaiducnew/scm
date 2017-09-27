<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<table border="1" style="margin-top: 10px; min-height: 400px">
	<tr>
		<td width="20%" valign="top">
			<%@ include file="left-nav.jsp"%>
		</td>
		<td width="80%" valign="top">
			<div style="width:90%; margin:0 auto;">
				<form:form
					modelAttribute="playerForUpdated" method="POST"
					enctype="multipart/form-data"
					action="/scm/editPlayer/${playerForUpdated.id}">
					<form:errors path="*" cssStyle="Color:RED"></form:errors>
					<fieldset>
						<legend>Edit Player</legend>
						<div style="float: left">
							<img id="myImg"
								src="<c:url value="/img/${playerForUpdated.firstName}.jpg"></c:url>"
								alt="image" />
						</div>
						<div class = "form_playerEdit">

							<h2>${playerForUpdated.firstName} Information:</h2>
							<div style="padding-left: 600px;">
								<p>
									<label class="label" for="firstName">First Name</label>
									<form:input type="text" class="textbox" path="firstName" id="firstName" />
								</p>
								<p>
									<label class="label" for="lastName">Last Name</label>
									<form:input type="text" class="textbox" path="lastName" id="lastName" />
								</p>
								<p>
									<label class="label" for="biography">Biography</label>
									<form:input type="text" class="textbox" path="biography" id="biography" />
								</p>
								<p>
									<label class="label" for="salary">Salary</label>
									<form:input type="text" class="textbox" path="salary" id="salary" />
								</p>
								<p>
									<label class="label" for="birthday">Birthday</label>
									<form:input type="text" class="textbox" path="birthday" id="birthday" />
								</p>
								<p>
									<label for="position.id">Position</label>
									<form:select path="position.id" items="${positions}" itemLabel="description" itemValue="id"/>
								</p>
								<p id="buttons">
									<input type="submit" name="submit" type="submit" value="Save">
								</p>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</td>
	</tr>
</table>
