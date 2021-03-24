FROM openjdk:11.0.7-jre-slim
COPY target/starter-web-0.0.1-SNAPSHOT.war spring-app.war
ENTRYPOINT ["java","-jar","/spring-app.war"]