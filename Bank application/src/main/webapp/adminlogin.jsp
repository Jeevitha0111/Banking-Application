<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>AdminLogin</h2><br>
    <div class="login">
    <form id="login" method="Post" action="AdminServlet">
        <label><b>User Name
        </b>
        </label>
        <input type="text" name="Uname" id="Uname" placeholder="Username">
        <br><br>
        <label><b>Password
        </b>
        </label>
        <input type="Password" name="Pass" id="Pass" placeholder="Password">
        <br><br>
        <input type="submit" name="log" id="log" value="Log In Here">
        <br><br>
        
    </form>
</div>

</body>
</html>

