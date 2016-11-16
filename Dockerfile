FROM oguiller/ubuntu:0.4

MAINTAINER Guillermo Rodriguez <guillermo@oguiller.com>
COPY ./target/beer-rest-service-0.1.0.war /opt/webapps/beer-rest.war
# Launch Tomcat
CMD ["/opt/tomcat/bin/catalina.sh", "run"]