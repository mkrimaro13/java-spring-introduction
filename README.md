# Proyecto de práctica

## Sobre la composición de los contenedores

### Contexto

Haciendo referencia a la [documentación](https://docs.docker.com/build/concepts/context/) según la documentación, el contexto de `build` es un conjunto de archivo al que se tiene acceso.

Puede ser una ruta relativa o absoluta del sistema o una url.

Si se ejecuta el comando, es la ruta que se pasa por parámetro:

```bash
docker build <PATH | URL | . >
```

Si se usa en el archivo `docker-compose.yaml` se indica mediante un parámetro:

Se puede indicar como un parámetro separado:

```YAML
api:
  build:
    context: .
    dockerfile: ./deployment/application/Dockerfile
```

Se puede indicar solamente el contexto:

```YAML
database:
  build:
    context: ./deployment/database
```

Si es un sistema de archivos, como un directorio, un repositorio de git (local o remoto) o un archivo `tar`, el contexto pasa a ser el conjunto de archivos, carpetas y sub-carpetas disponibles en dicha ruta.
