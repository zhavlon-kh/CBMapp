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
            <td style="vertical-align: top">Mobile :</td>
            <td>
                <form name="mobiles" class="mobiles">
                    <div>
                        <c:forEach items="${contact.mobiles}" var="mobile">
                            <div>
                                <input type="text" name="phoneNumber" value="${mobile.phoneNumber}">
                                <button type="button">Delete</button>
                            </div>
                        </c:forEach>

                    </div>
                </form>

            </td>
        </tr>
        <tr>
            <td style="vertical-align: top">Emails :</td>
            <td>

                <div id="emails">
                    <c:forEach items="${contact.emails}" var="email">
                        <div class="email">
                            <input type="hidden" class="emailsId" name="emailsid" value="${email.id}"/>
                            <input type="text" class="emails" name="emails" value="${email.email}">
                            <button type="button" onclick="deleteEmail(this);" class="btn btn-danger">Delete</button>
                        </div>
                    </c:forEach>
                </div>

                <button type="button" class="btn" onclick="addEmail()" >Add Email</button>
            </td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /> <a href="/contacts/">Cancel</a></td>
        </tr>
    </table>
</form>


<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

    var deleteThis = function(){
            $(this).delete();
        }



    $(document).load(function () {
        $('#emails').append('<div class="email"> <input type="text" name="emails"> <button type="button" onclick="$.fn.deleteFunction();" class="btn btn-danger">Delete</button> </div>');


        $.fn.addEmail = function(){
           $('#emails').append('<div class="email"> <input type="text" name="emails"> <button type="button" onclick="$.fn.deleteFunction();" class="btn btn-danger">Delete</button> </div>');

            /*var oldemails = document.getElementById('#oldEmails');
         console.log(typeof oldemails);*/

            /* for(email in oldemails){
                 $('#email_items').append('<div><input type="text" name="email" value="'+email+'"/>' +
                     '<button onclick=" detete()" id="delete">Delete</button>');
             }*/
        }

        /*function addInput() {
       $('#emails').append('<div class="email"> <input type="text" name="emails"> <button type="button" onclick="$.fn.deleteFunction();" class="btn btn-danger">Delete</button> </div>');
   };*/

    });

</script>--%>

<script type='text/javascript'>
    function addEmail(){
        // Container <div> where dynamic content will be placed
        var emails = document.getElementById("emails");
        // Append a line break
        var block = document.createElement("div");
        block.class = "email";
        // Create an <input> element, set its type and name attributes
        var input = document.createElement("input");
        input.type = "email";
        input.name = "emails";
        var deleteButton = document.createElement("button");
        deleteButton.type="button";
        deleteButton.setAttribute("onClick", "javascript: deleteEmail(this);");
        deleteButton.innerHTML="Delete";
        block.appendChild(input);
        block.appendChild(deleteButton);
        emails.appendChild(block);
    }

    function deleteEmail(e) {
        e.parentNode.parentNode.removeChild(e.parentNode);
    }

</script>

</body>
</html>
