<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 1/24/19
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Create New Contact</title>
</head>
<body>
<h1>Add New Contact</h1>

<form:form method="post" action="save">
    <table>
        <tr>
            <td></td>
            <td><form:hidden  path="id" /></td>
        </tr>

        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Surname :</td>
            <td><form:input path="surname" /></td>
        </tr>
        <tr>
            <td>Nickname :</td>
            <td><form:input path="nickname" /></td>
        </tr>
        <tr>
            <td>Company :</td>
            <td><form:input path="company" /></td>
        </tr>
        <tr>
            <td>Birhtday :</td>
            <td>
                <form:input type="date" path="birthday" class= "date" name = "birhtday" />
            </td>
        </tr>
        <tr>
            <td>Nickname :</td>
            <td>
                <ul>
                    <p>+996550555555</p> <a href="#">Add Mobile</a>
                </ul>
            </td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /> <a href="/contacts/">Cancel</a></td>
        </tr>
    </table>
</form:form>
</body>
</html>
