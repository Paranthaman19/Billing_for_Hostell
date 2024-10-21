package com.Parama.Billing.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Parama.Billing.Entity.MessBill;
import com.Parama.Billing.Service.MessBillService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private MessBillService messBillService;

    /**
     * Endpoint to retrieve the latest MessBill.
     *
     * @return The amount per student or a 404 error if no bills exist.
     */
    @GetMapping("/mess-bill")
    public ResponseEntity<?> getMessBill() {
        MessBill bill = messBillService.getLatestMessBill();
        if (bill != null) {
            return ResponseEntity.ok(bill.getAmountPerStudent());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No mess bill found.");
        }
    }
}
