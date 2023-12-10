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
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class Inicio2 extends javax.swing.JFrame {

    private TableRowSorter<DefaultTableModel> rowSorter;
    private Usuario usuario;
    private ArrayList<Figura> figuras = new ArrayList<>();

    public Inicio2(Usuario usuario) {
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
        configureRoundedBorder(btnComentario, Color.decode("#011627"), 12, 10);
        configureRoundedBorder(btnReview, Color.decode("#011627"), 12, 10);
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
        String sql = "SELECT nombre, numeroSerie, fechaAdquisicion, tamaño, precio, categoria, estado, marca, usuario FROM figuras WHERE usuario != ?";

        try (PreparedStatement ps = conexion.establecerConexion().prepareStatement(sql)) {

            ps.setString(1, usuario.getUsername());

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
        separator = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblFiltros = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblCategory = new javax.swing.JLabel();
        chBoxComics = new javax.swing.JCheckBox();
        chBoxPeliculas = new javax.swing.JCheckBox();
        chBoxSeries = new javax.swing.JCheckBox();
        chBoxVideojuegos = new javax.swing.JCheckBox();
        chBoxAnime = new javax.swing.JCheckBox();
        chBoxDeportes = new javax.swing.JCheckBox();
        chBoxMusica = new javax.swing.JCheckBox();
        chBoxDisney = new javax.swing.JCheckBox();
        separator2 = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        chBoxNew = new javax.swing.JCheckBox();
        chBoxNearMint = new javax.swing.JCheckBox();
        chBoxUsada = new javax.swing.JCheckBox();
        chBoxDamaged = new javax.swing.JCheckBox();
        chBoxRestaurada = new javax.swing.JCheckBox();
        btnComentario = new javax.swing.JButton();
        btnReview = new javax.swing.JButton();
        btnComentario1 = new javax.swing.JButton();

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

        separator.setBackground(new java.awt.Color(177, 178, 181));

        javax.swing.GroupLayout separatorLayout = new javax.swing.GroupLayout(separator);
        separator.setLayout(separatorLayout);
        separatorLayout.setHorizontalGroup(
            separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separatorLayout.setVerticalGroup(
            separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        bg.add(separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 144, 1, 630));

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

        bg.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 935, 580));

        lblFiltros.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblFiltros.setForeground(new java.awt.Color(1, 22, 39));
        lblFiltros.setText("Filtros");
        lblFiltros.setToolTipText("");
        bg.add(lblFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 144, 116, 30));

        jSeparator1.setBackground(new java.awt.Color(1, 22, 39));
        jSeparator1.setForeground(new java.awt.Color(1, 22, 39));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 70, 2));

        lblCategory.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(1, 22, 39));
        lblCategory.setText("Categorías");
        lblCategory.setToolTipText("");
        bg.add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 185, 116, 30));

        chBoxComics.setBackground(new java.awt.Color(255, 255, 255));
        chBoxComics.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxComics.setForeground(new java.awt.Color(1, 22, 39));
        chBoxComics.setText("Cómics & Superhéroes");
        chBoxComics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxComicsActionPerformed(evt);
            }
        });
        bg.add(chBoxComics, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 30));

        chBoxPeliculas.setBackground(new java.awt.Color(255, 255, 255));
        chBoxPeliculas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxPeliculas.setForeground(new java.awt.Color(1, 22, 39));
        chBoxPeliculas.setText("Películas");
        chBoxPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxPeliculasActionPerformed(evt);
            }
        });
        bg.add(chBoxPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 30));

        chBoxSeries.setBackground(new java.awt.Color(255, 255, 255));
        chBoxSeries.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxSeries.setForeground(new java.awt.Color(1, 22, 39));
        chBoxSeries.setText("Series & Televisión");
        chBoxSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxSeriesActionPerformed(evt);
            }
        });
        bg.add(chBoxSeries, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, 30));

        chBoxVideojuegos.setBackground(new java.awt.Color(255, 255, 255));
        chBoxVideojuegos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxVideojuegos.setForeground(new java.awt.Color(1, 22, 39));
        chBoxVideojuegos.setText("Videojuegos");
        chBoxVideojuegos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxVideojuegosActionPerformed(evt);
            }
        });
        bg.add(chBoxVideojuegos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 30));

        chBoxAnime.setBackground(new java.awt.Color(255, 255, 255));
        chBoxAnime.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxAnime.setForeground(new java.awt.Color(1, 22, 39));
        chBoxAnime.setText("Anime");
        chBoxAnime.setToolTipText("");
        chBoxAnime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxAnimeActionPerformed(evt);
            }
        });
        bg.add(chBoxAnime, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 30));

        chBoxDeportes.setBackground(new java.awt.Color(255, 255, 255));
        chBoxDeportes.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxDeportes.setForeground(new java.awt.Color(1, 22, 39));
        chBoxDeportes.setText("Deportes");
        chBoxDeportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxDeportesActionPerformed(evt);
            }
        });
        bg.add(chBoxDeportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, 30));

        chBoxMusica.setBackground(new java.awt.Color(255, 255, 255));
        chBoxMusica.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxMusica.setForeground(new java.awt.Color(1, 22, 39));
        chBoxMusica.setText("Música");
        chBoxMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxMusicaActionPerformed(evt);
            }
        });
        bg.add(chBoxMusica, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, 30));

        chBoxDisney.setBackground(new java.awt.Color(255, 255, 255));
        chBoxDisney.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxDisney.setForeground(new java.awt.Color(1, 22, 39));
        chBoxDisney.setText("Disney");
        chBoxDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxDisneyActionPerformed(evt);
            }
        });
        bg.add(chBoxDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, 30));

        separator2.setBackground(new java.awt.Color(177, 178, 181));

        javax.swing.GroupLayout separator2Layout = new javax.swing.GroupLayout(separator2);
        separator2.setLayout(separator2Layout);
        separator2Layout.setHorizontalGroup(
            separator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        separator2Layout.setVerticalGroup(
            separator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        bg.add(separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 232, 1));

        lblEstado.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(1, 22, 39));
        lblEstado.setText("Estado");
        lblEstado.setToolTipText("");
        bg.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 116, 30));

        chBoxNew.setBackground(new java.awt.Color(255, 255, 255));
        chBoxNew.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxNew.setForeground(new java.awt.Color(1, 22, 39));
        chBoxNew.setText("Nueva");
        chBoxNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxNewActionPerformed(evt);
            }
        });
        bg.add(chBoxNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, 30));

        chBoxNearMint.setBackground(new java.awt.Color(255, 255, 255));
        chBoxNearMint.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxNearMint.setForeground(new java.awt.Color(1, 22, 39));
        chBoxNearMint.setText("Casi nueva");
        chBoxNearMint.setToolTipText("");
        chBoxNearMint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxNearMintActionPerformed(evt);
            }
        });
        bg.add(chBoxNearMint, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, 30));

        chBoxUsada.setBackground(new java.awt.Color(255, 255, 255));
        chBoxUsada.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxUsada.setForeground(new java.awt.Color(1, 22, 39));
        chBoxUsada.setText("Usada/Fuera de la caja");
        chBoxUsada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxUsadaActionPerformed(evt);
            }
        });
        bg.add(chBoxUsada, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, -1, 30));

        chBoxDamaged.setBackground(new java.awt.Color(255, 255, 255));
        chBoxDamaged.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxDamaged.setForeground(new java.awt.Color(1, 22, 39));
        chBoxDamaged.setText("Dañada");
        chBoxDamaged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxDamagedActionPerformed(evt);
            }
        });
        bg.add(chBoxDamaged, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, -1, 30));

        chBoxRestaurada.setBackground(new java.awt.Color(255, 255, 255));
        chBoxRestaurada.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chBoxRestaurada.setForeground(new java.awt.Color(1, 22, 39));
        chBoxRestaurada.setText("Restaurada");
        chBoxRestaurada.setToolTipText("");
        chBoxRestaurada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBoxRestauradaActionPerformed(evt);
            }
        });
        bg.add(chBoxRestaurada, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, -1, 30));

        btnComentario.setBackground(new java.awt.Color(1, 22, 39));
        btnComentario.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        btnComentario.setForeground(new java.awt.Color(255, 255, 255));
        btnComentario.setText("Ofrecer Intercambio");
        btnComentario.setToolTipText("");
        btnComentario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 2, true));
        btnComentario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComentario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnComentarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnComentarioMouseExited(evt);
            }
        });
        bg.add(btnComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 740, 230, 52));

        btnReview.setBackground(new java.awt.Color(1, 22, 39));
        btnReview.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        btnReview.setForeground(new java.awt.Color(255, 255, 255));
        btnReview.setText("Dejar Reseña");
        btnReview.setToolTipText("");
        btnReview.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 2, true));
        btnReview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReviewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReviewMouseExited(evt);
            }
        });
        btnReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewActionPerformed(evt);
            }
        });
        bg.add(btnReview, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 90, 194, 52));

        btnComentario1.setBackground(new java.awt.Color(1, 22, 39));
        btnComentario1.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        btnComentario1.setForeground(new java.awt.Color(255, 255, 255));
        btnComentario1.setText("Dejar Comentario");
        btnComentario1.setToolTipText("");
        btnComentario1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 22, 39), 2, true));
        btnComentario1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComentario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentario1ActionPerformed(evt);
            }
        });
        bg.add(btnComentario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 194, 52));

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

    private void btnComentarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComentarioMouseEntered
        btnComentario.setBackground(Color.decode("#033762"));
    }//GEN-LAST:event_btnComentarioMouseEntered

    private void btnComentarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComentarioMouseExited
        btnComentario.setBackground(Color.decode("#011627"));
    }//GEN-LAST:event_btnComentarioMouseExited

    private void btnReviewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReviewMouseEntered
        btnReview.setBackground(Color.decode("#033762"));
    }//GEN-LAST:event_btnReviewMouseEntered

    private void btnReviewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReviewMouseExited
        btnReview.setBackground(Color.decode("#011627"));
    }//GEN-LAST:event_btnReviewMouseExited

    private void configureCategoryFilter() {
        List<RowFilter<Object, Object>> filters = new ArrayList<>();

        List<String> selectedCategories = new ArrayList<>();
        if (chBoxComics.isSelected()) {
            selectedCategories.add("Cómics & Superhéroes");
        }
        if (chBoxPeliculas.isSelected()) {
            selectedCategories.add("Películas");
        }
        if (chBoxSeries.isSelected()) {
            selectedCategories.add("Series & Televisión");
        }
        if (chBoxVideojuegos.isSelected()) {
            selectedCategories.add("Videojuegos");
        }
        if (chBoxAnime.isSelected()) {
            selectedCategories.add("Anime");
        }
        if (chBoxDeportes.isSelected()) {
            selectedCategories.add("Deportes");
        }
        if (chBoxMusica.isSelected()) {
            selectedCategories.add("Música");
        }
        if (chBoxDisney.isSelected()) {
            selectedCategories.add("Disney");
        }

        List<String> selectedStates = new ArrayList<>();
        if (chBoxNew.isSelected()) {
            selectedStates.add("Nueva");
        }
        if (chBoxNearMint.isSelected()) {
            selectedStates.add("Casi nueva");
        }
        if (chBoxUsada.isSelected()) {
            selectedStates.add("Usada/Fuera de la caja");
        }
        if (chBoxDamaged.isSelected()) {
            selectedStates.add("Dañada");
        }
        if (chBoxRestaurada.isSelected()) {
            selectedStates.add("Restaurada");
        }

        if (!selectedCategories.isEmpty()) {
            RowFilter<Object, Object> categoryFilter = RowFilter.orFilter(selectedCategories.stream()
                    .map(category -> RowFilter.regexFilter("(?i)" + category))
                    .collect(Collectors.toList()));
            filters.add(categoryFilter);
        }

        if (!selectedStates.isEmpty()) {
            RowFilter<Object, Object> stateFilter = RowFilter.orFilter(selectedStates.stream()
                    .map(state -> RowFilter.regexFilter("(?i)" + state))
                    .collect(Collectors.toList()));
            filters.add(stateFilter);
        }

        String searchText = searchTxt.getText().trim();
        if (!searchText.isEmpty() && !searchText.equals("Buscar figuras")) {
            RowFilter<Object, Object> searchFilter = RowFilter.regexFilter("(?i)" + searchText);
            filters.add(searchFilter);
        }

        if (filters.isEmpty()) {
            rowSorter.setRowFilter(null);
        } else {
            RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);
            rowSorter.setRowFilter(combinedFilter);
        }
    }


    private void chBoxComicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxComicsActionPerformed
        configureCategoryFilter();
    }//GEN-LAST:event_chBoxComicsActionPerformed

    private void chBoxPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxPeliculasActionPerformed
        configureCategoryFilter();
    }//GEN-LAST:event_chBoxPeliculasActionPerformed

    private void chBoxSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxSeriesActionPerformed
        configureCategoryFilter();
    }//GEN-LAST:event_chBoxSeriesActionPerformed

    private void chBoxVideojuegosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxVideojuegosActionPerformed
        configureCategoryFilter();
    }//GEN-LAST:event_chBoxVideojuegosActionPerformed

    private void chBoxAnimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxAnimeActionPerformed
        configureCategoryFilter();
    }//GEN-LAST:event_chBoxAnimeActionPerformed

    private void chBoxDeportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxDeportesActionPerformed
        configureCategoryFilter();
    }//GEN-LAST:event_chBoxDeportesActionPerformed

    private void chBoxMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxMusicaActionPerformed
        configureCategoryFilter();
    }//GEN-LAST:event_chBoxMusicaActionPerformed

    private void chBoxDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxDisneyActionPerformed
        configureCategoryFilter();

    }//GEN-LAST:event_chBoxDisneyActionPerformed

    private void chBoxNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxNewActionPerformed
        configureCategoryFilter();
    }//GEN-LAST:event_chBoxNewActionPerformed

    private void chBoxNearMintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxNearMintActionPerformed
        configureCategoryFilter();
    }//GEN-LAST:event_chBoxNearMintActionPerformed

    private void chBoxUsadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxUsadaActionPerformed
        configureCategoryFilter();
    }//GEN-LAST:event_chBoxUsadaActionPerformed

    private void chBoxDamagedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxDamagedActionPerformed
        configureCategoryFilter();
    }//GEN-LAST:event_chBoxDamagedActionPerformed

    private void chBoxRestauradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBoxRestauradaActionPerformed
        configureCategoryFilter();
    }//GEN-LAST:event_chBoxRestauradaActionPerformed

    private void lblMisFigurasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMisFigurasMouseClicked
        new MisFiguras(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblMisFigurasMouseClicked

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        configureCategoryFilter();
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

    private void btnComentario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentario1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRowIndex = table.getSelectedRow();

        if (selectedRowIndex != -1) {
            String serialNumber = model.getValueAt(selectedRowIndex, 0).toString();

            MutablePair<ArrayList<Figura>, Usuario> resultado = (MutablePair<ArrayList<Figura>, Usuario>) obtenerFiguras();

            Figura figuraInfo = null;

            for (Figura figura : figuras) {
                if (figura.getNumeroSerie().equals(serialNumber)) {
                    figuraInfo = figura;
                    break;
                }
            }

            if (figuraInfo != null) {
                new Comentarios(usuario, figuraInfo).setVisible(true);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una figura para comentar");
        }


    }//GEN-LAST:event_btnComentario1ActionPerformed

    private void btnReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRowIndex = table.getSelectedRow();

        if (selectedRowIndex != -1) {
            String serialNumber = model.getValueAt(selectedRowIndex, 0).toString();

            MutablePair<ArrayList<Figura>, Usuario> resultado = (MutablePair<ArrayList<Figura>, Usuario>) obtenerFiguras();

            Figura figuraInfo = null;

            for (Figura figura : figuras) {
                if (figura.getNumeroSerie().equals(serialNumber)) {
                    figuraInfo = figura;
                    break;
                }
            }

            if (figuraInfo != null) {
                new AñadirReseña(usuario, figuraInfo).setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una figura para calificar");
        }
    }//GEN-LAST:event_btnReviewActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = new Usuario();
                new Inicio2(usuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TEST;
    private javax.swing.JLabel bellIcon;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnComentario;
    private javax.swing.JButton btnComentario1;
    private javax.swing.JButton btnReview;
    private javax.swing.JCheckBox chBoxAnime;
    private javax.swing.JCheckBox chBoxComics;
    private javax.swing.JCheckBox chBoxDamaged;
    private javax.swing.JCheckBox chBoxDeportes;
    private javax.swing.JCheckBox chBoxDisney;
    private javax.swing.JCheckBox chBoxMusica;
    private javax.swing.JCheckBox chBoxNearMint;
    private javax.swing.JCheckBox chBoxNew;
    private javax.swing.JCheckBox chBoxPeliculas;
    private javax.swing.JCheckBox chBoxRestaurada;
    private javax.swing.JCheckBox chBoxSeries;
    private javax.swing.JCheckBox chBoxUsada;
    private javax.swing.JCheckBox chBoxVideojuegos;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFiltros;
    private javax.swing.JLabel lblMisFiguras;
    private javax.swing.JLabel lblNoticiasYEventos;
    private javax.swing.JLabel lblRecomendaciones;
    private javax.swing.JPanel navBar;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JPanel separator;
    private javax.swing.JPanel separator2;
    private javax.swing.JTable table;
    private javax.swing.JLabel userIcon;
    // End of variables declaration//GEN-END:variables
}
