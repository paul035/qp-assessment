FROM openjdk:21
EXPOSE 9090
ADD target/grocery-service.jar grocery-service.jar
ENTRYPOINT ["java", "-jar", "/grocery-service.jar"]