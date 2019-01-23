
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
<div>
    <h1>Hello World!</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Nickname</th>
            <th>Mobile</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${contacts}" var="contact">
            <tr>
                <td>${contact.name}</td>
                <td>${contact.surname}</td>
                <td>${contact.nickname}</td>
                <td><c:forEach items="${contact.mobiles}" var="mobile">
                    ${mobile.phoneNumber} ${mobile.mobileType} <br/>
                </c:forEach></td>
                <td><c:forEach items="${contact.emails}" var="email">
                    ${email.email} <br/>
                </c:forEach></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
