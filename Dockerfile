# Imagen base con Java 17
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar archivos necesarios para compilar
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Descargar dependencias (para cache)
RUN ./mvnw dependency:go-offline -B

# Copiar el código fuente
COPY src ./src

# Compilar la aplicación sin tests
RUN ./mvnw clean package -DskipTests

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar el .jar final
CMD ["java", "-jar", "target/consultorios-0.0.1-SNAPSHOT.jar"]
