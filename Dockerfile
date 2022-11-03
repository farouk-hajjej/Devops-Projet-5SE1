FROM openjdk:8
EXPOSE 8089
ADD target/devopsdocker.jar devopsdocker.jar
ENTRYPOINT ["java","-jar","/devopsdocker.jar"]