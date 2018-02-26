<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 13.02.2018
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/StudController">
    id: <input type="text" readonly value="${student.id}">
    first name: <input type="text" value="${student.firstname}">
    last name: <input type="text" value="${student.lastname}">
    tel : <input type="text" value="${student.tel}">
    dob: <input type="date" <fmt:formatDate pattern="yyyy-MM-dd" value="${student.dob}"/>>
    <input type="submit" value="ok">
</form>
</body>
</html>
