package com.ivandjoh.reminder.controller;

import com.ivandjoh.reminder.http.HomeRequest;
import com.ivandjoh.reminder.service.HomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("")
    public String home() {
        return "Hello World!";
    }

    @PostMapping("reminder")
    public ResponseEntity<?> setReminder(@RequestBody HomeRequest time) {
        return homeService.setReminder(time);
    }
}
