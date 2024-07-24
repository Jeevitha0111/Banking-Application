<!DOCTYPE html>
<html>
<head>
    <title>Withdrawal</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <form id="bankForm" method="post" action="BankServlet">
        <label for="username">User Name: </label>
        <input type="text" id="username" name="username" placeholder="Enter username" required><br>
        
        <label for="password">Password: </label>
        <input type="password" id="password" name="password" placeholder="Enter password" required><br>

        <label for="accountNumber">Account Number: </label>
        <input type="number" id="accountNumber" name="accountNumber" placeholder="Enter account number" required><br>
        
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" placeholder="Enter amount"><br>

        <div>
            <button type="button" onclick="submitForm('withdraw')">Withdraw</button>
            <button type="button" onclick="submitForm('checkBalance')">Check Balance</button>
        </div>
    </form>

    <script>
        function submitForm(action) {
            var form = document.getElementById('bankForm');
            var username = document.getElementById('username').value;
            var password = document.getElementById('password').value;
            var accountNumber = document.getElementById('accountNumber').value;
            var amount = document.getElementById('amount').value;

            if (username && password && accountNumber && (action !== 'withdraw' || amount)) {
                var actionInput = document.createElement('input');
                actionInput.type = 'hidden';
                actionInput.name = 'action';
                actionInput.value = action;
                form.appendChild(actionInput);
                form.submit();
            } else {
                alert('Please fill in all required fields.');
            }
        }
    </script>
</body>
</html>
