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

    
    @PostMapping("/create-bill")
    public ResponseEntity<?> createBill(
            @RequestParam double expenditure,
            @RequestParam int numberOfStudents) {

        
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
