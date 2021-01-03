FROM openjdk:15-jdk-alpine
LABEL maintainer="urehman.bese16seecs@seecs.edu.pk"
ARG JAR_FILE=target/rest-api-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} rest-api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","/rest-api.jar"]
