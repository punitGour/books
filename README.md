# books
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY /target/spring-boot-rest-example-0.5.0.war /app/
ENTRYPOINT ["java", "-jar", "spring-boot-rest-example-0.5.0.war"]

