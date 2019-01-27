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
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>--%>
<html>
<head>
    <title>Create New Contact</title>
</head>
<body>
<h1>Add New Contact</h1>

<form method="post" action="save">
    <table>
        <tr>
            <td></td>
            <td><input type="hidden" name="id" value="${contact.id}" /></td>
        </tr>

        <tr>
            <td>Name : </td>
            <td><input type="text" name="name" value="${contact.name}"/> </td>
        </tr>
        <tr>
            <td>Surname :</td>
            <td><input type="text" name="surname" value="${contact.surname}"/></td>
        </tr>
        <tr>
            <td>Nickname :</td>
            <td><input type="text" name="nickname" value="${contact.nickname}"/></td>
        </tr>
        <tr>
            <td>Company :</td>
            <td><input type="text" name="company" value="${contact.company}"/></td>
        </tr>
        <tr>
            <td>Birhtday :</td>
            <td>
                <input type="date" name = "birthday" value="${birthday}"/> <br>
            </td>
        </tr>
        <tr>
            <td>Mobile :</td>
            <td>
                <c:forEach items="${contact.mobiles}" var="mobile">
                    <ul>
                        <input type="text" name="mobiles" value="${mobile.phoneNumber}">
                        <button> Edit</button>
                        <button>Delete</button>
                    </ul>
                </c:forEach>
                <input type="text" name="newMobile">
            </td>
        </tr>
        <tr>
            <td style="vertical-align: top">Emails :</td>
            <td>
                <input type="hidden" id="oldEmails" value="${contact.emails}">
                <c:forEach items="${contact.emails}" var="email">
                    <div class="emails">
                        <div>
                        <input type="hidden" class="emailsId" name="emailsid" value="${email.id}"/>
                        <input type="text" class="emails" name="emails" value="${email.email}">
                        <a onclick="$.fn.myFunction();" href="#" class="btn btn-danger">Delete</a>
                        </div>
                    </div>
                </c:forEach>

                <%--<div id="email_items"/>
                <button id="add_email" onclick="">Add</button>--%>
            </td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /> <a href="/contacts/">Cancel</a></td>
        </tr>
    </table>
</form>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

    function addInput() {
        $('#email_items').append('<div><input type="text" name="email"/><input type="button" value="Delete" id="delete"/>');
    };

    $(document).load(function () {
        /*var oldemails = document.getElementById('#oldEmails');
        console.log(typeof oldemails);*/

       /* for(email in oldemails){
            $('#email_items').append('<div><input type="text" name="email" value="'+email+'"/>' +
                '<button onclick=" detete()" id="delete">Delete</button>');
        }*/

       $.fn.addEmail = function(){
           $(".emails").append("");
       }

        $.fn.myFunction = function(){
            $(this).parent("div").delete();
        }

    });

</script>

</body>
</html>
