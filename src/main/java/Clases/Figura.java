package Clases;

import Conexion.Conexion;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Figura implements Serializable {

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
        this.resenias = new ArrayList<>();
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

    public boolean validarAtributos() {

        if (this.nombre == null || this.nombre.isEmpty()
                || this.numeroSerie == null || this.numeroSerie.isEmpty()
                || this.tamanio == null
                || this.fechaAdquisicion == null
                || this.categoria == null || this.categoria.isEmpty()
                || this.estado == null || this.estado.isEmpty()
                || this.valor == null
                || this.marca == null || this.marca.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void crearFiguraDB(Figura figura, String username) {
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO figuras (nombre,numeroSerie,fechaAdquisicion,tamaño,precio,categoria,estado,usuario,marca) VALUES (?,?,?,?,?,?,?,?,?)";

        try (CallableStatement cs = conexion.establecerConexion().prepareCall(sql)) {

            cs.setString(1, figura.getNombre());
            cs.setString(2, figura.getNumeroSerie());
            cs.setDate(3, Date.valueOf(figura.getFechaAdquisicion()));
            cs.setDouble(4, figura.getTamanio());
            cs.setDouble(5, figura.getValor());
            cs.setString(6, figura.getCategoria());
            cs.setString(7, figura.getEstado());
            cs.setString(8, username);
            cs.setString(9, figura.getMarca());

            cs.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos. Error: " + e.getMessage());
        }
    }

    public static void actualizarFiguraDB(Figura figura, String username) {
        Conexion conexion = new Conexion();
        String sql = "UPDATE figuras SET nombre = ?, fechaAdquisicion = ?, tamaño = ?, precio = ?, categoria = ?, estado = ?, marca = ? WHERE usuario = ? AND numeroSerie = ?";
        try (CallableStatement cs = conexion.establecerConexion().prepareCall(sql)) {
            cs.setString(1, figura.getNombre());
            cs.setDate(2, Date.valueOf(figura.getFechaAdquisicion()));
            cs.setDouble(3, figura.getTamanio());
            cs.setDouble(4, figura.getValor());
            cs.setString(5, figura.getCategoria());
            cs.setString(6, figura.getEstado());
            cs.setString(7, figura.getMarca());
            cs.setString(8, username);
            cs.setString(9, figura.getNumeroSerie());

            cs.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos. Error: " + e.getMessage());

        }
    }

    public static void eliminarFiguraDB(String numeroSerie) {
        Conexion conexion = new Conexion();
        String sql = "DELETE FROM figuras WHERE numeroSerie = ?";

        try (PreparedStatement ps = conexion.establecerConexion().prepareStatement(sql)) {

            ps.setString(1, numeroSerie);
            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos. Error: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Figura{");
        sb.append("nombre=").append(nombre);
        sb.append(", numeroSerie=").append(numeroSerie);
        sb.append(", tamanio=").append(tamanio);
        sb.append(", fechaAdquisicion=").append(fechaAdquisicion);
        sb.append(", categoria=").append(categoria);
        sb.append(", estado=").append(estado);
        sb.append(", valor=").append(valor);
        sb.append(", marca=").append(marca);
        sb.append(", resenias=").append(resenias);
        sb.append('}');
        return sb.toString();
    }

}
