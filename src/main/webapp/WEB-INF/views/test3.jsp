<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2023/04/17
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Insert Title Here</title>
</head>
<body>
<%
    out.println("#03 : Hello World");
%>
<br>
당신의 아이디는 ${member.id} 입니다. <br>     <!-- 커맨드 객체 변수 member 의 속성값을 이용 -->
당신의 이름은 ${member.name} 입니다.

</body>
</html>
