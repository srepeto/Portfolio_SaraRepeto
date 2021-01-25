package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarOmodif {

    String nomEmp, cif, direccion, localidad, tipJornada, dniResponsable, nombreResp, apellidosResp, dniTL, nombreTL, apellidosTL, correoTL;
    int codEmp, codPost, telefonoTL;

    public InsertarOmodif(int codEmp, String nomEmp, String cif, String direccion, int codPost, String localidad, String tipJornada, String dniResponsable,
                          String nombreResp, String apellidosResp, String dniTL, String nombreTL, String apellidosTL, String correoTL, int telefonoTL) {

        this.nomEmp = nomEmp;
        this.cif = cif;
        this.direccion = direccion;
        this.localidad = localidad;
        this.tipJornada = tipJornada;
        this.dniResponsable = dniResponsable;
        this.nombreResp = nombreResp;
        this.apellidosResp = apellidosResp;
        this.dniTL = dniTL;
        this.nombreTL = nombreTL;
        this.apellidosTL = apellidosTL;
        this.correoTL = correoTL;
        this.codEmp = codEmp;
        this.codPost = codPost;
        this.telefonoTL = telefonoTL;
    }

    public boolean insertar () throws SQLException {
        Connection conexBd = null;

        try {

            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Proy3TE1", "root", "root");

            PreparedStatement st = conexBd.prepareStatement("INSERT INTO empresas VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, codEmp);
            st.setString(2, nomEmp);
            st.setString(3, cif);
            st.setString(4, direccion);
            st.setInt(5, codPost);
            st.setString(6, localidad);
            st.setString(7, tipJornada);
            st.setString(8, dniResponsable);
            st.setString(9, nombreResp);
            st.setString(10, apellidosResp);
            st.setString(11, dniTL);
            st.setString(12, nombreTL);
            st.setString(13, apellidosTL);
            st.setString(14, correoTL);
            st.setInt(15, telefonoTL);

            int regIns = st.executeUpdate();
            if (regIns >=1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException | ClassNotFoundException se) {
            return false;
        }
        finally {
            if (conexBd != null)
                try {
                    conexBd.close();
                    System.out.println("Conexión cerrada");
                } catch (SQLException ignore) {}
        }
    }


    public boolean modificar () throws SQLException {
        Connection conexBd = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Proy3TE1", "root", "root");

            String modif = ("UPDATE empresas SET Nombre = ?, CIF = ?, Dirección = ?, CP = ?, Localidad = ?, TipoJornada = ?, DNIResp = ?, NombreResp = ?, ApellidosResp = ?, DNITL = ?, NombreTL = ?, ApellidosTL = ?, MailTL = ?, TelefonoTL = ? WHERE CodEmpresa = ?");
            PreparedStatement st = conexBd.prepareStatement(modif);

            st.setString(1, nomEmp);
            st.setString(2, cif);
            st.setString(3, direccion);
            st.setInt(4, codPost);
            st.setString(5, localidad);
            st.setString(6, tipJornada);
            st.setString(7, dniResponsable);
            st.setString(8, nombreResp);
            st.setString(9, apellidosResp);
            st.setString(10, dniTL);
            st.setString(11, nombreTL);
            st.setString(12, apellidosTL);
            st.setString(13, correoTL);
            st.setInt(14, telefonoTL);
            st.setInt(15, codEmp);

            int regMod = st.executeUpdate();
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



}
