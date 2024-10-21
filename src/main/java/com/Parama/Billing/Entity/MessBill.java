package com.Parama.Billing.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class MessBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double monthlyExpenditure;
    private int numberOfStudents;
    private double amountPerStudent;

    @Temporal(TemporalType.DATE)
    private Date billingDate;

    // Constructors
    public MessBill() {
    }

    public MessBill(double monthlyExpenditure, int numberOfStudents, double amountPerStudent, Date billingDate) {
        this.monthlyExpenditure = monthlyExpenditure;
        this.numberOfStudents = numberOfStudents;
        this.amountPerStudent = amountPerStudent;
        this.billingDate = billingDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public double getMonthlyExpenditure() {
        return monthlyExpenditure;
    }

    public void setMonthlyExpenditure(double monthlyExpenditure) {
        this.monthlyExpenditure = monthlyExpenditure;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public double getAmountPerStudent() {
        return amountPerStudent;
    }

    public void setAmountPerStudent(double amountPerStudent) {
        this.amountPerStudent = amountPerStudent;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }
}
