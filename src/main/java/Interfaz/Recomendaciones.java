package Interfaz;

import Clases.Figura;
import Clases.Usuario;
import Conexion.Conexion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import javax.swing.JOptionPane;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class Recomendaciones extends javax.swing.JFrame {

    private TableRowSorter<DefaultTableModel> rowSorter;
    private Usuario usuario;
    private ArrayList<Figura> figuras = new ArrayList<>();

    public Recomendaciones(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        setComponentProperties();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        rowSorter = new TableRowSorter<>(model);
        table.setRowSorter(rowSorter);
    }

    public final void setComponentProperties() {

        ImageIcon homeLogo = new ImageIcon("house-solid.png");
        homeIcon.setText("");
        homeIcon.setIcon(homeLogo);
        homeIcon.setBounds(100, 100, homeIcon.getPreferredSize().width, homeIcon.getPreferredSize().height);

        ImageIcon bellLogo = new ImageIcon("bell-regular.png");
        bellIcon.setText("");
        bellIcon.setIcon(bellLogo);
        bellIcon.setBounds(100, 100, bellIcon.getPreferredSize().width, bellIcon.getPreferredSize().height);

        ImageIcon userLogo = new ImageIcon("circle-user-regular.png");
        userIcon.setText("");
        userIcon.setIcon(userLogo);
        userIcon.setBounds(100, 100, userIcon.getPreferredSize().width, userIcon.getPreferredSize().height);

        configureRoundedBorder(searchTxt, Color.WHITE, 12, 10);
        title.setText(usuario.getIntereses().get(0));
        setTableProperties();

    }

    private void configureRoundedBorder(JComponent component, Color color, int radius, int thickness) {
        LineBorder roundBorder = new LineBorder(color, thickness) {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(getLineColor());

                RoundRectangle2D roundRect = new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius, radius);
                g2d.draw(roundRect);
            }
        };
        component.setBorder(roundBorder);
    }

    private void setTableProperties() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
        table.setRowSorter(rowSorter);

        JTableHeader tHeader = table.getTableHeader();
        table.setBackground(Color.WHITE);

        tHeader.setBackground(Color.decode("#011627"));
        tHeader.setForeground(Color.WHITE);
        tHeader.setFont(new Font("Roboto", Font.BOLD, 24));

        MutablePair<ArrayList<Figura>, Usuario> resultado = (MutablePair<ArrayList<Figura>, Usuario>) obtenerFiguras();

        figuras = resultado.getLeft();
        Object rowData[] = new Object[8];

        for (Figura figura : figuras) {
            rowData[0] = figura.getNumeroSerie();
            rowData[1] = figura.getNombre();
            rowData[2] = figura.getMarca();
            rowData[3] = figura.getFechaAdquisicion();
            rowData[4] = figura.getEstado();
            rowData[5] = figura.getTamanio();
            rowData[6] = figura.getCategoria();
            rowData[7] = figura.getValor();

            model.addRow(rowData);
        }
    }

    private Pair<ArrayList<Figura>, Usuario> obtenerFiguras() {
        Conexion conexion = new Conexion();
        ArrayList<Figura> coleccion = new ArrayList<>();
        Usuario usuario1 = new Usuario();
        Pair<ArrayList<Figura>, Usuario> resultado = new MutablePair<>();
        String sql = "SELECT nombre, numeroSerie, fechaAdquisicion, tamaño, precio, categoria, estado, marca, usuario FROM figuras WHERE usuario != ? AND categoria = ?";

        try (PreparedStatement ps = conexion.establecerConexion().prepareStatement(sql)) {

            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getIntereses().get(0));
            ResultSet figurasRs = ps.executeQuery();

            while (figurasRs.next()) {
                Figura figura = new Figura();

                figura.setNombre(figurasRs.getString("nombre"));
                figura.setNumeroSerie(figurasRs.getString("numeroSerie"));
                figura.setFechaAdquisicion(figurasRs.getDate("fechaAdquisicion").toLocalDate());
                figura.setTamanio(figurasRs.getDouble("tamaño"));
                figura.setValor(figurasRs.getDouble("precio"));
                figura.setCategoria(figurasRs.getString("categoria"));
                figura.setEstado(figurasRs.getString("estado"));
                figura.setMarca(figurasRs.getString("marca"));
                usuario1.setUsername(figurasRs.getString("usuario"));
                coleccion.add(figura);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos" + e.getMessage());
        }

        resultado = new MutablePair<>(coleccion, usuario1);

        return resultado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        navBar = new javax.swing.JPanel();
        TEST = new javax.swing.JTextField();
        searchTxt = new javax.swing.JTextField();
        lblRecomendaciones = new javax.swing.JLabel();
        lblNoticiasYEventos = new javax.swing.JLabel();
        lblMisFiguras = new javax.swing.JLabel();
        homeIcon = new javax.swing.JLabel();
        bellIcon = new javax.swing.JLabel();
        userIcon = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        title = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1280, 830));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 830));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(1280, 830));
        bg.setPreferredSize(new java.awt.Dimension(1280, 830));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navBar.setBackground(new java.awt.Color(1, 22, 39));
        navBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TEST.setBackground(new java.awt.Color(1, 22, 39));
        TEST.setForeground(new java.awt.Color(204, 204, 204));
        TEST.setBorder(null);
        navBar.add(TEST, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 110, 20));

        searchTxt.setBackground(new java.awt.Color(1, 22, 39));
        searchTxt.setForeground(new java.awt.Color(204, 204, 204));
        searchTxt.setText("Buscar figuras");
        searchTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        searchTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTxtFocusLost(evt);
            }
        });
        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
        });
        navBar.add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 30, 590, 40));

        lblRecomendaciones.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lblRecomendaciones.setForeground(new java.awt.Color(255, 255, 255));
        lblRecomendaciones.setText("Recomendaciones");
        lblRecomendaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navBar.add(lblRecomendaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 40, 139, 22));

        lblNoticiasYEventos.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lblNoticiasYEventos.setForeground(new java.awt.Color(255, 255, 255));
        lblNoticiasYEventos.setText("Noticias y Eventos");
        lblNoticiasYEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navBar.add(lblNoticiasYEventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(749, 40, 137, 22));

        lblMisFiguras.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lblMisFiguras.setForeground(new java.awt.Color(255, 255, 255));
        lblMisFiguras.setText("Mis figuras");
        lblMisFiguras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMisFiguras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMisFigurasMouseClicked(evt);
            }
        });
        navBar.add(lblMisFiguras, new org.netbeans.lib.awtextra.AbsoluteConstraints(896, 40, 84, 22));

        homeIcon.setText("jLabel1");
        homeIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeIconMouseClicked(evt);
            }
        });
        navBar.add(homeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        bellIcon.setText("jLabel1");
        bellIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navBar.add(bellIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 30, -1, -1));

        userIcon.setText("jLabel1");
        userIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userIconMouseClicked(evt);
            }
        });
        navBar.add(userIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, -1, -1));

        bg.add(navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 100));

        table.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Serie", "Nombre", "Marca", "Fecha", "Estado", "Tamaño", "Categoría", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(30);
        jScrollPane2.setViewportView(table);

        bg.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 935, 580));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(1, 22, 39));
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 440, 60));

        title1.setBackground(new java.awt.Color(255, 255, 255));
        title1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        title1.setForeground(new java.awt.Color(1, 22, 39));
        title1.setText("Recomendaciones basada en tu interés");
        bg.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void lblMisFigurasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMisFigurasMouseClicked
        new MisFiguras(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblMisFigurasMouseClicked

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
    }//GEN-LAST:event_searchTxtKeyReleased

    private void searchTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTxtFocusGained
        if (searchTxt.getText().equals("Buscar figuras")) {
            searchTxt.setText("");
            searchTxt.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_searchTxtFocusGained

    private void searchTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTxtFocusLost
        if (searchTxt.getText().isEmpty()) {
            searchTxt.setText("Buscar figuras");
            searchTxt.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_searchTxtFocusLost

    private void userIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userIconMouseClicked
        new Perfil(usuario, usuario.getColeccion()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_userIconMouseClicked

    private void homeIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeIconMouseClicked
        new Inicio2(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeIconMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = new Usuario();
                new Recomendaciones(usuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TEST;
    private javax.swing.JLabel bellIcon;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMisFiguras;
    private javax.swing.JLabel lblNoticiasYEventos;
    private javax.swing.JLabel lblRecomendaciones;
    private javax.swing.JPanel navBar;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTable table;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel userIcon;
    // End of variables declaration//GEN-END:variables
}
