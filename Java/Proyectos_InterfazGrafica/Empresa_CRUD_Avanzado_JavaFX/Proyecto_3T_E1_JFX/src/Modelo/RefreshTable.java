package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Sara
 */
public class RefreshTable {
    TableView tablaEmpresas;
    //AQUÍ 2
    TableColumn codigoCL, nombreCL, cifCL, direccionCL, cpCL, localidadCL, tipJorCL, dniRespCL, respCL, apeRespCL, dniTutorCL, tutorCL, apeTutorCL, mailTutorCL, telfTutorCL;
    ObservableList datos;

    public RefreshTable(TableView tablaEmpresas, TableColumn codigoCL, TableColumn nombreCL, TableColumn cifCL, TableColumn direccionCL, TableColumn cpCL, TableColumn localidadCL, TableColumn tipJorCL, TableColumn dniRespCL, TableColumn respCL, TableColumn apeRespCL, TableColumn dniTutorCL, TableColumn tutorCL, TableColumn apeTutorCL, TableColumn mailTutorCL, TableColumn telfTutorCL, ObservableList datos) {
        this.tablaEmpresas = tablaEmpresas;
        this.codigoCL = codigoCL;
        this.nombreCL = nombreCL;
        this.cifCL = cifCL;
        this.direccionCL = direccionCL;
        this.cpCL = cpCL;
        this.localidadCL = localidadCL;
        this.tipJorCL = tipJorCL;
        this.dniRespCL = dniRespCL;
        this.respCL = respCL;
        this.apeRespCL = apeRespCL;
        this.dniTutorCL = dniTutorCL;
        this.tutorCL = tutorCL;
        this.apeTutorCL = apeTutorCL;
        this.mailTutorCL = mailTutorCL;
        this.telfTutorCL = telfTutorCL;
        this.datos = datos;
    }
      
    public void refrescarTabla () {
        datos.clear();
        
        Connection conexBd = null;
        Statement encapsulaCons = null;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/proy3te1", "root", "root");
            encapsulaCons = conexBd.createStatement();
            
            //AQUÍ 5
            String consulta = "SELECT CodEmpresa, Nombre, CIF, Dirección, CP, Localidad, TipoJornada, DNIResp, NombreResp, ApellidosResp, DNITL, NombreTL, ApellidosTL, MailTL, TelefonoTL FROM empresas";

            Statement stmt = conexBd.createStatement();
            ResultSet resul = stmt.executeQuery(consulta);
            
            //AQUÍ 6
            while (resul.next()) {
                datos.add(new TablaEmpresa(resul.getInt("CodEmpresa"), resul.getString("Nombre"),resul.getString("CIF"),resul.getString("Dirección"), resul.getInt("CP"), resul.getString("Localidad"), resul.getString("TipoJornada"), resul.getString("DNIResp"), resul.getString("NombreResp"), resul.getString("ApellidosResp"), resul.getString("DNITL"), resul.getString("NombreTL"), resul.getString("ApellidosTL"), resul.getString("MailTL"), resul.getInt("TelefonoTL")));
            }
        
            codigoCL.setCellValueFactory(new PropertyValueFactory<>("codEmp"));
            nombreCL.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cifCL.setCellValueFactory(new PropertyValueFactory<>("cif"));
            direccionCL.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            cpCL.setCellValueFactory(new PropertyValueFactory<>("CP"));
            localidadCL.setCellValueFactory(new PropertyValueFactory<>("Localidad"));
            tipJorCL.setCellValueFactory(new PropertyValueFactory<>("tipoJornada"));
            dniRespCL.setCellValueFactory(new PropertyValueFactory<>("dniResp"));
            respCL.setCellValueFactory(new PropertyValueFactory<>("nomResp"));
            apeRespCL.setCellValueFactory(new PropertyValueFactory<>("apeResp"));
            dniTutorCL.setCellValueFactory(new PropertyValueFactory<>("dniTutor"));
            tutorCL.setCellValueFactory(new PropertyValueFactory<>("nomTL"));
            apeTutorCL.setCellValueFactory(new PropertyValueFactory<>("apeTutor"));
            mailTutorCL.setCellValueFactory(new PropertyValueFactory<>("mailTutor"));
            telfTutorCL.setCellValueFactory(new PropertyValueFactory<>("telfTutor"));
            
            tablaEmpresas.setItems(datos);
            
            
        } catch (SQLException | ClassNotFoundException se) {
        } finally {
            if (conexBd != null)
                try {
                    conexBd.close();
                } catch (SQLException ignore) {}
        }

    }
    
}
