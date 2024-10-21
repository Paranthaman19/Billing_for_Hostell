package com.Parama.Billing.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Parama.Billing.Entity.MessBill;
import com.Parama.Billing.Service.MessBillService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private MessBillService messBillService;

    /**
     * Endpoint to create a new MessBill.
     *
     * @param expenditure      The total monthly expenditure.
     * @param numberOfStudents The number of students sharing the bill.
     * @return The created MessBill entity or an error message.
     */
    @PostMapping("/create-bill")
    public ResponseEntity<?> createBill(
            @RequestParam double expenditure,
            @RequestParam int numberOfStudents) {

        // Input Validation
        if (numberOfStudents <= 0) {
            return ResponseEntity.badRequest().body("Number of students must be greater than zero.");
        }

        if (expenditure < 0) {
            return ResponseEntity.badRequest().body("Expenditure cannot be negative.");
        }

        MessBill bill = messBillService.createOrUpdateMessBill(expenditure, numberOfStudents);
        return ResponseEntity.ok(bill);
    }
}
