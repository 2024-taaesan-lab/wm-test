FROM amazoncorretto:17-alpine3.18-jdk
COPY ./target/shortest-path-app*.jar app.jar
CMD ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]