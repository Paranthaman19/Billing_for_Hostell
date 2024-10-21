package com.Parama.Billing.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Parama.Billing.Entity.MessBill;

@Repository
public interface MessBillRepository extends JpaRepository<MessBill, Long> {
    // Custom query to fetch the latest MessBill based on the highest id
    MessBill findTopByOrderByIdDesc();
}
