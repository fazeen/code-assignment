package com.starzplay.assignment.bo;

import com.starzplay.assignment.entity.PaymentMethod;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PaymentMethodBO implements BaseBO<PaymentMethodBO, PaymentMethod> {
    private Long id;
    private String name;
    private String displayName;
    private String paymentType;

    private List<PaymentPlanBO> paymentPlans;
    @Override
    public PaymentMethod convertToEntity() {
        PaymentMethod entity = new PaymentMethod();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setDisplayName(this.getDisplayName());
        entity.setPaymentType(this.getPaymentType());
        if(this.getPaymentPlans() != null)
            this.paymentPlans.forEach(e->entity.addPaymentPlan(e.convertToEntity()));
        return entity;
    }

    @Override
    public PaymentMethodBO convertToBO(PaymentMethod entity) {
        this.setId(entity.getId());
        this.setName(entity.getName());
        this.setDisplayName(entity.getDisplayName());
        this.setPaymentType(entity.getPaymentType());
        if(entity.getPaymentPlans()!=null)
            this.setPaymentPlans(entity.getPaymentPlans().stream().map(e->new PaymentPlanBO().convertToBO(e)).collect(Collectors.toList()));
        return this;
    }

    @Override
    public PaymentMethodBO convertToNewBO(PaymentMethod entity) {
        return null;
    }
}
