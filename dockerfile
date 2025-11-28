# Use OpenJDK 20 (or 17 for LTS)
FROM openjdk:20-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven build files
COPY pom.xml .
COPY src ./src

# Build the project
RUN ./mvnw clean package -DskipTests

# Copy the jar
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","app.jar"]
