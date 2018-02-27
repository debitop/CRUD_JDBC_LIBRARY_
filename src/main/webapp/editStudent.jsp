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

<form method="POST" action="/StudentController">
    id: <input name="studId" type="text" readonly value="${student.id}"><br>
    first name: <input name="firstname" type="text" value="${student.firstname}"><br>
    last name: <input name="lastname" type="text" value="${student.lastname}"><br>
    tel : <input name="tel" type="text" value="${student.tel}"><br>
    dob: <input name="dob" type="date" <fmt:formatDate pattern="yyyy-MM-dd" value="${student.dob}"/>><br>
    <input type="submit" value="ok">
</form>
</body>
</html>
