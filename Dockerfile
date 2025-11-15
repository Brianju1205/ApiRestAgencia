# Etapa 1: Construir el proyecto con Maven y Java 17
FROM maven:3.8.5-openjdk-17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el pom.xml y el c�digo fuente
COPY pom.xml .
COPY src ./src

# Limpiar e instalar el proyecto (esto crea el .jar)
RUN mvn clean install -DskipTests


# Etapa 2: Crear la imagen final de ejecuci�n (m�s ligera)
FROM amazoncorretto:17-alpine-jre

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar solo el .jar de la etapa de construcci�n
# Aseg�rate que el nombre del .jar sea el de tu pom.xml
COPY --from=build /app/target/ApiRestAgencia-0.0.1-SNAPSHOT.jar .

# Exponer el puerto 8080 (aunque Render lo maneja, es buena pr�ctica)
EXPOSE 8080

# Comando para ejecutar la aplicaci�n
ENTRYPOINT ["java", "-jar", "ApiRestAgencia-0.0.1-SNAPSHOT.jar"]