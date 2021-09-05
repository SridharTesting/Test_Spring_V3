#FROM tomcat:8.0-alpine
#COPY ./target/*.war /usr/local/tomcat/webapps/CSBRestAPI.war
# EXPOSE 8080


FROM openjdk:14-alpine

ARG WAR_FILE=./target/*.war

COPY ${WAR_FILE} webapp.war

CMD ["java", "-Dspring.profiles.active=docker", "-jar", "webapp.war"]