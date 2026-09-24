package proyecto_farmacia;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Frm_Cargo extends javax.swing.JFrame {
// Modelo para mostrar datos en la tabla

    DefaultTableModel modeloTablaCargo = new DefaultTableModel();

    ConexionC_BD ConexionC_BD;

    public Frm_Cargo() {
        initComponents();
        this.setUndecorated(true);
        TXT_BuscarCargos.setText("Ingrese nombre cargo...");
        txtcodigocargo.setEnabled(false);
        BTN_Guardar.setEnabled(false);
        BTN_Modificar.setEnabled(false);
        CHEK_ReactivarCargo.setEnabled(false);

        ConexionC_BD = new ConexionC_BD();

        // Verificar que la conexión fue exitosa
        if (ConexionC_BD.getConnection() == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar con la base de datos.", "Error de conexión", JOptionPane.ERROR_MESSAGE
            );
        }

        // Definir los encabezados de la tabla
        String titulos[] = {"Código cargo", "Nombre cargo", "Estado"};

        // Asignar los títulos al modelo de la tabla
        modeloTablaCargo.setColumnIdentifiers(titulos);

        // Establecer el modelo a la JTable
        JTABLE_Mant_Cargo.setModel(modeloTablaCargo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtcodigocargo = new javax.swing.JTextField();
        BTN_VerCargo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtnombrecargo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        CHEK_ListarCargo_de_Baja = new javax.swing.JCheckBox();
        CHEK_ReactivarCargo = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Cargo = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarCargos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar = new javax.swing.JButton();
        BTN_Dar_de_baja = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("      REGISTRO DE CARGO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo cargo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        txtcodigocargo.setEditable(false);
        txtcodigocargo.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigocargo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigocargo.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigocargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigocargo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigocargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 330, 30));

        BTN_VerCargo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoja.jpeg"))); // NOI18N
        BTN_VerCargo.setText("VER CARGO");
        BTN_VerCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerCargoActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VerCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 180, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nombre cargo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        txtnombrecargo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtnombrecargo.setForeground(new java.awt.Color(0, 0, 204));
        txtnombrecargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombrecargo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtnombrecargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombrecargoKeyTyped(evt);
            }
        });
        jPanel1.add(txtnombrecargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 330, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CHEK_ListarCargo_de_Baja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CHEK_ListarCargo_de_Baja.setText("Listar cargo de baja");
        CHEK_ListarCargo_de_Baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHEK_ListarCargo_de_BajaActionPerformed(evt);
            }
        });
        jPanel3.add(CHEK_ListarCargo_de_Baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 160, -1));

        CHEK_ReactivarCargo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CHEK_ReactivarCargo.setText("Reactivar Estado");
        CHEK_ReactivarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHEK_ReactivarCargoActionPerformed(evt);
            }
        });
        jPanel3.add(CHEK_ReactivarCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 180, 120));
        jPanel3.getAccessibleContext().setAccessibleName("Estado"); // NOI18N

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 930, 140));

        JTABLE_Mant_Cargo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Cargo.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Cargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        JTABLE_Mant_Cargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_CargoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Cargo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 950, 220));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 190, 50));

        BTN_Guardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar (2).png"))); // NOI18N
        BTN_Guardar.setText("GUARDAR");
        BTN_Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GuardarMouseClicked(evt);
            }
        });
        BTN_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 190, 50));

        BTN_Modificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_Modificar.setText("MODIFICAR");
        BTN_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 200, 50));

        BTN_EXCEL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.jpeg"))); // NOI18N
        BTN_EXCEL.setText("Exportar");
        BTN_EXCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCELActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_EXCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, 120, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Nombre de Cargo");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        TXT_BuscarCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarCargosActionPerformed(evt);
            }
        });
        TXT_BuscarCargos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarCargosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarCargosKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarCargos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 950, 50));

        BTN_Cerrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_Cerrar.setText("Cerrar");
        BTN_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CerrarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 530, 130, 40));

        BTN_Dar_de_baja.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Dar_de_baja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/suprimir.jpeg"))); // NOI18N
        BTN_Dar_de_baja.setText("DAR DE BAJA");
        BTN_Dar_de_baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Dar_de_bajaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Dar_de_baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 180, 50));

        BTN_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.jpeg"))); // NOI18N
        BTN_PDF.setText("Exportar");
        BTN_PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDFActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 530, 120, 40));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_VerCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerCargoActionPerformed
        this.MostrarCargo();
    }//GEN-LAST:event_BTN_VerCargoActionPerformed

    private void JTABLE_Mant_CargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_CargoMouseClicked
        int fila = JTABLE_Mant_Cargo.getSelectedRow();
        if (fila == -1) {
            return;
        }

        String codigo = JTABLE_Mant_Cargo.getValueAt(fila, 0).toString();
        String nombre = JTABLE_Mant_Cargo.getValueAt(fila, 1).toString();
        String estado = JTABLE_Mant_Cargo.getValueAt(fila, 2).toString();

        txtcodigocargo.setText(codigo);
        txtnombrecargo.setText(nombre);        // pon el nombre de tu campo

// solo se puede reactivar si está INACTIVO
        CHEK_ReactivarCargo.setEnabled(estado.equals("INACTIVO"));
        CHEK_ReactivarCargo.setSelected(false);

        BTN_Modificar.setEnabled(estado.trim().equalsIgnoreCase("ACTIVO"));
        BTN_Dar_de_baja.setEnabled(estado.trim().equalsIgnoreCase("ACTIVO"));
    }//GEN-LAST:event_JTABLE_Mant_CargoMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
        this.limpiarCamposCargo();
        BTN_Guardar.setEnabled(true);
        BTN_Modificar.setEnabled(false);
        BTN_Dar_de_baja.setEnabled(false);
    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GuardarMouseClicked

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed
        try {
            // 1. Obtener datos del formulario
            String nombre = txtnombrecargo.getText().trim();

            // 2. Validar campo requerido
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese el nombre del cargo.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                txtnombrecargo.requestFocus();
                return;
            }

            // 3. Insertar usando el método de la clase de conexión
            // (el estado lo pone solo la base de datos como ACTIVO)
            ConexionC_BD.insertarCargo(nombre);

            // 4. Confirmar éxito
            JOptionPane.showMessageDialog(this, "Cargo registrado correctamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // 5. Refrescar la tabla con los activos
            this.MostrarCargo();

            // 6. Limpiar campos y apagar Guardar
            this.limpiarCamposCargo();
            BTN_Guardar.setEnabled(false);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el cargo: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
        try {
            //1. Obtener datos del formulario
            String codigoStr = txtcodigocargo.getText().trim();
            String nombre = txtnombrecargo.getText().trim();

            //2. Validar que se haya seleccionado un cargo y que el nombre no esté vacío
            if (codigoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione un cargo de la tabla para modificar.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese el nombre del cargo.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                txtnombrecargo.requestFocus();
                return;
            }

            //3. Convertir código a entero
            int codigoCargo = Integer.parseInt(codigoStr);

            //4. Llamar al método de modificación en la clase de conexión
            ConexionC_BD.modificarCargo(codigoCargo, nombre);

            JOptionPane.showMessageDialog(this, "Cargo actualizado correctamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            //5. Refrescar la tabla y limpiar campos
            listarCargo_Activos();
            limpiarCamposCargo();

            //6. Restablecer el estado de los botones
            BTN_Guardar.setEnabled(false);
            BTN_Modificar.setEnabled(true);
            BTN_Dar_de_baja.setEnabled(false);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Código de cargo no válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Validación", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al modificar el cargo: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarCargosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarCargosKeyReleased
        this.buscarCargo();
    }//GEN-LAST:event_TXT_BuscarCargosKeyReleased

    private void TXT_BuscarCargosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarCargosKeyTyped

    }//GEN-LAST:event_TXT_BuscarCargosKeyTyped

    private void BTN_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CerrarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar el formulario?", "Confirmar salida",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Cerrar conexión si tienes un método cerrarConexion()
                ConexionC_BD.cerrarConexion();
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());

            }
            // Cierra el formulario actual
            dispose(); // o this.dispose() si estás dentro del formulario
        }
    }//GEN-LAST:event_BTN_CerrarActionPerformed

    private void BTN_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDFActionPerformed

    }//GEN-LAST:event_BTN_PDFActionPerformed

    private void txtnombrecargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombrecargoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombrecargoKeyTyped

    private void TXT_BuscarCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarCargosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarCargosActionPerformed

    private void CHEK_ListarCargo_de_BajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHEK_ListarCargo_de_BajaActionPerformed
        this.listarCargo_dados_baja();
    }//GEN-LAST:event_CHEK_ListarCargo_de_BajaActionPerformed

    private void CHEK_ReactivarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHEK_ReactivarCargoActionPerformed
        if (!CHEK_ReactivarCargo.isSelected()) {
            return;
        }

        if (txtcodigocargo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecciona un cargo de la tabla");
            CHEK_ReactivarCargo.setSelected(false);
            return;
        }

        int codigo = Integer.parseInt(txtcodigocargo.getText().trim());

        try {
            ConexionC_BD.reactivarCargo(codigo);
            JOptionPane.showMessageDialog(this, "Estado activado correctamente");

            // limpiar los campos
            txtcodigocargo.setText("");
            txtnombrecargo.setText("");

            // volver a la lista de activos
            CHEK_ReactivarCargo.setSelected(false);
            CHEK_ReactivarCargo.setEnabled(false);
            CHEK_ListarCargo_de_Baja.setSelected(false);
            this.MostrarCargo();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al reactivar: " + e.getMessage());
            CHEK_ReactivarCargo.setSelected(false);
        }
    }//GEN-LAST:event_CHEK_ReactivarCargoActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void BTN_Dar_de_bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Dar_de_bajaActionPerformed
        try {
            //1. Obtener el código del cargo desde el campo de texto
            String codigoStr = txtcodigocargo.getText().trim();

            //2. Validar que se haya seleccionado un cargo
            if (codigoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione un cargo de la tabla para dar de baja.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int codigoCargo = Integer.parseInt(codigoStr);

            //3. Confirmar con el usuario antes de proceder
            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de dar de baja este cargo?",
                    "Confirmar acción", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {

                //4. Cambiar el estado del cargo a inactivo
                ConexionC_BD.darBajaCargo(codigoCargo);

                JOptionPane.showMessageDialog(this,
                        "Cargo dado de baja correctamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);

                //5. Actualizar la tabla y limpiar los controles
                listarCargo_Activos();
                limpiarCamposCargo();

                //6. Restablecer los botones
                BTN_Guardar.setEnabled(true);
                BTN_Modificar.setEnabled(false);
                BTN_Dar_de_baja.setEnabled(false);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Código de cargo inválido.",
                    "Error", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al dar de baja: " + e.getMessage(),
                    "Error en base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BTN_Dar_de_bajaActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Cargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Cargo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar;
    private javax.swing.JButton BTN_Dar_de_baja;
    private javax.swing.JButton BTN_EXCEL;
    private javax.swing.JButton BTN_Guardar;
    private javax.swing.JButton BTN_Modificar;
    private javax.swing.JButton BTN_Nuevo;
    private javax.swing.JButton BTN_PDF;
    private javax.swing.JButton BTN_VerCargo;
    private javax.swing.JCheckBox CHEK_ListarCargo_de_Baja;
    private javax.swing.JCheckBox CHEK_ReactivarCargo;
    private javax.swing.JTable JTABLE_Mant_Cargo;
    private javax.swing.JTextField TXT_BuscarCargos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtcodigocargo;
    private javax.swing.JTextField txtnombrecargo;
    // End of variables declaration//GEN-END:variables
public void MostrarCargo() {

        JTABLE_Mant_Cargo.setAutoCreateRowSorter(true);
        modeloTablaCargo.setRowCount(0);

        try {
            ResultSet rs = ConexionC_BD.ListarCargo();

            while (rs.next()) {
                Object[] fila = {
                    rs.getString("id_cargo"),
                    rs.getString("nombre_cargo"),
                    rs.getString("estado_cargo") // ya viene como 'ACTIVO' / 'INACTIVO'
                };
                modeloTablaCargo.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al mostrar cargo: " + e.getMessage());
        }
    }

    public void buscarCargo() {
        // Limpia la tabla antes de mostrar los resultados filtrados
        modeloTablaCargo.setRowCount(0);

        String busqueda = TXT_BuscarCargos.getText().trim();

        try (ResultSet rs = ConexionC_BD.buscarCargo(busqueda)) {
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_cargo"),
                    rs.getString("nombre_cargo"),
                    rs.getString("estado_cargo") // texto: 'ACTIVO' / 'INACTIVO'
                };
                modeloTablaCargo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar cargo:\n" + e.getMessage(),
                    "Error de búsqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* Método para listar los cargos activos */
    private void listarCargo_Activos() {

        JTABLE_Mant_Cargo.setAutoCreateRowSorter(true);

        // Limpiar la tabla antes de cargar nuevos datos
        modeloTablaCargo.setRowCount(0);

        try (ResultSet rs = ConexionC_BD.verCargosActivos()) {
            while (rs != null && rs.next()) {
                Object fila[] = {
                    rs.getInt("id_cargo"),
                    rs.getString("nombre_cargo"),
                    rs.getString("estado_cargo")
                };
                modeloTablaCargo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al listar cargos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* Método para listar los cargos dados de baja */
    public void listarCargo_dados_baja() {

        JTABLE_Mant_Cargo.setAutoCreateRowSorter(true);

        // Limpiar la tabla antes de cargar nuevos datos
        modeloTablaCargo.setRowCount(0);

        try (ResultSet rs = ConexionC_BD.verCargosInactivos()) {
            while (rs != null && rs.next()) {
                Object fila[] = {
                    rs.getInt("id_cargo"),
                    rs.getString("nombre_cargo"),
                    rs.getString("estado_cargo")
                };
                modeloTablaCargo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al listar cargos dados de baja: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* Limpiar los campos del formulario */
    public void limpiarCamposCargo() {
        txtcodigocargo.setText("");
        txtnombrecargo.setText("");
        txtnombrecargo.requestFocus();
    }
}
