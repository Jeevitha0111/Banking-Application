package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Transaction;
import com.user.DAO.TransactionDAO;

@WebServlet("/transactionHistory")
public class TransactionHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int acNo = Integer.parseInt(request.getParameter("accountNo"));
        
        // Call DAO to get transactions for the user
        List<Transaction> transactions = TransactionDAO.getTransactionsByAccountNo(acNo);

        // Set the transactions attribute in request scope
        request.setAttribute("transactions", transactions);

        // Forward to JSP
        request.getRequestDispatcher("/transactionHistory.jsp").forward(request, response);
    }
}
