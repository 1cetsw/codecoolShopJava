<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>


    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script src="/WEB-INF/validation/jlogin.js"></script>
    <script src="/WEB-INF/css/clogin.css"></script>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Fonts -->
    <link rel="dns-prefetch" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">



    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <title> Login Form</title>
</head>
<body>

<nav class="navbar navbar-expand-lg  navbar-laravel" style="background-color:#FFFFFF">
    <div class="container">
        <a class="navbar-brand" href="#" style="color:white"> Login Form</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <form   name="my-form-3"  action="./menulogin" method="post">
                    <li class="nav-item">
                        <button type="submit" name="login" class="btn" style="background-color:#FFFFFF;color:#0000FF">
                            <b> Login</b>
                        </button>
                    </li></form>
                <form   name="my-form-4"  action="./menuregister" method="post">
                    <li class="nav-item">
                        <button type="submit" name="register" class="btn" style="background-color:#FFFFFF;color:#0000FF">
                            <b> Register</b>
                        </button>
                    </li></form>
            </ul>

        </div>
    </div>
</nav>

<main class="my-form">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header" style="background-color:#0000FF;color:#FFFFFF;"><b>Login</b></div>
                    <div class="card-body">
                        <form class="needs-validation"  name="my-form" action="./RetrieveFromDB" method="post">



                            <div class="form-group row">
                                <label for="emailaddress" class="col-md-4 col-form-label text-md-right"><b>E-Mail Address</b></label>
                                <div class="col-md-6">
                                    <input type="text" id="emailaddress" class="form-control" name="emailaddress" placeholder="Email Address"  required>
                                </div>

                            </div>


                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right"> <b>Password</b></label>
                                <div class="col-md-6">
                                    <input type="password" id="d_pass" class="form-control" name="password" placeholder="Password"  required>
                                </div>
                            </div>

                            <div class="col-md-6 offset-md-4">
                                <button type="submit" class="btn" style="background-color:#0000FF;color:#FFFFFF;" >
                                    <b>Login</b>
                                </button>
                            </div>

                            <span style = "color:red;"> ${errMsg}</span>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


</main>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>