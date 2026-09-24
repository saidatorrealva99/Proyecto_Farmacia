package proyecto_farmacia;

import java.sql.*;

public class ConexionC_BD {

    // Variables de instancia para la conexión y ejecución de consultas
    private Connection conn; //conexion
    private Statement st; //procedimientos
    private ResultSet rs; //resultados

    // Parámetros de conexión (ajusta según tu entorno)
    private static final String URL = "jdbc:mysql://localhost:3306/bdfarmacia";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Constructor: se ejecuta al crear el objeto y conecta con la base de datos
     */
    public ConexionC_BD() {
        try {
            /*Cargar el driver de MYSQL (Opcional en versiones recientes)*/
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer conexión con la BD
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida correctamente con la BD 'farmacia'.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver de MySQL no encontrado.");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos.");
        }
    }

    /*Finaliza lo de arriba es todo base de datos, conectarse*/
    /**
     * **************************************************************************
     */
    /**
     * Método: obtiene el listado de escuelas profesionales (con JOIN a facultad
     * y escuelaprofesional) [ES PARA CREAR VISTAS NO SE PUEDE REPETIR EL NOMBRE
     * DESPUES DE RESULTSET]
     */
    public ResultSet listarArea() throws SQLException {
        String sql = "select*from view_area";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    /*Metodo para listar los cursos*/
    public ResultSet listarCargo() throws SQLException {
        String sql = "select*from view_listarCargo";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    /*Metodo para listar los usuarios*/
    public ResultSet listarTipoPersonal() throws SQLException {
        String sql = "select*from view_tipo_personal";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;

    }

    /* MANTENIMIENTO A LA TABLA FACULTAD */
    // 1. Método para listar todas las facultades activas usando la vista
    public ResultSet listarAreas() throws SQLException {
        String sql = "SELECT * FROM view_area";
        /* Llamamos a la vista estandarizada */
        st = conn.createStatement();
        /* Creamos el statement */
        rs = st.executeQuery(sql);
        /* Ejecutamos la consulta */
        return rs;
        /* Devolvemos los resultados */
    }

    // 2. Método para buscar facultades por coincidencia de nombre
    public ResultSet buscarArea(String nombre) throws SQLException {
        String sql = "{CALL sp_area_buscar(?)}";
        /* Llamada al procedimiento almacenado */
        CallableStatement cs = conn.prepareCall(sql);
        /* Usamos CallableStatement para SPs */
        cs.setString(1, nombre);
        /* Asignamos el parámetro de búsqueda */
        rs = cs.executeQuery();
        /* Ejecutamos y obtenemos resultados */
        return rs;
    }

    // 3. Método para insertar una nueva area
    public void insertarArea(String nombre_area, String observaciones) throws SQLException {
        String sql = "{CALL sp_area_insertar(?,?)}";
        // Usamos CallableStatement para procedimientos almacenados
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setString(1, nombre_area);
            cs.setString(2, observaciones);
            cs.execute();
            System.out.println("Area insertada correctamente...!");
        }
    }

    // 4. Método para modificar una facultad existente
    public void modificarArea(int codigo, String nuevoNombre, String nuevaobservacion) throws SQLException {
        String sql = "{CALL sp_area_actualizar(?, ?,?)}";
        // Usamos CallableStatement en lugar de PreparedStatement para llamadas a SPs
        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, codigo);
            cs.setString(2, nuevoNombre);
            cs.setString(3, nuevaobservacion);
            cs.executeUpdate();
            System.out.println("Area modificada correctamente...!");
        }
    }

    /* MANTENIMIENTO A LA TABLA CARGO */
// 1. Método para listar los cargos usando la vista
    public ResultSet ListarCargo() throws SQLException {
        String sql = "SELECT * FROM view_cargo";
        /* Llamamos a la vista estandarizada */
        st = conn.createStatement();
        /* Creamos el statement */
        rs = st.executeQuery(sql);
        /* Ejecutamos la consulta */
        return rs;
        /* Devolvemos los resultados */
    }

// 2. Método para buscar cargos por coincidencia de nombre
    public ResultSet buscarCargo(String nombre) throws SQLException {
        String sql = "SELECT * FROM view_cargo WHERE nombre_cargo LIKE ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + nombre + "%");
        rs = ps.executeQuery();
        return rs;
    }

    public void insertarCargo(String nombre) throws SQLException {
        try (CallableStatement cs = conn.prepareCall("{CALL sp_cargo_insertar(?)}")) {
            cs.setString(1, nombre);
            cs.execute();
        }
    }

    public void modificarCargo(int id, String nombre) throws SQLException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cargo es obligatorio.");
        }
        String sql = "UPDATE cargo SET nombre_cargo = ? WHERE id_cargo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, nombre.trim());
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void darBajaCargo(int codigo) throws SQLException {
        try (CallableStatement cs = conn.prepareCall("{CALL sp_cargo_baja(?)}")) {
            cs.setInt(1, codigo);
            cs.execute();
        }
    }

    public void reactivarCargo(int codigo) throws SQLException {
        try (CallableStatement cs = conn.prepareCall("{CALL sp_cargo_reactivar(?)}")) {
            cs.setInt(1, codigo);
            cs.execute();
        }
    }

    public ResultSet verCargosActivos() throws SQLException {
        st = conn.createStatement();
        rs = st.executeQuery("SELECT * FROM view_cargo WHERE estado_cargo = 'ACTIVO'");
        return rs;
    }

    public ResultSet verCargosInactivos() throws SQLException {
        st = conn.createStatement();
        rs = st.executeQuery("SELECT * FROM view_cargo WHERE estado_cargo = 'INACTIVO'");
        return rs;

    }

    /* MANTENIMIENTO A LA TABLA TIPO PERSONAL */
    public ResultSet listarTipo_Personal() throws SQLException {
        String sql = "SELECT * FROM view_tipo_personal";
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    public void insertarTipoPersonal(String nombre, String observaciones) throws SQLException {
        try (CallableStatement cs = getConnection().prepareCall("{call sp_tipo_personal_insertar(?, ?)}")) {
            cs.setString(1, nombre);
            cs.setString(2, observaciones);
            cs.execute();
        }
    }

    public void modificarTipoPersonal(int id, String nombre, String observaciones) throws SQLException {
        try (CallableStatement cs = getConnection().prepareCall("{call sp_tipo_personal_actualizar(?, ?, ?)}")) {
            cs.setInt(1, id);
            cs.setString(2, nombre);
            cs.setString(3, observaciones);
            cs.execute();
        }
    }

    public ResultSet buscarTipoPersonal(String nombre) throws SQLException {
        String sql = "SELECT * FROM view_tipo_personal WHERE nombre_tipo_personal LIKE ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + nombre + "%");
        rs = ps.executeQuery();
        return rs;
    }

    /* MANTENIMIENTO A LA TABLA COMPRA */
// LISTAR TODAS LAS COMPRAS
    public ResultSet ListarCompra() throws SQLException {
        String sql = "{CALL sp_listar_compra()}";
        CallableStatement cs = conn.prepareCall(sql);
        return cs.executeQuery();
    }

// BUSCAR COMPRAS POR NUMERO O PROVEEDOR
    public ResultSet buscarCompra(String texto) throws SQLException {
        String sql = "SELECT * FROM view_compra "
                + "WHERE numero_compra LIKE ? "
                + "OR razon_social LIKE ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + texto + "%");
        ps.setString(2, "%" + texto + "%");

        rs = ps.executeQuery();
        return rs;
    }

// INSERTAR COMPRA
    public void insertarCompra(int idProveedor, String numero,
            java.sql.Timestamp fecha, double total) throws SQLException {

        String sql = "INSERT INTO compra "
                + "(id_proveedor, numero_compra, fecha_compra, total_compra) "
                + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProveedor);
            ps.setString(2, numero);
            ps.setTimestamp(3, fecha);
            ps.setDouble(4, total);
            ps.executeUpdate();
        }
    }

// MODIFICAR COMPRA
    public void modificarCompra(int id, int idProveedor, String numero,
            java.sql.Timestamp fecha, double total) throws SQLException {

        String sql = "UPDATE compra SET id_proveedor = ?, "
                + "numero_compra = ?, fecha_compra = ?, "
                + "total_compra = ? WHERE id_compra = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProveedor);
            ps.setString(2, numero);
            ps.setTimestamp(3, fecha);
            ps.setDouble(4, total);
            ps.setInt(5, id);
            ps.executeUpdate();
        }
    }

// DAR DE BAJA UNA COMPRA
    public void darBajaCompra(int codigo) throws SQLException {
        String sql = "UPDATE compra SET estado = 'ANULADA' "
                + "WHERE id_compra = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        }
    }

// REACTIVAR UNA COMPRA
    public void reactivarCompra(int codigo) throws SQLException {
        String sql = "UPDATE compra SET estado = 'REGISTRADA' "
                + "WHERE id_compra = ? AND estado = 'ANULADA'";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        }
    }

// CARGAR PROVEEDORES EN EL COMBOBOX
    public ResultSet listarProveedoresCombo() throws SQLException {
        String sql = "SELECT id_proveedor, razon_social "
                + "FROM proveedor "
                + "WHERE estado = 1 "
                + "ORDER BY razon_social";

        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

// LISTAR COMPRAS ACTIVAS
    public ResultSet verComprasActivas() throws SQLException {
        String sql = "SELECT * FROM view_compra "
                + "WHERE estado <> 'ANULADA'";

        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

// LISTAR COMPRAS ANULADAS
    public ResultSet verComprasInactivas() throws SQLException {
        String sql = "SELECT * FROM view_compra "
                + "WHERE estado = 'ANULADA'";

        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

// OBTENER CODIGO DEL PROVEEDOR
    public int obtenerCodigoProveedor(String nombre) throws SQLException {
        String sql = "SELECT id_proveedor FROM proveedor "
                + "WHERE razon_social = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);

            try (ResultSet r = ps.executeQuery()) {
                if (r.next()) {
                    return r.getInt("id_proveedor");
                }
            }
        }

        return -1;
    }

    /* MANTENIMIENTO A LA TABLA DETALLE_COMPRA */
    public void insertarDetalleCompra(
            int idCompra,
            int idProducto,
            int idLote,
            int cantidad,
            double precioCompra) throws SQLException {

        try (CallableStatement cs = conn.prepareCall(
                "{CALL sp_detalle_compra_insertar(?,?,?,?,?)}")) {

            cs.setInt(1, idCompra);
            cs.setInt(2, idProducto);
            cs.setInt(3, idLote);
            cs.setInt(4, cantidad);
            cs.setDouble(5, precioCompra);

            cs.execute();
        }
    }

// 1. Método para listar los detalles de compra
    public ResultSet ListarDetalle_Compra() throws SQLException {
        String sql = "{CALL sp_listar_detalle_compra()}";
        CallableStatement cs = conn.prepareCall(sql);
        return cs.executeQuery();
    }

// 2. Método para guardar un detalle de compra
    public void GuardarDetalle_Compra(int id_compra, int idProducto, int idLote,
            int cantidad, double precioUnitario) throws SQLException {

        String sql = "{CALL sp_insertar_detalle_compra(?,?,?,?,?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id_compra);
            cs.setInt(2, idProducto);
            cs.setInt(3, idLote);
            cs.setInt(4, cantidad);
            cs.setDouble(5, precioUnitario);
            cs.executeUpdate();
        }
    }

// 3. Método para modificar un detalle de compra
    public void ModificarDetalle_Compra(int idDetalleCompra, int cantidad,
            double precioUnitario) throws SQLException {

        String sql = "{CALL sp_actualizar_detalle_compra(?,?,?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idDetalleCompra);
            cs.setInt(2, cantidad);
            cs.setDouble(3, precioUnitario);
            cs.executeUpdate();
        }
    }

// 4. Método para eliminar un detalle de compra
    public void EliminarDetalle_Compra(int idDetalleCompra) throws SQLException {

        String sql = "{CALL sp_eliminar_detalle_compra(?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idDetalleCompra);
            cs.executeUpdate();
        }
    }

//5. Método para buscar detalle de compra
    public ResultSet buscarDetalleCompra(String texto) throws SQLException {
        String sql = "SELECT dc.id_detalle_compra, c.numero_compra, "
                + "p.nombre_comercial, l.numero_lote, dc.cantidad, "
                + "dc.precio_unitario, dc.subtotal "
                + "FROM detalle_compra dc "
                + "INNER JOIN compra c ON dc.id_compra = c.id_compra "
                + "INNER JOIN producto p ON dc.id_producto = p.id_producto "
                + "INNER JOIN lote l ON dc.id_lote = l.id_lote "
                + "WHERE CAST(dc.id_detalle_compra AS CHAR) LIKE ? "
                + "OR c.numero_compra LIKE ? "
                + "OR p.nombre_comercial LIKE ? "
                + "OR l.numero_lote LIKE ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, "%" + texto + "%");
        ps.setString(2, "%" + texto + "%");
        ps.setString(3, texto + "%");
        ps.setString(4, "%" + texto + "%");

        return ps.executeQuery();
    }

// 6. Listar productos para el ComboBox
    public ResultSet listarProductosCombo() throws SQLException {
        String sql = "SELECT id_producto, nombre_comercial "
                + "FROM producto ORDER BY nombre_comercial";

        st = conn.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }

    /* CARGAR LOTES */
    public ResultSet ListarLotes() throws SQLException {
        String sql = "SELECT id_lote, numero_lote FROM lote ORDER BY id_lote ASC";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }

    /* MANTENIMIENTO A LA TABLA DETALLE_RECETA */
// 1. Método para listar los detalles de receta
    public ResultSet ListarDetalle_Receta() throws SQLException {
        String sql = "{CALL sp_listar_detalle_receta()}";
        CallableStatement cs = conn.prepareCall(sql);
        return cs.executeQuery();
    }

// 2. Método para guardar un detalle de receta
    public void GuardarDetalle_Receta(int idReceta, int idProducto,
            int cantidadPrescrita, String indicaciones) throws SQLException {

        String sql = "{CALL sp_insertar_detalle_receta(?,?,?,?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idReceta);
            cs.setInt(2, idProducto);
            cs.setInt(3, cantidadPrescrita);
            cs.setString(4, indicaciones);
            cs.executeUpdate();
        }
    }

// 3. Método para modificar un detalle de receta
    public void ModificarDetalle_Receta(int idDetalleReceta,
            int cantidadPrescrita, String indicaciones) throws SQLException {

        String sql = "{CALL sp_actualizar_detalle_receta(?,?,?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idDetalleReceta);
            cs.setInt(2, cantidadPrescrita);
            cs.setString(3, indicaciones);
            cs.executeUpdate();
        }
    }

// 4. Método para eliminar un detalle de receta
    public void EliminarDetalle_Receta(int idDetalleReceta) throws SQLException {

        String sql = "{CALL sp_eliminar_detalle_receta(?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idDetalleReceta);
            cs.executeUpdate();
        }
    }

// 5. Método para buscar detalles de receta
    public ResultSet buscarDetalleReceta(String texto) throws SQLException {

        String sql = "SELECT * FROM view_detalle_receta "
                + "WHERE CAST(id_receta AS CHAR) LIKE ? "
                + "OR nombre_comercial LIKE ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, texto + "%");
        ps.setString(2, texto + "%");

        rs = ps.executeQuery();
        return rs;
    }

// 6. Método para listar recetas en el ComboBox
    public ResultSet ListarRecetasCombo() throws SQLException {

        String sql = "SELECT id_receta FROM receta ORDER BY id_receta ASC";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }

// 7. Método para listar productos en el ComboBox
    public ResultSet ListarProductosRecetaCombo() throws SQLException {

        String sql = "SELECT id_producto, nombre_comercial "
                + "FROM producto ORDER BY nombre_comercial ASC";

        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }

    /* MANTENIMIENTO A LA TABLA DETALLE_VENTA */
// Método para listar los detalles de venta usando la vista
    public ResultSet ListarDetalle_Venta() throws SQLException {
        String sql = "{CALL sp_listar_detalle_venta()}";
        CallableStatement cs = conn.prepareCall(sql);
        return cs.executeQuery();
    }

// Método para insertar un detalle de venta
    public void InsertarDetalle_Venta(int idVenta, int idProducto, int idLote,
            int cantidad, double precioUnitario, double descuento) throws SQLException {

        String sql = "{CALL sp_insertar_detalle_venta(?,?,?,?,?,?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idVenta);
            cs.setInt(2, idProducto);
            cs.setInt(3, idLote);
            cs.setInt(4, cantidad);
            cs.setDouble(5, precioUnitario);
            cs.setDouble(6, descuento);
            cs.executeUpdate();
        }
    }

// Método para modificar un detalle de venta
    public void ModificarDetalle_Venta(int idDetalleVenta, int idVenta,
            int idProducto, int idLote, int cantidad,
            double precioUnitario, double descuento) throws SQLException {

        String sql = "{CALL sp_modificar_detalle_venta(?,?,?,?,?,?,?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idDetalleVenta);
            cs.setInt(2, idVenta);
            cs.setInt(3, idProducto);
            cs.setInt(4, idLote);
            cs.setInt(5, cantidad);
            cs.setDouble(6, precioUnitario);
            cs.setDouble(7, descuento);
            cs.executeUpdate();
        }
    }

// Método para eliminar un detalle de venta
    public void EliminarDetalle_Venta(int idDetalleVenta) throws SQLException {
        String sql = "{CALL sp_eliminar_detalle_venta(?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idDetalleVenta);
            cs.executeUpdate();
        }
    }

// Método para buscar detalles de venta
    public ResultSet BuscarDetalle_Venta(String texto) throws SQLException {
        String sql = "SELECT * FROM view_detalle_venta "
                + "WHERE CAST(id_detalle_venta AS CHAR) LIKE ? "
                + "OR CAST(id_venta AS CHAR) LIKE ? "
                + "OR nombre_comercial LIKE ? "
                + "OR numero_lote LIKE ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + texto + "%");
        ps.setString(2, "%" + texto + "%");
        ps.setString(3, "%" + texto + "%");
        ps.setString(4, "%" + texto + "%");

        return ps.executeQuery();
    }

    // Método para listar las ventas del combo
    public ResultSet ListarVentasCombo() throws SQLException {
        String sql = "SELECT id_venta FROM venta ORDER BY id_venta ASC";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }

// Método para listar los productos del combo
    public ResultSet ListarProductosCombo() throws SQLException {
        String sql = "SELECT id_producto, nombre_comercial "
                + "FROM producto ORDER BY nombre_comercial ASC";

        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.executeQuery();
    }

    public void cerrarConexion() {
        try {

            if (rs != null) {
                rs.close();
            }

            if (st != null) {
                st.close();
            }

            if (conn != null) {
                conn.close();
            }

            System.out.println("Conexión cerrada correctamente.");

        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión.");
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
