package com.user.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.controller.Connect;

public class UserDAO {

    public class BankManagement {

        private static final int NULL = 0;
        static Connection connect = Connect.getConnection();
        static String sql = "";

        public static boolean deposit(int acNo, int amount) {
            PreparedStatement st = null;
            ResultSet rs = null;

            try {
                // Check if the account number exists
                sql = "SELECT 1 FROM users WHERE AccountNo = ?";
                st = connect.prepareStatement(sql);
                st.setInt(1, acNo);
                rs = st.executeQuery();

                if (!rs.next()) {
                    // Account number does not exist
                    return false;
                }

                // Account number exists, proceed with deposit
                sql = "UPDATE users SET balance = balance + ? WHERE AccountNo = ?";
                st = connect.prepareStatement(sql);
                st.setInt(1, amount);
                st.setInt(2, acNo);
                st.executeUpdate();

                // Log the transaction
                TransactionDAO.logTransaction(acNo, "Deposit", amount, "Deposited money");

                return true;

                

            } catch (SQLException e) {
                e.printStackTrace();
                return false;

            } finally {
                // Properly close the resources
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public static boolean withdraw(String username, String password, int amount) {
            PreparedStatement st = null;
            ResultSet rs = null;

            try {
                sql = "SELECT * FROM users WHERE username = ? AND password = ?";
                st = connect.prepareStatement(sql);
                st.setString(1, username);
                st.setString(2, password);
                rs = st.executeQuery();

                if (rs.next()) {
                    int currentBalance = rs.getInt("balance");

                    if (currentBalance >= amount) {
                        sql = "UPDATE users SET balance = balance - ? WHERE username = ? AND password = ?";
                        st = connect.prepareStatement(sql);
                        st.setInt(1, amount);
                        st.setString(2, username);
                        st.setString(3, password);
                        st.executeUpdate();

                        // Log the transaction
                        TransactionDAO.logTransaction(rs.getInt("AccountNo"), "Withdraw", amount, "Withdrew money");

                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return false;

            } finally {
                try {
                    if (rs != null) rs.close();
                    if (st != null) st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public static int getBalance(int acNo) {
            int balance = NULL;
            sql = "SELECT balance FROM users WHERE AccountNo = ?";

            try (PreparedStatement st = connect.prepareStatement(sql)) {
                st.setInt(1, acNo);

                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        balance = rs.getInt("balance");
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return balance;
        }

        
        }
    }
