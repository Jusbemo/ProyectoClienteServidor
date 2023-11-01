package com.mycompany.proyectoclienteservidor;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.RoundRectangle2D;
import java.util.HashMap;
import java.util.Map;

public class InicioSesion extends javax.swing.JFrame {

    public InicioSesion() {
        initComponents();
        setComponentProperties();

    }

    public final void setComponentProperties() {
        ImageIcon logo = new ImageIcon("redLogo.jpeg");
        jLabel2.setText("");
        jLabel2.setIcon(logo);
        jLabel2.setBounds(50, 50, jLabel2.getPreferredSize().width, jLabel2.getPreferredSize().height);

        configureRoundedBorder(jTextField1, Color.BLACK, 12, 10);
        configureRoundedBorder(jPasswordField1, Color.BLACK, 12, 10);
        configureRoundedBorder(jButton1, Color.decode("#011627"), 12, 10);

        Font font = jLabel6.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel6.setFont(font.deriveFont(attributes));

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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        test = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
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

        jLabel2.setText("jLabel1");
        jLabel2.setAlignmentY(0.0F);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

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

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTextField1.setText("Ingrese su nombre de usuario");
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        bg.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 600, 40));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 22, 39));
        jLabel6.setText("Regístrate");
        jLabel6.setToolTipText("");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 600, -1, 20));

        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setText("password12345");
        jPasswordField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusLost(evt);
            }
        });
        bg.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 600, 40));

        jButton1.setBackground(new java.awt.Color(1, 22, 39));
        jButton1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Iniciar Sesión");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 2, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        bg.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 430, 50));

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

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        if (jTextField1.getText().equals("Ingrese su nombre de usuario")) {
            jTextField1.setText("");
            jTextField1.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        if (String.valueOf(jPasswordField1.getPassword()).equals("password12345")) {
            jPasswordField1.setText("");
            jPasswordField1.setForeground(Color.black);
        }
        if (jTextField1.getText().isEmpty()) {
            jTextField1.setText("Ingrese su nombre de usuario");
            jTextField1.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jPasswordField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusLost
        if (jTextField1.getText().equals("Ingrese su nombre de usuario")) {
            jTextField1.setText("");
            jTextField1.setForeground(Color.black);
        }
        if (String.valueOf(jPasswordField1.getPassword()).isEmpty()) {
            jPasswordField1.setText("password12345");
            jPasswordField1.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jPasswordField1FocusLost

    private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusGained
        if (String.valueOf(jPasswordField1.getPassword()).equals("password12345")) {
            jPasswordField1.setText("");
            jPasswordField1.setForeground(Color.black);
        }
    }//GEN-LAST:event_jPasswordField1FocusGained

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabel6.setForeground(Color.RED);

    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setForeground(Color.decode("#011627"));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBackground(Color.decode("#033762"));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(Color.decode("#011627"));
    }//GEN-LAST:event_jButton1MouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField test;
    // End of variables declaration//GEN-END:variables
}
