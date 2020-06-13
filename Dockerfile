FROM tomcat:10.0-jdk11-openjdk
LABEL maintainer="Joshua Wallace"
COPY jjw.project.crmlearn-1.0-SNAPSHOT.war /usr/local/tomcat/webapp
CMD [ "/usr/local/tomcat/bin/startup.sh" ]