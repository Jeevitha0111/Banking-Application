package com.model;

public class Bank {
    String username;
    String password;
    String fullName;
     String address;
    String mobileNumber;
     String email;
     String type;
     int balance;
     String dob;
     String idNo;

    public Bank(String username, String password, String fullName, String address, String mobileNumber, String email, String type, int balance, String dob, String idNo) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.type = type;
        this.balance = balance;
        this.dob = dob;
        this.idNo = idNo;
    }

	public String getUsername() {
		return username;
	}

	
	

	public String getPassword() {
		return password;
	}

	

	public String getFullName() {
		return fullName;
	}

	

	public String getAddress() {
		return address;
	}

	

	public String getMobileNumber() {
		return mobileNumber;
	}

	

	public String getEmail() {
		return email;
	}

	

	public String getType() {
		return type;
	}

	

	public int getBalance() {
		return balance;
	}

	

	public String getDob() {
		return dob;
	}

	

	public String getIdNo() {
		return idNo;
	}



	

    // Getters and setters for all fields
    // ...
}



