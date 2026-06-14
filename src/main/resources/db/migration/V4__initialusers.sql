
-- USUARIOS
-- Admin123*
INSERT INTO usuario (username, password, rol_id) VALUES
    ('admin',    '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 1);
-- Vendedor123*
INSERT INTO usuario (username, password, rol_id) VALUES
    ('vendedor', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 2);
-- Cliente123*
INSERT INTO usuario (username, password, rol_id) VALUES
    ('cliente',  '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi', 3);

-- PERFILES
INSERT INTO administrador (nombre, apellido, correo, telefono, usuario_id) VALUES
    ('Carlos', 'Quispe', 'admin@technova.com', '999000001', 1);

INSERT INTO vendedor (nombre, apellido, correo, telefono, usuario_id) VALUES
    ('Luis', 'Mamani', 'vendedor@technova.com', '999000002', 2);

INSERT INTO cliente (nombre, apellido, correo, telefono, usuario_id) VALUES
    ('María', 'Torres', 'cliente@technova.com', '999000003', 3);