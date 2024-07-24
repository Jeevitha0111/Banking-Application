package com.user.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controller.Connect;
import com.model.Bank;

public class AdminDAO {

    public static boolean createUser(Bank bank) {
        Connection connect = null;
        PreparedStatement st = null;

        try {
            connect = Connect.getConnection();
            System.out.println("Database connection established");

            String sql = "INSERT INTO users (username, password, fullName, address, mobileNo, EmailId, Type, balance, Dob, idProof) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            st = connect.prepareStatement(sql);
            st.setString(1, bank.getUsername());
            st.setString(2, bank.getPassword());
            st.setString(3, bank.getFullName());
            st.setString(4, bank.getAddress());
            st.setString(5, bank.getMobileNumber());
            st.setString(6, bank.getEmail());
            st.setString(7, bank.getType());
            st.setInt(8, bank.getBalance());
            st.setString(9, bank.getDob());
            st.setString(10, bank.getIdNo());

            // Debug: Print the SQL query
            System.out.println("Executing query: " + st);

            int rowsInserted = st.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
            return (rowsInserted > 0);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean deleteUser(int acNo) {
        Connection connect = null;
        PreparedStatement st = null;

        try {
            connect = Connect.getConnection();
            System.out.println("Database connection established");

            String sql = "DELETE FROM users WHERE  AccountNo= ?";
            st = connect.prepareStatement(sql);
            st.setInt(1, acNo);

            // Debug: Print the SQL query
            System.out.println("Executing query: " + st);

            int rowsDeleted = st.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
            return (rowsDeleted > 0);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // Update user method to handle partial updates
    public static boolean updateUser(Bank bank) {
        Connection connect = null;
        PreparedStatement st = null;

        try {
            connect = Connect.getConnection();
            StringBuilder sql = new StringBuilder("UPDATE users SET ");
            boolean first = true;

            if (bank.getPassword() != null) {
                sql.append("password = ?");
                first = false;
            }
            if (bank.getFullName() != null) {
                if (!first) sql.append(", ");
                sql.append("fullName = ?");
                first = false;
            }
            if (bank.getAddress() != null) {
                if (!first) sql.append(", ");
                sql.append("address = ?");
                first = false;
            }
            if (bank.getMobileNumber() != null) {
                if (!first) sql.append(", ");
                sql.append("mobileNo = ?");
                first = false;
            }
            if (bank.getEmail() != null) {
                if (!first) sql.append(", ");
                sql.append("EmailId = ?");
                first = false;
            }
            if (bank.getType() != null) {
                if (!first) sql.append(", ");
                sql.append("Type = ?");
                first = false;
            }
            if (bank.getBalance() != 0) {
                if (!first) sql.append(", ");
                sql.append("balance = ?");
                first = false;
            }
            if (bank.getDob() != null) {
                if (!first) sql.append(", ");
                sql.append("Dob = ?");
                first = false;
            }
            if (bank.getIdNo() != null) {
                if (!first) sql.append(", ");
                sql.append("idProof = ?");
            }
            sql.append(" WHERE username = ?");

            st = connect.prepareStatement(sql.toString());
            int index = 1;

            if (bank.getPassword() != null) st.setString(index++, bank.getPassword());
            if (bank.getFullName() != null) st.setString(index++, bank.getFullName());
            if (bank.getAddress() != null) st.setString(index++, bank.getAddress());
            if (bank.getMobileNumber() != null) st.setString(index++, bank.getMobileNumber());
            if (bank.getEmail() != null) st.setString(index++, bank.getEmail());
            if (bank.getType() != null) st.setString(index++, bank.getType());
            if (bank.getBalance() != 0) st.setInt(index++, bank.getBalance());
            if (bank.getDob() != null) st.setString(index++, bank.getDob());
            if (bank.getIdNo() != null) st.setString(index++, bank.getIdNo());
            st.setString(index++, bank.getUsername());

            int rowsUpdated = st.executeUpdate();
            return (rowsUpdated > 0);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        public static List<Bank> getAllUsers() {
            List<Bank> users = new ArrayList<>();
            Connection connect = null;
            PreparedStatement st = null;
            ResultSet rs = null;

            try {
                connect = Connect.getConnection();
                String sql = "SELECT * FROM users";
                st = connect.prepareStatement(sql);
                rs = st.executeQuery();

                while (rs.next()) {
                    Bank bank = new Bank(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullName"),
                        rs.getString("address"),
                        rs.getString("mobileNo"),
                        rs.getString("EmailId"),
                        rs.getString("Type"),
                        rs.getInt("balance"),
                        rs.getString("Dob"),
                        rs.getString("idProof")
                    );
                    users.add(bank);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
                    }
                    if (connect != null) {
                        connect.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return users;
        }
    
    }

    

