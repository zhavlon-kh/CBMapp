
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

    <c:if test="${contacts.size()>0}">
    <form action="exportordelete" method="post">
    <table border="1">
        <tr>
            <th></th>
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
                <td><input type="checkbox" name="selectedId" value="${contact.id}"></td>
                <td>${contact.name}</td>
                <td>${contact.surname}</td>
                <td>${contact.nickname}</td>
                <td>${dateFormat.format(contact.birthday)}</td>

                <td><c:forEach items="${contact.mobiles}" var="mobile">
                    <ul>${mobile.phoneNumber}</ul>
                </c:forEach></td>

                <td><c:forEach items="${contact.emails}" var="email">
                    <ul>${email.email}</ul>
                </c:forEach></td>

                <td><a href="/contacts/edit/${contact.id}">Edit</a></td>
                <td><a href="/contacts/delete/${contact.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
        <br>
        <button name="delete" value="delete">Delete</button>
        <button name="export" value="export">Export Contacts</button>
    </form>
    </c:if>
</div>
</body>
</html>
