package com.starzplay.assignment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "payment_method")
@Data
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_method_seq")
    @SequenceGenerator(name = "payment_method_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private String displayName;
    @Column
    private String paymentType;
    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL)
    Set<PaymentPlan> paymentPlans = new HashSet<>();


    public void addPaymentPlan(PaymentPlan paymentPlans){
        this.paymentPlans.add(paymentPlans);
        paymentPlans.setPaymentMethod(this);
    }



}