FROM openjdk:13-alpine
LABEL maintainer="urehman.bese16seecs@seecs.edu.pk"
VOLUME /tmp
EXPOSE 8500
ARG JAR_FILE=target/notificationService-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} notificationService.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/notificationService.jar"]
