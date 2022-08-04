

# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM  amazoncorretto:11.0.4
VOLUME /tmp
ARG JAR_FILE=target/reposervices-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} reposervices-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/reposervices-1.0-SNAPSHOT.jar"]