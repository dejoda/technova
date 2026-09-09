-- Migration to create Marca table and link it to Producto
CREATE TABLE marca (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE
);

ALTER TABLE producto ADD COLUMN marca_id BIGINT;
ALTER TABLE producto ADD CONSTRAINT fk_producto_marca FOREIGN KEY (marca_id) REFERENCES marca(id);
