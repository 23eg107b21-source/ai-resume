FROM openjdk:17-jdk-slim as builder

WORKDIR /app

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN chmod +x mvnw && \
    ./mvnw clean package -DskipTests -q

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/*.jar ./app.jar

EXPOSE 10000

CMD ["java", "-jar", "./app.jar"]
