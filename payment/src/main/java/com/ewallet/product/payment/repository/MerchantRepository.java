package com.ewallet.product.payment.repository;

import com.ewallet.product.payment.dto.Customer;
import com.ewallet.product.payment.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}

