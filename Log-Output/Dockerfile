# Use a Java 21 runtime
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy the executable Spring Boot JAR
COPY target/Log-Output-0.0.1-SNAPSHOT.jar app.jar

# Run as a non-root user
USER 10001:10001

# expose port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
