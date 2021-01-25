
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import vo.Trabajo;
import conexion.Conexion;


public class TrabajosDao {
    
    public ArrayList<Trabajo> obtenerTodos() {
        Conexion conex = new Conexion();
        ArrayList <Trabajo> listaTrabajos = new ArrayList<Trabajo>();
        Trabajo trabajo;
        
        try {
        Statement st = conex.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM trabajos");
        
        while (rs.next()) {
            trabajo = new Trabajo();
            trabajo.setIdtrabajo(rs.getInt("idtrabajo"));
            trabajo.setIdoperario(rs.getInt("idoperario"));
            trabajo.setTipotrabajo(rs.getString("tipotrabajo"));
            trabajo.setDescripcion(rs.getString("descripcion"));
            trabajo.setNumhoras(rs.getInt("numhoras"));
            trabajo.setPreciomaterial(rs.getFloat("preciomaterial"));
            trabajo.setPrecio(rs.getFloat("precio"));
            trabajo.setEstado(rs.getString("estado"));
            trabajo.setFechacomienzo(rs.getString("fechacomienzo"));
            trabajo.setFechafin(rs.getString("fechafin"));
            listaTrabajos.add(trabajo);
        }
        
        rs.close();
        st.close();
        conex.desconectar();        
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaTrabajos;    
    }
    
    
    public boolean insertar (Trabajo trabajo) {
        Conexion conex = new Conexion();
        
        try {
            
            PreparedStatement ps = conex.getConnection().prepareStatement("INSERT INTO trabajos (idoperario, tipotrabajo, descripcion, numhoras, preciomaterial, precio, estado, fechacomienzo, fechafin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, trabajo.getIdoperario());
            ps.setString(2, trabajo.getTipotrabajo());
            ps.setString(3, trabajo.getDescripcion());
            ps.setInt(4, trabajo.getNumhoras());
            ps.setFloat(5, trabajo.getPreciomaterial());
            ps.setFloat(6, trabajo.getPrecio());
            ps.setString(7, trabajo.getEstado());
            ps.setString(8, trabajo.getFechacomienzo());
            ps.setString(9, trabajo.getFechafin());                   
            
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
    
    
    public Trabajo obtenerTrabajo (int idTrabajo) {
        Conexion conex = new Conexion();
        Trabajo trabajo = new Trabajo();        

        try {
            PreparedStatement ps = conex.getConnection().prepareStatement("SELECT * FROM trabajos WHERE idtrabajo = ?");
            ps.setInt(1, idTrabajo);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                trabajo.setIdtrabajo(idTrabajo);
                trabajo.setIdoperario(rs.getInt("idoperario"));
                trabajo.setTipotrabajo(rs.getString("tipotrabajo"));
                trabajo.setDescripcion(rs.getString("descripcion"));
                trabajo.setNumhoras(rs.getInt("numhoras"));
                trabajo.setPreciomaterial(rs.getFloat("preciomaterial"));
                trabajo.setPrecio(rs.getFloat("precio"));
                trabajo.setEstado(rs.getString("estado"));
                trabajo.setFechacomienzo(rs.getString("fechacomienzo"));
                trabajo.setFechafin(rs.getString("fechafin"));                              
            }
                        
            ps.close();
            rs.close();
            conex.desconectar(); 
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return trabajo;
        
    }
    
        public ArrayList<Trabajo> obtenerTrabajosOperario (int idOperario) {
        Conexion conex = new Conexion();
        ArrayList <Trabajo> listaTrabajos = new ArrayList<Trabajo>();
        Trabajo trabajo;        

        try {
            PreparedStatement ps = conex.getConnection().prepareStatement("SELECT * FROM trabajos WHERE idoperario = ?");
            ps.setInt(1, idOperario);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                trabajo = new Trabajo();
                trabajo.setIdtrabajo(rs.getInt("idtrabajo"));
                trabajo.setIdoperario(idOperario);
                trabajo.setTipotrabajo(rs.getString("tipotrabajo"));
                trabajo.setDescripcion(rs.getString("descripcion"));
                trabajo.setNumhoras(rs.getInt("numhoras"));
                trabajo.setPreciomaterial(rs.getFloat("preciomaterial"));
                trabajo.setPrecio(rs.getFloat("precio"));
                trabajo.setEstado(rs.getString("estado"));
                trabajo.setFechacomienzo(rs.getString("fechacomienzo"));
                trabajo.setFechafin(rs.getString("fechafin"));
                listaTrabajos.add(trabajo);
            }
                        
            ps.close();
            rs.close();
            conex.desconectar(); 
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaTrabajos;
        
    }
    
    
    public boolean modificar (Trabajo trabajo) {
        Conexion conex = new Conexion();
        
        try {
            PreparedStatement ps = conex.getConnection().prepareStatement("UPDATE trabajos SET idoperario = ?, tipotrabajo = ?, descripcion = ?, numhoras = ?, preciomaterial=?, precio = ?, estado = ?, fechacomienzo = ?, fechafin = ? WHERE idtrabajo = ?");
            ps.setInt(1, trabajo.getIdoperario());
            ps.setString(2, trabajo.getTipotrabajo());
            ps.setString(3, trabajo.getDescripcion());
            ps.setInt(4, trabajo.getNumhoras());
            ps.setFloat(5, trabajo.getPreciomaterial());
            ps.setFloat(6, trabajo.getPrecio());
            ps.setString(7, trabajo.getEstado());
            ps.setString(8, trabajo.getFechacomienzo());
            ps.setString(9, trabajo.getFechafin());                       
            ps.setInt(10, trabajo.getIdtrabajo());
            
            int regMod = ps.executeUpdate();
            if (regMod >=1) {
                System.out.println("Trabajo modificado");
            } else {
                System.out.println("Error al modificar el trabajo");
            }
            
            ps.close();
            conex.desconectar();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar, revise los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
        
    }
    
    public void eliminar (int id) {
        Conexion conex = new Conexion();
        
            try {
                
                PreparedStatement ps = conex.getConnection().prepareStatement("DELETE FROM trabajos WHERE idtrabajo = ?");
                ps.setInt(1, id);
                
                int regElim = ps.executeUpdate();
                if (regElim >=1) {
                    System.out.println("Trabajo eliminado");
                } else {
                    System.out.println("No hay ningún trabajo con ese ID");
                }
                
                ps.close();
                conex.desconectar();
                
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
