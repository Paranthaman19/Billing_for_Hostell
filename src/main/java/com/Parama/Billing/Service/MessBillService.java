package com.Parama.Billing.Service;

import com.Parama.Billing.Entity.MessBill;
import com.Parama.Billing.Repo.MessBillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessBillService {

    @Autowired
    private MessBillRepository messBillRepository;

   
    public MessBill createOrUpdateMessBill(double expenditure, int numberOfStudents) {
        MessBill bill = new MessBill();
        bill.setMonthlyExpenditure(expenditure);
        bill.setNumberOfStudents(numberOfStudents);
        bill.setAmountPerStudent(expenditure / numberOfStudents);
        bill.setBillingDate(new Date()); 

        return messBillRepository.save(bill);
    }

    
    public MessBill getLatestMessBill() {
        return messBillRepository.findTopByOrderByIdDesc();
    }
}
