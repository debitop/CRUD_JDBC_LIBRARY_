<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 13.02.2018
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="2">

    <thead>
    <tr>
        <th>Stud Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>tel</th>
        <th>Dob</th>
        <th colspan="2">Actions</th>

    </tr>
    </thead>
    //цикл
    <c:forEach items="${students}" var="temp">


    <tr>
        <td><c:out value="${temp.id}"/></td>
        <td><c:out value="${temp.firstname}"/></td>
        <td><c:out value="${temp.lastname}"/></td>
        <td><c:out value="${temp.tel}"/></td>
        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${temp.dob}"/></td>
        <td><a href="/StudentController?action=delete&studId=${temp.id}">Delete</a></td>
        <td><a href="/StudentController?action=edit&studId=${temp.id}">Edit</a></td>


    </tr>
    </c:forEach>

</table>
<p><a href="/StudentController?action=create">Create Stud</a></p>

</body>
</html>
