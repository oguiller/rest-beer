FROM oguiller/ubuntu:0.4

MAINTAINER Guillermo Rodriguez <guillermo@oguiller.com>

# Launch Tomcat
CMD ["/opt/tomcat/bin/catalina.sh", "run"]