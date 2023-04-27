<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2023/04/27
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CreatePage</title>
</head>
<body>
createPage.jsp
<br />

<%
    String conPath = request.getContextPath();
//    System.out.println("conPath: " + conPath);
%>

<form action="<%=conPath%>/create">
    작성자 : <input type="text" name="writer" value="${dto.writer}"> <br />
    내용 : <input type="text" name="content" value="${dto.content}"> <br />
    <input type="submit" value="전송"> <br />
</form>

</body>
</html>
