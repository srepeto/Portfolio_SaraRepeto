package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Borrar {
    int codEmp;

    public Borrar(int codEmp) {
        this.codEmp = codEmp;
    }

    public boolean borrar () throws SQLException {
        Connection conexBd = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Proy3TE1", "root", "root");

            String elim = "DELETE FROM empresas WHERE CodEmpresa= ?";
            PreparedStatement st = conexBd.prepareStatement(elim);
            st.setInt(1, codEmp);

            int regElim = st.executeUpdate();
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

}
