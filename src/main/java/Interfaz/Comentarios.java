package Interfaz;

import Clases.Comentario;
import Server.Server;
import Clases.Figura;
import Clases.Usuario;
import Conexion.Conexion;
import java.awt.Color;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;

public class Comentarios extends javax.swing.JFrame {

    private Usuario usuario;
    private Figura figura;
    private ArrayList<Comentario> listaComentarios = new ArrayList<>();

    public Comentarios() {
        Server.iniciarServidor();
        initComponents();
        setComponentProperties();
        init();

    }

    public Comentarios(Usuario usuario, Figura figura) {
        Server.iniciarServidor();
        this.figura = figura;
        this.usuario = usuario;
        initComponents();
        setComponentProperties();
        init();

    }

    private void init() {
        commentsSection.setLayout(new MigLayout("alignx center"));

        listaComentarios = obtenerComentarios();

        for (Comentario comentario : listaComentarios) {
            commentsSection.add(new CComentario("@" + comentario.getNombre().getUsername(), comentario.getContenido(), comentario.getFecha().toString()), "wrap");
        }
    }

    public ArrayList<Comentario> obtenerComentarios() {
        ArrayList<Comentario> comentarios = new ArrayList<>();
        Conexion conexion = new Conexion();

        String sql = "SELECT usuario, figuraAsociada, fecha, comentario FROM comentarios WHERE figuraAsociada = ?";

        try (Connection connection = conexion.establecerConexion(); PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, figura.getNumeroSerie());

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Comentario comentario = new Comentario();
                    Usuario usuarioComment = new Usuario();

                    usuarioComment.setUsername(rs.getString("usuario"));
                    comentario.setNombre(usuarioComment);
                    comentario.setContenido(rs.getString("comentario"));

                    java.sql.Date fechaSQL = rs.getDate("fecha");
                    if (fechaSQL != null) {
                        comentario.setFecha(fechaSQL.toLocalDate());
                    }

                    comentarios.add(comentario);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return comentarios;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public final void setComponentProperties() {
        ImageIcon logo1 = new ImageIcon("bell-regular.png");
        ImageIcon logo2 = new ImageIcon("circle-user-regular.png");
        ImageIcon logo3 = new ImageIcon("house-solid.png");

        lblIconoNotificaciones.setText("");
        lblIconoNotificaciones.setIcon(logo1);
        lblIconoNotificaciones.setBounds(50, 50, lblIconoNotificaciones.getPreferredSize().width, lblIconoNotificaciones.getPreferredSize().height);

        lblIconoPerfil.setText("");
        lblIconoPerfil.setIcon(logo2);
        lblIconoPerfil.setBounds(50, 50, lblIconoPerfil.getPreferredSize().width, lblIconoPerfil.getPreferredSize().height);

        lblIconoCasita.setText("");
        lblIconoCasita.setIcon(logo3);
        lblIconoCasita.setBounds(50, 50, lblIconoCasita.getPreferredSize().width, lblIconoCasita.getPreferredSize().height);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlWhiteBackground = new javax.swing.JPanel();
        pnlNavTab = new javax.swing.JPanel();
        searchTxt = new javax.swing.JTextField();
        lblNoticiasEventos = new javax.swing.JLabel();
        lblMisFiguras = new javax.swing.JLabel();
        lblRecomendaciones = new javax.swing.JLabel();
        lblIconoNotificaciones = new javax.swing.JLabel();
        lblIconoPerfil = new javax.swing.JLabel();
        lblIconoCasita = new javax.swing.JLabel();
        searchTxtField1 = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        commentsSection = new javax.swing.JLayeredPane();
        addComentario = new javax.swing.JButton();
        txtComment = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 830));
        setResizable(false);

        pnlWhiteBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlWhiteBackground.setPreferredSize(new java.awt.Dimension(1280, 830));
        pnlWhiteBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlNavTab.setBackground(new java.awt.Color(1, 22, 39));
        pnlNavTab.setMaximumSize(new java.awt.Dimension(1280, 100));
        pnlNavTab.setMinimumSize(new java.awt.Dimension(1280, 100));
        pnlNavTab.setPreferredSize(new java.awt.Dimension(1280, 100));

        searchTxt.setBackground(new java.awt.Color(1, 22, 39));
        searchTxt.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        searchTxt.setForeground(new java.awt.Color(226, 226, 226));
        searchTxt.setText("Buscar figuras");
        searchTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        searchTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTxtFocusLost(evt);
            }
        });

        lblNoticiasEventos.setBackground(new java.awt.Color(1, 22, 39));
        lblNoticiasEventos.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblNoticiasEventos.setForeground(new java.awt.Color(255, 255, 255));
        lblNoticiasEventos.setText("Noticias y Eventos");
        lblNoticiasEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblMisFiguras.setBackground(new java.awt.Color(1, 22, 39));
        lblMisFiguras.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblMisFiguras.setForeground(new java.awt.Color(255, 255, 255));
        lblMisFiguras.setText("Mis Figuras");
        lblMisFiguras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMisFiguras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMisFigurasMouseClicked(evt);
            }
        });

        lblRecomendaciones.setBackground(new java.awt.Color(1, 22, 39));
        lblRecomendaciones.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblRecomendaciones.setForeground(new java.awt.Color(255, 255, 255));
        lblRecomendaciones.setText("Recomendaciones");
        lblRecomendaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblIconoNotificaciones.setText("jLabel4");
        lblIconoNotificaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblIconoPerfil.setText("jLabel5");
        lblIconoPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIconoPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconoPerfilMouseClicked(evt);
            }
        });

        lblIconoCasita.setText("jLabel6");
        lblIconoCasita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIconoCasita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconoCasitaMouseClicked(evt);
            }
        });

        searchTxtField1.setBackground(new java.awt.Color(1, 22, 39));
        searchTxtField1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        searchTxtField1.setForeground(new java.awt.Color(226, 226, 226));
        searchTxtField1.setBorder(null);

        javax.swing.GroupLayout pnlNavTabLayout = new javax.swing.GroupLayout(pnlNavTab);
        pnlNavTab.setLayout(pnlNavTabLayout);
        pnlNavTabLayout.setHorizontalGroup(
            pnlNavTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavTabLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblIconoCasita)
                .addGap(26, 26, 26)
                .addGroup(pnlNavTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchTxtField1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlNavTabLayout.createSequentialGroup()
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNoticiasEventos)
                        .addGap(18, 18, 18)
                        .addComponent(lblMisFiguras)
                        .addGap(18, 18, 18)
                        .addComponent(lblRecomendaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIconoNotificaciones)
                        .addGap(18, 18, 18)
                        .addComponent(lblIconoPerfil)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnlNavTabLayout.setVerticalGroup(
            pnlNavTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavTabLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(searchTxtField1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlNavTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNoticiasEventos)
                    .addComponent(lblMisFiguras)
                    .addComponent(lblRecomendaciones)
                    .addComponent(lblIconoNotificaciones)
                    .addComponent(lblIconoPerfil)
                    .addComponent(lblIconoCasita))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pnlWhiteBackground.add(pnlNavTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 100));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        title.setForeground(new java.awt.Color(1, 22, 39));
        title.setText("Comentarios");
        pnlWhiteBackground.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 60));

        addComentario.setBackground(new java.awt.Color(1, 22, 39));
        addComentario.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        addComentario.setForeground(new java.awt.Color(255, 255, 255));
        addComentario.setText("Enviar");
        addComentario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addComentario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addComentarioMouseClicked(evt);
            }
        });
        addComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addComentarioActionPerformed(evt);
            }
        });

        txtComment.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtComment.setText("Deja tu comentario");
        txtComment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtComment.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCommentFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCommentFocusLost(evt);
            }
        });

        commentsSection.setLayer(addComentario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        commentsSection.setLayer(txtComment, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout commentsSectionLayout = new javax.swing.GroupLayout(commentsSection);
        commentsSection.setLayout(commentsSectionLayout);
        commentsSectionLayout.setHorizontalGroup(
            commentsSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commentsSectionLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(addComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        commentsSectionLayout.setVerticalGroup(
            commentsSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commentsSectionLayout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addGroup(commentsSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(321, Short.MAX_VALUE))
        );

        pnlWhiteBackground.add(commentsSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1290, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWhiteBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWhiteBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void lblMisFigurasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMisFigurasMouseClicked
        new MisFiguras(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblMisFigurasMouseClicked

    private void addComentarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addComentarioMouseClicked

        Comentario comentario = new Comentario();
        comentario.setContenido(txtComment.getText());
        comentario.setFecha(LocalDate.now());
        comentario.setNombre(usuario);

        ArrayList<Object> listaDeObjetos = new ArrayList<>();
        listaDeObjetos.add(comentario);
        listaDeObjetos.add(figura.getNumeroSerie());

        try (Socket socket = new Socket("127.0.0.1", 10570)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            objectOutputStream.writeObject(listaDeObjetos);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error en cliente: " + ex.getMessage());

        }

        SwingUtilities.invokeLater(() -> {
            commentsSection.add(new CComentario("@" + usuario.getUsername(), comentario.getContenido(), LocalDate.now().toString()), "wrap");
            commentsSection.revalidate();
            commentsSection.repaint();
        });

        txtComment.setText("Deja tu comentario");


    }//GEN-LAST:event_addComentarioMouseClicked

    private void txtCommentFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCommentFocusGained
        if (txtComment.getText().equals("Deja tu comentario")) {
            txtComment.setText("");
            txtComment.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtCommentFocusGained

    private void txtCommentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCommentFocusLost
        if (txtComment.getText().isEmpty()) {
            txtComment.setText("Deja tu comentario");
            txtComment.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtCommentFocusLost

    private void lblIconoCasitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconoCasitaMouseClicked
        new Inicio2(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblIconoCasitaMouseClicked

    private void lblIconoPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconoPerfilMouseClicked
        new Perfil(usuario, usuario.getColeccion()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblIconoPerfilMouseClicked

    private void addComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addComentarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addComentarioActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = new Usuario();

                Figura figura = new Figura();
                new Comentarios(usuario, figura).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addComentario;
    private javax.swing.JLayeredPane commentsSection;
    private javax.swing.JLabel lblIconoCasita;
    private javax.swing.JLabel lblIconoNotificaciones;
    private javax.swing.JLabel lblIconoPerfil;
    private javax.swing.JLabel lblMisFiguras;
    private javax.swing.JLabel lblNoticiasEventos;
    private javax.swing.JLabel lblRecomendaciones;
    private javax.swing.JPanel pnlNavTab;
    private javax.swing.JPanel pnlWhiteBackground;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTextField searchTxtField1;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtComment;
    // End of variables declaration//GEN-END:variables
}
