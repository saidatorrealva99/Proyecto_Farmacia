package proyecto_farmacia;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Frm_Area extends javax.swing.JFrame {

// Modelo para mostrar datos en la tabla
    DefaultTableModel modeloTablaArea = new DefaultTableModel();

    // Objeto de conexión a la base de datos
    ConexionC_BD ConexionC_BD;

    public Frm_Area() {
        initComponents(); 
        this.setUndecorated(true);
        TXT_BuscarAreas.setText("Ingrese nombre area...");
        txtcodigoarea.setEnabled(true);
        txtnombrearea.setEnabled(true);
        txtobservacionArea.setEnabled(true);
        BTN_Guardar.setEnabled(true);
        BTN_DesactivarArea.setEnabled(true);
        BTN_Modificar.setEnabled(true);

        // Crear la conexión al iniciar el formulario
        ConexionC_BD = new ConexionC_BD();

        // Verificar que la conexión fue exitosa
        if (ConexionC_BD.getConnection() == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar con la base de datos.", "Error de conexión", JOptionPane.ERROR_MESSAGE
            );
        }

        // Definir los encabezados de la tabla
        String titulos[] = {"Código Area", "Nombre Area", "Observaciones Area"};

        // Asignar los títulos al modelo de la tabla
        modeloTablaArea.setColumnIdentifiers(titulos);

        // Establecer el modelo a la JTable
        JTABLE_Mant_Areas.setModel(modeloTablaArea);

        // Deshabilitar campo de código
        txtcodigoarea.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcodigoarea = new javax.swing.JTextField();
        txtobservacionArea = new javax.swing.JTextField();
        BTN_VerArea = new javax.swing.JButton();
        txtnombrearea = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Areas = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_DesactivarArea = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        TXT_BuscarAreas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        BTN_Cerrar = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("      REGISTRO DE AREA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Codigo Area");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Observacion");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        txtcodigoarea.setEditable(false);
        txtcodigoarea.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigoarea.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigoarea.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigoarea.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigoarea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txtcodigoarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 330, 30));

        txtobservacionArea.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtobservacionArea.setForeground(new java.awt.Color(0, 0, 204));
        txtobservacionArea.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtobservacionArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtobservacionArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtobservacionAreaActionPerformed(evt);
            }
        });
        txtobservacionArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtobservacionAreaKeyTyped(evt);
            }
        });
        jPanel3.add(txtobservacionArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 330, 30));

        BTN_VerArea.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoja.jpeg"))); // NOI18N
        BTN_VerArea.setText("VER AREAS");
        BTN_VerArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerAreaActionPerformed(evt);
            }
        });
        jPanel3.add(BTN_VerArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 180, 50));

        txtnombrearea.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtnombrearea.setForeground(new java.awt.Color(0, 0, 204));
        txtnombrearea.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombrearea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtnombrearea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreareaKeyTyped(evt);
            }
        });
        jPanel3.add(txtnombrearea, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 330, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nombre Area");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 790, 130));

        JTABLE_Mant_Areas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Areas.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Areas.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_Areas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_AreasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Areas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 810, 260));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 190, 50));

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
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 190, 50));

        BTN_Modificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_Modificar.setText("MODIFICAR");
        BTN_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 200, 50));

        BTN_DesactivarArea.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_DesactivarArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/suprimir.jpeg"))); // NOI18N
        BTN_DesactivarArea.setText("DAR DE BAJA");
        BTN_DesactivarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_DesactivarAreaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_DesactivarArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 180, 50));

        BTN_EXCEL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.jpeg"))); // NOI18N
        BTN_EXCEL.setText("Exportar");
        BTN_EXCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCELActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_EXCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, 120, 40));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ingresar el Nombre de Area");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        TXT_BuscarAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarAreasActionPerformed(evt);
            }
        });
        TXT_BuscarAreas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarAreasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarAreasKeyTyped(evt);
            }
        });
        jPanel4.add(TXT_BuscarAreas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("BUSCAR");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 810, 50));

        BTN_Cerrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_Cerrar.setText("Cerrar");
        BTN_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CerrarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 540, 130, 40));

        BTN_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.jpeg"))); // NOI18N
        BTN_PDF.setText("Exportar");
        BTN_PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDFActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 120, 40));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDFActionPerformed

    }//GEN-LAST:event_BTN_PDFActionPerformed

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

    private void TXT_BuscarAreasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarAreasKeyTyped

    }//GEN-LAST:event_TXT_BuscarAreasKeyTyped

    private void TXT_BuscarAreasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarAreasKeyReleased
               this.buscarArea();
    }//GEN-LAST:event_TXT_BuscarAreasKeyReleased

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void BTN_DesactivarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_DesactivarAreaActionPerformed

    }//GEN-LAST:event_BTN_DesactivarAreaActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
// Validar que se haya seleccionado un registro

        String codStr = txtcodigoarea.getText().trim();

        String nuevoNombre = txtnombrearea.getText().trim();

        String nuevaobservacion = txtobservacionArea.getText().trim();

        if (codStr.isEmpty() || nuevoNombre.isEmpty() || nuevaobservacion.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Seleccione una area y complete el nuevo nombre", "Campo requerido", JOptionPane.WARNING_MESSAGE);

            return;

        }

        int codigo = Integer.parseInt(codStr);

        // Confirmación del usuario
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea modificar esta area?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            try {

                ConexionC_BD.modificarArea(codigo, nuevoNombre, nuevaobservacion);

                JOptionPane.showMessageDialog(this, "Area modificada correctamente", "Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);

                this.MostrarArea();

                // Limpia los campos de texto
                txtcodigoarea.setText("");

                txtnombrearea.setText("");

                txtobservacionArea.setText("");

                BTN_DesactivarArea.setEnabled(true);

                BTN_Modificar.setEnabled(true);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this, "Error al modificar area:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);

            }

        }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed
// 1. Validar que el campo no esté vacío

        String nombre = txtnombrearea.getText().trim();

        if (nombre.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Ingrese el nombre de la area", "Campo requerido", JOptionPane.WARNING_MESSAGE);

            txtnombrearea.requestFocus();

            return;

        }

        // 2. Confirmar si el usuario desea guardar
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea guardar el registro de area?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            try {

                // 3. Llamar al método para insertar
                ConexionC_BD.insertarArea(nombre, nombre);

                // 4. Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this, "Area registrada correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

                //5. Actualizar tabla y limpiar campos
                this.MostrarArea();

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this, "Error al registrar Area:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);

            }

        }
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GuardarMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
// Limpia los campos de texto
        txtcodigoarea.setText("");
        txtnombrearea.setText("");
        txtobservacionArea.setText("");

        /*Enviar el cursor a la caja de texto*/
        txtnombrearea.requestFocus();
        txtnombrearea.setEnabled(true);

        /*Habilita el boton guardar*/
        BTN_Guardar.setEnabled(true);
        BTN_DesactivarArea.setEnabled(false);
        BTN_Modificar.setEnabled(false);
    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void JTABLE_Mant_AreasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_AreasMouseClicked
        /*Obtener la fila seleccionada*/

        int filaseleccionada = JTABLE_Mant_Areas.getSelectedRow();

        if (filaseleccionada >= 0) {

            /*llenar los campos de texto con los datos de la fila*/
            String codigo = JTABLE_Mant_Areas.getValueAt(filaseleccionada, 0).toString();

            String nombre = JTABLE_Mant_Areas.getValueAt(filaseleccionada, 1).toString();

            String observacion = JTABLE_Mant_Areas.getValueAt(filaseleccionada, 2).toString();

            txtcodigoarea.setText(codigo);
            txtnombrearea.setText(nombre);
            txtobservacionArea.setText(observacion);

            /*Habilitar los botones relacionados*/
            BTN_Modificar.setEnabled(true);

            BTN_DesactivarArea.setEnabled(true);

            /*Opcional: deshabilitar boton guardar */
            BTN_Guardar.setEnabled(true);

        }
    }//GEN-LAST:event_JTABLE_Mant_AreasMouseClicked

    private void txtnombreareaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreareaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreareaKeyTyped

    private void BTN_VerAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerAreaActionPerformed
        this.MostrarArea();
    }//GEN-LAST:event_BTN_VerAreaActionPerformed

    private void txtobservacionAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtobservacionAreaKeyTyped

    }//GEN-LAST:event_txtobservacionAreaKeyTyped

    private void txtobservacionAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtobservacionAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtobservacionAreaActionPerformed

    private void TXT_BuscarAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarAreasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarAreasActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Area.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Area().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar;
    private javax.swing.JButton BTN_DesactivarArea;
    private javax.swing.JButton BTN_EXCEL;
    private javax.swing.JButton BTN_Guardar;
    private javax.swing.JButton BTN_Modificar;
    private javax.swing.JButton BTN_Nuevo;
    private javax.swing.JButton BTN_PDF;
    private javax.swing.JButton BTN_VerArea;
    private javax.swing.JTable JTABLE_Mant_Areas;
    private javax.swing.JTextField TXT_BuscarAreas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtcodigoarea;
    private javax.swing.JTextField txtnombrearea;
    private javax.swing.JTextField txtobservacionArea;
    // End of variables declaration//GEN-END:variables

    /**
     * Muestra todas las facultades en la tabla
     */
    public void MostrarArea() {
        txtnombrearea.setEnabled(true);
        // Ordenar Asc, Desc
        JTABLE_Mant_Areas.setAutoCreateRowSorter(true);

        // Limpia la tabla antes de mostrar nuevos datos
        modeloTablaArea.setRowCount(0);

        try {
            // Llama al método que devuelve los datos de facultades
            ResultSet rs = ConexionC_BD.listarArea();

            // Recorre cada fila del resultado y agrega a la tabla
            while (rs.next()) {
                Object[] fila = {
                    rs.getString("id_area"),
                    rs.getString("Nombre_area"),
                    rs.getString("observaciones")
                /*rs.getString("EstadoFacultad")*/
                };
                modeloTablaArea.addRow(fila);
            }

        } catch (SQLException e) {

            // Muestra mensaje si ocurre un error en la consulta
            JOptionPane.showMessageDialog(this, "Error al mostrar areas:\n" + e.getMessage(), "Error en la consulta", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void buscarArea() {
        // Limpia la tabla antes de mostrar los resultados filtrados
        modeloTablaArea.setRowCount(0);
        // obtiene el texto ingresado por el usuario
        String busqueda = TXT_BuscarAreas.getText().trim();
        try {
            // Consulta los datos usando el procedimiento almacenado en la BD
            ResultSet rs = ConexionC_BD.buscarArea(busqueda);

            // Recorre los resultados y los anade a la tablal
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_area"),
                    rs.getString("nombre_area"),
                    rs.getString("observaciones")
                };
                modeloTablaArea.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar Area: \n" + e.getMessage(),
                    "Error de busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }
    

}
