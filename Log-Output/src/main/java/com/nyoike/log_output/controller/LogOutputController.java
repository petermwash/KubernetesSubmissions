package com.nyoike.log_output.controller;

import com.nyoike.log_output.model.LogStatus;
import com.nyoike.log_output.service.LogOutputService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogOutputController {

    private final LogOutputService logOutputService;

    public  LogOutputController(
            LogOutputService logOutputService
    ) {
        this.logOutputService = logOutputService;
    }

    @GetMapping("/status")
    public LogStatus getStatus() {
        return logOutputService.getStatus();
    }
}
