FROM openjdk:15-jdk-alpine
LABEL maintainer="urehman.bese16seecs@seecs.edu.pk"
ARG JAR_FILE=target/api-gateway-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} api-gateway.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=dev","-jar","/api-gateway.jar"]
