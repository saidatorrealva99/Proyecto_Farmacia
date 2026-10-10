
package proyecto_farmacia;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_farmacia.ConexionC_BD;


public class Frm_Detalle_Compra extends javax.swing.JFrame {

    DefaultTableModel modeloTablaDetalle_Compra;
    ConexionC_BD ConexionC_BD;

    public Frm_Detalle_Compra() {
        this.setUndecorated(true);
        initComponents();
        TXT_BuscarDetalle_Compra.setText("Ingrese nombre de compra...");
        this.setLocationRelativeTo(null);
        ConexionC_BD = new ConexionC_BD();

        modeloTablaDetalle_Compra = new DefaultTableModel();

        modeloTablaDetalle_Compra.addColumn("Código");
        modeloTablaDetalle_Compra.addColumn("N° Compra");
        modeloTablaDetalle_Compra.addColumn("Producto");
        modeloTablaDetalle_Compra.addColumn("N° Lote");
        modeloTablaDetalle_Compra.addColumn("Cantidad");
        modeloTablaDetalle_Compra.addColumn("Precio Unitario");
        modeloTablaDetalle_Compra.addColumn("Subtotal");

        JTABLE_Mant_Detalle_Compra.setModel(modeloTablaDetalle_Compra);

        txtcodigoDetalle_Compra.setEditable(false);
        txtSUBTOTAL.setEditable(false);

        CargarCompra();
        CargarProductos();
        CargarLotes();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSUBTOTAL = new javax.swing.JTextField();
        BTN_VerDetalle_Compra = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboPRODUCTO = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcodigoDetalle_Compra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxCOMPRA = new javax.swing.JComboBox<>();
        jComboBoxLOTE = new javax.swing.JComboBox<>();
        txt_CANTIDAD = new javax.swing.JTextField();
        txtPRECIO_UNITARIO = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Detalle_Compra = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_GUARDAR = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarDetalle_Compra = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar = new javax.swing.JButton();
        BTN_Dar_de_baja = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("      REGISTRO DETALLE_COMPRA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 240, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        txtSUBTOTAL.setEditable(false);
        txtSUBTOTAL.setBackground(new java.awt.Color(255, 255, 255));
        txtSUBTOTAL.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtSUBTOTAL.setForeground(new java.awt.Color(0, 0, 204));
        txtSUBTOTAL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSUBTOTAL.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(txtSUBTOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 330, 30));

        BTN_VerDetalle_Compra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerDetalle_Compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoja.jpeg"))); // NOI18N
        BTN_VerDetalle_Compra.setText("VER DETALLE_COMPRA");
        BTN_VerDetalle_Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerDetalle_CompraActionPerformed(evt);
            }
        });
        jPanel2.add(BTN_VerDetalle_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 230, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Subtotal");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Compra");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jComboPRODUCTO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Seleccionar>>" }));
        jPanel2.add(jComboPRODUCTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 330, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Lote");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Cantidad");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtcodigoDetalle_Compra.setEditable(false);
        txtcodigoDetalle_Compra.setBackground(new java.awt.Color(204, 204, 204));
        txtcodigoDetalle_Compra.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigoDetalle_Compra.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigoDetalle_Compra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigoDetalle_Compra.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(txtcodigoDetalle_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 330, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText(" Producto");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Precio Unitario");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        jComboBoxCOMPRA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Seleccionar>>" }));
        jComboBoxCOMPRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCOMPRAActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxCOMPRA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 330, 30));

        jComboBoxLOTE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Seleccionar>>" }));
        jComboBoxLOTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLOTEActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxLOTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 330, 30));

        txt_CANTIDAD.setEditable(false);
        txt_CANTIDAD.setBackground(new java.awt.Color(255, 255, 255));
        txt_CANTIDAD.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txt_CANTIDAD.setForeground(new java.awt.Color(0, 0, 204));
        txt_CANTIDAD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_CANTIDAD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(txt_CANTIDAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 330, 30));

        txtPRECIO_UNITARIO.setEditable(false);
        txtPRECIO_UNITARIO.setBackground(new java.awt.Color(255, 255, 255));
        txtPRECIO_UNITARIO.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtPRECIO_UNITARIO.setForeground(new java.awt.Color(0, 0, 204));
        txtPRECIO_UNITARIO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPRECIO_UNITARIO.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(txtPRECIO_UNITARIO, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 330, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 970, 220));

        JTABLE_Mant_Detalle_Compra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Detalle_Compra.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Detalle_Compra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        JTABLE_Mant_Detalle_Compra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_Detalle_CompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Detalle_Compra);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 970, 220));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 170, 50));

        BTN_GUARDAR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_GUARDAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar (2).png"))); // NOI18N
        BTN_GUARDAR.setText("GUARDAR");
        BTN_GUARDAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GUARDARMouseClicked(evt);
            }
        });
        BTN_GUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GUARDARActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_GUARDAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 180, 50));

        BTN_Modificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_Modificar.setText("MODIFICAR");
        BTN_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 200, 50));

        BTN_EXCEL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.jpeg"))); // NOI18N
        BTN_EXCEL.setText("Exportar");
        BTN_EXCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCELActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_EXCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 600, 120, 40));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Nombre de Cargo");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        TXT_BuscarDetalle_Compra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXT_BuscarDetalle_CompraFocusGained(evt);
            }
        });
        TXT_BuscarDetalle_Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarDetalle_CompraActionPerformed(evt);
            }
        });
        TXT_BuscarDetalle_Compra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarDetalle_CompraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarDetalle_CompraKeyTyped(evt);
            }
        });
        jPanel4.add(TXT_BuscarDetalle_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BUSCAR");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 970, 50));

        BTN_Cerrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_Cerrar.setText("Cerrar");
        BTN_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CerrarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 600, 130, 40));

        BTN_Dar_de_baja.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Dar_de_baja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/suprimir.jpeg"))); // NOI18N
        BTN_Dar_de_baja.setText("DAR DE BAJA");
        BTN_Dar_de_baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Dar_de_bajaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Dar_de_baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 180, 50));

        BTN_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.jpeg"))); // NOI18N
        BTN_PDF.setText("Exportar");
        BTN_PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDFActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 600, 120, 40));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_VerDetalle_CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerDetalle_CompraActionPerformed

        TXT_BuscarDetalle_Compra.setText("Ingrese nombre de compra...");
        MostrarDetalle_Compra();
    }//GEN-LAST:event_BTN_VerDetalle_CompraActionPerformed

    private void JTABLE_Mant_Detalle_CompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_Detalle_CompraMouseClicked
        int fila = JTABLE_Mant_Detalle_Compra.getSelectedRow();
        if (fila == -1) {
            return;
        }

        txtcodigoDetalle_Compra.setText(modeloTablaDetalle_Compra.getValueAt(fila, 0).toString());
        txt_CANTIDAD.setText(modeloTablaDetalle_Compra.getValueAt(fila, 4).toString());
        txtPRECIO_UNITARIO.setText(modeloTablaDetalle_Compra.getValueAt(fila, 5).toString());
        txtSUBTOTAL.setText(modeloTablaDetalle_Compra.getValueAt(fila, 6).toString());

        String compra = modeloTablaDetalle_Compra.getValueAt(fila, 1).toString();
        String producto = modeloTablaDetalle_Compra.getValueAt(fila, 2).toString();
        String lote = modeloTablaDetalle_Compra.getValueAt(fila, 3).toString();

        for (int i = 0; i < jComboBoxCOMPRA.getItemCount(); i++) {
            if (jComboBoxCOMPRA.getItemAt(i).endsWith(" - " + compra)) {
                jComboBoxCOMPRA.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < jComboPRODUCTO.getItemCount(); i++) {
            if (jComboPRODUCTO.getItemAt(i).endsWith(" - " + producto)) {
                jComboPRODUCTO.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < jComboBoxLOTE.getItemCount(); i++) {
            if (jComboBoxLOTE.getItemAt(i).endsWith(" - " + lote)) {
                jComboBoxLOTE.setSelectedIndex(i);
                break;
            }
        }

        txt_CANTIDAD.setEditable(true);
        txtPRECIO_UNITARIO.setEditable(true);
    }//GEN-LAST:event_JTABLE_Mant_Detalle_CompraMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
        this.LimpiarCampos();
    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GUARDARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GUARDARMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GUARDARMouseClicked

    private void BTN_GUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GUARDARActionPerformed
        try {
            // 1. Obtener datos del formulario
            String compra = (String) jComboBoxCOMPRA.getSelectedItem();
            String producto = (String) jComboPRODUCTO.getSelectedItem();
            String lote = (String) jComboBoxLOTE.getSelectedItem();
            String cantidadStr = txt_CANTIDAD.getText().trim();
            String precioStr = txtPRECIO_UNITARIO.getText().trim();

            // 2. Validar campos obligatorios
            if (compra == null || producto == null || lote == null
                    || cantidadStr.isEmpty() || precioStr.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Complete todos los campos obligatorios.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 3. Obtener los códigos seleccionados
            int codigoCompra = Integer.parseInt(compra.split(" - ")[0]);
            int codigoProducto = Integer.parseInt(producto.split(" - ")[0]);
            int codigoLote = Integer.parseInt(lote.split(" - ")[0]);

            int cantidad = Integer.parseInt(cantidadStr);
            double precio = Double.parseDouble(precioStr);

            // 4. Validar cantidad y precio
            if (cantidad <= 0 || precio <= 0) {
                JOptionPane.showMessageDialog(this,
                        "La cantidad y el precio deben ser mayores que cero.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 5. Guardar el detalle de compra
            ConexionC_BD.insertarDetalleCompra(
                    codigoCompra, codigoProducto, codigoLote, cantidad, precio);

            JOptionPane.showMessageDialog(this,
                    "Detalle de compra registrado correctamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // 6. Actualizar tabla y limpiar campos
            LimpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Verifique los códigos, la cantidad y el precio.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BTN_GUARDARActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
        try {
            if (txtcodigoDetalle_Compra.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione un detalle de compra de la tabla.");
                return;
            }

            int codigo = Integer.parseInt(txtcodigoDetalle_Compra.getText().trim());
            int cantidad = Integer.parseInt(txt_CANTIDAD.getText().trim());
            double precio = Double.parseDouble(txtPRECIO_UNITARIO.getText().trim());

            if (cantidad <= 0 || precio <= 0) {
                JOptionPane.showMessageDialog(this,
                        "La cantidad y el precio deben ser mayores que cero.");
                return;
            }

            ConexionC_BD.ModificarDetalle_Compra(codigo, cantidad, precio);
            JOptionPane.showMessageDialog(this, "Detalle de compra modificado correctamente.");
            MostrarDetalle_Compra();
            LimpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al modificar: " + e.getMessage());
        }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarDetalle_CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarDetalle_CompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarDetalle_CompraActionPerformed

    private void TXT_BuscarDetalle_CompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarDetalle_CompraKeyReleased

        String texto = TXT_BuscarDetalle_Compra.getText().trim();

        if (texto.equals("Ingrese nombre de compra...") || texto.isEmpty()) {
            MostrarDetalle_Compra();
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) JTABLE_Mant_Detalle_Compra.getModel();
        modelo.setRowCount(0);

        try {
            ResultSet rs = ConexionC_BD.buscarDetalleCompra(texto);

            while (rs.next()) {
                Object fila[] = {
                    rs.getInt("id_detalle_compra"),
                    rs.getString("nombre_comercial"),
                    rs.getString("numero_compra"),
                    rs.getString("numero_lote"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio_unitario"),
                    rs.getDouble("subtotal")
                };

                modelo.addRow(fila);
            }

            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar detalle de compra: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_TXT_BuscarDetalle_CompraKeyReleased

    private void TXT_BuscarDetalle_CompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarDetalle_CompraKeyTyped

    }//GEN-LAST:event_TXT_BuscarDetalle_CompraKeyTyped

    private void BTN_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CerrarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar el formulario?",
                "Confirmar salida", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                ConexionC_BD.cerrarConexion();
            } catch (Exception e) {
            }
            dispose(); // o this.dispose() si estás dentro del formulario
        }
    }//GEN-LAST:event_BTN_CerrarActionPerformed

    private void BTN_Dar_de_bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Dar_de_bajaActionPerformed
        try {
            if (txtcodigoDetalle_Compra.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione un detalle de compra de la tabla.");
                return;
            }

            int codigo = Integer.parseInt(txtcodigoDetalle_Compra.getText().trim());
            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Desea eliminar este detalle de compra?",
                    "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                ConexionC_BD.EliminarDetalle_Compra(codigo);
                JOptionPane.showMessageDialog(this, "Detalle de compra eliminado correctamente.");
                MostrarDetalle_Compra();
                LimpiarCampos();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al eliminar. Puede que el registro esté relacionado con otros datos.\n"
                    + e.getMessage());
        }
    }//GEN-LAST:event_BTN_Dar_de_bajaActionPerformed

    private void BTN_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDFActionPerformed

    }//GEN-LAST:event_BTN_PDFActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBoxCOMPRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCOMPRAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCOMPRAActionPerformed

    private void jComboBoxLOTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLOTEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLOTEActionPerformed

    private void TXT_BuscarDetalle_CompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_BuscarDetalle_CompraFocusGained
        if (TXT_BuscarDetalle_Compra.getText().equals("Ingrese nombre de compra...")) {
            TXT_BuscarDetalle_Compra.setText("");
        }
    }//GEN-LAST:event_TXT_BuscarDetalle_CompraFocusGained

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
        java.util.logging.Logger.getLogger(Frm_Detalle_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Frm_Detalle_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Frm_Detalle_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Frm_Detalle_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Frm_Detalle_Compra().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar;
    private javax.swing.JButton BTN_Dar_de_baja;
    private javax.swing.JButton BTN_EXCEL;
    private javax.swing.JButton BTN_GUARDAR;
    private javax.swing.JButton BTN_Modificar;
    private javax.swing.JButton BTN_Nuevo;
    private javax.swing.JButton BTN_PDF;
    private javax.swing.JButton BTN_VerDetalle_Compra;
    private javax.swing.JTable JTABLE_Mant_Detalle_Compra;
    private javax.swing.JTextField TXT_BuscarDetalle_Compra;
    private javax.swing.JComboBox<String> jComboBoxCOMPRA;
    private javax.swing.JComboBox<String> jComboBoxLOTE;
    private javax.swing.JComboBox<String> jComboPRODUCTO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtPRECIO_UNITARIO;
    private javax.swing.JTextField txtSUBTOTAL;
    private javax.swing.JTextField txt_CANTIDAD;
    private javax.swing.JTextField txtcodigoDetalle_Compra;
    // End of variables declaration//GEN-END:variables
/* MANTENIMIENTO A LA TABLA DETALLE_COMPRA */

    public void MostrarDetalle_Compra() {
        modeloTablaDetalle_Compra.setRowCount(0);
        try {
            ResultSet rs = ConexionC_BD.ListarDetalle_Compra();
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_detalle_compra"),
                    rs.getString("numero_compra"),
                    rs.getString("nombre_comercial"),
                    rs.getString("numero_lote"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio_unitario"),
                    rs.getDouble("subtotal")
                };
                modeloTablaDetalle_Compra.addRow(fila);
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al mostrar detalles: " + e.getMessage());
        }
    }

    public void CargarCompra() {
        jComboBoxCOMPRA.removeAllItems();

        try {
            ResultSet rs = ConexionC_BD.ListarCompra();

            while (rs.next()) {
                jComboBoxCOMPRA.addItem(
                        rs.getInt("id_compra") + " - "
                        + rs.getString("numero_compra")
                );
            }

            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar compra: " + e.getMessage());
        }
    }

    public void CargarProductos() {
        jComboPRODUCTO.removeAllItems();
        try {
            ResultSet rs = ConexionC_BD.listarProductosCombo();
            while (rs.next()) {
                jComboPRODUCTO.addItem(
                        rs.getInt("id_producto") + " - "
                        + rs.getString("nombre_comercial"));
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar productos: " + e.getMessage());
        }
    }

    public void CargarLotes() {
        jComboBoxLOTE.removeAllItems();
        try {
            ResultSet rs = ConexionC_BD.ListarLotes();
            while (rs.next()) {
                jComboBoxLOTE.addItem(
                        rs.getInt("id_lote") + " - "
                        + rs.getString("numero_lote"));
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar lotes: " + e.getMessage());
        }
    }

    public void LimpiarCampos() {
        txtcodigoDetalle_Compra.setText("");
        txt_CANTIDAD.setText("");
        txtPRECIO_UNITARIO.setText("");
        txtSUBTOTAL.setText("");
        JTABLE_Mant_Detalle_Compra.clearSelection();

        if (jComboBoxCOMPRA.getItemCount() > 0) {
            jComboBoxCOMPRA.setSelectedIndex(0);
        }
        if (jComboPRODUCTO.getItemCount() > 0) {
            jComboPRODUCTO.setSelectedIndex(0);
        }
        if (jComboBoxLOTE.getItemCount() > 0) {
            jComboBoxLOTE.setSelectedIndex(0);
        }
    }

    public void CalcularSubtotal() {
        try {
            int cantidad = Integer.parseInt(txt_CANTIDAD.getText().trim());
            double precio = Double.parseDouble(txtPRECIO_UNITARIO.getText().trim());
            txtSUBTOTAL.setText(String.format("%.2f", cantidad * precio));
        } catch (NumberFormatException e) {
            txtSUBTOTAL.setText("");
        }
    }
}
