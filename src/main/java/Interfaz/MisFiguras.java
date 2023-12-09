package Interfaz;

import Clases.Figura;
import Clases.Usuario;
import Excepciones.IOFiguraException;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MisFiguras extends javax.swing.JFrame {

    private Usuario usuario;

    public MisFiguras(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        setComponentProperties();

    }

    public final void setComponentProperties() {
        ImageIcon logo1 = new ImageIcon("bell-regular.png");
        ImageIcon logo2 = new ImageIcon("circle-user-regular.png");
        ImageIcon logo3 = new ImageIcon("house-solid.png");
        ImageIcon logo4 = new ImageIcon("fidepop!.png");

        lblIconoNotificaciones.setText("");
        lblIconoNotificaciones.setIcon(logo1);
        lblIconoNotificaciones.setBounds(50, 50, lblIconoNotificaciones.getPreferredSize().width, lblIconoNotificaciones.getPreferredSize().height);

        lblIconoPerfil.setText("");
        lblIconoPerfil.setIcon(logo2);
        lblIconoPerfil.setBounds(50, 50, lblIconoPerfil.getPreferredSize().width, lblIconoPerfil.getPreferredSize().height);

        lblIconoCasita.setText("");
        lblIconoCasita.setIcon(logo3);
        lblIconoCasita.setBounds(50, 50, lblIconoCasita.getPreferredSize().width, lblIconoCasita.getPreferredSize().height);

        lbllblIconoFidePop.setText("");
        lbllblIconoFidePop.setIcon(logo4);
        lbllblIconoFidePop.setBounds(50, 50, lbllblIconoFidePop.getPreferredSize().width, lbllblIconoFidePop.getPreferredSize().height);

        setTableProperties();
        setFormProperties();

    }

    private void setTableProperties() {
        JTableHeader tHeader = jtblVerEditar.getTableHeader();
        tHeader.setBackground(Color.decode("#011627"));
        tHeader.setForeground(Color.WHITE);
        tHeader.setFont(new Font("Roboto", Font.BOLD, 20));
        tHeader.setVisible(true);

        DefaultTableModel model = (DefaultTableModel) jtblVerEditar.getModel();
        ArrayList<Figura> coleccion = usuario.getColeccion();

        Object rowData[] = new Object[9];
        for (Figura figura : coleccion) {

            int counter = figura.getResenias().size();
            rowData[0] = figura.getNumeroSerie();
            rowData[1] = figura.getNombre();
            rowData[2] = figura.getMarca();
            rowData[3] = figura.getFechaAdquisicion();
            rowData[4] = figura.getEstado();
            rowData[5] = figura.getTamanio();
            rowData[6] = figura.getCategoria();
            rowData[7] = figura.getValor();

            rowData[8] = counter;
            model.addRow(rowData);

        }

    }

    private void setFormProperties() {
        cboxCategoria.addItem("Cómics & Superhéroes");
        cboxCategoria.addItem("Películas");
        cboxCategoria.addItem("Series & Televisión");
        cboxCategoria.addItem("Videojuegos");
        cboxCategoria.addItem("Anime");
        cboxCategoria.addItem("Deportes");
        cboxCategoria.addItem("Música");
        cboxCategoria.addItem("Disney");
        cboxCategoria.addItem("Otros");

        cboxEstado.addItem("Nueva");
        cboxEstado.addItem("Casi Nueva");
        cboxEstado.addItem("Usada/Fuera de la caja");
        cboxEstado.addItem("Dañada");
        cboxEstado.addItem("Restaurada");
    }

    private static boolean isInvalidFigureName(String nombre) {
        return nombre.isEmpty() || nombre.equals("Ingrese el nombre de la figura");
    }

    private static boolean isInvalidSerialNumber(String numeroSerie) {
        return numeroSerie.isEmpty() || numeroSerie.equals("Ingrese el número de serie de la figura");
    }

    private static boolean isInvalidSize(String size) {
        if (size.isEmpty() || size.equals("Ingrese el tamaño de la figura")) {
            return true;
        }

        try {
            Double.valueOf(size);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private static boolean isInvalidDate(String dateString) {
        if (dateString.isEmpty()) {
            return true;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM y");
        sdf.setLenient(false);

        try {

            Date date = sdf.parse(dateString);

            String formattedDate = sdf.format(date);
            if (!dateString.equals(formattedDate)) {
                return true;
            }

        } catch (ParseException e) {
            return true;
        }

        return false;
    }

    private static boolean isInvalidCategory(String category) {
        return category.equals("Seleccione la categoría de la figura");
    }

    private static boolean isInvalidState(String state) {
        return state.equals("Seleccione el estado de la figura");
    }

    private static boolean isInvalidPrice(String price) {

        if (price.isEmpty() || price.equals("Ingrese el precio estimado de la figura")) {
            return true;
        }

        try {
            Double.valueOf(price);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private static boolean isInvalidBrand(String brand) {
        return brand.isEmpty() || brand.equals("Ingrese la marca de la figura");
    }

    private Figura getFigureInformation() {
        Figura figura = new Figura();

        String nombre = txtNombre.getText();
        String numeroSerie = txtNumeroSerie.getText();
        String tamanio = txtTamanho.getText();
        LocalDate fecha = null;
        String formattedDate = "";

        if (dateChooser.getDate() != null) {
            Date dateFromChooser = dateChooser.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM y");
            formattedDate = sdf.format(dateFromChooser);

            try {
                fecha = LocalDate.parse(formattedDate, DateTimeFormatter.ofPattern("dd MMM y"));
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Error al formatear la fecha");
            }
        }

        String categoria = cboxCategoria.getSelectedItem().toString();
        String estado = cboxEstado.getSelectedItem().toString();
        String precio = txtPrecioEstimado.getText();
        String marca = txtMarca.getText();

        if (isInvalidFigureName(nombre)) {
            JOptionPane.showMessageDialog(this, "El campo nombre de figura debe ser completado");
        } else if (isInvalidSerialNumber(numeroSerie)) {
            JOptionPane.showMessageDialog(this, "El campo numero de serie debe ser completado");
        } else if (isInvalidSize(tamanio)) {
            JOptionPane.showMessageDialog(this, "El campo tamaño debe ser completado o fue ingresado en un formato incorrecto");
        } else if (fecha == null || fecha.toString() == null || isInvalidDate(formattedDate)) {
            JOptionPane.showMessageDialog(this, "El campo fecha debe ser completado o fue ingresado en un formato incorrecto");
        } else if (isInvalidCategory(categoria)) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una categoría para su figura");
        } else if (isInvalidState(estado)) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione el estado de su figura");
        } else if (isInvalidPrice(precio)) {
            JOptionPane.showMessageDialog(this, "El campo precio debe ser completado o fue ingresado en un formato incorrecto");
        } else if (isInvalidBrand(marca)) {
            JOptionPane.showMessageDialog(this, "El campo marca debe ser completado");
        } else {
            figura.setNombre(nombre);
            figura.setNumeroSerie(numeroSerie);
            figura.setTamanio(Double.valueOf(tamanio));
            figura.setFechaAdquisicion(fecha);
            figura.setCategoria(categoria);
            figura.setEstado(estado);
            figura.setValor(Double.valueOf(precio));
            figura.setMarca(marca);
        }

        return figura;
    }

    private void reestablecerCampos() {
        txtNombre.setText("Ingrese el nombre de la figura");
        txtNumeroSerie.setText("Ingrese el número de serie de la figura");
        txtTamanho.setText("Ingrese el tamaño de la figura");
        txtMarca.setText("Ingrese la marca de la figura");
        txtPrecioEstimado.setText("Ingrese el precio estimado de la figura");
        dateChooser.setDate(null);
        cboxCategoria.setSelectedIndex(0);
        cboxEstado.setSelectedIndex(0);
    }

    private void updateTableContent(Figura figura) {
        DefaultTableModel model = (DefaultTableModel) jtblVerEditar.getModel();
        Object rowData[] = new Object[9];

        int counter = figura.getResenias().size();
        rowData[0] = figura.getNumeroSerie();
        rowData[1] = figura.getNombre();
        rowData[2] = figura.getMarca();
        rowData[3] = figura.getFechaAdquisicion();
        rowData[4] = figura.getEstado();
        rowData[5] = figura.getTamanio();
        rowData[6] = figura.getCategoria();
        rowData[7] = figura.getValor();
        rowData[8] = counter;
        model.addRow(rowData);
    }

    private void deleteTableRow() {
        DefaultTableModel model = (DefaultTableModel) jtblVerEditar.getModel();

        int selectedRow = jtblVerEditar.getSelectedRow();

        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Aún no has agregado figuras a tu colección, por lo que no puedes eliminar");
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione la figura que desea eliminar de su lista");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlWhiteBackground = new javax.swing.JPanel();
        tbpnlMisFiguras = new javax.swing.JTabbedPane();
        pnlVerEditarFigura = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblVerEditar = new javax.swing.JTable();
        btnEliminarFigura = new javax.swing.JButton();
        btnEditarFigura = new javax.swing.JButton();
        pnlAgregarFigura = new javax.swing.JPanel();
        lblAgregarFigura = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNumeroSerie = new javax.swing.JLabel();
        txtNumeroSerie = new javax.swing.JTextField();
        lblTamanho = new javax.swing.JLabel();
        txtTamanho = new javax.swing.JTextField();
        lblFechaAdquisicion = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        cboxCategoria = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        cboxEstado = new javax.swing.JComboBox<>();
        lblPrecioEstimado = new javax.swing.JLabel();
        txtPrecioEstimado = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        btnAgregarFigura = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        pnlNavTab = new javax.swing.JPanel();
        searchTxt1 = new javax.swing.JTextField();
        searchTxt = new javax.swing.JTextField();
        lblNoticiasEventos = new javax.swing.JLabel();
        lblMisFiguras = new javax.swing.JLabel();
        lblRecomendaciones = new javax.swing.JLabel();
        lblIconoNotificaciones = new javax.swing.JLabel();
        lblIconoPerfil = new javax.swing.JLabel();
        lblIconoCasita = new javax.swing.JLabel();
        pnlBlueBarMisFiguras = new javax.swing.JPanel();
        lblBlueBarMisFiguras = new javax.swing.JLabel();
        lbllblIconoFidePop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 830));
        setMinimumSize(new java.awt.Dimension(1280, 830));
        setPreferredSize(new java.awt.Dimension(1280, 830));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 830));

        pnlWhiteBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlWhiteBackground.setMaximumSize(new java.awt.Dimension(1280, 830));
        pnlWhiteBackground.setMinimumSize(new java.awt.Dimension(1280, 830));
        pnlWhiteBackground.setPreferredSize(new java.awt.Dimension(1280, 830));
        pnlWhiteBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbpnlMisFiguras.setBackground(new java.awt.Color(255, 255, 255));
        tbpnlMisFiguras.setMaximumSize(new java.awt.Dimension(1280, 32767));
        tbpnlMisFiguras.setMinimumSize(new java.awt.Dimension(1280, 1));
        tbpnlMisFiguras.setPreferredSize(new java.awt.Dimension(1280, 100));

        pnlVerEditarFigura.setBackground(new java.awt.Color(255, 255, 255));
        pnlVerEditarFigura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtblVerEditar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jtblVerEditar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "# Serie", "Nombre", "Marca", "Fecha", "Estado", "Tamaño", "Categoría", "Precio", "Reseñas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblVerEditar.setRowHeight(35);
        jtblVerEditar.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtblVerEditar);
        jtblVerEditar.getAccessibleContext().setAccessibleName("");
        jtblVerEditar.getAccessibleContext().setAccessibleDescription("");

        pnlVerEditarFigura.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1200, 370));

        btnEliminarFigura.setBackground(new java.awt.Color(1, 22, 39));
        btnEliminarFigura.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        btnEliminarFigura.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarFigura.setText("Eliminar figura");
        btnEliminarFigura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarFigura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFiguraActionPerformed(evt);
            }
        });
        pnlVerEditarFigura.add(btnEliminarFigura, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 420, 210, 40));
        btnEliminarFigura.getAccessibleContext().setAccessibleName("Agrega una nueva figura");

        btnEditarFigura.setBackground(new java.awt.Color(1, 22, 39));
        btnEditarFigura.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        btnEditarFigura.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarFigura.setText("Editar figura");
        btnEditarFigura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarFigura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarFiguraActionPerformed(evt);
            }
        });
        pnlVerEditarFigura.add(btnEditarFigura, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, 210, 40));

        tbpnlMisFiguras.addTab("Ver/Editar", pnlVerEditarFigura);

        pnlAgregarFigura.setBackground(new java.awt.Color(255, 255, 255));
        pnlAgregarFigura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAgregarFigura.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblAgregarFigura.setForeground(new java.awt.Color(1, 22, 39));
        lblAgregarFigura.setText("¡AGREGA UNA NUEVA FIGURA A TU COLECCIÓN!");
        pnlAgregarFigura.add(lblAgregarFigura, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        lblNombre.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(1, 22, 39));
        lblNombre.setText("Nombre");
        pnlAgregarFigura.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtNombre.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(128, 128, 128));
        txtNombre.setText("Ingrese el nombre de la figura");
        txtNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        pnlAgregarFigura.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 595, 30));

        lblNumeroSerie.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblNumeroSerie.setForeground(new java.awt.Color(1, 22, 39));
        lblNumeroSerie.setText("Número de serie");
        pnlAgregarFigura.add(lblNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txtNumeroSerie.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtNumeroSerie.setForeground(new java.awt.Color(128, 128, 128));
        txtNumeroSerie.setText("Ingrese el número de serie de la figura");
        txtNumeroSerie.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtNumeroSerie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumeroSerieFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroSerieFocusLost(evt);
            }
        });
        pnlAgregarFigura.add(txtNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 595, 30));

        lblTamanho.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblTamanho.setForeground(new java.awt.Color(1, 22, 39));
        lblTamanho.setText("Tamaño");
        pnlAgregarFigura.add(lblTamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txtTamanho.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtTamanho.setForeground(new java.awt.Color(128, 128, 128));
        txtTamanho.setText("Ingrese el tamaño de la figura");
        txtTamanho.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtTamanho.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTamanhoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTamanhoFocusLost(evt);
            }
        });
        pnlAgregarFigura.add(txtTamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 223, 595, 30));

        lblFechaAdquisicion.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblFechaAdquisicion.setForeground(new java.awt.Color(1, 22, 39));
        lblFechaAdquisicion.setText("Fecha de adquisición");
        pnlAgregarFigura.add(lblFechaAdquisicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        lblCategoria.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(1, 22, 39));
        lblCategoria.setText("Categoría");
        pnlAgregarFigura.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        cboxCategoria.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        cboxCategoria.setForeground(new java.awt.Color(128, 128, 128));
        cboxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la categoría de la figura" }));
        cboxCategoria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pnlAgregarFigura.add(cboxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 595, 30));

        lblEstado.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(1, 22, 39));
        lblEstado.setText("Estado");
        pnlAgregarFigura.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        cboxEstado.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        cboxEstado.setForeground(new java.awt.Color(128, 128, 128));
        cboxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el estado de la figura" }));
        cboxEstado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        pnlAgregarFigura.add(cboxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 427, 595, 30));

        lblPrecioEstimado.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblPrecioEstimado.setForeground(new java.awt.Color(1, 22, 39));
        lblPrecioEstimado.setText("Precio estimado");
        pnlAgregarFigura.add(lblPrecioEstimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, -1, -1));

        txtPrecioEstimado.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtPrecioEstimado.setForeground(new java.awt.Color(128, 128, 128));
        txtPrecioEstimado.setText("Ingrese el precio estimado de la figura");
        txtPrecioEstimado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtPrecioEstimado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioEstimadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioEstimadoFocusLost(evt);
            }
        });
        pnlAgregarFigura.add(txtPrecioEstimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 595, 30));

        lblMarca.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(1, 22, 39));
        lblMarca.setText("Marca");
        pnlAgregarFigura.add(lblMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        txtMarca.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(128, 128, 128));
        txtMarca.setText("Ingrese la marca de la figura");
        txtMarca.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtMarca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMarcaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMarcaFocusLost(evt);
            }
        });
        pnlAgregarFigura.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 163, 595, 30));

        btnAgregarFigura.setBackground(new java.awt.Color(1, 22, 39));
        btnAgregarFigura.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        btnAgregarFigura.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarFigura.setText("Agregar Figura");
        btnAgregarFigura.setToolTipText("");
        btnAgregarFigura.setBorder(null);
        btnAgregarFigura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarFigura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarFiguraMouseClicked(evt);
            }
        });
        pnlAgregarFigura.add(btnAgregarFigura, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 250, 40));

        dateChooser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        dateChooser.setDateFormatString("dd MMM y");
        dateChooser.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        pnlAgregarFigura.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 595, 30));

        tbpnlMisFiguras.addTab("AgregarFigura", pnlAgregarFigura);

        pnlWhiteBackground.add(tbpnlMisFiguras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1290, 540));

        pnlNavTab.setBackground(new java.awt.Color(1, 22, 39));
        pnlNavTab.setMaximumSize(new java.awt.Dimension(1280, 100));
        pnlNavTab.setMinimumSize(new java.awt.Dimension(1280, 100));

        searchTxt1.setBackground(new java.awt.Color(1, 22, 39));
        searchTxt1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        searchTxt1.setForeground(new java.awt.Color(226, 226, 226));
        searchTxt1.setBorder(null);

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

        javax.swing.GroupLayout pnlNavTabLayout = new javax.swing.GroupLayout(pnlNavTab);
        pnlNavTab.setLayout(pnlNavTabLayout);
        pnlNavTabLayout.setHorizontalGroup(
            pnlNavTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavTabLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblIconoCasita)
                .addGap(26, 26, 26)
                .addGroup(pnlNavTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(searchTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(pnlNavTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNoticiasEventos)
                    .addComponent(lblMisFiguras)
                    .addComponent(lblRecomendaciones)
                    .addComponent(lblIconoNotificaciones)
                    .addComponent(lblIconoPerfil)
                    .addComponent(lblIconoCasita))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pnlWhiteBackground.add(pnlNavTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1290, 100));

        pnlBlueBarMisFiguras.setBackground(new java.awt.Color(1, 22, 39));
        pnlBlueBarMisFiguras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBlueBarMisFiguras.setBackground(new java.awt.Color(255, 255, 255));
        lblBlueBarMisFiguras.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        lblBlueBarMisFiguras.setForeground(new java.awt.Color(255, 255, 255));
        lblBlueBarMisFiguras.setText("Mis Figuras");
        pnlBlueBarMisFiguras.add(lblBlueBarMisFiguras, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 22, -1, -1));

        lbllblIconoFidePop.setText("jLabel1");
        pnlBlueBarMisFiguras.add(lbllblIconoFidePop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlWhiteBackground.add(pnlBlueBarMisFiguras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 151, 700, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlWhiteBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWhiteBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        if (txtNombre.getText().equals("Ingrese el nombre de la figura")) {
            txtNombre.setText("");
            txtNombre.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if (txtNombre.getText().isEmpty()) {
            txtNombre.setText("Ingrese el nombre de la figura");
            txtNombre.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtNumeroSerieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroSerieFocusGained
        if (txtNumeroSerie.getText().equals("Ingrese el número de serie de la figura")) {
            txtNumeroSerie.setText("");
            txtNumeroSerie.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNumeroSerieFocusGained

    private void txtNumeroSerieFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroSerieFocusLost
        if (txtNumeroSerie.getText().isEmpty()) {
            txtNumeroSerie.setText("Ingrese el número de serie de la figura");
            txtNumeroSerie.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtNumeroSerieFocusLost

    private void txtTamanhoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTamanhoFocusGained
        if (txtTamanho.getText().equals("Ingrese el tamaño de la figura")) {
            txtTamanho.setText("");
            txtTamanho.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtTamanhoFocusGained

    private void txtTamanhoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTamanhoFocusLost
        if (txtTamanho.getText().isEmpty()) {
            txtTamanho.setText("Ingrese el tamaño de la figura");
            txtTamanho.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtTamanhoFocusLost

    private void txtPrecioEstimadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioEstimadoFocusGained
        if (txtPrecioEstimado.getText().equals("Ingrese el precio estimado de la figura")) {
            txtPrecioEstimado.setText("");
            txtPrecioEstimado.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtPrecioEstimadoFocusGained

    private void txtPrecioEstimadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioEstimadoFocusLost
        if (txtPrecioEstimado.getText().isEmpty()) {
            txtPrecioEstimado.setText("Ingrese el precio estimado de la figura");
            txtPrecioEstimado.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPrecioEstimadoFocusLost

    private void txtMarcaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMarcaFocusGained
        if (txtMarca.getText().equals("Ingrese la marca de la figura")) {
            txtMarca.setText("");
            txtMarca.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtMarcaFocusGained

    private void txtMarcaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMarcaFocusLost
        if (txtMarca.getText().isEmpty()) {
            txtMarca.setText("Ingrese la marca de la figura");
            txtMarca.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtMarcaFocusLost

    private void btnAgregarFiguraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarFiguraMouseClicked
        Figura figura = getFigureInformation();
        if (figura.validarAtributos()) {
            Figura.crearFiguraDB(figura, this.usuario.getUsername());
            JOptionPane.showMessageDialog(this, "Se agregó la figura a tu lista de figuras");
            reestablecerCampos();
            updateTableContent(figura);
        }
    }//GEN-LAST:event_btnAgregarFiguraMouseClicked

    private Figura validarDatosFiguraEditada() {
        Figura figura = new Figura();
        DefaultTableModel model = (DefaultTableModel) jtblVerEditar.getModel();

        int selectedRowIndex = jtblVerEditar.getSelectedRow();

        String nombre = model.getValueAt(selectedRowIndex, 1).toString();
        String marca = model.getValueAt(selectedRowIndex, 2).toString();
        String estado = model.getValueAt(selectedRowIndex, 4).toString();
        String tamanio = model.getValueAt(selectedRowIndex, 5).toString();
        String categoria = model.getValueAt(selectedRowIndex, 6).toString();
        String precio = model.getValueAt(selectedRowIndex, 7).toString();

        try {
            if (isInvalidFigureName(nombre)) {
                throw new IOFiguraException("El nombre de la figura no puede quedar en blanco");
            } else if (isInvalidBrand(marca)) {
                throw new IOFiguraException("La marca de la figura no puede quedar en blanco");
            } else if (isInvalidState(estado)) {
                throw new IOFiguraException("El estado de la figura no puede quedar en blanco");
            } else if (isInvalidSize(tamanio)) {
                throw new IOFiguraException("El tamaño de la figura no puede quedar en blanco o lo ingresaste en un formato incorrecto");
            } else if (isInvalidCategory(categoria)) {
                throw new IOFiguraException("La categoría de la figura no puede quedar en blanco");
            } else if (isInvalidPrice(precio)) {
                throw new IOFiguraException("El precio de la figura no puede quedar en blanco o lo ingresaste en un formato incorrecto");
            } else {
                figura.setNumeroSerie(model.getValueAt(selectedRowIndex, 0).toString());
                figura.setNombre(nombre);
                figura.setMarca(marca);
                figura.setFechaAdquisicion((LocalDate) model.getValueAt(selectedRowIndex, 3));
                figura.setEstado(estado);
                figura.setTamanio(Double.valueOf(tamanio));
                figura.setCategoria(categoria);
                figura.setValor(Double.valueOf(precio));

                return figura;
            }
        } catch (IOFiguraException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        return null;
    }

    private void btnEditarFiguraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarFiguraActionPerformed
        Figura figura = validarDatosFiguraEditada();

        if (figura != null) {
            Figura.actualizarFiguraDB(figura, usuario.getUsername());
            JOptionPane.showMessageDialog(this, "La información de su figura ha sido actualizada");
        }


    }//GEN-LAST:event_btnEditarFiguraActionPerformed

    private void btnEliminarFiguraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFiguraActionPerformed
        Figura figura = new Figura();
        DefaultTableModel model = (DefaultTableModel) jtblVerEditar.getModel();

        int selectedRowIndex = jtblVerEditar.getSelectedRow();

        if (selectedRowIndex != -1) {
            figura.setNumeroSerie(model.getValueAt(selectedRowIndex, 0).toString());
            figura.setNombre(model.getValueAt(selectedRowIndex, 1).toString());
            figura.setMarca(model.getValueAt(selectedRowIndex, 2).toString());
            figura.setFechaAdquisicion((LocalDate) model.getValueAt(selectedRowIndex, 3));
            figura.setEstado(model.getValueAt(selectedRowIndex, 4).toString());
            figura.setTamanio((Double) model.getValueAt(selectedRowIndex, 5));
            figura.setCategoria(model.getValueAt(selectedRowIndex, 6).toString());
            figura.setValor((Double) model.getValueAt(selectedRowIndex, 7));

            Figura.eliminarFiguraDB(figura.getNumeroSerie());
            deleteTableRow();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione la figura que desea eliminar de su lista");
    }//GEN-LAST:event_btnEliminarFiguraActionPerformed
    }

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

    private void lblIconoCasitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconoCasitaMouseClicked
        new Inicio2(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblIconoCasitaMouseClicked

    private void lblIconoPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconoPerfilMouseClicked
        new Perfil(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblIconoPerfilMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = new Usuario();
                new MisFiguras(usuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFigura;
    private javax.swing.JButton btnEditarFigura;
    private javax.swing.JButton btnEliminarFigura;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JComboBox<String> cboxEstado;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblVerEditar;
    private javax.swing.JLabel lblAgregarFigura;
    private javax.swing.JLabel lblBlueBarMisFiguras;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaAdquisicion;
    private javax.swing.JLabel lblIconoCasita;
    private javax.swing.JLabel lblIconoNotificaciones;
    private javax.swing.JLabel lblIconoPerfil;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMisFiguras;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNoticiasEventos;
    private javax.swing.JLabel lblNumeroSerie;
    private javax.swing.JLabel lblPrecioEstimado;
    private javax.swing.JLabel lblRecomendaciones;
    private javax.swing.JLabel lblTamanho;
    private javax.swing.JLabel lbllblIconoFidePop;
    private javax.swing.JPanel pnlAgregarFigura;
    private javax.swing.JPanel pnlBlueBarMisFiguras;
    private javax.swing.JPanel pnlNavTab;
    private javax.swing.JPanel pnlVerEditarFigura;
    private javax.swing.JPanel pnlWhiteBackground;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTextField searchTxt1;
    private javax.swing.JTabbedPane tbpnlMisFiguras;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroSerie;
    private javax.swing.JTextField txtPrecioEstimado;
    private javax.swing.JTextField txtTamanho;
    // End of variables declaration//GEN-END:variables
}
