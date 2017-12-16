<%--
  Created by IntelliJ IDEA.
  User: quocq
  Date: 12/16/2017
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="LoginServlet" method="post">
        username: <br/>
        <input type="text" name="username">
        <br/>
        password: <br/>
        <input type="password" name="password"/>
        <br/>
        <input type="submit" value="Login"></input>
        <br/>
    </form>
</body>
</html>
