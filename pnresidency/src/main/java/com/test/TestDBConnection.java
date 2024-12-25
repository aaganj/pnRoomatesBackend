package com.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {
   public static void main(String[] args) {
        String url = "jdbc:mysql://sql309.ezyro.com/ezyro_37964565_pnroomates";
        String username = "ezyro_37964565";
        String password = "1cf4a139";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database successfully!");
        } catch (Exception e) {
          System.out.println("unable to connect to DB");
            e.printStackTrace();
        }
    }
  
}
