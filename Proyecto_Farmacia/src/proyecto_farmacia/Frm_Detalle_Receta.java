package proyecto_farmacia;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Frm_Detalle_Receta extends javax.swing.JFrame {

    DefaultTableModel modeloTablaDetalle_Receta;
    ConexionC_BD ConexionC_BD;

    public Frm_Detalle_Receta() {
        initComponents();

        ConexionC_BD = new ConexionC_BD();
        this.setUndecorated(true);

        modeloTablaDetalle_Receta = new DefaultTableModel();
        modeloTablaDetalle_Receta.addColumn("Código");
        modeloTablaDetalle_Receta.addColumn("N° Receta");
        modeloTablaDetalle_Receta.addColumn("ID Producto");
        modeloTablaDetalle_Receta.addColumn("Medicamento");
        modeloTablaDetalle_Receta.addColumn("Cantidad");
        modeloTablaDetalle_Receta.addColumn("Indicaciones");

        JTABLE_Mant_DetalleReceta.setModel(modeloTablaDetalle_Receta);

        txtcodigoreceta.setEditable(false);
        txtcantidad.setEditable(true);
        txtindicaciones.setEditable(true);

        CargarRecetas();
        CargarProductos();

        // La tabla inicia vacía
        modeloTablaDetalle_Receta.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtid_producto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtindicaciones = new javax.swing.JTextField();
        txtcodigomedicamento = new javax.swing.JComboBox<>();
        BTN_VerDetalle_Receta = new javax.swing.JButton();
        txtcodigoreceta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_DetalleReceta = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarDetalleReceta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar = new javax.swing.JButton();
        BTN_Eliminar = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("      REGISTRO DETALLE_RECETA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 240, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        txtcantidad.setEditable(false);
        txtcantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtcantidad.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcantidad.setForeground(new java.awt.Color(0, 0, 204));
        txtcantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 330, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Indicaciones");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("ID Receta");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        txtid_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Producto..." }));
        jPanel2.add(txtid_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 330, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("ID Producto");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Cantidad prescrita");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txtindicaciones.setEditable(false);
        txtindicaciones.setBackground(new java.awt.Color(255, 255, 255));
        txtindicaciones.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtindicaciones.setForeground(new java.awt.Color(0, 0, 204));
        txtindicaciones.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtindicaciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtindicaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtindicacionesActionPerformed(evt);
            }
        });
        jPanel2.add(txtindicaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 330, 30));

        txtcodigomedicamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar receta..." }));
        txtcodigomedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigomedicamentoActionPerformed(evt);
            }
        });
        jPanel2.add(txtcodigomedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 330, 30));

        BTN_VerDetalle_Receta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerDetalle_Receta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoja.jpeg"))); // NOI18N
        BTN_VerDetalle_Receta.setText("VER DETALLE_RECETA");
        BTN_VerDetalle_Receta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerDetalle_RecetaActionPerformed(evt);
            }
        });
        jPanel2.add(BTN_VerDetalle_Receta, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 230, 50));

        txtcodigoreceta.setEditable(false);
        txtcodigoreceta.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigoreceta.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigoreceta.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigoreceta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigoreceta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtcodigoreceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigorecetaActionPerformed(evt);
            }
        });
        jPanel2.add(txtcodigoreceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 330, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 970, 170));

        JTABLE_Mant_DetalleReceta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_DetalleReceta.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_DetalleReceta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        JTABLE_Mant_DetalleReceta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_DetalleRecetaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_DetalleReceta);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 970, 220));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 170, 50));

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
        jPanel1.add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 180, 50));

        BTN_Modificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_Modificar.setText("MODIFICAR");
        BTN_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 200, 50));

        BTN_EXCEL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.jpeg"))); // NOI18N
        BTN_EXCEL.setText("Exportar");
        BTN_EXCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCELActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_EXCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 540, 120, 40));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Nombre de Detalle_Receta");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 30));

        TXT_BuscarDetalleReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarDetalleRecetaActionPerformed(evt);
            }
        });
        TXT_BuscarDetalleReceta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarDetalleRecetaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarDetalleRecetaKeyTyped(evt);
            }
        });
        jPanel4.add(TXT_BuscarDetalleReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.jpeg"))); // NOI18N
        jLabel5.setText("BUSCAR");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 970, 50));

        BTN_Cerrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_Cerrar.setText("Cerrar");
        BTN_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CerrarActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 130, 40));

        BTN_Eliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/suprimir.jpeg"))); // NOI18N
        BTN_Eliminar.setText("DAR DE BAJA");
        BTN_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EliminarActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 180, 50));

        BTN_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.jpeg"))); // NOI18N
        BTN_PDF.setText("Exportar");
        BTN_PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDFActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, 120, 40));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_VerDetalle_RecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerDetalle_RecetaActionPerformed
        this.MostrarDetalle_Receta();
    }//GEN-LAST:event_BTN_VerDetalle_RecetaActionPerformed

    private void JTABLE_Mant_DetalleRecetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_DetalleRecetaMouseClicked
        int fila = JTABLE_Mant_DetalleReceta.getSelectedRow();

        if (fila == -1) {
            return;
        }

        txtcodigoreceta.setText(
                modeloTablaDetalle_Receta.getValueAt(fila, 0).toString());

        String receta
                = modeloTablaDetalle_Receta.getValueAt(fila, 1).toString();

        String producto
                = modeloTablaDetalle_Receta.getValueAt(fila, 2).toString();

        for (int i = 0; i < txtcodigomedicamento.getItemCount(); i++) {
            if (txtcodigomedicamento.getItemAt(i).equals(receta)) {
                txtcodigomedicamento.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < txtid_producto.getItemCount(); i++) {
            if (txtid_producto.getItemAt(i).startsWith(producto + " - ")) {
                txtid_producto.setSelectedIndex(i);
                break;
            }
        }

        txtcantidad.setText(
                modeloTablaDetalle_Receta.getValueAt(fila, 4).toString());

        Object valor = modeloTablaDetalle_Receta.getValueAt(fila, 5);
        txtindicaciones.setText(valor == null ? "" : valor.toString());

        txtcantidad.setEditable(true);
        txtindicaciones.setEditable(true);

    }//GEN-LAST:event_JTABLE_Mant_DetalleRecetaMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
        this.LimpiarCampos();
    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GuardarMouseClicked

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed
        try {
            String receta = (String) txtcodigomedicamento.getSelectedItem();
            String producto = (String) txtid_producto.getSelectedItem();
            String cantidadTexto = txtcantidad.getText().trim();
            String indicaciones = txtindicaciones.getText().trim();

            if (receta == null || producto == null
                    || receta.equals("Seleccionar receta...")
                    || producto.equals("Seleccionar producto...")
                    || cantidadTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Complete los campos obligatorios.");
                return;
            }

            int idReceta = ObtenerID(receta);
            int idProducto = ObtenerID(producto);
            int cantidad = Integer.parseInt(cantidadTexto);

            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this,
                        "La cantidad debe ser mayor que cero.");
                return;
            }

            ConexionC_BD.GuardarDetalle_Receta(
                    idReceta, idProducto, cantidad, indicaciones);

            JOptionPane.showMessageDialog(this,
                    "Detalle de receta registrado correctamente.");

            MostrarDetalle_Receta();
            LimpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese una cantidad válida.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar: " + e.getMessage());
        }

    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
        try {
            if (txtcodigoreceta.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Seleccione un detalle de receta de la tabla.");
                return;
            }

            int codigo = Integer.parseInt(txtcodigoreceta.getText().trim());
            int cantidad = Integer.parseInt(txtcantidad.getText().trim());
            String indicaciones = txtindicaciones.getText().trim();

            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this,
                        "La cantidad debe ser mayor que cero.");
                return;
            }

            ConexionC_BD.ModificarDetalle_Receta(
                    codigo, cantidad, indicaciones);

            JOptionPane.showMessageDialog(this,
                    "Detalle de receta modificado correctamente.");

            MostrarDetalle_Receta();
            LimpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese una cantidad válida.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al modificar: " + e.getMessage());
        }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarDetalleRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarDetalleRecetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarDetalleRecetaActionPerformed

    private void TXT_BuscarDetalleRecetaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarDetalleRecetaKeyReleased
        String texto = TXT_BuscarDetalleReceta.getText().trim();

        DefaultTableModel modelo = (DefaultTableModel) JTABLE_Mant_DetalleReceta.getModel();
        modelo.setRowCount(0);

        try {
            ResultSet rs = ConexionC_BD.buscarDetalleReceta(texto);

            while (rs.next()) {
                Object fila[] = {
                    rs.getInt("id_detalle_receta"),
                    rs.getInt("id_receta"),
                    rs.getInt("id_producto"),
                    rs.getString("nombre_comercial"),
                    rs.getInt("cantidad_prescrita"),
                    rs.getString("indicaciones")
                };

                modelo.addRow(fila);
            }

            rs.close();

            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this,
                        "No se encontraron detalles de receta.",
                        "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar detalle de receta: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_TXT_BuscarDetalleRecetaKeyReleased

    private void TXT_BuscarDetalleRecetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarDetalleRecetaKeyTyped

    }//GEN-LAST:event_TXT_BuscarDetalleRecetaKeyTyped

    private void BTN_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CerrarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de que deseas cerrar el formulario?",
                "Confirmar salida", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_BTN_CerrarActionPerformed

    private void BTN_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EliminarActionPerformed
        try {
            if (txtcodigoreceta.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Seleccione un detalle de receta de la tabla.");
                return;
            }

            int codigo = Integer.parseInt(txtcodigoreceta.getText().trim());

            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Desea eliminar este detalle de receta?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                ConexionC_BD.EliminarDetalle_Receta(codigo);

                JOptionPane.showMessageDialog(this,
                        "Detalle de receta eliminado correctamente.");

                MostrarDetalle_Receta();
                LimpiarCampos();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al eliminar detalle de receta: " + e.getMessage());
        }
    }//GEN-LAST:event_BTN_EliminarActionPerformed

    private void BTN_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDFActionPerformed

    }//GEN-LAST:event_BTN_PDFActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void txtcodigomedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigomedicamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigomedicamentoActionPerformed

    private void txtindicacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtindicacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtindicacionesActionPerformed

    private void txtcodigorecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigorecetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigorecetaActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Detalle_Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Detalle_Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Detalle_Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Detalle_Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Detalle_Receta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar;
    private javax.swing.JButton BTN_EXCEL;
    private javax.swing.JButton BTN_Eliminar;
    private javax.swing.JButton BTN_Guardar;
    private javax.swing.JButton BTN_Modificar;
    private javax.swing.JButton BTN_Nuevo;
    private javax.swing.JButton BTN_PDF;
    private javax.swing.JButton BTN_VerDetalle_Receta;
    private javax.swing.JTable JTABLE_Mant_DetalleReceta;
    private javax.swing.JTextField TXT_BuscarDetalleReceta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JComboBox<String> txtcodigomedicamento;
    private javax.swing.JTextField txtcodigoreceta;
    private javax.swing.JComboBox<String> txtid_producto;
    private javax.swing.JTextField txtindicaciones;
    // End of variables declaration//GEN-END:variables

    /* MANTENIMIENTO A LA TABLA DETALLE_RECETA */
    public void MostrarDetalle_Receta() {
        modeloTablaDetalle_Receta.setRowCount(0);

        try {
            ResultSet rs = ConexionC_BD.ListarDetalle_Receta();

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_detalle_receta"),
                    rs.getInt("id_receta"),
                    rs.getInt("id_producto"),
                    rs.getString("nombre_comercial"),
                    rs.getInt("cantidad_prescrita"),
                    rs.getString("indicaciones")
                };

                modeloTablaDetalle_Receta.addRow(fila);
            }

            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al mostrar detalle_receta: " + e.getMessage());
        }
    }

    public void CargarRecetas() {
        txtcodigomedicamento.removeAllItems();
        txtcodigomedicamento.addItem("Seleccionar receta...");

        try {
            ResultSet rs = ConexionC_BD.ListarRecetasCombo();

            while (rs.next()) {
                txtcodigomedicamento.addItem(
                        String.valueOf(rs.getInt("id_receta")));
            }

            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar recetas: " + e.getMessage());
        }
    }

    public void CargarProductos() {
        txtid_producto.removeAllItems();
        txtid_producto.addItem("Seleccionar producto...");

        try {
            ResultSet rs = ConexionC_BD.ListarProductosRecetaCombo();

            while (rs.next()) {
                txtid_producto.addItem(
                        rs.getInt("id_producto") + " - "
                        + rs.getString("nombre_comercial"));
            }

            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar productos: " + e.getMessage());
        }
    }

    public int ObtenerID(String texto) {
        return Integer.parseInt(texto.split(" - ")[0]);
    }

    public void LimpiarCampos() {
        txtcodigoreceta.setText("");
        txtcantidad.setText("");
        txtindicaciones.setText("");

        JTABLE_Mant_DetalleReceta.clearSelection();

        if (txtcodigomedicamento.getItemCount() > 0) {
            txtcodigomedicamento.setSelectedIndex(0);
        }

        if (txtid_producto.getItemCount() > 0) {
            txtid_producto.setSelectedIndex(0);
        }

        txtcantidad.setEditable(true);
        txtindicaciones.setEditable(true);
    }
}
