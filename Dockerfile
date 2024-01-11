FROM openjdk:20
WORKDIR /app
EXPOSE 8080
COPY ./target/block-arch-0.0.1-SNAPSHOT.jar spring-app.jar
ENTRYPOINT ["java", "-jar", "spring-app.jar"]
