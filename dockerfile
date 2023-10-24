# Use a base image with Java pre-installed
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built by your Spring Boot application to the container
COPY target/queueService-0.0.1-SNAPSHOT.jar /app/queueService.jar

# Expose the port your Spring Boot application runs on
EXPOSE 8080

# Command to run your Java application
CMD ["java" , "-jar", "queueService.jar"]