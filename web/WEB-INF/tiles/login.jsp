<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    $(document).ready(function() {
        document.f.username.focus();
    });
</script>

<h3>Login with Username and Password</h3>
<c:if test="${param.error != null}">
    <p class="error">Login failed. Check credentials.</p>
</c:if>

<form name='f' action='${pageContext.request.contextPath}/login' method='POST'>
    <table class="formtable">
        <tr>
            <td>User1:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td>Remember Me:</td>
            <td colspan='2'><input name="remember-me" type="checkbox"/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
        </tr>
    </table>
</form>

<p>
    <a href="<c:url value="/newaccount"/>">Create new account</a>
</p>