package proyecto_farmacia;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class FRM_Reporte_Recetas extends javax.swing.JFrame {
    
    DefaultTableModel dmt = new DefaultTableModel();
    ConexionS_BD  ConexionS_BD;
    private boolean informacionVisible = false;
    
    public FRM_Reporte_Recetas() {
        
        setUndecorated(true);
        initComponents();
        
        setLocationRelativeTo(null);

         ConexionS_BD = new ConexionS_BD();

        dmt = new DefaultTableModel(
                new String[]{
                    "Personal emisor",
                    "Área del personal",
                    "Diagnóstico",
                    "Medicamentos diferentes",
                    "Unidades prescritas",
                    "Fecha de emisión"
                },
                0
        );

        jTable_Reporte.setModel(dmt);
        jLabel_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        getContentPane().setLayout(new java.awt.GridBagLayout());
        getContentPane().add(jPanel1);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_Titulo = new javax.swing.JLabel();
        jButton_Info = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Reporte = new javax.swing.JTable();
        jButton_Cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel_Titulo.setText("REPORTE DE RECETAS");
        jPanel1.add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        jButton_Info.setText("Mostrar Información");
        jButton_Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InfoActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 40));

        jTable_Reporte.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_Reporte);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 1000, 260));

        jButton_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.jpeg"))); // NOI18N
        jButton_Cerrar.setText("CERRAR REPORTE");
        jButton_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CerrarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 430, 220, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1060, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InfoActionPerformed
        if (informacionVisible) {
            dmt.setRowCount(0);
            informacionVisible = false;
            jButton_Info.setText("Mostrar Información");
            return;
        }
        String sql = "SELECT * FROM Vista_Analisis_Recetas_Prescritas " + "ORDER BY fecha_emision DESC";
        try {
            Connection con = ConexionS_BD.getConexion();
            try (PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
                dmt.setRowCount(0);
                while (rs.next()) {
                    Object[] fila = {rs.getString("nombres_personal_emisor"), rs.getString("area_personal"), rs.getString("diagnostico"), rs.getInt("cantidad_medicamentos_diferentes_recetados"), rs.getInt("unidades_totales_prescritas"), rs.getDate("fecha_emision")};
                    dmt.addRow(fila);
                }
            }
            informacionVisible = true;
            jButton_Info.setText("Ocultar Información");
            if (dmt.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No hay prescripciones médicas registradas para mostrar.", "Reporte de recetas", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al consultar las prescripciones: " + e.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
        }
          
    }//GEN-LAST:event_jButton_InfoActionPerformed

    private void jButton_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CerrarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar el formulario?",
            "Confirmar salida",
            JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Cerrar conexión si tienes un método cerrarConexion()
                ConexionS_BD.cerrarConexion();
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());

            }
            // Cierra el formulario actual
            dispose(); // o this.dispose() si estás dentro del formulario
        }
    }//GEN-LAST:event_jButton_CerrarActionPerformed

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
            java.util.logging.Logger.getLogger(FRM_Reporte_Recetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_Reporte_Recetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_Reporte_Recetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_Reporte_Recetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_Reporte_Recetas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cerrar;
    private javax.swing.JButton jButton_Info;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Reporte;
    // End of variables declaration//GEN-END:variables
}
