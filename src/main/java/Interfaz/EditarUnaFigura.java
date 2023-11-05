/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import javax.swing.ImageIcon;

/**
 *
 * @author ACER
 */
public class EditarUnaFigura extends javax.swing.JFrame {

    /**
     * Creates new form EditarUnaFigura
     */
    public EditarUnaFigura() {
        initComponents();
        setComponentProperties();
    }
    
    public final void setComponentProperties(){
        ImageIcon logo = new ImageIcon("fidepop-2.png");
        lblIcono.setText("");
        lblIcono.setIcon(logo);
        lblIcono.setBounds(50, 50, lblIcono.getPreferredSize().width, lblIcono.getPreferredSize().height);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlWhiteBackground = new javax.swing.JPanel();
        pnlBlueBackground = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        txtNumeroSerie = new javax.swing.JTextField();
        lblFechaAdquisicion = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblNumeroSerie = new javax.swing.JLabel();
        lblTamanho = new javax.swing.JLabel();
        txtFechaAdquisicion = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblActualizaDatos = new javax.swing.JLabel();
        txtTamanho = new javax.swing.JTextField();
        cboxEstado = new javax.swing.JComboBox<>();
        btnGuardarCambios = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        cboxCategoria = new javax.swing.JComboBox<>();
        txtPrecioEstimado = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblPrecioEstimado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1280, 830));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 830));

        pnlWhiteBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlWhiteBackground.setMaximumSize(new java.awt.Dimension(1280, 830));
        pnlWhiteBackground.setMinimumSize(new java.awt.Dimension(1280, 830));
        pnlWhiteBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBlueBackground.setBackground(new java.awt.Color(1, 22, 39));
        pnlBlueBackground.setMaximumSize(new java.awt.Dimension(616, 830));
        pnlBlueBackground.setMinimumSize(new java.awt.Dimension(616, 830));

        lblIcono.setText("jLabel1");

        javax.swing.GroupLayout pnlBlueBackgroundLayout = new javax.swing.GroupLayout(pnlBlueBackground);
        pnlBlueBackground.setLayout(pnlBlueBackgroundLayout);
        pnlBlueBackgroundLayout.setHorizontalGroup(
            pnlBlueBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBlueBackgroundLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(lblIcono)
                .addContainerGap(477, Short.MAX_VALUE))
        );
        pnlBlueBackgroundLayout.setVerticalGroup(
            pnlBlueBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBlueBackgroundLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(lblIcono)
                .addContainerGap(658, Short.MAX_VALUE))
        );

        pnlWhiteBackground.add(pnlBlueBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 616, 830));

        txtNumeroSerie.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtNumeroSerie.setForeground(new java.awt.Color(198, 197, 197));
        txtNumeroSerie.setText("Ingrese el número de serie de la figura");
        txtNumeroSerie.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtNumeroSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroSerieActionPerformed(evt);
            }
        });
        pnlWhiteBackground.add(txtNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 595, -1));

        lblFechaAdquisicion.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblFechaAdquisicion.setForeground(new java.awt.Color(1, 22, 39));
        lblFechaAdquisicion.setText("Fecha de adquisición");
        pnlWhiteBackground.add(lblFechaAdquisicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(1, 22, 39));
        btnCancelar.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlWhiteBackground.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 630, 169, -1));

        lblEstado.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(1, 22, 39));
        lblEstado.setText("Estado");
        pnlWhiteBackground.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, -1, -1));

        txtMarca.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(198, 197, 197));
        txtMarca.setText("Ingrese la marca de la figura");
        txtMarca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        pnlWhiteBackground.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, 595, -1));

        lblNumeroSerie.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblNumeroSerie.setForeground(new java.awt.Color(1, 22, 39));
        lblNumeroSerie.setText("Número de serie");
        pnlWhiteBackground.add(lblNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, -1, -1));

        lblTamanho.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblTamanho.setForeground(new java.awt.Color(1, 22, 39));
        lblTamanho.setText("Tamaño");
        pnlWhiteBackground.add(lblTamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, -1, -1));

        txtFechaAdquisicion.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtFechaAdquisicion.setForeground(new java.awt.Color(198, 197, 197));
        txtFechaAdquisicion.setText("Ingrese la fecha de  adiquisición de la figura");
        txtFechaAdquisicion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pnlWhiteBackground.add(txtFechaAdquisicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 595, -1));

        lblNombre.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(1, 22, 39));
        lblNombre.setText("Nombre");
        pnlWhiteBackground.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, -1, -1));

        lblActualizaDatos.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblActualizaDatos.setForeground(new java.awt.Color(1, 22, 39));
        lblActualizaDatos.setText("ACTUALIZA LOS DATOS DE TU FIGURA");
        pnlWhiteBackground.add(lblActualizaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, -1));

        txtTamanho.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtTamanho.setForeground(new java.awt.Color(198, 197, 197));
        txtTamanho.setText("Ingrese el tamaño de la figura");
        txtTamanho.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTamanhoActionPerformed(evt);
            }
        });
        pnlWhiteBackground.add(txtTamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 595, -1));

        cboxEstado.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        cboxEstado.setForeground(new java.awt.Color(198, 197, 197));
        cboxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el estado de la figura", "Item 2", "Item 3", "Item 4" }));
        cboxEstado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pnlWhiteBackground.add(cboxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 595, -1));

        btnGuardarCambios.setBackground(new java.awt.Color(1, 22, 39));
        btnGuardarCambios.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnGuardarCambios.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.setBorder(null);
        btnGuardarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlWhiteBackground.add(btnGuardarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 630, -1, -1));

        lblCategoria.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(1, 22, 39));
        lblCategoria.setText("Categoría");
        pnlWhiteBackground.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, -1, -1));

        lblMarca.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(1, 22, 39));
        lblMarca.setText("Marca");
        pnlWhiteBackground.add(lblMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 530, -1, -1));

        cboxCategoria.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        cboxCategoria.setForeground(new java.awt.Color(198, 197, 197));
        cboxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la categoría de la figura", "Item 2", "Item 3", "Item 4" }));
        cboxCategoria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pnlWhiteBackground.add(cboxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 595, -1));

        txtPrecioEstimado.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtPrecioEstimado.setForeground(new java.awt.Color(198, 197, 197));
        txtPrecioEstimado.setText("Ingrese el precio estimado de la figura");
        txtPrecioEstimado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pnlWhiteBackground.add(txtPrecioEstimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 595, -1));

        txtNombre.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(198, 197, 197));
        txtNombre.setText("Ingrese el nombre de la figura");
        txtNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        pnlWhiteBackground.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 595, -1));

        lblPrecioEstimado.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblPrecioEstimado.setForeground(new java.awt.Color(1, 22, 39));
        lblPrecioEstimado.setText("Precio estimado");
        pnlWhiteBackground.add(lblPrecioEstimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlWhiteBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWhiteBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTamanhoActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNumeroSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroSerieActionPerformed

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
            java.util.logging.Logger.getLogger(EditarUnaFigura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarUnaFigura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarUnaFigura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarUnaFigura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarUnaFigura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JComboBox<String> cboxEstado;
    private javax.swing.JLabel lblActualizaDatos;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaAdquisicion;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroSerie;
    private javax.swing.JLabel lblPrecioEstimado;
    private javax.swing.JLabel lblTamanho;
    private javax.swing.JPanel pnlBlueBackground;
    private javax.swing.JPanel pnlWhiteBackground;
    private javax.swing.JTextField txtFechaAdquisicion;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroSerie;
    private javax.swing.JTextField txtPrecioEstimado;
    private javax.swing.JTextField txtTamanho;
    // End of variables declaration//GEN-END:variables
}
