<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2023/05/04
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
</head>
<body>
Welcome : Admin

<hr>

<%--
<c:if test="${not empty pageContext.request.userPrincipal }">
    <p> is Log-In</p>
</c:if>

<c:if test="${empty pageContext.request.userPrincipal }">
    <p> is Log-Out</p>
</c:if>

USER ID : ${pageContext.request.userPrincipal.name} <br>
<a href="logout">Log Out</a> <br>
--%>

<sec:authorize access="isAuthenticated()">
    <p> Log-In</p>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <p> Log-Out</p>
</sec:authorize>

USER ID : <sec:authentication property="name" /> <br>

<c:url value="/logout" var="logoutUrl" />
<a href="${logoutUrl}">Log Out</a> <br>

</body>
</html>
