
package proyecto_farmacia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.DefaultTableModel; // Para trabajar con JTable
import javax.swing.JOptionPane;

public class Frm_Proveedor extends javax.swing.JFrame {
    /*Modelo para mostrar datos en la tabla*/
    DefaultTableModel modeloTablaProveedor = new DefaultTableModel();

    //Objeto para mostrar datos en la tabla
    //Objetivo de conexion a la base de datos (versión instanciada)*/
    ConexionS_BD conexionS_BD;
    
    public Frm_Proveedor() {
        initComponents();//Inicializa lso componentes visuales
        this.setLocationRelativeTo(this);
        txtcodigoProveedor.setEnabled(true);
        BTN_GuardarProveedor.setEnabled(true);
        BTN_DesactivarProveedor.setEnabled(true);
        BTN_ModificarProveedor.setEnabled(true);
        JCHEK_Reactivar_Proveedor.setEnabled(false);
        
        // Crear la conexion al iniciar el formulario
        conexionS_BD = new ConexionS_BD();
        
        if (conexionS_BD.getConexion() == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar con la base de datos.",
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
            return; // Evita continuar si no hay conexion
        }
        
        // 1. Definimos la cadena exacta del placeholder para evitar confusiones
        String placeholderText = "Buscar Código , Razón social o Ruc...";

        // 2. Configuración inicial del Placeholder
        TXT_BuscarProveedor.setText(placeholderText);
        TXT_BuscarProveedor.setForeground(new java.awt.Color(153, 153, 153)); // Color gris tenue

        TXT_BuscarProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                // Si el texto actual es exactamente el placeholder, se limpia y se pone color negro
                if (TXT_BuscarProveedor.getText().equals(placeholderText)) {
                    TXT_BuscarProveedor.setText("");
                    TXT_BuscarProveedor.setForeground(new java.awt.Color(0, 0, 0)); // Color negro para escribir
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                // Si el usuario sale y la caja queda vacía, vuelve a aparecer el texto guía
                if (TXT_BuscarProveedor.getText().trim().isEmpty()) {
                    TXT_BuscarProveedor.setText(placeholderText);
                    TXT_BuscarProveedor.setForeground(new java.awt.Color(153, 153, 153));
                }
            }
        });
        // Definir los encabezados de la tabla
        String titulos[] = {"ID", "RAZON_SOCIAL", "RUC", "TELEFONO", "DIRECCION", "CORREO", "ESTADO", };
        // Asignar los titulos al modelo
        modeloTablaProveedor.setColumnIdentifiers(titulos);
        // Establecer el modelo a la JTable
        JTABLE_Mant_Proveedor.setModel(modeloTablaProveedor);

        //Deshabilitar campo de codigo (solo lo mostrara, no se escribe)
        txtcodigoProveedor.setEnabled(false);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigoProveedor = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        BTN_VerProveedor = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        CHEK_ListarProveedores_de_Baja = new javax.swing.JCheckBox();
        JCHEK_Reactivar_Proveedor = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Proveedor = new javax.swing.JTable();
        BTN_NuevoProveedor = new javax.swing.JButton();
        BTN_GuardarProveedor = new javax.swing.JButton();
        BTN_ModificarProveedor = new javax.swing.JButton();
        BTN_DesactivarProveedor = new javax.swing.JButton();
        BTN_EXCELProveedor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarProveedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_CerrarProveedor = new javax.swing.JButton();
        BTN_PDFProveedor = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE PROVEEDOR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo Proveedor");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Telefono");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        txtcodigoProveedor.setEditable(false);
        txtcodigoProveedor.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigoProveedor.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigoProveedor.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigoProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigoProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 220, 30));

        txtTelefono.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 204));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 200, 30));

        BTN_VerProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoja.jpeg"))); // NOI18N
        BTN_VerProveedor.setText("VER PROVEEDOR");
        BTN_VerProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VerProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 180, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Direccion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(0, 0, 204));
        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 220, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("RUC");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        txtRuc.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtRuc.setForeground(new java.awt.Color(0, 0, 204));
        txtRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRuc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });
        jPanel1.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 200, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Razon_social");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtRazonSocial.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtRazonSocial.setForeground(new java.awt.Color(0, 0, 204));
        txtRazonSocial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRazonSocial.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyTyped(evt);
            }
        });
        jPanel1.add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 59, 220, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Correo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txtCorreo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(0, 0, 204));
        txtCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 220, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CHEK_ListarProveedores_de_Baja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CHEK_ListarProveedores_de_Baja.setText("Listar proveedores de baja");
        CHEK_ListarProveedores_de_Baja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CHEK_ListarProveedores_de_BajaMouseClicked(evt);
            }
        });
        CHEK_ListarProveedores_de_Baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHEK_ListarProveedores_de_BajaActionPerformed(evt);
            }
        });
        jPanel3.add(CHEK_ListarProveedores_de_Baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 160, -1));

        JCHEK_Reactivar_Proveedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JCHEK_Reactivar_Proveedor.setText("Reactivar proveedor");
        JCHEK_Reactivar_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCHEK_Reactivar_ProveedorMouseClicked(evt);
            }
        });
        JCHEK_Reactivar_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCHEK_Reactivar_ProveedorActionPerformed(evt);
            }
        });
        jPanel3.add(JCHEK_Reactivar_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 180, 120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 910, 200));

        JTABLE_Mant_Proveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Proveedor.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        JTABLE_Mant_Proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_ProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Proveedor);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 920, 220));

        BTN_NuevoProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_NuevoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        BTN_NuevoProveedor.setText("NUEVO");
        BTN_NuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_NuevoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 190, 50));

        BTN_GuardarProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_GuardarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar (2).png"))); // NOI18N
        BTN_GuardarProveedor.setText("GUARDAR");
        BTN_GuardarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GuardarProveedorMouseClicked(evt);
            }
        });
        BTN_GuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GuardarProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_GuardarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 190, 50));

        BTN_ModificarProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_ModificarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_ModificarProveedor.setText("MODIFICAR");
        BTN_ModificarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_ModificarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 200, 50));

        BTN_DesactivarProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_DesactivarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/suprimir.jpeg"))); // NOI18N
        BTN_DesactivarProveedor.setText("DAR DE BAJA");
        BTN_DesactivarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_DesactivarProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_DesactivarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, 180, 50));

        BTN_EXCELProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCELProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.jpeg"))); // NOI18N
        BTN_EXCELProveedor.setText("Exportar");
        BTN_EXCELProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCELProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_EXCELProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, 120, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Nombre de la Proveedor");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        TXT_BuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarProveedorActionPerformed(evt);
            }
        });
        TXT_BuscarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarProveedorKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 450, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.jpeg"))); // NOI18N
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 920, 50));

        BTN_CerrarProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_CerrarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_CerrarProveedor.setText("Cerrar");
        BTN_CerrarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CerrarProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_CerrarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 570, 130, 40));

        BTN_PDFProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.jpeg"))); // NOI18N
        BTN_PDFProveedor.setText("Exportar");
        BTN_PDFProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDFProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_PDFProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 570, 120, 40));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped

    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void BTN_VerProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerProveedorActionPerformed
    //Llamar al metodo que llena la tabla con datos de la facultad
    this.MostrarProveedor();
    this.BTN_GuardarProveedor.setEnabled(false);
    this.BTN_DesactivarProveedor.setEnabled(false);
    this.BTN_ModificarProveedor.setEnabled(false);
    }//GEN-LAST:event_BTN_VerProveedorActionPerformed

    private void JTABLE_Mant_ProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_ProveedorMouseClicked
 /*Obtener la fila seleccionada*/
        int filaseleccionada = JTABLE_Mant_Proveedor.getSelectedRow();
        if (filaseleccionada >= 0) {
            /*llenar los campos de texto con los datos de la fila*/
            String codigo = JTABLE_Mant_Proveedor.getValueAt(filaseleccionada, 0).toString();           
            String razon_social = JTABLE_Mant_Proveedor.getValueAt(filaseleccionada, 1).toString();
            String ruc =JTABLE_Mant_Proveedor.getValueAt(filaseleccionada, 2).toString();
            String telefono =JTABLE_Mant_Proveedor.getValueAt(filaseleccionada, 3).toString();
            String direccion =JTABLE_Mant_Proveedor.getValueAt(filaseleccionada, 4).toString();
            String correo =JTABLE_Mant_Proveedor.getValueAt(filaseleccionada, 5).toString();
           // String estadoProveedor =JTABLE_Mant_Proveedor.getValueAt(filaSeleccionada, 6).toString();
            
            txtcodigoProveedor.setText(codigo);
            txtRazonSocial.setText(razon_social);
            txtRuc.setText(ruc);
            txtTelefono.setText(telefono);
            txtDireccion.setText(direccion);
            txtCorreo.setText(correo);  
            
            
            
            //Habilitar el campo para editar nombre
            txtRazonSocial.setEnabled(true);
            txtRuc.setEnabled(true);
            txtTelefono.setEnabled(true);
            txtDireccion.setEnabled(true);
            txtCorreo.setEnabled(true);
            //el campo que no se debe editar
            txtcodigoProveedor.setEnabled(false);

            /*Habilitar los botones relacionados*/
            BTN_ModificarProveedor.setEnabled(true);
            BTN_DesactivarProveedor.setEnabled(true);
            /*Opcional: deshabilitar boton guardar */
            BTN_GuardarProveedor.setEnabled(false);
           this.CHEK_ListarProveedores_de_Baja.setEnabled(true);
            int filaSeleccionada = JTABLE_Mant_Proveedor.getSelectedRow();

     if (filaSeleccionada != -1) {
        JCHEK_Reactivar_Proveedor.setSelected(false);
        JCHEK_Reactivar_Proveedor.setEnabled(true);
        
    }
    

        }
    }//GEN-LAST:event_JTABLE_Mant_ProveedorMouseClicked

    private void BTN_NuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoProveedorActionPerformed
        /*Limpia ls cajas de texto*/
        txtcodigoProveedor.setText(" ");
        txtRazonSocial.setText(" ");
        txtRuc.setText(" ");
        txtTelefono.setText(" ");
        txtDireccion.setText(" ");
        txtCorreo.setText(" ");    

        /*Enviar el curso a la caja de texto: txtnombreFacultad*/
        txtcodigoProveedor.requestFocus();
        txtRazonSocial.setEnabled(true);
        txtRuc.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtCorreo.setEnabled(true);

        /*HABILITA EL BOTON GUARDAR*/
        BTN_GuardarProveedor.setEnabled(true);
         BTN_DesactivarProveedor.setEnabled(false);
        BTN_ModificarProveedor.setEnabled(false);
        BTN_DesactivarProveedor.setEnabled(false);

    }//GEN-LAST:event_BTN_NuevoProveedorActionPerformed

    private void BTN_GuardarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarProveedorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GuardarProveedorMouseClicked

    private void BTN_GuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarProveedorActionPerformed
// 1. Validar que el campo no esté vacío      
        String razonSocial = txtRazonSocial.getText().trim();
        String ruc = txtRuc.getText().trim();
        String Telefono = txtTelefono.getText().trim();
        String Direccion = txtDireccion.getText().trim();
        String correo = txtCorreo.getText().trim();

        if (razonSocial.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la RazonSocial de Proveedor", "Campo requerido", JOptionPane.WARNING_MESSAGE);
            txtRazonSocial.requestFocus();
            return;
        } // 3. Validar ruc
        if (ruc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ruc de Proveedor", "Campo requerido", JOptionPane.WARNING_MESSAGE
            );
            txtRuc.requestFocus();
            return;
        }// 4. Validar  DNI
        if (Telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el Telefono  del Proveedor", "Campo requerido", JOptionPane.WARNING_MESSAGE
            );
            txtTelefono.requestFocus();
            return;
        }// 5. Validar  dirección 
        if (Direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la dirección  del Proveedor", "Campo requerido", JOptionPane.WARNING_MESSAGE
            );
            txtDireccion.requestFocus();
            return;
        }// 6. Validar  teléfono
        if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la teléfono   del Proveedor", "Campo requerido", JOptionPane.WARNING_MESSAGE
            );
            txtCorreo.requestFocus();
            return;

        }// 2. Confirmar si el usuario desea guardar
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea guardar el registro del Proveedor?", "Confirmación", JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {

            try {
                // 3. Llamar al método para insertar
                conexionS_BD.insertarProveedor(razonSocial, ruc, Telefono, Direccion, correo);
                // 4. Mostrar mensaje de éxito

                JOptionPane.showMessageDialog(this, "Proveedor registrado correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                //5. Actualizar tabla y limpiar campos
                this.MostrarProveedor();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al registrar al Proveedor:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_BTN_GuardarProveedorActionPerformed

    private void BTN_ModificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarProveedorActionPerformed

// Validar que se haya seleccionado un registro
        String codStr = txtcodigoProveedor.getText().trim();
        String NuevoRazonSocial = txtRazonSocial.getText().trim();
        String NuevoRuc = txtRuc.getText().trim();
        String NuevoTelefono = txtTelefono.getText().trim();
        String NuevoDireccion = txtDireccion.getText().trim();
        String NuevoCorreo = txtCorreo.getText().trim();        
        
        // VALIDAR TODOS LOS CAMPOS
        if (codStr.isEmpty() || NuevoRazonSocial.isEmpty() || NuevoRuc.isEmpty() ||
        NuevoTelefono.isEmpty() || NuevoDireccion.isEmpty() ||NuevoCorreo.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Seleccione un proveedor y complete la nueva razon social", "Campo requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }
         // CONVERTIR EL CÓDIGO DEL CLIENTE
        int codigo ;
        try {
            codigo=Integer.parseInt(codStr);
        }catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
            this,
            "El código del proveedor no es válido.",
            "Código incorrecto",
            JOptionPane.WARNING_MESSAGE
        );

        return;
        } 
        
        // Confirmación del usuario
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea modificar Cliente?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                 // MODIFICAR CLIENTE
                conexionS_BD.modificarProveedor(
                codigo,
                NuevoRazonSocial,
                NuevoRuc,
                NuevoTelefono,
                NuevoDireccion,
                NuevoCorreo);
                 // MENSAJE DE ÉXITO
                JOptionPane.showMessageDialog(this, "Proveedor modificada correctamente", "Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);
                //Actualizar la tabla
                this.MostrarProveedor();
                
                // Limpia los campos de texto
                txtcodigoProveedor.setText("");
                txtRazonSocial.setText("");
                txtRuc.setText(" ");
                txtTelefono.setText(" ");
                txtDireccion.setText(" ");
                txtCorreo.setText("");                              
                
                //this.MostrarCliente();//metodo actualizar
                BTN_DesactivarProveedor.setEnabled(false);
                BTN_ModificarProveedor.setEnabled(true);
                BTN_GuardarProveedor.setEnabled(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al modificar proveedor:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_BTN_ModificarProveedorActionPerformed

    private void BTN_DesactivarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_DesactivarProveedorActionPerformed
        // 1. Validar que se haya seleccionado un proveedor
        String codStr = txtcodigoProveedor.getText().trim();
        if (codStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor en la tabla para desactivar.", "Campo requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int codigo = Integer.parseInt(codStr); // Convertir a entero
        // 2. Confirmar la acción con el usuario
        int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea dar de baja este proveedor?", "Confirmar desactivación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                // 3. Llamar al método que ejecuta el procedure de desactivación
                conexionS_BD.desactivarProveedor(codigo);
                // 4. Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Proveedor dado de baja correctamente.", "Operación exitosa", 
                        JOptionPane.INFORMATION_MESSAGE);
                // 5. Actualizar tabla y limpiar campos
               MostrarProveedor();
                // Limpia los campos de texto
                txtcodigoProveedor.setText("");
                txtRazonSocial.setText("");
                txtRuc.setText("");
                txtTelefono.setText("");
                txtDireccion.setText("");
                txtCorreo.setText("");
                
                   /* 6. Deshabilitar botones */
                BTN_DesactivarProveedor.setEnabled(false);
                BTN_ModificarProveedor.setEnabled(false);
            } catch (SQLException ex) {
                // 7. Captura cualquier error lanzado por el procedure (por SIGNAL)
                JOptionPane.showMessageDialog(this, "Error al desactivar cliente:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BTN_DesactivarProveedorActionPerformed

    private void BTN_EXCELProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELProveedorActionPerformed

    }//GEN-LAST:event_BTN_EXCELProveedorActionPerformed

    private void TXT_BuscarProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarProveedorKeyReleased
        this.buscarProveedorGeneral();
    }//GEN-LAST:event_TXT_BuscarProveedorKeyReleased

    private void TXT_BuscarProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarProveedorKeyTyped

    }//GEN-LAST:event_TXT_BuscarProveedorKeyTyped

    private void BTN_CerrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CerrarProveedorActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar el formulario?", "Confirmar salida",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Cerrar conexión si tienes un método cerrarConexion()
                conexionS_BD.cerrarConexion();
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
            // Cierra el formulario actual
            dispose(); // o this.dispose() si estás dentro del formulario
        }
    }//GEN-LAST:event_BTN_CerrarProveedorActionPerformed

    private void BTN_PDFProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDFProveedorActionPerformed

    }//GEN-LAST:event_BTN_PDFProveedorActionPerformed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed

    private void txtRazonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSocialKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void CHEK_ListarProveedores_de_BajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CHEK_ListarProveedores_de_BajaMouseClicked
        /* this.listarDocente_dados_Baja();*/
    }//GEN-LAST:event_CHEK_ListarProveedores_de_BajaMouseClicked

    private void CHEK_ListarProveedores_de_BajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHEK_ListarProveedores_de_BajaActionPerformed
// Limpiar la tabla antes de cargar el personal desactivado
        modeloTablaProveedor.setRowCount(0);

        boolean hayRegistros = false;
        /* Deshabilitar la opción de reactivar al iniciar el listado */
        CHEK_ListarProveedores_de_Baja.setSelected(false);
        JCHEK_Reactivar_Proveedor.setSelected(false);
        JCHEK_Reactivar_Proveedor.setEnabled(false);

        try (ResultSet rs = conexionS_BD.listarProveedoresDeBaja()) {

            while (rs != null && rs.next()) {

                

                    hayRegistros = true;

                    Object[] fila = {
                        rs.getInt("id_proveedor"),
                        rs.getString("razon_social"),
                        rs.getString("ruc"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("correo"),
                        "Inactivo"
                    };

                    modeloTablaProveedor.addRow(fila);
                
            }

            if (!hayRegistros) {
                JOptionPane.showMessageDialog(
                        this,
                        "No se encontraron proveedores dados de baja.",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
// Habilitar la opción para reactivar 
                this.JCHEK_Reactivar_Proveedor.setEnabled(true);
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al listar los proveedores dados de baja:\n "
                    + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

        }

/* Deshabilitar la opción de listar bajas */
        CHEK_ListarProveedores_de_Baja.setEnabled(false);
    }//GEN-LAST:event_CHEK_ListarProveedores_de_BajaActionPerformed

    private void JCHEK_Reactivar_ProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCHEK_Reactivar_ProveedorMouseClicked
     
    }//GEN-LAST:event_JCHEK_Reactivar_ProveedorMouseClicked

    private void JCHEK_Reactivar_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCHEK_Reactivar_ProveedorActionPerformed
// 1. Verificar si hay una fila seleccionada en la tabla
        int filaSeleccionada = JTABLE_Mant_Proveedor.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un proveedor de la tabla para reactivar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Obtener el ID y el estado actual desde la tabla  
        int idProveedor = Integer.parseInt( JTABLE_Mant_Proveedor.getValueAt(filaSeleccionada, 0).toString() ); 
        String estadoProveedor = JTABLE_Mant_Proveedor.getValueAt(filaSeleccionada, 6).toString();

        // 3. Validar que el proveedor esté inactivo
         if (estadoProveedor.equalsIgnoreCase("Activo")) { 
JOptionPane.showMessageDialog( this, "El proveedor seleccionado ya se encuentra activo.",
"Advertencia", JOptionPane.WARNING_MESSAGE ); 
return; }
           
        // 4. Confirmar la reactivación
        int confirmacion = JOptionPane.showConfirmDialog( this, 
                "¿Está seguro de reactivar al proveedor seleccionado?", "Confirmar reactivación", 
                JOptionPane.YES_NO_OPTION ); if (confirmacion == JOptionPane.YES_OPTION) { 
                    try {
               // 5. Llamar al método DAO para reactivar el proveedor
                boolean resultado = conexionS_BD.activarProveedor(idProveedor);

                if (resultado) {
                    JOptionPane.showMessageDialog(this, "Proveedor reactivado exitosamente.",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    // 6. Actualizar la tabla de proveedores dados de baja
                    // Puedes invocar nuevamente la carga de inactivos o tu método de actualización según prefieras:
                    MostrarProveedor();

                } else { JOptionPane.showMessageDialog( this, "No se pudo realizar la operación. Verifique que el proveedor exista.", "Error", 
                        JOptionPane.ERROR_MESSAGE ); }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error de base de datos al reactivar el proveedor: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
           // 7. Restablecer el JCheckBox después de la operación    
       this.JCHEK_Reactivar_Proveedor.setSelected(false);
this.JCHEK_Reactivar_Proveedor.setEnabled(false);

this.CHEK_ListarProveedores_de_Baja.setEnabled(false);

// Dejar el JCheckBox desmarcado y deshabilitado
javax.swing.SwingUtilities.invokeLater(() -> {
    JCHEK_Reactivar_Proveedor.setSelected(false);
    JCHEK_Reactivar_Proveedor.setEnabled(false);
});
    }//GEN-LAST:event_JCHEK_Reactivar_ProveedorActionPerformed

    private void TXT_BuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarProveedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Proveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Proveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CerrarProveedor;
    private javax.swing.JButton BTN_DesactivarProveedor;
    private javax.swing.JButton BTN_EXCELProveedor;
    private javax.swing.JButton BTN_GuardarProveedor;
    private javax.swing.JButton BTN_ModificarProveedor;
    private javax.swing.JButton BTN_NuevoProveedor;
    private javax.swing.JButton BTN_PDFProveedor;
    private javax.swing.JButton BTN_VerProveedor;
    private javax.swing.JCheckBox CHEK_ListarProveedores_de_Baja;
    private javax.swing.JCheckBox JCHEK_Reactivar_Proveedor;
    private javax.swing.JTable JTABLE_Mant_Proveedor;
    private javax.swing.JTextField TXT_BuscarProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtcodigoProveedor;
    // End of variables declaration//GEN-END:variables

public void MostrarProveedor() {
        txtRazonSocial.setEnabled(true);/*desactivar y activar RazonSocial*/
        //Ordenar Asc, Desc
        JTABLE_Mant_Proveedor.setAutoCreateRowSorter(true);
        //Limpia la tabla antes de mostrar nuevos datos
        modeloTablaProveedor.setRowCount(0);
        try {
            //Llama al métdo que devuelve los datos de facultad
            ResultSet rs = conexionS_BD.listarProveedores();
            //Recorre cada fila del resultado y agrega a la tabla
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_proveedor"),
                    rs.getString("razon_social"),
                    rs.getString("ruc"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("correo"),
                    rs.getInt("estado") == 1 ? "Activo" : "Inactivo"
                    };

                modeloTablaProveedor.addRow(fila);
            }
        } catch (SQLException e) {
            //Muestra mensaje si ocurre un error en la consulta
            JOptionPane.showMessageDialog(this, "Error al mostrar Proveedor:\n" + e.getMessage(),
                    "Error de consulta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarProveedorGeneral() {
        // Limpia la tabla antes de mostrar los resultados filtrados
        modeloTablaProveedor.setRowCount(0);
        // obtiene el texto ingresado por el usuario
        String busqueda = TXT_BuscarProveedor.getText().trim();
        try {
            // Consulta los datos usando el procedimiento almacenado en la BD
            ResultSet rs = conexionS_BD.buscarProveedores(busqueda);

            // Recorre los resultados y los anade a la tablal
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_proveedor"),
                    rs.getString("razon_social"),
                    rs.getString("ruc"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("correo"),
                    rs.getInt("estado") == 1 ? "Activo" : "Inactivo"
                };
                modeloTablaProveedor.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar proveedor: \n" + e.getMessage(),
                    "Error de busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }




}
