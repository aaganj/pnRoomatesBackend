package com.pnresidency.pnresidency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserDetails;
import com.pnresidency.pnresidency.dto.UserPrice;
import com.pnresidency.pnresidency.repository.UserDetailsRepository;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @CrossOrigin
    @PostMapping("/submit-details")
    public ResponseEntity<String> submitDetails(@RequestBody UserDetails userDetails) {
        // Process the received data
        userDetailsRepository.save(userDetails);

        System.out.println("Received: " + userDetails);
        return ResponseEntity.ok("Details submitted successfully!");
    }

    @GetMapping("/user-prices")
    public ResponseEntity<List<UserPrice>> getUserPrices() {
        List<UserPrice> userPrices = userDetailsRepository.calculateUserPrices();
        return ResponseEntity.ok(userPrices);
    }
   
     // Endpoint to reset prices for all users
     @PostMapping("/reset-prices")
     public ResponseEntity<String> resetPrices() {
         userDetailsRepository.resetAllPrices();
         return ResponseEntity.ok("Prices reset successfully.");
     }

    @PostMapping("/reset-price/{userName}")
    public ResponseEntity<String> resetPriceForUser(@PathVariable String userName) {
        int updatedCount = userDetailsRepository.resetPriceForUser(userName);
        if (updatedCount > 0) {
            return ResponseEntity.ok("Price reset successfully for " + userName);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

}
