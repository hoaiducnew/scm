<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/fanclubs" var="url" />
<table border="1" style="margin-top: 10px; min-height: 400px">
	<tr>
		<td width="20%" valign="top">
			<%@ include file="header.jsp"%>
		</td>
		<td width="80%" valign="top">
			<div style="width:90%; margin:0 auto;">
				<form:form
					modelAttribute="fanclub" method="POST"
					enctype="multipart/form-data"
					action="${url}/edit/${fanclub.id}">
					<form:errors path="*" cssStyle="Color:RED"></form:errors>
					<fieldset>
						<legend>Edit Player</legend>
						<div style="float: left">
							<img id="myImg"
								src="<c:url value="/img/fanclub-${fanclub.name}.jpg"></c:url>"
								alt="image" />
						</div>
						<div class = "form_playerEdit">

							<h2>${fanclub.name} Information:</h2>
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
								<label for="leader">Leader</label>
								<form:input path="leader" id="leader" />
							</p>
							
							<p>
								<label for="email">Email</label>
								<form:input path="email" id="email" />
							</p>
							
							<p>
								<label for="numberOfMembers">Number of Member</label>
								<form:input path="numberOfMembers" id="numberOfMembers" />
							</p>
							
							<p>
								<label for="address">Address</label>
								<form:input path="address" id="address" />
							</p>
<!-- 							<p> -->
<!-- 								<label for="image" class="control-label col-lg-2">Images: </label> -->
<%-- 								<form:input path="image" type="file" /> --%>
<!-- 							</p> -->
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
