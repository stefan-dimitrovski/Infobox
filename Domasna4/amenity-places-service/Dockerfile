FROM openjdk:11
COPY . /usr/src/myapp/amenity-places-service
WORKDIR /usr/src/myapp/amenity-places-service
ADD ./target/amenity-places-service-0.0.1-SNAPSHOT.jar amenity-places-service.jar
# RUN javac Main.java
CMD ["java", "-jar", "amenity-places-service.jar"]