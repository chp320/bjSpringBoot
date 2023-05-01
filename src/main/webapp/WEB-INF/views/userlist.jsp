<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2023/04/28
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<%
    out.println("MyBatis: Hello World");
%>
<br>

<c:forEach var="dto" items="${users}">
    ${dto.id} / ${dto.name} <br>
</c:forEach>

</body>
</html>
