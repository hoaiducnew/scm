<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<header>
   	<h1><a href="<spring:url value="/" />"><spring:message code="application.name"/></a></h1>
	<h6>[<a href="?language=en">English</a> | <a href="?language=vn">Vietnamese</a>]</h6>
</header>

<%@ include file="/WEB-INF/views/header.jsp"%>
