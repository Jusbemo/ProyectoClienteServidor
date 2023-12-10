package Clases;

import Conexion.Conexion;
import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

public class Reseña implements Serializable {

    private Usuario usuario;
    private String texto;
    private LocalDate fechaResenia;
    private int calificacion;
    private String titulo;
    private LocalTime horaResenia;
    private String numeroSerieFigura;

    public Reseña() {
    }

    public Reseña(Usuario usuario, String titulo, String texto, LocalDate fechaResenia, LocalTime horaResenia, int calificacion) {
        this.usuario = usuario;
        this.texto = texto;
        this.fechaResenia = fechaResenia;
        this.calificacion = calificacion;
    }

    public Reseña(Usuario usuario, String texto, LocalDate fechaResenia, int calificacion, String titulo, LocalTime horaResenia) {
        this.usuario = usuario;
        this.texto = texto;
        this.fechaResenia = fechaResenia;
        this.calificacion = calificacion;
        this.titulo = titulo;
        this.horaResenia = horaResenia;
    }

    public Reseña(Usuario usuario, String texto, LocalDate fechaResenia, int calificacion, String titulo, LocalTime horaResenia, String numeroSerieFigura) {
        this.usuario = usuario;
        this.texto = texto;
        this.fechaResenia = fechaResenia;
        this.calificacion = calificacion;
        this.titulo = titulo;
        this.horaResenia = horaResenia;
        this.numeroSerieFigura = numeroSerieFigura;
    }
    
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getFechaResenia() {
        return fechaResenia;
    }

    public void setFechaResenia(LocalDate fechaResenia) {
        this.fechaResenia = fechaResenia;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalTime getHoraResenia() {
        return horaResenia;
    }

    public void setHoraResenia(LocalTime horaResenia) {
        this.horaResenia = horaResenia;
    }

    public String getNumeroSerieFigura() {
        return numeroSerieFigura;
    }

    public void setNumeroSerieFigura(String numeroSerieFigura) {
        this.numeroSerieFigura = numeroSerieFigura;
    }

    public static void crearReseñaBD(Reseña reseña, String figura) {
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO reseñas (usuario, figura, calificacion, contenido, fecha, hora, titulo) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conexion.establecerConexion().prepareStatement(sql)) {

            ps.setString(1, reseña.getUsuario().getUsername());
            ps.setString(2, figura);
            ps.setInt(3, reseña.getCalificacion());
            ps.setString(4, reseña.getTexto());          
            ps.setDate(5, Date.valueOf(reseña.getFechaResenia()));
            ps.setTime(6, Time.valueOf(reseña.getHoraResenia()));
            ps.setString(7, reseña.getTitulo());

            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al crear la reseña" + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rese\u00f1a{");
        sb.append("usuario=").append(usuario);
        sb.append(", texto=").append(texto);
        sb.append(", fechaResenia=").append(fechaResenia);
        sb.append(", calificacion=").append(calificacion);
        sb.append(", titulo=").append(titulo);
        sb.append(", horaResenia=").append(horaResenia);
        sb.append(", numeroSerieFigura=").append(numeroSerieFigura);
        sb.append('}');
        return sb.toString();
    }
    
}
