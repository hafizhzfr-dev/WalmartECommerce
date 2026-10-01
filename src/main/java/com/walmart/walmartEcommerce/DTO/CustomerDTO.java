package com.walmart.walmartEcommerce.DTO;

public class CustomerDTO {
  private String customerId;
  private String name;
  private String walletId;

  public CustomerDTO(String customerId, String name, String walletId) {
    this.customerId = customerId;
    this.name = name;
    this.walletId = walletId;
  }

  public String getCustomerId() {
    return this.customerId;
  }

  public String getName() {
    return this.name;
  }

  public String getWalletId() {
    return this.walletId;
  }
}
