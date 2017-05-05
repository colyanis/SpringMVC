<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Insert title here</title>
</head>
<body>

<p><a href="${pageContext.request.contextPath}/offers">Show current offers.</a></p>

<p><a href="${pageContext.request.contextPath}/createOffer">Add a new offer.</a></p>

<sec:authorize access="!isAuthenticated()">
    <p><a href="<c:url value='/login'/>">Log in</a></p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <p><a href="<c:url value='/logout'/>">Log out</a></p>
</sec:authorize>

<sec:authorize access="hasAnyAuthority('ROLE_ADMIN')">
    <p><a href="<c:url value="/admin"/>"/>Admin</p>
</sec:authorize>

</body>
</html>