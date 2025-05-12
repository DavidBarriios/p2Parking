# Usa una imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Copia el archivo .jar de la aplicación (asegúrate de que el archivo .jar está en target/)
COPY target/paking-0.0.1-SNAPSHOT.jar /app/paking.jar

# Expone el puerto 8080
EXPOSE 8081

# Ejecuta el archivo .jar de la aplicación
ENTRYPOINT ["java", "-jar", "/app/paking.jar"]