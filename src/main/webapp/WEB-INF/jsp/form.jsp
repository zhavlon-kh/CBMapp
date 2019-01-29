<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>--%>
<html>
<head>
    <title>Create New Contact</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
          integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
          crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.3.1.js"
            integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
            crossorigin="anonymous"></script>
</head>
<body>
<div>
<h1>
    <c:choose>
        <c:when test="${contact.id==0}">
            Add New Contact
        </c:when>
        <c:otherwise>
            Edit Contact
        </c:otherwise>
    </c:choose>
</h1>

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

                <%--Here, dont add space(s) or newline(s) between [div emails], [c:foreach], and [div email] --%>
                <%--otherwise the javascript function checkIn() does not work--%>
                <div id="mobiles"><c:forEach items="${contact.mobiles}" var="mobile"><div class="mobile">
                    <input type="hidden" class="mobilesId" name="mobilesid" value="${mobile.id}"/>
                    <input type="text" class="mobiles" name="mobiles" value="${mobile.phoneNumber}">
                    <button type="button" onclick="deleteThis(this);" class="btn btn-danger"><span class="fas fa-trash-alt"></span> Delete</button>
                </div></c:forEach></div>

                <button type="button" class="btn btn-info" onclick="addMobile()" ><i class="fas fa-plus"></i> Mobile</button>

            </td>
        </tr>
        <tr>
            <td style="vertical-align: top">Emails :</td>

            <td>

                <%--Here, dont add spaces or newline between [div emails], [c:foreach], and [div email] --%>
                <%--otherwise the javascript function checkIn() does not work--%>
                <div id="emails"><c:forEach items="${contact.emails}" var="email"><div class="email">
                            <input type="hidden" class="emailsId" name="emailsid" value="${email.id}"/>
                            <input type="text" class="emails" name="emails" value="${email.email}">
                            <button type="button" onclick="deleteThis(this);" class="btn btn-danger"><span class="fas fa-trash-alt"></span> Delete</button>
                </div></c:forEach></div>

                <button type="button" class="btn btn-info" onclick="addEmail()" ><i class="fas fa-plus"></i> Add Email</button>

            </td>
        </tr>
        <tr>
            <td> </td>
            <td><button type="submit" class="btn btn-success"><i class="far fa-save"></i> Save</button> <a class="btn btn-warning" href="/contacts/">Cancel</a></td>
        </tr>
    </table>

</form>
</div>

<script type='text/javascript'>
    // Containers <div> where dynamic content will be placed
    var emails = document.getElementById("emails");
    var mobiles = document.getElementById("mobiles")

    function addEmail(){
        var block = document.createElement("div");
        block.setAttribute("class","email");
        // Create an <input> element, set its type and name attributes
        var input = document.createElement("input");
        input.type = "email";
        input.name = "emails";
        var deleteButton = document.createElement("button");
        deleteButton.type="button";
        deleteButton.setAttribute("class","btn btn-danger");
        deleteButton.setAttribute("onClick", "javascript: deleteThis(this);");
        deleteButton.innerHTML="<span class=\"fas fa-trash-alt\"></span> Delete";
        block.appendChild(input);
        block.innerHTML += '&nbsp;';
        block.appendChild(deleteButton);
        emails.appendChild(block);
    }

    function addMobile(){
        var block = document.createElement("div");
        block.setAttribute("class","mobile");
        // Create an <input> element, set its type and name attributes
        var input = document.createElement("input");
        input.type = "tel";
        input.name = "mobiles";
        var deleteButton = document.createElement("button");
        deleteButton.type="button";
        deleteButton.setAttribute("class","btn btn-danger");
        deleteButton.setAttribute("onClick", "javascript: deleteThis(this);");
        deleteButton.innerHTML="<span class=\"fas fa-trash-alt\"></span> Delete";
        block.appendChild(input);
        block.innerHTML += '&nbsp;';
        block.appendChild(deleteButton);
        mobiles.appendChild(block);
    }

    function deleteThis(e) {
        e.parentNode.parentNode.removeChild(e.parentNode);
        checkIn();
    }

    function checkIn(){
        if( emails.innerHTML ==="" ) {
            addEmail();
        }
        if (mobiles.innerHTML===""){
            addMobile();
        }
    }

    document.addEventListener("DOMContentLoaded",function (evt) {
       checkIn();
    });

</script>

</body>
</html>
