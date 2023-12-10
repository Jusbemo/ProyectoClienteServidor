package Interfaz;

import Clases.Figura;
import Clases.Reseña;
import Clases.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Perfil extends javax.swing.JFrame {

    private Usuario usuario;
    private ArrayList<Figura> figuras = new ArrayList<>();

    public Perfil(Usuario usuario, ArrayList<Figura> figuras) {
        this.usuario = usuario;
        this.figuras = figuras;
        initComponents();
        setComponentProperties();
        mostrarInformacionUsuario(usuario);
        setTableReviewsProperties();
    }

    public final void setComponentProperties() {
        ImageIcon logo1 = new ImageIcon("fidepoplarge.png");
        ImageIcon logo2 = new ImageIcon("angle-left-solid.png");

        lblIconoFide1.setText("");
        lblIconoFide1.setIcon(logo1);
        lblIconoFide1.setBounds(50, 50, lblIconoFide1.getPreferredSize().width, lblIconoFide1.getPreferredSize().height);

        lblIconoVolver.setText("");
        lblIconoVolver.setIcon(logo2);
        lblIconoVolver.setBounds(50, 50, lblIconoVolver.getPreferredSize().width, lblIconoVolver.getPreferredSize().height);

    }

    private void mostrarInformacionUsuario(Usuario usuario) {
        if (usuario != null) {
            lblNombreUsuario.setText("@" + usuario.getUsername());
            lblNombreAboutMe.setText(usuario.getNombre());
            lblApellidosAboutMe.setText(usuario.getApellido());
            lblEdadAboutMe.setText(String.valueOf(usuario.getEdad()));
            lblPaisAboutMe.setText(usuario.getPais());
            lblUsuarioAboutMe.setText(usuario.getUsername());
            lblCorreoAboutMe.setText(usuario.getEmail());
            lblNúmero.setText(String.valueOf(usuario.getColeccion().size()));
            for (String interes : usuario.getIntereses()) {
                lblInteresesAboutMe.setText(interes + "\n");
            }
            double precioEstimado = 0.0;
            for (Figura figura : usuario.getColeccion()) {
                precioEstimado += figura.getValor();
            }
            lblPrecio1.setText(String.valueOf(precioEstimado));
        }
    }

    private void setTableReviewsProperties() {
        JTableHeader tHeader = jtblReseñas.getTableHeader();
        tHeader.setBackground(Color.decode("#011627"));
        tHeader.setForeground(Color.WHITE);
        tHeader.setFont(new Font("Roboto", Font.BOLD, 20));
        tHeader.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) jtblReseñas.getModel();
        ArrayList<Reseña> coleccionReseñas = new ArrayList<>();
        
        for (Figura figura : figuras) {
            coleccionReseñas.addAll(figura.getResenias());
        }

        Object rowData[] = new Object[5];

        for (Reseña reseña : coleccionReseñas) {

            rowData[0] = reseña.getUsuario().getUsername();
            rowData[1] = reseña.getNumeroSerieFigura();
            rowData[2] = reseña.getCalificacion();
            rowData[3] = reseña.getTexto();
            rowData[4] = reseña.getFechaResenia();

            model.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPerfil = new javax.swing.JPanel();
        lblIconoVolver = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        tbdPerfil = new javax.swing.JTabbedPane();
        pnlSobreMi = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblPaisAboutMe = new javax.swing.JLabel();
        lblIntereses = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblNombreAboutMe = new javax.swing.JLabel();
        lblApellidosAboutMe = new javax.swing.JLabel();
        lblEdadAboutMe = new javax.swing.JLabel();
        lblInteresesAboutMe = new javax.swing.JLabel();
        lblPais = new javax.swing.JLabel();
        lblCorreoAboutMe = new javax.swing.JLabel();
        lblUsuarioAboutMe = new javax.swing.JLabel();
        pnlNotificaciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblReseñas = new javax.swing.JTable();
        lblNúmero = new javax.swing.JLabel();
        lblNúmeroFiguras = new javax.swing.JLabel();
        backLbl = new javax.swing.JLabel();
        lblIconoFide1 = new javax.swing.JLabel();
        lblPrecioEstimado = new javax.swing.JLabel();
        lblPrecio1 = new javax.swing.JLabel();
        lblPrecio2 = new javax.swing.JLabel();
        lblPrecio3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 830));
        setMinimumSize(new java.awt.Dimension(1280, 830));
        setSize(new java.awt.Dimension(1280, 830));

        pnlPerfil.setBackground(new java.awt.Color(1, 22, 39));
        pnlPerfil.setMaximumSize(new java.awt.Dimension(1280, 830));
        pnlPerfil.setMinimumSize(new java.awt.Dimension(1280, 830));
        pnlPerfil.setPreferredSize(new java.awt.Dimension(1280, 830));
        pnlPerfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIconoVolver.setText("l");
        lblIconoVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIconoVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconoVolverMouseClicked(evt);
            }
        });
        pnlPerfil.add(lblIconoVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 20, 20));

        lblNombreUsuario.setFont(new java.awt.Font("Roboto", 1, 60)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("NOMBRE DEL USUARIO");
        pnlPerfil.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 770, 70));

        tbdPerfil.setToolTipText("");
        tbdPerfil.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N

        pnlSobreMi.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(1, 22, 39));
        lblNombre.setText("Nombre");

        lblApellidos.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblApellidos.setForeground(new java.awt.Color(1, 22, 39));
        lblApellidos.setText("Apellidos");

        lblCorreo.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(1, 22, 39));
        lblCorreo.setText("Correo Eléctronico");

        lblUsuario.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(1, 22, 39));
        lblUsuario.setText("Nombre de usuario");

        lblPaisAboutMe.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblPaisAboutMe.setText("País");

        lblIntereses.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblIntereses.setForeground(new java.awt.Color(1, 22, 39));
        lblIntereses.setText("Intereses");

        lblEdad.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblEdad.setForeground(new java.awt.Color(1, 22, 39));
        lblEdad.setText("Edad");

        lblNombreAboutMe.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblNombreAboutMe.setText("Nombre");

        lblApellidosAboutMe.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblApellidosAboutMe.setText("Apellidos");

        lblEdadAboutMe.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblEdadAboutMe.setText("Edad");

        lblInteresesAboutMe.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblInteresesAboutMe.setText("Intereses");

        lblPais.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblPais.setForeground(new java.awt.Color(1, 22, 39));
        lblPais.setText("País");

        lblCorreoAboutMe.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblCorreoAboutMe.setText("Correo Eléctronico");

        lblUsuarioAboutMe.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblUsuarioAboutMe.setText("Nombre de usuario");

        javax.swing.GroupLayout pnlSobreMiLayout = new javax.swing.GroupLayout(pnlSobreMi);
        pnlSobreMi.setLayout(pnlSobreMiLayout);
        pnlSobreMiLayout.setHorizontalGroup(
            pnlSobreMiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSobreMiLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(pnlSobreMiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCorreo)
                    .addComponent(lblCorreoAboutMe)
                    .addGroup(pnlSobreMiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblApellidosAboutMe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblApellidos, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(lblNombreAboutMe, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(lblUsuarioAboutMe)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 490, Short.MAX_VALUE)
                .addGroup(pnlSobreMiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEdad)
                    .addComponent(lblEdadAboutMe)
                    .addComponent(lblInteresesAboutMe)
                    .addComponent(lblIntereses)
                    .addComponent(lblPais)
                    .addComponent(lblPaisAboutMe))
                .addGap(281, 281, 281))
        );
        pnlSobreMiLayout.setVerticalGroup(
            pnlSobreMiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSobreMiLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlSobreMiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlSobreMiLayout.createSequentialGroup()
                        .addComponent(lblEdad)
                        .addGap(18, 18, 18)
                        .addComponent(lblEdadAboutMe))
                    .addGroup(pnlSobreMiLayout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombreAboutMe)))
                .addGap(35, 35, 35)
                .addGroup(pnlSobreMiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSobreMiLayout.createSequentialGroup()
                        .addComponent(lblApellidos)
                        .addGap(18, 18, 18)
                        .addComponent(lblApellidosAboutMe))
                    .addGroup(pnlSobreMiLayout.createSequentialGroup()
                        .addComponent(lblPais)
                        .addGap(18, 18, 18)
                        .addComponent(lblPaisAboutMe)))
                .addGap(28, 28, 28)
                .addGroup(pnlSobreMiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSobreMiLayout.createSequentialGroup()
                        .addComponent(lblCorreo)
                        .addGap(18, 18, 18)
                        .addComponent(lblCorreoAboutMe)
                        .addGap(29, 29, 29)
                        .addComponent(lblUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(lblUsuarioAboutMe))
                    .addGroup(pnlSobreMiLayout.createSequentialGroup()
                        .addComponent(lblIntereses)
                        .addGap(18, 18, 18)
                        .addComponent(lblInteresesAboutMe)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        tbdPerfil.addTab("Sobre mí", pnlSobreMi);

        pnlNotificaciones.setBackground(new java.awt.Color(255, 255, 255));

        jtblReseñas.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jtblReseñas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Número de Serie", "Calificación", "Reseña", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblReseñas.setRowHeight(35);
        jtblReseñas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblReseñas);

        javax.swing.GroupLayout pnlNotificacionesLayout = new javax.swing.GroupLayout(pnlNotificaciones);
        pnlNotificaciones.setLayout(pnlNotificacionesLayout);
        pnlNotificacionesLayout.setHorizontalGroup(
            pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotificacionesLayout.createSequentialGroup()
                    .addContainerGap(40, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );
        pnlNotificacionesLayout.setVerticalGroup(
            pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
            .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotificacionesLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );

        tbdPerfil.addTab("Reseñas", pnlNotificaciones);

        pnlPerfil.add(tbdPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1280, 540));

        lblNúmero.setBackground(new java.awt.Color(255, 255, 255));
        lblNúmero.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblNúmero.setForeground(new java.awt.Color(255, 255, 255));
        lblNúmero.setText("0");
        pnlPerfil.add(lblNúmero, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 214, 350, -1));

        lblNúmeroFiguras.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblNúmeroFiguras.setForeground(new java.awt.Color(255, 255, 255));
        lblNúmeroFiguras.setText("Número de figuras");
        pnlPerfil.add(lblNúmeroFiguras, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 370, -1));

        backLbl.setFont(new java.awt.Font("Roboto", 1, 21)); // NOI18N
        backLbl.setForeground(new java.awt.Color(255, 255, 255));
        backLbl.setText("Volver");
        backLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backLblMouseClicked(evt);
            }
        });
        pnlPerfil.add(backLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 20, -1, -1));

        lblIconoFide1.setText("logoFide");
        lblIconoFide1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlPerfil.add(lblIconoFide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        lblPrecioEstimado.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblPrecioEstimado.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecioEstimado.setText("Precio Estimado");
        pnlPerfil.add(lblPrecioEstimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 370, -1));

        lblPrecio1.setBackground(new java.awt.Color(255, 255, 255));
        lblPrecio1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblPrecio1.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio1.setText("0");
        pnlPerfil.add(lblPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 210, -1));

        lblPrecio2.setBackground(new java.awt.Color(255, 255, 255));
        lblPrecio2.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblPrecio2.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/robot-solid.png"))); // NOI18N
        pnlPerfil.add(lblPrecio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 212, 40, 40));

        lblPrecio3.setBackground(new java.awt.Color(255, 255, 255));
        lblPrecio3.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblPrecio3.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilidades/colon-sign-solid.png"))); // NOI18N
        pnlPerfil.add(lblPrecio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 212, 30, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backLblMouseClicked
        new Inicio2(usuario).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_backLblMouseClicked

    private void lblIconoVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconoVolverMouseClicked
        new Inicio2(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblIconoVolverMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = new Usuario();
                ArrayList<Figura> figuras = new ArrayList<>();
                new Perfil(usuario, figuras).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblReseñas;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblApellidosAboutMe;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCorreoAboutMe;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEdadAboutMe;
    private javax.swing.JLabel lblIconoFide1;
    private javax.swing.JLabel lblIconoVolver;
    private javax.swing.JLabel lblIntereses;
    private javax.swing.JLabel lblInteresesAboutMe;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreAboutMe;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblNúmero;
    private javax.swing.JLabel lblNúmeroFiguras;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblPaisAboutMe;
    private javax.swing.JLabel lblPrecio1;
    private javax.swing.JLabel lblPrecio2;
    private javax.swing.JLabel lblPrecio3;
    private javax.swing.JLabel lblPrecioEstimado;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarioAboutMe;
    private javax.swing.JPanel pnlNotificaciones;
    private javax.swing.JPanel pnlPerfil;
    private javax.swing.JPanel pnlSobreMi;
    private javax.swing.JTabbedPane tbdPerfil;
    // End of variables declaration//GEN-END:variables
}
