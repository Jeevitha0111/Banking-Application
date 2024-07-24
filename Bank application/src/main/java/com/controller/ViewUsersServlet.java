package com.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Bank;
import com.user.DAO.AdminDAO;

@WebServlet("/ViewUsersServlet")
public class ViewUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bank> users = AdminDAO.getAllUsers();
        response.setContentType("text/html");
        response.getWriter().println("<html><body><h1>User Details</h1><table border='1'><tr><th>Username</th><th>Password</th><th>Full Name</th><th>Address</th><th>Mobile Number</th><th>Email</th><th>Type</th><th>Balance</th><th>Date of Birth</th><th>ID Proof</th></tr>");
        
        for (Bank user : users) {
            response.getWriter().println(
                "<tr><td>" + user.getUsername() + "</td>" +
                "<td>" + user.getPassword() + "</td>" +
                "<td>" + user.getFullName() + "</td>" +
                "<td>" + user.getAddress() + "</td>" +
                "<td>" + user.getMobileNumber() + "</td>" +
                "<td>" + user.getEmail() + "</td>" +
                "<td>" + user.getType() + "</td>" +
                "<td>" + user.getBalance() + "</td>" +
                "<td>" + user.getDob() + "</td>" +
                "<td>" + user.getIdNo() + "</td></tr>"
            );
        }

        response.getWriter().println("</table></body></html>");
    }
}
