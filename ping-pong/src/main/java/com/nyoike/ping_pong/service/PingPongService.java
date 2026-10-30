package com.nyoike.ping_pong.service;

import org.springframework.stereotype.Service;

@Service
public class PingPongService {

    private int counter;

    public PingPongService() {
        this.counter = 0;
    }

    public String getPongCounter() {
        return "pong " + counter++;
    }
}
