FROM openjdk:17-jdk-slim
COPY target/bot-backend.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
