package com.walmart.walmartEcommerce.Entity;

public class Customer {
  private String customerId;
  private String name;
  private Wallet wallet;

  public Customer(String customerId, String name) {
    this.customerId = customerId;
    this.name = name;
  }

  public assignWallet(Wallet wallet){
    this.wallet = wallet;
  }

  public String getName() {
    return this.name;
  }

  public String getCustomerId() {
    return this.customerId;
  }

  public Wallet getWallet() {
    return this.wallet;
  }

}
