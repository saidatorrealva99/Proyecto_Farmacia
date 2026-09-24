package proyecto_farmacia;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Frm_Usuario extends javax.swing.JFrame {

    DefaultTableModel modeloTablaUsuario = new DefaultTableModel();
    ConexionS_BD conexionS_BD;

    public Frm_Usuario() {
        initComponents();
        /*Centrar*/
        this.setLocationRelativeTo(this);

        this.BTN_GUARDARUsuario.setEnabled(false);
        this.BTN_ResetearUsuario.setEnabled(false);
        this.jRadioLsitarDesactivados.setEnabled(false);
        this.jRadioActiivar.setEnabled(false);
        this.jRadioDesactivar.setEnabled(false);

        // 1. Definimos la cadena exacta del placeholder para evitar confusiones
        String placeholderText = "Buscar Código o Usuario...";

        // 2. Configuración inicial del Placeholder
        TXT_BUSCAR_Usuario.setText(placeholderText);
        TXT_BUSCAR_Usuario.setForeground(new java.awt.Color(153, 153, 153)); // Color gris tenue

        TXT_BUSCAR_Usuario.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                // Si el texto actual es exactamente el placeholder, se limpia y se pone color negro
                if (TXT_BUSCAR_Usuario.getText().equals(placeholderText)) {
                    TXT_BUSCAR_Usuario.setText("");
                    TXT_BUSCAR_Usuario.setForeground(new java.awt.Color(0, 0, 0)); // Color negro para escribir
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                // Si el usuario sale y la caja queda vacía, vuelve a aparecer el texto guía
                if (TXT_BUSCAR_Usuario.getText().trim().isEmpty()) {
                    TXT_BUSCAR_Usuario.setText(placeholderText);
                    TXT_BUSCAR_Usuario.setForeground(new java.awt.Color(153, 153, 153));
                }
            }
        });
        String titulos[] = {"ID", "Código", "Contraseña", "Cargo", "Personal", "Estado"};

        modeloTablaUsuario.setColumnIdentifiers(titulos);
        JTABLE_Usuario.setModel(modeloTablaUsuario);

        /**/
        conexionS_BD = new ConexionS_BD();

        /**/
        this.llenarJComboBox_Cargos_usuarios();
        this.llenarJComboBox_Personal_usuarios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtId_Usuario = new javax.swing.JTextField();
        jComboCargo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        BTN_ListarUsuario = new javax.swing.JButton();
        jPanelAccionesUsuario = new javax.swing.JPanel();
        jRadioLsitarDesactivados = new javax.swing.JRadioButton();
        jRadioActiivar = new javax.swing.JRadioButton();
        jRadioDesactivar = new javax.swing.JRadioButton();
        TxtCodigoUsuario = new javax.swing.JTextField();
        TextPassword = new javax.swing.JTextField();
        jComboPersonal = new javax.swing.JComboBox<>();
        BTN_NUEVOUsuario = new javax.swing.JButton();
        BTN_GUARDARUsuario = new javax.swing.JButton();
        BTN_ResetearUsuario = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BUSCAR_Usuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Usuario = new javax.swing.JTable();
        BTN_CERRARUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Id_Usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Codigo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Cargo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Password");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, 20));

        txtId_Usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtId_Usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId_Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtId_UsuarioMouseClicked(evt);
            }
        });
        txtId_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId_UsuarioActionPerformed(evt);
            }
        });
        txtId_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtId_UsuarioKeyPressed(evt);
            }
        });
        jPanel1.add(txtId_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 310, -1));

        jComboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCargoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 310, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Personal");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        BTN_ListarUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_ListarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/casa.png"))); // NOI18N
        BTN_ListarUsuario.setText("Listar Usuario");
        BTN_ListarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ListarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_ListarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, 50));

        jPanelAccionesUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAccionesUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanelAccionesUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(jRadioLsitarDesactivados);
        jRadioLsitarDesactivados.setText("Listar_Desactivados");
        jRadioLsitarDesactivados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioLsitarDesactivadosActionPerformed(evt);
            }
        });
        jPanelAccionesUsuario.add(jRadioLsitarDesactivados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        buttonGroup1.add(jRadioActiivar);
        jRadioActiivar.setText("Actiivar");
        jRadioActiivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioActiivarActionPerformed(evt);
            }
        });
        jPanelAccionesUsuario.add(jRadioActiivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        buttonGroup1.add(jRadioDesactivar);
        jRadioDesactivar.setText("Desactivar");
        jRadioDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioDesactivarActionPerformed(evt);
            }
        });
        jPanelAccionesUsuario.add(jRadioDesactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jPanel1.add(jPanelAccionesUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 330, 100));
        jPanel1.add(TxtCodigoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 310, -1));
        jPanel1.add(TextPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 310, -1));

        jComboPersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboPersonalActionPerformed(evt);
            }
        });
        jPanel1.add(jComboPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 310, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 850, 250));

        BTN_NUEVOUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_NUEVOUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        BTN_NUEVOUsuario.setText("NUEVO");
        BTN_NUEVOUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NUEVOUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_NUEVOUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 150, 50));

        BTN_GUARDARUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_GUARDARUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar (2).png"))); // NOI18N
        BTN_GUARDARUsuario.setText("GUARDAR");
        BTN_GUARDARUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GUARDARUsuarioMouseClicked(evt);
            }
        });
        BTN_GUARDARUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GUARDARUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_GUARDARUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 140, 50));

        BTN_ResetearUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_ResetearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_ResetearUsuario.setText("Reset");
        BTN_ResetearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ResetearUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_ResetearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 140, 50));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar Usuario");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 30));

        TXT_BUSCAR_Usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_BUSCAR_Usuario.setToolTipText("");
        TXT_BUSCAR_Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TXT_BUSCAR_UsuarioMouseClicked(evt);
            }
        });
        TXT_BUSCAR_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BUSCAR_UsuarioActionPerformed(evt);
            }
        });
        TXT_BUSCAR_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BUSCAR_UsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BUSCAR_UsuarioKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BUSCAR_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 410, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 830, 50));

        JTABLE_Usuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Usuario.setForeground(new java.awt.Color(0, 0, 153));
        JTABLE_Usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTABLE_Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_UsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Usuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 840, 260));

        BTN_CERRARUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_CERRARUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_CERRARUsuario.setText("Cerrar");
        BTN_CERRARUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CERRARUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_CERRARUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 140, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO USUARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 240, 30));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_NUEVOUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NUEVOUsuarioActionPerformed

    }//GEN-LAST:event_BTN_NUEVOUsuarioActionPerformed

    private void BTN_GUARDARUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GUARDARUsuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GUARDARUsuarioMouseClicked

    private void BTN_GUARDARUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GUARDARUsuarioActionPerformed

    }//GEN-LAST:event_BTN_GUARDARUsuarioActionPerformed

    private void BTN_ResetearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ResetearUsuarioActionPerformed
// 1. Verificar si hay una fila seleccionada en la tabla
int filaSeleccionada = JTABLE_Usuario.getSelectedRow();

if (filaSeleccionada == -1) {
    JOptionPane.showMessageDialog(
            this,
            "Por favor, seleccione un usuario de la tabla para restablecer su contraseña.",
            "Advertencia",
            JOptionPane.WARNING_MESSAGE
    );
    return;
}

// 2. Obtener el ID y código del usuario
int idUsuario = Integer.parseInt(
        JTABLE_Usuario.getValueAt(filaSeleccionada, 0).toString()
);

String codigoUsuario = JTABLE_Usuario.getValueAt(
        filaSeleccionada, 1
).toString();

// 3. Ventana de confirmación
int confirmacion = JOptionPane.showConfirmDialog(
        this,
        "¿Está seguro de restablecer la contraseña del usuario con código ["
        + codigoUsuario + "] al valor por defecto ('123456')?",
        "Confirmar Restablecimiento",
        JOptionPane.YES_NO_OPTION
);

if (confirmacion == JOptionPane.YES_OPTION) {

    try {

        // 4. Ejecutar el método para restablecer la contraseña
        boolean resultado = conexionS_BD.resetearPasswordUsuario(idUsuario);

        if (resultado) {

            JOptionPane.showMessageDialog(
                    this,
                    "¡Contraseña restablecida exitosamente al valor por defecto ('123456')!",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // 5. Actualizar la tabla
            mostrarDatosTablaUsuarios();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "No se pudo realizar la operación. El ID de usuario no existe.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error de base de datos al restablecer la contraseña: "
                + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
    }//GEN-LAST:event_BTN_ResetearUsuarioActionPerformed

    private void TXT_BUSCAR_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_UsuarioActionPerformed

    }//GEN-LAST:event_TXT_BUSCAR_UsuarioActionPerformed

    private void TXT_BUSCAR_UsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_UsuarioKeyReleased
        String texto = TXT_BUSCAR_Usuario.getText().trim();
        String placeholderText = "Buscar Código o Cargo...";

        // 1. Si tiene el texto de guía o está vacío, restauramos/mostramos todos los registros y salimos
        if (texto.equals(placeholderText) || texto.isEmpty()) {
            mostrarDatosTablaUsuarios(); // Vuelve a cargar todos los usuarios en lugar de dejar la tabla en blanco
            return;
        }

        // 2. Limpiar tabla antes de mostrar resultados nuevos del filtro
        modeloTablaUsuario.setRowCount(0);

        // 3. Usamos try-with-resources para ejecutar el procedimiento almacenado de búsqueda a través del DAO
        try (ResultSet rs = conexionS_BD.buscarUsuario(texto)) {

            // 4. Llenar la tabla con los resultados obtenidos del filtro
            while (rs != null && rs.next()) {
                Object fila[] = {
                    rs.getInt("id_usuario"),
                    rs.getString("codigo"),
                    rs.getString("password"),
                    rs.getString("nombre_cargo"),
                    rs.getString("nombre_personal"),
                    rs.getString("estado_usuario")
                };
                modeloTablaUsuario.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar usuarios: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_TXT_BUSCAR_UsuarioKeyReleased

    private void TXT_BUSCAR_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_UsuarioKeyTyped



    }//GEN-LAST:event_TXT_BUSCAR_UsuarioKeyTyped

    private void JTABLE_UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_UsuarioMouseClicked
        int filaSeleccionada = JTABLE_Usuario.getSelectedRow();

    if (filaSeleccionada == -1) {
        return;
    }

    // ID
    txtId_Usuario.setText(
            JTABLE_Usuario.getValueAt(filaSeleccionada, 0).toString()
    );

    // Código
    TxtCodigoUsuario.setText(
            JTABLE_Usuario.getValueAt(filaSeleccionada, 1).toString()
    );

    // Contraseña
    TextPassword.setText(
            JTABLE_Usuario.getValueAt(filaSeleccionada, 2).toString()
    );

    // Cargo
    jComboCargo.setSelectedItem(
            JTABLE_Usuario.getValueAt(filaSeleccionada, 3).toString()
    );

    // Personal
    jComboPersonal.setSelectedItem(
            JTABLE_Usuario.getValueAt(filaSeleccionada, 4).toString()
    );

    /* Estado
    TxtEstadoUsuario1.setText(
            JTABLE_Usuario.getValueAt(filaSeleccionada, 5).toString()
    );*/
    
    
        
        this.BTN_ResetearUsuario.setEnabled(true);
        this.jRadioActiivar.setEnabled(true);
        this.jRadioDesactivar.setEnabled(true);
        this.jRadioLsitarDesactivados.setEnabled(true);
    }//GEN-LAST:event_JTABLE_UsuarioMouseClicked

    private void BTN_ListarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ListarUsuarioActionPerformed

        this.mostrarDatosTablaUsuarios();
        this.BTN_ListarUsuario.setEnabled(false);
    }//GEN-LAST:event_BTN_ListarUsuarioActionPerformed

    private void BTN_CERRARUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CERRARUsuarioActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar el formulario?",
                "Confirmar salida",
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

    }//GEN-LAST:event_BTN_CERRARUsuarioActionPerformed

    private void jRadioActiivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioActiivarActionPerformed
        // 1. Verificar si hay una fila seleccionada en la tabla
        int filaSeleccionada = JTABLE_Usuario.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario de la tabla para activar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Obtener el ID y el estado actual desde la tabla 
        // (Índice 0: IdUsuario, ÍNDICE 4: EstadoUsuario)
        int idUsuario = Integer.parseInt(JTABLE_Usuario.getValueAt(filaSeleccionada, 0).toString());
        String estadoUsuario = JTABLE_Usuario.getValueAt(filaSeleccionada, 4).toString();

        // 3. Validar que el usuario esté inactivo para poder activarlo (si ya está activo, no procede)
        if (estadoUsuario.equalsIgnoreCase("Activo")) {
            JOptionPane.showMessageDialog(this, "El usuario seleccionado ya se encuentra activo.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // 4. Ventana de confirmación antes de proceder
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de activar al usuario seleccionado?",
                "Confirmar Activación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // 5. Llamar al método DAO que ejecuta el procedimiento almacenado seguro
                boolean resultado = conexionS_BD.reactivarUsuario(idUsuario);

                if (resultado) {
                    JOptionPane.showMessageDialog(this, "Usuario activado exitosamente.",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    // 6. Refrescar la tabla de inactivos (ya que al activarlo, este usuario saldrá de la lista de inactivos)
                    // Puedes invocar nuevamente la carga de inactivos o tu método de actualización según prefieras:
                    mostrarDatosTablaUsuarios();

                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo realizar la operación. El ID de usuario no existe.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error de base de datos al activar el usuario: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.jRadioLsitarDesactivados.setEnabled(false);
    }//GEN-LAST:event_jRadioActiivarActionPerformed

    private void jRadioDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioDesactivarActionPerformed
        // 1. Verificar si hay una fila seleccionada en la tabla
        int filaSeleccionada = JTABLE_Usuario.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario de la tabla para desactivar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Obtener el ID y el estado actual desde la tabla 
        // (Asegúrate de que el índice 0 sea el IdUsuario y el índice 4 sea el EstadoUsuario)
        int idUsuario = Integer.parseInt(JTABLE_Usuario.getValueAt(filaSeleccionada, 0).toString());
        String estadoUsuario = JTABLE_Usuario.getValueAt(filaSeleccionada, 4).toString();

        // 3. Validar que el usuario esté activo para poder desactivarlo
        if (estadoUsuario.equalsIgnoreCase("Inactivo")) {
            JOptionPane.showMessageDialog(this, "El usuario seleccionado ya se encuentra inactivo.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 4. Ventana de confirmación antes de proceder
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de desactivar al usuario seleccionado?",
                "Confirmar Desactivación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // 5. Llamar al método DAO que ejecuta el procedimiento almacenado seguro
                boolean resultado = conexionS_BD.desactivarUsuario(idUsuario);

                if (resultado) {
                    JOptionPane.showMessageDialog(this, "Usuario desactivado exitosamente.",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    // 6. Refrescar la tabla de usuarios activos y limpiar campos
                    mostrarDatosTablaUsuarios();
                    // limpiarCampos(); // Descomenta si tienes un método para limpiar los JTextFields
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo realizar la operación. El ID de usuario no existe.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error de base de datos al desactivar el usuario: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.jRadioDesactivar.setEnabled(false);

    }//GEN-LAST:event_jRadioDesactivarActionPerformed

    private void jRadioLsitarDesactivadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioLsitarDesactivadosActionPerformed
// Limpiar la tabla antes de cargar los usuarios desactivados 
modeloTablaUsuario.setRowCount(0);
boolean hayRegistros = false; 
try (ResultSet rs = conexionS_BD.verUsuarios()) {
    while (rs != null && rs.next()) { 
// Solo mostrar usuarios desactivados 
if (rs.getInt("estado_usuario") == 0) {
    hayRegistros = true;
    Object fila[] = { rs.getInt("id_usuario"), 
        rs.getString("codigo"), 
        rs.getString("password"), 
        rs.getString("nombre_cargo"), 
        rs.getString("nombre_personal"), 
        rs.getString("estado_usuario") }; 
    modeloTablaUsuario.addRow(fila);
} 
    } 
    if (!hayRegistros) { 
        JOptionPane.showMessageDialog( 
                this, "No se encontraron usuarios desactivados registrados.",
                "Información", 
                JOptionPane.INFORMATION_MESSAGE );
    } 
} catch (SQLException e) { 
    JOptionPane.showMessageDialog( 
            this, 
            "Error al listar los usuarios desactivados: "
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE ); 
} // Al listar desactivados, habilitamos la opción para reactivar 
this.jRadioActiivar.setEnabled(true);
    }//GEN-LAST:event_jRadioLsitarDesactivadosActionPerformed

    private void jComboPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboPersonalActionPerformed

    }//GEN-LAST:event_jComboPersonalActionPerformed

    private void jComboCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboCargoActionPerformed

    private void TXT_BUSCAR_UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_UsuarioMouseClicked
                                        
    String texto = TXT_BUSCAR_Usuario.getText().trim();
    String placeholderText = "Buscar Código o Cargo...";

    // 1. Si está vacío o contiene el texto de guía,
    // mostrar nuevamente todos los usuarios
    if (texto.equals(placeholderText) || texto.isEmpty()) {
        mostrarDatosTablaUsuarios();
        return;
    }

    // 2. Limpiar la tabla antes de mostrar los resultados
    modeloTablaUsuario.setRowCount(0);

    // 3. Ejecutar el procedimiento almacenado de búsqueda
    try (ResultSet rs = conexionS_BD.buscarUsuario(texto)) {

        // 4. Cargar los resultados encontrados
        while (rs != null && rs.next()) {

            Object fila[] = {
                rs.getInt("id_usuario"),
                rs.getString("codigo"),
                rs.getString("password"),
                rs.getString("nombre_cargo"),
                rs.getString("nombre_personal"),
                rs.getString("estado_usuario")
            };

            modeloTablaUsuario.addRow(fila);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Error al buscar usuarios: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    }//GEN-LAST:event_TXT_BUSCAR_UsuarioMouseClicked

    private void txtId_UsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtId_UsuarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId_UsuarioKeyPressed

    private void txtId_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId_UsuarioActionPerformed

    private void txtId_UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtId_UsuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId_UsuarioMouseClicked

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
            java.util.logging.Logger.getLogger(Frm_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CERRARUsuario;
    private javax.swing.JButton BTN_GUARDARUsuario;
    private javax.swing.JButton BTN_ListarUsuario;
    private javax.swing.JButton BTN_NUEVOUsuario;
    private javax.swing.JButton BTN_ResetearUsuario;
    private javax.swing.JTable JTABLE_Usuario;
    private javax.swing.JTextField TXT_BUSCAR_Usuario;
    private javax.swing.JTextField TextPassword;
    private javax.swing.JTextField TxtCodigoUsuario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.JComboBox<String> jComboCargo;
    private javax.swing.JComboBox<String> jComboPersonal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAccionesUsuario;
    private javax.swing.JRadioButton jRadioActiivar;
    private javax.swing.JRadioButton jRadioDesactivar;
    private javax.swing.JRadioButton jRadioLsitarDesactivados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtId_Usuario;
    // End of variables declaration//GEN-END:variables
private void llenarJComboBox_Cargos_usuarios() {
        try {
            jComboCargo.removeAllItems();
            jComboCargo.addItem("<<Seleccionar>>"); // Opción por defecto

            // Usamos try-with-resources para asegurar el cierre del ResultSet si el método lo permite,
            try (ResultSet rs = conexionS_BD.combobox_ListarCargos()) {
                while (rs != null && rs.next()) {
                    String NombreCargo = rs.getString("nombre_cargo");
                    if (NombreCargo != null) {
                        jComboCargo.addItem(NombreCargo.trim());
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar NombreCargo: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarJComboBox_Personal_usuarios() {
        try {
            jComboPersonal.removeAllItems();
            jComboPersonal.addItem("<<Seleccionar>>");

            try (ResultSet rs = conexionS_BD.listarPersonal()) {

                while (rs != null && rs.next()) {
                    String nombrePersonal = rs.getString("nombre_personal");

                    if (nombrePersonal != null) {
                        jComboPersonal.addItem(nombrePersonal.trim());
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al cargar personal: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void mostrarDatosTablaUsuarios() {
        // Limpiar la tabla antes de cargar nuevos registros
        modeloTablaUsuario.setRowCount(0);

        // Obtener los usuarios desde la vista
        try (ResultSet rs = conexionS_BD.verUsuarios()) {

            while (rs != null && rs.next()) {

                Object fila[] = {
                    rs.getInt("id_usuario"),
                    rs.getString("codigo"),
                    rs.getString("password"),
                    rs.getString("nombre_cargo"),
                    rs.getString("nombre_personal"),
                    rs.getString("estado_usuario")
                };

                modeloTablaUsuario.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al listar los usuarios: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }
    
    
}
