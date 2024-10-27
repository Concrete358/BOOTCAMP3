FROM ubuntu:22.04

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk wget && \
    apt-get clean;

WORKDIR /app

COPY ./target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

ENV DEVOPS=BAM-BA-LEJLA

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/demo.jar"]