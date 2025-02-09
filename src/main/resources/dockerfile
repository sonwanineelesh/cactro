# Use an official Maven image to build the project
FROM maven:3.8.6-openjdk-17 AS build

WORKDIR /app

# Copy the project files
COPY . .

# Build the application (creates a JAR file in /target)
RUN mvn clean package -DskipTests

# Use a smaller JDK runtime to run the built application
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy only the built JAR file
COPY --from=build /app/target/cactro-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
