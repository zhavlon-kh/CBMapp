
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
<div>
    <h1>Contacts</h1>
    <div><a href="/contacts/form">Create New Contact</a></div>

    <form action="exportOrDelete">
    <table border="1">
        <tr>
<<<<<<< HEAD
            <th><input type="checkbox" value=""></th>
=======
            <th></th>
>>>>>>> f559489e04ddc1855acf8e61559254b5e65ef7ff
            <th>Name</th>
            <th>Surname</th>
            <th>Nickname</th>
            <th>Birthday</th>
            <th>Mobile</th>
            <th>Email</th>
            <th></th>
            <th></th>
        </tr>


        <c:forEach items="${contacts}" var="contact">
            <tr>
<<<<<<< HEAD
                <td><input type="checkbox" name="selected" value="${contact}"></td>
                <td>${contact.name}</td>
                <td>${contact.surname}</td>
                <td>${contact.nickname}</td>
                <td>${dateFormat.parse(contact.birthday.toString())}</td>
=======
                <td><input type="checkbox" name="selectedId" value="${contact.id}"></td>
                <td>${contact.name}</td>
                <td>${contact.surname}</td>
                <td>${contact.nickname}</td>
                <td>${dateFormat.format(contact.birthday)}</td>
>>>>>>> f559489e04ddc1855acf8e61559254b5e65ef7ff
                <td><c:forEach items="${contact.mobiles}" var="mobile">
                    ${mobile.phoneNumber} <br/>
                </c:forEach></td>
                <td><c:forEach items="${contact.emails}" var="email">
                    ${email.email} <br/>
                </c:forEach></td>
                <td><a href="/contacts/edit/${contact.id}">Edit</a></td>
                <td><a href="/contacts/delete/${contact.id}">Delete</a></td>
            </tr>
        </c:forEach>
        <br>
        <button name="delete" value="delete">Delete</button>
        <button name="export" value="export">Export Contacts</button>
    </table>
    </form>
</div>
</body>
</html>
