<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>
<style type="text/css"> @import url("<spring:url value="/css/main.css"/>"); </style>
<style type="text/css"> @import url(css/players.css); </style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="<spring:url value="/resource/js/cart.js"/>"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  	crossorigin="anonymous"></script>
</head>

<body>

	<div>
		<tiles:insertAttribute name="header" />
	</div>
	<div class="content">
		<tiles:insertAttribute name="content" />
	</div>
	<div>
		<tiles:insertAttribute name="footer" />
	</div>
	
</body>
</html>
