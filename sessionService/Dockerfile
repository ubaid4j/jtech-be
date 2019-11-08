FROM maven
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests


FROM hirokimatsumoto/alpine-openjdk-11
LABEL maintainer="urehman.bese16seecs@seecs.edu.pk"
VOLUME /tmp
EXPOSE 8300
ARG JAR_FILE=target/sessionService-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} sessionService.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/sessionService.jar"]
