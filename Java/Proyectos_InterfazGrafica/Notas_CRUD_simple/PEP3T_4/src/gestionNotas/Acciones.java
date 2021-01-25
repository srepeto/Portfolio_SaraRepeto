package gestionNotas;

import javax.swing.*;
import java.sql.*;

public class Acciones {

    int codMat;
    String nomAsig;
    float nota1, nota2;

    public Acciones(int codMat, String nomAsig, float nota1, float nota2) {
        this.codMat = codMat;
        this.nomAsig = nomAsig;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public boolean insertar () throws SQLException {
        Connection conexBd = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/puntu4", "root", "root");

            String insert = "INSERT INTO NOTAS (codigo, nomasig, nota1, nota2) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedSt = conexBd.prepareStatement(insert);
            preparedSt.setInt(1, codMat);
            preparedSt.setString(2, nomAsig);
            preparedSt.setFloat(3, nota1);
            preparedSt.setFloat(4, nota2);

            int regIns = preparedSt.executeUpdate();
            if (regIns >=1) {
                return true;
            } else {
                return false;
            }

        }
        catch (SQLException | ClassNotFoundException se) {
            return false;
        }
        finally {
            if (conexBd != null)
                try {
                    conexBd.close();
                } catch (SQLException ignore) {}
        }
    }

    public boolean modificar () throws SQLException {
        Connection conexBd = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/puntu4", "root", "root");

            String modif = "UPDATE notas SET nomasig=?, nota1=?, nota2=? WHERE codigo = ?";
            PreparedStatement preparedSt = conexBd.prepareStatement(modif);

            preparedSt.setString(1, nomAsig);
            preparedSt.setFloat(2, nota1);
            preparedSt.setFloat(3, nota2);
            preparedSt.setInt(4, codMat);

            int regMod = preparedSt.executeUpdate();
            if (regMod >=1) {
                return true;
            } else {
                return false;
            }

        }
        catch (SQLException | ClassNotFoundException se) {
            return false;
        }
        finally {
            if (conexBd != null)
                try {
                    conexBd.close();
                } catch (SQLException ignore) {}
        }
    }

    public boolean eliminar () throws SQLException {
        Connection conexBd = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/puntu4", "root", "root");

            String elim = "DELETE FROM notas WHERE codigo = ?";
            PreparedStatement preparedSt = conexBd.prepareStatement(elim);
            preparedSt.setInt(1, codMat);

            int regElim = preparedSt.executeUpdate();
            if (regElim >=1) {
                return true;
            } else {
                return false;
            }

        }
        catch (SQLException | ClassNotFoundException se) {
            return false;
        }
        finally {
            if (conexBd != null)
                try {
                    conexBd.close();
                } catch (SQLException ignore) {}
        }
    }

    public boolean consultar (JTextField campoNomAsig, JTextField campoNota1, JTextField campoNota2) throws SQLException {
        Connection conexBd = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/puntu4", "root", "root");

            String consulta = "SELECT * FROM notas WHERE codigo = " + codMat;
            Statement st = conexBd.createStatement();

            ResultSet resulCons = st.executeQuery(consulta);
            while (resulCons.next()) {
                codMat = resulCons.getInt("codigo");
                nomAsig = resulCons.getString("nomasig");
                nota1 = resulCons.getFloat("nota1");
                nota2 = resulCons.getFloat("nota2");
                campoNomAsig.setText(nomAsig);
                campoNota1.setText(String.valueOf(nota1));
                campoNota2.setText(String.valueOf(nota2));
                return true;
            }

        }
        catch (SQLException | ClassNotFoundException se) {
            return false;
        }
        finally {
            if (conexBd != null)
                try {
                    conexBd.close();
                } catch (SQLException ignore) {}
        }
        return false;
    }


}
