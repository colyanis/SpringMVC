<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Insert title here</title>
</head>
<>
Hi there!
<br/>

<c:forEach var="offer" items="${offers}">
    <p>
        <c:out value="${offer}"></c:out>
    </p>
</c:forEach>
</body>
</html>