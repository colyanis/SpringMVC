<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    function onDeleteClick(event) {
        event.preventDefault();
        alert("Delete");
    }

    function onReady() {
        $("#delete").click(onDeleteClick());
    }

    $(document).ready(onReady);
</script>

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">
    <sf:input type="hidden" name="id" path="id"/>
    <table class="formtable">
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
        <c:if test="${offer.id != 0}">
            <tr>
                <td></td>
                <td class="delete control">
                    <input class="control" id="delete" name="delete" value="Delete advert" type="submit"/>
                </td>
            </tr>
        </c:if>
    </table>
</sf:form>
