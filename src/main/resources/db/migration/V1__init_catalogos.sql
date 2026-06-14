CREATE TABLE categoria (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nombre VARCHAR(100) NOT NULL,
                           descripcion VARCHAR(255)
);

CREATE TABLE caracteristica (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                nombre VARCHAR(100) NOT NULL
);

CREATE TABLE rol (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     nombre VARCHAR(50) NOT NULL
);

CREATE TABLE usuario (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         username VARCHAR(100) NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         rol_id INT,
                         FOREIGN KEY (rol_id) REFERENCES rol(id)
);

CREATE TABLE administrador (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               nombre VARCHAR(100),
                               apellido VARCHAR(100),
                               correo VARCHAR(150) UNIQUE,
                               telefono VARCHAR(20),
                               usuario_id INT UNIQUE,
                               FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE vendedor (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100),
                          apellido VARCHAR(100),
                          correo VARCHAR(150) UNIQUE,
                          telefono VARCHAR(20),
                          usuario_id INT UNIQUE,
                          FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE producto (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(150) NOT NULL,
                          descripcion TEXT,
                          precio DECIMAL(10,2) NOT NULL,
                          stock INT NOT NULL,
                          marca VARCHAR(100),
                          modelo VARCHAR(100),
                          garantia INT,
                          categoria_id BIGINT,
                          FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

CREATE TABLE cliente (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100),
                         apellido VARCHAR(100),
                         correo VARCHAR(150) UNIQUE,
                         telefono VARCHAR(20),
                         usuario_id INT UNIQUE,
                         FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE direccion (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           cliente_id INT,
                           direccion VARCHAR(255),
                           ciudad VARCHAR(100),
                           referencia VARCHAR(255),
                           FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE pedido (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        cliente_id INT,
                        fecha DATETIME,
                        total DECIMAL(10,2),
                        estado VARCHAR(50),
                        FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE detalle_pedido (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                pedido_id INT,
                                producto_id BIGINT,
                                cantidad INT,
                                precio DECIMAL(10,2),
                                FOREIGN KEY (pedido_id) REFERENCES pedido(id),
                                FOREIGN KEY (producto_id) REFERENCES producto(id)
);

CREATE TABLE pago (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      pedido_id INT,
                      monto DECIMAL(10,2),
                      metodo VARCHAR(50),
                      fecha DATETIME,
                      FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);

CREATE TABLE producto_caracteristica (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         producto_id BIGINT,
                                         caracteristica_id BIGINT,
                                         valor VARCHAR(255),

                                         FOREIGN KEY (producto_id)
                                             REFERENCES producto(id)
                                             ON DELETE CASCADE,

                                         FOREIGN KEY (caracteristica_id)
                                             REFERENCES caracteristica(id)
);

CREATE TABLE producto_imagen (
                                 id_imagen BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 id_producto BIGINT,
                                 url_imagen VARCHAR(500),
                                 principal BOOLEAN,

                                 FOREIGN KEY (id_producto)
                                     REFERENCES producto(id)
                                     ON DELETE CASCADE
);