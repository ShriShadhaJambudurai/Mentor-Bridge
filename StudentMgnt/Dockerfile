FROM openjdk:17-jdk-alpine

ADD target/student-application-mongodb.jar student-application-mongodb.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","student-application-mongodb.jar"]