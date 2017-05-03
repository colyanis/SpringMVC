<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Create New Account</title>
    <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/script/jquery.js">
    </script>
    <script type="text/javascript">
        function onLoad() {
            $('#password').keyup(checkPasswordsMatch);
            $('#confirmpass').keyup(checkPasswordsMatch);

            $("#details").submit(canSubmit)
        }

        function canSubmit() {
            var password = $("#password").val();
            var confirmpass = $("#confirmpass").val();

            if(password == confirmpass) {
                return true;
            } else {
                alert("<fmt:message key='UnmatchedPassword.user.password'/>")
                return false;
            }
        }

        function checkPasswordsMatch() {
            var password = $('#password').val();
            var confirmpass = $('#confirmpass').val();

            if (password.length > 3 || confirmpass.length > 3) {
                if (password == confirmpass) {
                    $('#matchpass').text("<fmt:message key='MatchedPassword.user.password'/>")
                    $("#matchpass").addClass("valid");
                    $("#matchpass").remove("error");
                } else {
                    $('#matchpass').text("<fmt:message key='UnmatchedPassword.user.password'/>")
                    $("#matchpass").remove("valid");
                    $("#matchpass").addClass("error");
                }
            }

        }

        $(document).ready(onLoad);
    </script>
</head>
<body>

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
</body>
</html>
