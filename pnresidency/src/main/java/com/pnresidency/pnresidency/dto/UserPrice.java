package com.pnresidency.pnresidency.dto;

public class UserPrice {
  private String userName;
    private Double totalPrice;

    public UserPrice(String userName, Double totalPrice) {
        this.userName = userName;
        this.totalPrice = totalPrice;
    }

    public String getUserName() {
        return userName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
  
}
