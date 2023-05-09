<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2023/05/10
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="/webjars/bootstrap/5.1.0/css/bootstrap.min.css">
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.1.0/js/bootstrap.min.js"></script>

<%--    <link rel="stylesheet" href="../resources/webjars/bootstrap/5.1.0/css/bootstrap.min.css">--%>
<%--    <script src="../resources/webjars/jquery/3.6.0/jquery.min.js"></script>--%>
<%--    <script src="../resources/webjars/bootstrap/5.1.0/js/bootstrap.min.js"></script>--%>

<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.0/css/bootstrap.min.css">--%>
<%--    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.min.js"></script>--%>
<%--    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.1.0/js/bootstrap.min.js"></script>--%>

</head>
<body>

경로: ${pageContext.request.contextPath}

<p>
    <button type="button" class="btn btn-lg btn-default">Default</button>
    <button type="button" class="btn btn-lg btn-primary">Primary</button>
    <button type="button" class="btn btn-lg btn-success">Success</button>
    <button type="button" class="btn btn-lg btn-info">Info</button>
    <button type="button" class="btn btn-lg btn-warning">Warning</button>
    <button type="button" class="btn btn-lg btn-danger">Danger</button>
    <button type="button" class="btn btn-lg btn-link">Link</button>
</p>
</body>
</html>
