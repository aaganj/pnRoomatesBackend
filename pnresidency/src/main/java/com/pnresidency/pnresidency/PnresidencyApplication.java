package com.pnresidency.pnresidency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@EntityScan(basePackages = "com.entity")
@RestController
public class PnresidencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PnresidencyApplication.class, args);
	}

}
