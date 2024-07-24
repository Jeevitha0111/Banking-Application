<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="login">
        <h2>Login Page</h2>
        <form id="login" method="post" action="Loginservlet">
            <label><b>User Name</b></label>
            <input type="text" name="Uname" id="Uname" placeholder="Username" required>
            <label><b>Password</b></label>
            <input type="password" name="Pass" id="Pass" placeholder="Password" required>
            <input type="submit" name="log" id="log" value="Log In Here">
        </form>
    </div>
</body>
</html>
