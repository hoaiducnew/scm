<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/stadiums" var="url" />
<table border="1" style="margin-top: 10px; min-height: 400px">
	<tr>
		<td width="20%" valign="top">
			<%@ include file="header.jsp"%>
		</td>
		<td width="80%" valign="top">
			<div style="width:90%; margin:0 auto;">
				<form:form
					modelAttribute="stadium" method="POST"
					enctype="multipart/form-data"
					action="${url}/edit/${stadium.id}">
					<input type="hidden" value="edit" name="type">
					<form:errors path="*" cssStyle="Color:RED"></form:errors>
					<fieldset>
						<legend>Edit Player</legend>
						<div style="float: left">
							<img id="myImg"
								src="<c:url value="/img/stadium-${stadium.name}.jpg"></c:url>"
								alt="image" />
						</div>
						<div class = "form_playerEdit">

							<h2>${stadium.name} Information:</h2>
							<div style="padding-left: 600px;">
								<p>
								<label for="name">Name</label>
								<form:input path="name" id="name" />
								<form:errors path="name" cssStyle="alert"/>
							</p>
							<p>
								<label for="description">Description</label>
								<form:input path="description" id="description" />
							</p>
							<p>
								<label for="capacity">Capacity</label>
								<form:input path="capacity" id="capacity" />
							</p>
							
							<p>
								<label for="address">Address</label>
								<form:input path="address" id="address" />
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
