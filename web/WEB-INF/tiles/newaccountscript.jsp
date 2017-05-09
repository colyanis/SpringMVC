<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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