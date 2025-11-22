package com.ewallet.product.payment.repository;

import com.ewallet.product.payment.dto.Customer;
import com.ewallet.product.payment.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

