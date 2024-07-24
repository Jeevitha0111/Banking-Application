package com.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Un = request.getParameter("Uname");
        String Upwd = request.getParameter("Pass");
        boolean isValid = validateUser(Un, Upwd);

        if (isValid) {
            // Login successful
            response.sendRedirect("LoginSuccess.html"); // Redirect to a success page
        } else {
            // Login failed
            response.sendRedirect("LoginError.html"); // Redirect to the login page again
        }
    }

    // Method to validate user against MySQL database
    private boolean validateUser(String Un, String Upwd) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL database bankCredentials
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankCredentials", "root", "2003");
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE password = ? AND  username= ?")) {

                // Set parameters for the query
                statement.setString(2, Un);
                statement.setString(1, Upwd);

                // Execute the query
                try (ResultSet result = statement.executeQuery()) {
                    // Check if any row exists in the result set
                    return result.next();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {																																		
            e.printStackTrace();
            return false;
        }
    }
}
