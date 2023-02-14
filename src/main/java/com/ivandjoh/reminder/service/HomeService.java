package com.ivandjoh.reminder.service;

import com.ivandjoh.reminder.http.HomeRequest;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface HomeService {
    ResponseEntity<?> setReminder(HomeRequest time);

    ResponseEntity<?> getCalcTime() throws ParseException;
}
