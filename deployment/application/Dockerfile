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

FROM gradle:9-jdk25
WORKDIR /app
EXPOSE 8090
EXPOSE 35729
# Comando para ejecutar en modo desarrollo con recarga automática
ENTRYPOINT ["gradle", "bootRun", "--continuous", "-Dorg.gradle.vfs.watch=true"]