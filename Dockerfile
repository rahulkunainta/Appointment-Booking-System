FROM tomcat:9.0

RUN rm -rf /usr/local/tomcat/webapps/*

COPY Appointment-Booking-System.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]