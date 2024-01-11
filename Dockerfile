FROM openjdk:20
EXPOSE 8080
ADD target/block-arch-0.0.1-SNAPSHOT.jar spring-app.jar
ENTRYPOINT ["java", "-jar", "spring-app.jar"]