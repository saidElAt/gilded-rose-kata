# ------------------------------------------------------------
# Build stage
# ------------------------------------------------------------
FROM maven:3.9.16-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -B clean package

# ------------------------------------------------------------
# Runtime stage
# ------------------------------------------------------------
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build \
    /app/target/gilded-rose-kata-1.0-SNAPSHOT.jar \
    app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]