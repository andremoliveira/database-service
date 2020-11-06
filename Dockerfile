FROM openjdk:8-jdk-alpine
ARG JAR_FILE=/build/libs/*.jar
COPY ${JAR_FILE} /database-service.jar
ENTRYPOINT ["java","-jar","/database-service.jar"]


