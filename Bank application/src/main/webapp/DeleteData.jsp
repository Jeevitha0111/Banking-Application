<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Account</title>
</head>
<body>
<h2>Create</h2><br>
<div class="delete">
    <form id="delete" method="post" action="AdminServlet">
        
        <label><b>Full Name</b></label>
        <input type="text" name="name" id="name" placeholder="Enter Full Name" >
        <br><br>
        
        <label><b>Address</b></label>
        <input type="text" name="address" id="address" placeholder="Enter Address" >
        <br><br>
        
        <label><b>Mobile Number</b></label>
        <input type="text" name="mobNo" id="mobNo" placeholder="Enter Mobile Number" >
        <br><br>
        
        <label><b>Email ID</b></label>
        <input type="text" name="email" id="email" placeholder="Enter Email ID" >
        <br><br>
        
        <label><b>Type</b></label>
        <input type="text" name="type" id="type" placeholder="Enter type of Account" >
        <br><br>
        
        <label><b>Initial Balance</b></label>
        <input type="number" name="Balance" id="Balance" placeholder="Enter Initial Balance" >
        <br><br>
        
        <label><b>Date of Birth</b></label>
        <input type="text" name="dob" id="dob" placeholder="Enter Date of Birth" >
        <br><br>
        
        <label><b>ID No</b></label>
        <input type="text" name="idNo" id="idNo" placeholder="Enter ID No" >
        <br><br>
        
        <label><b>User Name</b></label>
        <input type="text" name="username" id="username" placeholder="Create Username" >
        <br><br>
        
        <label><b>Password</b></label>
        <input type="text" name="password" id="password" placeholder="Create Password" >
        <br><br>
        
        <input type="submit"  onclick="CreateAccount.html" value="Back"><br></br>
        
        <label><b>Account Number</b></label>
        <input type="number" name="accountno" id="accountno" placeholder="Enter accountno" required>
        <br><br>
        
        
        <input type="submit"  onclick="submitForm('delete')" value="Delete User">
        <br><br>
        
    </form>
</div>
<script>
        function submitForm(action) {
            var form = document.getElementById('delete');
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
