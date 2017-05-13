<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<table class="offers">
    <tr>
        <td>Name</td><td>Email</td><td>Offer</td>
    </tr>
    <c:forEach var="offer" items="${offers}">
        <tr>
            <td>
                <c:out value="${offer.user.name}"></c:out>
            </td>
            <td>
                <c:out value="${offer.user.email}"></c:out>
            </td>
            <td>
                <c:out value="${offer.text}"></c:out>
            </td>
        </tr>

    </c:forEach>
</table>

<c:choose>
    <c:when test="${hasOffer}">
        <p><a href="${pageContext.request.contextPath}/createOffer">Edit or Delete offer.</a></p>
    </c:when>
    <c:otherwise>
        <p><a href="${pageContext.request.contextPath}/createOffer">Add a new offer.</a></p>
    </c:otherwise>
</c:choose>


<sec:authorize access="hasAnyAuthority('ROLE_ADMIN')">
    <p><a href="<c:url value="/admin"/>"/>Admin</p>
</sec:authorize>