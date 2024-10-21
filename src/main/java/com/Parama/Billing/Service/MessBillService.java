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

    /**
     * Creates a new MessBill entry.
     *
     * @param expenditure        The total monthly expenditure.
     * @param numberOfStudents   The number of students sharing the bill.
     * @return The saved MessBill entity.
     */
    public MessBill createOrUpdateMessBill(double expenditure, int numberOfStudents) {
        MessBill bill = new MessBill();
        bill.setMonthlyExpenditure(expenditure);
        bill.setNumberOfStudents(numberOfStudents);
        bill.setAmountPerStudent(expenditure / numberOfStudents);
        bill.setBillingDate(new Date()); // Current date

        return messBillRepository.save(bill);
    }

    /**
     * Retrieves the latest MessBill entry.
     *
     * @return The latest MessBill entity, or null if none exist.
     */
    public MessBill getLatestMessBill() {
        return messBillRepository.findTopByOrderByIdDesc();
    }
}
