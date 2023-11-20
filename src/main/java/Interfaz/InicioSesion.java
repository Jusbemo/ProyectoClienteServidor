package Interfaz;

import Clases.Usuario;
import Conexion.Conexion;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InicioSesion extends javax.swing.JFrame {

    public InicioSesion() {
        initComponents();
        setComponentProperties();

    }

    public final void setComponentProperties() {
        ImageIcon logo = new ImageIcon("redLogo.jpeg");
        icono.setText("");
        icono.setIcon(logo);
        icono.setBounds(50, 50, icono.getPreferredSize().width, icono.getPreferredSize().height);

        configureRoundedBorder(txtUsername, Color.BLACK, 12, 10);
        configureRoundedBorder(txtPassword, Color.BLACK, 12, 10);
        configureRoundedBorder(btnIniciarSesion, Color.decode("#011627"), 12, 10);

        Font font = btnRegistrarse.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        btnRegistrarse.setFont(font.deriveFont(attributes));

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        icono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        test = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        btnRegistrarse = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(500, 500));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1280, 830));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 830));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(1280, 830));
        bg.setPreferredSize(new java.awt.Dimension(1280, 830));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(1, 22, 39));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icono.setText("jLabel1");
        icono.setAlignmentY(0.0F);
        jPanel2.add(icono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 34));
        jLabel1.setText("BIENVENIDO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 34));
        jLabel4.setText("¡Que alegría verte de vuelta!");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, -1, -1));

        bg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 830));
        jPanel2.getAccessibleContext().setAccessibleName("");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 22, 39));
        jLabel3.setText("Nombre de usuario");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, -1, 20));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 34)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 22, 39));
        jLabel5.setText("INICIAR SESIÓN");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 200, -1, -1));

        test.setBackground(new java.awt.Color(255, 255, 255));
        test.setBorder(null);
        bg.add(test, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, -1, -1));

        txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtUsername.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUsername.setText("Ingrese su nombre de usuario");
        txtUsername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        bg.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 600, 40));

        btnRegistrarse.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnRegistrarse.setForeground(new java.awt.Color(1, 22, 39));
        btnRegistrarse.setText("Regístrate");
        btnRegistrarse.setToolTipText("");
        btnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarseMouseExited(evt);
            }
        });
        bg.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 600, -1, 20));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setText("password12345");
        txtPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        bg.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 600, 40));

        btnIniciarSesion.setBackground(new java.awt.Color(1, 22, 39));
        btnIniciarSesion.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 2, true));
        btnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseExited(evt);
            }
        });
        bg.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 430, 50));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 22, 39));
        jLabel7.setText("Contraseña");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, -1, 20));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 22, 39));
        jLabel8.setText("¿Aún no tienes cuenta?");
        bg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 580, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        if (txtUsername.getText().equals("Ingrese su nombre de usuario")) {
            txtUsername.setText("");
            txtUsername.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        if (String.valueOf(txtPassword.getPassword()).equals("password12345")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
        }
        if (txtUsername.getText().isEmpty()) {
            txtUsername.setText("Ingrese su nombre de usuario");
            txtUsername.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        if (txtUsername.getText().equals("Ingrese su nombre de usuario")) {
            txtUsername.setText("");
            txtUsername.setForeground(Color.black);
        }
        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
            txtPassword.setText("password12345");
            txtPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        if (String.valueOf(txtPassword.getPassword()).equals("password12345")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtPasswordFocusGained

    private void btnRegistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarseMouseEntered
        btnRegistrarse.setForeground(Color.RED);

    }//GEN-LAST:event_btnRegistrarseMouseEntered

    private void btnRegistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarseMouseExited
        btnRegistrarse.setForeground(Color.decode("#011627"));
    }//GEN-LAST:event_btnRegistrarseMouseExited

    private void btnIniciarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseEntered
        btnIniciarSesion.setBackground(Color.decode("#033762"));
    }//GEN-LAST:event_btnIniciarSesionMouseEntered

    private void btnIniciarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseExited
        btnIniciarSesion.setBackground(Color.decode("#011627"));
    }//GEN-LAST:event_btnIniciarSesionMouseExited

    private void btnRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarseMouseClicked
        this.dispose();
        new Registro().setVisible(true);
    }//GEN-LAST:event_btnRegistrarseMouseClicked

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(password.getBytes());
            byte[] rbt = md.digest();

            StringBuilder sbPwd = new StringBuilder();

            for (byte b : rbt) {
                sbPwd.append(String.format("%02x", b));
            }

            return sbPwd.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error al encriptar la contraseña" + e.getMessage());
        }
        return null;
    }

    private Usuario validarInicioSesion(String username, String password) {
        //RETORNAR EL USUARIO CON LOS DATOS EN CASO DE QUE SE ENCUENTRE
        Conexion conexion = new Conexion();

        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
        String interesSql = "SELECT * FROM intereses WHERE usuarioAsociado = ?";
        String hashPassword = hashPassword(password);

        try (Connection connection = conexion.establecerConexion(); PreparedStatement ps = connection.prepareStatement(sql); PreparedStatement interesPs = connection.prepareStatement(interesSql);) {

            ps.setString(1, username);
            ps.setString(2, hashPassword);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setEdad(rs.getInt("edad"));
                    usuario.setUsername(rs.getString("usuario"));
                    usuario.setPais(rs.getString("pais"));
                    usuario.setEmail(rs.getString("correo"));
                    usuario.setPassword(rs.getString("contraseña"));

                    ArrayList<String> intereses = new ArrayList<>();

                    interesPs.setString(1, username);

                    try (ResultSet interesRs = interesPs.executeQuery()) {
                        while (interesRs.next()) {
                            intereses.add(interesRs.getString("interes"));
                        }
                    }

                    usuario.setIntereses(intereses);

                    return usuario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void btnIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseClicked

        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());

        Usuario usuario = validarInicioSesion(username, password);

        try {
            if (usuario.validarAtributos()) {
                
                
                //AGREGAR CODIGO PARA INICIO SE LE DEBE ENVIAR COMO PARAMETRO EL OBJETO USUARIO A LA NUEVA VENTANA INICIO
                new Inicio2().setVisible(true);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "El usuario o contraseña son incorrectos");
        }


    }//GEN-LAST:event_btnIniciarSesionMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel btnRegistrarse;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField test;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
