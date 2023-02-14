package com.ivandjoh.reminder.service.Impl;

import com.ivandjoh.reminder.http.HomeRequest;
import com.ivandjoh.reminder.http.HomeResponse;
import com.ivandjoh.reminder.service.HomeService;
import com.ivandjoh.reminder.utils.QuartzScheduler;
import com.ivandjoh.reminder.utils.ReminderHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class HomeServiceImpl implements HomeService {

    private final Logger log = LoggerFactory.getLogger(HomeServiceImpl.class);

    @Override
    public ResponseEntity<?> setReminder(HomeRequest time) {

        HomeResponse response = new HomeResponse();
        response.setTime(time.getTime());
        response.setMessage("Reminder has been set for " + time.getTime());

        String getTime = response.getTime();

        String[] strTime = getTime.split(":", 2);

        ReminderHelper.executeTask(Integer.parseInt(strTime[0]));

        return ResponseEntity
                .status(200)
                .body(response);
    }

    @Override
    public ResponseEntity<?> getCalcTime() throws ParseException {

        String time1 = "12:45";
        String time2 = "14:00";

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date d1 = format.parse(time1);
        Date d2 = format.parse(time2);

        long diff = d2.getTime() - d1.getTime();
        int min = (int) (diff / (1000*60));
        log.info("Time difference : {} minutes ", min);

        return ResponseEntity
                .status(200)
                .body(min);
    }

    @Override
    public ResponseEntity<?> quartz() {

        QuartzScheduler.executeTask(2);
        return null;
    }
}
