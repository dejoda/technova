INSERT INTO producto (nombre, descripcion, precio, stock, marca, modelo, garantia, categoria_id) VALUES
                                                                                                     ('Laptop Dell Inspiron 15', 'Laptop para estudio y trabajo', 2600.00, 12, 'Dell', 'Inspiron 15', 12, 1),
                                                                                                     ('Laptop Acer Aspire 5', 'Laptop económica y funcional', 2100.00, 18, 'Acer', 'Aspire 5', 12, 1),
                                                                                                     ('Celular iPhone 13', 'Smartphone Apple gama media-alta', 3200.00, 10, 'Apple', 'iPhone 13', 12, 2),
                                                                                                     ('Celular Xiaomi Redmi Note 12', 'Smartphone calidad-precio', 900.00, 25, 'Xiaomi', 'Redmi Note 12', 12, 2),
                                                                                                     ('Monitor AOC 27"', 'Monitor gamer Full HD', 750.00, 14, 'AOC', '27G2', 12, 3),
                                                                                                     ('Mouse HyperX Pulsefire', 'Mouse gamer RGB preciso', 160.00, 35, 'HyperX', 'Pulsefire', 6, 5),
                                                                                                     ('Teclado SteelSeries Apex', 'Teclado mecánico premium', 500.00, 10, 'SteelSeries', 'Apex 3', 12, 4),
                                                                                                     ('Audífonos JBL Quantum', 'Headset gamer envolvente', 320.00, 22, 'JBL', 'Quantum 100', 6, 6),
                                                                                                     ('Componentes PC RTX 4060', 'Tarjeta gráfica de última generación', 1800.00, 6, 'NVIDIA', 'RTX 4060', 24, 7),
                                                                                                     ('Laptop MSI Gaming GF63', 'Laptop gamer potente y ligera', 4200.00, 8, 'MSI', 'GF63 Thin', 12, 1);
INSERT INTO producto_caracteristica (producto_id, caracteristica_id, valor) VALUES

-- 11 Dell Inspiron
(11, 1, '8GB'),
(11, 2, '512GB SSD'),
(11, 3, 'Intel i5'),
(11, 5, '15.6 pulgadas'),

-- 12 Acer Aspire
(12, 1, '8GB'),
(12, 2, '256GB SSD'),
(12, 3, 'Intel i3'),
(12, 5, '15.6 pulgadas'),

-- 13 iPhone 13
(13, 1, '4GB'),
(13, 2, '128GB'),
(13, 5, '6.1 pulgadas'),
(13, 6, '2532x1170'),

-- 14 Xiaomi Redmi Note 12
(14, 1, '6GB'),
(14, 2, '128GB'),
(14, 5, '6.67 pulgadas'),
(14, 6, '2400x1080'),

-- 15 Monitor AOC
(15, 5, '27 pulgadas'),
(15, 6, '1920x1080'),
(15, 7, '144Hz'),

-- 16 Mouse HyperX
(16, 8, '16000 DPI'),
(16, 9, 'USB'),

-- 17 Teclado SteelSeries
(17, 9, 'USB'),
(17, 10, 'Mecanico'),

-- 18 Audifonos JBL
(18, 9, 'Inalambrico'),
(18, 6, '7.1 Surround'),

-- 19 RTX 4060
(19, 4, 'RTX 4060'),
(19, 9, 'PCIe 4.0'),

-- 20 MSI GF63
(20, 1, '16GB'),
(20, 2, '512GB SSD'),
(20, 3, 'Intel i7'),
(20, 4, 'RTX 4050'),
(20, 5, '15.6 pulgadas');

INSERT INTO producto_imagen (id_producto, url_imagen, principal) VALUES
                                                                     (11, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (12, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (13, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (14, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (15, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (16, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (17, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (18, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (19, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (20, 'https://via.placeholder.com/800x800?text=producto', true);




INSERT INTO producto (nombre, descripcion, precio, stock, marca, modelo, garantia, categoria_id) VALUES

                                                                                                     ('Laptop Huawei MateBook D15', 'Laptop elegante para oficina y estudio', 2400.00, 14, 'Huawei', 'MateBook D15', 12, 1),
                                                                                                     ('Laptop Razer Blade 15', 'Laptop gamer premium de alto rendimiento', 8500.00, 5, 'Razer', 'Blade 15', 24, 1),

                                                                                                     ('Celular OnePlus 11', 'Smartphone gama alta rendimiento fluido', 3300.00, 9, 'OnePlus', '11', 12, 2),
                                                                                                     ('Celular Motorola G84', 'Smartphone económico y equilibrado', 1100.00, 20, 'Motorola', 'G84', 12, 2),

                                                                                                     ('Monitor ASUS VG249Q', 'Monitor gamer IPS 144Hz', 850.00, 11, 'ASUS', 'VG249Q', 12, 3),
                                                                                                     ('Monitor BenQ 27"', 'Monitor profesional para diseño', 1200.00, 8, 'BenQ', 'GW2780', 12, 3),

                                                                                                     ('Mouse Corsair Harpoon', 'Mouse gamer ligero y preciso', 140.00, 28, 'Corsair', 'Harpoon RGB', 6, 5),
                                                                                                     ('Mouse Microsoft Basic', 'Mouse sencillo para oficina', 60.00, 50, 'Microsoft', 'Basic Optical', 6, 5),

                                                                                                     ('Teclado HP Pavilion', 'Teclado cómodo para uso diario', 120.00, 30, 'HP', 'Pavilion Keyboard', 6, 4),
                                                                                                     ('Audifonos Sony WH-CH520', 'Audífonos inalámbricos con buen sonido', 220.00, 18, 'Sony', 'WH-CH520', 12, 6);

INSERT INTO producto_imagen (id_producto, url_imagen, principal) VALUES
                                                                     (21, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (22, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (23, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (24, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (25, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (26, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (27, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (28, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (29, 'https://via.placeholder.com/800x800?text=producto', true),
                                                                     (30, 'https://via.placeholder.com/800x800?text=producto', true);


INSERT INTO producto_caracteristica (producto_id, caracteristica_id, valor) VALUES

-- 21 Huawei MateBook D15
(21, 1, '8GB'),
(21, 2, '512GB SSD'),
(21, 3, 'Intel i5'),
(21, 5, '15.6 pulgadas'),

-- 22 Razer Blade 15
(22, 1, '16GB'),
(22, 2, '1TB SSD'),
(22, 3, 'Intel i7'),
(22, 4, 'RTX 4070'),
(22, 5, '15.6 pulgadas'),

-- 23 OnePlus 11
(23, 1, '12GB'),
(23, 2, '256GB'),
(23, 5, '6.7 pulgadas'),
(23, 6, '3216x1440'),

-- 24 Motorola G84
(24, 1, '8GB'),
(24, 2, '256GB'),
(24, 5, '6.5 pulgadas'),
(24, 6, '2400x1080'),

-- 25 Monitor ASUS VG249Q
(25, 5, '24 pulgadas'),
(25, 6, '1920x1080'),
(25, 7, '144Hz'),

-- 26 Monitor BenQ
(26, 5, '27 pulgadas'),
(26, 6, '2560x1440'),
(26, 7, '60Hz'),

-- 27 Mouse Corsair Harpoon
(27, 8, '10000 DPI'),
(27, 9, 'USB'),

-- 28 Mouse Microsoft Basic
(28, 8, '1000 DPI'),
(28, 9, 'USB'),

-- 29 Teclado HP Pavilion
(29, 9, 'USB'),
(29, 10, 'Membrana'),

-- 30 Audifonos Sony WH-CH520
(30, 9, 'Bluetooth'),
(30, 6, 'Estereo');