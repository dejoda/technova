


INSERT INTO categoria (nombre, descripcion) VALUES
                                                ('Laptops', 'Computadoras portátiles'),
                                                ('Celulares', 'Smartphones y accesorios'),
                                                ('Monitores', 'Pantallas y monitores'),
                                                ('Teclados', 'Teclados mecánicos y normales'),
                                                ('Mouse', 'Mouse gamer y oficina'),
                                                ('Audifonos', 'Audífonos y headsets'),
                                                ('Componentes PC', 'Partes de computadora'),
                                                ('Almacenamiento', 'Discos duros, SSD y memorias USB'),
                                                ('Impresoras', 'Impresoras y escáneres'),
                                                ('Cámaras', 'Cámaras fotográficas y de video'),
                                                ('Tablets', 'Tabletas y e-readers'),
                                                ('Redes', 'Routers, switches y accesorios de red'),
                                                ('Webcams', 'Cámaras web para videollamadas'),
                                                ('Sillas Gamer', 'Sillas ergonómicas para gaming'),
                                                ('Escritorios', 'Escritorios y soportes para PC'),
                                                ('Cooling', 'Ventiladores, coolers y pasta térmica'),
                                                ('Fuentes de Poder', 'Fuentes de alimentación para PC'),
                                                ('Gabinetes', 'Cases y gabinetes para PC'),
                                                ('Smart TV', 'Televisores inteligentes'),
                                                ('Consolas', 'Consolas de videojuegos y accesorios'),
                                                ('Micrófonos', 'Micrófonos para streaming y podcasting'),
                                                ('Parlantes', 'Parlantes y sistemas de sonido'),
                                                ('Proyectores', 'Proyectores para hogar y oficina'),
                                                ('UPS', 'Sistemas de alimentación ininterrumpida'),
                                                ('Cables', 'Cables HDMI, USB, DisplayPort y más'),
                                                ('Hubs y Docks', 'Concentradores USB y estaciones de acoplamiento'),
                                                ('Pads de Mouse', 'Mousepads gamer y de oficina'),
                                                ('Lápices Digitales', 'Stylus y lápices para tablets'),
                                                ('Smartwatch', 'Relojes inteligentes y pulseras fitness'),
                                                ('Drones', 'Drones y accesorios de vuelo'),
                                                ('Realidad Virtual', 'Gafas VR y accesorios'),
                                                ('Streaming', 'Capturadoras, elgato y accesorios para streaming'),
                                                ('Iluminación LED', 'Tiras LED y luces para setup'),
                                                ('Memorias RAM', 'Módulos de memoria RAM DDR4 y DDR5'),
                                                ('Procesadores', 'CPUs Intel y AMD'),
                                                ('Placas Madre', 'Motherboards para PC de escritorio'),
                                                ('Tarjetas Gráficas', 'GPUs NVIDIA y AMD'),
                                                ('Cargadores', 'Cargadores rápidos y baterías portátiles'),
                                                ('Accesorios Celular', 'Fundas, protectores y soportes para celular'),
                                                ('Software', 'Licencias de software y antivirus'),
                                                ('PC de Escritorio', 'Computadoras de escritorio completas'),
                                                ('PC Gamer', 'Equipos gaming de alto rendimiento'),
                                                ('Mini PC', 'Computadoras compactas y portátiles'),
                                                ('All in One', 'Computadoras todo en uno con pantalla integrada');


INSERT INTO caracteristica (nombre) VALUES
-- Generales
('Color'),
('Material'),
('Peso'),
('Dimensiones'),
('Garantia'),
('Iluminacion RGB'),
('Tipo de Conexion'),
('Conectividad'),

-- Laptops / PCs
('Procesador'),
('Numero de Nucleos'),
('Velocidad del Procesador'),
('RAM'),
('Tipo de Memoria'),
('Almacenamiento'),
('Tipo de Almacenamiento'),
('Tarjeta Grafica'),
('Memoria VRAM'),
('Sistema Operativo'),
('Tamaño Pantalla'),
('Tipo de Panel'),
('Resolucion'),
('Frecuencia Hz'),
('Tiempo de Respuesta'),
('Brillo'),
('Bateria'),
('Carga Rapida'),
('Teclado Retroiluminado'),
('Camara Web'),
('Microfono Integrado'),
('Puertos'),
('HDMI'),
('USB'),
('Thunderbolt'),
('Lector de Huella'),
('Grosor'),

-- Celulares / Tablets
('Camara Principal'),
('Camara Frontal'),
('Resistencia al Agua'),
('NFC'),
('GPS'),
('5G'),
('4G LTE'),
('eSIM'),
('Ranura SIM'),
('Carga Inalambrica'),
('Pantalla Tactil'),
('Autonomia'),

-- Monitores / Smart TV
('Relacion de Contraste'),
('HDR'),
('DisplayPort'),
('Relacion de Aspecto'),

-- Teclados
('Numero de Teclas'),
('Switch'),
('Tipo de Teclado'),
('Anti Ghosting'),
('N-Key Rollover'),
('Macro'),
('Perfil Programable'),
('Teclas Multimedia'),
('Reposamuñecas'),

-- Mouse
('DPI'),
('Tipo de Sensor'),
('Numero de Botones'),
('Polling Rate'),
('Sensibilidad'),
('Ambidiestro'),

-- Audifonos / Parlantes / Microfonos
('Frecuencia de Audio'),
('Impedancia'),
('Cancelacion de Ruido'),
('Modo Surround'),
('Sensibilidad Microfono'),
('Potencia'),
('Canales de Audio'),
('Bluetooth'),

-- Componentes PC
('Socket'),
('Chipset'),
('Factor de Forma'),
('TDP'),
('Velocidad de Lectura'),
('Velocidad de Escritura'),
('Interfaz'),

-- Redes
('Velocidad de Red'),
('Frecuencia de Red'),
('Numero de Antenas'),
('WiFi'),
('MU-MIMO'),
('VPN'),
('PoE'),

-- Impresoras
('Velocidad de Impresion'),
('Tipo de Impresion'),
('Resolucion de Impresion'),
('Tipo de Tinta'),
('Escaner Integrado'),
('Impresion Doble Cara'),

-- Camaras / Webcams
('Zoom Optico'),
('Estabilizacion'),
('Formato de Video'),

-- Cooling
('Velocidad de Ventilador'),
('Nivel de Ruido'),

-- Fuentes de Poder / UPS
('Potencia UPS'),
('Tiempo de Respaldo'),
('Numero de Tomas'),
('Proteccion contra Sobretension'),

-- Smartwatch
('Giroscopio'),
('Acelerometro'),
('Ciclos de Carga'),

-- Drones
('Tiempo de Vuelo'),
('Velocidad Maxima Vuelo'),
('Altitud Maxima'),
('Campo de Vision'),

-- Realidad Virtual
('Resolucion por Ojo'),
('Frecuencia de Refresco VR'),
('Seguimiento de Manos'),
('Latencia'),

-- Proyectores
('Lumenes'),
('Distancia de Proyeccion'),
('Vida de Lampara'),
('Keystone'),

-- Almacenamiento externo
('Capacidad'),
('Velocidad USB'),

-- PC de Escritorio / PC Gamer / All in One
('Tipo de Enfriamiento'),
('Incluye Monitor'),
('Incluye Teclado'),
('Incluye Mouse'),
('Ranuras de Expansion'),
('Ranuras RAM'),
('Velocidad RAM'),
('Fuente de Poder'),
('Formato Gabinete'),
('Unidad Optica');


INSERT INTO producto (nombre, descripcion, precio, stock, marca, modelo, garantia, categoria_id) VALUES
                                                                                                     ('Laptop ASUS TUF F15', 'Laptop gamer ASUS', 3500.00, 10, 'ASUS', 'TUF F15', 12, 1),
                                                                                                     ('Laptop Lenovo IdeaPad 3', 'Laptop para oficina y estudio', 2200.00, 15, 'Lenovo', 'IdeaPad 3', 12, 1),

                                                                                                     ('Mouse Logitech G502', 'Mouse gamer RGB', 180.00, 30, 'Logitech', 'G502', 6, 5),
                                                                                                     ('Teclado Redragon Kumara', 'Teclado mecánico RGB', 250.00, 20, 'Redragon', 'Kumara K552', 6, 4),

                                                                                                     ('Monitor LG 24"', 'Monitor Full HD', 600.00, 12, 'LG', '24MK600', 12, 3),
                                                                                                     ('Celular Samsung S21', 'Smartphone gama alta', 2800.00, 8, 'Samsung', 'S21', 12, 2),

                                                                                                     ('Laptop HP Victus 15', 'Laptop gamer HP de alto rendimiento', 3900.00, 9, 'HP', 'Victus 15', 12, 1),
                                                                                                     ('Mouse Razer DeathAdder V2', 'Mouse gamer ergonómico RGB', 210.00, 25, 'Razer', 'DeathAdder V2', 6, 5),

                                                                                                     ('Monitor Samsung Odyssey G5', 'Monitor curvo QHD gamer', 1250.00, 7, 'Samsung', 'Odyssey G5', 12, 3),
                                                                                                     ('Teclado Logitech G Pro', 'Teclado mecánico compacto RGB', 420.00, 14, 'Logitech', 'G Pro', 6, 4),

                                                                                                     ('Laptop Dell Inspiron 15', 'Laptop para estudio y trabajo', 2600.00, 12, 'Dell', 'Inspiron 15', 12, 1),
                                                                                                     ('Laptop Acer Aspire 5', 'Laptop económica y funcional', 2100.00, 18, 'Acer', 'Aspire 5', 12, 1),

                                                                                                     ('Celular iPhone 13', 'Smartphone Apple gama media-alta', 3200.00, 10, 'Apple', 'iPhone 13', 12, 2),
                                                                                                     ('Celular Xiaomi Redmi Note 12', 'Smartphone calidad-precio', 900.00, 25, 'Xiaomi', 'Redmi Note 12', 12, 2),

                                                                                                     ('Monitor AOC 27"', 'Monitor gamer Full HD', 750.00, 14, 'AOC', '27G2', 12, 3),
                                                                                                     ('Mouse HyperX Pulsefire', 'Mouse gamer RGB preciso', 160.00, 35, 'HyperX', 'Pulsefire', 6, 5),

                                                                                                     ('Teclado SteelSeries Apex', 'Teclado mecánico premium', 500.00, 10, 'SteelSeries', 'Apex 3', 12, 4),
                                                                                                     ('Audífonos JBL Quantum', 'Headset gamer envolvente', 320.00, 22, 'JBL', 'Quantum 100', 6, 6),

                                                                                                     ('Componentes PC RTX 4060', 'Tarjeta gráfica de última generación', 1800.00, 6, 'NVIDIA', 'RTX 4060', 24, 7),
                                                                                                     ('Laptop MSI Gaming GF63', 'Laptop gamer potente y ligera', 4200.00, 8, 'MSI', 'GF63 Thin', 12, 1),

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






INSERT INTO producto_caracteristica (producto_id, caracteristica_id, valor) VALUES


(1, 1, '16GB'),
(1, 2, '512GB SSD'),
(1, 3, 'Intel i7'),
(1, 4, 'RTX 3050'),
(1, 5, '15.6 pulgadas'),


(2, 1, '8GB'),
(2, 2, '256GB SSD'),
(2, 3, 'Intel i5'),
(2, 5, '15.6 pulgadas'),


(3, 8, '25600 DPI'),
(3, 9, 'USB'),


(4, 9, 'USB'),
(4, 10, 'Mecanico'),


(5, 5, '24 pulgadas'),
(5, 6, '1920x1080'),
(5, 7, '75Hz'),


(6, 1, '8GB'),
(6, 2, '128GB'),
(6, 5, '6.2 pulgadas'),
(6, 6, '2400x1080'),


(7, 1, '16GB'),
(7, 2, '512GB SSD'),
(7, 3, 'Intel i7'),
(7, 4, 'RTX 4050'),
(7, 5, '15.6 pulgadas'),


(8, 8, '20000 DPI'),
(8, 9, 'USB'),


(9, 5, '27 pulgadas'),
(9, 6, '2560x1440'),
(9, 7, '144Hz'),


(10, 9, 'USB'),
(10, 10, 'Mecanico'),

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
(20, 5, '15.6 pulgadas'),

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




INSERT INTO producto_imagen (id_producto, url_imagen, principal) VALUES

-- 1: Laptop ASUS TUF F15
(1, '/images/products/asus-tuf-f15/asus-tuf-f15-1.jpg', true),
(1, '/images/products/asus-tuf-f15/asus-tuf-f15-2.jpg', false),

-- 2: Laptop Lenovo IdeaPad 3
(2, '/images/products/lenovo-ideapad-3/lenovo-ideapad-3-1.jpg', true),
(2, '/images/products/lenovo-ideapad-3/lenovo-ideapad-3-2.jpg', false),

-- 3: Mouse Logitech G502
(3, '/images/products/logitech-g502/logitech-g502-1.jpg', true),
(3, '/images/products/logitech-g502/logitech-g502-2.jpg', false),

-- 4: Teclado Redragon Kumara
(4, '/images/products/redragon-kumara/redragon-kumara-1.jpg', true),
(4, '/images/products/redragon-kumara/redragon-kumara-2.jpg', false),

-- 5: Monitor LG 24"
(5, '/images/products/lg-ultragear-24/lg-ultragear-24-1.jpg', true),
(5, '/images/products/lg-ultragear-24/lg-ultragear-24-2.jpg', false),

-- 6: Celular Samsung S21
(6, '/images/products/samsung-s21/samsung-s21-1.jpg', true),
(6, '/images/products/samsung-s21/samsung-s21-2.jpg', false),

-- 7: Laptop HP Victus 15
(7, '/images/products/hp-victus-15/hp-victus-15-1.jpg', true),
(7, '/images/products/hp-victus-15/hp-victus-15-2.jpg', false),

-- 8: Mouse Razer DeathAdder V2
(8, '/images/products/razer-deathadder-v2/razer-deathadder-v2-1.jpg', true),
(8, '/images/products/razer-deathadder-v2/razer-deathadder-v2-2.jpg', false),

-- 9: Monitor Samsung Odyssey G5
(9, '/images/products/samsung-odyssey-g5/samsung-odyssey-g5-1.jpg', true),
(9, '/images/products/samsung-odyssey-g5/samsung-odyssey-g5-2.jpg', false),

-- 10: Teclado Logitech G Pro
(10, '/images/products/logitech-g-pro/logitech-g-pro-1.jpg', true),
(10, '/images/products/logitech-g-pro/logitech-g-pro-2.jpg', false),

-- 11: Laptop Dell Inspiron 15
(11, '/images/products/dell-inspiron-15/dell-inspiron-15-1.jpg', true),
(11, '/images/products/dell-inspiron-15/dell-inspiron-15-2.jpg', false),

-- 12: Laptop Acer Aspire 5
(12, '/images/products/acer-aspire-5/acer-aspire-5-1.jpg', true),
(12, '/images/products/acer-aspire-5/acer-aspire-5-2.jpg', false),

-- 13: Celular iPhone 13
(13, '/images/products/iphone-13/iphone-13-1.jpg', true),
(13, '/images/products/iphone-13/iphone-13-2.jpg', false),

-- 14: Celular Xiaomi Redmi Note 12
(14, '/images/products/xiaomi-redmi-note-12/xiaomi-redmi-note-12-1.jpg', true),
(14, '/images/products/xiaomi-redmi-note-12/xiaomi-redmi-note-12-2.jpg', false),

-- 15: Monitor AOC 27"
(15, '/images/products/aoc-27g2/aoc-27g2-1.jpg', true),
(15, '/images/products/aoc-27g2/aoc-27g2-2.jpg', false),

-- 16: Mouse HyperX Pulsefire
(16, '/images/products/hyperx-pulsefire/hyperx-pulsefire-1.jpg', true),
(16, '/images/products/hyperx-pulsefire/hyperx-pulsefire-2.jpg', false),

-- 17: Teclado SteelSeries Apex (carpeta tiene "-1" de más)
(17, '/images/products/steelseries-apex-3-1/steelseries-apex-3-1.jpg', true),
(17, '/images/products/steelseries-apex-3-1/steelseries-apex-3-2.jpg', false),

-- 18: Audífonos JBL Quantum
(18, '/images/products/jbl-quantum-100/jbl-quantum-100-1.jpg', true),
(18, '/images/products/jbl-quantum-100/jbl-quantum-100-2.jpg', false),

-- 19: RTX 4060
(19, '/images/products/nvidia-rtx-4060/nvidia-rtx-4060-1.jpg', true),
(19, '/images/products/nvidia-rtx-4060/nvidia-rtx-4060-2.jpg', false),

-- 20: Laptop MSI GF63
(20, '/images/products/msi-gf63-thin/msi-gf63-thin-1.jpg', true),
(20, '/images/products/msi-gf63-thin/msi-gf63-thin-2.jpg', false),

-- 21: Laptop Huawei MateBook D15
(21, '/images/products/huawei-matebook-d15/huawei-matebook-d15-1.jpg', true),
(21, '/images/products/huawei-matebook-d15/huawei-matebook-d15-2.jpg', false),

-- 22: Laptop Razer Blade 15
(22, '/images/products/razer-blade-15/razer-blade-15-1.jpg', true),
(22, '/images/products/razer-blade-15/razer-blade-15-2.jpg', false),

-- 23: Celular OnePlus 11
(23, '/images/products/oneplus-11/oneplus-11-1.jpg', true),
(23, '/images/products/oneplus-11/oneplus-11-2.jpg', false),

-- 24: Celular Motorola G84
(24, '/images/products/motorola-g84/motorola-g84-1.jpg', true),
(24, '/images/products/motorola-g84/motorola-g84-2.jpg', false),

-- 25: Monitor ASUS VG249Q
(25, '/images/products/asus-vg249q/asus-vg249q-1.jpg', true),
(25, '/images/products/asus-vg249q/asus-vg249q-2.jpg', false),

-- 26: Monitor BenQ GW2780
(26, '/images/products/benq-gw2780/benq-gw2780-1.jpg', true),
(26, '/images/products/benq-gw2780/benq-gw2780-2.jpg', false),

-- 27: Mouse Corsair Harpoon RGB
(27, '/images/products/corsair-harpoon-rgb/corsair-harpoon-rgb-1.jpg', true),
(27, '/images/products/corsair-harpoon-rgb/corsair-harpoon-rgb-2.jpg', false),

-- 28: Mouse Microsoft Basic Optical
(28, '/images/products/microsoft-basic-optical/microsoft-basic-optical-1.jpg', true),
(28, '/images/products/microsoft-basic-optical/microsoft-basic-optical-2.jpg', false),

-- 29: Teclado HP Pavilion
(29, '/images/products/hp-pavilion-keyboard/hp-pavilion-keyboard-1.jpg', true),
(29, '/images/products/hp-pavilion-keyboard/hp-pavilion-keyboard-2.jpg', false),

-- 30: Audífonos Sony WH-CH520
(30, '/images/products/sony-wh-ch520/sony-wh-ch520-1.jpg', true),
(30, '/images/products/sony-wh-ch520/sony-wh-ch520-2.jpg', false);


