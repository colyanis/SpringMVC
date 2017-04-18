<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Insert title here</title>
</head>
<>
Hi there!

<c:out value="${name}"></c:out>

<sql:query var="rs" dataSource="jdbc/spring">
    select id, name, text from offers
</sql:query>

<c:forEach var="row" items="${rs.rows}">
    ID ${row.id}<br/>
    Name ${row.name}<br/>
    Text ${row.text}<br/>
    <br/>
</c:forEach>
</body>
</html>