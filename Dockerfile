FROM openjdk:21-jdk-alpine
COPY target/*.jar testapp.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "testapp.jar"]
