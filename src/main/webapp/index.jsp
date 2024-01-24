<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="./index.css">
</head>
<body>
<div class="div_class">
    <h1> Welcome to our website </h1>
    <h2>Please register to use th website</h2>
    <a href="${pageContext.request.contextPath}/auth?action=signup">Sign Up</a>
</div>

<br>
</body>
</html>
