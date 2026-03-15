FROM eclipse-temurin:17

WORKDIR /api

COPY target/EventClean-0.0.1-SNAPSHOT.jar apiEventClean.jar

ENTRYPOINT ["java", "-jar", "apiEventClean.jar"]