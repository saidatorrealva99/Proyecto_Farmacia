package proyecto_farmacia;

import java.sql.*; // Librerias para conexion con MySQL
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.DefaultTableModel; // Para trabajar con JTable
import javax.swing.JOptionPane;

public class Frm_Cliente extends javax.swing.JFrame {
   

    /*Modelo para mostrar datos en la tabla*/
    DefaultTableModel modeloTablaCliente = new DefaultTableModel();

    //Objeto para mostrar datos en la tabla
    //Objetivo de conexion a la base de datos (versión instanciada)*/
    ConexionS_BD conexionS_BD;

    public Frm_Cliente() {
        initComponents(); //Inicializa lso componentes visuales
       /*Centrar*/
        this.setLocationRelativeTo(this);
        txtcodigocliente.setEnabled(true);
        BTN_Guardarcliente.setEnabled(true);
        //BTN_Desactivarcliente.setEnabled(true);
        BTN_Modificarcliente.setEnabled(true);

        // Crear la conexion al iniciar el formulario
        conexionS_BD = new ConexionS_BD();

        if (conexionS_BD.getConexion() == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar con la base de datos.",
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
            return; // Evita continuar si no hay conexion
        }
         // 1. Definimos la cadena exacta del placeholder para evitar confusiones
        String placeholderText = "Buscar Código , Nombre o DNI...";

        // 2. Configuración inicial del Placeholder
        TXT_Buscarcliente.setText(placeholderText);
        TXT_Buscarcliente.setForeground(new java.awt.Color(153, 153, 153)); // Color gris tenue

        TXT_Buscarcliente.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                // Si el texto actual es exactamente el placeholder, se limpia y se pone color negro
                if (TXT_Buscarcliente.getText().equals(placeholderText)) {
                    TXT_Buscarcliente.setText("");
                    TXT_Buscarcliente.setForeground(new java.awt.Color(0, 0, 0)); // Color negro para escribir
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                // Si el usuario sale y la caja queda vacía, vuelve a aparecer el texto guía
                if (TXT_Buscarcliente.getText().trim().isEmpty()) {
                    TXT_Buscarcliente.setText(placeholderText);
                    TXT_Buscarcliente.setForeground(new java.awt.Color(153, 153, 153));
                }
            }
        });
        // Definir los encabezados de la tabla
        String titulos[] = {"id", "nombre", "apellidos", "dni", "direccion", "telefono", "correo"};
        // Asignar los titulos al modelo
        modeloTablaCliente.setColumnIdentifiers(titulos);
        // Establecer el modelo a la JTable
        JTABLE_Mant_Clinte.setModel(modeloTablaCliente);

        //Deshabilitar campo de codigo (solo lo mostrara, no se escribe)
        txtcodigocliente.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        FRM_CLIENTE = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigocliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        BTN_Vercliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtApellidoCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtDniCliente = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtnombrecliente1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Clinte = new javax.swing.JTable();
        BTN_Nuevocliente = new javax.swing.JButton();
        BTN_Guardarcliente = new javax.swing.JButton();
        BTN_Modificarcliente = new javax.swing.JButton();
        BTN_EXCELcliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_Buscarcliente = new javax.swing.JTextField();
        jLupacliente = new javax.swing.JLabel();
        BTN_Cerrar1cliente = new javax.swing.JButton();
        BTN_PDFcliente = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FRM_CLIENTE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        FRM_CLIENTE.setText("MANTENIMIENTO DE CLIENTE");
        getContentPane().add(FRM_CLIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo Cliente");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Apellido Cliente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtcodigocliente.setEditable(false);
        txtcodigocliente.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigocliente.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigocliente.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigocliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigocliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigocliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 330, 30));

        txtTelefonoCliente.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtTelefonoCliente.setForeground(new java.awt.Color(0, 0, 204));
        txtTelefonoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefonoCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTelefonoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 170, 30));

        BTN_Vercliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Vercliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoja.jpeg"))); // NOI18N
        BTN_Vercliente.setText("VER CLIENTES");
        BTN_Vercliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerclienteActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_Vercliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 180, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Correo ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        txtApellidoCliente.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtApellidoCliente.setForeground(new java.awt.Color(0, 0, 204));
        txtApellidoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellidoCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtApellidoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtApellidoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 330, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Direccion ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Dni Cliente");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Telefono ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, -1));

        txtCorreo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(0, 0, 204));
        txtCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 290, 30));

        txtDniCliente.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtDniCliente.setForeground(new java.awt.Color(0, 0, 204));
        txtDniCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDniCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDniCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtDniCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 170, 30));

        txtDireccion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(0, 0, 204));
        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 330, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nombre Cliente");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtnombrecliente1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtnombrecliente1.setForeground(new java.awt.Color(0, 0, 204));
        txtnombrecliente1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombrecliente1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtnombrecliente1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombrecliente1KeyTyped(evt);
            }
        });
        jPanel1.add(txtnombrecliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 330, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 960, 190));

        JTABLE_Mant_Clinte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Clinte.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Clinte.setModel(new javax.swing.table.DefaultTableModel(
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
        JTABLE_Mant_Clinte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_ClinteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Clinte);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 980, 220));

        BTN_Nuevocliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Nuevocliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        BTN_Nuevocliente.setText("NUEVO");
        BTN_Nuevocliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoclienteActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Nuevocliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 190, 50));

        BTN_Guardarcliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Guardarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar (2).png"))); // NOI18N
        BTN_Guardarcliente.setText("GUARDAR");
        BTN_Guardarcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GuardarclienteMouseClicked(evt);
            }
        });
        BTN_Guardarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GuardarclienteActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Guardarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 190, 50));

        BTN_Modificarcliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Modificarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_Modificarcliente.setText("MODIFICAR");
        BTN_Modificarcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_ModificarclienteMouseClicked(evt);
            }
        });
        BTN_Modificarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarclienteActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Modificarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 200, 50));

        BTN_EXCELcliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCELcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.jpeg"))); // NOI18N
        BTN_EXCELcliente.setText("Exportar");
        BTN_EXCELcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCELclienteActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_EXCELcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, 120, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Nombre del cliente");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        TXT_Buscarcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TXT_BuscarclienteMouseClicked(evt);
            }
        });
        TXT_Buscarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarclienteActionPerformed(evt);
            }
        });
        TXT_Buscarcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarclienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarclienteKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_Buscarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 490, -1));

        jLupacliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLupacliente.setForeground(new java.awt.Color(255, 255, 255));
        jLupacliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.jpeg"))); // NOI18N
        jLupacliente.setText("BUSCAR");
        jPanel2.add(jLupacliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 980, 50));

        BTN_Cerrar1cliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar1cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_Cerrar1cliente.setText("Cerrar");
        BTN_Cerrar1cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Cerrar1clienteActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Cerrar1cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, 130, 40));

        BTN_PDFcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.jpeg"))); // NOI18N
        BTN_PDFcliente.setText("Exportar");
        BTN_PDFcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDFclienteActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_PDFcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 580, 120, 40));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoClienteKeyTyped

    }//GEN-LAST:event_txtTelefonoClienteKeyTyped

    private void BTN_VerclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerclienteActionPerformed
        this.MostrarCliente();
    }//GEN-LAST:event_BTN_VerclienteActionPerformed

    private void JTABLE_Mant_ClinteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_ClinteMouseClicked
        /*Obtener la fila seleccionada*/
        int filaseleccionada = JTABLE_Mant_Clinte.getSelectedRow();
        if (filaseleccionada >= 0) {
            /*llenar los campos de texto con los datos de la fila*/
            String codigo = JTABLE_Mant_Clinte.getValueAt(filaseleccionada, 0).toString();           
            String nombre = JTABLE_Mant_Clinte.getValueAt(filaseleccionada, 1).toString();
            String apellido =JTABLE_Mant_Clinte.getValueAt(filaseleccionada, 2).toString();
            String dni =JTABLE_Mant_Clinte.getValueAt(filaseleccionada, 3).toString();
            String direccion =JTABLE_Mant_Clinte.getValueAt(filaseleccionada, 4).toString();
            String telefono =JTABLE_Mant_Clinte.getValueAt(filaseleccionada, 5).toString();
            String correo =JTABLE_Mant_Clinte.getValueAt(filaseleccionada, 6).toString();
            
            txtcodigocliente.setText(codigo);
            txtnombrecliente1.setText(nombre);
            txtApellidoCliente.setText(apellido);
            txtDniCliente.setText(dni);
            txtDireccion.setText(direccion);
            txtTelefonoCliente.setText(telefono);
            txtCorreo.setText(correo);         
            
            
            //Habilitar el campo para editar nombre
            txtnombrecliente1.setEnabled(true);
            txtApellidoCliente.setEnabled(true);
            txtDireccion.setEnabled(true);
            txtCorreo.setEnabled(true);
            txtDniCliente.setEnabled(true);
            txtTelefonoCliente.setEnabled(true);
            //el campo que no se debe editar
            txtcodigocliente.setEnabled(false);

            /*Habilitar los botones relacionados*/
            BTN_Modificarcliente.setEnabled(true);
            //BTN_Desactivarcliente.setEnabled(true);
            /*Opcional: deshabilitar boton guardar */
            BTN_Guardarcliente.setEnabled(false);

        }
    }//GEN-LAST:event_JTABLE_Mant_ClinteMouseClicked

    private void BTN_NuevoclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoclienteActionPerformed
        /*Limpia ls cajas de texto*/
        txtcodigocliente.setText("");
        txtnombrecliente1.setText(" ");
        txtApellidoCliente.setText(" ");
        txtDniCliente.setText(" ");
        txtDireccion.setText(" ");
        txtTelefonoCliente.setText("");
        txtCorreo.setText(" ");

        /*Enviar el curso a la caja de texto: txtnombreFacultad*/
        txtcodigocliente.requestFocus();     
        txtnombrecliente1.setEnabled(true);
        txtApellidoCliente.setEnabled(true);
        txtDniCliente.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefonoCliente.setEnabled(true);
        txtCorreo.setEnabled(true);

        /*HABILITA EL BOTON GUARDAR*/
        BTN_Guardarcliente.setEnabled(true);
        //BTN_Desactivarcliente.setEnabled(false);
        BTN_Modificarcliente.setEnabled(false);
        //BTN_Desactivarcliente.setEnabled(false);

        
    }//GEN-LAST:event_BTN_NuevoclienteActionPerformed

    private void BTN_GuardarclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarclienteMouseClicked

    }//GEN-LAST:event_BTN_GuardarclienteMouseClicked

    private void BTN_GuardarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarclienteActionPerformed

        // 1. Validar que el campo no esté vacío
        String nombre = txtnombrecliente1.getText().trim();
        String apellido =txtApellidoCliente.getText().trim();
        String dni = txtDniCliente.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String telefono = txtTelefonoCliente.getText().trim();
        String correo = txtCorreo.getText().trim();
        
        // 2. Validar nombre
    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Ingrese el nombre del Cliente","Campo requerido",  JOptionPane.WARNING_MESSAGE
        );
        txtnombrecliente1.requestFocus();
        return;
    } // 3. Validar apellido
    if (apellido.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Ingrese el apellido del Cliente","Campo requerido",  JOptionPane.WARNING_MESSAGE
        );
        txtApellidoCliente.requestFocus();
        return;
    }// 4. Validar  DNI
    if (dni.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Ingrese el DNI  del Cliente","Campo requerido",  JOptionPane.WARNING_MESSAGE
        );
        txtDniCliente.requestFocus();
        return;
    }// 5. Validar  dirección 
    if (direccion.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Ingrese la dirección  del Cliente","Campo requerido",  JOptionPane.WARNING_MESSAGE
        );
        txtDireccion.requestFocus();
        return;
    }// 6. Validar  teléfono
    if (telefono.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Ingrese la teléfono   del Cliente","Campo requerido",  JOptionPane.WARNING_MESSAGE
        );
        txtTelefonoCliente.requestFocus();
        return;
    }
    // 7. Validar  correo
    if (correo.isEmpty()) {
        JOptionPane.showMessageDialog(this,"Ingrese el correo   del Cliente","Campo requerido",  JOptionPane.WARNING_MESSAGE
        );
        txtCorreo.requestFocus();
        return;
    }
    
    
        // 2. Confirmar si el usuario desea guardar
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea guardar el registro del cliente?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            try {
                // 3. Llamar al método para insertar
                conexionS_BD.insertarCliente(nombre, apellido, dni, direccion, telefono, correo);
                // 4. Mostrar mensaje de éxito

                JOptionPane.showMessageDialog(this, "Cliente registrado correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                //5. Actualizar tabla y limpiar campos
                this.MostrarCliente();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al registrar Cliente:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_BTN_GuardarclienteActionPerformed

    private void BTN_ModificarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarclienteActionPerformed
// Validar que se haya seleccionado un registro
        String codStr = txtcodigocliente.getText().trim();
        String NuevoNombre = txtnombrecliente1.getText().trim();
        String NuevoApellido = txtApellidoCliente.getText().trim();
        String NuevaDireccion = txtDireccion.getText().trim();
        String NuevoCorreo = txtCorreo.getText().trim();
        String NuevoDni = txtDniCliente.getText().trim();
        String NuevoTelefono = txtTelefonoCliente.getText().trim();
        
        // VALIDAR TODOS LOS CAMPOS
        if (codStr.isEmpty() || NuevoNombre.isEmpty() || NuevoApellido.isEmpty() ||
        NuevoDni.isEmpty() || NuevaDireccion.isEmpty() ||NuevoTelefono.isEmpty() ||
        NuevoCorreo.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Seleccione un Cliente y complete el nuevo nombre", "Campo requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }
         // CONVERTIR EL CÓDIGO DEL CLIENTE
        int codigo ;
        try {
            codigo=Integer.parseInt(codStr);
        }catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
            this,
            "El código del cliente no es válido.",
            "Código incorrecto",
            JOptionPane.WARNING_MESSAGE
        );

        return;
        } 
        
        // Confirmación del usuario
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea modificar Cliente?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                 // MODIFICAR CLIENTE
                conexionS_BD.modificarCliente(
                codigo,
                NuevoNombre,
                NuevoApellido,
                NuevoDni,
                NuevaDireccion,
                NuevoTelefono,
                NuevoCorreo);
                 // MENSAJE DE ÉXITO
                JOptionPane.showMessageDialog(this, "Facultad modificada correctamente", "Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);
                //Actualizar la tabla
                this.MostrarCliente();
                
                // Limpia los campos de texto
                txtcodigocliente.setText("");
                txtnombrecliente1.setText("");
                txtApellidoCliente.setText(" ");
                txtDireccion.setText(" ");
                txtCorreo.setText("");
                txtDniCliente.setText(" ");
                txtTelefonoCliente.setText(" ");
                
                //this.MostrarCliente();//metodo actualizar
               // BTN_Desactivarcliente.setEnabled(false);
                BTN_Modificarcliente.setEnabled(true);
                BTN_Guardarcliente.setEnabled(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al modificar cliente:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_BTN_ModificarclienteActionPerformed

    private void BTN_EXCELclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCELclienteActionPerformed

    }//GEN-LAST:event_BTN_EXCELclienteActionPerformed

    private void TXT_BuscarclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarclienteKeyReleased
        this.buscarClienteGenral();
    }//GEN-LAST:event_TXT_BuscarclienteKeyReleased

    private void TXT_BuscarclienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarclienteKeyTyped

    }//GEN-LAST:event_TXT_BuscarclienteKeyTyped

    private void BTN_Cerrar1clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Cerrar1clienteActionPerformed
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
    }//GEN-LAST:event_BTN_Cerrar1clienteActionPerformed

    private void BTN_PDFclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDFclienteActionPerformed

    }//GEN-LAST:event_BTN_PDFclienteActionPerformed

    private void txtApellidoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoClienteKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtDniClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniClienteKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtnombrecliente1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombrecliente1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombrecliente1KeyTyped

    private void TXT_BuscarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarclienteActionPerformed
      
    }//GEN-LAST:event_TXT_BuscarclienteActionPerformed

    private void BTN_ModificarclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_ModificarclienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_ModificarclienteMouseClicked

    private void TXT_BuscarclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TXT_BuscarclienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarclienteMouseClicked

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
            java.util.logging.Logger.getLogger(Frm_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar1cliente;
    private javax.swing.JButton BTN_EXCELcliente;
    private javax.swing.JButton BTN_Guardarcliente;
    private javax.swing.JButton BTN_Modificarcliente;
    private javax.swing.JButton BTN_Nuevocliente;
    private javax.swing.JButton BTN_PDFcliente;
    private javax.swing.JButton BTN_Vercliente;
    private javax.swing.JLabel FRM_CLIENTE;
    private javax.swing.JTable JTABLE_Mant_Clinte;
    private javax.swing.JTextField TXT_Buscarcliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLupacliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtcodigocliente;
    private javax.swing.JTextField txtnombrecliente1;
    // End of variables declaration//GEN-END:variables
public void MostrarCliente() {
        txtnombrecliente1.setEnabled(true);/*desactivar y activar nombreFacultad*/
        //Ordenar Asc, Desc
        JTABLE_Mant_Clinte.setAutoCreateRowSorter(true);
        //Limpia la tabla antes de mostrar nuevos datos
        modeloTablaCliente.setRowCount(0);
        try {
            //Llama al métdo que devuelve los datos de facultad
            ResultSet rs = conexionS_BD.listarClientes();
            //Recorre cada fila del resultado y agrega a la tabla
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_cliente"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("dni"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("correo"),};

                modeloTablaCliente.addRow(fila);
            }
        } catch (SQLException e) {
            //Muestra mensaje si ocurre un error en la consulta
            JOptionPane.showMessageDialog(this, "Error al mostrar Cliente:\n" + e.getMessage(),
                    "Error de consulta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarClienteGenral() {
        // Limpia la tabla antes de mostrar los resultados filtrados
        modeloTablaCliente.setRowCount(0);
        // obtiene el texto ingresado por el usuario
        String busqueda = TXT_Buscarcliente.getText().trim();
        try {
            // Consulta los datos usando el procedimiento almacenado en la BD
            ResultSet rs = conexionS_BD.buscarClientes(busqueda);

            // Recorre los resultados y los anade a la tablal
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_cliente"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("dni"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("correo")
                };
                modeloTablaCliente.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar cliente: \n" + e.getMessage(),
                    "Error de busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

}
