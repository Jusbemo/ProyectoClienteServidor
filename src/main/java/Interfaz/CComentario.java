package Interfaz;

public class CComentario extends javax.swing.JPanel {
    
    private String username, comentario, fecha, intercambio;
    
    public CComentario() {
        initComponents();
    }
    
    public CComentario(String username, String comentario, String fecha, String intercambio) {
        initComponents();
        this.username = username;
        this.comentario = comentario;
        this.fecha = fecha;
        this.intercambio = intercambio;
        initProperties();
    }
    
    private void initProperties() {
        txtUsername.setText(username);
        txtComment.setText(comentario);
        fechaTxt.setText(fecha);
        txtChange.setText(intercambio);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername = new javax.swing.JLabel();
        imageAvatar1 = new Utilidades.ImageAvatar();
        txtComment = new javax.swing.JLabel();
        fechaTxt = new javax.swing.JLabel();
        txtChange = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setForeground(new java.awt.Color(242, 242, 242));

        txtUsername.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtUsername.setText("@username");

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/user.png"))); // NOI18N

        txtComment.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtComment.setText("comment");

        fechaTxt.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        txtChange.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtChange.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fechaTxt;
    private Utilidades.ImageAvatar imageAvatar1;
    private javax.swing.JLabel txtChange;
    private javax.swing.JLabel txtComment;
    private javax.swing.JLabel txtUsername;
    // End of variables declaration//GEN-END:variables
}
