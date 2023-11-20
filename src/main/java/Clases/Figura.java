package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Figura {

    private String nombre;
    private String numeroSerie;
    private Double tamanio;
    private LocalDate fechaAdquisicion;
    private String categoria;
    private String estado;
    private Double valor;
    private String marca;
    private ArrayList<Reseña> resenias;

    public Figura() {
        this.resenias = new ArrayList<>();
    }

    public Figura(String nombre, String numeroSerie, Double tamanio, LocalDate fechaAdquisicion, String categoria, String estado, Double valor, String marca, ArrayList<Reseña> resenias) {
        this.nombre = nombre;
        this.numeroSerie = numeroSerie;
        this.tamanio = tamanio;
        this.fechaAdquisicion = fechaAdquisicion;
        this.categoria = categoria;
        this.estado = estado;
        this.valor = valor;
        this.marca = marca;
        this.resenias = resenias;
    }

    public Figura(String nombre, String numeroSerie, Double tamanio, LocalDate fechaAdquisicion, String categoria, String estado, Double valor, String marca) {
        this.nombre = nombre;
        this.numeroSerie = numeroSerie;
        this.tamanio = tamanio;
        this.fechaAdquisicion = fechaAdquisicion;
        this.categoria = categoria;
        this.estado = estado;
        this.valor = valor;
        this.marca = marca;
        this.resenias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Double getTamanio() {
        return tamanio;
    }

    public void setTamanio(Double tamanio) {
        this.tamanio = tamanio;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public ArrayList<Reseña> getResenias() {
        return resenias;
    }

    public void setResenias(ArrayList<Reseña> resenias) {
        this.resenias = resenias;
    }

}
