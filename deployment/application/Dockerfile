# Para lo que sería producción
# Etapa 1: Compilación
# FROM gradle:9.3.0-jdk21-alpine AS build
# WORKDIR /app
# COPY build.gradle settings.gradle ./
# COPY ./src/ ./src/
# RUN gradle bootJar --no-daemon

# # Etapa 2: Ejecución
# FROM eclipse-temurin:21-jre-alpine
# WORKDIR /app
# # Copiamos solo el .jar generado desde la etapa de compilación
# COPY --from=build /app/build/libs/app.jar app.jar
# # Exponemos el puerto de tu app (comúnmente 8080)
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "app.jar"]

FROM gradle:8.5-jdk21
WORKDIR /app
# No se copia directamente el código, se copiará en un volumen en el compose
# Exponemos el puerto de la app y el de debug (opcional)
EXPOSE 8090 5005
# Comando para ejecutar en modo desarrollo con recarga automática
ENTRYPOINT ["gradle", "bootRun", "--continuous", "-PskipDownload=true"]