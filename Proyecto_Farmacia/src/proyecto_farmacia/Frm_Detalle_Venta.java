package proyecto_farmacia;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Frm_Detalle_Venta extends javax.swing.JFrame {

    DefaultTableModel modeloTablaDetalle_Venta;
    ConexionC_BD ConexionC_BD;

    public Frm_Detalle_Venta() {
        initComponents();

        ConexionC_BD = new ConexionC_BD();
        this.setUndecorated(true);

        modeloTablaDetalle_Venta = new DefaultTableModel();
        modeloTablaDetalle_Venta.addColumn("Código");
        modeloTablaDetalle_Venta.addColumn("Venta");
        modeloTablaDetalle_Venta.addColumn("Producto");
        modeloTablaDetalle_Venta.addColumn("Lote");
        modeloTablaDetalle_Venta.addColumn("Cantidad");
        modeloTablaDetalle_Venta.addColumn("Precio Unitario");
        modeloTablaDetalle_Venta.addColumn("Descuento");
        modeloTablaDetalle_Venta.addColumn("Subtotal");

        JTABLE_Mant_Detalle_Venta.setModel(modeloTablaDetalle_Venta);

        txtCantidad.setEditable(true);
        descuento.setEditable(true);

        CargarVentas();
        CargarProductos();
        CargarLotes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        descuento = new javax.swing.JTextField();
        BTN_VerDetalle_Venta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboproducto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcodigoDetalle_Venta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxDetalle_Venta = new javax.swing.JComboBox<>();
        jComboBoxlote = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        preciounitario = new javax.swing.JTextField();
        subTotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Detalle_Venta = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarDetalle_Venta = new javax.swing.JTextField();
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

        descuento.setEditable(false);
        descuento.setBackground(new java.awt.Color(255, 255, 255));
        descuento.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        descuento.setForeground(new java.awt.Color(0, 0, 204));
        descuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descuento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 330, 30));

        BTN_VerDetalle_Venta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerDetalle_Venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoja.jpeg"))); // NOI18N
        BTN_VerDetalle_Venta.setText("VER DETALLE_VENTA");
        BTN_VerDetalle_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerDetalle_VentaActionPerformed(evt);
            }
        });
        jPanel2.add(BTN_VerDetalle_Venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 230, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("descuento");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Venta");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jComboproducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Seleccionar>>" }));
        jPanel2.add(jComboproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 330, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Lote");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Cantidad");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        txtcodigoDetalle_Venta.setEditable(false);
        txtcodigoDetalle_Venta.setBackground(new java.awt.Color(204, 204, 204));
        txtcodigoDetalle_Venta.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigoDetalle_Venta.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigoDetalle_Venta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigoDetalle_Venta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(txtcodigoDetalle_Venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 330, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText(" Producto");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Precio Unitario");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        jComboBoxDetalle_Venta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Seleccionar>>" }));
        jComboBoxDetalle_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDetalle_VentaActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxDetalle_Venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 330, 30));

        jComboBoxlote.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Seleccionar>>" }));
        jComboBoxlote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxloteActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxlote, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 330, 30));

        txtCantidad.setEditable(false);
        txtCantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidad.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(0, 0, 204));
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 330, 30));

        preciounitario.setEditable(false);
        preciounitario.setBackground(new java.awt.Color(255, 255, 255));
        preciounitario.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        preciounitario.setForeground(new java.awt.Color(0, 0, 204));
        preciounitario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        preciounitario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(preciounitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 330, 30));

        subTotal.setEditable(false);
        subTotal.setBackground(new java.awt.Color(255, 255, 255));
        subTotal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        subTotal.setForeground(new java.awt.Color(0, 0, 204));
        subTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        subTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(subTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 330, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Subtotal");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 970, 220));

        JTABLE_Mant_Detalle_Venta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Detalle_Venta.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Detalle_Venta.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_Detalle_Venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_Detalle_VentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Detalle_Venta);

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
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 180, 50));

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

        TXT_BuscarDetalle_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarDetalle_VentaActionPerformed(evt);
            }
        });
        TXT_BuscarDetalle_Venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarDetalle_VentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarDetalle_VentaKeyTyped(evt);
            }
        });
        jPanel4.add(TXT_BuscarDetalle_Venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

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

    private void BTN_VerDetalle_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerDetalle_VentaActionPerformed
        this.MostrarDetalle_Venta();
    }//GEN-LAST:event_BTN_VerDetalle_VentaActionPerformed

    private void jComboBoxDetalle_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDetalle_VentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDetalle_VentaActionPerformed

    private void jComboBoxloteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxloteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxloteActionPerformed

    private void JTABLE_Mant_Detalle_VentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_Detalle_VentaMouseClicked
        int fila = JTABLE_Mant_Detalle_Venta.getSelectedRow();

        if (fila == -1) {
            return;
        }

        txtcodigoDetalle_Venta.setText(
                modeloTablaDetalle_Venta.getValueAt(fila, 0).toString());

        String venta = modeloTablaDetalle_Venta.getValueAt(fila, 1).toString();

        for (int i = 1; i < jComboBoxDetalle_Venta.getItemCount(); i++) {
            if (jComboBoxDetalle_Venta.getItemAt(i).startsWith(venta + " - ")) {
                jComboBoxDetalle_Venta.setSelectedIndex(i);
                break;
            }
        }

        String producto = modeloTablaDetalle_Venta.getValueAt(fila, 2).toString();

        for (int i = 1; i < jComboproducto.getItemCount(); i++) {
            if (jComboproducto.getItemAt(i).endsWith(" - " + producto)) {
                jComboproducto.setSelectedIndex(i);
                break;
            }
        }

        String lote = modeloTablaDetalle_Venta.getValueAt(fila, 3).toString();

        for (int i = 1; i < jComboBoxlote.getItemCount(); i++) {
            if (jComboBoxlote.getItemAt(i).endsWith(" - " + lote)) {
                jComboBoxlote.setSelectedIndex(i);
                break;
            }
        }

        txtCantidad.setText(
                modeloTablaDetalle_Venta.getValueAt(fila, 4).toString());

        preciounitario.setText(
                modeloTablaDetalle_Venta.getValueAt(fila, 5).toString());

        descuento.setText(
                modeloTablaDetalle_Venta.getValueAt(fila, 6).toString());

        subTotal.setText(
                modeloTablaDetalle_Venta.getValueAt(fila, 7).toString());
    
    }//GEN-LAST:event_JTABLE_Mant_Detalle_VentaMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
        this.LimpiarCampos();
    }//GEN-LAST:event_BTN_NuevoActionPerformed

    private void BTN_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GuardarMouseClicked

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed
        try {
            if (jComboBoxDetalle_Venta.getSelectedIndex() == 0
                    || jComboproducto.getSelectedIndex() == 0
                    || jComboBoxlote.getSelectedIndex() == 0
                    || txtCantidad.getText().trim().isEmpty()
                    || preciounitario.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Complete los campos obligatorios.");
                return;
            }

            int idVenta = ObtenerID(
                    jComboBoxDetalle_Venta.getSelectedItem().toString());

            int idProducto = ObtenerID(
                    jComboproducto.getSelectedItem().toString());

            int idLote = ObtenerID(
                    jComboBoxlote.getSelectedItem().toString());

            int cantidad = Integer.parseInt(txtCantidad.getText());
            double precioUnitario = Double.parseDouble(preciounitario.getText());

            double descuentoValor = 0;

            if (!descuento.getText().trim().isEmpty()) {
                descuentoValor = Double.parseDouble(descuento.getText());
            }

            if (cantidad <= 0 || precioUnitario <= 0 || descuentoValor < 0) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese valores válidos para cantidad, precio y descuento.");
                return;
            }

            ConexionC_BD.InsertarDetalle_Venta(
                    idVenta, idProducto, idLote,
                    cantidad, precioUnitario, descuentoValor);

            JOptionPane.showMessageDialog(this,
                    "Detalle de venta registrado correctamente.");

            LimpiarCampos();
            MostrarDetalle_Venta();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Verifique que cantidad, precio y descuento sean números.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar: " + e.getMessage());
}
    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed

        try {
            if (txtcodigoDetalle_Venta.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Seleccione un detalle de venta de la tabla.");
                return;
            }

            int idDetalleVenta = Integer.parseInt(
                    txtcodigoDetalle_Venta.getText());

            int idVenta = ObtenerID(
                    jComboBoxDetalle_Venta.getSelectedItem().toString());

            int idProducto = ObtenerID(
                    jComboproducto.getSelectedItem().toString());

            int idLote = ObtenerID(
                    jComboBoxlote.getSelectedItem().toString());

            int cantidad = Integer.parseInt(txtCantidad.getText());
            double precioUnitario = Double.parseDouble(preciounitario.getText());

            double descuentoValor = 0;

            if (!descuento.getText().trim().isEmpty()) {
                descuentoValor = Double.parseDouble(descuento.getText());
            }

            if (cantidad <= 0 || precioUnitario <= 0 || descuentoValor < 0) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese valores válidos.");
                return;
            }

            ConexionC_BD.ModificarDetalle_Venta(
                    idDetalleVenta, idVenta, idProducto, idLote,
                    cantidad, precioUnitario, descuentoValor);

            JOptionPane.showMessageDialog(this,
                    "Detalle de venta modificado correctamente.");

            LimpiarCampos();
            MostrarDetalle_Venta();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Verifique los datos numéricos.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al modificar: " + e.getMessage());
        }

    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarDetalle_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarDetalle_VentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarDetalle_VentaActionPerformed

    private void TXT_BuscarDetalle_VentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarDetalle_VentaKeyReleased

        String texto = TXT_BuscarDetalle_Venta.getText().trim();

        DefaultTableModel modelo = (DefaultTableModel) JTABLE_Mant_Detalle_Venta.getModel();
        modelo.setRowCount(0);

        try {
            ResultSet rs = ConexionC_BD.BuscarDetalle_Venta(texto);

            while (rs.next()) {
                Object fila[] = {
                    rs.getInt("id_detalle_venta"),
                    rs.getInt("id_venta"),
                    rs.getString("nombre_comercial"),
                    rs.getString("numero_lote"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio_unitario"),
                    rs.getDouble("descuento"),
                    rs.getDouble("Subtotal")
                };

                modelo.addRow(fila);
            }

            rs.close();

            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this,
                        "No se encontraron detalles de venta.",
                        "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar detalle de venta: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_TXT_BuscarDetalle_VentaKeyReleased

    private void TXT_BuscarDetalle_VentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarDetalle_VentaKeyTyped

    }//GEN-LAST:event_TXT_BuscarDetalle_VentaKeyTyped

    private void BTN_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CerrarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de que deseas cerrar el formulario?",
                "Confirmar salida", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_BTN_CerrarActionPerformed

    private void BTN_Dar_de_bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Dar_de_bajaActionPerformed
        try {
            if (txtcodigoDetalle_Venta.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Seleccione un detalle de venta de la tabla.");
                return;
            }

            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de eliminar este detalle de venta?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                int codigo = Integer.parseInt(
                        txtcodigoDetalle_Venta.getText());

                ConexionC_BD.EliminarDetalle_Venta(codigo);

                JOptionPane.showMessageDialog(this,
                        "Detalle de venta eliminado correctamente.");

                LimpiarCampos();
                MostrarDetalle_Venta();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al eliminar: " + e.getMessage());
        }
    }//GEN-LAST:event_BTN_Dar_de_bajaActionPerformed

    private void BTN_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDFActionPerformed

    }//GEN-LAST:event_BTN_PDFActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
        java.util.logging.Logger.getLogger(Frm_Detalle_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Frm_Detalle_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Frm_Detalle_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Frm_Detalle_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Frm_Detalle_Venta().setVisible(true);
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
    private javax.swing.JButton BTN_VerDetalle_Venta;
    private javax.swing.JTable JTABLE_Mant_Detalle_Venta;
    private javax.swing.JTextField TXT_BuscarDetalle_Venta;
    private javax.swing.JTextField descuento;
    private javax.swing.JComboBox<String> jComboBoxDetalle_Venta;
    private javax.swing.JComboBox<String> jComboBoxlote;
    private javax.swing.JComboBox<String> jComboproducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField preciounitario;
    private javax.swing.JTextField subTotal;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtcodigoDetalle_Venta;
    // End of variables declaration//GEN-END:variables
// MÉTODO PARA MOSTRAR LOS DETALLES DE VENTA

    public void MostrarDetalle_Venta() {
        modeloTablaDetalle_Venta.setRowCount(0);

        try {
            ResultSet rs = ConexionC_BD.ListarDetalle_Venta();

            while (rs.next()) {
                modeloTablaDetalle_Venta.addRow(new Object[]{
                    rs.getInt("id_detalle_venta"),
                    rs.getInt("id_venta"),
                    rs.getString("nombre_comercial"),
                    rs.getString("numero_lote"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio_unitario"),
                    rs.getDouble("descuento"),
                    rs.getDouble("Subtotal")
                });
            }

            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al mostrar los detalles de venta: " + e.getMessage());
        }
    }

// MÉTODO PARA CARGAR LAS VENTAS
    public void CargarVentas() {
        jComboBoxDetalle_Venta.removeAllItems();
        jComboBoxDetalle_Venta.addItem("<<Seleccionar>>");

        try {
            ResultSet rs = ConexionC_BD.ListarVentasCombo();

            while (rs.next()) {
                jComboBoxDetalle_Venta.addItem(
                        rs.getInt("id_venta") + " - Venta");
            }

            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar las ventas: " + e.getMessage());
        }
    }

// MÉTODO PARA CARGAR LOS PRODUCTOS
    public void CargarProductos() {
        jComboproducto.removeAllItems();
        jComboproducto.addItem("<<Seleccionar>>");

        try {
            ResultSet rs = ConexionC_BD.ListarProductosCombo();

            while (rs.next()) {
                jComboproducto.addItem(
                        rs.getInt("id_producto") + " - "
                        + rs.getString("nombre_comercial"));
            }

            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los productos: " + e.getMessage());
        }
    }

// MÉTODO PARA CARGAR LOS LOTES
    public void CargarLotes() {
        jComboBoxlote.removeAllItems();
        jComboBoxlote.addItem("<<Seleccionar>>");

        try {
            ResultSet rs = ConexionC_BD.ListarLotes();

            while (rs.next()) {
                jComboBoxlote.addItem(
                        rs.getInt("id_lote") + " - "
                        + rs.getString("numero_lote"));
            }

            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los lotes: " + e.getMessage());
        }
    }

// MÉTODO PARA OBTENER EL ID DEL COMBO
    public int ObtenerID(String texto) {
        return Integer.parseInt(texto.split(" - ")[0]);
    }

// MÉTODO PARA LIMPIAR LOS CAMPOS
    public void LimpiarCampos() {
        txtcodigoDetalle_Venta.setText("");
        txtCantidad.setText("");
        preciounitario.setText("");
        descuento.setText("");
        subTotal.setText("");

        jComboBoxDetalle_Venta.setSelectedIndex(0);
        jComboproducto.setSelectedIndex(0);
        jComboBoxlote.setSelectedIndex(0);

        JTABLE_Mant_Detalle_Venta.clearSelection();
    }}
