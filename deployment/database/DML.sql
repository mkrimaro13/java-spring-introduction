\c tienda;

SET search_path TO comercial, public;

INSERT INTO categorias (nombre)
VALUES ('ropa interior'),
       ('ropa casual'),
       ('vestidos'),
       ('ropa de noche'),
       ('camisas'),
       ('camisetas'),
       ('pantalones'),
       ('abrigos'),
       ('sacos'),
       ('chaquetas'),
       ('ropa deportiva');

INSERT INTO productos (nombre, descripcion)
VALUES ('Brazier básico', 'Diseño ergonómico y sin costuras, ideal para el uso diario bajo cualquier tipo de prenda.'),
       ('Camisón', 'La prenda ideal para tus momentos íntimos, confeccionada en seda suave para un descanso elegante.'),
       ('Brazier de encaje',
        'La comodidad y la elegencia en una pieza de ropa interior de alta calidad con detalles florales.'),
       ('Panty tipo hipster', 'Corte moderno de tiro medio que ofrece cobertura total y un ajuste perfecto al cuerpo.'),
       ('Panty de encaje', 'Sensualidad y delicadeza con bordes ultra planos que no se marcan en la ropa exterior.'),
       ('Pantalón tiro alto',
        'Silueta estilizada que realza la figura, perfecto para looks de oficina o eventos casuales.'),
       ('Abrigo de invierno', 'Protección térmica superior con forro acolchado y exterior resistente al viento.'),
       ('Camisa a cuadros tipo polo',
        'El equilibrio perfecto entre lo deportivo y lo formal con tejido transpirable de algodón.'),
       ('Jogger',
        'Comodidad urbana con pretina elástica y materiales suaves, ideal para el home-office o entrenamiento ligero.'),
       ('Legging', 'Tejido elástico de alta densidad que ofrece soporte y libertad de movimiento total.'),
       ('Vestido corto', 'Diseño versátil y fresco, ideal para días soleados o salidas casuales con amigos.'),
       ('Vestido Largo', 'Elegancia fluida con caída natural, perfecto para eventos formales o noches de verano.');

INSERT INTO categorias_productos(id_categoria, id_producto)
VALUES (1, 1),
       (1, 2),
       (3, 2),
       (4, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (7, 6),
       (8, 7),
       (5, 8),
       (6, 8),
       (2, 9),
       (11, 9),
       (3, 10),
       (2, 10),
       (3, 11);

INSERT INTO atributos(nombre)
VALUES ('talla'),
       ('color'),
       ('material');

INSERT INTO valores_atributos (id_atributo, valor)
VALUES (1, 'S'),
       (1, 'M'),
       (1, 'XS'),
       (1, 'L'),
       (1, 'XL'),
       (2, 'Negro'),
       (2, 'Blanco'),
       (2, 'Rojo'),
       (2, 'Azul'),
       (2, 'Estampado'),
       (3, 'Algodón'),
       (3, 'Poliester'),
       (3, 'Lana'),
       (3, 'Seda'),
       (3, 'Satín');

INSERT INTO variantes_productos (id_producto, sku, precio, descuento, unidades_disponibles, enlace_imagen)
VALUES (1, 'BR-BAS-NEG-M', 25000.00, 0, 50, 'https://pixabay.com/images/download/ai-generated-9482051_1920.jpg'),
       (1, 'BR-BAS-BLA-S', 25000.00, 10, 30, 'https://pixabay.com/images/download/ai-generated-8471328_1920.png'),
       (2, 'CAM-SEDA-ROJ-M', 45000.00, 0, 15, 'https://pixabay.com/images/download/ai-generated-9130330_1920.png'),
       (3, 'BR-ENC-NEG-L', 35000.00, 15, 20, 'https://pixabay.com/images/download/beautiful-8621774_1920.png'),
       (3, 'BR-ENC-ROJ-M', 35000.00, 0, 25, 'https://pixabay.com/images/download/ai-generated-9075426_1920.png'),
       (4, 'PAN-HIP-AZU-S', 12000.00, 0, 100, 'https://pixabay.com/images/download/ai-generated-8689568_1920.png'),
       (7, 'ABR-INV-NEG-XL', 180000.00, 20, 10, 'https://pixabay.com/images/download/coat-947395_1920.jpg'),
       (7, 'ABR-INV-AZU-L', 180000.00, 0, 12, 'https://pixabay.com/images/download/woman-8274960_1920.jpg'),
       (9, 'JOG-GRIS-M', 55000.00, 5, 40, 'https://pixabay.com/images/download/walk-617389_1920.jpg'),
       (12, 'VES-LAR-ROJ-S', 95000.00, 0, 8, 'https://pixabay.com/images/download/rose-7228242_1920.jpg'),
       (11, 'VES-COR-ROJ-M', 90000.00, 8, 15, 'https://pixabay.com/images/download/summer-1188515_1920.jpg');

INSERT INTO valores_variantes (id_variante, id_valor_atributo)
VALUES (1, 2),
       (1, 6),
       (2, 1),
       (2, 7),
       (3, 2),
       (3, 8),
       (3, 14),
       (4, 4),
       (4, 6),
       (5, 2),
       (5, 8),
       (6, 1),
       (6, 9),
       (6, 11),
       (7, 5),
       (7, 6),
       (7, 13),
       (8, 4),
       (8, 9),
       (9, 2),
       (9, 9),
       (9, 12),
       (10, 1),
       (10, 8),
       (10, 14),
       (11, 2),
       (11, 8);