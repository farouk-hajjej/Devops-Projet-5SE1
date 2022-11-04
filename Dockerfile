FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/projet-devops.jar projet-devops.jar
ENTRYPOINT ["java","-jar","/projet-devops.jar"]