package com.starzplay.assignment.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.starzplay.assignment.entity.PaymentMethod;
import com.starzplay.assignment.entity.PaymentPlan;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentPlanBO implements BaseBO<PaymentPlanBO, PaymentPlan>{
    private Long id;
    private Double netAmount;
    private Double taxAmount;
    private Double grossAmount;
    private String currency;
    private String duration;
    @JsonIgnore
    private Long paymentMethodId;


    @Override
    public PaymentPlan convertToEntity() {
        PaymentPlan entity = new PaymentPlan();
        entity.setId(this.getId());
        entity.setCurrency(this.getCurrency());
        entity.setDuration(this.getDuration());
        entity.setNetAmount(this.getNetAmount());
        entity.setGrossAmount(this.getGrossAmount());
        entity.setTaxAmount(this.getGrossAmount());
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setId(this.getPaymentMethodId());
        entity.setPaymentMethod(paymentMethod);
        return entity;
    }

    @Override
    public PaymentPlanBO convertToBO(PaymentPlan entity) {
        this.setId(entity.getId());
        this.setCurrency(entity.getCurrency());
        this.setDuration(entity.getDuration());
        this.setNetAmount(entity.getNetAmount());
        this.setGrossAmount(entity.getGrossAmount());
        this.setTaxAmount(entity.getGrossAmount());
        this.setPaymentMethodId(entity.getPaymentMethod().getId());
        return this;
    }

    @Override
    public PaymentPlanBO convertToNewBO(PaymentPlan entity) {
        return null;
    }
}
