# ===============================
# Stage 1 - Build
# ===============================

FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /build

COPY pom.xml .

COPY .mvn .mvn
COPY mvnw .

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw clean package -DskipTests



# ===============================
# Stage 2 - Runtime
# ===============================

FROM eclipse-temurin:21-jre

WORKDIR /app

ARG APP_VERSION

COPY --from=builder \
     /build/target/*.jar \
     app.jar

LABEL org.opencontainers.image.version=$APP_VERSION

EXPOSE 8080


ENTRYPOINT ["java", "-jar", "app.jar"]
