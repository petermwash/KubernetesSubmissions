package com.nyoike.ping_pong.controller;

import com.nyoike.ping_pong.service.PingPongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPongController {

    public final PingPongService pingPongService;

    public PingPongController(
            PingPongService pingPongService
    ) {
        this.pingPongService = pingPongService;
    }

    @GetMapping("/pingpong")
    public String getPongCounter() {
        return pingPongService.getPongCounter();
    }
}
