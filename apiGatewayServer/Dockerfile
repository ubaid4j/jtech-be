FROM openjdk:15-jdk-alpine
LABEL maintainer="urehman.bese16seecs@seecs.edu.pk"
ARG JAR_FILE=target/apiGatewayServer-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} apiGatewayServer.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/apiGatewayServer.jar"]
