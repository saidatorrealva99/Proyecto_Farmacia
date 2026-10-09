
package proyecto_farmacia;
import java.sql.*; // Librerías para conexión con MySQL
import javax.swing.table.DefaultTableModel; // Para trabajar con JTable
import javax.swing.JOptionPane;
    
public class Frm_SubCategoria extends javax.swing.JFrame {

    /*Modelo para mostrar datos en la tabla*/
    DefaultTableModel modeloTablaSubCategoria = new DefaultTableModel();

    ConexionS_BD conexionS_BD;

    public Frm_SubCategoria() {
        initComponents();
        TXT_BuscarSubCategoria.setText("Ingrese nombres ...");
        TXT_BuscarSubCategoria.setForeground(new java.awt.Color(153, 153, 153)); // Color gris tenue

        TXT_BuscarSubCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                // Al hacer clic, si tiene el texto por defecto, se limpia y se pone el texto negro normal
                if (TXT_BuscarSubCategoria.getText().equals("Ingrese nombres ...")) {
                    TXT_BuscarSubCategoria.setText("");
                    TXT_BuscarSubCategoria.setForeground(new java.awt.Color(0, 0, 0)); // Color negro para escribir
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                // Si el usuario sale de la caja y se queda vacía, vuelve a aparecer el texto guía
                if (TXT_BuscarSubCategoria.getText().trim().isEmpty()) {
                    TXT_BuscarSubCategoria.setText("Ingrese nombres ...");
                    TXT_BuscarSubCategoria.setForeground(new java.awt.Color(153, 153, 153));
                }
            }
        });
        // ---------------------------------------------
        /*2. Desactivar botones*/
        txtCodigoSubCategoria.setEnabled(false);
        BTN_ModificarSubCategoria.setEnabled(false);
        BTN_GuardarSubCategoria.setEnabled(false);

        /*3. Instanciamos al conexion a la clase de la base de datos*/
        conexionS_BD = new ConexionS_BD();

        /*4. Metodo para cargar registros del JComboBox*/
        this.cargarCategoria();

        /*5. Definir los encabezados de la tabla*/
        String titulos[] = {"Codigo", "Nombres", "Categoria"};
        modeloTablaSubCategoria.setColumnIdentifiers(titulos);
        JTABLE_MantSubCategoria.setModel(modeloTablaSubCategoria);

        //6. Ocultar la columna Código (Índice 0)
        /*JTABLE_MantSubCategoria.getColumnModel().getColumn(0).setMinWidth(0);
        JTABLE_MantSubCategoria.getColumnModel().getColumn(0).setMaxWidth(0);
        JTABLE_MantSubCategoria.getColumnModel().getColumn(0).setWidth(0);*/
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoSubCategoria = new javax.swing.JTextField();
        txtnombreSubCategoria = new javax.swing.JTextField();
        BTN_VerSubCat = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_MantSubCategoria = new javax.swing.JTable();
        BTN_NuevoSubCategoria = new javax.swing.JButton();
        BTN_GuardarSubCategoria = new javax.swing.JButton();
        BTN_ModificarSubCategoria = new javax.swing.JButton();
        BTN_EXCELSubCategoria = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TXT_BuscarSubCategoria = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BTN_CerrarSubCategoria = new javax.swing.JButton();
        BTN_PDFSubCategoria = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Codigo SubCategoria");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Categoria");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txtCodigoSubCategoria.setEditable(false);
        txtCodigoSubCategoria.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigoSubCategoria.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtCodigoSubCategoria.setForeground(new java.awt.Color(0, 0, 204));
        txtCodigoSubCategoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoSubCategoria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txtCodigoSubCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 370, 30));

        txtnombreSubCategoria.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtnombreSubCategoria.setForeground(new java.awt.Color(0, 0, 204));
        txtnombreSubCategoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombreSubCategoria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtnombreSubCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnombreSubCategoriaMouseClicked(evt);
            }
        });
        txtnombreSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreSubCategoriaActionPerformed(evt);
            }
        });
        txtnombreSubCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreSubCategoriaKeyTyped(evt);
            }
        });
        jPanel3.add(txtnombreSubCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 370, 30));

        BTN_VerSubCat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerSubCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoja.jpeg"))); // NOI18N
        BTN_VerSubCat.setText("VER SubCategoria");
        BTN_VerSubCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerSubCatActionPerformed(evt);
            }
        });
        jPanel3.add(BTN_VerSubCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 280, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nombre SubCategoria");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxCategoriaMouseClicked(evt);
            }
        });
        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });
        jComboBoxCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxCategoriaKeyPressed(evt);
            }
        });
        jPanel3.add(jComboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 370, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 870, 150));

        JTABLE_MantSubCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_MantSubCategoria.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_MantSubCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_MantSubCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_MantSubCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_MantSubCategoria);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 890, 260));

        BTN_NuevoSubCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_NuevoSubCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        BTN_NuevoSubCategoria.setText("NUEVO");
        BTN_NuevoSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoSubCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_NuevoSubCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 190, 50));

        BTN_GuardarSubCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_GuardarSubCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar (2).png"))); // NOI18N
        BTN_GuardarSubCategoria.setText("GUARDAR");
        BTN_GuardarSubCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GuardarSubCategoriaMouseClicked(evt);
            }
        });
        BTN_GuardarSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GuardarSubCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_GuardarSubCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 190, 50));

        BTN_ModificarSubCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_ModificarSubCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_ModificarSubCategoria.setText("MODIFICAR");
        BTN_ModificarSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarSubCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_ModificarSubCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 200, 50));

        BTN_EXCELSubCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCELSubCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.jpeg"))); // NOI18N
        BTN_EXCELSubCategoria.setText("Exportar");
        BTN_EXCELSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCELSubCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_EXCELSubCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 580, 120, 40));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ingresar el Nombre de la Escuela Profesional");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        TXT_BuscarSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarSubCategoriaActionPerformed(evt);
            }
        });
        TXT_BuscarSubCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarSubCategoriaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarSubCategoriaKeyTyped(evt);
            }
        });
        jPanel4.add(TXT_BuscarSubCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("BUSCAR");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 890, 50));

        BTN_CerrarSubCategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_CerrarSubCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_CerrarSubCategoria.setText("Cerrar");
        BTN_CerrarSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CerrarSubCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_CerrarSubCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 580, 130, 40));

        BTN_PDFSubCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.jpeg"))); // NOI18N
        BTN_PDFSubCategoria.setText("Exportar");
        BTN_PDFSubCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDFSubCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_PDFSubCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, 120, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO SUB CATEGORIA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 370, 30));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreSubCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnombreSubCategoriaMouseClicked

    }//GEN-LAST:event_txtnombreSubCategoriaMouseClicked

    private void txtnombreSubCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreSubCategoriaKeyTyped

    }//GEN-LAST:event_txtnombreSubCategoriaKeyTyped

    private void BTN_VerSubCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerSubCatActionPerformed
       this.MostrarSubCategoria();
     
    }//GEN-LAST:event_BTN_VerSubCatActionPerformed

    private void jComboBoxCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaMouseClicked

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jComboBoxCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaKeyPressed

    private void JTABLE_MantSubCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_MantSubCategoriaMouseClicked
        int filaSeleccionada = JTABLE_MantSubCategoria.getSelectedRow();
        if (filaSeleccionada == -1) {
            return; // Evita clics en espacios vacíos
        }
        // Control de estados de los botones
        BTN_ModificarSubCategoria.setEnabled(true);
        BTN_GuardarSubCategoria.setEnabled(false);

        try {
            // Extraer valores de la tabla respetando estrictamente el orden de las columnas de la vista
            txtCodigoSubCategoria.setText(JTABLE_MantSubCategoria.getValueAt(filaSeleccionada, 0).toString().trim());
            txtnombreSubCategoria.setText(JTABLE_MantSubCategoria.getValueAt(filaSeleccionada, 1).toString().trim());
   
            // Selección directa de la profesión en el ComboBox
            String CategoriaTabla = JTABLE_MantSubCategoria.getValueAt(filaSeleccionada, 2).toString().trim();
            jComboBoxCategoria.setSelectedItem(CategoriaTabla);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al seleccionar el registro: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        
    }//GEN-LAST:event_JTABLE_MantSubCategoriaMouseClicked

    private void BTN_NuevoSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoSubCategoriaActionPerformed
    this.listarSubCategoria_limpiar_Campo();

    txtnombreSubCategoria.setEnabled(true);
    jComboBoxCategoria.setEnabled(true);

    txtCodigoSubCategoria.setEnabled(false);

    BTN_GuardarSubCategoria.setEnabled(true);
    BTN_ModificarSubCategoria.setEnabled(false);
    BTN_VerSubCat.setEnabled(true);
    }//GEN-LAST:event_BTN_NuevoSubCategoriaActionPerformed

    private void BTN_GuardarSubCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarSubCategoriaMouseClicked
        
    }//GEN-LAST:event_BTN_GuardarSubCategoriaMouseClicked

    private void BTN_GuardarSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarSubCategoriaActionPerformed
try {
            // 1. Obtener datos del formulario
            String nombre = txtnombreSubCategoria.getText().trim();

            //2. Obtener la profesión seleccionada del ComboBox
            String nombreCategoria = (String) jComboBoxCategoria.getSelectedItem();

            //3. Validar campos requeridos
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor complete los campos obligatorios .",
                        "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
           if (nombreCategoria == null || nombreCategoria.equals("<<Seleccionar>>") 
                   || nombreCategoria.trim().isEmpty()) { 
               JOptionPane.showMessageDialog( this, "Seleccione una categoría válida.", 
                       "Validación", JOptionPane.WARNING_MESSAGE ); 
               return; }

            //4. Obtener el código de la profesión (asumiendo que tienes un método similar a obtenerCodigoFacultad)
            int codigoCategoria = conexionS_BD.obtenerCodigoCategoria(nombreCategoria);
            if (codigoCategoria == -1) {
                JOptionPane.showMessageDialog(this, "No se encontró el código de la categoria seleccionada.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //5. Insertar usando el método de la clase conexionBD
            conexionS_BD.insertarSubcategoria(nombre,codigoCategoria );

            //6. Confirmar éxito
            JOptionPane.showMessageDialog(this, "SubCategoría registrada correctamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            //7. Limpiar campos usando tu método creado
            this.listarSubCategoria_limpiar_Campo();// Asegúrate de tener tu método que lista los docentes en la tabla

           

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), 
                    "Validación", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                    "Error al guardar el subCategoria: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BTN_GuardarSubCategoriaActionPerformed

    private void BTN_ModificarSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarSubCategoriaActionPerformed
        // Validar que se haya seleccionado un registro
        String codStr = txtCodigoSubCategoria.getText().trim();
        String NuevoNombre = txtnombreSubCategoria.getText().trim();

        // VALIDAR CAMPOS
        if (codStr.isEmpty() || NuevoNombre.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una SubCategoría y complete el nuevo nombre.",
                    "Campo requerido",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // VALIDAR COMBOBOX
        if (jComboBoxCategoria.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una Categoría.",
                    "Campo requerido",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // CONVERTIR CÓDIGO DE SUBCATEGORÍA
        int codigoSubCategoria;

        try {
            codigoSubCategoria = Integer.parseInt(codStr);
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "El código de SUBCATEGORÍA no es válido.",
                    "Código incorrecto",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // CONFIRMACIÓN
        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Desea modificar la SubCategoría?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {

            try {

                // Obtener nombre de la categoría seleccionada
                String nombreCategoria
                        = jComboBoxCategoria.getSelectedItem().toString();

                // Obtener ID de la categoría
                int idCategoria
                        = conexionS_BD.obtenerCodigoCategoria(nombreCategoria);

                // Verificar que exista la categoría
                if (idCategoria == 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "No se encontró la categoría seleccionada.",
                            "Categoría no encontrada",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                // MODIFICAR SUBCATEGORÍA
                conexionS_BD.modificarSubcategoria(
                        codigoSubCategoria,
                        NuevoNombre,
                        idCategoria
                );

                // MENSAJE DE ÉXITO
                JOptionPane.showMessageDialog(
                        this,
                        "SubCategoría modificada correctamente.",
                        "Modificación exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                );

                // ACTUALIZAR TABLA
                this.MostrarSubCategoria();

                // LIMPIAR CAMPOS
                txtCodigoSubCategoria.setText("");
                txtnombreSubCategoria.setText("");

                // Regresar ComboBox a la primera opción
                jComboBoxCategoria.setSelectedIndex(0);

                // Habilitar botones
                BTN_ModificarSubCategoria.setEnabled(true);
                BTN_GuardarSubCategoria.setEnabled(true);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Error al modificar SubCategoría:\n" + ex.getMessage(),
                        "Error de base de datos",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_BTN_ModificarSubCategoriaActionPerformed

    private void BTN_EXCELSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELSubCategoriaActionPerformed

    }//GEN-LAST:event_BTN_EXCELSubCategoriaActionPerformed

    private void TXT_BuscarSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarSubCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarSubCategoriaActionPerformed

    private void TXT_BuscarSubCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarSubCategoriaKeyReleased
        String texto = TXT_BuscarSubCategoria.getText().trim();

        //1. Si tiene el texto de guía o está vacío, no buscamos (o puedes listar todos si prefieres)
        if (texto.isEmpty() || texto.equals("Ingrese nombres ..")) {
            modeloTablaSubCategoria.setRowCount(0);
            return;
        }

        //2. Limpiar tabla antes de mostrar resultados nuevos
        modeloTablaSubCategoria.setRowCount(0);

        //3. Usamos try-with-resources para ejecutar el procedimiento almacenado de búsqueda
        try (ResultSet rs = conexionS_BD.buscarSubcategoria(texto)) {

            //4. Llenar la tabla con los resultados obtenidos
            while(rs != null && rs.next()) {
                Object fila[] = {
                    rs.getInt("id_subcategoria"),
                    rs.getString("nombre_subcategoria"),
                    rs.getString("nombre_categoria")};

                modeloTablaSubCategoria.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al buscar subcategorías: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_TXT_BuscarSubCategoriaKeyReleased

    private void TXT_BuscarSubCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarSubCategoriaKeyTyped
       
    }//GEN-LAST:event_TXT_BuscarSubCategoriaKeyTyped

    private void BTN_CerrarSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CerrarSubCategoriaActionPerformed
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

    }//GEN-LAST:event_BTN_CerrarSubCategoriaActionPerformed

    private void BTN_PDFSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDFSubCategoriaActionPerformed

    }//GEN-LAST:event_BTN_PDFSubCategoriaActionPerformed

    private void txtnombreSubCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreSubCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreSubCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_SubCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_SubCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_SubCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_SubCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_SubCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CerrarSubCategoria;
    private javax.swing.JButton BTN_EXCELSubCategoria;
    private javax.swing.JButton BTN_GuardarSubCategoria;
    private javax.swing.JButton BTN_ModificarSubCategoria;
    private javax.swing.JButton BTN_NuevoSubCategoria;
    private javax.swing.JButton BTN_PDFSubCategoria;
    private javax.swing.JButton BTN_VerSubCat;
    private javax.swing.JTable JTABLE_MantSubCategoria;
    private javax.swing.JTextField TXT_BuscarSubCategoria;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtCodigoSubCategoria;
    private javax.swing.JTextField txtnombreSubCategoria;
    // End of variables declaration//GEN-END:variables
private void cargarCategoria() {
        /* Método para cargar las Categoria al JComboBox */
        
      
        try {
            jComboBoxCategoria.removeAllItems();
            jComboBoxCategoria.addItem("<<Seleccionar>>"); // Opción por defecto

            // Usamos try-with-resources para asegurar el cierre del ResultSet
            try (ResultSet rs = conexionS_BD.combobox_ListarCategorias()) {
                while (rs != null && rs.next()) {
                    String nombreCategoria = rs.getString("nombre_categoria");
                    if (nombreCategoria != null) {
                        jComboBoxCategoria.addItem(nombreCategoria.trim());
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar Categoria: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    

public void MostrarSubCategoria() {
        txtCodigoSubCategoria.setEnabled(false);/*desactivar y activar nombreFacultad*/
        //Ordenar Asc, Desc
        JTABLE_MantSubCategoria.setAutoCreateRowSorter(true);
        //Limpia la tabla antes de mostrar nuevos datos
        modeloTablaSubCategoria.setRowCount(0);
        try {
            //Llama al métdo que devuelve los datos de facultad
            ResultSet rs = conexionS_BD.verSubcategorias();
            //Recorre cada fila del resultado y agrega a la tabla
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_subcategoria"),
                    rs.getString("nombre_subcategoria"),
                    rs.getString("nombre_categoria")};

                modeloTablaSubCategoria.addRow(fila);
            }
        } catch (SQLException e) {
            //Muestra mensaje si ocurre un error en la consulta
            JOptionPane.showMessageDialog(this, "Error al mostrar SubCategoria:\n" + e.getMessage(),
                    "Error de consulta", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void listarSubCategoria_limpiar_Campo() {
        txtCodigoSubCategoria.setText("");
        txtnombreSubCategoria.setText("");


        txtnombreSubCategoria.setText("");
        jComboBoxCategoria.setSelectedIndex(0); // Regresa a "<<Seleccionar>>"
    }
    
public void buscarSubCategoriaGenral() {
        // Limpia la tabla antes de mostrar los resultados filtrados
        modeloTablaSubCategoria.setRowCount(0);
        // obtiene el texto ingresado por el usuario
        String busqueda = TXT_BuscarSubCategoria.getText().trim();
        try {
            // Consulta los datos usando el procedimiento almacenado en la BD
            ResultSet rs = conexionS_BD.buscarSubcategoria(busqueda);

            // Recorre los resultados y los anade a la tablal
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_subcategoria"),
                    rs.getString("nombre_subcategoria"),
                    rs.getString("nombre_categoria")
                };
                modeloTablaSubCategoria.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar SubCategoria: \n" + e.getMessage(),
                    "Error de busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }
}
