<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width-device-width, initial-scale = 1.0">
    <title>Edit Profile</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/fontawesome.min.css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet"  href="temp.css">

    <div class="container bootstrap snippets">
        <div class="row">
            <div class="col-xs-12 col-sm-9">
                <form class="form-horizontal" action="save" method="post">
                    <div class="panel panel-default">
                        <div class="panel-body text-center">
                            <img src="https://bootdey.com/img/Content/avatar/avatar6.png" class="img-circle profile-avatar" alt="User avatar">
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">User info</h4>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Username</label>
                                <div class="col-sm-10">
                                    <input type="text" name="username" class="form-control" value = "${user.username}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Name</label>
                                <div class="col-sm-10">
                                    <input type="text" name = "name" class="form-control" value = "${user.name}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Surname</label>
                                <div class="col-sm-10">
                                    <input type="text" name = "surname" class="form-control" value = "${user.surname}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Address</label>
                                <div class="col-sm-10">
                                    <input type="text" name="address" class="form-control" value = "${user.address}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Phone Number</label>
                                <div class="col-sm-10">
                                    <input type="text" name="phone" class="form-control" value="${user.phone}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">E-mail</label>
                                <div class="col-sm-10">
                                    <input type="text" name="email" class="form-control" value="${user.email}">
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--<div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">Security</h4>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Current password</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">New password</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control">
                                </div>
                            </div>
                        </div>
                    </div> -->
                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-2">
                            <button type="save" class="btn btn-primary">Save</button>
                            <!--<button type="reset" class="btn btn-warning">Cancel</button> -->
                            <a href="/profile" class="btn btn-warning"> Cancel </a>
                            <a href="/profile/delete/${user.id}" class="btn btn-danger">Delete</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
