package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private Connection connection = null;
    private final String url = "jdbc:mysql://localhost:3306/fidepop";
    private final String username = "root";
    private final String password = "hATZ_9O7R";

    public Connection establecerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Error: No se encontró el controlador de la base de datos.");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al conectar la base de datos. Error: " + sqle.getMessage());
        }

        return connection;

    }
}
