FROM openjdk:8u272-jdk-slim
MAINTAINER arunkumarvgk@gmail.com, arunkumars546@gmail.com
WORKDIR /app/work
COPY target/employee-microservice.jar .
EXPOSE 7070
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=docker", "employee-microservice.jar"]