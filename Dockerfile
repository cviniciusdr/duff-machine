FROM openjdk:8-jdk-alpine
MAINTAINER Carlos Vinicius Duarte Rodrigues <cvinicius.dr@gmail.com>

VOLUME /tmp
ARG JAR_FILE
COPY  target/duff-machine.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]