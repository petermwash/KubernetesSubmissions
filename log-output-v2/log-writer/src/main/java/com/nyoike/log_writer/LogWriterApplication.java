package com.nyoike.log_writer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LogWriterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogWriterApplication.class, args);
	}

}
