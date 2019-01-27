<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
<div>
    <h1>Contacts</h1>
    <div><a href="/contacts/form">Create New Contact</a></div>
    <table border="0">
        <tr>
            <th><input type="checkbox"></th>
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
                <td><input name="selectedcontactsid" type="checkbox" value="${contact.id}"></td>
                <td>${contact.name}</td>
                <td>${contact.surname}</td>
                <td>${contact.nickname}</td>
                <td>${contact.birthday.toString()}</td>
                <td><c:forEach items="${contact.mobiles}" var="mobile">
                    ${mobile.phoneNumber} ${mobile.mobileType} <br/>
                </c:forEach></td>
                <td><c:forEach items="${contact.emails}" var="email">
                    ${email.email} <br/>
                    <div class="btn-group">
                        <button type="button" class="btn btn-lg" id="delete_btn">Delete</button>
                    </div>
                </c:forEach></td>
                <td><a href="/contacts/edit/${contact.id}">Edit</a></td>
                <td><a href="/contacts/delete/${contact.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script>

    $(document).on('click', '#delete_btn', function(){

        if (confirm("Are you sure you want to delete this task?")) {

            var taskId = $('#task_form').find('input[name="id"]').val();
            $.ajax({
                type: "GET",
                url: "<c:url value='/contacts/deleteTask/"+ contactId +"' />",
                success: function(){
                    $('#dialog').dialog('close');
                    $('#calendar').fullCalendar('removeEvents', taskId);
                }
            });
        }
    })
</script>


</html>
