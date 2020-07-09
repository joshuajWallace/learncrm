FROM tomcat:9.0-jdk11-openjdk
LABEL maintainer="Joshua Wallace"
EXPOSE 8080
COPY ./jjw.project.crmlearn-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
CMD [ "catalina.sh", "run" ]