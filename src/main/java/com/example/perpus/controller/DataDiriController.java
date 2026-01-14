package com.example.perpus.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller


public class DataDiriController {
    @GetMapping("/data_diri")
    public String showProfile() {
        return "data_diri";  // This will map to /src/main/resources/templates/data_diri.html
    }
}

