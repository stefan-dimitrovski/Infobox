# FROM openjdk:latest

# ADD ./eureka-server-0.0.1-SNAPSHOT.jar app.jar

# ENTRYPOINT [ "java", "-jar", "app.jar" ]

# EXPOSE 8761

FROM openjdk:11
COPY . /usr/src/myapp/eureka-server
WORKDIR /usr/src/myapp/eureka-server
ADD ./target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
# RUN javac Main.java
CMD ["java", "-jar", "eureka-server.jar"]