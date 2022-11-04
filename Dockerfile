FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/projet-docker.jar projet-docker.jar
ENTRYPOINT ["java","-jar","/projet-docker.jar"]