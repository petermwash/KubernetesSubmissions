package com.nyoike.log_writer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.UUID;

@Service
public class LogWriterService {

    private final String randomString;
    private final Path logFile;

    public LogWriterService(
            @Value("${app.log.file-path}") String filePath
    )  {
        this.randomString = UUID.randomUUID().toString();
        this.logFile = Path.of(filePath);
    }

    @Scheduled(fixedRateString = "${app.log.interval-ms}")
    public void writeLog() {
        String line = "%s: %s%n".formatted(
                Instant.now(),
                randomString
        );

        try {
            Files.createDirectories(logFile.getParent());

            Files.writeString(
                    logFile,
                    line,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            System.out.print(line);

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Failed to write log to " + logFile, e
            );
        }
    }
}
