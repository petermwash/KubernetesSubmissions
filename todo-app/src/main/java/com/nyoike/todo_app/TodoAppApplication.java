package com.nyoike.todo_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class TodoAppApplication {

	private final Environment environment;

	public TodoAppApplication(Environment environment) {
		this.environment = environment;
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady() {
		String port = environment.getProperty(
				"local.server.port",
				environment.getProperty("server.port", "8080")
		);

		System.out.println("Server started in port " + port);
	}


}
