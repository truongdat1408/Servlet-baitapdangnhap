<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Details User</h2>
<p>ID: ${sessionScope.detailUser.getId()}</p>
<p>Email: ${sessionScope.detailUser.getEmail()}</p>
<p>Email: ${sessionScope.detailUser.getFullname()}</p>
<p>Email: ${sessionScope.detailUser.getAvatar()}</p>
</body>
</html>
