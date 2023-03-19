package com.starzplay.assignment.service;

import com.starzplay.assignment.bo.PaymentMethodBO;

import java.util.List;

public interface PaymentMethodService {
    public List<PaymentMethodBO> getAllPaymentMethod();

    List<PaymentMethodBO> getAllPaymentMethodName(String name);

    PaymentMethodBO save(PaymentMethodBO paymentMethodBO);
}
