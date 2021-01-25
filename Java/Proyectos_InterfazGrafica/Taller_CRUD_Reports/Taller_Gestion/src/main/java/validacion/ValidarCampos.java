package validacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class ValidarCampos {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    
    
    public boolean camposTrabajoValidos(String costeMaterial, String fechaComienzo) {        
        if (!esNumero(costeMaterial)) {
            JOptionPane.showMessageDialog(null, "Coste del material incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!esFecha(fechaComienzo)) {
            JOptionPane.showMessageDialog(null, "Formato de Fecha incorrecto. Ejemplo: 2020-10-31", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }        
        
        return true;
    }
    
    
    public boolean camposOperarioValidos(String DNIop, String nombre, String apellidos, String direccion, String telefono) {
        if (esNumero(DNIop)) {
            JOptionPane.showMessageDialog(null, "DNI incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (esNumero(nombre)) {
            JOptionPane.showMessageDialog(null, "Nombre incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (esNumero(apellidos)) {
            JOptionPane.showMessageDialog(null, "Apellidos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (esNumero(direccion)) {
            JOptionPane.showMessageDialog(null, "Dirección incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!esNumero(telefono)) {
            JOptionPane.showMessageDialog(null, "Teléfono incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    
    public boolean esFecha (String campoFecha) {
        try {
        java.util.Date fecha = formatoFecha.parse(campoFecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    public boolean esNumero(String num) {
        try {
            Float.parseFloat(num);
        } catch (NumberFormatException nfe) {
            return false;
        }        
        return true;
    }
    
}
