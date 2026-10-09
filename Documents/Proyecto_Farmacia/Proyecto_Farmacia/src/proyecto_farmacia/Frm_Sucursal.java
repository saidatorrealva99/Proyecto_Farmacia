
package proyecto_farmacia;
import java.sql.*; // Librerias para conexion con MySQL
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.DefaultTableModel; // Para trabajar con JTable
import javax.swing.JOptionPane;
public class Frm_Sucursal extends javax.swing.JFrame {
/*Modelo para mostrar datos en la tabla*/
    DefaultTableModel modeloTablaSucursal = new DefaultTableModel();

    //Objeto para mostrar datos en la tabla
    //Objetivo de conexion a la base de datos (versión instanciada)*/
    ConexionS_BD conexionS_BD;

    public Frm_Sucursal() {
        
        initComponents();
        /*Centrar*/
        this.setLocationRelativeTo(this);
        txtCodigoSucursal.setEnabled(true);
        BTN_GuardarSucursal.setEnabled(true);
        BTN_ModificarSucursal.setEnabled(true);
        // Crear la conexion al iniciar el formulario
        conexionS_BD = new ConexionS_BD();
        if (conexionS_BD.getConexion() == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar con la base de datos.",
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
            return; // Evita continuar si no hay conexion
        }
        
        // 1. Definimos la cadena exacta del placeholder para evitar confusiones
        String placeholderText = "Buscar Código o Sucursal...";

        // 2. Configuración inicial del Placeholder
        TXT_BuscarSucursal.setText(placeholderText);
        TXT_BuscarSucursal.setForeground(new java.awt.Color(153, 153, 153)); // Color gris tenue

        TXT_BuscarSucursal.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                // Si el texto actual es exactamente el placeholder, se limpia y se pone color negro
                if (TXT_BuscarSucursal.getText().equals(placeholderText)) {
                    TXT_BuscarSucursal.setText("");
                    TXT_BuscarSucursal.setForeground(new java.awt.Color(0, 0, 0)); // Color negro para escribir
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                // Si el usuario sale y la caja queda vacía, vuelve a aparecer el texto guía
                if (TXT_BuscarSucursal.getText().trim().isEmpty()) {
                    TXT_BuscarSucursal.setText(placeholderText);
                    TXT_BuscarSucursal.setForeground(new java.awt.Color(153, 153, 153));
                }
            }
        });
        // Definir los encabezados de la tabla
        String titulos[] = {"ID", "NOMBRE", "DIRECCION", "TELEFONO"};
        // Asignar los titulos al modelo
        modeloTablaSucursal.setColumnIdentifiers(titulos);
        // Establecer el modelo a la JTable
        JTABLE_Mant_Sucursal.setModel(modeloTablaSucursal);

        //Deshabilitar campo de codigo (solo lo mostrara, no se escribe)
        txtCodigoSucursal.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoSucursal = new javax.swing.JTextField();
        txtTelefonoSucursal = new javax.swing.JTextField();
        BTN_VerSucursal = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreSucursal = new javax.swing.JTextField();
        txtDireccionSucursal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Sucursal = new javax.swing.JTable();
        BTN_NuevoSucursal = new javax.swing.JButton();
        BTN_GuardarSucursal = new javax.swing.JButton();
        BTN_ModificarSucursal = new javax.swing.JButton();
        BTN_EXCELSucursal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarSucursal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_CerrarSucursal = new javax.swing.JButton();
        BTN_PDFSucursal = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE SUCURSAL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo Sucursal");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Telefono Sucursal");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtCodigoSucursal.setEditable(false);
        txtCodigoSucursal.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigoSucursal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtCodigoSucursal.setForeground(new java.awt.Color(0, 0, 204));
        txtCodigoSucursal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoSucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtCodigoSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 330, 30));

        txtTelefonoSucursal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtTelefonoSucursal.setForeground(new java.awt.Color(0, 0, 204));
        txtTelefonoSucursal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefonoSucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTelefonoSucursal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoSucursalKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefonoSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 330, 30));

        BTN_VerSucursal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoja.jpeg"))); // NOI18N
        BTN_VerSucursal.setText("VER SUCURSAL");
        BTN_VerSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerSucursalActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VerSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 180, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nombre Sucursal");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Direccion Sucursal");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtNombreSucursal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtNombreSucursal.setForeground(new java.awt.Color(0, 0, 204));
        txtNombreSucursal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreSucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNombreSucursal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreSucursalKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 59, 330, 30));

        txtDireccionSucursal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtDireccionSucursal.setForeground(new java.awt.Color(0, 0, 204));
        txtDireccionSucursal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccionSucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDireccionSucursal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionSucursalKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccionSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 330, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 790, 180));

        JTABLE_Mant_Sucursal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Sucursal.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Sucursal.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_Sucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_SucursalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Sucursal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 810, 220));

        BTN_NuevoSucursal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_NuevoSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        BTN_NuevoSucursal.setText("NUEVO");
        BTN_NuevoSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoSucursalActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_NuevoSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 190, 50));

        BTN_GuardarSucursal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_GuardarSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar (2).png"))); // NOI18N
        BTN_GuardarSucursal.setText("GUARDAR");
        BTN_GuardarSucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GuardarSucursalMouseClicked(evt);
            }
        });
        BTN_GuardarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GuardarSucursalActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_GuardarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 190, 50));

        BTN_ModificarSucursal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_ModificarSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_ModificarSucursal.setText("MODIFICAR");
        BTN_ModificarSucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_ModificarSucursalMouseClicked(evt);
            }
        });
        BTN_ModificarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarSucursalActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_ModificarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 200, 50));

        BTN_EXCELSucursal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCELSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.jpeg"))); // NOI18N
        BTN_EXCELSucursal.setText("Exportar");
        BTN_EXCELSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCELSucursalActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_EXCELSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 580, 120, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Nombre de la Sucursal");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        TXT_BuscarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarSucursalActionPerformed(evt);
            }
        });
        TXT_BuscarSucursal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarSucursalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarSucursalKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 290, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.jpeg"))); // NOI18N
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 810, 50));

        BTN_CerrarSucursal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_CerrarSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_CerrarSucursal.setText("Cerrar");
        BTN_CerrarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CerrarSucursalActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_CerrarSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, 130, 40));

        BTN_PDFSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.jpeg"))); // NOI18N
        BTN_PDFSucursal.setText("Exportar");
        BTN_PDFSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDFSucursalActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_PDFSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, 120, 40));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoSucursalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoSucursalKeyTyped

    }//GEN-LAST:event_txtTelefonoSucursalKeyTyped

    private void BTN_VerSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerSucursalActionPerformed
this.MostrarSucursal();
    }//GEN-LAST:event_BTN_VerSucursalActionPerformed

    private void JTABLE_Mant_SucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_SucursalMouseClicked
/*Obtener la fila seleccionada*/
        int filaseleccionada = JTABLE_Mant_Sucursal.getSelectedRow();
        if (filaseleccionada >= 0) {
            /*llenar los campos de texto con los datos de la fila*/
            String codigo = JTABLE_Mant_Sucursal.getValueAt(filaseleccionada, 0).toString();           
            String nombre = JTABLE_Mant_Sucursal.getValueAt(filaseleccionada, 1).toString();
            String direccion =JTABLE_Mant_Sucursal.getValueAt(filaseleccionada, 2).toString();
            String telefono =JTABLE_Mant_Sucursal.getValueAt(filaseleccionada, 3).toString();
            
            txtCodigoSucursal.setText(codigo);
            txtNombreSucursal.setText(nombre);
            txtDireccionSucursal.setText(direccion);
            txtTelefonoSucursal.setText(telefono);         
            
            
            //Habilitar el campo para editar nombre
            txtNombreSucursal.setEnabled(true);
            txtDireccionSucursal.setEnabled(true);
            txtTelefonoSucursal.setEnabled(true);

            //el campo que no se debe editar
            txtCodigoSucursal.setEnabled(false);

            /*Habilitar los botones relacionados*/
            BTN_ModificarSucursal.setEnabled(true);

            /*Opcional: deshabilitar boton guardar */
            BTN_GuardarSucursal.setEnabled(false);

        }
    }//GEN-LAST:event_JTABLE_Mant_SucursalMouseClicked

    private void BTN_NuevoSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoSucursalActionPerformed
 /*Limpia ls cajas de texto*/
        txtCodigoSucursal.setText("");
        txtNombreSucursal.setText(" ");
        txtDireccionSucursal.setText(" ");
        txtTelefonoSucursal.setText("");

        /*Enviar el curso a la caja de texto: txtnombreFacultad*/
        txtCodigoSucursal.requestFocus();     
        txtNombreSucursal.setEnabled(true);
        txtDireccionSucursal.setEnabled(true);
        txtTelefonoSucursal.setEnabled(true);

        /*HABILITA EL BOTON GUARDAR*/
        BTN_GuardarSucursal.setEnabled(true);
        BTN_ModificarSucursal.setEnabled(false);

        
    }//GEN-LAST:event_BTN_NuevoSucursalActionPerformed

    private void BTN_GuardarSucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarSucursalMouseClicked
        // 1. Validar que el campo no esté vacío
        String nombre = txtNombreSucursal.getText().trim();
        String direccion = txtDireccionSucursal.getText().trim();
        String telefono =txtTelefonoSucursal.getText().trim();
        
        // 2. Validar nombre
    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Ingrese el nombre del Sucursal","Campo requerido",  JOptionPane.WARNING_MESSAGE
        );
        txtNombreSucursal.requestFocus();
        return;
    } // 3. Validar Direccion
    if (direccion.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Ingrese el apellido del Sucursal","Campo requerido",  JOptionPane.WARNING_MESSAGE
        );
        txtDireccionSucursal.requestFocus();
        return;
    }// 4. Validar  Telefono
    if (telefono.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Ingrese el DNI  del Sucursal","Campo requerido",  JOptionPane.WARNING_MESSAGE
        );
        txtTelefonoSucursal.requestFocus();
        return;
    
    }
    
        // 2. Confirmar si el usuario desea guardar
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea guardar el registro del Sucursal?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            try {
                // 3. Llamar al método para insertar
                conexionS_BD.insertarSucursal(nombre, direccion,  telefono);
                // 4. Mostrar mensaje de éxito

                JOptionPane.showMessageDialog(this, "Sucursal registrado correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                //5. Actualizar tabla y limpiar campos
                this.MostrarSucursal();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al registrar Sucursal:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
            }

        }
        
    }//GEN-LAST:event_BTN_GuardarSucursalMouseClicked

    private void BTN_GuardarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarSucursalActionPerformed
// 1. Validar que el campo no esté vacío
        String nombre = txtNombreSucursal.getText().trim();
        String direccion = txtDireccionSucursal.getText().trim();
        String telefono = txtTelefonoSucursal.getText().trim();
        
        // 1. Validar nombre
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre de la facultad", "Campo requerido", JOptionPane.WARNING_MESSAGE);
            txtNombreSucursal.requestFocus();
            return;
        }// 2. Validar  dirección 
    if (direccion.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Ingrese la dirección  del Sucursal","Campo requerido",  JOptionPane.WARNING_MESSAGE
        );
        txtDireccionSucursal.requestFocus();
        return;
    }// 3. Validar  teléfono
    if (telefono.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Ingrese la teléfono   del Sucursal","Campo requerido",  JOptionPane.WARNING_MESSAGE
        );
        txtTelefonoSucursal.requestFocus();
        return;
    }
        // 2. Confirmar si el usuario desea guardar
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea guardar el registro de Sucursal?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            try {
                // 3. Llamar al método para insertar
                conexionS_BD.insertarSucursal(nombre, direccion, telefono);
                // 4. Mostrar mensaje de éxito

                JOptionPane.showMessageDialog(this, "Facultad registrada correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                //5. Actualizar tabla y limpiar campos
                this.MostrarSucursal();
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(this, "Error al registrar sucursal:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_BTN_GuardarSucursalActionPerformed

    private void BTN_ModificarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarSucursalActionPerformed
    // Validar que se haya seleccionado un registro
        String codStr = txtCodigoSucursal.getText().trim();
        String NuevoNombre = txtNombreSucursal.getText().trim();
        String NuevaDireccion = txtDireccionSucursal.getText().trim();
        String NuevoTelefono = txtTelefonoSucursal.getText().trim();
        
        // VALIDAR TODOS LOS CAMPOS
        if (codStr.isEmpty() || NuevoNombre.isEmpty()|| NuevaDireccion.isEmpty() ||NuevoTelefono.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Seleccione una Sucursal y complete el nuevo nombre", "Campo requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }
         // CONVERTIR EL CÓDIGO DEL Sucursal
        int codigo ;
        try {
            codigo=Integer.parseInt(codStr);
        }catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
            this,
            "El código del Sucursal no es válido.",
            "Código incorrecto",
            JOptionPane.WARNING_MESSAGE
        );

        return;
        } 
        
        // Confirmación del usuario
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea modificar Sucursal?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                 // MODIFICAR Sucursal
                conexionS_BD.modificarSucursal(
                codigo,
                NuevoNombre,
                NuevaDireccion,
                NuevoTelefono);
                 // MENSAJE DE ÉXITO
                JOptionPane.showMessageDialog(this, "Sucursal modificada correctamente", "Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);
                //Actualizar la tabla
                this.MostrarSucursal();
                
                // Limpia los campos de texto
                txtCodigoSucursal.setText("");
                txtNombreSucursal.setText("");
                txtDireccionSucursal.setText("");
                txtTelefonoSucursal.setText(" ");
                
                //this.MostrarCliente();//metodo actualizar
                BTN_ModificarSucursal.setEnabled(true);
                BTN_GuardarSucursal.setEnabled(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al modificar Sucursal:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_BTN_ModificarSucursalActionPerformed

    private void BTN_EXCELSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELSucursalActionPerformed

    }//GEN-LAST:event_BTN_EXCELSucursalActionPerformed

    private void TXT_BuscarSucursalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarSucursalKeyReleased
this.buscarSucursalGenral();
    }//GEN-LAST:event_TXT_BuscarSucursalKeyReleased

    private void TXT_BuscarSucursalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarSucursalKeyTyped

    }//GEN-LAST:event_TXT_BuscarSucursalKeyTyped

    private void BTN_CerrarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CerrarSucursalActionPerformed
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
    }//GEN-LAST:event_BTN_CerrarSucursalActionPerformed

    private void BTN_PDFSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDFSucursalActionPerformed

    }//GEN-LAST:event_BTN_PDFSucursalActionPerformed

    private void txtNombreSucursalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreSucursalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreSucursalKeyTyped

    private void txtDireccionSucursalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionSucursalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionSucursalKeyTyped

    private void TXT_BuscarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarSucursalActionPerformed

    private void BTN_ModificarSucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_ModificarSucursalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_ModificarSucursalMouseClicked

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
            java.util.logging.Logger.getLogger(Frm_Sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Sucursal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Sucursal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CerrarSucursal;
    private javax.swing.JButton BTN_EXCELSucursal;
    private javax.swing.JButton BTN_GuardarSucursal;
    private javax.swing.JButton BTN_ModificarSucursal;
    private javax.swing.JButton BTN_NuevoSucursal;
    private javax.swing.JButton BTN_PDFSucursal;
    private javax.swing.JButton BTN_VerSucursal;
    private javax.swing.JTable JTABLE_Mant_Sucursal;
    private javax.swing.JTextField TXT_BuscarSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtCodigoSucursal;
    private javax.swing.JTextField txtDireccionSucursal;
    private javax.swing.JTextField txtNombreSucursal;
    private javax.swing.JTextField txtTelefonoSucursal;
    // End of variables declaration//GEN-END:variables
public void MostrarSucursal() {
        txtNombreSucursal.setEnabled(true);/*desactivar y activar nombreSucursal*/
        //Ordenar Asc, Desc
        JTABLE_Mant_Sucursal.setAutoCreateRowSorter(true);
        //Limpia la tabla antes de mostrar nuevos datos
        modeloTablaSucursal.setRowCount(0);
        try {
            //Llama al métdo que devuelve los datos de facultad
            ResultSet rs = conexionS_BD.listarSucursales();
            //Recorre cada fila del resultado y agrega a la tabla
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_sucursal"),
                    rs.getString("nombre_sucursal"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),};

                modeloTablaSucursal.addRow(fila);
            }
        } catch (SQLException e) {
            //Muestra mensaje si ocurre un error en la consulta
            JOptionPane.showMessageDialog(this, "Error al mostrar Sucursal:\n" + e.getMessage(),
                    "Error de consulta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarSucursalGenral() {
        // Limpia la tabla antes de mostrar los resultados filtrados
        modeloTablaSucursal.setRowCount(0);
        // obtiene el texto ingresado por el usuario
        String busqueda = TXT_BuscarSucursal.getText().trim();
        try {
            // Consulta los datos usando el procedimiento almacenado en la BD
            ResultSet rs = conexionS_BD.buscarSucursales(busqueda);

            // Recorre los resultados y los anade a la tablal
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_sucursal"),
                    rs.getString("nombre_sucursal"),
                    rs.getString("direccion"),
                    rs.getString("telefono")
                };
                modeloTablaSucursal.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar Sucursal: \n" + e.getMessage(),
                    "Error de busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

}
