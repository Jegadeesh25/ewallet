package com.ewallet.product.payment.repository;

import com.ewallet.product.payment.dto.Customer;
import com.ewallet.product.payment.dto.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {

    CustomerAccount findByCustomer(Customer customer);
}

