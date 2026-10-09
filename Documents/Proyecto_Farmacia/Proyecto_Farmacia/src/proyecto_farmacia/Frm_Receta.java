
package proyecto_farmacia;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Frm_Receta extends javax.swing.JFrame {
int idCliente;
int idPersonal;
String fechaEmision;
    DefaultTableModel modeloTablaReceta = new DefaultTableModel();
    ConexionS_BD conexionS_BD;

    public Frm_Receta() {
        initComponents();
        
        /*Centrar*/
        this.setLocationRelativeTo(this);

        this.BTN_GUARDARReceta.setEnabled(false);
        this.BTN_MODIFICARReceta.setEnabled(false);
        this.BTN_NUEVOReceta.setEnabled(false);
        this.BTN_CERRAR.setEnabled(true);

        // 1. Definimos la cadena exacta del placeholder
        String placeholderText = "Buscar Código o fecha...";

// 2. Configuración inicial del Placeholder
        TXT_BUSCAR_Receta.setText(placeholderText);
        TXT_BUSCAR_Receta.setForeground(new java.awt.Color(153, 153, 153));

        txtId_Receta.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {

                if (TXT_BUSCAR_Receta.getText().equals(placeholderText)) {
                    TXT_BUSCAR_Receta.setText("");
                    TXT_BUSCAR_Receta.setForeground(new java.awt.Color(0, 0, 0));
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {

                if (TXT_BUSCAR_Receta.getText().trim().isEmpty()) {
                    TXT_BUSCAR_Receta.setText(placeholderText);
                    TXT_BUSCAR_Receta.setForeground(new java.awt.Color(153, 153, 153));
                }
            }
        });

// 3. Configuración de las columnas de la tabla
        String titulos[] = {
            "ID",
            "Cliente",
            "DNI Cliente",
            "Personal",
            "Diagnóstico",
            "Fecha Emisión",
            "Observaciones"
        };

        modeloTablaReceta.setColumnIdentifiers(titulos);
        JTABLE_Receta.setModel(modeloTablaReceta);

// 4. Conexión con la base de datos
        conexionS_BD = new ConexionS_BD();

// 5. Cargar los ComboBox
        this.llenarJComboBox_Clientes();
        this.llenarJComboBox_Personal();

// 6. Cargar las recetas en la tabla
        this.listarRecetas();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtId_Receta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        BTN_ListarReceta = new javax.swing.JButton();
        jTextObservaciones = new javax.swing.JTextField();
        Txt_Daignostico = new javax.swing.JTextField();
        jComboCliente = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboNombrePersonal = new javax.swing.JComboBox<>();
        jTxtFechaEmision = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        BTN_NUEVOReceta = new javax.swing.JButton();
        BTN_GUARDARReceta = new javax.swing.JButton();
        BTN_MODIFICARReceta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BUSCAR_Receta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Receta = new javax.swing.JTable();
        BTN_CERRAR = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Id_Receta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nombre Personal");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fecha Emision");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Diagnostico");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 80, 20));

        txtId_Receta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtId_Receta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtId_Receta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 310, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Observaciones");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        BTN_ListarReceta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_ListarReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/casa.png"))); // NOI18N
        BTN_ListarReceta.setText("Listar Usuario");
        BTN_ListarReceta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_ListarRecetaMouseClicked(evt);
            }
        });
        BTN_ListarReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ListarRecetaActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_ListarReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 160, 70));
        jPanel1.add(jTextObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 310, -1));
        jPanel1.add(Txt_Daignostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 310, -1));

        jComboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboClienteActionPerformed(evt);
            }
        });
        jPanel1.add(jComboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 310, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nombre Cliente");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jComboNombrePersonal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboNombrePersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboNombrePersonalActionPerformed(evt);
            }
        });
        jPanel1.add(jComboNombrePersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 240, -1));
        jPanel1.add(jTxtFechaEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 310, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE RECETA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 240, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 870, 250));

        BTN_NUEVOReceta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_NUEVOReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        BTN_NUEVOReceta.setText("NUEVO");
        BTN_NUEVOReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NUEVORecetaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_NUEVOReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 150, 50));

        BTN_GUARDARReceta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_GUARDARReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar (2).png"))); // NOI18N
        BTN_GUARDARReceta.setText("GUARDAR");
        BTN_GUARDARReceta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GUARDARRecetaMouseClicked(evt);
            }
        });
        BTN_GUARDARReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GUARDARRecetaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_GUARDARReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 140, 50));

        BTN_MODIFICARReceta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_MODIFICARReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_MODIFICARReceta.setText("MODIFICAR");
        BTN_MODIFICARReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_MODIFICARRecetaActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_MODIFICARReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 140, 50));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar codigo de receta ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, 30));

        TXT_BUSCAR_Receta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_BUSCAR_Receta.setToolTipText("");
        TXT_BUSCAR_Receta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BUSCAR_RecetaActionPerformed(evt);
            }
        });
        TXT_BUSCAR_Receta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BUSCAR_RecetaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BUSCAR_RecetaKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BUSCAR_Receta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 410, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.jpeg"))); // NOI18N
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 850, 50));

        JTABLE_Receta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Receta.setForeground(new java.awt.Color(0, 0, 153));
        JTABLE_Receta.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Receta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_RecetaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Receta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 860, 290));

        BTN_CERRAR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_CERRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_CERRAR.setText("Cerrar");
        BTN_CERRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CERRARActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_CERRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 140, 50));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 910, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_ListarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ListarRecetaActionPerformed

    TXT_BUSCAR_Receta.setText("");
    listarRecetas();
    
    }//GEN-LAST:event_BTN_ListarRecetaActionPerformed

    private void BTN_NUEVORecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NUEVORecetaActionPerformed
/* Limpiar los campos */

txtId_Receta.setText("");

jComboCliente.setSelectedIndex(-1);
jComboNombrePersonal.setSelectedIndex(-1);

Txt_Daignostico.setText("");
jTxtFechaEmision.setDate(null);
jTextObservaciones.setText("");

/* Enviar el cursor al primer campo */
txtId_Receta.requestFocus();

/* Habilitar campos para registrar una nueva receta */
jComboCliente.setEnabled(true);
jComboNombrePersonal.setEnabled(true);
Txt_Daignostico.setEnabled(true);
jTxtFechaEmision.setEnabled(true);
jTextObservaciones.setEnabled(true);

/* El ID no se modifica manualmente */
txtId_Receta.setEnabled(false);

/* HABILITAR BOTÓN GUARDAR */
BTN_GUARDARReceta.setEnabled(true);

/* DESHABILITAR BOTONES DE MODIFICAR Y ELIMINAR */
BTN_MODIFICARReceta.setEnabled(false);

    }//GEN-LAST:event_BTN_NUEVORecetaActionPerformed

    private void BTN_GUARDARRecetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GUARDARRecetaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GUARDARRecetaMouseClicked

    private void BTN_GUARDARRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GUARDARRecetaActionPerformed
// 1. Obtener los datos del formulario

        String cliente = jComboCliente.getSelectedItem() != null
                ? jComboCliente.getSelectedItem().toString().trim()
                : "";

        String personal = jComboNombrePersonal.getSelectedItem() != null
                ? jComboNombrePersonal.getSelectedItem().toString().trim()
                : "";

        String diagnostico = Txt_Daignostico.getText().trim();

        String observaciones = jTextObservaciones.getText().trim();


        // 2. Validar Cliente

        if (cliente.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione el NombreCliente",
                    "Campo requerido",
                    JOptionPane.WARNING_MESSAGE
            );

            jComboCliente.requestFocus();
            return;
        }


        // 3. Validar Personal

        if (personal.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione el NombrePersonal",
                    "Campo requerido",
                    JOptionPane.WARNING_MESSAGE
            );

            jComboNombrePersonal.requestFocus();
            return;
        }


        // 4. Validar Diagnóstico

        if (diagnostico.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese el diagnóstico",
                    "Campo requerido",
                    JOptionPane.WARNING_MESSAGE
            );

            Txt_Daignostico.requestFocus();
            return;
        }


        // 5. Validar Fecha

        if (jTxtFechaEmision.getDate() == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione la fecha de emisión",
                    "Campo requerido",
                    JOptionPane.WARNING_MESSAGE
            );

            jTxtFechaEmision.requestFocus();
            return;
        }


        // 6. Obtener los IDs de Cliente y Personal

        try {

            idCliente = conexionS_BD.obtenerIdCliente(
            jComboCliente.getSelectedItem().toString()
    );
             idPersonal = conexionS_BD.obtenerIdPersonal(
            jComboNombrePersonal.getSelectedItem().toString()
    );


            // Verificar que existan

            if (idCliente == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "No se encontró el Cliente seleccionado",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }


            if (idPersonal == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "No se encontró el Personal seleccionado",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }


            // 7. Convertir la fecha

            java.util.Date fecha = jTxtFechaEmision.getDate();

            java.sql.Date fechaSQL =
                    new java.sql.Date(fecha.getTime());


            // 8. Confirmar si desea guardar

            int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    "¿Desea guardar el registro de la receta?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION
            );


            if (respuesta == JOptionPane.YES_OPTION) {

                // 9. Insertar receta

                conexionS_BD.insertarReceta(
                        idCliente,
                        idPersonal,
                        diagnostico,
                        fechaSQL.toString(),
                        observaciones
                );


                // 10. Mensaje de éxito

                JOptionPane.showMessageDialog(
                        this,
                        "Receta registrada correctamente",
                        "Registro exitoso",
                        JOptionPane.INFORMATION_MESSAGE
                );


                // 11. Actualizar tabla

                this.listarRecetas();


                // 12. Limpiar campos

                jComboCliente.setSelectedIndex(-1);
                jComboNombrePersonal.setSelectedIndex(-1);
                Txt_Daignostico.setText("");
                jTxtFechaEmision.setDate(null);
                jTextObservaciones.setText("");

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al registrar la receta:\n" + ex.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_BTN_GUARDARRecetaActionPerformed

    private void BTN_MODIFICARRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_MODIFICARRecetaActionPerformed
 // 1. Obtener los datos de los campos
    String codStr = txtId_Receta.getText().trim();
    String NuevoDiagnostico = Txt_Daignostico.getText().trim();
    String NuevasObservaciones = jTextObservaciones.getText().trim();

    // 2. Validar los campos
    if (codStr.isEmpty()
            || NuevoDiagnostico.isEmpty()
            || NuevasObservaciones.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Seleccione una receta y complete todos los campos.",
                "Campos requeridos",
                JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // 3. Convertir el ID de la receta
    int codigo;

    try {
        codigo = Integer.parseInt(codStr);
    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
                this,
                "El código de la receta no es válido.",
                "Código incorrecto",
                JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // 4. Validar los ComboBox y la fecha
    if (jComboCliente.getSelectedIndex() <= 0
            || jComboNombrePersonal.getSelectedIndex() <= 0
            || jTxtFechaEmision.getDate() == null) {

        JOptionPane.showMessageDialog(
                this,
                "Seleccione el cliente, el personal y la fecha de emisión.",
                "Campos requeridos",
                JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // 5. Confirmar la modificación
    int respuesta = JOptionPane.showConfirmDialog(
            this,
            "¿Desea modificar la receta?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION
    );

    if (respuesta != JOptionPane.YES_OPTION) {
        return;
    }

    // 6. Consultar los IDs y modificar la receta
    try {

        // Obtener los IDs de las selecciones
        idCliente = conexionS_BD.obtenerIdCliente(
                jComboCliente.getSelectedItem().toString()
        );

        idPersonal = conexionS_BD.obtenerIdPersonal(
                jComboNombrePersonal.getSelectedItem().toString()
        );

        // Verificar que los registros existan
        if (idCliente == -1 || idPersonal == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "No se encontró el cliente o el personal seleccionado.",
                    "Registro no encontrado",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Convertir la fecha
        fechaEmision = new java.text.SimpleDateFormat("yyyy-MM-dd")
                .format(jTxtFechaEmision.getDate());

        // Ejecutar la modificación UNA SOLA VEZ
        conexionS_BD.modificarReceta(
                codigo,
                idCliente,
                idPersonal,
                NuevoDiagnostico,
                fechaEmision,
                NuevasObservaciones
        );

        // Mostrar confirmación
        JOptionPane.showMessageDialog(
                this,
                "Receta modificada correctamente.",
                "Modificación exitosa",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Actualizar la tabla
        listarRecetas();

        // Limpiar los campos
        txtId_Receta.setText("");
        Txt_Daignostico.setText("");
        jTextObservaciones.setText("");

        jComboCliente.setSelectedIndex(0);
        jComboNombrePersonal.setSelectedIndex(0);
        jTxtFechaEmision.setDate(null);

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(
                this,
                "Error al modificar la receta:\n" + ex.getMessage(),
                "Error de base de datos",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_BTN_MODIFICARRecetaActionPerformed

    private void TXT_BUSCAR_RecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_RecetaActionPerformed

    }//GEN-LAST:event_TXT_BUSCAR_RecetaActionPerformed

    private void TXT_BUSCAR_RecetaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_RecetaKeyReleased
this.listarRecetas();
    }//GEN-LAST:event_TXT_BUSCAR_RecetaKeyReleased

    private void TXT_BUSCAR_RecetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BUSCAR_RecetaKeyTyped

    }//GEN-LAST:event_TXT_BUSCAR_RecetaKeyTyped

    private void JTABLE_RecetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_RecetaMouseClicked
this.ocultarColumnasIDReceta();
/* Obtener la fila seleccionada */
int filaseleccionada = JTABLE_Receta.getSelectedRow();

if (filaseleccionada >= 0) {

    /* Llenar los campos con los datos de la fila */

String codigo = JTABLE_Receta.getValueAt(filaseleccionada, 0).toString();
String cliente = JTABLE_Receta.getValueAt(filaseleccionada, 1).toString();
String dni = JTABLE_Receta.getValueAt(filaseleccionada, 2).toString();
String personal = JTABLE_Receta.getValueAt(filaseleccionada, 3).toString();
String diagnostico = JTABLE_Receta.getValueAt(filaseleccionada, 4).toString();
String fecha = JTABLE_Receta.getValueAt(filaseleccionada, 5).toString();
java.sql.Date fechaSQL = java.sql.Date.valueOf(fecha);
jTxtFechaEmision.setDate(fechaSQL);
String observaciones = JTABLE_Receta.getValueAt(filaseleccionada, 6).toString();
    txtId_Receta.setText(codigo);

    jComboCliente.setSelectedItem(cliente);

    jComboNombrePersonal.setSelectedItem(personal);

    Txt_Daignostico.setText(diagnostico);


    jTextObservaciones.setText(observaciones);


    /* Habilitar los campos para editar */

    jComboCliente.setEnabled(true);
    jComboNombrePersonal.setEnabled(true);
    Txt_Daignostico.setEnabled(true);
    jTxtFechaEmision.setEnabled(true);
    jTextObservaciones.setEnabled(true);


    /* El ID no se debe editar */

    txtId_Receta.setEnabled(false);


    /* Habilitar botones relacionados */

    BTN_MODIFICARReceta.setEnabled(true);
    /* Deshabilitar botón Guardar */

    BTN_GUARDARReceta.setEnabled(false);
    /* Mantener habilitados los botones Nuevo y Cerrar */

    BTN_NUEVOReceta.setEnabled(true);
    BTN_CERRAR.setEnabled(true);
}
    }//GEN-LAST:event_JTABLE_RecetaMouseClicked

    private void BTN_CERRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CERRARActionPerformed
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
    }//GEN-LAST:event_BTN_CERRARActionPerformed

    private void BTN_ListarRecetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_ListarRecetaMouseClicked
         /* Obtener la fila seleccionada */
    int filaSeleccionada = JTABLE_Receta.getSelectedRow();

    if (filaSeleccionada >= 0) {

        /* Obtener los datos de la fila */
        String codigo = JTABLE_Receta.getValueAt(filaSeleccionada, 0).toString();
        String cliente = JTABLE_Receta.getValueAt(filaSeleccionada, 1).toString();
        String personal = JTABLE_Receta.getValueAt(filaSeleccionada, 3).toString();
        String diagnostico = JTABLE_Receta.getValueAt(filaSeleccionada, 4).toString();
        String fecha = JTABLE_Receta.getValueAt(filaSeleccionada, 5).toString();
        String observaciones = JTABLE_Receta.getValueAt(filaSeleccionada, 6).toString();

        /* Llenar los campos */
        txtId_Receta.setText(codigo);

        jComboCliente.setSelectedItem(cliente);

        jComboNombrePersonal.setSelectedItem(personal);

        Txt_Daignostico.setText(diagnostico);

        jTxtFechaEmision.setDate(
            java.sql.Date.valueOf(fecha)
        );

        jTextObservaciones.setText(observaciones);

        /* Campos que se pueden modificar */
        jComboCliente.setEnabled(true);
        jComboNombrePersonal.setEnabled(true);
        Txt_Daignostico.setEnabled(true);
        jTxtFechaEmision.setEnabled(true);
        jTextObservaciones.setEnabled(true);

        /* ID no se modifica */
        txtId_Receta.setEnabled(false);

        /* Habilitar botones relacionados */
        BTN_MODIFICARReceta.setEnabled(true);


        /* Deshabilitar Guardar mientras se modifica */
        BTN_GUARDARReceta.setEnabled(false);
    }
    }//GEN-LAST:event_BTN_ListarRecetaMouseClicked

    private void jComboNombrePersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboNombrePersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboNombrePersonalActionPerformed

    private void jComboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboClienteActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Receta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CERRAR;
    private javax.swing.JButton BTN_GUARDARReceta;
    private javax.swing.JButton BTN_ListarReceta;
    private javax.swing.JButton BTN_MODIFICARReceta;
    private javax.swing.JButton BTN_NUEVOReceta;
    private javax.swing.JTable JTABLE_Receta;
    private javax.swing.JTextField TXT_BUSCAR_Receta;
    private javax.swing.JTextField Txt_Daignostico;
    private javax.swing.JComboBox<String> jComboCliente;
    private javax.swing.JComboBox<String> jComboNombrePersonal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextObservaciones;
    private com.toedter.calendar.JDateChooser jTxtFechaEmision;
    private javax.swing.JTextField txtId_Receta;
    // End of variables declaration//GEN-END:variables

private void llenarJComboBox_Clientes() {

    try {

        jComboCliente.removeAllItems();
        jComboCliente.addItem("<<Seleccionar>>");
        try (ResultSet rs = conexionS_BD.combobox_ListarClientes()) {
            while (rs.next()) {
                jComboCliente.addItem(
                       
                    rs.getString("nombre_cliente")
                );
            }
        }
    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
            this,
            "Error al cargar clientes: " + e.getMessage()
        );
    }
}


private void llenarJComboBox_Personal() {

    try {

        jComboNombrePersonal.removeAllItems();

        jComboNombrePersonal.addItem("<<Seleccionar>>");

        try (ResultSet rs = conexionS_BD.combobox_ListarPersonal()) {

            while (rs.next()) {

                jComboNombrePersonal.addItem(
                         
                    rs.getString("nombre_personal")
                );
            }
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
            this,
            "Error al cargar personal: " + e.getMessage()
        );
    }
}

    private void listarRecetas() {
// Limpia la tabla antes de mostrar los resultados filtrados
        modeloTablaReceta.setRowCount(0);
        
        // Obtiene el texto ingresado por el usuario
        String busqueda = TXT_BUSCAR_Receta.getText().trim();
        try { ResultSet rs = conexionS_BD.buscarReceta(busqueda);
            while (rs.next()) {

                Object[] fila = {
                    rs.getInt("id_receta"),
                    rs.getString("nombre_cliente"),
                    rs.getString("dni_cliente"),
                    rs.getString("nombre_personal"),
                    rs.getString("diagnostico"),
                    rs.getDate("fecha_emision"),
                    rs.getString("observaciones")
                };

                modeloTablaReceta.addRow(fila);
            }
            rs.close();

            }catch (SQLException e) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Error al buscar receta:\n" +  e.getMessage(),
                "Error de búsqueda",
        JOptionPane.ERROR_MESSAGE
                    );
    }
        }
    private void ocultarColumnasIDReceta() {
        // Ocultar ID_CLIENTE (columna 1)
        JTABLE_Receta.getColumnModel().getColumn(1).setMinWidth(0); 
        JTABLE_Receta.getColumnModel().getColumn(1).setMaxWidth(0); 
        JTABLE_Receta.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        // Ocultar ID_PERSONAL (columna 4)
        
        JTABLE_Receta.getColumnModel().getColumn(4).setMinWidth(0); 
        JTABLE_Receta.getColumnModel().getColumn(4).setMaxWidth(0); 
        JTABLE_Receta.getColumnModel().getColumn(4).setPreferredWidth(0);
        
    }

    }
