package com.ewallet.product.payment.service;

import com.ewallet.product.payment.dto.*;
import com.ewallet.product.payment.exception.BusinessException;
import com.ewallet.product.payment.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final CustomerRepository customerRepository;
    private final CustomerAccountRepository customerAccountRepository;

    private final MerchantRepository merchantRepository;
    private final ProductRepository productRepository;

    private final WalletFeeRepository walletFeeRepository;


    @Transactional
    public PaymentResponse processPayment(PaymentRequest request) {

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new BusinessException("Customer not found"));

        CustomerAccount customerAccount =
                customerAccountRepository.findByCustomer(customer);

        if (customerAccount == null) {
            throw new BusinessException("Customer account not found");
        }

        Merchant merchant = merchantRepository.findById(request.getMerchantId())
                .orElseThrow(() -> new BusinessException("Merchant not found"));

        Product product = productRepository.findById( request.getProductId())
                .orElseThrow(() -> new BusinessException("Product not found"));

        int amount = product.getCost();

        WalletFee walletFee = walletFeeRepository.findByCurrency(request.getCurrency());

        if (walletFee == null) {
            throw new BusinessException("Wallet fee not configured for currency: " + request.getCurrency());
        }

        int fee = walletFee.getFee();

        int totalDebit = amount + fee;

        if (customerAccount.getBalance() < totalDebit) {
            throw new BusinessException("Insufficient wallet balance");
        }

        try {

            int updatedBalance = customerAccount.getBalance() - totalDebit;
            customerAccount.setBalance(updatedBalance);
            customerAccountRepository.save(customerAccount);

            int updatedMerchantBalance = merchant.getBalance() + amount;
            merchant.setBalance(updatedMerchantBalance);
            merchantRepository.save(merchant);
            String txnId = UUID.randomUUID().toString();
            return PaymentResponse.builder()
                    .transactionId(txnId)
                    .status("SUCCESS")
                    .amount(amount)
                    .feeAmount(fee)
                    .totalDebit(totalDebit)
                    .merchantCredit(amount)
                    .build();

        } catch (Exception ex) {

            throw new BusinessException("Payment failed: " + ex.getMessage());
        }
    }
}
