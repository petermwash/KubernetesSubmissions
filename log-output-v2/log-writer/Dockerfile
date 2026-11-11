FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/log-writer-0.0.1-SNAPSHOT.jar app.jar

RUN mkdir -p /usr/src/app/shared

USER 10001:10001

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
