FROM openjdk:27-ea-trixie
COPY target/job-app.jar job-app.jar
ENTRYPOINT ["java","-jar","/job-app.jar"]