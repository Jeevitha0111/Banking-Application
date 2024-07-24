<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update User Details</title>
</head>
<body>
    <h1>Update User Details</h1>
    <div class="update">
    <form id="update" action="AdminServlet" method="post">
        <input type="hidden" name="action" value="update">

        <label for="username">User name:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>

        <label for="name">Full Name:</label>
        <input type="text" id="name" name="name"><br><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address"><br><br>

        <label for="mobNo">Mobile Number:</label>
        <input type="text" id="mobNo" name="mobNo"><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email"><br><br>

        <label for="type">Type:</label>
        <input type="text" id="type" name="type"><br><br>

        <label for="Balance">Balance:</label>
        <input type="number" id="Balance" name="Balance"><br><br>

        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob"><br><br>

        <label for="idNo">ID Number:</label>
        <input type="text" id="idNo" name="idNo"><br><br>

        <input type="submit" onclick="submitForm('update')" value="Update User">
    </form>
    </div>
<script>
        function submitForm(action) {
            var form = document.getElementById('update');
            var actionInput = document.createElement('input');
            actionInput.type = 'hidden';
            actionInput.name = 'action';
            actionInput.value = action;
            form.appendChild(actionInput);
            form.submit();
        }
    </script>
</body>
</html>
