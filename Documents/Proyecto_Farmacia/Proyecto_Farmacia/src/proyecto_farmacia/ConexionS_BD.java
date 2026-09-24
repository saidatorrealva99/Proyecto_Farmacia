
package proyecto_farmacia;
import java.sql.*;

public class ConexionS_BD { 
    // Variables de instancia para la conexion y ejecucion de consultas
    private Connection conn;
    private Statement st;
    private ResultSet rs;

    // Parametros de conexion (ajusta segun tu entorno)
    private static final String URL = "jdbc:mysql://localhost:3306/bdfarmacia";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Constructor: se ejecuta al crear el objeto y conecta con la base de datos
     * ... 3 lines *
     */
    public ConexionS_BD() {
        try {
            // Cargar el driver de MySQL (opcional en versiones recientes)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer conexion con la BD
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Conexion establecida correctamente con la BD 'Proyecto_farmacia'.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver de MySQL no encontrado.");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos.");
        }
    }

/*FINALIZA/*
/* MANTENIMIENTO A LA TABLA SUCURSAL */

/* 1. Método para listar todas las sucursales usando la vista */
public ResultSet listarSucursales() throws SQLException {
    String sql = "SELECT * FROM view_sucursales";
    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;
}

/* 2. Método para buscar sucursales por coincidencia de nombre */
public ResultSet buscarSucursales(String nombre) throws SQLException {
    String sql = "{CALL sp_buscar_sucursal(?)}";
    CallableStatement cs = conn.prepareCall(sql);
    cs.setString(1, nombre);
    rs = cs.executeQuery();
    return rs;
}
/* 3. Método para insertar una nueva sucursal */
public void insertarSucursal(String nombre, String direccion, String telefono) throws SQLException {
    String sql = "{CALL sp_guardar_sucursal(?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setString(1, nombre);
        cs.setString(2, direccion);
        cs.setString(3, telefono);
        cs.execute();

        System.out.println("Sucursal insertada correctamente...!");
    }
}
/* 4. Método para modificar una sucursal existente */
public void modificarSucursal(int id, String nombre, String direccion, String telefono) throws SQLException {
    String sql = "{CALL sp_modificar_sucursal(?, ?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setInt(1, id);
        cs.setString(2, nombre);
        cs.setString(3, direccion);
        cs.setString(4, telefono);
        cs.executeUpdate();

        System.out.println("Sucursal modificada correctamente...!");
    }
}
/* 5. Método para eliminar una sucursal 
public void eliminarSucursal(int id) throws SQLException {
    String sql = "{CALL sp_sucursal_eliminar(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setInt(1, id);
        cs.executeUpdate();

        System.out.println("Sucursal eliminada correctamente...!");
    }FINALIZA
}*/



/* MANTENIMIENTO A LA TABLA PROVEEDOR */

/* 1. Método para listar todos los proveedores activos usando la vista */
public ResultSet listarProveedores() throws SQLException {
    String sql = "SELECT * FROM view_proveedores";
    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;
}

/* 2. Método para buscar proveedores por coincidencia de razón social */
public ResultSet buscarProveedores(String razonSocial) throws SQLException {
    String sql = "{CALL sp_buscar_proveedor(?)}";
    CallableStatement cs = conn.prepareCall(sql);
    cs.setString(1, razonSocial);
    rs = cs.executeQuery();
    return rs;
}

/* 3. Método para insertar un nuevo proveedor */
public void insertarProveedor(
        String razonSocial,
        String ruc,
        String telefono,
        String direccion,
        String correo) throws SQLException {

    String sql = "{CALL sp_guardar_proveedor(?, ?, ?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setString(1, razonSocial);
        cs.setString(2, ruc);
        cs.setString(3, telefono);
        cs.setString(4, direccion);
        cs.setString(5, correo);
        cs.execute();

        System.out.println("Proveedor insertado correctamente...!");
    }
}

/* 4. Método para modificar un proveedor existente */
public void modificarProveedor(
        int id,
        String razonSocial,
        String ruc,
        String telefono,
        String direccion,
        String correo) throws SQLException {

    String sql = "{CALL sp_modificar_proveedor(?, ?, ?, ?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setInt(1, id);
        cs.setString(2, razonSocial);
        cs.setString(3, ruc);
        cs.setString(4, telefono);
        cs.setString(5, direccion);
        cs.setString(6, correo);
        cs.executeUpdate();

        System.out.println("Proveedor modificado correctamente...!");
    }
}

/* 5. Método para dar de baja (desactivar) un proveedor lógicamente */
public void desactivarProveedor(int id) throws SQLException {
    String sql = "{CALL sp_baja_proveedor(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setInt(1, id);
        cs.executeUpdate();

        System.out.println("Proveedor desactivado correctamente...!");
    }
}


/* 8. Activar un Proveedor */
public boolean activarProveedor(int idProveedor) throws SQLException {

    String sql = "{CALL sp_activar_proveedor(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idProveedor);

        cs.execute();

        return true;
    }
}

/*9 Listar todos los proveedores dados de baja */
public ResultSet listarProveedoresDeBaja() throws SQLException {

    String sql = "SELECT id_proveedor, razon_social, ruc, "
               + "telefono, direccion, correo, estado "
               + "FROM proveedor "
               + "WHERE estado = 0 "
               + "ORDER BY id_proveedor";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}

/* MANTENIMIENTO A LA TABLA LABORATORIO */


/* 1. Método para listar todos los laboratorios usando la vista */
public ResultSet listarLaboratorios() throws SQLException {
    String sql = "SELECT * FROM view_laboratorios";
    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;
}

/* 2. Método para buscar laboratorios por coincidencia de nombre */
public ResultSet buscarLaboratorios(String nombre) throws SQLException {
    String sql = "{CALL sp_buscar_laboratorio(?)}";
    CallableStatement cs = conn.prepareCall(sql);
    cs.setString(1, nombre);
    rs = cs.executeQuery();
    return rs;
}

/* 3. Método para insertar un nuevo laboratorio */
public void insertarLaboratorio(
        String nombre, String ruc, String direccion, String telefono, String correo) throws SQLException {

    String sql = "{CALL sp_guardar_laboratorio(?, ?, ?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        
        cs.setString(1, nombre);
        cs.setString(2, ruc);
        cs.setString(3, direccion);
        cs.setString(4, telefono);
        cs.setString(5, correo);
        cs.executeUpdate();

        System.out.println("Laboratorio insertado correctamente...!");
    }
}

/* 4. Método para modificar un laboratorio existente */
public void modificarLaboratorio( 
        int id,
        String nombre, String ruc, String direccion, String telefono, String correo ) throws SQLException {

    String sql = "{CALL sp_modificar_laboratorio(?, ?, ?, ?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setInt(1, id);
        cs.setString(2, nombre);
        cs.setString(3, ruc);
        cs.setString(4, direccion);
        cs.setString(5, telefono);
        cs.setString(6, correo);
        cs.executeUpdate();

        System.out.println("Laboratorio modificado correctamente...!");
    }
}

/* 5. Método para eliminar un laboratorio */
public void eliminarLaboratorio(int id) throws SQLException {
    String sql = "{CALL sp_eliminar_laboratorio(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setInt(1, id);
        cs.executeUpdate();

        System.out.println("Laboratorio eliminado correctamente...!");
    }
}

/*================MANTENIMIENTO A LA TABLA CLIENTE=============================== */

/* 1. Método para listar todos los clientes activos usando la vista */
public ResultSet listarClientes() throws SQLException {
    String sql = "SELECT * FROM view_clientes";
    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;
}

/* 2. Método para buscar clientes por coincidencia de nombres */
public ResultSet buscarClientes(String nombre) throws SQLException {
    String sql = "{CALL sp_buscar_cliente(?)}";
    CallableStatement cs = conn.prepareCall(sql);
    cs.setString(1, nombre);
    rs = cs.executeQuery();
    return rs;
}

/* 3. Método para insertar un nuevo cliente */
public void insertarCliente(
        String nombres,
        String apellidos,
        String dni,
        String direccion,
        String telefono,
        String correo) throws SQLException {

    String sql = "{CALL sp_guardar_cliente(?, ?, ?, ?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setString(1, nombres);
        cs.setString(2, apellidos);
        cs.setString(3, dni);
        cs.setString(4, direccion);
        cs.setString(5, telefono);
        cs.setString(6, correo);
        cs.execute();

        System.out.println("Cliente insertado correctamente...!");
    }
}


/* 4. Método para modificar un cliente existente */
public void modificarCliente(
        int id,
        String nombres,
        String apellidos,
        String dni,
        String direccion,
        String telefono,
        String correo) throws SQLException {

    String sql = "{CALL sp_modificar_cliente(?, ?, ?, ?, ?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {
        cs.setInt(1, id);
        cs.setString(2, nombres);
        cs.setString(3, apellidos);
        cs.setString(4, dni);
        cs.setString(5, direccion);
        cs.setString(6, telefono);
        cs.setString(7, correo);
        cs.executeUpdate();

        System.out.println("Cliente modificado correctamente...!");
    }
}

    /* 5. Método para dar de baja (desactivar) un cliente lógicamente */
    public void desactivarCliente(int id) throws SQLException {
        String sql = "{CALL sp_baja_cliente(?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id);
            cs.executeUpdate();

            System.out.println("Cliente desactivado correctamente...!");
        }
    }

    public Connection getConexion() {

        return conn;
    }
    /*================ MANTENIMIENTO A LA TABLA SUBCATEGORIA ===============================*/


/*============ MANTENIMIENTO SUBCATEGORIA ========================================*/

/* 1. Para cargar las categorías al JComboBox */
public ResultSet combobox_ListarCategorias() throws SQLException {

    String sql = "SELECT nombre_categoria FROM categoria ORDER BY nombre_categoria";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


/* 2. Obtiene el código de la categoría dado su nombre */
public int obtenerCodigoCategoria(String nombreCategoria) throws SQLException {

    String sql = "SELECT id_categoria FROM categoria WHERE nombre_categoria = ?";

    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, nombreCategoria);

    ResultSet rsAux = ps.executeQuery();

    if (rsAux.next()) {
        return rsAux.getInt("id_categoria");
    } else {
        return -1;
    }
}


/* 3. Listar subcategorías usando la vista */
public ResultSet verSubcategorias() throws SQLException {

    String sql = "SELECT "
            + "s.id_subcategoria, "
            + "s.nombre_subcategoria, "
            + "(SELECT c.nombre_categoria "
            + " FROM categoria c "
            + " WHERE c.id_categoria = s.id_categoria) AS nombre_categoria "
            + "FROM subcategoria s "
            + " ORDER BY s.id_subcategoria ASC";
    

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


/* 4. Buscar subcategoría por nombre de subcategoría o categoría */
public ResultSet buscarSubcategoria(String criterio) throws SQLException {

    String sql = "{CALL sp_buscar_subcategoria(?)}";

    CallableStatement cs = conn.prepareCall(sql);
    cs.setString(1, criterio);

    rs = cs.executeQuery();

    return rs;
}


/* 5. Insertar una nueva subcategoría */
public void insertarSubcategoria(
        String nombreSubcategoria,
        int idCategoria) throws SQLException {

    String sql = "{CALL sp_insertar_subcategoria(?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setString(1, nombreSubcategoria);
        cs.setInt(2, idCategoria);

        cs.execute();
    }
}


/* 6. Modificar una subcategoría */
public void modificarSubcategoria(
        int idSubcategoria,
        String nombreSubcategoria,
        int idCategoria) throws SQLException {

    String sql = "{CALL sp_modificar_subcategoria(?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idSubcategoria);
        cs.setString(2, nombreSubcategoria);
        cs.setInt(3, idCategoria);

        cs.executeUpdate();
    }
}

/*================ FINALIZA MANTENIMIENTO SUBCATEGORIA ===============================*/
/*============================================================================*/    
     public void cerrarConexion() {
         /* Método: cierra todos los objetos abiertos (buena práctica) ... 3 lines */
        try {
            if (rs != null) rs.close () ; // Cierra resultados
            if (st != null) st.close (); // Cierra sentencia
            if (conn != null) conn.close (); // Cierra conexion
            System. out.println(" Conexion cerrada correctamente.");
        }catch (SQLException e) {
            System. err.println("X Error al cerrar la conexion.") ;
        }
        
    }

     
     
/*============ MANTENIMIENTO USUARIO ========================================*/

/* 1. Para cargar los cargos al JComboBox */
public ResultSet combobox_ListarCargos() throws SQLException {

    String sql = "SELECT nombre_cargo "
            + "FROM cargo "
            + "WHERE estado_cargo = 1 "
            + "ORDER BY nombre_cargo";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


/* 2. Obtiene el código del cargo dado su nombre */
public int obtenerCodigoCargo(String nombreCargo) throws SQLException {

    String sql = "SELECT id_cargo "
            + "FROM cargo "
            + "WHERE nombre_cargo = ?";

    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, nombreCargo);

    ResultSet rsAux = ps.executeQuery();

    if (rsAux.next()) {
        return rsAux.getInt("id_cargo");
    } else {
        return -1;
    }
}

/* 3. Listar usuarios usando la vista */
public ResultSet verUsuarios() throws SQLException {

    String sql = "SELECT "
            + "id_usuario, "
            + "codigo, "
            + "password, "
            + "id_cargo, "
            + "nombre_cargo, "
            + "id_personal, "
            + "nombre_personal, "
            + "estado_usuario "
            + "FROM view_usuario "
            + "ORDER BY id_usuario ASC";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


/* 4. Buscar usuario por código o cargo */
public ResultSet buscarUsuario(String criterio) throws SQLException {

    String sql = "{CALL sp_buscar_usuario(?)}";

    CallableStatement cs = conn.prepareCall(sql);
    cs.setString(1, criterio);

    rs = cs.executeQuery();

    return rs;
}


/* 5. Insertar un nuevo usuario */
public void insertarUsuario(
        String codigo,
        String password,
        int idCargo,
        int idPersonal,
        int estadoUsuario) throws SQLException {

    String sql = "{CALL sp_insertar_usuario(?, ?, ?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setString(1, codigo);
        cs.setString(2, password);
        cs.setInt(3, idCargo);

        if (idPersonal == -1) {
            cs.setNull(4, java.sql.Types.INTEGER);
        } else {
            cs.setInt(4, idPersonal);
        }

        cs.setInt(5, estadoUsuario);

        cs.execute();
    }
}


/* 6. Modificar un usuario */
public void modificarUsuario(
        int idUsuario,
        String codigo,
        String password,
        int idCargo,
        int idPersonal,
        int estadoUsuario) throws SQLException {

    String sql = "{CALL sp_modificar_usuario(?, ?, ?, ?, ?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idUsuario);
        cs.setString(2, codigo);
        cs.setString(3, password);
        cs.setInt(4, idCargo);

        if (idPersonal == -1) {
            cs.setNull(5, java.sql.Types.INTEGER);
        } else {
            cs.setInt(5, idPersonal);
        }

        cs.setInt(6, estadoUsuario);

        cs.executeUpdate();
    }
    
}
/* 7. Desactivar un usuario */
public boolean desactivarUsuario(int idUsuario) throws SQLException {

    String sql = "{CALL sp_desactivar_usuario(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idUsuario);
        cs.executeUpdate();

        return true;
    }
}

/* 8. Activar un usuario */
public boolean activarUsuario(int idUsuario) throws SQLException {

    String sql = "{CALL sp_activar_usuario(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idUsuario);
        cs.executeUpdate();

        return true;
    }
}

/* 8. Reactivar un usuario */
public boolean reactivarUsuario(int idUsuario) throws SQLException {

    String sql = "{CALL sp_reactivar_usuario(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idUsuario);
        cs.executeUpdate();

        return true;
    }
}
/* Método para listar todos los registros de Personal usando la vista */
public ResultSet listarPersonal() throws SQLException {
    String sql = "SELECT * FROM vw_personal";
    st = conn.createStatement();
    rs = st.executeQuery(sql);
    return rs;
}
public boolean resetearPasswordUsuario(int idUsuario) throws SQLException {

    String sql = "{CALL sp_resetear_password_usuario(?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idUsuario);
        cs.executeUpdate();

        return true;
    }
}
/*================ FINALIZA MANTENIMIENTO USUARIO ===============================*/
  
public ResultSet verRecetas() throws SQLException {

    String sql = "{CALL sp_receta_listar()}";

    CallableStatement cs = conn.prepareCall(sql);

    return cs.executeQuery();
}

public ResultSet buscarReceta(String busqueda) throws SQLException {

    String sql = "{CALL sp_receta_buscar(?)}";

    CallableStatement cs = conn.prepareCall(sql);

    cs.setString(1, busqueda);

    return cs.executeQuery();
}



public void insertarReceta(
        int idCliente,
        int idPersonal,
        String diagnostico,
        String fechaEmision,
        String observaciones) throws SQLException {

    String sql = "{CALL sp_receta_insertar(?,?,?,?,?)}";

    CallableStatement cs = conn.prepareCall(sql);

    cs.setInt(1, idCliente);
    cs.setInt(2, idPersonal);
    cs.setString(3, diagnostico);
    cs.setString(4, fechaEmision);
    cs.setString(5, observaciones);

    cs.executeUpdate();
}

public void modificarReceta(
        int idReceta,
        int idCliente,
        int idPersonal,
        String diagnostico,
        String fechaEmision,
        String observaciones) throws SQLException {

    String sql = "{CALL sp_receta_modificar(?,?,?,?,?,?)}";

    CallableStatement cs = conn.prepareCall(sql);

    cs.setInt(1, idReceta);
    cs.setInt(2, idCliente);
    cs.setInt(3, idPersonal);
    cs.setString(4, diagnostico);
    cs.setString(5, fechaEmision);
    cs.setString(6, observaciones);

    cs.executeUpdate();
}

public void eliminarReceta(int idReceta) throws SQLException {

    String sql = "{CALL sp_receta_eliminar(?)}";

    CallableStatement cs = conn.prepareCall(sql);

    cs.setInt(1, idReceta);

    cs.executeUpdate();
}

public ResultSet combobox_ListarClientes() throws SQLException {

    String sql = "SELECT id_cliente, "
            + "CONCAT(nombres, ' ', apellidos) AS nombre_cliente "
            + "FROM cliente "
            + "WHERE estado = 1 "
            + "ORDER BY nombres, apellidos";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}

public int obtenerIdCliente(String nombreCliente) throws SQLException {

    String sql = "SELECT id_cliente "
            + "FROM cliente "
            + "WHERE CONCAT(nombres, ' ', apellidos) = ?";

    PreparedStatement ps = conn.prepareStatement(sql);

    ps.setString(1, nombreCliente);

    ResultSet resultado = ps.executeQuery();

    if (resultado.next()) {
        return resultado.getInt("id_cliente");
    }

    return -1;
}



public ResultSet combobox_ListarPersonal() throws SQLException {

    String sql = "SELECT id_personal, "
            + "CONCAT(nombres, ' ', apellidos) AS nombre_personal "
            + "FROM personal "
            + "WHERE estado = 1 "
            + "ORDER BY nombres, apellidos";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}


public int obtenerIdPersonal(String nombrePersonal) throws SQLException {

    String sql = "SELECT id_personal "
            + "FROM personal "
            + "WHERE CONCAT(nombres, ' ', apellidos) = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, nombrePersonal);

        try (ResultSet resultado = ps.executeQuery()) {

            if (resultado.next()) {
                return resultado.getInt("id_personal");
            }
        }
    }

    return -1;
}



/*============LOGIN======================0*/

//*==================== PARA EL INICIO DE SESIÓN - LOGIN =====================*/
/* 1. Para cargar los cargos en el JComboBox */
public ResultSet ComboBox_Cargos() throws SQLException {

    String sql = "SELECT nombre_cargo "
            + "FROM cargo "
            + "WHERE estado_cargo = 1 "
            + "ORDER BY nombre_cargo";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}
    
    
    /* Método para validar si el acceso es correcto y devuelve true o false */
    public boolean validarLogin(String codigo, String password, String cargo) throws SQLException {
        String sql = "{CALL sp_validar_usuario(?, ?, ?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, codigo);
            cs.setString(2, password);
            cs.setString(3, cargo);

            try (ResultSet rs = cs.executeQuery()) {
                // Si encuentra un registro, significa que el usuario, clave y cargo coinciden y está activo
                return rs.next();
            }
        }
    }
    
    
    /* Método para bloquear al usuario tras superar los intentos fallidos */
    public void bloquearUsuario(String codigo) throws SQLException {
        String sql = "{CALL sp_bloquear_usuario(?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, codigo);
            cs.executeUpdate();
        }
    }



/*============PERSONAL===========================================00*/

public ResultSet buscarPersonal(String busqueda) throws SQLException {

    String sql = "{CALL sp_personal_buscar(?)}";

    CallableStatement cs = conn.prepareCall(sql);
    cs.setString(1, busqueda);

    rs = cs.executeQuery();

    return rs;
}

public ResultSet comboBoxTipoPersonal() throws SQLException {

    String sql = "SELECT nombre_tipo_personal "
            + "FROM tipo_personal "
            + "ORDER BY nombre_tipo_personal ASC";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}

public ResultSet comboBoxCargosPersonal() throws SQLException {

    String sql = "SELECT nombre_cargo "
            + "FROM cargo "
            + "WHERE estado_cargo = 1 "
            + "ORDER BY nombre_cargo ASC";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}

public ResultSet comboBoxAreasPersonal() throws SQLException {

    String sql = "SELECT nombre_area "
            + "FROM area "
            + "ORDER BY nombre_area ASC";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}

public ResultSet comboBoxSucursalesPersonal() throws SQLException {

    String sql = "SELECT nombre_sucursal "
            + "FROM sucursal "
            + "ORDER BY nombre_sucursal ASC";

    st = conn.createStatement();
    rs = st.executeQuery(sql);

    return rs;
}

public int obtenerIdTipoPersonal(String nombre) throws SQLException {

    String sql = "SELECT id_tipo_personal "
            + "FROM tipo_personal "
            + "WHERE nombre_tipo_personal = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, nombre);

        try (ResultSet resultado = ps.executeQuery()) {

            if (resultado.next()) {
                return resultado.getInt("id_tipo_personal");
            }
        }
    }

    return -1;
}

public int obtenerIdCargoPersonal(String nombre) throws SQLException {

    String sql = "SELECT id_cargo "
            + "FROM cargo "
            + "WHERE nombre_cargo = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, nombre);

        try (ResultSet resultado = ps.executeQuery()) {

            if (resultado.next()) {
                return resultado.getInt("id_cargo");
            }
        }
    }

    return -1;
}

public int obtenerIdAreaPersonal(String nombre) throws SQLException {

    String sql = "SELECT id_area "
            + "FROM area "
            + "WHERE nombre_area = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, nombre);

        try (ResultSet resultado = ps.executeQuery()) {

            if (resultado.next()) {
                return resultado.getInt("id_area");
            }
        }
    }

    return -1;
}

public int obtenerIdSucursalPersonal(String nombre) throws SQLException {

    String sql = "SELECT id_sucursal "
            + "FROM sucursal "
            + "WHERE nombre_sucursal = ?";

    try (PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, nombre);

        try (ResultSet resultado = ps.executeQuery()) {

            if (resultado.next()) {
                return resultado.getInt("id_sucursal");
            }
        }
    }

    return -1;
}
//6.modificar personal
public void modificarPersonal(
        int idPersonal,
        int idTipoPersonal,
        int idCargo,
        int idArea,
        int idSucursal,
        String nombres,
        String apellidos,
        String dni,
        String direccion,
        String telefono,
        String correo,
        String observaciones
        /*String estado*/) throws SQLException {

    String sql = "{CALL sp_personal_modificar(?,?,?,?,?,?,?,?,?,?,?,?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idPersonal);
        cs.setInt(2, idTipoPersonal);
        cs.setInt(3, idCargo);
        cs.setInt(4, idArea);
        cs.setInt(5, idSucursal);
        cs.setString(6, nombres);
        cs.setString(7, apellidos);
        cs.setString(8, dni);
        cs.setString(9, direccion);
        cs.setString(10, telefono);
        cs.setString(11, correo);
        cs.setString(12, observaciones);
        //cs.setString(13, estado);

        cs.executeUpdate();
    }
}
/* 7. Desactivar un Personal */
public boolean desactivarPersonal(int idPersonal) throws SQLException {

    String sql = "{CALL sp_personal_estado(?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idPersonal);
        cs.setInt(2, 0); // 0 = desactivar

        cs.execute();

        return true;
    }
}

/* 8. Activar un Personal */
public boolean activarPersonal(int idPersonal) throws SQLException {

    String sql = "{CALL sp_personal_estado(?, ?)}";

    try (CallableStatement cs = conn.prepareCall(sql)) {

        cs.setInt(1, idPersonal);
        cs.setInt(2, 1); // 1 = activar

        cs.execute();

        return true;
    }
}

}



