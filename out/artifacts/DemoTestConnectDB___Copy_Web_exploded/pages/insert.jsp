<%-- 
    Document   : insert
    Created on : Nov 16, 2017, 11:40:39 AM
    Author     : hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Add New User1111</h1>
<form action="InsertServlet" method="post" enctype="multipart/form-data">
    Username:<input type="text" id="username" name="username"/> <br>
    Password:<input type="password" id="password" name="password"/><br>
    Full name:<input type="text" id="fullname" name="fullname"/><br>
    Photo:<input type="file" id="photo" name="photo"/><br>
    Email:<input type="email" id="email" name="email"/><br>
    Level:<input type="number" id="level" name="level"/><br>
    <input type="submit" value="Create">
</form>
</body>
</html>
