-- ============================================================
-- BASE DE DATOS: bdfarmacia (Con Módulo de Acceso Unificado)
-- Sistema de gestión para farmacia
-- Motor: MySQL / InnoDB
-- Compatible con phpMyAdmin
-- ============================================================


-- ============================================================
-- 1. CONFIGURACIÓN INICIAL
-- ============================================================

SET SQL_MODE = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

SET FOREIGN_KEY_CHECKS = 0;


-- ============================================================
-- 2. CREAR Y USAR BASE DE DATOS
-- ============================================================

DROP DATABASE IF EXISTS bdfarmacia;

CREATE DATABASE bdfarmacia
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE bdfarmacia;


-- ============================================================
-- 3. TABLAS DE CATÁLOGO (Incluye Cargo para el Acceso)
-- ============================================================

-- 3.1 Tipo de Personal
DROP TABLE IF EXISTS tipo_personal;

CREATE TABLE tipo_personal (
    id_tipo_personal INT UNSIGNED AUTO_INCREMENT,
    nombre_tipo_personal VARCHAR(100) NOT NULL,
    observaciones VARCHAR(255) NULL,
    PRIMARY KEY (id_tipo_personal),
    CONSTRAINT uq_tipo_personal_nombre UNIQUE (nombre_tipo_personal)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 3.2 Área
DROP TABLE IF EXISTS area;

CREATE TABLE area (
    id_area INT UNSIGNED AUTO_INCREMENT,
    nombre_area VARCHAR(100) NOT NULL,
    observaciones VARCHAR(255) NULL,
    PRIMARY KEY (id_area),
    CONSTRAINT uq_area_nombre UNIQUE (nombre_area)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 3.3 Cargo (Base para los perfiles y validación de usuarios)
DROP TABLE IF EXISTS cargo;

CREATE TABLE cargo (
    id_cargo INT UNSIGNED AUTO_INCREMENT,
    nombre_cargo VARCHAR(100) NOT NULL,
    estado_cargo TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (id_cargo),
    CONSTRAINT uq_cargo_nombre UNIQUE (nombre_cargo)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 3.4 Unidad de Medida
DROP TABLE IF EXISTS unidad_medida;

CREATE TABLE unidad_medida (
    id_unidad_medida INT UNSIGNED AUTO_INCREMENT,
    nombre_unidad VARCHAR(100) NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_unidad_medida),
    CONSTRAINT uq_unidad_nombre UNIQUE (nombre_unidad),
    CONSTRAINT uq_unidad_abreviatura UNIQUE (abreviatura)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 3.5 Categoría
DROP TABLE IF EXISTS categoria;

CREATE TABLE categoria (
    id_categoria INT UNSIGNED AUTO_INCREMENT,
    nombre_categoria VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_categoria),
    CONSTRAINT uq_categoria_nombre UNIQUE (nombre_categoria)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 3.6 Subcategoría
DROP TABLE IF EXISTS subcategoria;

CREATE TABLE subcategoria (
    id_subcategoria INT UNSIGNED AUTO_INCREMENT,
    nombre_subcategoria VARCHAR(100) NOT NULL,
    id_categoria INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_subcategoria),
    CONSTRAINT uq_subcategoria_categoria UNIQUE (id_categoria, nombre_subcategoria),
    CONSTRAINT fk_subcategoria_categoria FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_subcategoria_categoria ON subcategoria (id_categoria);

-- 3.7 Presentación
DROP TABLE IF EXISTS presentacion;

CREATE TABLE presentacion (
    id_presentacion INT UNSIGNED AUTO_INCREMENT,
    nombre_presentacion VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_presentacion),
    CONSTRAINT uq_presentacion_nombre UNIQUE (nombre_presentacion)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 3.8 Método de Pago
DROP TABLE IF EXISTS metodo_pago;

CREATE TABLE metodo_pago (
    id_metodo_pago INT UNSIGNED AUTO_INCREMENT,
    nombre_metodo VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255) NULL,
    PRIMARY KEY (id_metodo_pago),
    CONSTRAINT uq_metodo_pago_nombre UNIQUE (nombre_metodo)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 3.9 Tipo de Comprobante
DROP TABLE IF EXISTS tipo_comprobante;

CREATE TABLE tipo_comprobante (
    id_tipo_comprobante INT UNSIGNED AUTO_INCREMENT,
    nombre_tipo VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255) NULL,
    PRIMARY KEY (id_tipo_comprobante),
    CONSTRAINT uq_tipo_comprobante_nombre UNIQUE (nombre_tipo)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;


-- ============================================================
-- 4. SUCURSAL Y PERSONAL (Módulo de Acceso: Tabla Usuario)
-- ============================================================

-- 4.1 Sucursal
DROP TABLE IF EXISTS sucursal;

CREATE TABLE sucursal (
    id_sucursal INT UNSIGNED AUTO_INCREMENT,
    nombre_sucursal VARCHAR(150) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(20) NULL,
    PRIMARY KEY (id_sucursal),
    CONSTRAINT uq_sucursal_nombre UNIQUE (nombre_sucursal)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 4.2 Personal
DROP TABLE IF EXISTS personal;

CREATE TABLE personal (
    id_personal INT UNSIGNED AUTO_INCREMENT,
    id_tipo_personal INT UNSIGNED NOT NULL,
    id_cargo INT UNSIGNED NOT NULL,
    id_area INT UNSIGNED NOT NULL,
    id_sucursal INT UNSIGNED NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    dni VARCHAR(15) NOT NULL,
    direccion VARCHAR(255) NULL,
    telefono VARCHAR(20) NULL,
    correo VARCHAR(150) NULL,
    observaciones VARCHAR(255) NULL,
    estado TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (id_personal),
    CONSTRAINT uq_personal_dni UNIQUE (dni),
    CONSTRAINT uq_personal_correo UNIQUE (correo),
    CONSTRAINT fk_personal_tipo FOREIGN KEY (id_tipo_personal) REFERENCES tipo_personal (id_tipo_personal) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_personal_cargo FOREIGN KEY (id_cargo) REFERENCES cargo (id_cargo) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_personal_area FOREIGN KEY (id_area) REFERENCES area (id_area) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_personal_sucursal FOREIGN KEY (id_sucursal) REFERENCES sucursal (id_sucursal) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_personal_tipo ON personal (id_tipo_personal);
CREATE INDEX idx_personal_cargo ON personal (id_cargo);
CREATE INDEX idx_personal_area ON personal (id_area);
CREATE INDEX idx_personal_sucursal ON personal (id_sucursal);

-- 4.3 Usuario (Tabla para el login vinculada a cargo y opcionalmente a personal)
DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario (
    id_usuario INT UNSIGNED AUTO_INCREMENT,
    codigo VARCHAR(15) NOT NULL,
    password VARCHAR(255) NOT NULL,
    id_cargo INT UNSIGNED NOT NULL,
    id_personal INT UNSIGNED NULL,
    estado_usuario TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (id_usuario),
    CONSTRAINT uq_usuario_codigo UNIQUE (codigo),
    CONSTRAINT fk_usuario_cargo FOREIGN KEY (id_cargo) REFERENCES cargo (id_cargo) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_usuario_personal FOREIGN KEY (id_personal) REFERENCES personal (id_personal) ON UPDATE CASCADE ON DELETE SET NULL
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_usuario_cargo ON usuario (id_cargo);


-- ============================================================
-- 5. PROVEEDORES Y LABORATORIOS
-- ============================================================

-- 5.1 Proveedor
DROP TABLE IF EXISTS proveedor;

CREATE TABLE proveedor (
    id_proveedor INT UNSIGNED AUTO_INCREMENT,
    razon_social VARCHAR(200) NOT NULL,
    ruc VARCHAR(11) NOT NULL,
    telefono VARCHAR(20) NULL,
    direccion VARCHAR(255) NULL,
    correo VARCHAR(150) NULL,
    estado TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (id_proveedor),
    CONSTRAINT uq_proveedor_ruc UNIQUE (ruc),
    CONSTRAINT uq_proveedor_correo UNIQUE (correo)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 5.2 Laboratorio
DROP TABLE IF EXISTS laboratorio;

CREATE TABLE laboratorio (
    id_laboratorio INT UNSIGNED AUTO_INCREMENT,
    nombre_laboratorio VARCHAR(200) NOT NULL,
    ruc VARCHAR(11) NULL,
    direccion VARCHAR(255) NULL,
    telefono VARCHAR(20) NULL,
    correo VARCHAR(150) NULL,
    PRIMARY KEY (id_laboratorio),
    CONSTRAINT uq_laboratorio_nombre UNIQUE (nombre_laboratorio),
    CONSTRAINT uq_laboratorio_ruc UNIQUE (ruc)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;


-- ============================================================
-- 6. PRODUCTO
-- ============================================================

DROP TABLE IF EXISTS producto;

CREATE TABLE producto (
    id_producto INT UNSIGNED AUTO_INCREMENT,
    nombre_comercial VARCHAR(200) NOT NULL,
    principio_activo VARCHAR(200) NULL,
    concentracion VARCHAR(100) NULL,
    forma_farmaceutica VARCHAR(100) NULL,
    registro_sanitario VARCHAR(50) NULL,
    sku VARCHAR(50) NOT NULL,
    precio_venta DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    precio_costo DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    fecha_registro DATE NOT NULL,
    estado TINYINT(1) NOT NULL DEFAULT 1,
    observaciones VARCHAR(255) NULL,
    id_unidad_medida INT UNSIGNED NOT NULL,
    id_presentacion INT UNSIGNED NOT NULL,
    id_laboratorio INT UNSIGNED NOT NULL,
    id_subcategoria INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_producto),
    CONSTRAINT uq_producto_sku UNIQUE (sku),
    CONSTRAINT uq_producto_registro_sanitario UNIQUE (registro_sanitario),
    CONSTRAINT chk_producto_precio_venta CHECK (precio_venta >= 0),
    CONSTRAINT chk_producto_precio_costo CHECK (precio_costo >= 0),
    CONSTRAINT fk_producto_unidad FOREIGN KEY (id_unidad_medida) REFERENCES unidad_medida (id_unidad_medida) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_producto_presentacion FOREIGN KEY (id_presentacion) REFERENCES presentacion (id_presentacion) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_producto_laboratorio FOREIGN KEY (id_laboratorio) REFERENCES laboratorio (id_laboratorio) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_producto_subcategoria FOREIGN KEY (id_subcategoria) REFERENCES subcategoria (id_subcategoria) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_producto_unidad ON producto (id_unidad_medida);
CREATE INDEX idx_producto_presentacion ON producto (id_presentacion);
CREATE INDEX idx_producto_laboratorio ON producto (id_laboratorio);
CREATE INDEX idx_producto_subcategoria ON producto (id_subcategoria);


-- ============================================================
-- 7. LOTES
-- ============================================================

DROP TABLE IF EXISTS lote;

CREATE TABLE lote (
    id_lote INT UNSIGNED AUTO_INCREMENT,
    id_producto INT UNSIGNED NOT NULL,
    numero_lote VARCHAR(50) NOT NULL,
    fecha_fabricacion DATE NULL,
    fecha_vencimiento DATE NOT NULL,
    PRIMARY KEY (id_lote),
    CONSTRAINT uq_lote_producto UNIQUE (id_producto, numero_lote),
    CONSTRAINT uq_lote_producto_id UNIQUE (id_producto, id_lote),
    CONSTRAINT chk_lote_fechas CHECK (fecha_fabricacion IS NULL OR fecha_vencimiento >= fecha_fabricacion),
    CONSTRAINT fk_lote_producto FOREIGN KEY (id_producto) REFERENCES producto (id_producto) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_lote_producto ON lote (id_producto);
CREATE INDEX idx_lote_vencimiento ON lote (fecha_vencimiento);


-- ============================================================
-- 8. INVENTARIO
-- ============================================================

DROP TABLE IF EXISTS inventario;

CREATE TABLE inventario (
    id_inventario INT UNSIGNED AUTO_INCREMENT,
    id_sucursal INT UNSIGNED NOT NULL,
    id_lote INT UNSIGNED NOT NULL,
    stock_actual INT UNSIGNED NOT NULL DEFAULT 0,
    stock_minimo INT UNSIGNED NOT NULL DEFAULT 0,
    stock_maximo INT UNSIGNED NOT NULL DEFAULT 0,
    ubicacion_pasillo VARCHAR(50) NULL,
    fecha_actualizacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_inventario),
    CONSTRAINT uq_inventario_sucursal_lote UNIQUE (id_sucursal, id_lote),
    CONSTRAINT chk_inventario_stock CHECK (stock_maximo >= stock_minimo),
    CONSTRAINT fk_inventario_sucursal FOREIGN KEY (id_sucursal) REFERENCES sucursal (id_sucursal) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_inventario_lote FOREIGN KEY (id_lote) REFERENCES lote (id_lote) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_inventario_sucursal ON inventario (id_sucursal);
CREATE INDEX idx_inventario_lote ON inventario (id_lote);


-- ============================================================
-- 9. CLIENTE
-- ============================================================

DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
    id_cliente INT UNSIGNED AUTO_INCREMENT,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    dni VARCHAR(15) NOT NULL,
    direccion VARCHAR(255) NULL,
    telefono VARCHAR(20) NULL,
    correo VARCHAR(150) NULL,
    estado TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (id_cliente),
    CONSTRAINT uq_cliente_dni UNIQUE (dni),
    CONSTRAINT uq_cliente_correo UNIQUE (correo)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;


-- ============================================================
-- 10. RECETA
-- ============================================================

DROP TABLE IF EXISTS receta;

CREATE TABLE receta (
    id_receta INT UNSIGNED AUTO_INCREMENT,
    id_cliente INT UNSIGNED NOT NULL,
    id_personal INT UNSIGNED NOT NULL,
    diagnostico VARCHAR(255) NULL,
    fecha_emision DATE NOT NULL,
    observaciones VARCHAR(255) NULL,
    PRIMARY KEY (id_receta),
    CONSTRAINT fk_receta_cliente FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_receta_personal FOREIGN KEY (id_personal) REFERENCES personal (id_personal) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_receta_cliente ON receta (id_cliente);
CREATE INDEX idx_receta_personal ON receta (id_personal);


-- ============================================================
-- 11. DETALLE DE RECETA
-- ============================================================

DROP TABLE IF EXISTS detalle_receta;

CREATE TABLE detalle_receta (
    id_detalle_receta INT UNSIGNED AUTO_INCREMENT,
    id_receta INT UNSIGNED NOT NULL,
    id_producto INT UNSIGNED NOT NULL,
    cantidad_prescrita INT UNSIGNED NOT NULL,
    indicaciones VARCHAR(255) NULL,
    PRIMARY KEY (id_detalle_receta),
    CONSTRAINT uq_detalle_receta UNIQUE (id_receta, id_producto),
    CONSTRAINT chk_detalle_receta_cantidad CHECK (cantidad_prescrita > 0),
    CONSTRAINT fk_detalle_receta_receta FOREIGN KEY (id_receta) REFERENCES receta (id_receta) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_detalle_receta_producto FOREIGN KEY (id_producto) REFERENCES producto (id_producto) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_detalle_receta_receta ON detalle_receta (id_receta);
CREATE INDEX idx_detalle_receta_producto ON detalle_receta (id_producto);


-- ============================================================
-- 12. COMPRA
-- ============================================================

DROP TABLE IF EXISTS compra;

CREATE TABLE compra (
    id_compra INT UNSIGNED AUTO_INCREMENT,
    id_proveedor INT UNSIGNED NOT NULL,
    numero_compra VARCHAR(50) NOT NULL,
    fecha_compra DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total_compra DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    estado ENUM('REGISTRADA', 'RECIBIDA', 'ANULADA') NOT NULL DEFAULT 'REGISTRADA',
    PRIMARY KEY (id_compra),
    CONSTRAINT uq_compra_numero UNIQUE (numero_compra),
    CONSTRAINT chk_compra_total CHECK (total_compra >= 0),
    CONSTRAINT fk_compra_proveedor FOREIGN KEY (id_proveedor) REFERENCES proveedor (id_proveedor) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_compra_proveedor ON compra (id_proveedor);
CREATE INDEX idx_compra_fecha ON compra (fecha_compra);


-- ============================================================
-- 13. DETALLE DE COMPRA
-- ============================================================

DROP TABLE IF EXISTS detalle_compra;

CREATE TABLE detalle_compra (
    id_detalle_compra INT UNSIGNED AUTO_INCREMENT,
    id_compra INT UNSIGNED NOT NULL,
    id_producto INT UNSIGNED NOT NULL,
    id_lote INT UNSIGNED NOT NULL,
    cantidad INT UNSIGNED NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) GENERATED ALWAYS AS (cantidad * precio_unitario) STORED,
    PRIMARY KEY (id_detalle_compra),
    CONSTRAINT uq_detalle_compra UNIQUE (id_compra, id_producto, id_lote),
    CONSTRAINT chk_detalle_compra_cantidad CHECK (cantidad > 0),
    CONSTRAINT chk_detalle_compra_precio CHECK (precio_unitario >= 0),
    CONSTRAINT fk_detalle_compra_compra FOREIGN KEY (id_compra) REFERENCES compra (id_compra) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_detalle_compra_producto FOREIGN KEY (id_producto) REFERENCES producto (id_producto) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_detalle_compra_lote_producto FOREIGN KEY (id_producto, id_lote) REFERENCES lote (id_producto, id_lote) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_detalle_compra_compra ON detalle_compra (id_compra);
CREATE INDEX idx_detalle_compra_producto ON detalle_compra (id_producto);
CREATE INDEX idx_detalle_compra_lote ON detalle_compra (id_lote);


-- ============================================================
-- 14. VENTA
-- ============================================================

DROP TABLE IF EXISTS venta;

CREATE TABLE venta (
    id_venta INT UNSIGNED AUTO_INCREMENT,
    id_cliente INT UNSIGNED NULL,
    id_metodo_pago INT UNSIGNED NOT NULL,
    id_tipo_comprobante INT UNSIGNED NOT NULL,
    id_personal INT UNSIGNED NOT NULL,
    id_sucursal INT UNSIGNED NOT NULL,
    id_receta INT UNSIGNED NULL,
    serie_comprobante VARCHAR(10) NOT NULL,
    numero_comprobante VARCHAR(20) NOT NULL,
    fecha_venta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total_venta DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    estado ENUM('PENDIENTE', 'PAGADA', 'ANULADA') NOT NULL DEFAULT 'PENDIENTE',
    PRIMARY KEY (id_venta),
    CONSTRAINT uq_venta_comprobante UNIQUE (serie_comprobante, numero_comprobante),
    CONSTRAINT chk_venta_total CHECK (total_venta >= 0),
    CONSTRAINT chk_venta_serie CHECK (CHAR_LENGTH(TRIM(serie_comprobante)) > 0),
    CONSTRAINT chk_venta_numero CHECK (CHAR_LENGTH(TRIM(numero_comprobante)) > 0),
    CONSTRAINT fk_venta_cliente FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente) ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_venta_metodo_pago FOREIGN KEY (id_metodo_pago) REFERENCES metodo_pago (id_metodo_pago) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_venta_tipo_comprobante FOREIGN KEY (id_tipo_comprobante) REFERENCES tipo_comprobante (id_tipo_comprobante) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_venta_personal FOREIGN KEY (id_personal) REFERENCES personal (id_personal) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_venta_sucursal FOREIGN KEY (id_sucursal) REFERENCES sucursal (id_sucursal) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_venta_receta FOREIGN KEY (id_receta) REFERENCES receta (id_receta) ON UPDATE CASCADE ON DELETE SET NULL
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_venta_cliente ON venta (id_cliente);
CREATE INDEX idx_venta_metodo_pago ON venta (id_metodo_pago);
CREATE INDEX idx_venta_tipo_comprobante ON venta (id_tipo_comprobante);
CREATE INDEX idx_venta_personal ON venta (id_personal);
CREATE INDEX idx_venta_sucursal ON venta (id_sucursal);
CREATE INDEX idx_venta_receta ON venta (id_receta);
CREATE INDEX idx_venta_fecha ON venta (fecha_venta);


-- ============================================================
-- 15. DETALLE DE VENTA
-- ============================================================

DROP TABLE IF EXISTS detalle_venta;

CREATE TABLE detalle_venta (
    id_detalle_venta INT UNSIGNED AUTO_INCREMENT,
    id_venta INT UNSIGNED NOT NULL,
    id_producto INT UNSIGNED NOT NULL,
    id_lote INT UNSIGNED NOT NULL,
    cantidad INT UNSIGNED NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    descuento DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    subtotal DECIMAL(10,2) GENERATED ALWAYS AS ((cantidad * precio_unitario) - descuento) STORED,
    PRIMARY KEY (id_detalle_venta),
    CONSTRAINT uq_detalle_venta UNIQUE (id_venta, id_producto, id_lote),
    CONSTRAINT chk_detalle_venta_cantidad CHECK (cantidad > 0),
    CONSTRAINT chk_detalle_venta_precio CHECK (precio_unitario >= 0),
    CONSTRAINT chk_detalle_venta_descuento CHECK (descuento >= 0),
    CONSTRAINT chk_detalle_venta_subtotal CHECK ((cantidad * precio_unitario) >= descuento),
    CONSTRAINT fk_detalle_venta_venta FOREIGN KEY (id_venta) REFERENCES venta (id_venta) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_detalle_venta_producto FOREIGN KEY (id_producto) REFERENCES producto (id_producto) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_detalle_venta_lote_producto FOREIGN KEY (id_producto, id_lote) REFERENCES lote (id_producto, id_lote) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE INDEX idx_detalle_venta_venta ON detalle_venta (id_venta);
CREATE INDEX idx_detalle_venta_producto ON detalle_venta (id_producto);
CREATE INDEX idx_detalle_venta_lote ON detalle_venta (id_lote);


-- ============================================================
-- 16. VISTA PARA EL LOGIN EN NETBEANS (Usa la tabla cargo)
-- ============================================================

DROP VIEW IF EXISTS view_usuarios;

CREATE VIEW view_usuarios AS
SELECT 
    u.id_usuario,
    u.codigo,
    u.password,
    c.nombre_cargo,
    u.estado_usuario
FROM usuario u
INNER JOIN cargo c ON u.id_cargo = c.id_cargo;


-- ============================================================
-- 17. RESTAURAR CONFIGURACIÓN Y VERIFICACIÓN
-- ============================================================

SET FOREIGN_KEY_CHECKS = 1;

SHOW TABLES;
