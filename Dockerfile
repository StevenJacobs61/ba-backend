FROM openjdk:20

COPY target/block-arch-0.0.1-SNAPSHOT.jar spring-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-app.jar"]

