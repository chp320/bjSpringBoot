<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2023/05/04
  Time: 11:40 PM
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
Welcome : Member

<hr>

<%--
<!-- 로그인 상태: request.userPrincipal 에 사용자의 로그인 정보가 들어있다 -->
<c:if test="${not empty pageContext.request.userPrincipal }">
    <p> is Log-In</p>
</c:if>

<!-- 비로그인 상태: request.userPrincipal 에 사용자의 로그인 정보가 없다 -->
<c:if test="${empty pageContext.request.userPrincipal }">
    <p> is Log-Out</p>
</c:if>
--%>

<!-- 스프링 시큐리티 관련 jstl 사용 -->
<sec:authorize access="isAuthenticated()">
    <p> Log-In</p>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <p> Log-Out</p>
</sec:authorize>

<%--
USER ID : ${pageContext.request.userPrincipal.name} <br>
<a href="/logout">Log Out</a> <br>
--%>

USER ID : <sec:authentication property="name" /><br>

<c:url var="logoutUrl" value="/logout" />
<a href="${logoutUrl}">Log Out</a><br>



</body>
</html>
