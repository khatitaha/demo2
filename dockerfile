# Use OpenJDK 17 LTS Alpine (smallest size)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy project
COPY . .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the jar
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run Spring Boot app
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
