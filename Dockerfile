
FROM amazoncorretto:17.0.6

COPY build/libs/*.jar.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]