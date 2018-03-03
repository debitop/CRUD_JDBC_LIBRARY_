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

<form method="POST" action="/BookController">
    bookId: <input name="bookId" type="text" readonly value="${book.id}"><br>
    userId: <input name="studId" type="text" readonly value="${studId}"><br>
    author: <input name="author" type="text" value="${book.author}"><br>
    title : <input name="title" type="text" value="${book.title}"><br>
        <input type="submit" value="ok">
</form>

</body>
</html>
