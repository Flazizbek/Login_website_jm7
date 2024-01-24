<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./index.css">
</head>
<body class="auth_body">
<c:choose>
    <c:when test="${param.action eq 'signup'}">
        <div class="container">
            <form class="form_container" action="${pageContext.request.contextPath}/auth?action=signup" method="post">
                <label>
                    Username : <input type="text" name="username">
                </label>
                <label>
                    Email : <input type="email" name="email">
                </label>
                <label>
                    Password : <input type="password" name="password">
                </label>
                <label>
                    <input class="submit_button" type="submit" value="Sign Up">
                </label>
                <div>
                    <p>
                        Already have account?
                    </p>
                    <a href="${pageContext.request.contextPath}/auth?action=signin">Sign In</a>
                </div>
            </form>
        </div>
    </c:when>
    <c:otherwise>
        <div class="container">
            <form class="form_container" action="${pageContext.request.contextPath}/auth?action=signin" method="post">
                <label>
                    Email : <input type="email" name="email">
                </label>
                <label>
                    Password : <input type="password" name="password">
                </label>
                <label>
                    <input class="submit_button" type="submit" value="Login">
                </label>
                <div>
                    <p>
                        Already have account?
                    </p>
                    <a href="${pageContext.request.contextPath}/auth?action=signup">Sign Up</a>
                </div>
            </form>
        </div>
    </c:otherwise>

</c:choose>

<c:if test="${not empty requestScope.error}">
    <div class="error">
        <p>${requestScope.error}</p>
    </div>
</c:if>
<div>
${sessionScope.user}
</div>


</body>
</html>
