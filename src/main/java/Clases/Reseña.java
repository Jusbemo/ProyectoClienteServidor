package Clases;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reseña {

    private Usuario usuario;
    private String titulo;
    private String texto;
    private LocalDate fechaResenia;
    private LocalTime horaResenia;
    private int calificacion;

    public Reseña() {
    }

    public Reseña(Usuario usuario, String titulo, String texto, LocalDate fechaResenia, LocalTime horaResenia, int calificacion) {
        this.usuario = usuario;
        this.titulo = titulo;
        this.texto = texto;
        this.fechaResenia = fechaResenia;
        this.horaResenia = horaResenia;
        this.calificacion = calificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public LocalTime getHoraResenia() {
        return horaResenia;
    }

    public void setHoraResenia(LocalTime horaResenia) {
        this.horaResenia = horaResenia;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

}
