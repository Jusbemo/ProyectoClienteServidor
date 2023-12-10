package Clases;

import Conexion.Conexion;
import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Comentario implements Serializable {

    private Usuario nombre;
    private String contenido;
    private LocalDate fecha;
    private String intercambio;

    public Comentario() {
    }

    public Comentario(Usuario nombre, String contenido, LocalDate fecha) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public Comentario(Usuario nombre, String contenido, LocalDate fecha, String intercambio) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.fecha = fecha;
        this.intercambio = intercambio;
    }

    public String getIntercambio() {
        return intercambio;
    }

    public void setIntercambio(String intercambio) {
        this.intercambio = intercambio;
    }

    public Usuario getNombre() {
        return nombre;
    }

    public void setNombre(Usuario nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public static void crearComentarioBD(Comentario comentario, String figura) {
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO comentarios (usuario, figuraAsociada, fecha, comentario, intercambio) VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = conexion.establecerConexion().prepareStatement(sql)) {

            ps.setString(1, comentario.getNombre().getUsername());
            ps.setString(2, figura);
            ps.setDate(3, Date.valueOf(comentario.getFecha()));
            ps.setString(4, comentario.getContenido());
            ps.setString(5, comentario.getIntercambio());

            ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al crear el comentario" + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comentario{");
        sb.append("nombre=").append(nombre);
        sb.append(", contenido=").append(contenido);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }

}
