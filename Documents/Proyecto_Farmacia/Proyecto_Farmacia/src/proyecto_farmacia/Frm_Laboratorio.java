
package proyecto_farmacia;
import java.sql.*; // Librerias para conexion con MySQL
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.DefaultTableModel; // Para trabajar con JTable
import javax.swing.JOptionPane;
public class Frm_Laboratorio extends javax.swing.JFrame {
    /*Modelo para mostrar datos en la tabla*/
    DefaultTableModel modeloTablaLaboratorio = new DefaultTableModel();

    //Objeto para mostrar datos en la tabla
    //Objetivo de conexion a la base de datos (versión instanciada)*/
    ConexionS_BD conexionS_BD;

    public Frm_Laboratorio() {
        
        initComponents(); //Inicializa lso componentes visuales
        /*Centrar*/
        this.setLocationRelativeTo(this);

        txtcodigoLaboratorio.setEnabled(true);
        BTN_GuardarLabortorio.setEnabled(true);
        BTN_ModificarLabortorio.setEnabled(true);

        // Crear la conexion al iniciar el formulario
        conexionS_BD = new ConexionS_BD();

        if (conexionS_BD.getConexion() == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar con la base de datos.",
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
            return; // Evita continuar si no hay conexion
        }
        
        // 1. Definimos la cadena exacta del placeholder para evitar confusiones
        String placeholderText = "Buscar Código , Nombre o RUC...";

        // 2. Configuración inicial del Placeholder
        TXT_BuscarLabortorio.setText(placeholderText);
        TXT_BuscarLabortorio.setForeground(new java.awt.Color(153, 153, 153)); // Color gris tenue

        TXT_BuscarLabortorio.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                // Si el texto actual es exactamente el placeholder, se limpia y se pone color negro
                if (TXT_BuscarLabortorio.getText().equals(placeholderText)) {
                    TXT_BuscarLabortorio.setText("");
                    TXT_BuscarLabortorio.setForeground(new java.awt.Color(0, 0, 0)); // Color negro para escribir
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                // Si el usuario sale y la caja queda vacía, vuelve a aparecer el texto guía
                if (TXT_BuscarLabortorio.getText().trim().isEmpty()) {
                    TXT_BuscarLabortorio.setText(placeholderText);
                    TXT_BuscarLabortorio.setForeground(new java.awt.Color(153, 153, 153));
                }
            }
        });
        // Definir los encabezados de la tabla
        String titulos[] = {"id", "nombre", "ruc", "direccion", "telefono", "correo"};
        // Asignar los titulos al modelo
        modeloTablaLaboratorio.setColumnIdentifiers(titulos);
        // Establecer el modelo a la JTable
        JTABLE_Mant_Labortorio.setModel(modeloTablaLaboratorio);

        //Deshabilitar campo de codigo (solo lo mostrara, no se escribe)
        txtcodigoLaboratorio.setEnabled(false);
    }   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcodigoLaboratorio = new javax.swing.JTextField();
        txtCorreoLaboratorio = new javax.swing.JTextField();
        BTN_VerLaboratorio = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtnombreLaboratorio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDireccionLaboratorio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtRucLaboratorio1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTelefonoLaboratorio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTABLE_Mant_Labortorio = new javax.swing.JTable();
        BTN_NuevoLabortorio = new javax.swing.JButton();
        BTN_GuardarLabortorio = new javax.swing.JButton();
        BTN_ModificarLabortorio = new javax.swing.JButton();
        BTN_EXCEL_Labortorio = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        TXT_BuscarLabortorio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cerrar_Labortorio = new javax.swing.JButton();
        BTN_PDF_Labortorio = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MANTENIMIENTO DE LABORATORIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Codigo Laboratorio");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Correo Laboratorio");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        txtcodigoLaboratorio.setEditable(false);
        txtcodigoLaboratorio.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigoLaboratorio.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtcodigoLaboratorio.setForeground(new java.awt.Color(0, 0, 204));
        txtcodigoLaboratorio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcodigoLaboratorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtcodigoLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 330, 30));

        txtCorreoLaboratorio.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtCorreoLaboratorio.setForeground(new java.awt.Color(0, 0, 204));
        txtCorreoLaboratorio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreoLaboratorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCorreoLaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoLaboratorioKeyTyped(evt);
            }
        });
        jPanel1.add(txtCorreoLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 240, 30));

        BTN_VerLaboratorio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_VerLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hoja.jpeg"))); // NOI18N
        BTN_VerLaboratorio.setText("VER LABORATORIOS");
        BTN_VerLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VerLaboratorioActionPerformed(evt);
            }
        });
        jPanel1.add(BTN_VerLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 220, 70));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Nombre Laboratorio");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtnombreLaboratorio.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtnombreLaboratorio.setForeground(new java.awt.Color(0, 0, 204));
        txtnombreLaboratorio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnombreLaboratorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtnombreLaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreLaboratorioKeyTyped(evt);
            }
        });
        jPanel1.add(txtnombreLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 59, 330, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Dirección Laboratorio");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        txtDireccionLaboratorio.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtDireccionLaboratorio.setForeground(new java.awt.Color(0, 0, 204));
        txtDireccionLaboratorio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccionLaboratorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDireccionLaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionLaboratorioKeyTyped(evt);
            }
        });
        jPanel1.add(txtDireccionLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 330, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Ruc Laboratorio");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txtRucLaboratorio1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtRucLaboratorio1.setForeground(new java.awt.Color(0, 0, 204));
        txtRucLaboratorio1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRucLaboratorio1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtRucLaboratorio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucLaboratorio1KeyTyped(evt);
            }
        });
        jPanel1.add(txtRucLaboratorio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 330, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Telefono Laboratorio");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        txtTelefonoLaboratorio.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtTelefonoLaboratorio.setForeground(new java.awt.Color(0, 0, 204));
        txtTelefonoLaboratorio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefonoLaboratorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTelefonoLaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoLaboratorioKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefonoLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 240, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 930, 220));

        JTABLE_Mant_Labortorio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JTABLE_Mant_Labortorio.setForeground(new java.awt.Color(0, 0, 204));
        JTABLE_Mant_Labortorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Direccion", "Ruc", "Telefono", "Correo"
            }
        ));
        JTABLE_Mant_Labortorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTABLE_Mant_LabortorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTABLE_Mant_Labortorio);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 940, 260));

        BTN_NuevoLabortorio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_NuevoLabortorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        BTN_NuevoLabortorio.setText("NUEVO");
        BTN_NuevoLabortorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NuevoLabortorioActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_NuevoLabortorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 190, 50));

        BTN_GuardarLabortorio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_GuardarLabortorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar (2).png"))); // NOI18N
        BTN_GuardarLabortorio.setText("GUARDAR");
        BTN_GuardarLabortorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_GuardarLabortorioMouseClicked(evt);
            }
        });
        BTN_GuardarLabortorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GuardarLabortorioActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_GuardarLabortorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 190, 50));

        BTN_ModificarLabortorio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_ModificarLabortorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        BTN_ModificarLabortorio.setText("MODIFICAR");
        BTN_ModificarLabortorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_ModificarLabortorioMouseClicked(evt);
            }
        });
        BTN_ModificarLabortorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModificarLabortorioActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_ModificarLabortorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 200, 50));

        BTN_EXCEL_Labortorio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_EXCEL_Labortorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.jpeg"))); // NOI18N
        BTN_EXCEL_Labortorio.setText("Exportar");
        BTN_EXCEL_Labortorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EXCEL_LabortorioActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_EXCEL_Labortorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 640, 120, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingresar el Nombre del Laboratorio");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        TXT_BuscarLabortorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarLabortorioActionPerformed(evt);
            }
        });
        TXT_BuscarLabortorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarLabortorioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXT_BuscarLabortorioKeyTyped(evt);
            }
        });
        jPanel2.add(TXT_BuscarLabortorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 460, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.jpeg"))); // NOI18N
        jLabel5.setText("BUSCAR");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 940, 50));

        BTN_Cerrar_Labortorio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_Cerrar_Labortorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        BTN_Cerrar_Labortorio.setText("Cerrar");
        BTN_Cerrar_Labortorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Cerrar_LabortorioActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_Cerrar_Labortorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 640, 130, 40));

        BTN_PDF_Labortorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.jpeg"))); // NOI18N
        BTN_PDF_Labortorio.setText("Exportar");
        BTN_PDF_Labortorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PDF_LabortorioActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_PDF_Labortorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 640, 120, 40));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoLaboratorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoLaboratorioKeyTyped

    }//GEN-LAST:event_txtCorreoLaboratorioKeyTyped

    private void BTN_VerLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VerLaboratorioActionPerformed
         this.MostrarLaboratorio();
    }//GEN-LAST:event_BTN_VerLaboratorioActionPerformed

    private void JTABLE_Mant_LabortorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTABLE_Mant_LabortorioMouseClicked
/*Obtener la fila seleccionada*/
        int filaseleccionada = JTABLE_Mant_Labortorio.getSelectedRow();
        if (filaseleccionada >= 0) {
            /*llenar los campos de texto con los datos de la fila*/
            String codigo = JTABLE_Mant_Labortorio.getValueAt(filaseleccionada, 0).toString();           
            String nombre = JTABLE_Mant_Labortorio.getValueAt(filaseleccionada, 1).toString();
            String direccion =JTABLE_Mant_Labortorio.getValueAt(filaseleccionada, 2).toString();
            String ruc =JTABLE_Mant_Labortorio.getValueAt(filaseleccionada, 3).toString();         
            String telefono =JTABLE_Mant_Labortorio.getValueAt(filaseleccionada, 4).toString();
            String correo =JTABLE_Mant_Labortorio.getValueAt(filaseleccionada, 5).toString();
            
            
            txtcodigoLaboratorio.setText(codigo);
            txtnombreLaboratorio.setText(nombre);
            txtDireccionLaboratorio.setText(direccion);
            txtRucLaboratorio1.setText(ruc);
            txtTelefonoLaboratorio.setText(telefono);
            txtCorreoLaboratorio.setText(correo);                  
            
            
            //Habilitar el campo para editar nombre
            txtnombreLaboratorio.setEnabled(true);
            txtRucLaboratorio1.setEnabled(true);
            txtDireccionLaboratorio.setEnabled(true);
            txtTelefonoLaboratorio.setEnabled(true);
            txtCorreoLaboratorio.setEnabled(true);
            //el campo que no se debe editar
            txtcodigoLaboratorio.setEnabled(false);

            /*Habilitar los botones relacionados*/
            BTN_ModificarLabortorio.setEnabled(true);
            /*Opcional: deshabilitar boton guardar */
            BTN_GuardarLabortorio.setEnabled(false);

        }
    }//GEN-LAST:event_JTABLE_Mant_LabortorioMouseClicked

    private void BTN_NuevoLabortorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NuevoLabortorioActionPerformed
      /*Limpia ls cajas de texto*/
        txtcodigoLaboratorio.setText("");
        txtnombreLaboratorio.setText(" ");
        txtRucLaboratorio1.setText(" ");
        txtDireccionLaboratorio.setText(" ");
        txtTelefonoLaboratorio.setText(" ");
        txtCorreoLaboratorio.setText("");

        /*Enviar el curso a la caja de texto: txtnombreFacultad*/
        txtcodigoLaboratorio.requestFocus();     
        txtnombreLaboratorio.setEnabled(true);
        txtRucLaboratorio1.setEnabled(true);
        txtDireccionLaboratorio.setEnabled(true);
        txtTelefonoLaboratorio.setEnabled(true);
        txtCorreoLaboratorio.setEnabled(true);
        

        /*HABILITA EL BOTON GUARDAR*/
        BTN_GuardarLabortorio.setEnabled(true);
        BTN_ModificarLabortorio.setEnabled(false);
       
        
    }//GEN-LAST:event_BTN_NuevoLabortorioActionPerformed

    private void BTN_GuardarLabortorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_GuardarLabortorioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_GuardarLabortorioMouseClicked

    private void BTN_GuardarLabortorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarLabortorioActionPerformed
        // 1. Validar que el campo no esté vacío        
        String Nombre = txtnombreLaboratorio.getText().trim();
        String Ruc = txtRucLaboratorio1.getText().trim();
        String Direccion = txtDireccionLaboratorio.getText().trim();
        String Telefono = txtTelefonoLaboratorio.getText().trim();
        String Correo = txtCorreoLaboratorio.getText().trim();

        // 2. Validar nombre
        if (Nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del Laboratorio", "Campo requerido", JOptionPane.WARNING_MESSAGE
            );
            txtnombreLaboratorio.requestFocus();
            return;
        } // 3. Validar Ruc
        if (Ruc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el Ruc del Laboratorio", "Campo requerido", JOptionPane.WARNING_MESSAGE
            );
            txtRucLaboratorio1.requestFocus();
            return;
        }// 4. Validar  Direccion
        if (Direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el DNI  del Laboratorio", "Campo requerido", JOptionPane.WARNING_MESSAGE
            );
            txtDireccionLaboratorio.requestFocus();
            return;

        }// 5. Validar  teléfono
        if (Telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la teléfono   del Laboratorio", "Campo requerido", JOptionPane.WARNING_MESSAGE
            );
            txtTelefonoLaboratorio.requestFocus();
            return;
        }
        // 6. Validar  correo
        if (Correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el correo   del Laboratorio", "Campo requerido", JOptionPane.WARNING_MESSAGE
            );
            txtCorreoLaboratorio.requestFocus();
            return;
        }

        // Confirmar si el usuario desea guardar
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea guardar el registro del Laboratorio?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            try {
                // 3. Llamar al método para insertar
                conexionS_BD.insertarLaboratorio(Nombre, Ruc, Direccion, Telefono, Correo);
                // 4. Mostrar mensaje de éxito

                JOptionPane.showMessageDialog(this, "Laboratorio registrado correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                //5. Actualizar tabla y limpiar campos
                // Limpiar campos
                txtcodigoLaboratorio.setText("");
                txtnombreLaboratorio.setText("");
                txtRucLaboratorio1.setText("");
                txtDireccionLaboratorio.setText("");
                txtTelefonoLaboratorio.setText("");
                txtCorreoLaboratorio.setText("");

                BTN_GuardarLabortorio.setEnabled(true);
                BTN_ModificarLabortorio.setEnabled(false);

                this.MostrarLaboratorio();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al registrar Laboratorio:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
            }

        }


    }//GEN-LAST:event_BTN_GuardarLabortorioActionPerformed

    private void BTN_ModificarLabortorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModificarLabortorioActionPerformed
     // Validar que se haya seleccionado un registro
        String codStr = txtcodigoLaboratorio.getText().trim();
        String NuevoNombre = txtnombreLaboratorio.getText().trim();
        String NuevoRuc = txtRucLaboratorio1.getText().trim();
        String NuevoDireccion = txtDireccionLaboratorio.getText().trim();
        String NuevoTelefono = txtTelefonoLaboratorio.getText().trim();
        String NuevoCorreo = txtCorreoLaboratorio.getText().trim();
        
        
        // VALIDAR TODOS LOS CAMPOS
        if (codStr.isEmpty() || NuevoNombre.isEmpty() || NuevoRuc.isEmpty() ||
        NuevoDireccion.isEmpty() ||NuevoTelefono.isEmpty()||  NuevoCorreo.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Seleccione una laboratorio y complete el nuevo nombre", "Campo requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }
         // CONVERTIR EL CÓDIGO DEL CLIENTE
        int codigo ;
        try {
            codigo=Integer.parseInt(codStr);
        }catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(
            this,
            "El código del laboratorio no es válido.",
            "Código incorrecto",
            JOptionPane.WARNING_MESSAGE
        );

        return;
        } 
        
        // Confirmación del usuario
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea modificar Laboratorio?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                 // MODIFICAR CLIENTE
                conexionS_BD.modificarLaboratorio(
                codigo,         
                NuevoNombre,
                NuevoRuc,
                NuevoDireccion,
                NuevoTelefono,
                NuevoCorreo);
                 // MENSAJE DE ÉXITO
                JOptionPane.showMessageDialog(this, "Laboratorio modificada correctamente", "Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);
                //Actualizar la tabla
                this.MostrarLaboratorio();
                
                // Limpia los campos de texto
                txtcodigoLaboratorio.setText("");
                txtnombreLaboratorio.setText("");
                txtRucLaboratorio1.setText(" ");
                txtDireccionLaboratorio.setText(" ");
                txtTelefonoLaboratorio.setText("");
                txtCorreoLaboratorio.setText(" ");
                
                //this.MostrarCliente();//metodo actualizar             
                BTN_ModificarLabortorio.setEnabled(true);
                BTN_GuardarLabortorio.setEnabled(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al modificar Laboratorio:\n" + ex.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_BTN_ModificarLabortorioActionPerformed

    private void BTN_EXCEL_LabortorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EXCEL_LabortorioActionPerformed

    }//GEN-LAST:event_BTN_EXCEL_LabortorioActionPerformed

    private void TXT_BuscarLabortorioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarLabortorioKeyReleased
     this.buscarLaboratorioGenral();
    }//GEN-LAST:event_TXT_BuscarLabortorioKeyReleased

    private void TXT_BuscarLabortorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarLabortorioKeyTyped

    }//GEN-LAST:event_TXT_BuscarLabortorioKeyTyped

    private void BTN_Cerrar_LabortorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Cerrar_LabortorioActionPerformed
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
    }//GEN-LAST:event_BTN_Cerrar_LabortorioActionPerformed

    private void BTN_PDF_LabortorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PDF_LabortorioActionPerformed

    }//GEN-LAST:event_BTN_PDF_LabortorioActionPerformed

    private void txtnombreLaboratorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreLaboratorioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreLaboratorioKeyTyped

    private void txtDireccionLaboratorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionLaboratorioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionLaboratorioKeyTyped

    private void txtRucLaboratorio1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucLaboratorio1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucLaboratorio1KeyTyped

    private void txtTelefonoLaboratorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoLaboratorioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoLaboratorioKeyTyped

    private void TXT_BuscarLabortorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarLabortorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarLabortorioActionPerformed

    private void BTN_ModificarLabortorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_ModificarLabortorioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_ModificarLabortorioMouseClicked

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
            java.util.logging.Logger.getLogger(Frm_Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Laboratorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cerrar_Labortorio;
    private javax.swing.JButton BTN_EXCEL_Labortorio;
    private javax.swing.JButton BTN_GuardarLabortorio;
    private javax.swing.JButton BTN_ModificarLabortorio;
    private javax.swing.JButton BTN_NuevoLabortorio;
    private javax.swing.JButton BTN_PDF_Labortorio;
    private javax.swing.JButton BTN_VerLaboratorio;
    private javax.swing.JTable JTABLE_Mant_Labortorio;
    private javax.swing.JTextField TXT_BuscarLabortorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtCorreoLaboratorio;
    private javax.swing.JTextField txtDireccionLaboratorio;
    private javax.swing.JTextField txtRucLaboratorio1;
    private javax.swing.JTextField txtTelefonoLaboratorio;
    private javax.swing.JTextField txtcodigoLaboratorio;
    private javax.swing.JTextField txtnombreLaboratorio;
    // End of variables declaration//GEN-END:variables
public void MostrarLaboratorio() {
        txtnombreLaboratorio.setEnabled(true);/*desactivar y activar nombreLaboratorio*/
        //Ordenar Asc, Desc
        JTABLE_Mant_Labortorio.setAutoCreateRowSorter(true);
        //Limpia la tabla antes de mostrar nuevos datos
        modeloTablaLaboratorio.setRowCount(0);
        try {
            //Llama al métdo que devuelve los datos de facultad
            ResultSet rs = conexionS_BD.listarLaboratorios();
            //Recorre cada fila del resultado y agrega a la tabla
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_laboratorio"),
                    rs.getString("nombre_laboratorio"),
                    rs.getString("ruc"),                    
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("correo"),};

                modeloTablaLaboratorio.addRow(fila);
            }
        } catch (SQLException e) {
            //Muestra mensaje si ocurre un error en la consulta
            JOptionPane.showMessageDialog(this, "Error al mostrar Laboratorio:\n" + e.getMessage(),
                    "Error de consulta", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarLaboratorioGenral() {
        // Limpia la tabla antes de mostrar los resultados filtrados
        modeloTablaLaboratorio.setRowCount(0);
        // obtiene el texto ingresado por el usuario
        String busqueda = TXT_BuscarLabortorio.getText().trim();
        try {
            // Consulta los datos usando el procedimiento almacenado en la BD
            ResultSet rs = conexionS_BD.buscarLaboratorios(busqueda);

            // Recorre los resultados y los anade a la tablal
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_laboratorio"),
                    rs.getString("nombre_laboratorio"),
                    rs.getString("ruc"),                    
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("correo")
                };
                modeloTablaLaboratorio.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al buscar Laboratorio: \n" + e.getMessage(),
                    "Error de busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }
}
