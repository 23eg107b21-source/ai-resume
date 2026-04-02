FROM maven:3.9.7-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -B clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/*.jar ./app.jar

EXPOSE 10000

CMD ["java", "-jar", "./app.jar"]
