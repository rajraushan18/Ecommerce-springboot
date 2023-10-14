# Use the official OpenJDK base image with Java 17
FROM openjdk:17

# Set the working directory inside the container
#WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

ENV JAVA_OPTS=""

# Expose the port your microservice is listening on
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

#ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]