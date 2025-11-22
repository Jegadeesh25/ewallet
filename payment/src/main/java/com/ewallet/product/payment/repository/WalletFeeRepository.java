package com.ewallet.product.payment.repository;

import com.ewallet.product.payment.dto.Customer;
import com.ewallet.product.payment.dto.WalletFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface WalletFeeRepository extends JpaRepository<WalletFee, Long> {

    WalletFee findByCurrency(String currency);
}

