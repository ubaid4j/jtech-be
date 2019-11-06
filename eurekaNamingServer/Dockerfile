FROM hirokimatsumoto/alpine-openjdk-11
LABEL maintainer="urehman.bese16seecs@seecs.edu.pk"
VOLUME /tmp
EXPOSE 0.0.0.0:8761
ARG JAR_FILE=target/eurekaNamingServer-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} eurekaNamingServer.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eurekaNamingServer.jar"]
