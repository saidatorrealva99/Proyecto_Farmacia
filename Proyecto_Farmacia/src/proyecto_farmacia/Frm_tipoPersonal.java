package proyecto_farmacia;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Frm_tipoPersonal extends javax.swing.JFrame {
// Modelo para mostrar datos en la tabla
    DefaultTableModel modeloTablaTipoPersonal = new DefaultTableModel();

    // Objeto de conexión a la base de datos
    ConexionC_BD ConexionC_BD;

    public Frm_tipoPersonal() {
        initComponents();
        this.setUndecorated(true);
        TXT_BuscarTipo_Personal.setText("Ingrese tipo personal...");
        txtcodigoTipo_Personal.setEnabled(true);
        txtnombreTipo_Personal.setEnabled(true);
        txtObservaciones_Tipo_Personal.setEnabled(true);
        BTN_Guardar.setEnabled(true);
        BTN_Desactivar.setEnabled(true);
        BTN_Modificar.setEnabled(true);

        // Crear la conexión al iniciar el formulario
        ConexionC_BD = new ConexionC_BD();

        // Verificar que la conexión fue exitosa
        if (ConexionC_BD.getConnection() == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar con la base de datos.", "Error de conexión", JOptionPane.ERROR_MESSAGE
            );
        }

        // Definir los encabezados de la tabla
        String titulos[] = {"Código Tipo Personal", "Nombre Tipo Personal", "Observaciones Tipo Personal"};

        // Asignar los títulos al modelo de la tabla
        modeloTablaTipoPersonal.setColumnIdentifiers(titulos);

        // Establecer el modelo a la JTable
        JTABLE_Mant_Tipo_Personal.setModel(modeloTablaTipoPersonal);

        // Deshabilitar campo de código
        txtcodigoTipo_Personal.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigoTipo_Personal = new javax.swing.JTextField();
        txtObservaciones_Tipo_Personal = new javax.swing.JTextField();
        BTN_VerTipo_Personal = new javax.swing.JButton();
        txtnombreTipo_Personal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Tipo_Personal = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_Desactivar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarTipo_Personal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("                 TIPO DE PERSONAL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo Tipo de Personal");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Observacion");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        txtcodigoTipo_Personal.setEditable(false);
        txtcodigoTipo_Personal.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigoTipo_Personal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigoTipo_Personal.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigoTipo_Personal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigoTipo_Personal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigoTipo_Personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 330, 30));

        txtObservaciones_Tipo_Personal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtObservaciones_Tipo_Personal.setForeground(new java.awt.Color(0, 0, 204));
        txtObservaciones_Tipo_Personal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtObservaciones_Tipo_Personal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtObservaciones_Tipo_Personal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObservaciones_Tipo_PersonalKeyTyped(evt);
            }
        });
        jPanel1.add(txtObservaciones_Tipo_Personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 330, 30));

        BTN_VerTipo_Personal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerTipo_Personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoja.jpeg"))); // NOI18N
        BTN_VerTipo_Personal.setText("VER TIPO DE PERSONAL");
        BTN_VerTipo_Personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerTipo_PersonalActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VerTipo_Personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 240, 50));

        txtnombreTipo_Personal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtnombreTipo_Personal.setForeground(new java.awt.Color(0, 0, 204));
        txtnombreTipo_Personal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombreTipo_Personal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtnombreTipo_Personal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreTipo_PersonalKeyTyped(evt);
            }
        });
        jPanel1.add(txtnombreTipo_Personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 330, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nombre Tipo de Personal");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 790, 140));

        JTABLE_Mant_Tipo_Personal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Tipo_Personal.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Tipo_Personal.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_Tipo_Personal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_Tipo_PersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Tipo_Personal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 810, 220));

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
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 190, 50));

        BTN_Modificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_Modificar.setText("MODIFICAR");
        BTN_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 200, 50));

        BTN_Desactivar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Desactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/suprimir.jpeg"))); // NOI18N
        BTN_Desactivar.setText("DAR DE BAJA");
        BTN_Desactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_DesactivarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Desactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 180, 50));

        BTN_EXCEL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.jpeg"))); // NOI18N
        BTN_EXCEL.setText("Exportar");
        BTN_EXCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCELActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_EXCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, 120, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Nombre tipo de personal");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 30));

        TXT_BuscarTipo_Personal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarTipo_PersonalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarTipo_PersonalKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarTipo_Personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.jpeg"))); // NOI18N
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 810, 50));

        BTN_Cerrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_Cerrar.setText("Cerrar");
        BTN_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CerrarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 520, 130, 40));

        BTN_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.jpeg"))); // NOI18N
        BTN_PDF.setText("Exportar");
        BTN_PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDFActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, 120, 40));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtObservaciones_Tipo_PersonalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservaciones_Tipo_PersonalKeyTyped

    }//GEN-LAST:event_txtObservaciones_Tipo_PersonalKeyTyped

    private void BTN_VerTipo_PersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerTipo_PersonalActionPerformed
        this.MostrarTipoPersonal();
    }//GEN-LAST:event_BTN_VerTipo_PersonalActionPerformed

    private void JTABLE_Mant_Tipo_PersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_Tipo_PersonalMouseClicked
        /*Obtener la fila seleccionada*/

        int filaseleccionada = JTABLE_Mant_Tipo_Personal.getSelectedRow();

        if (filaseleccionada >= 0) {

            /*llenar los campos de texto con los datos de la fila*/
            String codigo = JTABLE_Mant_Tipo_Personal.getValueAt(filaseleccionada, 0).toString();

            String nombre = JTABLE_Mant_Tipo_Personal.getValueAt(filaseleccionada, 1).toString();

            String observacion = JTABLE_Mant_Tipo_Personal.getValueAt(filaseleccionada, 2).toString();

            txtcodigoTipo_Personal.setText(codigo);
            txtnombreTipo_Personal.setText(nombre);
            txtObservaciones_Tipo_Personal.setText(observacion);

            /*Habilitar los botones relacionados*/
            BTN_Modificar.setEnabled(true);

            BTN_Desactivar.setEnabled(true);

            /*Opcional: deshabilitar boton guardar */
            BTN_Guardar.setEnabled(true);

        }
    }//GEN-LAST:event_JTABLE_Mant_Tipo_PersonalMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
// Limpia los campos de texto
        txtcodigoTipo_Personal.setText("");
        txtnombreTipo_Personal.setText("");
        txtObservaciones_Tipo_Personal.setText("");

        /*Enviar el cursor a la caja de texto*/
        txtnombreTipo_Personal.requestFocus();
        txtnombreTipo_Personal.setEnabled(true);

        /*Habilita el boton guardar*/
        BTN_Guardar.setEnabled(true);
        BTN_Desactivar.setEnabled(false);
        BTN_Modificar.setEnabled(false);
    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GuardarMouseClicked

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed
// 1. Validar que el campo no esté vacío

        String nombre = txtnombreTipo_Personal.getText().trim();

        if (nombre.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Ingrese el nombre de la tipo personal", "Campo requerido", JOptionPane.WARNING_MESSAGE);

            txtnombreTipo_Personal.requestFocus();

            return;

        }

        // 2. Confirmar si el usuario desea guardar
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea guardar el registro de area?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            try {

                // 3. Llamar al método para insertar
                ConexionC_BD.insertarTipoPersonal(nombre, nombre);

                // 4. Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Tipo Personal registrada correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

                //5. Actualizar tabla y limpiar campos
                this.MostrarTipoPersonal();

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this, "Error al registrar Tipo Personal:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);

            }

        }
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
// Validar que se haya seleccionado un registro

        String codStr = txtcodigoTipo_Personal.getText().trim();

        String nuevoNombre = txtnombreTipo_Personal.getText().trim();

        String nuevaobservacion = txtObservaciones_Tipo_Personal.getText().trim();

        if (codStr.isEmpty() || nuevoNombre.isEmpty() || nuevaobservacion.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Seleccione un tipo de personal y complete el nuevo nombre", "Campo requerido", JOptionPane.WARNING_MESSAGE);

            return;

        }

        int codigo = Integer.parseInt(codStr);

        // Confirmación del usuario
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea modificar este tipo de personal?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            try {

                ConexionC_BD.modificarArea(codigo, nuevoNombre, nuevaobservacion);

                JOptionPane.showMessageDialog(this, "Area modificada correctamente", "Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);

                this.MostrarTipoPersonal();

                // Limpia los campos de texto
                txtcodigoTipo_Personal.setText("");

                txtnombreTipo_Personal.setText("");

                txtObservaciones_Tipo_Personal.setText("");

                BTN_Desactivar.setEnabled(true);

                BTN_Modificar.setEnabled(true);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this, "Error al modificar tipo de personal:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);

            }

        }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_DesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_DesactivarActionPerformed

    }//GEN-LAST:event_BTN_DesactivarActionPerformed

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarTipo_PersonalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarTipo_PersonalKeyReleased
        this.buscarTipoPersonal();
    }//GEN-LAST:event_TXT_BuscarTipo_PersonalKeyReleased

    private void TXT_BuscarTipo_PersonalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarTipo_PersonalKeyTyped

    }//GEN-LAST:event_TXT_BuscarTipo_PersonalKeyTyped

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

    private void txtnombreTipo_PersonalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreTipo_PersonalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreTipo_PersonalKeyTyped

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
            java.util.logging.Logger.getLogger(Frm_tipoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_tipoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_tipoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_tipoPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_tipoPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar;
    private javax.swing.JButton BTN_Desactivar;
    private javax.swing.JButton BTN_EXCEL;
    private javax.swing.JButton BTN_Guardar;
    private javax.swing.JButton BTN_Modificar;
    private javax.swing.JButton BTN_Nuevo;
    private javax.swing.JButton BTN_PDF;
    private javax.swing.JButton BTN_VerTipo_Personal;
    private javax.swing.JTable JTABLE_Mant_Tipo_Personal;
    private javax.swing.JTextField TXT_BuscarTipo_Personal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtObservaciones_Tipo_Personal;
    private javax.swing.JTextField txtcodigoTipo_Personal;
    private javax.swing.JTextField txtnombreTipo_Personal;
    // End of variables declaration//GEN-END:variables
/**
     * Muestra todos los tipos de personal en la tabla
     */
    public void MostrarTipoPersonal() {
        txtnombreTipo_Personal.setEnabled(true);
        // Ordenar Asc, Desc
        JTABLE_Mant_Tipo_Personal.setAutoCreateRowSorter(true);

        // Limpia la tabla antes de mostrar nuevos datos
        modeloTablaTipoPersonal.setRowCount(0);

        try {
            // Llama al método que devuelve los datos de tipo personal
            ResultSet rs = ConexionC_BD.listarTipo_Personal();

            // Recorre cada fila del resultado y agrega a la tabla
            while (rs.next()) {
                Object[] fila = {
                    rs.getString("id_tipo_personal"),
                    rs.getString("nombre_tipo_personal"),
                    rs.getString("observaciones")
                };
                modeloTablaTipoPersonal.addRow(fila);
            }

        } catch (SQLException e) {

            // Muestra mensaje si ocurre un error en la consulta
            JOptionPane.showMessageDialog(this, "Error al mostrar tipos de personal:\n" + e.getMessage(), "Error en la consulta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarTipoPersonal() {
        // Limpia la tabla antes de mostrar los resultados filtrados
        modeloTablaTipoPersonal.setRowCount(0);
        // obtiene el texto ingresado por el usuario
        String busqueda = TXT_BuscarTipo_Personal.getText().trim();
        try {
            // Consulta los datos usando el procedimiento almacenado en la BD
            ResultSet rs = ConexionC_BD.buscarTipoPersonal(busqueda);

            // Recorre los resultados y los anade a la tablal
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_tipo_personal"),
                    rs.getString("nombre_tipo_personal"),
                    rs.getString("observaciones")
                };
                modeloTablaTipoPersonal.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar Tipo de Personal: \n" + e.getMessage(),
                    "Error de busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

}
