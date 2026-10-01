package com.walmart.walmartEcommerce.Entity;

public class Wallet {
  private String walletId;
  private double balance;
  private Customer customer;

  public Wallet(String walletId, Customer customer, double balance) {
    this.walletId = walletId;
    this.balance = 0;
    this.customer = customer;
  }

  public String getWalletId() {
    return this.walletId;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double newBalance) {
    this.balance = newBalance;
  }

  public Customer getCustomer() {
    return this.customer;
  }
}
