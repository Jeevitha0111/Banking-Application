package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BankServlet")
public class BankServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));

        if ("deposit".equals(action)) {
            int amount = Integer.parseInt(request.getParameter("amount"));
            boolean success =com.user.DAO.UserDAO.BankManagement.deposit(accountNumber, amount);
            response.getWriter().write(success ? "Deposit successful" : "Deposit failed");
        }
        else if ("withdraw".equals(action)) {
            int amount = Integer.parseInt(request.getParameter("amount"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean success = com.user.DAO.UserDAO.BankManagement.withdraw(username, password, amount);
            if(success) {
            	response.sendRedirect("WithdrawSuccess.html");
            }
            else {
            	response.getWriter().println("withdraw Failed");
            	response.sendRedirect("Withdraw.jsp");
        } 
        }
        
    	else if ("checkBalance".equals(action)) {
            int balance = com.user.DAO.UserDAO.BankManagement.getBalance(accountNumber);
            response.getWriter().write("Balance: " + balance + "Go Back and Continue Banking !!");
        }
    }
}
