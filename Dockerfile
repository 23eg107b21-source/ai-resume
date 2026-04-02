# Multi-stage build
FROM openjdk:17-jdk-slim as builder

WORKDIR /app

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN chmod +x mvnw && \
    ./mvnw clean package -DskipTests -q

# Runtime stage
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 10000

ENV PORT=10000
ENV JAVA_OPTS="-Xmx512m -Xms256m"

ENTRYPOINT exec java $JAVA_OPTS -jar /app/app.jar
