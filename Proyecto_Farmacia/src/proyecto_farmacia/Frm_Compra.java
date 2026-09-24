package proyecto_farmacia;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import proyecto_farmacia.ConexionC_BD;

public class Frm_Compra extends javax.swing.JFrame {

    // Modelo para mostrar datos en la tabla
    DefaultTableModel modeloTablaCompras = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    ConexionC_BD ConexionC_BD;

    public Frm_Compra() {
        this.setUndecorated(true);
        
        initComponents();
        this.setLocationRelativeTo(null);
        TXT_BuscarCompras.setText("Ingrese producto para buscar");

        TXT_BuscarCompras.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (TXT_BuscarCompras.getText().equals("Ingrese producto para buscar")) {
                    TXT_BuscarCompras.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (TXT_BuscarCompras.getText().trim().isEmpty()) {
                    TXT_BuscarCompras.setText("Ingrese producto para buscar");
                }
            }
        });
        txtcodigoCompra.setEnabled(false);
        BTN_Guardar.setEnabled(false);
        BTN_Modificar.setEnabled(false);
        BTN_Dar_de_baja.setEnabled(false);
        CHEK_ReactivarCompras.setEnabled(false);
        txtTotal_Compra.setEditable(true);

        ConexionC_BD = new ConexionC_BD();

        // Verificar que la conexión fue exitosa
        if (ConexionC_BD.getConnection() == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar con la base de datos.",
                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }

        // Cargar proveedores en el ComboBox
        this.cargarProveedores();

        // Definir los encabezados de la tabla
        String titulos[] = {"Código", "Proveedor", "N° Compra", "Fecha", "Total", "Estado"};
        modeloTablaCompras.setColumnIdentifiers(titulos);
        JTABLE_Mant_Compras.setModel(modeloTablaCompras);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTotal_Compra = new javax.swing.JTextField();
        BTN_VerCompras = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNumero_Compra = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        CHEK_ListarCompra_de_Baja = new javax.swing.JCheckBox();
        CHEK_ReactivarCompras = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxCompras = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcodigoCompra = new javax.swing.JTextField();
        Fecha_Compra = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Compras = new javax.swing.JTable();
        BTN_Nuevo = new javax.swing.JButton();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Modificar = new javax.swing.JButton();
        BTN_EXCEL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarCompras = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar = new javax.swing.JButton();
        BTN_Dar_de_baja = new javax.swing.JButton();
        BTN_PDF = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("      REGISTRO DE COMPRAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("ID Compra");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        txtTotal_Compra.setEditable(false);
        txtTotal_Compra.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal_Compra.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtTotal_Compra.setForeground(new java.awt.Color(0, 0, 204));
        txtTotal_Compra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal_Compra.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtTotal_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 330, 30));

        BTN_VerCompras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoja.jpeg"))); // NOI18N
        BTN_VerCompras.setText("VER COMPRAS");
        BTN_VerCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerComprasActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VerCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 180, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Total Compra");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        txtNumero_Compra.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtNumero_Compra.setForeground(new java.awt.Color(0, 0, 204));
        txtNumero_Compra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumero_Compra.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNumero_Compra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumero_CompraKeyTyped(evt);
            }
        });
        jPanel1.add(txtNumero_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 330, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CHEK_ListarCompra_de_Baja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CHEK_ListarCompra_de_Baja.setText("Listar compras de baja");
        CHEK_ListarCompra_de_Baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHEK_ListarCompra_de_BajaActionPerformed(evt);
            }
        });
        jPanel3.add(CHEK_ListarCompra_de_Baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 160, -1));

        CHEK_ReactivarCompras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CHEK_ReactivarCompras.setText("Reactivar Compra");
        CHEK_ReactivarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHEK_ReactivarComprasActionPerformed(evt);
            }
        });
        jPanel3.add(CHEK_ReactivarCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 180, 120));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Proveedor");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jComboBoxCompras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBoxCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 330, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("N° Compra");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fecha Compra");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        txtcodigoCompra.setEditable(false);
        txtcodigoCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigoCompra.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigoCompra.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigoCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigoCompra.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 330, 30));
        jPanel1.add(Fecha_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 132, 330, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 940, 230));

        JTABLE_Mant_Compras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Compras.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Compras.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_Compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_ComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Compras);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 950, 220));

        BTN_Nuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        BTN_Nuevo.setText("NUEVO");
        BTN_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 190, 50));

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
        getContentPane().add(BTN_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 190, 50));

        BTN_Modificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_Modificar.setText("MODIFICAR");
        BTN_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 200, 50));

        BTN_EXCEL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.jpeg"))); // NOI18N
        BTN_EXCEL.setText("Exportar");
        BTN_EXCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCELActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_EXCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 620, 120, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Nombre de Cargo");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        TXT_BuscarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarComprasActionPerformed(evt);
            }
        });
        TXT_BuscarCompras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarComprasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarComprasKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 950, 50));

        BTN_Cerrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_Cerrar.setText("Cerrar");
        BTN_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CerrarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 620, 130, 40));

        BTN_Dar_de_baja.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Dar_de_baja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/suprimir.jpeg"))); // NOI18N
        BTN_Dar_de_baja.setText("DAR DE BAJA");
        BTN_Dar_de_baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Dar_de_bajaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Dar_de_baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, 180, 50));

        BTN_PDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.jpeg"))); // NOI18N
        BTN_PDF.setText("Exportar");
        BTN_PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDFActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_PDF, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 620, 120, 40));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_VerComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerComprasActionPerformed
        this.mostrarCompras();
    }//GEN-LAST:event_BTN_VerComprasActionPerformed

    private void txtNumero_CompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumero_CompraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumero_CompraKeyTyped

    private void CHEK_ListarCompra_de_BajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHEK_ListarCompra_de_BajaActionPerformed
        this.listarCompra_dadas_baja();
    }//GEN-LAST:event_CHEK_ListarCompra_de_BajaActionPerformed

    private void CHEK_ReactivarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHEK_ReactivarComprasActionPerformed
        if (!CHEK_ReactivarCompras.isSelected()) {
            return;
        }

        if (txtcodigoCompra.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecciona una compra de la tabla");
            CHEK_ReactivarCompras.setSelected(false);
            return;
        }

        int codigo = Integer.parseInt(txtcodigoCompra.getText().trim());

        try {
            ConexionC_BD.reactivarCompra(codigo);
            JOptionPane.showMessageDialog(this, "Compra reactivada correctamente");

            this.limpiarCamposCompra();

            CHEK_ReactivarCompras.setSelected(false);
            CHEK_ReactivarCompras.setEnabled(false);
            CHEK_ListarCompra_de_Baja.setSelected(false);
            this.mostrarCompras();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al reactivar: " + e.getMessage());
            CHEK_ReactivarCompras.setSelected(false);
        }
    }//GEN-LAST:event_CHEK_ReactivarComprasActionPerformed

    private void JTABLE_Mant_ComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_ComprasMouseClicked

        int fila = JTABLE_Mant_Compras.getSelectedRow();
        if (fila == -1) {
            return;
        }

        txtcodigoCompra.setText(JTABLE_Mant_Compras.getValueAt(fila, 0).toString());
        jComboBoxCompras.setSelectedItem(JTABLE_Mant_Compras.getValueAt(fila, 1).toString());
        txtNumero_Compra.setText(JTABLE_Mant_Compras.getValueAt(fila, 2).toString());

        Object valorFecha = JTABLE_Mant_Compras.getValueAt(fila, 3);
        if (valorFecha instanceof java.util.Date) {
            Fecha_Compra.setDate((java.util.Date) valorFecha);
        } else {
            Fecha_Compra.setDate(Timestamp.valueOf(valorFecha.toString()));
        }

        txtTotal_Compra.setText(JTABLE_Mant_Compras.getValueAt(fila, 4).toString());
        String estado = JTABLE_Mant_Compras.getValueAt(fila, 5).toString();

        // solo se puede reactivar si está ANULADA
        CHEK_ReactivarCompras.setEnabled(estado.equals("ANULADA"));
        CHEK_ReactivarCompras.setSelected(false);

        BTN_Modificar.setEnabled(!estado.equals("ANULADA"));
        BTN_Dar_de_baja.setEnabled(!estado.equals("ANULADA"));
    }//GEN-LAST:event_JTABLE_Mant_ComprasMouseClicked

    private void BTN_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoActionPerformed
        this.limpiarCamposCompra();
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
            String nombreProveedor = (String) jComboBoxCompras.getSelectedItem();
            String numero = txtNumero_Compra.getText().trim();
            String totalStr = txtTotal_Compra.getText().trim();

            // 2. Validar campos requeridos
            if (nombreProveedor == null || jComboBoxCompras.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(this, "Seleccione un proveedor.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (numero.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el número de compra.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                txtNumero_Compra.requestFocus();
                return;
            }
            if (Fecha_Compra.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Seleccione la fecha de la compra.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (totalStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el total de la compra.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                txtTotal_Compra.requestFocus();
                return;
            }

            // 3. Obtener el código del proveedor a partir del nombre del combo
            int idProveedor = ConexionC_BD.obtenerCodigoProveedor(nombreProveedor);
            if (idProveedor == -1) {
                JOptionPane.showMessageDialog(this, "No se encontró el proveedor seleccionado.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Timestamp fecha = new Timestamp(Fecha_Compra.getDate().getTime());
            double total = Double.parseDouble(totalStr);

            // 4. Insertar
            ConexionC_BD.insertarCompra(idProveedor, numero, fecha, total);

            // 5. Confirmar éxito
            JOptionPane.showMessageDialog(this, "Compra registrada correctamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // 6. Refrescar tabla y limpiar
            this.mostrarCompras();
            this.limpiarCamposCompra();
            BTN_Guardar.setEnabled(false);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El total debe ser un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar la compra: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarActionPerformed
        try {
            // 1. Obtener datos del formulario
            String codigoStr = txtcodigoCompra.getText().trim();
            String nombreProveedor = (String) jComboBoxCompras.getSelectedItem();
            String numero = txtNumero_Compra.getText().trim();
            String totalStr = txtTotal_Compra.getText().trim();

            // 2. Validar
            if (codigoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione una compra de la tabla para modificar.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (nombreProveedor == null || jComboBoxCompras.getSelectedIndex() <= 0
                    || numero.isEmpty() || totalStr.isEmpty() || Fecha_Compra.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 3. Convertir datos
            int codigo = Integer.parseInt(codigoStr);
            int idProveedor = ConexionC_BD.obtenerCodigoProveedor(nombreProveedor);
            if (idProveedor == -1) {
                JOptionPane.showMessageDialog(this, "El proveedor seleccionado no es válido.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Timestamp fecha = new Timestamp(Fecha_Compra.getDate().getTime());
            double total = Double.parseDouble(totalStr);

            // 4. Modificar
            ConexionC_BD.modificarCompra(codigo, idProveedor, numero, fecha, total);

            JOptionPane.showMessageDialog(this, "Compra actualizada correctamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // 5. Refrescar y limpiar
            this.listarCompra_Activas();
            this.limpiarCamposCompra();

            BTN_Guardar.setEnabled(false);
            BTN_Modificar.setEnabled(false);
            BTN_Dar_de_baja.setEnabled(false);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Código o total no válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al modificar la compra: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BTN_ModificarActionPerformed

    private void BTN_EXCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELActionPerformed

    }//GEN-LAST:event_BTN_EXCELActionPerformed

    private void TXT_BuscarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarComprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarComprasActionPerformed

    private void TXT_BuscarComprasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarComprasKeyReleased
        this.buscarCompra();
    }//GEN-LAST:event_TXT_BuscarComprasKeyReleased

    private void TXT_BuscarComprasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarComprasKeyTyped

    }//GEN-LAST:event_TXT_BuscarComprasKeyTyped

    private void BTN_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CerrarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de que deseas cerrar el formulario?", "Confirmar salida",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                ConexionC_BD.cerrarConexion();
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
            this.setVisible(false);
        }
    }//GEN-LAST:event_BTN_CerrarActionPerformed

    private void BTN_Dar_de_bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Dar_de_bajaActionPerformed
        try {
            String codigoStr = txtcodigoCompra.getText().trim();

            if (codigoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione una compra de la tabla para dar de baja.",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int codigo = Integer.parseInt(codigoStr);

            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de dar de baja esta compra?",
                    "Confirmar acción", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                ConexionC_BD.darBajaCompra(codigo);

                JOptionPane.showMessageDialog(this, "Compra dada de baja correctamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);

                this.listarCompra_Activas();
                this.limpiarCamposCompra();

                BTN_Guardar.setEnabled(true);
                BTN_Modificar.setEnabled(true);
                BTN_Dar_de_baja.setEnabled(true);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código de compra inválido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al dar de baja: " + e.getMessage(),
                    "Error en base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BTN_Dar_de_bajaActionPerformed

    private void BTN_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDFActionPerformed

    }//GEN-LAST:event_BTN_PDFActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Compra().setVisible(true);
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
    private javax.swing.JButton BTN_VerCompras;
    private javax.swing.JCheckBox CHEK_ListarCompra_de_Baja;
    private javax.swing.JCheckBox CHEK_ReactivarCompras;
    private com.toedter.calendar.JDateChooser Fecha_Compra;
    private javax.swing.JTable JTABLE_Mant_Compras;
    private javax.swing.JTextField TXT_BuscarCompras;
    private javax.swing.JComboBox<String> jComboBoxCompras;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtNumero_Compra;
    private javax.swing.JTextField txtTotal_Compra;
    private javax.swing.JTextField txtcodigoCompra;
    // End of variables declaration//GEN-END:variables
 /* Método para cargar los proveedores en el JComboBox */
    public void cargarProveedores() {
        try {
            String sql = "SELECT  id_proveedor, razon_social FROM proveedor";
            PreparedStatement ps = ConexionC_BD.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel modelo = (DefaultTableModel) JTABLE_Mant_Compras.getModel();
            modelo.setRowCount(0);

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id_proveedor"),
                    rs.getString("razon_social")
                });
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar proveedores: " + e.getMessage());
        }
    }

    /* Llena la tabla con un ResultSet de view_compra */
    private void llenarTabla(ResultSet rs) throws SQLException {
        while (rs != null && rs.next()) {
            Object[] fila = {
                rs.getInt("id_compra"),
                rs.getString("id_proveedor"),
                rs.getString("numero_compra"),
                rs.getTimestamp("fecha_compra"),
                rs.getDouble("total_compra"),
                rs.getString("estado")
            };
            modeloTablaCompras.addRow(fila);
        }
    }

    // Sobrecarga para mantener compatibilidad con llamadas que pasan un parámetro de búsqueda
    public void mostrarCompras() {
        JTABLE_Mant_Compras.setAutoCreateRowSorter(true);
        modeloTablaCompras.setRowCount(0);
        try {
            // Si tu método en la BD acepta filtro de búsqueda:
            llenarTabla(ConexionC_BD.ListarCompra());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al mostrar compras: " + e.getMessage());
        }
    }

    public void buscarCompra() {
        modeloTablaCompras.setRowCount(0);
        String busqueda = TXT_BuscarCompras.getText().trim();
        try {
            llenarTabla(ConexionC_BD.buscarCompra(busqueda));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar compra:\n" + e.getMessage(),
                    "Error de búsqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* Compras que no están anuladas */
    private void listarCompra_Activas() {
        JTABLE_Mant_Compras.setAutoCreateRowSorter(true);
        modeloTablaCompras.setRowCount(0);
        try {
            llenarTabla(ConexionC_BD.verComprasActivas());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al listar compras: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* Compras anuladas (dadas de baja) */
    public void listarCompra_dadas_baja() {
        JTABLE_Mant_Compras.setAutoCreateRowSorter(true);
        modeloTablaCompras.setRowCount(0);
        try {
            llenarTabla(ConexionC_BD.verComprasInactivas());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al listar compras de baja: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* Limpiar los campos del formulario */
    public void limpiarCamposCompra() {
        txtcodigoCompra.setText("");
        jComboBoxCompras.setSelectedIndex(0);
        txtNumero_Compra.setText("");
        Fecha_Compra.setDate(null);
        txtTotal_Compra.setText("");
        txtNumero_Compra.requestFocus();
    }
}
