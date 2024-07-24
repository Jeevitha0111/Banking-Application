package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Bank;
import com.user.DAO.AdminDAO;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                createUser(request, response);
                break;
            case "update":
                updateUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            default:
                response.getWriter().println("Invalid action!");
                break;
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("name");
        String address = request.getParameter("address");
        String mobileNumber = request.getParameter("mobNo");
        String email = request.getParameter("email");
        String type = request.getParameter("type");
        int balance = Integer.parseInt(request.getParameter("Balance"));
        String dob = request.getParameter("dob");
        String idNo = request.getParameter("idNo");

        Bank bank = new Bank(username, password, fullName, address, mobileNumber, email, type, balance, dob, idNo);
        boolean result = AdminDAO.createUser(bank);
        if (result) {
            response.getWriter().println("Account created successfully!");
        } else {
            response.getWriter().println("Account creation failed!");
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("name");
        String address = request.getParameter("address");
        String mobileNumber = request.getParameter("mobNo");
        String email = request.getParameter("email");
        String type = request.getParameter("type");
        int balance = 0;
        if (request.getParameter("Balance") != null && !request.getParameter("Balance").isEmpty()) {
            balance = Integer.parseInt(request.getParameter("Balance"));
        }
        String dob = request.getParameter("dob");
        String idNo = request.getParameter("idNo");

        Bank bank = new Bank(username, password, fullName, address, mobileNumber, email, type, balance, dob, idNo);
        boolean result = AdminDAO.updateUser(bank);
        if (result) {
            response.getWriter().println("Account updated successfully!");
        } else {
            response.getWriter().println("Account update failed!");
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int acNo = Integer.parseInt(request.getParameter("accountno"));

        boolean result = AdminDAO.deleteUser(acNo);
        if (result) {
            response.getWriter().println("Account deleted successfully!");
        } else {
            response.getWriter().println("Account deletion failed!");
        }
    }
}
