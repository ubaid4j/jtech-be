
FROM hirokimatsumoto/alpine-openjdk-11
LABEL maintainer="urehman.bese16seecs@seecs.edu.pk"
VOLUME /tmp
EXPOSE 8400
ARG JAR_FILE=target/messageService-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} messageService.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/messageService.jar"]
