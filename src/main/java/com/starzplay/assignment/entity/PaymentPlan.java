package com.starzplay.assignment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment_plan")
public class PaymentPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_plan_seq")
    @SequenceGenerator(name = "payment_plan_seq" ,allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private Double netAmount;
    @Column
    private Double taxAmount;
    @Column
    private Double grossAmount;
    @Column
    private String currency;
    @Column
    private String duration;
    @ManyToOne(cascade  = CascadeType.ALL)
    @JoinColumn(name = "PAYMENT_METHOD_ID")
    private PaymentMethod paymentMethod;
}