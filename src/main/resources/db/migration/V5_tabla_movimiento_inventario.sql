CREATE TABLE movimiento_inventario (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       producto_id BIGINT,
                                       usuario_id INT,
                                       tipo VARCHAR(20) NOT NULL,
                                       cantidad INT NOT NULL,
                                       stock_resultante INT NOT NULL,
                                       motivo VARCHAR(255),
                                       fecha DATETIME,

                                       FOREIGN KEY (producto_id) REFERENCES producto(id),
                                       FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

INSERT INTO movimiento_inventario (producto_id, usuario_id, tipo, cantidad, stock_resultante, motivo, fecha)
SELECT id, 1, 'entrada', stock, stock, 'Carga inicial - migración', NOW()
FROM producto
WHERE stock > 0;