-- ============================================================
-- 1. VISTA DE AREA
-- ============================================================

CREATE OR REPLACE VIEW view_area AS
SELECT 
    A.id_area,
    A.nombre_area,
    A.observaciones
FROM area A
ORDER BY A.id_area ASC;

SELECT * FROM view_area;


-- ============================================================
-- 1. BUSCAR AREA
-- ============================================================

USE bdfarmacia;

DROP PROCEDURE IF EXISTS sp_area_buscar;

DELIMITER //
CREATE PROCEDURE sp_area_buscar(
    IN p_nombreArea VARCHAR(100)
)
BEGIN
    SELECT id_area, nombre_area, observaciones
    FROM view_area
    WHERE nombre_area LIKE CONCAT('%', TRIM(p_nombreArea), '%')
    ORDER BY id_area ASC;
END //
DELIMITER ;

CALL sp_area_buscar('Farmacia');


-- ============================================================
-- 1. GUARDAR AREA
-- ============================================================

DELIMITER //

CREATE PROCEDURE sp_area_insertar(
    IN p_nombreArea VARCHAR(100),
    IN p_observaciones VARCHAR(255)
)
BEGIN
    IF p_nombreArea IS NULL OR TRIM(p_nombreArea) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre del area es obligatorio';
    END IF;

    IF EXISTS (
        SELECT 1
        FROM area
        WHERE LOWER(nombre_area) = LOWER(TRIM(p_nombreArea))
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El area ya existe';
    END IF;

    INSERT INTO area (
        nombre_area,
        observaciones
    )
    VALUES (
        TRIM(p_nombreArea),
        NULLIF(TRIM(p_observaciones), '')
    );
END //

DELIMITER ;

CALL sp_area_insertar('Marketing', 'Area de marketing');


-- ============================================================
-- 1. MODIFICAR AREA
-- ============================================================

DELIMITER //

CREATE PROCEDURE sp_area_actualizar(
    IN p_idArea INT,
    IN p_nuevoNombre VARCHAR(100),
    IN p_nuevasObservaciones VARCHAR(255)
)
BEGIN

    IF p_idArea IS NULL OR p_idArea <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El ID del area no es valido';
    END IF;

    IF p_nuevoNombre IS NULL OR TRIM(p_nuevoNombre) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre del area es obligatorio';
    END IF;

    IF NOT EXISTS (
        SELECT 1
        FROM area
        WHERE id_area = p_idArea
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El area no existe';
    END IF;

    IF EXISTS (
        SELECT 1
        FROM area
        WHERE LOWER(nombre_area) = LOWER(TRIM(p_nuevoNombre))
        AND id_area <> p_idArea
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ya existe otra area con ese nombre';
    END IF;

    UPDATE area
    SET 
        nombre_area = TRIM(p_nuevoNombre),
        observaciones = NULLIF(TRIM(p_nuevasObservaciones), '')
    WHERE id_area = p_idArea;

END //

DELIMITER ;


-- ============================================================
-- 2. VISTA DE CARGO
-- Muestra solamente los cargos activos
-- ============================================================

CREATE OR REPLACE VIEW view_cargo AS
SELECT 
    C.id_cargo,
    C.nombre_cargo,
    CASE
        WHEN C.estado_cargo = 1 THEN 'activo'
        WHEN C.estado_cargo = 0 THEN 'inactivo'
    END AS estado_cargo
FROM cargo C
ORDER BY C.id_cargo ASC;

SELECT * FROM view_cargo;


-- ============================================================
-- 2. BUSCAR CARGO
-- ============================================================

DELIMITER //

CREATE PROCEDURE sp_cargo_buscar(
    IN p_nombreCargo VARCHAR(100)
)
BEGIN
    SELECT 
        id_cargo,
        nombre_cargo,
        estado_cargo
    FROM view_cargo_activo
    WHERE nombre_cargo LIKE CONCAT('%', TRIM(p_nombreCargo), '%')
    ORDER BY id_cargo ASC;
END //

DELIMITER ;

CALL sp_cargo_buscar('Administrador');


-- ============================================================
-- 2. GUARDAR CARGO
-- ============================================================

DELIMITER //

CREATE PROCEDURE sp_cargo_insertar(
    IN p_nombreCargo VARCHAR(100)
)
BEGIN
    IF p_nombreCargo IS NULL OR TRIM(p_nombreCargo) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre del cargo es obligatorio';
    END IF;

    IF EXISTS (
        SELECT 1
        FROM cargo
        WHERE LOWER(nombre_cargo) = LOWER(TRIM(p_nombreCargo))
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El cargo ya existe';
    END IF;

    INSERT INTO cargo (
        nombre_cargo,
        estado_cargo
    )
    VALUES (
        TRIM(p_nombreCargo),
        1
    );
END //

DELIMITER ;

CALL sp_cargo_insertar('Encargado de Marketing');


-- ============================================================
-- 2. MODIFICAR CARGO
-- ============================================================

DELIMITER //

CREATE PROCEDURE sp_cargo_actualizar(
    IN p_idCargo INT,
    IN p_nuevoNombre VARCHAR(100)
)
BEGIN

    IF p_idCargo IS NULL OR p_idCargo <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El ID del cargo no es valido';
    END IF;

    IF p_nuevoNombre IS NULL OR TRIM(p_nuevoNombre) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre del cargo es obligatorio';
    END IF;

    IF NOT EXISTS (
        SELECT 1
        FROM cargo
        WHERE id_cargo = p_idCargo
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El cargo no existe';
    END IF;

    IF EXISTS (
        SELECT 1
        FROM cargo
        WHERE LOWER(nombre_cargo) = LOWER(TRIM(p_nuevoNombre))
        AND id_cargo <> p_idCargo
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ya existe otro cargo con ese nombre';
    END IF;

    UPDATE cargo
    SET 
        nombre_cargo = TRIM(p_nuevoNombre)
    WHERE id_cargo = p_idCargo;

END //

DELIMITER ;


-- ============================================================
-- 5. DAR DE BAJA CARGO
-- ============================================================

DELIMITER //

CREATE PROCEDURE sp_cargo_desactivar(
    IN p_idCargo INT
)
BEGIN

    IF p_idCargo IS NULL OR p_idCargo <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El ID del cargo no es valido';
    END IF;

    IF NOT EXISTS (
        SELECT 1
        FROM cargo
        WHERE id_cargo = p_idCargo
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El cargo no existe';
    END IF;

    UPDATE cargo
    SET estado_cargo = 0
    WHERE id_cargo = p_idCargo;

END //

DELIMITER ;


-- ============================================================
-- 3. VISTA DE TIPO_PERSONAL
-- ============================================================

CREATE OR REPLACE VIEW view_tipo_personal AS
SELECT 
    TP.id_tipo_personal,
    TP.nombre_tipo_personal,
    TP.observaciones
FROM tipo_personal TP
ORDER BY TP.id_tipo_personal ASC;

SELECT * FROM view_tipo_personal;


-- ============================================================
-- 3. BUSCAR TIPO_PERSONAL
-- ============================================================

DELIMITER //

CREATE PROCEDURE sp_tipo_personal_buscar(
    IN p_nombreTipoPersonal VARCHAR(100)
)
BEGIN
    SELECT 
        id_tipo_personal,
        nombre_tipo_personal,
        observaciones
    FROM view_tipo_personal
    WHERE nombre_tipo_personal LIKE CONCAT('%', TRIM(p_nombreTipoPersonal), '%')
    ORDER BY id_tipo_personal ASC;
END //

DELIMITER ;

CALL sp_tipo_personal_buscar('Administrativo');


-- ============================================================
-- 3. GUARDAR TIPO_PERSONAL
-- ============================================================

DELIMITER //

CREATE PROCEDURE sp_tipo_personal_insertar(
    IN p_nombreTipoPersonal VARCHAR(100),
    IN p_observaciones VARCHAR(255)
)
BEGIN
    IF p_nombreTipoPersonal IS NULL 
       OR TRIM(p_nombreTipoPersonal) = '' THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre del tipo de personal es obligatorio';
    END IF;

    IF EXISTS (
        SELECT 1
        FROM tipo_personal
        WHERE LOWER(nombre_tipo_personal) =
              LOWER(TRIM(p_nombreTipoPersonal))
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El tipo de personal ya existe';
    END IF;

    INSERT INTO tipo_personal (
        nombre_tipo_personal,
        observaciones
    )
    VALUES (
        TRIM(p_nombreTipoPersonal),
        NULLIF(TRIM(p_observaciones), '')
    );
END //

DELIMITER ;

CALL sp_tipo_personal_insertar('Marketing', 'Personal de marketing');


-- ============================================================
-- 3. MODIFICAR TIPO_PERSONAL
-- ============================================================

DELIMITER //

CREATE PROCEDURE sp_tipo_personal_actualizar(
    IN p_idTipoPersonal INT,
    IN p_nuevoNombre VARCHAR(100),
    IN p_nuevasObservaciones VARCHAR(255)
)
BEGIN

    IF p_idTipoPersonal IS NULL OR p_idTipoPersonal <= 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El ID del tipo de personal no es valido';
    END IF;

    IF p_nuevoNombre IS NULL OR TRIM(p_nuevoNombre) = '' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El nombre del tipo de personal es obligatorio';
    END IF;

    IF NOT EXISTS (
        SELECT 1
        FROM tipo_personal
        WHERE id_tipo_personal = p_idTipoPersonal
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El tipo de personal no existe';
    END IF;

    IF EXISTS (
        SELECT 1
        FROM tipo_personal
        WHERE LOWER(nombre_tipo_personal) =
              LOWER(TRIM(p_nuevoNombre))
        AND id_tipo_personal <> p_idTipoPersonal
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ya existe otro tipo de personal con ese nombre';
    END IF;

    UPDATE tipo_personal
    SET 
        nombre_tipo_personal = TRIM(p_nuevoNombre),
        observaciones = NULLIF(TRIM(p_nuevasObservaciones), '')
    WHERE id_tipo_personal = p_idTipoPersonal;

END //

DELIMITER ;


-- ============================================================
-- 6. VISTA  DE COMPRA
-- ============================================================

CREATE OR REPLACE VIEW view_compra AS
SELECT
    C.id_compra,
    C.id_proveedor,
    P.razon_social,
    C.numero_compra,
    C.fecha_compra,
    C.total_compra,
    C.estado
FROM compra C
INNER JOIN proveedor P
    ON C.id_proveedor = P.id_proveedor;

SELECT * FROM view_compra;


-- ============================================================
-- MANTENIMIENTO DE COMPRA
-- ============================================================

USE bdfarmacia;

DROP PROCEDURE IF EXISTS sp_compra_insertar;
DROP PROCEDURE IF EXISTS sp_compra_actualizar;
DROP PROCEDURE IF EXISTS sp_compra_buscar;
DROP PROCEDURE IF EXISTS sp_compra_baja;
DROP PROCEDURE IF EXISTS sp_compra_reactivar;

DELIMITER //

CREATE PROCEDURE sp_compra_insertar(
    IN p_id_proveedor INT UNSIGNED,
    IN p_numero_compra VARCHAR(50),
    IN p_fecha_compra DATETIME,
    IN p_total_compra DECIMAL(10,2)
)
BEGIN
    INSERT INTO compra (id_proveedor, numero_compra, fecha_compra, total_compra)
    VALUES (p_id_proveedor, TRIM(p_numero_compra), p_fecha_compra, p_total_compra);
END //

CREATE PROCEDURE sp_compra_actualizar(
    IN p_id_compra INT UNSIGNED,
    IN p_id_proveedor INT UNSIGNED,
    IN p_numero_compra VARCHAR(50),
    IN p_fecha_compra DATETIME,
    IN p_total_compra DECIMAL(10,2)
)
BEGIN
    UPDATE compra
    SET id_proveedor  = p_id_proveedor,
        numero_compra = TRIM(p_numero_compra),
        fecha_compra  = p_fecha_compra,
        total_compra  = p_total_compra
    WHERE id_compra = p_id_compra;
END //

CREATE PROCEDURE sp_compra_buscar(
    IN p_texto VARCHAR(100)
)
BEGIN
    SELECT * FROM view_compra
    WHERE numero_compra    LIKE CONCAT('%', TRIM(p_texto), '%')
       OR nombre_proveedor LIKE CONCAT('%', TRIM(p_texto), '%')
    ORDER BY id_compra;
END //

CREATE PROCEDURE sp_compra_baja(
    IN p_id_compra INT UNSIGNED
)
BEGIN
    UPDATE compra SET estado = 'ANULADA' WHERE id_compra = p_id_compra;
END //

CREATE PROCEDURE sp_compra_reactivar(
    IN p_id_compra INT UNSIGNED
)
BEGIN
    UPDATE compra SET estado = 'REGISTRADA' WHERE id_compra = p_id_compra;
END //

DELIMITER ;


-- ============================================================
-- VISTA DE DETALLE_COMPRA
-- ============================================================

CREATE VIEW view_detalle_compra AS
SELECT
    dc.id_detalle_compra,
    c.numero_compra,
    p.nombre_comercial,
    l.numero_lote,
    dc.cantidad,
    dc.precio_unitario,
    dc.subtotal
FROM detalle_compra dc
INNER JOIN compra c
    ON dc.id_compra = c.id_compra
INNER JOIN producto p
    ON dc.id_producto = p.id_producto
INNER JOIN lote l
    ON dc.id_lote = l.id_lote;


-- ============================================================
-- PROCEDIMIENTOS DE DETALLE_COMPRA
-- ============================================================

DROP PROCEDURE IF EXISTS sp_listar_detalle_compra;

DELIMITER //

CREATE PROCEDURE sp_listar_detalle_compra()
BEGIN
    SELECT
        dc.id_detalle_compra,
        c.numero_compra,
        p.nombre_comercial,
        l.numero_lote,
        dc.cantidad,
        dc.precio_unitario,
        dc.subtotal
    FROM detalle_compra dc
    INNER JOIN compra c ON dc.id_compra = c.id_compra
    INNER JOIN producto p ON dc.id_producto = p.id_producto
    INNER JOIN lote l ON dc.id_lote = l.id_lote
    ORDER BY dc.id_detalle_compra DESC;
END //


-- ============================================================
-- PROCEDIMIENTO PARA INSERTAR DETALLE_COMPRA
-- ============================================================

CREATE PROCEDURE sp_insertar_detalle_compra(
    IN p_id_compra INT UNSIGNED,
    IN p_id_producto INT UNSIGNED,
    IN p_id_lote INT UNSIGNED,
    IN p_cantidad INT UNSIGNED,
    IN p_precio_unitario DECIMAL(10,2)
)
BEGIN
    INSERT INTO detalle_compra (
        id_compra,
        id_producto,
        id_lote,
        cantidad,
        precio_unitario
    )
    VALUES (
        p_id_compra,
        p_id_producto,
        p_id_lote,
        p_cantidad,
        p_precio_unitario
    );
END //


-- ============================================================
-- PROCEDIMIENTO PARA ACTUALIZAR DETALLE_COMPRA
-- ============================================================

CREATE PROCEDURE sp_actualizar_detalle_compra(
    IN p_id_detalle_compra INT UNSIGNED,
    IN p_cantidad INT UNSIGNED,
    IN p_precio_unitario DECIMAL(10,2)
)
BEGIN
    UPDATE detalle_compra
    SET
        cantidad = p_cantidad,
        precio_unitario = p_precio_unitario
    WHERE id_detalle_compra = p_id_detalle_compra;
END //


-- ============================================================
-- PROCEDIMIENTO PARA ELIMINAR DETALLE_COMPRA
-- ============================================================

CREATE PROCEDURE sp_eliminar_detalle_compra(
    IN p_id_detalle_compra INT UNSIGNED
)
BEGIN
    DELETE FROM detalle_compra
    WHERE id_detalle_compra = p_id_detalle_compra;
END //


-- ============================================================
-- PROCEDIMIENTO PARA LISTAR DETALLE_COMPRA
-- ============================================================

DELIMITER //

CREATE PROCEDURE sp_listar_detalle_compra()
BEGIN
    SELECT id_compra, numero_compra
    FROM compra
    ORDER BY id_compra DESC;
END //

DELIMITER ;


-- =====================================================
-- MANTENIMIENTO A LA TABLA DETALLE_RECETA
-- =====================================================


/* 1. CREAR VISTA PARA LISTAR LOS DETALLES DE RECETA */

CREATE OR REPLACE VIEW view_detalle_receta AS
SELECT
    dr.id_detalle_receta,
    dr.id_receta,
    p.nombre_comercial,
    dr.cantidad_prescrita,
    dr.indicaciones
FROM detalle_receta dr
INNER JOIN producto p
    ON dr.id_producto = p.id_producto;


/* 2. PROCEDIMIENTO PARA LISTAR LOS DETALLES DE RECETA */

DELIMITER //

CREATE PROCEDURE sp_listar_detalle_receta()
BEGIN
    SELECT * FROM view_detalle_receta;
END //


/* 3. PROCEDIMIENTO PARA INSERTAR UN DETALLE DE RECETA */

CREATE PROCEDURE sp_insertar_detalle_receta(
    IN p_id_receta INT UNSIGNED,
    IN p_id_producto INT UNSIGNED,
    IN p_cantidad_prescrita INT UNSIGNED,
    IN p_indicaciones VARCHAR(255)
)
BEGIN
    INSERT INTO detalle_receta (
        id_receta,
        id_producto,
        cantidad_prescrita,
        indicaciones
    )
    VALUES (
        p_id_receta,
        p_id_producto,
        p_cantidad_prescrita,
        p_indicaciones
    );
END //


/* 4. PROCEDIMIENTO PARA MODIFICAR UN DETALLE DE RECETA */

CREATE PROCEDURE sp_actualizar_detalle_receta(
    IN p_id_detalle_receta INT UNSIGNED,
    IN p_cantidad_prescrita INT UNSIGNED,
    IN p_indicaciones VARCHAR(255)
)
BEGIN
    UPDATE detalle_receta
    SET cantidad_prescrita = p_cantidad_prescrita,
        indicaciones = p_indicaciones
    WHERE id_detalle_receta = p_id_detalle_receta;
END //


/* 5. PROCEDIMIENTO PARA ELIMINAR UN DETALLE DE RECETA */

CREATE PROCEDURE sp_eliminar_detalle_receta(
    IN p_id_detalle_receta INT UNSIGNED
)
BEGIN
    DELETE FROM detalle_receta
    WHERE id_detalle_receta = p_id_detalle_receta;
END //

DELIMITER ;


-- =========================================================
-- PROCEDIMIENTOS DE DETALLE_RECETA
-- =========================================================

DROP PROCEDURE IF EXISTS sp_detalle_receta_buscar;

DELIMITER $$

CREATE PROCEDURE sp_detalle_receta_buscar(IN p_busqueda VARCHAR(255))
BEGIN
    SELECT *
    FROM view_detalle_receta
    WHERE CAST(id_detalle_receta AS CHAR) LIKE CONCAT('%', p_busqueda, '%')
       OR CAST(id_receta AS CHAR) LIKE CONCAT('%', p_busqueda, '%')
       OR CAST(id_producto AS CHAR) LIKE CONCAT('%', p_busqueda, '%')
       OR indicaciones LIKE CONCAT('%', p_busqueda, '%');
END $$

DELIMITER ;


DROP PROCEDURE IF EXISTS sp_detalle_receta_insertar;

DELIMITER $$

CREATE PROCEDURE sp_detalle_receta_insertar(
    IN p_id_receta INT,
    IN p_id_producto INT,
    IN p_cantidad INT,
    IN p_indicaciones VARCHAR(255)
)
BEGIN
    INSERT INTO detalle_receta
    (
        id_receta,
        id_producto,
        cantidad_prescrita,
        indicaciones
    )
    VALUES
    (
        p_id_receta,
        p_id_producto,
        p_cantidad,
        p_indicaciones
    );
END $$

DELIMITER ;


DROP PROCEDURE IF EXISTS sp_detalle_receta_actualizar;

DELIMITER $$

CREATE PROCEDURE sp_detalle_receta_actualizar(
    IN p_id_detalle_receta INT,
    IN p_id_receta INT,
    IN p_id_producto INT,
    IN p_cantidad INT,
    IN p_indicaciones VARCHAR(255)
)
BEGIN
    UPDATE detalle_receta
    SET
        id_receta = p_id_receta,
        id_producto = p_id_producto,
        cantidad_prescrita = p_cantidad,
        indicaciones = p_indicaciones
    WHERE id_detalle_receta = p_id_detalle_receta;
END $$

DELIMITER ;


DROP PROCEDURE IF EXISTS sp_detalle_receta_eliminar;

DELIMITER $$

CREATE PROCEDURE sp_detalle_receta_eliminar(
    IN p_id_detalle_receta INT
)
BEGIN
    DELETE FROM detalle_receta
    WHERE id_detalle_receta = p_id_detalle_receta;
END $$

DELIMITER ;


-- VISTA DETALLES DE VENTA

CREATE OR REPLACE VIEW view_detalle_venta AS
SELECT
    dv.id_detalle_venta,
    v.id_venta,
    dv.id_producto,
    p.nombre_comercial,
    dv.id_lote,
    l.numero_lote,
    dv.cantidad,
    dv.precio_unitario,
    dv.descuento,
    dv.Subtotal
FROM detalle_venta dv
INNER JOIN venta v
    ON dv.id_venta = v.id_venta
INNER JOIN producto p
    ON dv.id_producto = p.id_producto
INNER JOIN lote l
    ON dv.id_lote = l.id_lote;

DELIMITER //

-- PROCEDIMIENTO PARA LISTAR LOS DETALLES DE VENTA

CREATE PROCEDURE sp_listar_detalle_venta()
BEGIN
    SELECT *
    FROM view_detalle_venta;
END //


-- PROCEDIMIENTO PARA INSERTAR UN DETALLE DE VENTA

CREATE PROCEDURE sp_insertar_detalle_venta(
    IN p_id_venta INT UNSIGNED,
    IN p_id_producto INT UNSIGNED,
    IN p_id_lote INT UNSIGNED,
    IN p_cantidad INT UNSIGNED,
    IN p_precio_unitario DECIMAL(10,2),
    IN p_descuento DECIMAL(10,2)
)
BEGIN
    INSERT INTO detalle_venta (
        id_venta,
        id_producto,
        id_lote,
        cantidad,
        precio_unitario,
        descuento
    )
    VALUES (
        p_id_venta,
        p_id_producto,
        p_id_lote,
        p_cantidad,
        p_precio_unitario,
        p_descuento
    );
END //


-- PROCEDIMIENTO PARA MODIFICAR UN DETALLE DE VENTA

CREATE PROCEDURE sp_modificar_detalle_venta(
    IN p_id_detalle_venta INT UNSIGNED,
    IN p_id_venta INT UNSIGNED,
    IN p_id_producto INT UNSIGNED,
    IN p_id_lote INT UNSIGNED,
    IN p_cantidad INT UNSIGNED,
    IN p_precio_unitario DECIMAL(10,2),
    IN p_descuento DECIMAL(10,2)
)
BEGIN
    UPDATE detalle_venta
    SET
        id_venta = p_id_venta,
        id_producto = p_id_producto,
        id_lote = p_id_lote,
        cantidad = p_cantidad,
        precio_unitario = p_precio_unitario,
        descuento = p_descuento
    WHERE id_detalle_venta = p_id_detalle_venta;
END //


-- PROCEDIMIENTO PARA ELIMINAR UN DETALLE DE VENTA

CREATE PROCEDURE sp_eliminar_detalle_venta(
    IN p_id_detalle_venta INT UNSIGNED
)
BEGIN
    DELETE FROM detalle_venta
    WHERE id_detalle_venta = p_id_detalle_venta;
END //

DELIMITER ;