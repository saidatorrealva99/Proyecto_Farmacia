package proyecto_farmacia;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

public class Frm_MenuPrincipal_Farmacia extends javax.swing.JFrame {

    // =====================================================================
    // 1. VARIABLES DE LA CLASE
    // =====================================================================
    private static final int ANCHO_SIDEBAR = 225;
    private static final Color COLOR_NARANJA = new Color(255, 103, 0);

    private final List<ItemMenu> itemsMenu = new ArrayList<>();
    private ItemMenu itemConfig, itemSalir;

    private JLabel lblFecha, lblHora, lblUsuario, lblRol;
    private javax.swing.Timer relojTimer;
    private Point mouseInicio, ventanaInicio;

    private JPanel panelContenido;
    private JLabel lblBienvenida;

    private Image imgLogoSuperior;
    private Image imgBannerBienvenida;
    private Image imgLogoInferior;

    // =====================================================================
    // 2. CONSTRUCTOR Y CARGA MULTI-RUTA DE IMÁGENES
    // =====================================================================
    public Frm_MenuPrincipal_Farmacia() {
        setUndecorated(true);
        cargarImagenes();
        initComponents();

        configurarLayout();
        armarSidebar();
        armarHeader();
        armarContenido();

        setLocationRelativeTo(null);
    }

    private void cargarImagenes() {
        imgLogoSuperior = buscarImagen("Mifarma_icono.png");
        imgBannerBienvenida = buscarImagen("mifarma_Lateral.jpeg");
        imgLogoInferior = buscarImagen("Mifarma_Abajo.jpeg");
    }

    private Image buscarImagen(String nombreArchivo) {
        String[] rutasPosibles = {
            "/proyecto_farmacia/img/" + nombreArchivo,
            "/proyecto_farmacia/" + nombreArchivo,
            "src/proyecto_farmacia/img/" + nombreArchivo,
            "src/proyecto_farmacia/" + nombreArchivo,
            "img/" + nombreArchivo,
            nombreArchivo
        };

        for (String ruta : rutasPosibles) {
            try {
                if (ruta.startsWith("/")) {
                    java.net.URL url = getClass().getResource(ruta);
                    if (url != null) {
                        return new ImageIcon(url).getImage();
                    }
                } else {
                    File archivo = new File(ruta);
                    if (archivo.exists()) {
                        return ImageIO.read(archivo);
                    }
                }
            } catch (Exception ignored) {
            }
        }
        System.err.println("No se pudo encontrar la imagen: " + nombreArchivo);
        return null;
    }

    // =====================================================================
    // 3. CÓDIGO GENERADO POR NETBEANS
    // =====================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSidebar_Izquierda = new javax.swing.JPanel();
        jPanelHeader = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelSidebar_Izquierda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelSidebar_IzquierdaLayout = new javax.swing.GroupLayout(jPanelSidebar_Izquierda);
        jPanelSidebar_Izquierda.setLayout(jPanelSidebar_IzquierdaLayout);
        jPanelSidebar_IzquierdaLayout.setHorizontalGroup(
            jPanelSidebar_IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        jPanelSidebar_IzquierdaLayout.setVerticalGroup(
            jPanelSidebar_IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 746, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelSidebar_Izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 750));

        jPanelHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1266, Short.MAX_VALUE)
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1270, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Frm_MenuPrincipal_Farmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_MenuPrincipal_Farmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_MenuPrincipal_Farmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_MenuPrincipal_Farmacia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_MenuPrincipal_Farmacia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelSidebar_Izquierda;
    // End of variables declaration//GEN-END:variables
 // =====================================================================
    // 5. LAYOUT GENERAL
    // =====================================================================
    private void configurarLayout() {
        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(243, 246, 251));

        jPanelSidebar_Izquierda = new PanelSidebar();
        jPanelSidebar_Izquierda.setPreferredSize(new Dimension(ANCHO_SIDEBAR, 0));

        JPanel derecha = new JPanel(new BorderLayout());
        derecha.setBackground(new Color(243, 246, 251));

        panelContenido = new PanelDashboard();
        panelContenido.setLayout(new GridBagLayout());
        panelContenido.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        derecha.add(jPanelHeader, BorderLayout.NORTH);
        derecha.add(panelContenido, BorderLayout.CENTER);

        getContentPane().add(jPanelSidebar_Izquierda, BorderLayout.WEST);
        getContentPane().add(derecha, BorderLayout.CENTER);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private class PanelSidebar extends JPanel {

        public PanelSidebar() {
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, getWidth(), getHeight());

            int hSide = getHeight();
            int y = Math.max(0, hSide - 110);

            if (imgLogoInferior != null) {
                g2.drawImage(imgLogoInferior, 0, y, getWidth(), hSide - y, this);
            } else {
                g2.setColor(COLOR_NARANJA);
                g2.fillRect(0, y, getWidth(), hSide - y);

                g2.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2.setColor(new Color(255, 205, 0));
                g2.drawArc(-50, y - 40, 240, 90, 10, 110);
                g2.setColor(new Color(55, 180, 75));
                g2.drawArc(-20, y - 30, 210, 80, 15, 95);
            }

            g2.dispose();
        }

        @Override
        public void doLayout() {
            super.doLayout();
            ubicarInferiores();
        }
    }

    // =====================================================================
    // 6. SIDEBAR
    // =====================================================================
    private void armarSidebar() {
        JPanel p = jPanelSidebar_Izquierda;
        p.removeAll();
        itemsMenu.clear();

        int anchoItem = ANCHO_SIDEBAR - 24;

        JPanel panelLogo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setFont(new Font("Segoe UI", Font.BOLD, 22));
                g2.setColor(COLOR_NARANJA);
                g2.drawString("Mifarma", 8, 30);

                if (imgLogoSuperior != null) {
                    g2.drawImage(imgLogoSuperior, 105, 6, 32, 32, this);
                } else {
                    int cx = 110, cy = 10;
                    g2.setColor(new Color(55, 180, 75));
                    g2.fillRoundRect(cx + 6, cy, 8, 22, 3, 3);
                    g2.fillRoundRect(cx, cy + 6, 22, 8, 3, 3);
                }

                g2.setFont(new Font("Segoe UI", Font.ITALIC, 9));
                g2.setColor(new Color(120, 130, 140));
                g2.drawString("Tu salud, nuestra prioridad", 8, 44);

                g2.dispose();
            }
        };
        panelLogo.setOpaque(false);
        p.add(panelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 190, 50));

        JPanel linea = new JPanel();
        linea.setBackground(new Color(230, 235, 240));
        p.add(linea, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 68, anchoItem, 1));

        Object[][] datos = {
            {"Inicio", FontAwesomeSolid.HOME, true},
            {"Productos", FontAwesomeSolid.PILLS, false},
            {"Clientes", FontAwesomeSolid.USERS, false},
            {"Ventas", FontAwesomeSolid.SHOPPING_CART, false},
            {"Compras", FontAwesomeSolid.SHOPPING_BAG, false},
            {"Inventario", FontAwesomeSolid.CUBES, false},
            {"Proveedores", FontAwesomeSolid.TRUCK, false},
            {"Sucursales", FontAwesomeSolid.STORE, false},
            {"Reportes", FontAwesomeSolid.CHART_BAR, false}
        };

        int y = 78;
        for (Object[] d : datos) {
            final String texto = (String) d[0];
            final boolean esInicio = (boolean) d[2];
            final ItemMenu it = new ItemMenu(texto, (FontAwesomeSolid) d[1], esInicio);
            it.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    seleccionar(it);
                    abrirModulo(texto);
                }
            });
            itemsMenu.add(it);
            p.add(it, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, y, anchoItem, 38));
            y += 42;
        }

        itemsMenu.get(0).setSeleccionado(true);

        itemConfig = new ItemMenu("Configuración", FontAwesomeSolid.COG, false);
        itemSalir = new ItemMenu("Cerrar Sesión", FontAwesomeSolid.POWER_OFF, false);

        itemConfig.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirModulo("Configuración");
            }
        });
        itemSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cerrarSesion();
            }
        });

        p.add(itemConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 580, anchoItem, 38));
        p.add(itemSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 624, anchoItem, 38));

        p.revalidate();
        p.repaint();
    }

    private void ubicarInferiores() {
        if (itemConfig == null || itemSalir == null) {
            return;
        }
        int h = jPanelSidebar_Izquierda.getHeight();
        int ancho = ANCHO_SIDEBAR - 24;
        itemConfig.setBounds(12, h - 90, ancho, 38);
        itemSalir.setBounds(12, h - 46, ancho, 38);
    }

    private void seleccionar(ItemMenu elegido) {
        for (ItemMenu it : itemsMenu) {
            it.setSeleccionado(it == elegido);
        }
    }

    private void abrirModulo(String nombre) {
        try {
            switch (nombre) {
                case "Compras":
                    JOptionPane.showMessageDialog(this, "Abriendo módulo de Compras...");
                    break;
                case "Productos":
                    JOptionPane.showMessageDialog(this, "Abriendo módulo de Productos...");
                    break;
                case "Clientes":
                    JOptionPane.showMessageDialog(this, "Abriendo módulo de Clientes...");
                    break;
                case "Ventas":
                    JOptionPane.showMessageDialog(this, "Abriendo módulo de Ventas...");
                    break;
                case "Inventario":
                    JOptionPane.showMessageDialog(this, "Abriendo módulo de Inventario...");
                    break;
                case "Proveedores":
                    JOptionPane.showMessageDialog(this, "Abriendo módulo de Proveedores...");
                    break;
                case "Sucursales":
                    JOptionPane.showMessageDialog(this, "Abriendo módulo de Sucursales...");
                    break;
                case "Reportes":
                    JOptionPane.showMessageDialog(this, "Abriendo módulo de Reportes...");
                    break;
                case "Configuración":
                    JOptionPane.showMessageDialog(this, "Abriendo Configuración...");
                    break;
                case "Inicio":
                    armarContenido();
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "El módulo " + nombre + " no está disponible.");
                    break;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al abrir el módulo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cerrarSesion() {
        int r = JOptionPane.showConfirmDialog(this, "¿Deseas cerrar sesión?",
                "Cerrar sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (r == JOptionPane.YES_OPTION) {
            dispose();
        }
    }

    private class ItemMenu extends JComponent {

        private final String texto;
        private final FontAwesomeSolid ico;
        private final boolean esInicio;
        private boolean seleccionado = false;
        private boolean hover = false;

        ItemMenu(String texto, FontAwesomeSolid ico, boolean esInicio) {
            this.texto = texto;
            this.ico = ico;
            this.esInicio = esInicio;
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    hover = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    hover = false;
                    repaint();
                }
            });
        }

        void setSeleccionado(boolean s) {
            seleccionado = s;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            if (seleccionado) {
                g2.setColor(COLOR_NARANJA);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
            } else if (hover) {
                g2.setColor(new Color(255, 242, 230));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
            }

            Color colorTexto = seleccionado ? Color.WHITE : new Color(71, 85, 105);
            Icon iconoPintar = FontIcon.of(ico, 16, colorTexto);

            int iy = (getHeight() - iconoPintar.getIconHeight()) / 2;
            iconoPintar.paintIcon(this, g2, 14, iy);

            g2.setFont(new Font("Segoe UI", seleccionado ? Font.BOLD : Font.PLAIN, 13));
            g2.setColor(colorTexto);
            FontMetrics fm = g2.getFontMetrics();
            int ty = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
            g2.drawString(texto, 44, ty);

            if (!texto.equals("Cerrar Sesión")) {
                FontIcon flecha = FontIcon.of(
                        esInicio ? FontAwesomeSolid.CHEVRON_DOWN : FontAwesomeSolid.CHEVRON_RIGHT,
                        10,
                        colorTexto
                );
                flecha.paintIcon(this, g2, getWidth() - 20, (getHeight() - flecha.getIconHeight()) / 2);
            }

            g2.dispose();
        }
    }

    // =====================================================================
    // 7. HEADER
    // =====================================================================
    private void armarHeader() {
        JPanel h = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(COLOR_NARANJA);
                g2.fillRect(0, 0, getWidth(), getHeight());

                g2.setColor(new Color(255, 255, 255, 30));
                g2.setStroke(new BasicStroke(1.5f));
                int w = getWidth();
                g2.drawLine(w / 2 - 100, 10, w / 2, 10);
                g2.drawLine(w / 2, 10, w / 2 + 40, 30);
                g2.drawOval(w / 2 + 40, 28, 5, 5);

                g2.drawLine(w / 2 - 40, 25, w / 2 + 80, 25);
                g2.drawOval(w / 2 + 80, 23, 5, 5);

                g2.dispose();
            }
        };

        h.setLayout(new BorderLayout());
        h.setPreferredSize(new Dimension(0, 60));
        h.setBorder(BorderFactory.createEmptyBorder(0, 16, 0, 8));

        JPanel izq = new JPanel(new GridBagLayout());
        izq.setOpaque(false);

        JLabel titulo = new JLabel("Sistema de Gestión de Farmacia");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel subtitulo = new JLabel("Administración y control de la cadena de farmacias Mifarma");
        subtitulo.setForeground(new Color(255, 230, 210));
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JPanel textos = new JPanel();
        textos.setOpaque(false);
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
        textos.add(titulo);
        textos.add(subtitulo);

        izq.add(textos);
        h.add(izq, BorderLayout.WEST);

        JPanel der = new JPanel(new GridBagLayout());
        der.setOpaque(false);
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;

        JLabel icoCal = new JLabel(FontIcon.of(FontAwesomeSolid.CALENDAR_ALT, 22, Color.WHITE));
        lblFecha = new JLabel();
        lblFecha.setForeground(Color.WHITE);
        lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblHora = new JLabel();
        lblHora.setForeground(new Color(255, 230, 210));
        lblHora.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JPanel fechaHora = new JPanel();
        fechaHora.setOpaque(false);
        fechaHora.setLayout(new BoxLayout(fechaHora, BoxLayout.Y_AXIS));
        fechaHora.add(lblFecha);
        fechaHora.add(lblHora);

        JLabel avatar = new JLabel(FontIcon.of(FontAwesomeSolid.USER_CIRCLE, 34, Color.WHITE));
        lblUsuario = new JLabel("admin");
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblRol = new JLabel("Administrador");
        lblRol.setForeground(new Color(255, 230, 210));
        lblRol.setFont(new Font("Segoe UI", Font.PLAIN, 11));

        JPanel datosUsuario = new JPanel();
        datosUsuario.setOpaque(false);
        datosUsuario.setLayout(new BoxLayout(datosUsuario, BoxLayout.Y_AXIS));
        datosUsuario.add(lblUsuario);
        datosUsuario.add(lblRol);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        botones.setOpaque(false);
        botones.add(new BotonVentana(FontAwesomeSolid.MINUS, new Color(255, 255, 255, 40), () -> setExtendedState(JFrame.ICONIFIED)));
        botones.add(new BotonVentana(FontAwesomeSolid.WINDOW_MAXIMIZE, new Color(255, 255, 255, 40), this::alternarMaximizado));
        botones.add(new BotonVentana(FontAwesomeSolid.TIMES, new Color(220, 38, 38), () -> System.exit(0)));

        c.gridx = 0;
        c.insets = new Insets(0, 0, 0, 8);
        der.add(icoCal, c);
        c.gridx = 1;
        c.insets = new Insets(0, 0, 0, 18);
        der.add(fechaHora, c);
        c.gridx = 2;
        c.insets = new Insets(0, 0, 0, 18);
        der.add(crearSeparadorVertical(), c);
        c.gridx = 3;
        c.insets = new Insets(0, 0, 0, 8);
        der.add(avatar, c);
        c.gridx = 4;
        c.insets = new Insets(0, 0, 0, 20);
        der.add(datosUsuario, c);
        c.gridx = 5;
        c.insets = new Insets(0, 0, 0, 0);
        c.anchor = GridBagConstraints.NORTHEAST;
        der.add(botones, c);

        h.add(der, BorderLayout.EAST);
        habilitarArrastre(h);
        iniciarReloj();

        jPanelHeader.removeAll();
        jPanelHeader.setLayout(new BorderLayout());
        jPanelHeader.add(h, BorderLayout.CENTER);
        jPanelHeader.revalidate();
        jPanelHeader.repaint();
    }

    private JComponent crearSeparadorVertical() {
        JPanel sep = new JPanel();
        sep.setBackground(new Color(255, 180, 120));
        sep.setPreferredSize(new Dimension(1, 32));
        return sep;
    }

    private void iniciarReloj() {
        final java.time.format.DateTimeFormatter fFecha = java.time.format.DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", new java.util.Locale("es", "PE"));
        final java.time.format.DateTimeFormatter fHora = java.time.format.DateTimeFormatter.ofPattern("hh:mm:ss a", new java.util.Locale("es", "PE"));

        Runnable actualizar = () -> {
            java.time.LocalDateTime ahora = java.time.LocalDateTime.now();
            lblFecha.setText(ahora.format(fFecha));
            lblHora.setText(ahora.format(fHora));
        };
        actualizar.run();
        relojTimer = new javax.swing.Timer(1000, e -> actualizar.run());
        relojTimer.start();
    }

    private void alternarMaximizado() {
        if ((getExtendedState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) {
            setExtendedState(JFrame.NORMAL);
            setSize(1200, 700);
            setLocationRelativeTo(null);
        } else {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }

    private void habilitarArrastre(JComponent zona) {
        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseInicio = e.getLocationOnScreen();
                ventanaInicio = getLocation();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if ((getExtendedState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) {
                    return;
                }
                Point p = e.getLocationOnScreen();
                setLocation(ventanaInicio.x + p.x - mouseInicio.x, ventanaInicio.y + p.y - mouseInicio.y);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    alternarMaximizado();
                }
            }
        };
        zona.addMouseListener(ma);
        zona.addMouseMotionListener(ma);
    }

    private class BotonVentana extends JComponent {

        private final Icon icono;
        private final Color colorHover;
        private boolean hover = false;

        BotonVentana(FontAwesomeSolid ico, Color colorHover, Runnable accion) {
            this.icono = FontIcon.of(ico, 11, Color.WHITE);
            this.colorHover = colorHover;
            setPreferredSize(new Dimension(36, 26));
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    hover = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    hover = false;
                    repaint();
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    accion.run();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            if (hover) {
                g2.setColor(colorHover);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
            icono.paintIcon(this, g2, (getWidth() - icono.getIconWidth()) / 2, (getHeight() - icono.getIconHeight()) / 2);
            g2.dispose();
        }
    }

    // =====================================================================
    // 8. CONTENIDO
    // =====================================================================
    private void armarContenido() {
        panelContenido.removeAll();

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.72;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(0, 0, 14, 14);
        panelContenido.add(crearTarjetaBienvenida(), c);

        GridBagConstraints e = new GridBagConstraints();
        e.gridx = 0;
        e.gridy = 1;
        e.weightx = 0.72;
        e.weighty = 0;
        e.fill = GridBagConstraints.HORIZONTAL;
        e.anchor = GridBagConstraints.NORTH;
        e.insets = new Insets(0, 0, 14, 14);
        panelContenido.add(crearFilaEstadisticas(), e);

        GridBagConstraints d = new GridBagConstraints();
        d.gridx = 1;
        d.gridy = 0;
        d.gridheight = 2;
        d.weightx = 0.28;
        d.weighty = 0;
        d.fill = GridBagConstraints.BOTH;
        d.anchor = GridBagConstraints.NORTH;
        d.insets = new Insets(0, 0, 14, 0);
        panelContenido.add(crearPanelAccesos(), d);

        GridBagConstraints relleno = new GridBagConstraints();
        relleno.gridx = 0;
        relleno.gridy = 2;
        relleno.gridwidth = 2;
        relleno.weighty = 1;
        relleno.fill = GridBagConstraints.BOTH;
        panelContenido.add(Box.createGlue(), relleno);

        panelContenido.revalidate();
        panelContenido.repaint();
    }

    private JPanel crearTarjetaBienvenida() {
        JPanel tarjeta = new TarjetaBienvenida();
        tarjeta.setLayout(new BorderLayout());
        tarjeta.setBorder(BorderFactory.createEmptyBorder(16, 20, 16, 20));
        tarjeta.setMinimumSize(new Dimension(300, 130));

        JPanel izq = new JPanel(new GridBagLayout());
        izq.setOpaque(false);
        izq.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 16));

        JLabel logoIcono = new JLabel(FontIcon.of(FontAwesomeSolid.PLUS_CIRCLE, 48, COLOR_NARANJA));
        izq.add(logoIcono);
        tarjeta.add(izq, BorderLayout.WEST);

        lblBienvenida = new JLabel("¡Bienvenido, admin!");
        lblBienvenida.setForeground(COLOR_NARANJA);
        lblBienvenida.setFont(new Font("Segoe UI", Font.BOLD, 22));

        JLabel linea1 = new JLabel("Gestiona la información de la cadena de farmacias Mifarma");
        JLabel linea2 = new JLabel("de manera eficiente y segura.");
        for (JLabel l : new JLabel[]{linea1, linea2}) {
            l.setForeground(new Color(100, 116, 139));
            l.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        }

        JPanel textos = new JPanel();
        textos.setOpaque(false);
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));
        textos.add(lblBienvenida);
        textos.add(Box.createVerticalStrut(4));
        textos.add(linea1);
        textos.add(linea2);

        JPanel centro = new JPanel(new GridBagLayout());
        centro.setOpaque(false);
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = 1;
        centro.add(textos, gc);
        tarjeta.add(centro, BorderLayout.CENTER);

        return tarjeta;
    }

    private class TarjetaBienvenida extends JPanel {

        TarjetaBienvenida() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Shape forma = new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 14, 14);

            g2.setColor(Color.WHITE);
            g2.fill(forma);

            g2.setClip(forma);

            int wBanner = Math.min(260, getWidth() / 2);
            int xBanner = getWidth() - wBanner;

            if (imgBannerBienvenida != null) {
                g2.drawImage(imgBannerBienvenida, xBanner, 0, wBanner, getHeight(), this);
            } else {
                GradientPaint gp = new GradientPaint(xBanner, 0, COLOR_NARANJA, getWidth(), 0, new Color(230, 70, 0));
                g2.setPaint(gp);
                g2.fillRect(xBanner, 0, wBanner, getHeight());

                if (wBanner > 140) {
                    g2.setFont(new Font("Segoe UI", Font.BOLD, 22));
                    g2.setColor(Color.WHITE);
                    g2.drawString("Mifarma", xBanner + 20, 58);
                }
            }

            g2.setClip(null);

            g2.setColor(new Color(226, 232, 240));
            g2.draw(forma);
            g2.dispose();
        }
    }

    private JPanel crearFilaEstadisticas() {
        JPanel p = new JPanel(new GridLayout(1, 4, 10, 0));
        p.setOpaque(false);

        p.add(crearCardStat("Total Clientes", "1,248", "↑ 5%", "Clientes registrados en el sistema", FontAwesomeSolid.USERS, COLOR_NARANJA));
        p.add(crearCardStat("Productos", "632", "↑ 3%", "Total de productos en stock", FontAwesomeSolid.PILLS, new Color(22, 163, 74)));
        p.add(crearCardStat("Ventas", "486", "↑ 7%", "Total de ventas registradas", FontAwesomeSolid.SHOPPING_CART, new Color(2, 132, 199)));
        p.add(crearCardStat("Compras", "142", "↑ 6%", "Total de compras registradas", FontAwesomeSolid.FILE_ALT, new Color(147, 51, 234)));

        return p;
    }

    private JPanel crearCardStat(String titulo, String valor, String porcentaje, String subtexto, FontAwesomeSolid ico, Color colorIco) {
        PanelRedondeado card = new PanelRedondeado();
        card.setLayout(new BorderLayout(6, 4));
        card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);

        JLabel iconLabel = new JLabel(FontIcon.of(ico, 16, Color.WHITE));
        JPanel iconBg = new JPanel(new GridBagLayout());
        iconBg.setBackground(colorIco);
        iconBg.setPreferredSize(new Dimension(30, 30));
        iconBg.add(iconLabel);

        JLabel lblTit = new JLabel(titulo);
        lblTit.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblTit.setForeground(new Color(30, 41, 59));
        lblTit.setBorder(BorderFactory.createEmptyBorder(0, 6, 0, 0));

        JLabel lblPorc = new JLabel(porcentaje);
        lblPorc.setFont(new Font("Segoe UI", Font.BOLD, 10));
        lblPorc.setForeground(new Color(22, 163, 74));

        top.add(iconBg, BorderLayout.WEST);
        top.add(lblTit, BorderLayout.CENTER);
        top.add(lblPorc, BorderLayout.EAST);

        JLabel lblVal = new JLabel(valor);
        lblVal.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblVal.setForeground(new Color(15, 23, 42));

        JLabel lblSub = new JLabel(subtexto);
        lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 9));
        lblSub.setForeground(new Color(148, 163, 184));

        JPanel centro = new JPanel();
        centro.setOpaque(false);
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.add(Box.createVerticalStrut(2));
        centro.add(lblVal);
        centro.add(Box.createVerticalStrut(2));
        centro.add(lblSub);

        card.add(top, BorderLayout.NORTH);
        card.add(centro, BorderLayout.CENTER);

        return card;
    }

    private JPanel crearPanelAccesos() {
        PanelRedondeado panel = new PanelRedondeado();
        panel.setLayout(new BorderLayout(0, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        JLabel titulo = new JLabel("Accesos rápidos", FontIcon.of(FontAwesomeSolid.BOLT, 16, COLOR_NARANJA), SwingConstants.LEFT);
        titulo.setIconTextGap(8);
        titulo.setForeground(new Color(30, 41, 59));
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JPanel grid = new JPanel(new GridLayout(2, 2, 8, 8));
        grid.setOpaque(false);

        JButton btnCliente = crearBotonAcceso("Registrar Cliente", FontAwesomeSolid.USER, COLOR_NARANJA);
        btnCliente.addActionListener(e -> abrirModulo("Clientes"));

        JButton btnProducto = crearBotonAcceso("Registrar Producto", FontAwesomeSolid.TAG, new Color(22, 163, 74));
        btnProducto.addActionListener(e -> abrirModulo("Productos"));

        JButton btnVenta = crearBotonAcceso("Nueva Venta", FontAwesomeSolid.SHOPPING_CART, new Color(2, 132, 199));
        btnVenta.addActionListener(e -> abrirModulo("Ventas"));

        JButton btnReporte = crearBotonAcceso("Generar Reportes", FontAwesomeSolid.FILE_ALT, new Color(147, 51, 234));
        btnReporte.addActionListener(e -> abrirModulo("Reportes"));

        grid.add(btnCliente);
        grid.add(btnProducto);
        grid.add(btnVenta);
        grid.add(btnReporte);

        panel.add(titulo, BorderLayout.NORTH);
        panel.add(grid, BorderLayout.CENTER);

        return panel;
    }

    private JButton crearBotonAcceso(String texto, FontAwesomeSolid ico, Color colorIco) {
        JButton btn = new JButton();
        btn.setLayout(new GridBagLayout());
        btn.setBackground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(6, 6, 6, 6)
        ));

        JLabel iconLabel = new JLabel(FontIcon.of(ico, 18, Color.WHITE));

        JPanel iconBg = new PanelIconoRedondeado(colorIco);
        iconBg.setOpaque(false);
        iconBg.setPreferredSize(new Dimension(34, 34));
        iconBg.setMinimumSize(new Dimension(34, 34));
        iconBg.setLayout(new GridBagLayout());
        iconBg.add(iconLabel);

        JLabel textLabel = new JLabel("<html><div style='text-align: center; line-height: 10px;'>" + texto.replaceAll(" ", "<br>") + "</div></html>");
        textLabel.setFont(new Font("Segoe UI", Font.BOLD, 10));
        textLabel.setForeground(new Color(30, 41, 59));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 6);
        btn.add(iconBg, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        btn.add(textLabel, gbc);

        return btn;
    }

    private class PanelIconoRedondeado extends JPanel {

        private final Color colorFondo;

        public PanelIconoRedondeado(Color color) {
            this.colorFondo = color;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(colorFondo);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
            g2.dispose();
        }
    }

    private class PanelRedondeado extends JPanel {

        PanelRedondeado() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Shape forma = new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 12, 12);
            g2.setColor(Color.WHITE);
            g2.fill(forma);

            g2.setColor(new Color(226, 232, 240));
            g2.draw(forma);
            g2.dispose();
        }
    }

    private class PanelDashboard extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();

            g2.setColor(new Color(255, 230, 210, 100));
            Path2D.Float p = new Path2D.Float();
            p.moveTo(w * 0.4, h);
            p.curveTo(w * 0.6, h - 80, w * 0.8, h - 20, w, h - 100);
            p.lineTo(w, h);
            p.closePath();
            g2.fill(p);

            g2.setColor(new Color(255, 205, 170, 70));
            Path2D.Float p2 = new Path2D.Float();
            p2.moveTo(w * 0.2, h);
            p2.curveTo(w * 0.5, h - 140, w * 0.8, h - 40, w, h - 180);
            p2.lineTo(w, h);
            p2.closePath();
            g2.fill(p2);

            int x = w - 340;
            int y = h - 100;

            if (x > 300 && y > 200) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.15f));

                g2.setFont(new Font("Segoe UI", Font.BOLD, 48));
                g2.setColor(new Color(30, 50, 90));
                g2.drawString("Mifarma", x, y + 50);

                int cx = x + 210, cy = y + 8;
                g2.setColor(new Color(30, 50, 90));
                g2.fillRoundRect(cx + 16, cy, 18, 50, 5, 5);
                g2.fillRoundRect(cx, cy + 16, 50, 18, 5, 5);

                g2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                g2.drawString("Tu salud, nuestra prioridad", x + 10, y + 78);
            }

            g2.dispose();
        }
    }
}
