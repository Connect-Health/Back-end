#
# Build stage
#
FROM maven:3.8.6-amazoncorretto-17 AS build

WORKDIR  /app

COPY connecthealth /app

RUN mvn clean package -X -DskipTests

#
# Package stage
#
FROM openjdk:17-ea-10-jdk-slim

WORKDIR /app

COPY --from=build ./app/target/*.jar ./connecthealth.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","connecthealth.jar"]