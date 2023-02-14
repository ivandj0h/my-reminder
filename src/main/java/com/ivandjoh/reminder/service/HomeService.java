package com.ivandjoh.reminder.service;

import com.ivandjoh.reminder.http.HomeRequest;
import org.springframework.http.ResponseEntity;

public interface HomeService {
    ResponseEntity<?> setReminder(HomeRequest time);
}
