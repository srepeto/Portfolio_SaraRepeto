
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
   static String bd = "taller";
   static String login = "root";
   static String password = "root";
   static String url = "jdbc:mysql://localhost:3306/"+bd+"?serverTimezone=UTC";
    
    Connection conn = null;
    
    public Conexion () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            if (conn!=null) {
                System.out.println("Conexión con la base de datos "+bd+" completada");
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
    
    public void desconectar() {
        conn=null;
    }
    
    
}
