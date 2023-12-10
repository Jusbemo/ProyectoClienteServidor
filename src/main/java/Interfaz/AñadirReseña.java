package Interfaz;

import Clases.Figura;
import Clases.Reseña;
import Clases.Usuario;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

public class AñadirReseña extends javax.swing.JFrame {

    private Figura figura;
    private Usuario usuario;

    public AñadirReseña(Usuario usuario, Figura figura) {
        this.figura = figura;
        this.usuario = usuario;
        initComponents();
    }

    public static boolean isNumber(String str) {
        try {
            int numero = Integer.parseInt(str);
            return numero >= 1 && numero <= 5;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        pnlBlanco = new javax.swing.JPanel();
        pnlAzul = new javax.swing.JPanel();
        lblResenia = new javax.swing.JLabel();
        lblCalificacion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtResenia = new javax.swing.JTextField();
        txtCalificación = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnEnviar2 = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBlanco.setBackground(new java.awt.Color(255, 255, 255));

        pnlAzul.setBackground(new java.awt.Color(1, 22, 39));

        lblResenia.setFont(new java.awt.Font("Roboto", 1, 22)); // NOI18N
        lblResenia.setForeground(new java.awt.Color(255, 255, 255));
        lblResenia.setText("¡Deja tu reseña!");

        javax.swing.GroupLayout pnlAzulLayout = new javax.swing.GroupLayout(pnlAzul);
        pnlAzul.setLayout(pnlAzulLayout);
        pnlAzulLayout.setHorizontalGroup(
            pnlAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAzulLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(lblResenia)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        pnlAzulLayout.setVerticalGroup(
            pnlAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAzulLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblResenia)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        lblCalificacion.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblCalificacion.setText("Calificación");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Reseña");

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);

        txtResenia.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtResenia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtCalificación.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCalificación.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCalificación.setText("Ingresa un número del 1 al 5");
        txtCalificación.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCalificación.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCalificaciónFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCalificaciónFocusLost(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("");
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEnviar2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnEnviar2.setText("Enviar");
        btnEnviar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEnviar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBlancoLayout = new javax.swing.GroupLayout(pnlBlanco);
        pnlBlanco.setLayout(pnlBlancoLayout);
        pnlBlancoLayout.setHorizontalGroup(
            pnlBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBlancoLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnviar2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(pnlBlancoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCalificacion)
                        .addComponent(jLabel2)
                        .addComponent(txtResenia)
                        .addComponent(txtCalificación, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBlancoLayout.setVerticalGroup(
            pnlBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBlancoLayout.createSequentialGroup()
                .addComponent(pnlAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCalificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCalificación, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtResenia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(pnlBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBlanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviar2ActionPerformed

        Reseña reseña = new Reseña();
        String calificacion = txtCalificación.getText();
        int calificacionValor;

        if (isNumber(calificacion)) {
            calificacionValor = Integer.parseInt(calificacion);
            reseña.setCalificacion(calificacionValor);
            reseña.setTexto(txtResenia.getText());
            reseña.setFechaResenia(LocalDate.now());
            reseña.setHoraResenia(LocalTime.now());
            reseña.setTitulo("Título de la reseña");
            reseña.setUsuario(usuario);

            Reseña.crearReseñaBD(reseña, figura.getNumeroSerie());

            JOptionPane.showMessageDialog(this, "Se ha agregado tu reseña");
        } else {
            JOptionPane.showMessageDialog(this, "Se debe ingresar un número entre el 1 y el 5");
        }

    }//GEN-LAST:event_btnEnviar2ActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCalificaciónFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCalificaciónFocusGained
        if (txtCalificación.getText().equals("Ingresa un número del 1 al 5")) {
            txtCalificación.setText("");
            txtCalificación.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtCalificaciónFocusGained

    private void txtCalificaciónFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCalificaciónFocusLost
        if (txtCalificación.getText().isEmpty()) {
            txtCalificación.setText("Ingresa un número del 1 al 5");
            txtCalificación.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtCalificaciónFocusLost

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Figura figura = new Figura();
                Usuario usuario = new Usuario();
                new AñadirReseña(usuario, figura).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblCalificacion;
    private javax.swing.JLabel lblResenia;
    private javax.swing.JPanel pnlAzul;
    private javax.swing.JPanel pnlBlanco;
    private javax.swing.JTextField txtCalificación;
    private javax.swing.JTextField txtResenia;
    // End of variables declaration//GEN-END:variables
}
