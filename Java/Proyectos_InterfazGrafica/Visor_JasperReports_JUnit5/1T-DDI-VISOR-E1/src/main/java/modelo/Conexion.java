package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    protected Connection conexion = null;
    private final String URL_CONEXION = "jdbc:mariadb://localhost:3306/Visor";
    private final String USERNAME_BBDD = "root";
    private final String PASSWORD_BBDD = "root";
    private final String DRIVER = "org.mariadb.jdbc.Driver";

    public void conectarBBDD () {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL_CONEXION, USERNAME_BBDD, PASSWORD_BBDD);
            System.out.println("Conexión creada con éxito");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver de la BBDD");
            ex.printStackTrace();
        }
    }

    public void cerrarConexion () {
        try {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection()
    {
        try
        {
            return DriverManager.getConnection(URL_CONEXION,USERNAME_BBDD,PASSWORD_BBDD);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return conexion;
    }

}