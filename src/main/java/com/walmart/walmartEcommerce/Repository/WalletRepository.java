package com.walmart.walmartEcommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.walmartEcommerce.Entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, String> {
}
