<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<table border="1">

    <tr>
        <th>id</th>
        <th>userId</th>
        <th>author</th>
        <th>title</th>
    </tr>
<c:forEach items="${books}" var="temp">
    <tr>
        <td> <c:out value="${temp.id}"></c:out> </td>
        <td> <c:out value="${temp.userid}"></c:out> </td>
        <td> <c:out value="${temp.author}"></c:out> </td>
        <td> <c:out value="${temp.title}"></c:out> </td>
        <td><a href="/BookController?action=edit&bookId=${temp.id}&studId=${temp.userid}">Edit</a> </td>
        <td><a href="/BookController?action=delete&bookId=${temp.id}&studId=${temp.userid}">Delete</a> </td>

    </tr>
</c:forEach>
</table>

<a href="/BookController?action=create&studId=${studId}">Create Book</a>
<a href="/StudentController?action=list">Students</a>
</body>
</html>
