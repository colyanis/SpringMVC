<%--
  Created by IntelliJ IDEA.
  User: mtverdok
  Date: 4/19/2017
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Offer</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/docreate">
<table>
    <tr>
        <td>Name:</td>
        <td>
            <input name="name" type="text">
        </td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>
            <input name="email" type="text"/>
        </td>
    </tr>
    <tr>
        <td>Your offer:</td>
        <td>
            <textarea name="text" rows="10" cols="10"></textarea>
        </td>
    </tr>
    <tr>
        <td></td>
        <td>
            <input value="Create advert" type="submit"/>
        </td>
    </tr>
</table>
</form>
</body>
</html>
