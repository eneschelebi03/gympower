
FROM amazoncorretto:17.0.6

COPY --from=build build/libs/gympower.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]