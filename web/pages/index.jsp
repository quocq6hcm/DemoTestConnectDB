<%--
// ****************************************** ************************************
// **************************    ************ User: MiTom
// *****************************    ********* Phone: 0966 941 840
// ********************************    ****** Email: 
// ****************************************** ************************************
// *****       ********       ******    ***** Package: ${PACKAGE_NAME}
// *****        ******        ******    ***** Project: DemoTestConnectDB
// *****    *    ****    *    ******    ***** Date: 14-Nov-17
// *****    **    **    **    ******    ***** Time: 09:01
// *****    ***        ***    ******    ***** Name: ${NAME}
// *****    **************    ******    ***** ************************************
// *****    **************    ******    ***** Created by IntelliJ IDEA.
// ****************************************** ************************************
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>

<table border="1" cellspacing="0" cellpadding="5">
    <caption><h1>List of Users</h1></caption>
    <thead>
    <tr>
        <td>username</td>
        <td>FullName</td>
        <td>Photo</td>
        <td>Email</td>
        <td>level</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listUser}" var="e">
        <tr>
            <td>${e.username}</td>
            <td>${e.fullName}</td>
            <td><img src="resources/images/${e.photo}" alt="${e.photo}" height="80px"></td>
            <td>${e.email}</td>
            <td>${e.level}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<button onclick="window.location.href='views/CreateEmployee.jsp'">Add new</button>
</body>
</html>
