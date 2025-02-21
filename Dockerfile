FROM openjdk:21-jdk

# designation du repertoire de travail
WORKDIR /app

COPY appweb-0.0.1-SNAPSHOT.jar appweb-0.0.1-SNAPSHOT.jar

EXPOSE 9001

ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk
ENV PATH="$JAVA_HOME/bin:$PATH"

#creation d'un label indiquant le responsable de ce dockerfile
LABEL email=evan.aljundi@devops-afpa.fr

ENTRYPOINT ["java", "-jar", "appweb-0.0.1-SNAPSHOT.jar"]