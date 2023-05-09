<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2023/05/05
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LoginForm</title>
</head>
<body>
<h1>loginForm.jsp</h1>

<%--&lt;%&ndash;<form-login action="<c:url value='j_spring_security_check' />" method="post">&ndash;%&gt;--%>
<%--<form action="<spring:url value="j_spring_security_check" />" method="post">--%>
<%--  ID : <input type="text" name="j_username"> <br>--%>
<%--  PW : <input type="text" name="j_password"> <br>--%>
<%--  <input type="submit" value="LOGIN"> <br>--%>
<%--&lt;%&ndash;</form-login>&ndash;%&gt;--%>
<%--</form>--%>


<spring:url value="j_spring_security_check" var="loginUrl"/>
<form action="${loginUrl}" method="post">
    <c:if test="${param.error != null}">
        <p>
            Login Error! <br>
            ${error_message}
        </p>
    </c:if>
    ID : <input type="text" name="j_username" value="${username}"> <br>
    PW : <input type="text" name="j_password"> <br>
    <input type="submit" value="LOGIN"> <br>
</form>

</body>
</html>
