package modelo;

import javax.swing.*;
import java.sql.*;

public class Asignacion {

    public void asigCombos(JComboBox alumno, JComboBox empresa, JComboBox tutor) {
        Connection conexBd = null;

        try {

            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Proy3TE1", "root", "root");

            Statement st = conexBd.createStatement();
            ResultSet resulAlum = st.executeQuery("SELECT Nombre, Apellidos FROM alumnos");
            String nom, ape;

            while (resulAlum.next()) {
                nom = resulAlum.getString("Nombre");
                ape = resulAlum.getString("Apellidos");
                alumno.addItem(ape + ", " + nom);
            }

            ResultSet resulEmp = st.executeQuery("SELECT Nombre FROM empresas");
            String nomEmp;

            while (resulEmp.next()) {
                nomEmp = resulEmp.getString("Nombre");
                empresa.addItem(nomEmp);
            }

            ResultSet resulTut = st.executeQuery("SELECT NomAp FROM tutoresdocentes");
            String nomTut;

            while (resulTut.next()) {
                nomTut = resulTut.getString("NomAp");
                tutor.addItem(nomTut);
            }

        } catch (SQLException | ClassNotFoundException se) {
        } finally {
            if (conexBd != null)
                try {
                    conexBd.close();
                } catch (SQLException ignore) {}
        }
    }

    public boolean asigFinal(String nomApeAlum, String nomEmpresa, String nomTutor) {
        Connection conexBd = null;

        try {

            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Proy3TE1", "root", "root");

            String[] listaPalabras = nomApeAlum.split(", ");
            String apellidos = listaPalabras[0];
            String nombre = listaPalabras[1];

            int codAlum =0, codEmp=0, codTut=0;

            Statement st = conexBd.createStatement();

            ResultSet resulAlum = st.executeQuery("SELECT CodigoAlumno FROM alumnos WHERE Nombre = '" + nombre + "' AND Apellidos = '" + apellidos + "'");
            while (resulAlum.next()) {
                codAlum = resulAlum.getInt("CodigoAlumno");
            }

            ResultSet resulEmp = st.executeQuery("SELECT CodEmpresa FROM empresas WHERE Nombre = '" + nomEmpresa + "'");
            while (resulEmp.next()) {
                codEmp = resulEmp.getInt("CodEmpresa");
            }

            ResultSet resulTut = st.executeQuery("SELECT CodigoTutor FROM tutoresdocentes WHERE NomAp = '" + nomTutor + "'");
            while (resulTut.next()) {
                codTut = resulTut.getInt("CodigoTutor");
            }

            ResultSet resulFinal = st.executeQuery("SELECT * FROM asignados WHERE CodigoAlumno = "+codAlum);
            if (resulFinal.next()==true) {
                return false;
            } else {
                PreparedStatement pst = conexBd.prepareStatement("INSERT INTO asignados VALUES (?,?,?)");
                pst.setInt(1, codAlum);
                pst.setInt(2, codEmp);
                pst.setInt(3, codTut);
                pst.executeUpdate();
                return true;
            }

        } catch (SQLException | ClassNotFoundException se) {
            return false;
        } finally {
            if (conexBd != null)
                try {
                    conexBd.close();
                } catch (SQLException ignore) {}
        }
    }

    public String tutorLaboral(String nomEmpresa) {
        Connection conexBd = null;
        String nomTut = "";
        try {

            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Proy3TE1", "root", "root");

            Statement st = conexBd.createStatement();

            ResultSet resulTutLab = st.executeQuery("SELECT NombreTL FROM empresas WHERE Nombre = '"+nomEmpresa+"'");
            while (resulTutLab.next()) {
                nomTut = resulTutLab.getString("NombreTL");
            }

        } catch (SQLException | ClassNotFoundException se) {
        } finally {
            if (conexBd != null)
                try {
                    conexBd.close();
                } catch (SQLException ignore) {}
        }
        return nomTut;
    }

}
