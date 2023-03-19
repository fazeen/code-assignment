package com.starzplay.assignment.repository;

import com.starzplay.assignment.entity.PaymentPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentPlanRepository extends JpaRepository<PaymentPlan, Long> {
}