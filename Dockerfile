FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/devopsdocker.jar devopsdocker.jar
ENTRYPOINT ["java","-jar","/devopsdocker.jar"]