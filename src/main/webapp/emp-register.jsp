<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration New User</title>

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
<div align="center" class="text-warning">
    <h1 class="text-warning" >Employee Register Form</h1>
    <form class="form-group col-md-6" action="<%= request.getContextPath() %>/register" method="post">
        <table style="with: 80%" class="text-warning">
            <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName" placeholder="First Name"/></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastName" placeholder="Last Name" /></td>
            </tr>
            <tr>
                <td>UserName</td>
                <td><input type="text" name="username" placeholder="User Name"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" placeholder="Password"/></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" placeholder="Adress"/></td>
            </tr>
            <tr>
                <td>Phone number</td>
                <td><input type="text" name="contact" placeholder="Phone number" /></td>
            </tr>
        </table>
        <input class="btn btn-success" type="submit" value="Register" />
    </form>
    <p>You have account? ?  <button class="btn btn-warning" onclick="location.href='emp-login.jsp'" style="height:auto;">Login</button></p>
</div>
</body>
</html>