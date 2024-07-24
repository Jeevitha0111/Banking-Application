 package com.model;

public class Transaction {
    private int TransactionID;
    private int AccountNo;
    private String type;
    private int amount;
    private String date;
    private String description;

    public Transaction(int TransactionID, int AccountNo, String type, int amount, String date, String description) {
        this.TransactionID = TransactionID;
        this.AccountNo = AccountNo;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    // Getters and setters
    public int getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(int TransactionID) {
        this.TransactionID = TransactionID;
    }

    public int getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(int AccountNo) {
        this.AccountNo = AccountNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
