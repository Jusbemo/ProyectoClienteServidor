package Interfaz;

import Clases.Usuario;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Inicio1 extends javax.swing.JFrame {

    private Usuario usuario;

    public Inicio1(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        setComponentProperties();
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
        searchTxtField1 = new javax.swing.JTextField();
        searchTxt = new javax.swing.JTextField();
        lblNoticiasEventos = new javax.swing.JLabel();
        lblMisFiguras = new javax.swing.JLabel();
        lblRecomendaciones = new javax.swing.JLabel();
        lblIconoNotificaciones = new javax.swing.JLabel();
        lblIconoPerfil = new javax.swing.JLabel();
        lblIconoCasita = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();

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

        searchTxtField1.setBackground(new java.awt.Color(1, 22, 39));
        searchTxtField1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        searchTxtField1.setForeground(new java.awt.Color(226, 226, 226));
        searchTxtField1.setBorder(null);

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

        lblIconoCasita.setText("jLabel6");
        lblIconoCasita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnlNavTabLayout.setVerticalGroup(
            pnlNavTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavTabLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(searchTxtField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNavTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNoticiasEventos)
                    .addComponent(lblMisFiguras)
                    .addComponent(lblRecomendaciones)
                    .addComponent(lblIconoNotificaciones)
                    .addComponent(lblIconoPerfil)
                    .addComponent(lblIconoCasita))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlWhiteBackground.add(pnlNavTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 100));

        lblInicio.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(179, 179, 179));
        lblInicio.setText("Busca el nombre de una figura para intercambiar");
        pnlWhiteBackground.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWhiteBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWhiteBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = new Usuario();
                new Inicio1(usuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIconoCasita;
    private javax.swing.JLabel lblIconoNotificaciones;
    private javax.swing.JLabel lblIconoPerfil;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblMisFiguras;
    private javax.swing.JLabel lblNoticiasEventos;
    private javax.swing.JLabel lblRecomendaciones;
    private javax.swing.JPanel pnlNavTab;
    private javax.swing.JPanel pnlWhiteBackground;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTextField searchTxtField1;
    // End of variables declaration//GEN-END:variables
}
