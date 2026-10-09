/* ============================================================
   VISTA PARA LISTAR LAS SUCURSALES
   ============================================================ */

CREATE OR REPLACE VIEW view_sucursales AS
SELECT
    s.id_sucursal AS id_sucursal,
    s.nombre_sucursal AS nombre_sucursal,
    s.direccion AS direccion,
    s.telefono AS telefono
FROM sucursal s
ORDER BY s.id_sucursal ASC;

select * from view_sucursales;

/*=====================CRUD===============================================*/

/* ============================================================
   SP PARA BUSCAR SUCURSALES
   ============================================================ */

DROP PROCEDURE IF EXISTS sp_buscar_sucursal;
DELIMITER $$

CREATE PROCEDURE sp_buscar_sucursal(
    IN p_busqueda VARCHAR(150)
)
BEGIN
    SELECT
        id_sucursal,
        nombre_sucursal,
        direccion,
        telefono
    FROM view_sucursales
    WHERE nombre_sucursal COLLATE utf8mb4_unicode_ci
              LIKE CONCAT('%', p_busqueda, '%') COLLATE utf8mb4_unicode_ci
       OR CAST(id_sucursal AS CHAR CHARACTER SET utf8mb4)
              COLLATE utf8mb4_unicode_ci
              LIKE CONCAT('%', p_busqueda, '%') COLLATE utf8mb4_unicode_ci
    ORDER BY id_sucursal ASC;
END $$

DELIMITER ;
-- Ejemplo de uso:
CALL sp_buscar_sucursal('Chimbote');
CALL sp_buscar_sucursal('');

/* ============================================================
   SP PARA GUARDAR SUCURSAL
   ============================================================ */

DELIMITER $$

CREATE PROCEDURE sp_guardar_sucursal(
    IN p_nombre_sucursal VARCHAR(150),
    IN p_direccion VARCHAR(255),
    IN p_telefono VARCHAR(20)
)
BEGIN
    INSERT INTO sucursal (
        nombre_sucursal,
        direccion,
        telefono
    )
    VALUES (
        p_nombre_sucursal,
        p_direccion,
        p_telefono
    );
END $$

DELIMITER ;
-- Ejemplo de uso:
CALL sp_guardar_sucursal(
    'Mifarma Chimbote',
    'Av. José Pardo 123',
    '987654321'
);

/* ============================================================
   SP PARA MODIFICAR SUCURSAL
   ============================================================ */

DELIMITER $$

CREATE PROCEDURE sp_modificar_sucursal(
    IN p_id_sucursal INT UNSIGNED,
    IN p_nombre_sucursal VARCHAR(150),
    IN p_direccion VARCHAR(255),
    IN p_telefono VARCHAR(20)
)
BEGIN
    UPDATE sucursal
    SET
        nombre_sucursal = p_nombre_sucursal,
        direccion = p_direccion,
        telefono = p_telefono
    WHERE id_sucursal = p_id_sucursal;
END $$

DELIMITER ;

-- Ejemplo de uso:
CALL sp_modificar_sucursal(
    1,
    'Mifarma Chimbote Actualizada',
    'Av. José Pardo 456',
    '987654322'
);






/* ============================================================
   VISTA PARA LISTAR LOS PROVEEDORES ACTIVOS
   ============================================================ */

CREATE OR REPLACE VIEW view_proveedores AS
SELECT
    p.id_proveedor AS id_proveedor,
    p.razon_social AS razon_social,
    p.ruc AS ruc,
    p.telefono AS telefono,
    p.direccion AS direccion,
    p.correo AS correo,
    p.estado AS estado
FROM proveedor p
WHERE p.estado = 1
ORDER BY p.id_proveedor ASC;

select * from view_proveedores;


/*=====================CRUD===============================================*/


/* ============================================================
   SP PARA BUSCAR PROVEEDORES
   ============================================================ */
DROP PROCEDURE IF EXISTS sp_buscar_proveedor;
DELIMITER $$

CREATE PROCEDURE sp_buscar_proveedor(
    IN p_busqueda VARCHAR(200)
)
BEGIN
    SELECT
        id_proveedor,
        razon_social,
        ruc,
        telefono,
        direccion,
        correo,
        estado
    FROM view_proveedores
    WHERE razon_social LIKE CONCAT('%', p_busqueda, '%')
       OR ruc LIKE CONCAT('%', p_busqueda, '%')
       OR id_proveedor LIKE CONCAT('%', p_busqueda, '%')
       
    ORDER BY id_proveedor ASC;
END $$

DELIMITER ;

-- Ejemplo de uso:
CALL sp_buscar_proveedor('Pfizer');
CALL sp_buscar_proveedor('');
/* ============================================================
   SP PARA GUARDAR PROVEEDOR
   ============================================================ */

DELIMITER $$

CREATE PROCEDURE sp_guardar_proveedor(
    IN p_razon_social VARCHAR(200),
    IN p_ruc VARCHAR(11),
    IN p_telefono VARCHAR(20),
    IN p_direccion VARCHAR(255),
    IN p_correo VARCHAR(150)
)
BEGIN
    INSERT INTO proveedor (
        razon_social,
        ruc,
        telefono,
        direccion,
        correo,
        estado
    )
    VALUES (
        p_razon_social,
        p_ruc,
        p_telefono,
        p_direccion,
        p_correo,
        1
    );
END $$

DELIMITER ;

-- Ejemplo de uso:
CALL sp_guardar_proveedor(
    'Laboratorios Pfizer Perú S.A.',
    '20100012345',
    '987654321',
    'Av. República de Panamá 123',
    'contacto@pfizer.com'
);

/* ============================================================
   SP PARA MODIFICAR PROVEEDOR
   ============================================================ */

DELIMITER $$

CREATE PROCEDURE sp_modificar_proveedor(
    IN p_id_proveedor INT UNSIGNED,
    IN p_razon_social VARCHAR(200),
    IN p_ruc VARCHAR(11),
    IN p_telefono VARCHAR(20),
    IN p_direccion VARCHAR(255),
    IN p_correo VARCHAR(150)
)
BEGIN
    UPDATE proveedor
    SET
        razon_social = p_razon_social,
        ruc = p_ruc,
        telefono = p_telefono,
        direccion = p_direccion,
        correo = p_correo
    WHERE id_proveedor = p_id_proveedor;
END $$

DELIMITER ;

-- Ejemplo de uso:
CALL sp_modificar_proveedor(
    6,
    'Laboratorios Pfizer Perú Actualizado',
    '20100012345',
    '987654322',
    'Av. República de Panamá 456',
    'ventas@pfizer.com'
);

/* ============================================================
   SP PARA DAR DE BAJA PROVEEDOR
   ============================================================ */

DELIMITER $$

CREATE PROCEDURE sp_baja_proveedor(
    IN p_id_proveedor INT UNSIGNED
)
BEGIN
    UPDATE proveedor
    SET estado = 0
    WHERE id_proveedor = p_id_proveedor;
END $$

DELIMITER ;
-- Ejemplo de uso:
CALL sp_baja_proveedor(6);

/*=====================Activar ====================================*/
DELIMITER //

CREATE PROCEDURE sp_activar_proveedor(
    IN p_id_proveedor INT
)
BEGIN
    IF EXISTS (
        SELECT 1
        FROM proveedor
        WHERE id_proveedor = p_id_proveedor
    ) THEN

        UPDATE proveedor
        SET estado = 1
        WHERE id_proveedor = p_id_proveedor;

    END IF;
END //

DELIMITER ;



/* ============================================================
   VISTA PARA LISTAR LOS LABORATORIOS
   ============================================================ */

CREATE OR REPLACE VIEW view_laboratorios AS
SELECT
    l.id_laboratorio AS id_laboratorio,
    l.nombre_laboratorio AS nombre_laboratorio,
    l.ruc AS ruc,
    l.direccion AS direccion,
    l.telefono AS telefono,
    l.correo AS correo
FROM laboratorio l
ORDER BY l.id_laboratorio ASC;

select * from view_laboratorios;

/*=====================CRUD===============================================*/

/* ============================================================
   SP PARA BUSCAR LABORATORIOS
   ============================================================ */
DROP PROCEDURE IF EXISTS sp_buscar_laboratorio;
DELIMITER $$

DELIMITER $$

CREATE PROCEDURE sp_buscar_laboratorio(
    IN p_busqueda VARCHAR(200)
)
BEGIN
    SELECT
        id_laboratorio,
        nombre_laboratorio,
        ruc,
        direccion,
        telefono,
        correo
    FROM view_laboratorios
    WHERE nombre_laboratorio COLLATE utf8mb4_unicode_ci
              LIKE CONCAT('%', p_busqueda, '%') COLLATE utf8mb4_unicode_ci
       OR CAST(id_laboratorio AS CHAR CHARACTER SET utf8mb4)
              COLLATE utf8mb4_unicode_ci
              LIKE CONCAT('%', p_busqueda, '%') COLLATE utf8mb4_unicode_ci
       OR ruc COLLATE utf8mb4_unicode_ci
              LIKE CONCAT('%', p_busqueda, '%') COLLATE utf8mb4_unicode_ci
    ORDER BY id_laboratorio ASC;
END $$

DELIMITER ;
-- Ejemplo de uso:
CALL sp_buscar_laboratorio('Medifarma');
CALL sp_buscar_laboratorio('');

/* ============================================================
   SP PARA GUARDAR LABORATORIO
   ============================================================ */

DELIMITER $$

CREATE PROCEDURE sp_guardar_laboratorio(
    IN p_nombre_laboratorio VARCHAR(200),
    IN p_ruc VARCHAR(11),
    IN p_direccion VARCHAR(255),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(150)
)
BEGIN
    INSERT INTO laboratorio (
        nombre_laboratorio,
        ruc,
        direccion,
        telefono,
        correo
    )
    VALUES (
        p_nombre_laboratorio,
        p_ruc,
        p_direccion,
        p_telefono,
        p_correo
    );
END $$

DELIMITER ;
-- Ejemplo de uso:
CALL sp_guardar_laboratorio(
    'Laboratorios Medifarma S.A.C.',
    '20100123456',
    'Av. Industrial 123',
    '987654321',
    'contacto@medifarma.com'
);

/* ============================================================
   SP PARA MODIFICAR LABORATORIO
   ============================================================ */

DELIMITER $$

CREATE PROCEDURE sp_modificar_laboratorio(
    IN p_id_laboratorio INT UNSIGNED,
    IN p_nombre_laboratorio VARCHAR(200),
    IN p_ruc VARCHAR(11),
    IN p_direccion VARCHAR(255),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(150)
)
BEGIN
    UPDATE laboratorio
    SET
        nombre_laboratorio = p_nombre_laboratorio,
        ruc = p_ruc,
        direccion = p_direccion,
        telefono = p_telefono,
        correo = p_correo
    WHERE id_laboratorio = p_id_laboratorio;
END $$

DELIMITER ;

-- Ejemplo de uso:
CALL sp_modificar_laboratorio(
    1,
    'Laboratorios Medifarma Actualizado',
    '20100123456',
    'Av. Industrial 456',
    '987654322',
    'ventas@medifarma.com'
);




/* ============================================================
   VISTA PARA LISTAR LOS CLIENTES ACTIVOS
   ============================================================ */

CREATE OR REPLACE VIEW view_clientes AS
SELECT
    c.id_cliente AS id_cliente,
    c.nombres AS nombres,
    c.apellidos AS apellidos,
    c.dni AS dni,
    c.direccion AS direccion,
    c.telefono AS telefono,
    c.correo AS correo,
    c.estado AS estado
FROM cliente c
WHERE c.estado = 1
ORDER BY c.id_cliente ASC;

select * from view_clientes;
/*=====================CRUD===============================================*/

/* ============================================================
   SP PARA BUSCAR CLIENTES
   ============================================================ */

DELIMITER $$

CREATE PROCEDURE sp_buscar_cliente(
    IN p_busqueda VARCHAR(150)
)
BEGIN
    SELECT
        id_cliente,
        nombres,
        apellidos,
        dni,
        direccion,
        telefono,
        correo,
        estado
    FROM view_clientes
    WHERE nombres LIKE CONCAT('%', p_busqueda, '%')
       OR id_cliente LIKE CONCAT('%', p_busqueda, '%')
       OR apellidos LIKE CONCAT('%', p_busqueda, '%')
       OR dni LIKE CONCAT('%', p_busqueda, '%')
       
    ORDER BY id_cliente ASC;
END $$

DELIMITER ;

-- Ejemplo de uso:
CALL sp_buscar_cliente('Saida');
CALL sp_buscar_cliente('');
/* ============================================================
   SP PARA GUARDAR CLIENTE
   ============================================================ */

DELIMITER $$

CREATE PROCEDURE sp_guardar_cliente(
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_dni VARCHAR(15),
    IN p_direccion VARCHAR(255),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(150)
)
BEGIN
    INSERT INTO cliente (
        nombres,
        apellidos,
        dni,
        direccion,
        telefono,
        correo,
        estado
    )
    VALUES (
        p_nombres,
        p_apellidos,
        p_dni,
        p_direccion,
        p_telefono,
        p_correo,
        1
    );
END $$

DELIMITER ;
-- Ejemplo de uso:
CALL sp_guardar_cliente(
    'Saida',
    'Torrealva Mendoza',
    '12345678',
    'Av. Pacífico 123',
    '987654321',
    'saida@gmail.com'
);

/* ============================================================
   SP PARA MODIFICAR CLIENTE
   ============================================================ */

DELIMITER $$

CREATE PROCEDURE sp_modificar_cliente(
    IN p_id_cliente INT UNSIGNED,
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_dni VARCHAR(15),
    IN p_direccion VARCHAR(255),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(150)
)
BEGIN
    UPDATE cliente
    SET
        nombres = p_nombres,
        apellidos = p_apellidos,
        dni = p_dni,
        direccion = p_direccion,
        telefono = p_telefono,
        correo = p_correo
    WHERE id_cliente = p_id_cliente;
END $$

DELIMITER ;
-- Ejemplo de uso:
CALL sp_modificar_cliente(
    1,
    'Saida',
    'Torrealva Mendoza Actualizado',
    '12345678',
    'Av. Pacífico 456',
    '987654322',
    'saida_actualizado@gmail.com'
);

/* ============================================================
   SP PARA DAR DE BAJA CLIENTE
   ============================================================ */

DELIMITER $$

CREATE PROCEDURE sp_baja_cliente(
    IN p_id_cliente INT UNSIGNED
)
BEGIN
    UPDATE cliente
    SET estado = 0
    WHERE id_cliente = p_id_cliente;
END $$

DELIMITER ;

-- Ejemplo de uso:
CALL sp_baja_cliente(1);


/*===============================================================
               CREAR VISTA SUB_CATEGORIA
=================================================================*/
/* 1. Vista */
DROP VIEW IF EXISTS vw_subcategoria;

CREATE VIEW vw_subcategoria AS
SELECT
    s.id_subcategoria,
    s.nombre_subcategoria,
    c.id_categoria,
    c.nombre_categoria
FROM subcategoria s
INNER JOIN categoria c
    ON s.id_categoria = c.id_categoria;

/* 2. Procedure para buscar usando la vista */

DROP PROCEDURE IF EXISTS sp_buscar_subcategoria;

DELIMITER //

CREATE PROCEDURE sp_buscar_subcategoria(
    IN p_busqueda VARCHAR(100)
)
BEGIN
    SELECT
        id_subcategoria,
        nombre_subcategoria,
        id_categoria,
        nombre_categoria
    FROM vw_subcategoria
    WHERE nombre_subcategoria LIKE CONCAT('%', p_busqueda, '%')
       OR nombre_categoria LIKE CONCAT('%', p_busqueda, '%');
END //

DELIMITER ;

/* 3. Procedure para insertar */

DROP PROCEDURE IF EXISTS sp_insertar_subcategoria;

DELIMITER //

CREATE PROCEDURE sp_insertar_subcategoria(
    IN p_nombre_subcategoria VARCHAR(100),
    IN p_id_categoria INT UNSIGNED
)
BEGIN
    INSERT INTO subcategoria (
        nombre_subcategoria,
        id_categoria
    )
    VALUES (
        p_nombre_subcategoria,
        p_id_categoria
    );
END //

DELIMITER ;

/* 4. Procedure para modificar */

DROP PROCEDURE IF EXISTS sp_modificar_subcategoria;

DELIMITER //

CREATE PROCEDURE sp_modificar_subcategoria(
    IN p_id_subcategoria INT UNSIGNED,
    IN p_nombre_subcategoria VARCHAR(100),
    IN p_id_categoria INT UNSIGNED
)
BEGIN

    /* Validar que no exista otra subcategoría
       con la misma categoría y nombre */

    IF EXISTS (
        SELECT 1
        FROM subcategoria
        WHERE nombre_subcategoria = p_nombre_subcategoria
          AND id_categoria = p_id_categoria
          AND id_subcategoria <> p_id_subcategoria
    ) THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT =
        'Error: Esta subcategoría ya existe en la categoría seleccionada.';

    ELSE

        UPDATE subcategoria
        SET
            nombre_subcategoria = p_nombre_subcategoria,
            id_categoria = p_id_categoria
        WHERE id_subcategoria = p_id_subcategoria;

    END IF;

END //

DELIMITER ;


/* Finaliza */

/*===============================================================
                  CREAR VISTA USUARIO
=================================================================*/

DROP VIEW IF EXISTS view_usuario;

CREATE VIEW view_usuario AS
SELECT
    u.id_usuario,
    u.codigo,
    u.password,
    u.id_cargo,
    c.nombre_cargo,
    u.id_personal,
    CONCAT(p.nombres, ' ', p.apellidos) AS nombre_personal,
    u.estado_usuario,
    CASE
        WHEN u.estado_usuario = 1 THEN 'Activo'
        ELSE 'Inactivo'
    END AS estado_texto
FROM usuario u
INNER JOIN cargo c
    ON u.id_cargo = c.id_cargo
LEFT JOIN personal p
    ON u.id_personal = p.id_personal;
/* 4. Procedure para modificar */

DELIMITER //

CREATE PROCEDURE sp_modificar_usuario(
    IN p_id_usuario INT UNSIGNED,
    IN p_codigo VARCHAR(15),
    IN p_password VARCHAR(255),
    IN p_id_cargo INT UNSIGNED,
    IN p_id_personal INT UNSIGNED,
    IN p_estado_usuario TINYINT
)
BEGIN
    IF EXISTS (
        SELECT 1
        FROM usuario
        WHERE codigo = p_codigo
          AND id_usuario <> p_id_usuario
    ) THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: El código de usuario ya existe.';

    ELSE

        UPDATE usuario
        SET
            codigo = p_codigo,
            password = p_password,
            id_cargo = p_id_cargo,
            id_personal = p_id_personal,
            estado_usuario = p_estado_usuario
        WHERE id_usuario = p_id_usuario;

    END IF;
END //

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE sp_desactivar_usuario(IN p_id_usuario INT)
BEGIN
    IF EXISTS (
        SELECT 1
        FROM usuario
        WHERE id_usuario = p_id_usuario
    ) THEN

        UPDATE usuario
        SET estado_usuario = 0
        WHERE id_usuario = p_id_usuario;

    END IF;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE sp_activar_usuario(IN p_id_usuario INT)
BEGIN
    IF EXISTS (
        SELECT 1
        FROM usuario
        WHERE id_usuario = p_id_usuario
    ) THEN

        UPDATE usuario
        SET estado_usuario = 1
        WHERE id_usuario = p_id_usuario;

    END IF;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE sp_reactivar_usuario(IN p_id_usuario INT)
BEGIN
    IF EXISTS (
        SELECT 1
        FROM usuario
        WHERE id_usuario = p_id_usuario
    ) THEN

        UPDATE usuario
        SET estado_usuario = 1
        WHERE id_usuario = p_id_usuario;

    END IF;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE sp_resetear_password_usuario(IN p_id_usuario INT)
BEGIN

    IF EXISTS (
        SELECT 1
        FROM usuario
        WHERE id_usuario = p_id_usuario
    ) THEN

        UPDATE usuario
        SET password = '123456'
        WHERE id_usuario = p_id_usuario;

    END IF;

END $$

DELIMITER ;
/* Finaliza */

/*=========================0RECETA================00*/

DROP VIEW IF EXISTS vw_receta;

CREATE VIEW vw_receta AS
SELECT
    r.id_receta,
    r.id_cliente,
    CONCAT(c.nombres, ' ', c.apellidos) AS nombre_cliente,
    c.dni AS dni_cliente,
    r.id_personal,
    CONCAT(p.nombres, ' ', p.apellidos) AS nombre_personal,
    r.diagnostico,
    r.fecha_emision,
    r.observaciones
FROM receta r
INNER JOIN cliente c
    ON r.id_cliente = c.id_cliente
INNER JOIN personal p
    ON r.id_personal = p.id_personal;



DROP PROCEDURE IF EXISTS sp_receta_listar;

CREATE PROCEDURE sp_receta_listar()
BEGIN
    SELECT
        id_receta,
        id_cliente,
        nombre_cliente,
        dni_cliente,
        id_personal,
        nombre_personal,
        diagnostico,
        fecha_emision,
        observaciones
    FROM vw_receta
    ORDER BY id_receta ASC;
END;
/*========================================00
*/
DROP PROCEDURE IF EXISTS sp_receta_listar;

DELIMITER //

CREATE PROCEDURE sp_receta_listar()
BEGIN
    SELECT
        id_receta,
        id_cliente,
        nombre_cliente,
        dni_cliente,
        id_personal,
        nombre_personal,
        diagnostico,
        fecha_emision,
        observaciones
    FROM vw_receta
    ORDER BY id_receta ASC;
END //

DELIMITER ;

DROP PROCEDURE IF EXISTS sp_receta_buscar;

DELIMITER //

CREATE PROCEDURE sp_receta_buscar(
    IN p_busqueda VARCHAR(255)
)
BEGIN
    SELECT
        id_receta,
        id_cliente,
        nombre_cliente,
        dni_cliente,
        id_personal,
        nombre_personal,
        diagnostico,
        fecha_emision,
        observaciones
    FROM vw_receta
    WHERE nombre_cliente LIKE CONCAT('%', p_busqueda, '%')
       OR dni_cliente LIKE CONCAT('%', p_busqueda, '%')
       OR nombre_personal LIKE CONCAT('%', p_busqueda, '%')
       OR diagnostico LIKE CONCAT('%', p_busqueda, '%')
       OR observaciones LIKE CONCAT('%', p_busqueda, '%')
    ORDER BY id_receta ASC;
END //

DELIMITER ;

DROP PROCEDURE IF EXISTS sp_receta_insertar;

DELIMITER //

CREATE PROCEDURE sp_receta_insertar(
    IN p_id_cliente INT UNSIGNED,
    IN p_id_personal INT UNSIGNED,
    IN p_diagnostico VARCHAR(255),
    IN p_fecha_emision DATE,
    IN p_observaciones VARCHAR(255)
)
BEGIN
    INSERT INTO receta (
        id_cliente,
        id_personal,
        diagnostico,
        fecha_emision,
        observaciones
    )
    VALUES (
        p_id_cliente,
        p_id_personal,
        p_diagnostico,
        p_fecha_emision,
        p_observaciones
    );
END //

DELIMITER ;


DROP PROCEDURE IF EXISTS sp_receta_modificar;

DELIMITER //

CREATE PROCEDURE sp_receta_modificar(
    IN p_id_receta INT UNSIGNED,
    IN p_id_cliente INT UNSIGNED,
    IN p_id_personal INT UNSIGNED,
    IN p_diagnostico VARCHAR(255),
    IN p_fecha_emision DATE,
    IN p_observaciones VARCHAR(255)
)
BEGIN
    UPDATE receta
    SET
        id_cliente = p_id_cliente,
        id_personal = p_id_personal,
        diagnostico = p_diagnostico,
        fecha_emision = p_fecha_emision,
        observaciones = p_observaciones
    WHERE id_receta = p_id_receta;
END //

DELIMITER ;


DROP PROCEDURE IF EXISTS sp_receta_eliminar;

DELIMITER //

CREATE PROCEDURE sp_receta_eliminar(
    IN p_id_receta INT UNSIGNED
)
BEGIN
    DELETE FROM receta
    WHERE id_receta = p_id_receta;
END //

DELIMITER ;


/*===========0Login====================0=*/
/*=========================LOGIN==============================================*/
/*Se considera como parametros Codigo, password,nombrecargo para el ingreso*/
DELIMITER //

DROP PROCEDURE IF EXISTS sp_validar_usuario//

CREATE PROCEDURE sp_validar_usuario(
IN p_codigo VARCHAR(15),
IN p_password VARCHAR(255),
IN p_cargo VARCHAR(100)
)
BEGIN
SELECT
u.id_usuario,
u.codigo,
u.password,
c.nombre_cargo,
u.estado_usuario
FROM usuario u
INNER JOIN cargo c
ON u.id_cargo = c.id_cargo
WHERE u.codigo = p_codigo
AND u.password = p_password
AND c.nombre_cargo = p_cargo
AND u.estado_usuario = 1;
END //

DELIMITER ;


-- Testeo procedure
CALL sp_validar_usuario('11001', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'Gerente');



/*Procedure para cambiar el estadousuario cuando supera los intentos*/
DELIMITER //
DROP PROCEDURE IF EXISTS sp_bloquear_usuario //
CREATE PROCEDURE sp_bloquear_usuario(
    IN p_codigo VARCHAR(15)
)
BEGIN
    UPDATE Usuario 
    SET EstadoUsuario = 0 
    WHERE Codigo = p_codigo;
END //
DELIMITER ;



/*==============PERSONAL=============================================00*/


DROP VIEW IF EXISTS vw_personal;

CREATE VIEW vw_personal AS
SELECT
    p.id_personal,
    p.id_tipo_personal,
    tp.nombre_tipo_personal,
    p.id_cargo,
    c.nombre_cargo,
    p.id_area,
    a.nombre_area,
    p.id_sucursal,
    s.nombre_sucursal,
    p.nombres,
    p.apellidos,

    CONCAT(p.nombres, ' ', p.apellidos) AS nombre_personal,

    p.dni,
    p.direccion,
    p.telefono,
    p.correo,
    p.observaciones,
    p.estado,

    CASE
        WHEN p.estado = 1 THEN 'Activo'
        ELSE 'Inactivo'
    END AS estado_texto

FROM personal p
INNER JOIN tipo_personal tp
    ON p.id_tipo_personal = tp.id_tipo_personal
INNER JOIN cargo c
    ON p.id_cargo = c.id_cargo
INNER JOIN area a
    ON p.id_area = a.id_area
INNER JOIN sucursal s
    ON p.id_sucursal = s.id_sucursal;



DROP PROCEDURE IF EXISTS sp_personal_buscar;

DELIMITER $$

CREATE PROCEDURE sp_personal_buscar(
    IN p_busqueda VARCHAR(100)
)
BEGIN

    SELECT
        id_personal,
        id_tipo_personal,
        nombre_tipo_personal,
        id_cargo,
        nombre_cargo,
        id_area,
        nombre_area,
        id_sucursal,
        nombre_sucursal,
        nombres,
        apellidos,
        dni,
        direccion,
        telefono,
        correo,
        observaciones,
        estado,
        estado_texto
    FROM vw_personal
    WHERE
        nombres LIKE CONCAT('%', p_busqueda, '%')
        OR apellidos LIKE CONCAT('%', p_busqueda, '%')
        OR dni LIKE CONCAT('%', p_busqueda, '%')
    ORDER BY id_personal ASC;

END $$

DELIMITER ;


DROP PROCEDURE IF EXISTS sp_personal_insertar;

DELIMITER $$

CREATE PROCEDURE sp_personal_insertar(
    IN p_id_tipo_personal INT,
    IN p_id_cargo INT,
    IN p_id_area INT,
    IN p_id_sucursal INT,
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_dni VARCHAR(15),
    IN p_direccion VARCHAR(255),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(150),
    IN p_observaciones VARCHAR(255)
)
BEGIN

    INSERT INTO personal (
        id_tipo_personal,
        id_cargo,
        id_area,
        id_sucursal,
        nombres,
        apellidos,
        dni,
        direccion,
        telefono,
        correo,
        observaciones
       
    )
    VALUES (
        p_id_tipo_personal,
        p_id_cargo,
        p_id_area,
        p_id_sucursal,
        p_nombres,
        p_apellidos,
        p_dni,
        p_direccion,
        p_telefono,
        p_correo,
        p_observaciones,
        1
    );

END $$

DELIMITER ;


DROP PROCEDURE IF EXISTS sp_personal_modificar;

DELIMITER $$

CREATE PROCEDURE sp_personal_modificar(
    IN p_id_personal INT,
    IN p_id_tipo_personal INT,
    IN p_id_cargo INT,
    IN p_id_area INT,
    IN p_id_sucursal INT,
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_dni VARCHAR(15),
    IN p_direccion VARCHAR(255),
    IN p_telefono VARCHAR(20),
    IN p_correo VARCHAR(150),
    IN p_observaciones VARCHAR(255)
)
BEGIN

    UPDATE personal
    SET
        id_tipo_personal = p_id_tipo_personal,
        id_cargo = p_id_cargo,
        id_area = p_id_area,
        id_sucursal = p_id_sucursal,
        nombres = p_nombres,
        apellidos = p_apellidos,
        dni = p_dni,
        direccion = p_direccion,
        telefono = p_telefono,
        correo = p_correo,
        observaciones = p_observaciones
    WHERE id_personal = p_id_personal;

END $$

DELIMITER ;

DROP PROCEDURE IF EXISTS sp_personal_estado;

DELIMITER $$




DELIMITER $$

CREATE PROCEDURE sp_personal_estado(
    IN p_id_personal INT,
    IN p_estado TINYINT
)
BEGIN

    IF p_estado = 1 THEN

        UPDATE personal
        SET estado = 1
        WHERE id_personal = p_id_personal;

    ELSE

        UPDATE personal
        SET estado = 0
        WHERE id_personal = p_id_personal;

    END IF;

END $$

DELIMITER ;

