<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>

    <!-- Bootstrap components -->
    <!-- Latest compiled and minified Jquery -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>

    <!--Latest compiled and minified Popper -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
            integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
            crossorigin="anonymous"></script>

    <!-- Latest compiled and minified CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <!-- End of Bootstrap components -->

    <link rel="stylesheet" type="text/css" href="/static/css/main.css"/>

</head>
<body background="static/img/background.jpg">

<div align="center" class="text-warning>">


    <div class="container text-warning">
        <h1 class="text-warning>">Employee Login Form</h1>
        <p>Please enter your username and password</p>
        <form class="form-group mx-sm-3 mb-2" action="<%=request.getContextPath()%>/login" method="post">
            <label class="sr-only">Username</label>
            <input type="text" class="form-control" name="username" placeholder="Username" id="username" required>
            <label class="sr-only">Password</label>
            <input type="password" class="form-control" name="password" placeholder="Password" id="password"
                   required>
            <input type="checkbox" value="checked"><b>Remember</b>
            <input class="btn btn-success" type="submit" value="Login" class="form-control btn btn-primary  " name="">
        </form>
        <p>You don't have an account?
            <button class="btn btn-warning " onclick="location.href='emp-register.jsp'" style="height:auto;">Register
            </button>
        </p>
    </div>
</div>

</body>
</html>