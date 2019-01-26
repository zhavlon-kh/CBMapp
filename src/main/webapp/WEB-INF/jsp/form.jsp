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
    <script>
        $(document)


        $(document)
            .ready(
                function() {
                    var wrapper = $(".myFields");
                    <%--<c:forEach items="${contact.emails}" var="email">
                        $(wrapper)
                            .append(
                                '<div class="form-group"><label class="col-md-2" for="email">Email</label><input type="text" name="mytext[]" class="col-md-6"/><a href="#"   class="btn btn-danger btn-sm delFld"><span class="fas fa-trash-alt"></span>Delete</a></div>'); //add input box
                    </c:forEach>--%>
                    $('#add_button')
                        .click(
                            function(e) {
                                e.preventDefault();
                                $(wrapper)
                                    .append(
                                        '<div class="form-group">' +
                                        '<label class="col-md-2" for="person">Person Name</label>' +
                                        '<input type="text" name="mytext[]" class="col-md-6"/>' +
                                            '<a href="#"   class="btn btn-danger btn-sm delFld">' +
                                        '<span class="fas fa-trash-alt"></span>Delete</a></div>'); //add input box
                            });

                    $(wrapper).on("click", ".delFld", function(e) {
                        e.preventDefault();
                        $(this).parent('div').remove();
                    })
                });
    </script>
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

            </td>
        </tr>
        <tr>
            <td style="vertical-align: top">Emails :</td>
            <td >
                <div class="container">
                <div class="myField"/>
                    <button id="add_button" class="addNew btn btn-success btn-sm">
                        <span class="fa fa-plus"></span>Add New
                    </button>
                </div>

            </td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /> <a href="/contacts/">Cancel</a></td>
        </tr>
    </table>

    <%--<div class="container">
        <div class="myFields"></div>
        <button id="add_button" class="addNew btn btn-success btn-sm">
            <span class="fa fa-plus"></span>Add New
        </button>
    </div>--%>
</form>
</body>
</html>
