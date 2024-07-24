<%@ page import="java.util.List" %>
<%@ page import="com.user.DAO.TransactionDAO" %>
<%@ page import="com.model.Transaction" %>

<html>
<head>
    <title>Transaction History</title>
</head>
<body>
    <h1>Transaction History</h1>
    
    <form method="get" action="transactionHistory">
        <label for="accountNo">Account Number:</label>
        <input type="text" id="accountNo" name="accountNo" required>
        <input type="submit" value="View Transactions">
    </form>
    
    <%
        String accountNoStr = request.getParameter("accountNo");
        if (accountNoStr != null && !accountNoStr.trim().isEmpty()) {
            try {
                int accountNo = Integer.parseInt(accountNoStr);
                List<Transaction> transactions = TransactionDAO.getTransactionsByAccountNo(accountNo);
    %>
    <h2>Transactions for Account Number: <%= accountNo %></h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Type</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <%
                if (transactions.isEmpty()) {
            %>
            <tr>
                <td colspan="5">No transactions found for this account number.</td>
            </tr>
            <%
                } else {
                    for (Transaction transaction : transactions) {
            %>
            <tr>
                <td><%= transaction.getTransactionID() %></td>
                <td><%= transaction.getType() %></td>
                <td><%= transaction.getAmount() %></td>
                <td><%= transaction.getDate() %></td>
                <td><%= transaction.getDescription() %></td>
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
    <%
            } catch (NumberFormatException e) {
                out.println("<p style='color:red;'>Invalid account number format.</p>");
            }
        }
    %>
</body>
</html>
