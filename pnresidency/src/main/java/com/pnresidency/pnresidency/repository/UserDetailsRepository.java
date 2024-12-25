package com.pnresidency.pnresidency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.UserDetails;
import com.pnresidency.pnresidency.dto.UserPrice;

import jakarta.transaction.Transactional;

public interface  UserDetailsRepository extends JpaRepository<UserDetails, Long>{

   // Calculate total price spent by each user
    @Query("SELECT new com.pnresidency.pnresidency.dto.UserPrice(u.userName, SUM(u.itemPrice)) " +
           "FROM UserDetails u GROUP BY u.userName")
    List<UserPrice> calculateUserPrices();
    

    // Reset all prices for every user
    @Transactional
    @Modifying
    @Query("UPDATE UserDetails u SET u.itemPrice = 0")
    void resetAllPrices();

    @Modifying
    @Transactional
    @Query("UPDATE UserDetails u SET u.itemPrice = 0 WHERE u.userName = :userName")
    int resetPriceForUser(@Param("userName") String userName);

  
}
