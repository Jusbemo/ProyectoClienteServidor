package Interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;

public class Registro extends javax.swing.JFrame {

    public Registro() {
        initComponents();
        setComponentProperties();
    }

    public final void setComponentProperties() {
        ImageIcon logo = new ImageIcon("redLogo.jpeg");
        penpotIconImage.setText("");
        penpotIconImage.setIcon(logo);
        penpotIconImage.setBounds(50, 50, penpotIconImage.getPreferredSize().width, penpotIconImage.getPreferredSize().height);

        configureRoundedBorder(nameTextField, Color.BLACK, 12, 10);
        configureRoundedBorder(lastnameTextField, Color.BLACK, 12, 10);
        configureRoundedBorder(emailTextField, Color.BLACK, 12, 10);
        configureRoundedBorder(usernameTextField, Color.BLACK, 12, 10);
        configureRoundedBorder(passwordField, Color.BLACK, 12, 10);
        configureRoundedBorder(confirmPasswordField, Color.BLACK, 12, 10);

        configureRoundedBorder(createButton, Color.decode("#011627"), 12, 10);
        configureRoundedBorder(loginButton, Color.decode("#011627"), 12, 10);
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
        leftBgBlue = new javax.swing.JPanel();
        penpotIconImage = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        text = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        lastnameTextField = new javax.swing.JTextField();
        lastnameLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        interesesLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        countryLabel = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        confirmPasswordLabel = new javax.swing.JLabel();
        intereesComboBox = new javax.swing.JComboBox<>();
        ageLabel = new javax.swing.JLabel();
        ageSpinner = new javax.swing.JSpinner();
        loginButton = new javax.swing.JButton();
        createButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        countryComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1280, 830));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 830));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(1280, 830));
        bg.setPreferredSize(new java.awt.Dimension(1280, 830));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leftBgBlue.setBackground(new java.awt.Color(1, 22, 39));
        leftBgBlue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        penpotIconImage.setText("jLabel1");
        leftBgBlue.add(penpotIconImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        bg.add(leftBgBlue, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 830));
        leftBgBlue.getAccessibleContext().setAccessibleName("");

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 1, 34)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(1, 22, 39));
        titleLabel.setText("REGISTRAR USUARIO");
        bg.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMinimumSize(new java.awt.Dimension(1280, 830));
        jPanel5.setPreferredSize(new java.awt.Dimension(1280, 830));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text.setBackground(new java.awt.Color(255, 255, 255));
        text.setBorder(null);
        jPanel5.add(text, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Roboto", 1, 34)); // NOI18N
        title.setForeground(new java.awt.Color(1, 22, 39));
        title.setText("REGISTRAR USUARIO");
        jPanel5.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        nameLabel.setBackground(new java.awt.Color(255, 255, 255));
        nameLabel.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(1, 22, 39));
        nameLabel.setText("Nombre");
        jPanel5.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, -1));

        nameTextField.setBackground(new java.awt.Color(255, 255, 255));
        nameTextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nameTextField.setForeground(new java.awt.Color(204, 204, 204));
        nameTextField.setText("Ingrese su nombre");
        nameTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 3, true));
        nameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTextFieldFocusLost(evt);
            }
        });
        jPanel5.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 610, 37));

        lastnameTextField.setBackground(new java.awt.Color(255, 255, 255));
        lastnameTextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lastnameTextField.setForeground(new java.awt.Color(204, 204, 204));
        lastnameTextField.setText("Ingrese su apellido");
        lastnameTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 3, true));
        lastnameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastnameTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastnameTextFieldFocusLost(evt);
            }
        });
        jPanel5.add(lastnameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 610, 37));

        lastnameLabel.setBackground(new java.awt.Color(255, 255, 255));
        lastnameLabel.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lastnameLabel.setForeground(new java.awt.Color(1, 22, 39));
        lastnameLabel.setText("Apellido");
        jPanel5.add(lastnameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

        emailTextField.setBackground(new java.awt.Color(255, 255, 255));
        emailTextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        emailTextField.setForeground(new java.awt.Color(204, 204, 204));
        emailTextField.setText("Ingrese su correo electrónico");
        emailTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 3, true));
        emailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailTextFieldFocusLost(evt);
            }
        });
        jPanel5.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 610, 37));

        emailLabel.setBackground(new java.awt.Color(255, 255, 255));
        emailLabel.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(1, 22, 39));
        emailLabel.setText("Correo electrónico");
        jPanel5.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, -1, -1));

        interesesLabel.setBackground(new java.awt.Color(255, 255, 255));
        interesesLabel.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        interesesLabel.setForeground(new java.awt.Color(1, 22, 39));
        interesesLabel.setText("Interéses");
        jPanel5.add(interesesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 640, -1, -1));

        usernameTextField.setBackground(new java.awt.Color(255, 255, 255));
        usernameTextField.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        usernameTextField.setForeground(new java.awt.Color(204, 204, 204));
        usernameTextField.setText("Ingrese su nombre de usuario");
        usernameTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 3, true));
        usernameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameTextFieldFocusLost(evt);
            }
        });
        jPanel5.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 610, 37));

        passwordLabel.setBackground(new java.awt.Color(255, 255, 255));
        passwordLabel.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(1, 22, 39));
        passwordLabel.setText("Constraseña");
        jPanel5.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, -1, -1));

        passwordField.setBackground(new java.awt.Color(255, 255, 255));
        passwordField.setForeground(new java.awt.Color(204, 204, 204));
        passwordField.setText("password12345");
        passwordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 3, true));
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });
        jPanel5.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 610, 37));

        countryLabel.setBackground(new java.awt.Color(255, 255, 255));
        countryLabel.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        countryLabel.setForeground(new java.awt.Color(1, 22, 39));
        countryLabel.setText("País");
        jPanel5.add(countryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 550, -1, -1));

        confirmPasswordField.setBackground(new java.awt.Color(255, 255, 255));
        confirmPasswordField.setForeground(new java.awt.Color(204, 204, 204));
        confirmPasswordField.setText("password12345");
        confirmPasswordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 3, true));
        confirmPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmPasswordFieldFocusLost(evt);
            }
        });
        jPanel5.add(confirmPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, 610, 37));

        confirmPasswordLabel.setBackground(new java.awt.Color(255, 255, 255));
        confirmPasswordLabel.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        confirmPasswordLabel.setForeground(new java.awt.Color(1, 22, 39));
        confirmPasswordLabel.setText("Confirmar contraseña");
        jPanel5.add(confirmPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, -1, -1));

        intereesComboBox.setBackground(new java.awt.Color(255, 255, 255));
        intereesComboBox.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        intereesComboBox.setForeground(new java.awt.Color(204, 204, 204));
        intereesComboBox.setMaximumRowCount(30);
        intereesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eliga sus interéses", "Item 2", "Item 3", "Item 4" }));
        intereesComboBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 1, true));
        jPanel5.add(intereesComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 670, 610, 37));

        ageLabel.setBackground(new java.awt.Color(255, 255, 255));
        ageLabel.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        ageLabel.setForeground(new java.awt.Color(1, 22, 39));
        ageLabel.setText("Edad");
        jPanel5.add(ageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 550, -1, -1));

        ageSpinner.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        ageSpinner.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 1, true));
        ageSpinner.setName(""); // NOI18N
        jPanel5.add(ageSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 590, 273, 37));

        loginButton.setBackground(new java.awt.Color(1, 22, 39));
        loginButton.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Iniciar Sesión");
        loginButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 2, true));
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 740, 194, 52));

        createButton.setBackground(new java.awt.Color(1, 22, 39));
        createButton.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        createButton.setForeground(new java.awt.Color(255, 255, 255));
        createButton.setText("Crear Usuario");
        createButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 2, true));
        createButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(createButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 740, 194, 52));

        usernameLabel.setBackground(new java.awt.Color(255, 255, 255));
        usernameLabel.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(1, 22, 39));
        usernameLabel.setText("Nombre de usuario");
        jPanel5.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, -1, -1));

        countryComboBox.setBackground(new java.awt.Color(255, 255, 255));
        countryComboBox.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        countryComboBox.setForeground(new java.awt.Color(204, 204, 204));
        countryComboBox.setMaximumRowCount(30);
        countryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione su país", "Item 2", "Item 3", "Item 4" }));
        countryComboBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 1, true));
        jPanel5.add(countryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, 273, 37));

        bg.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFieldFocusGained
        if (nameTextField.getText().equals("Ingrese su nombre")) {
            nameTextField.setText("");
            nameTextField.setForeground(Color.black);
        }
    }//GEN-LAST:event_nameTextFieldFocusGained

    private void nameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFieldFocusLost
        if (nameTextField.getText().isEmpty()) {
            nameTextField.setText("Ingrese su nombre");
            nameTextField.setForeground(Color.gray);
        }
    }//GEN-LAST:event_nameTextFieldFocusLost

    private void lastnameTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameTextFieldFocusGained
        if (lastnameTextField.getText().equals("Ingrese su apellido")) {
            lastnameTextField.setText("");
            lastnameTextField.setForeground(Color.black);
        }
    }//GEN-LAST:event_lastnameTextFieldFocusGained

    private void lastnameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameTextFieldFocusLost
        if (lastnameTextField.getText().isEmpty()) {
            lastnameTextField.setText("Ingrese su apellido");
            lastnameTextField.setForeground(Color.gray);
        }
    }//GEN-LAST:event_lastnameTextFieldFocusLost

    private void emailTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextFieldFocusGained
        if (emailTextField.getText().equals("Ingrese su correo electrónico")) {
            emailTextField.setText("");
            emailTextField.setForeground(Color.black);
        }
    }//GEN-LAST:event_emailTextFieldFocusGained

    private void emailTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextFieldFocusLost
        if (emailTextField.getText().isEmpty()) {
            emailTextField.setText("Ingrese su correo electrónico");
            emailTextField.setForeground(Color.gray);
        }
    }//GEN-LAST:event_emailTextFieldFocusLost

    private void usernameTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTextFieldFocusGained
        if (usernameTextField.getText().equals("Ingrese su nombre de usuario")) {
            usernameTextField.setText("");
            usernameTextField.setForeground(Color.black);
        }
    }//GEN-LAST:event_usernameTextFieldFocusGained

    private void usernameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTextFieldFocusLost
        if (usernameTextField.getText().isEmpty()) {
            usernameTextField.setText("Ingrese su nombre de usuario");
            usernameTextField.setForeground(Color.gray);
        }
    }//GEN-LAST:event_usernameTextFieldFocusLost

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        if (String.valueOf(passwordField.getPassword()).equals("password12345")) {
            passwordField.setText("");
            passwordField.setForeground(Color.black);
        }
    }//GEN-LAST:event_passwordFieldFocusGained

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        if (String.valueOf(passwordField.getPassword()).isEmpty()) {
            passwordField.setText("password12345");
            passwordField.setForeground(Color.gray);
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void confirmPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmPasswordFieldFocusGained
        if (String.valueOf(confirmPasswordField.getPassword()).equals("password12345")) {
            confirmPasswordField.setText("");
            confirmPasswordField.setForeground(Color.black);
        }
    }//GEN-LAST:event_confirmPasswordFieldFocusGained

    private void confirmPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmPasswordFieldFocusLost
        if (String.valueOf(confirmPasswordField.getPassword()).isEmpty()) {
            confirmPasswordField.setText("password12345");
            confirmPasswordField.setForeground(Color.gray);
        }
    }//GEN-LAST:event_confirmPasswordFieldFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageLabel;
    private javax.swing.JSpinner ageSpinner;
    private javax.swing.JPanel bg;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JComboBox<String> countryComboBox;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JComboBox<String> intereesComboBox;
    private javax.swing.JLabel interesesLabel;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JTextField lastnameTextField;
    private javax.swing.JPanel leftBgBlue;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel penpotIconImage;
    private javax.swing.JTextField text;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
