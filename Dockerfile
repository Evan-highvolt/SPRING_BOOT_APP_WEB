FROM openjdk:21-jdk

RUN mkdir /usr/local/webApp

COPY appweb-0.0.1-SNAPSHOT.jar /usr/local/webApp/appweb-0.0.1-SNAPSHOT.jar

EXPOSE 9001

ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk
ENV PATH="$JAVA_HOME/bin:$PATH"

#creation d'un label indiquant le responsable de ce dockerfile
LABEL email=evan.aljundi@devops-afpa.fr

# designation du repertoire de travail
WORKDIR /usr/local/webApp

ENTRYPOINT ["java", "-jar", "appweb-0.0.1-SNAPSHOT.jar"]