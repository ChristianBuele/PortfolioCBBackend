# Etapa 1: build (usa Maven + JDK 17)
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos definición del proyecto y dependencias
COPY pom.xml .
COPY src ./src

# Construimos el jar (sin tests para ir más rápido)
RUN mvn clean package -DskipTests

# Etapa 2: runtime (solo JRE, más liviano)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiamos el jar ya construido desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Puerto interno de la app
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
