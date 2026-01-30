DO
$$
    BEGIN
        IF
            NOT EXISTS(SELECT 1
                       FROM pg_database
                       WHERE datname = 'tienda') THEN
            PERFORM DBLINK_EXEC('dbname=postgres', 'CREATE DATABASE tienda');
        END IF;
    END
$$;

\c tienda;

CREATE SCHEMA IF NOT EXISTS comercial;

SET search_path TO comercial, public;

SHOW search_path;

CREATE TABLE IF NOT EXISTS categorias
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    activo BOOLEAN     NOT NULL DEFAULT TRUE
);


-- -----------------------------------------------------
-- Table PRODUCTOS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS productos
(
    id          SERIAL PRIMARY KEY,
    nombre      VARCHAR(45) NOT NULL,
    descripcion TEXT,
    activo      BOOLEAN     NOT NULL DEFAULT TRUE
);


CREATE TABLE IF NOT EXISTS categorias_productos
(
    id_producto  INT REFERENCES productos (id) ON DELETE CASCADE,
    id_categoria INT REFERENCES CATEGORIAS (id) ON DELETE CASCADE,
    PRIMARY KEY (id_producto, id_categoria)
);

CREATE TABLE IF NOT EXISTS variantes_productos
(
    id                   SERIAL PRIMARY KEY,
    id_producto          INT                NOT NULL REFERENCES productos (id) ON DELETE CASCADE,
    sku                  VARCHAR(50) UNIQUE NOT NULL,
    precio               DECIMAL(12, 2)     NOT NULL,
    descuento            INT                NOT NULL CHECK ( descuento < 100 )          DEFAULT 0,
    unidades_disponibles INT                NOT NULL CHECK ( unidades_disponibles >= 0) DEFAULT 0,
    enlace_imagen        TEXT
);

CREATE TABLE IF NOT EXISTS atributos
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS valores_atributos
(
    id          SERIAL PRIMARY KEY,
    id_atributo INT REFERENCES atributos (id) ON DELETE CASCADE,
    valor       VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS valores_variantes
(
    id_variante       INT REFERENCES variantes_productos (id),
    id_valor_atributo INT REFERENCES valores_atributos (id),
    PRIMARY KEY (id_variante, id_valor_atributo)
);

CREATE SCHEMA IF NOT EXISTS management;

SET search_path TO management, public;

SHOW search_path;

\dn