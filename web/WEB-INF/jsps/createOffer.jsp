<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Create Offer</title>
    <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>

<sec:authorize access="!isAuthenticated()">
    <p><a href="<c:url value='/login'/>">Log in</a></p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <p><a href="<c:url value='/logout'/>">Log out</a></p>
</sec:authorize>

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">
<table class="formtable">
    <tr>
        <td class="label">Name:</td>
        <td>
            <sf:input class="control" name="name" type="text" path="name"/>
            <br/>
            <sf:errors path="name" cssClass="error"></sf:errors>
        </td>
    </tr>
    <tr>
        <td class="label">Email:</td>
        <td>
            <sf:input class="control" path="email" name="email" type="text"/>
            <br/>
            <sf:errors path="email" cssClass="error"></sf:errors>
        </td>
    </tr>
    <tr>
        <td class="label">Your offer:</td>
        <td>
            <sf:textarea class="control" name="text" rows="10" cols="10" path="text"></sf:textarea>
            <br/>
            <sf:errors path="text" cssClass="error"></sf:errors>
        </td>
    </tr>
    <tr>
        <td></td>
        <td>
            <input class="control" value="Create advert" type="submit"/>
        </td>
    </tr>
</table>
</sf:form>
</body>
</html>
