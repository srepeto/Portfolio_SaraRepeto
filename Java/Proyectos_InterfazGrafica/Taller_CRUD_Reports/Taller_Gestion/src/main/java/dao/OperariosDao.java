
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vo.Operario;
import vo.Trabajo;

public class OperariosDao {
    
    public ArrayList<Operario> obtenerTodos() {
        Conexion conex = new Conexion();
        ArrayList <Operario> listaOperarios = new ArrayList<Operario>();
        Operario operario;
        
        try {
        Statement st = conex.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM operarios");
        
        while (rs.next()) {
            operario = new Operario();
            operario.setIdoperario(rs.getInt("idoperario"));
            operario.setDni(rs.getString("dni"));
            operario.setNombre(rs.getString("nombre"));
            operario.setApellidos(rs.getString("apellidos"));
            operario.setDireccion(rs.getString("direccion"));
            operario.setTelefono(rs.getString("telefono"));
            listaOperarios.add(operario);
        }
        
        rs.close();
        st.close();
        conex.desconectar();        
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaOperarios;    
    }
    
    public Operario obtenerOperario (int idOperario) {
        Conexion conex = new Conexion();
        Operario operario = new Operario();        

        try {
            PreparedStatement ps = conex.getConnection().prepareStatement("SELECT * FROM operarios WHERE idoperario = ?");
            ps.setInt(1, idOperario);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                operario.setIdoperario(idOperario);
                operario.setDni(rs.getString("dni"));
                operario.setNombre(rs.getString("nombre"));
                operario.setApellidos(rs.getString("apellidos"));
                operario.setDireccion(rs.getString("direccion"));
                operario.setTelefono(rs.getString("telefono"));
            }
                        
            ps.close();
            rs.close();
            conex.desconectar(); 
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return operario;
        
    }

    public boolean insertar (Operario operario) {
        Conexion conex = new Conexion();
        
        try {
            
            PreparedStatement ps = conex.getConnection().prepareStatement("INSERT INTO operarios (dni, nombre, apellidos, direccion, telefono) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, operario.getDni());
            ps.setString(2, operario.getNombre());
            ps.setString(3, operario.getApellidos());
            ps.setString(4, operario.getDireccion());
            ps.setString(5, operario.getTelefono());               
            
            int regIns = ps.executeUpdate();
            if (regIns >=1) {
            System.out.println("Registro insertado");
            } else {
            System.out.println("No se ha podido realizar la inserción");
            }
            
            ps.close();
            ps.close();
            conex.desconectar(); 
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar, revise los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }    
    
}
