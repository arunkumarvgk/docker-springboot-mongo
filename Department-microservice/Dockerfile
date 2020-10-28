FROM openjdk:8u272-jdk-slim
MAINTAINER arunkumarvgk@gmail.com, arunkumars546@gmail.com
WORKDIR /app/work
COPY target/department-microservice.jar .
EXPOSE 7272
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=docker", "department-microservice.jar"]