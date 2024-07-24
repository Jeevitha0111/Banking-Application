package com.user.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.controller.Connect;
import com.model.Transaction;

public class TransactionDAO {

    private static final Logger LOGGER = Logger.getLogger(TransactionDAO.class.getName());
    
    public static List<Transaction> getTransactionsByAccountNo(int accountNo) {
        List<Transaction> transactions = new ArrayList<>();
        Connection connect = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            connect = Connect.getConnection();
            if (connect == null) {
                LOGGER.severe("Failed to obtain database connection.");
                return transactions;
            }

            String sql = "SELECT * FROM transactions WHERE AccountNo = ?";
            st = connect.prepareStatement(sql);
            st.setInt(1, accountNo);
            rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("TransactionID");
                String type = rs.getString("type");
                int amount = rs.getInt("amount");
                String date = rs.getString("date");
                String description = rs.getString("description");
                Transaction transaction = new Transaction(id, accountNo, type, amount, date, description);
                transactions.add(transaction);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching transactions", e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error closing resources", e);
            }
        }
        return transactions;
    }

    public static void logTransaction(int acNo, String type, int amount, String description) {
        Connection connect = null;
        PreparedStatement st = null;

        try {
            connect = Connect.getConnection();
            if (connect == null) {
                LOGGER.severe("Failed to obtain database connection.");
                return;
            }

            String sql = "INSERT INTO transactions (AccountNo, type, amount, description) VALUES (?, ?, ?, ?)";
            st = connect.prepareStatement(sql);
            st.setInt(1, acNo);
            st.setString(2, type);
            st.setInt(3, amount);
            st.setString(4, description);
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Transaction logged successfully: " + type + " of amount " + amount + " for account " + acNo);
            } else {
                LOGGER.warning("No rows affected while logging transaction.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error logging transaction", e);
        } finally {
            try {
                if (st != null) st.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error closing resources", e);
            }
        }
    }
}
