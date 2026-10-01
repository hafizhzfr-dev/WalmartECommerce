package com.walmart.walmartEcommerce.Service;

import org.springframework.stereotype.Service;

import com.walmart.walmartEcommerce.DTO.CustomerDTO;
import com.walmart.walmartEcommerce.Entity.Customer;
import com.walmart.walmartEcommerce.Repository.CustomerRepository;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public CustomerDTO registerCustomer(String name) {
    String customerId = "C" + name.substring(0, 2).toUpperCase()
        + String.format("%03d", this.customerRepository.count() + 1);
    Customer customer = new Customer(customerId, name);
    CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerId(), customer.getName(), "NO WALLET");
    this.customerRepository.save(customer);
    return customerDTO;

  }

  public CustomerDTO getCustomerDTO(Customer customer) {
    if (customer.getWallet() == null) {
      return new CustomerDTO(customer.getCustomerId(), customer.getName(), "NO WALLET");
    }
    return new CustomerDTO(customer.getCustomerId(), customer.getName(), customer.getWallet().getWalletId());
  }

  public Customer getCustomer(String customerId) {
    return this.customerRepository.findById(customerId)
        .orElseThrow(() -> new IllegalArgumentException("Customer " + customerId + " not found!"));
  }

  public void saveCustomer(Customer customer) {
    this.customerRepository.save(customer);
  }

  public void printAllCustomer() {
    System.out.println("");
    System.out.println("List Customers:");
    for (Customer customer : this.customerRepository.findAll()) {
      CustomerDTO customerDTO = getCustomerDTO(customer);
      System.out.println(
          customerDTO.getCustomerId() + " | "
              + customerDTO.getName() + " | "
              + customerDTO.getWalletId() + " | ");
    }
  }
}
