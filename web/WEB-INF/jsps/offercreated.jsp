<%--
  Created by IntelliJ IDEA.
  User: mtverdok
  Date: 4/19/2017
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Offer Created</title>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
  <p><a href="<c:url value='/login'/>">Log in</a></p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
  <p><a href="<c:url value='/logout'/>">Log out</a></p>
</sec:authorize>

Offer created: <a href="${pageContext.request.contextPath}/offers">click here to view</a>
</body>
</html>
