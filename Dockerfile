
FROM amazoncorretto:17.0.6

COPY --from=build build/libs/*.jar.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]