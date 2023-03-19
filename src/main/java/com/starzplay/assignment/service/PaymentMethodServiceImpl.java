package com.starzplay.assignment.service;

import com.starzplay.assignment.bo.PaymentMethodBO;
import com.starzplay.assignment.repository.PaymentMethodRepository;
import com.starzplay.assignment.repository.PaymentPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService{
    @Autowired
    PaymentMethodRepository paymentMethodRepository;
    @Autowired
    PaymentPlanRepository paymentPlanRepository;
    @Override
    public List<PaymentMethodBO> getAllPaymentMethod() {
        return paymentMethodRepository.findAll()
                .stream()
                .map(e->new PaymentMethodBO().convertToBO(e))
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentMethodBO> getAllPaymentMethodName(String name) {
         return paymentMethodRepository.findByName(name)
                .stream()
                .map(e->new PaymentMethodBO().convertToBO(e))
                .collect(Collectors.toList());
    }

    @Override

    public PaymentMethodBO save(PaymentMethodBO paymentMethodBO) {
        paymentMethodBO = paymentMethodBO.convertToBO(paymentMethodRepository.save(paymentMethodBO.convertToEntity()));
        return paymentMethodBO;
    }
}
