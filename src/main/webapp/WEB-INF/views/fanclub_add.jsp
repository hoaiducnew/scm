<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<table width="100%" border="1"
	style="margin-top: 50px; min-height: 400px">
	<tr>
		<td width="20%" valign="top">
			<table width="100%" border="1">
				<tr>
					<td class="header">FanClub</td>
				</tr>
			</table>
		</td>
		<td width="60%" valign="top"><form:form modelAttribute="fanClub" enctype="multipart/form-data">
				<form:errors path="*" cssStyle="Color:RED"></form:errors>

				<fieldset>
					<legend>
						<h1>Add FanClub</h1>
					</legend>
					<p>
						<label for="name">Name</label>
						<form:input path="name" id="name" />
						<form:errors path="name" cssStyle="alert" />
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
					<p>
						<label for="image" class="control-label col-lg-2">Images:
						</label>
						<form:input path="image" type="file" />
					</p>

					<p id="buttons">
						<input name="submit" type="submit" value="Save">
					</p>
				</fieldset>
			</form:form></td>
	</tr>
</table>
