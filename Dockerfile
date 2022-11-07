FROM openjdk:11
ADD target/tpAchatProject-1.0.jar montaproduit.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","montaproduit.jar"]