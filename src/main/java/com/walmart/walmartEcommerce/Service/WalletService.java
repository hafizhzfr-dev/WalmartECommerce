package com.walmart.walmartEcommerce.Service;

import org.springframework.stereotype.Service;

import com.walmart.walmartEcommerce.DTO.WalletDTO;
import com.walmart.walmartEcommerce.Entity.Customer;
import com.walmart.walmartEcommerce.Entity.Wallet;
import com.walmart.walmartEcommerce.Repository.WalletRepository;

@Service
public class WalletService {
  private final WalletRepository walletRepository;
  private final CustomerService customerService;

  public WalletService(WalletRepository walletRepository, CustomerService customerService) {
    this.walletRepository = walletRepository;
    this.customerService = customerService;
  }

  public WalletDTO registerWallet(String customerId, double balance) {
    Customer customer = this.customerService.getCustomer(customerId);
    String walletId = "W" + customer.getName().substring(0, 2).toUpperCase()
        + String.format("%03d", this.walletRepository.count() + 1);

    Wallet wallet = new Wallet(walletId, customer, balance);
    this.walletRepository.save(wallet);

    customer.assignWallet(wallet);
    this.customerService.saveCustomer(customer);

    WalletDTO walletDTO = new WalletDTO(wallet.getWalletId(), wallet.getCustomer().getCustomerId(),
        wallet.getBalance());

    return walletDTO;
  }

}
