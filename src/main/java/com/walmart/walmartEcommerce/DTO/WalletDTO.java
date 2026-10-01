package com.walmart.walmartEcommerce.DTO;

public class WalletDTO {
  private String walletId;
  private String customerId;
  private double balance;

  public WalletDTO(String walletId, String customerId, double balance) {
    this.walletId = walletId;
    this.customerId = customerId;
    this.balance = balance;
  }

  public String getWalletId() {
    return this.walletId;
  }

  public String getCustomerId() {
    return this.customerId;
  }

  public double getBalance() {
    return this.balance;
  }
}
