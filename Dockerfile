
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM  amazoncorretto:11.0.4
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} reposervices.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/reposervices.jar"]