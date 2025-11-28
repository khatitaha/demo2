# Use official OpenJDK 17 LTS slim image
FROM openjdk:17-jdk-slim

# Install Maven dependencies if not using wrapper (optional)
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy Maven wrapper and project files
COPY . .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the Spring Boot jar (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Expose port (change if your app uses a different port)
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
