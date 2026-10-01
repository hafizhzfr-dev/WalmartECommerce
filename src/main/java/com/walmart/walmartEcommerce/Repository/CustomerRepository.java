package com.walmart.walmartEcommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.walmartEcommerce.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
