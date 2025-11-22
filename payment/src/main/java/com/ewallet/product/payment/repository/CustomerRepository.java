package com.ewallet.product.payment.repository;

import com.ewallet.product.payment.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}


