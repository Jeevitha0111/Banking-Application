package com.controller;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	static Connection connect; 
	public static Connection getConnection()
    {
        try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankCredentials", "root", "2003");
        }
        catch (Exception e) {
            System.out.println("Connection Failed!");
        }
		return connect;
    }
        
        //ResultSet rs=st.executeQuery();
        //rs.next(); //taking to next element in column
        //st.close(); //closing statement
        //connect.close(); //closing connection
		
	}


