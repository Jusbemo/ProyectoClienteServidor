package Clases;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Usuario implements Serializable {

    private String nombre;
    private String apellido;
    private int edad;
    private String pais;
    private String username;
    private String email;
    private String password;
    private ArrayList<Figura> coleccion;
    private ArrayList<String> intereses;

    public Usuario() {
        this.coleccion = new ArrayList<>();
        this.intereses = new ArrayList<>();
    }

    public Usuario(String nombre, String apellido, int edad, String pais, String username, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pais = pais;
        this.username = username;
        this.email = email;
        this.password = password;
        this.coleccion = new ArrayList<>();
        this.intereses = new ArrayList<>();
    }

    public Usuario(String nombre, String apellido, int edad, String pais, String username, String email, String password, ArrayList<Figura> coleccion, ArrayList<String> intereses) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pais = pais;
        this.username = username;
        this.email = email;
        this.password = password;
        this.coleccion = new ArrayList<>();
        this.intereses = new ArrayList<>();
    }

    public Usuario(String nombre, String apellido, int edad, String pais, String username, String email, String password, ArrayList<String> intereses) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pais = pais;
        this.username = username;
        this.email = email;
        this.password = password;
        this.coleccion = new ArrayList<>();
        this.intereses = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Figura> getColeccion() {
        return coleccion;
    }

    public void setColeccion(ArrayList<Figura> coleccion) {
        this.coleccion = coleccion;
    }

    public ArrayList<String> getIntereses() {
        return intereses;
    }

    public void setIntereses(ArrayList<String> intereses) {
        this.intereses = intereses;
    }

    public boolean validarAtributos() {

        if (this.nombre == null || this.nombre.isEmpty()
                || this.apellido == null || this.apellido.isEmpty()
                || this.pais == null || this.pais.isEmpty()
                || this.username == null || this.username.isEmpty()
                || this.email == null || this.email.isEmpty()
                || this.password == null || this.password.isEmpty()
                || this.edad < 16) {
            return false;
        }

        return this.intereses != null && !this.intereses.isEmpty();
    }

    public static boolean isInvalidUsername(JTextField usuarioTxtField) {
        String username = usuarioTxtField.getText().toLowerCase();

        if (username.isEmpty() || username.equalsIgnoreCase("Ingrese su nombre de usuario")) {
            return true;
        }
        String trimUsername = username.trim();
        Conexion objConexion = new Conexion();

        String sql = "SELECT * FROM usuarios WHERE usuario = ?";

        try {
            PreparedStatement ps = objConexion.establecerConexion().prepareStatement(sql);
            ps.setString(1, trimUsername);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos. Error: " + e.getMessage());
            return true;
        }

        return false;

    }

    private void hashPassword() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(this.password.getBytes());
            byte[] rbt = md.digest();

            StringBuilder sbPwd = new StringBuilder();

            for (byte b : rbt) {
                sbPwd.append(String.format("%02x", b));
            }

            this.password = sbPwd.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error al encriptar la contraseña" + e.getMessage());
        }
    }

    public static void crearUsuarioBD(Usuario usuario) {
        Conexion conexion = new Conexion();

        String sql = "INSERT INTO usuarios (nombre, apellido, edad, usuario, pais, correo, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?);";

        usuario.hashPassword();

        try (CallableStatement cs = conexion.establecerConexion().prepareCall(sql)) {

            cs.setString(1, usuario.getNombre());
            cs.setString(2, usuario.getApellido());
            cs.setInt(3, usuario.getEdad());
            cs.setString(4, usuario.getUsername());
            cs.setString(5, usuario.getPais());
            cs.setString(6, usuario.getEmail());
            cs.setString(7, usuario.getPassword());

            cs.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos. Error: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", edad=").append(edad);
        sb.append(", pais=").append(pais);
        sb.append(", username=").append(username);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", coleccion=").append(coleccion);
        sb.append(", intereses=").append(intereses);
        sb.append('}');
        return sb.toString();
    }

}
