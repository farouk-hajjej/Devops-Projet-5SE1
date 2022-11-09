FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/docker-spring-boot.jar achatfarouk.jar
ENTRYPOINT ["java","-jar","achatfarouk.jar"]