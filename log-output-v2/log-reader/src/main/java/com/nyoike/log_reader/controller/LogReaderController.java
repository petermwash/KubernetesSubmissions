package com.nyoike.log_reader.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class LogReaderController {

    private final Path logFile;

    public LogReaderController(
            @Value("${app.log.file-path}") String filePath
    ) {
        this.logFile = Path.of(filePath);
    }

    @GetMapping(value = "/logs", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getLogs() {

        if (Files.notExists(logFile)) {
            return ResponseEntity
                    .status(404)
                    .body("Log file does not exist yet.");
        }

        try {
            String content = Files.readString(
                    logFile,
                    StandardCharsets.UTF_8
            );

            return ResponseEntity.ok(content);

        } catch (IOException e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Unable to read log file");
        }
    }
}
