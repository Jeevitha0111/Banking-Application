<!DOCTYPE html>
<html>
<head>
    <title>Bank Management</title>
</head>
<link rel="stylesheet" href="styles.css">
<body>

    <form id="bankForm" method="post" action="BankServlet">
        <label for="accountNumber">Account Number:</label>
        <input type="number" id="accountNumber" name="accountNumber" placeholder="Enter account number" required><br>

        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" placeholder="Enter amount"><br>

        <div >
            <button type="button" onclick="submitForm('deposit')">Deposit</button>
        </div>
    </form>

    <script>
        function submitForm(action) {
            var form = document.getElementById('bankForm');
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
