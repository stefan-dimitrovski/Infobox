# FROM openjdk:latest

# ADD ./eureka-server-0.0.1-SNAPSHOT.jar app.jar

# ENTRYPOINT [ "java", "-jar", "app.jar" ]

# EXPOSE 8761

FROM openjdk:11
COPY . /usr/src/myapp/infoboxGlaven-master
WORKDIR /usr/src/myapp/infoboxGlaven-master
ADD ./target/infobox-0.0.1-SNAPSHOT.jar infoboxGlaven-master.jar
# RUN javac Main.java
CMD ["java", "-jar", "infoboxGlaven-master.jar"]