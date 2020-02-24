FROM tomcat:8-jre8
COPY target/music-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]