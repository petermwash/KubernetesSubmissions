package com.nyoike.log_output.service;


import com.nyoike.log_output.model.LogStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class LogOutputService {

    private final String randomString;

    public LogOutputService() {
        this.randomString = UUID.randomUUID().toString();
    }

    public LogStatus getStatus() {
        return new LogStatus(
                Instant.now().toString(),
                randomString
        );
    }

    @Scheduled(fixedRateString = "${app.log.interval-ms}")
    public void printLog() {
        String timestamp = Instant.now().toString();

        System.out.printf(
                "%s: %s%n",
                timestamp,
                randomString
        );
    }
}
