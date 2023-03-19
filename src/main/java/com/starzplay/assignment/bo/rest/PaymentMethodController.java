package com.starzplay.assignment.bo.rest;

import com.starzplay.assignment.bo.PaymentMethodBO;
import com.starzplay.assignment.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/config/payment-methods")
public class PaymentMethodController {

    @Autowired
    PaymentMethodService paymentMethodService;
    @GetMapping
    public List<PaymentMethodBO> getAllPaymentMethod(@RequestParam(required = false) String name){
        if(name != null){
            return paymentMethodService.getAllPaymentMethodName(name);
        }
        return paymentMethodService.getAllPaymentMethod();
    }
    @PostMapping
    public PaymentMethodBO savePaymentMethod(@RequestBody PaymentMethodBO paymentMethodBO){
        return paymentMethodService.save(paymentMethodBO);
    }
    @PutMapping
    public PaymentMethodBO updatePaymentMethod(@RequestBody PaymentMethodBO paymentMethodBO){
        return paymentMethodService.save(paymentMethodBO);
    }


}
