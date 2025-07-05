FROM openjdk:22-jdk-slim

WORKDIR /app

COPY target/estoque_produtos-1.0-SNAPSHOT.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]