<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h2>Create new account</h2>

<sf:form id = "details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
    <table class="formtable">
        <tr>
            <td class="label">Username:</td>
            <td>
                <sf:input class="control" name="username" type="text" path="username"/>
                <br/>

                <div class="error">
                    <sf:errors path="username"></sf:errors>
                </div>
            </td>
        </tr>
        <tr>
            <td class="label">Email:</td>
            <td>
                <sf:input class="control" path="email" name="email" type="text"/>
                <br/>

                <div class="error">
                    <sf:errors path="email"></sf:errors>
                </div>
            </td>
        </tr>
        <tr>
            <td class="label">Password:</td>
            <td>
                <sf:input class="control" id="password" path="password" name="password" type="text"/>
                <br/>

                <div class="error">
                    <sf:errors path="password"></sf:errors>
                </div>
            </td>
        </tr>
        <tr>
            <td class="label">Confirm password:</td>
            <td>
                <input class="control" id="confirmpass" name="confirmpass" type="text"/>

                <div id="matchpass"></div>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input class="control" value="Create account" type="submit"/>
            </td>
        </tr>
    </table>
</sf:form>