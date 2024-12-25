package com.pnresidency.pnresidency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/{path:[^\\.]*}"})
    public String forward() {
        return "forward:/index.html"; // Serve React's index.html
    }
  
}
