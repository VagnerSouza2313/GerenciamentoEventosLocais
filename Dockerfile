FROM eclipse-temurin:17

WORKDIR /app

COPY target/EventClean-0.0.1-SNAPSHOT.jar EventClean.jar

ENTRYPOINT ["java", "-jar", "EventClean.jar"]