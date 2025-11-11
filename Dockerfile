# Imagen base con JDK 17 (Render soporta OpenJDK)
FROM eclipse-temurin:17-jdk-alpine

# Establecer directorio de trabajo
WORKDIR /app

# Copiar pom.xml y descargar dependencias (para cacheo)
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

RUN ./mvnw dependency:go-offline -B

# Copiar el resto del código fuente
COPY src ./src

# Compilar el proyecto (sin tests)
RUN ./mvnw clean package -DskipTests

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "target/consultorios-0.0.1-SNAPSHOT.jar"]
