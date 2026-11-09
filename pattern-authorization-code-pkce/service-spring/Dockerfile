FROM eclipse-temurin:25-jdk AS build
WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle* settings.gradle* gradle.properties* ./
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon > /dev/null 2>&1 || true

COPY src src
RUN ./gradlew bootJar --no-daemon -x test

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

RUN apk add --no-cache curl \
    && addgroup -S app && adduser -S app -G app

COPY --from=build /app/build/libs/*.jar app.jar

USER app
EXPOSE 8080

ENV JAVA_OPTS="-XX:MaxRAMPercentage=75"


ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar app.jar"]