FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Create a directory for SQL scripts
RUN mkdir -p /app/sql
COPY create_database.sql /app/sql/
COPY insert_data.sql /app/sql/

# Set environment variables
ENV POSTGRES_URL=jdbc:postgresql://postgres:5432/api
ENV POSTGRES_USER=root
ENV POSTGRES_PASSWORD=root
ENV JWT_SECRET=your-secret-key
ENV JWT_EXPIRATION=86400000

# Expose the application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"] 