package Controlador;

import help.Help;
import Modelo.Asignacion;
import Modelo.ExtraerFicheros;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import Modelo.Borrar;
import Modelo.InsertarOmodif;
import Modelo.RefreshTable;
import Modelo.TablaEmpresa;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author Sara
 */
public class GestionSAFAController implements Initializable {

    @FXML
    private ComboBox<String> tipJor;
    @FXML
    private TextField codEmpresa;
    @FXML
    private TextField nomEmpresa;
    @FXML
    private TextField CIF;
    @FXML
    private TextField codPost;
    @FXML
    private TextField direccion;
    @FXML
    private TextField localidad;
    @FXML
    private TextField dniResp;
    @FXML
    private TextField nomResp;
    @FXML
    private TextField apResp;
    @FXML
    private TextField nomTL;
    @FXML
    private TextField apTL;
    @FXML
    private TextField emailTL;
    @FXML
    private TextField telefonoTL;
    @FXML
    private Label mensajes;
    @FXML
    private Button insert;
    @FXML
    private Button modificar;
    @FXML
    private Button borrar;
    @FXML
    private Button botFichFT;
    @FXML
    private Label salida;
    @FXML
    private Button botAsigAA;
    @FXML
    private TextField dniTutLab;
    @FXML
    private ComboBox<String> alumnoCombo;
    @FXML
    private ComboBox<String> empresaCombo;
    @FXML
    private ComboBox<String> tutorCombo;
    @FXML
    private TableView<TablaEmpresa> tablaEmpresas;
    @FXML
    private TableColumn<?, ?> codigoCL;
    @FXML
    private TableColumn<?, ?> nombreCL;
    @FXML
    private TableColumn<?, ?> cifCL;
    @FXML
    private TableColumn<?, ?> tipJorCL;
    @FXML
    private TableColumn<?, ?> respCL;
    @FXML
    private TableColumn<?, ?> tutorCL;
    @FXML
    private TableColumn<?, ?> direccionCL;
    @FXML
    private TableColumn<?, ?> cpCL;
    @FXML
    private TableColumn<?, ?> localidadCL;
    @FXML
    private TableColumn<?, ?> dniRespCL;
    @FXML
    private TableColumn<?, ?> apeRespCL;
    @FXML
    private TableColumn<?, ?> dniTutorCL;
    @FXML
    private TableColumn<?, ?> apeTutorCL;
    @FXML
    private TableColumn<?, ?> mailTutorCL;
    @FXML
    private TableColumn<?, ?> telfTutorCL;
    
    ObservableList<TablaEmpresa> datos = FXCollections.observableArrayList();
    
    @FXML
    private Tab tabAA;
    @FXML
    private ImageView logoSafa;
    @FXML
    private ImageView logoSafa1;
    @FXML
    private ImageView logoSafa2;
    @FXML
    private ImageView logoSafa3;
    @FXML
    private MenuBar barra1;
    @FXML
    private Menu menu4;
    @FXML
    private MenuItem ayuda4;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipJor.getItems().add("Partida");
        tipJor.getItems().add("Continua");
        tipJor.getSelectionModel().selectFirst();
        
        //AQUÍ 1
        RefreshTable objRT = new RefreshTable(tablaEmpresas, codigoCL, nombreCL, cifCL, direccionCL, cpCL, localidadCL, tipJorCL, dniRespCL, respCL, apeRespCL, dniTutorCL, tutorCL, apeTutorCL, mailTutorCL, telfTutorCL, datos);
        objRT.refrescarTabla();        
    }    

    @FXML
    private void accionBotFT(ActionEvent eventFT) {
        if(eventFT.getSource() == botFichFT) {
            try {
                ExtraerFicheros objFT = new ExtraerFicheros();
                objFT.FichXML();
                objFT.FichDat();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    //AQUÍ 3
    private void insOmod(ActionEvent eventInsOmod) {
        RefreshTable objRT = new RefreshTable(tablaEmpresas, codigoCL, nombreCL, cifCL, direccionCL, cpCL, localidadCL, tipJorCL, dniRespCL, respCL, apeRespCL, dniTutorCL, tutorCL, apeTutorCL, mailTutorCL, telfTutorCL, datos);
        try {
            Integer codEmp = Integer.parseInt(codEmpresa.getText().trim());
            String nomEmp = nomEmpresa.getText().trim();
            String cif = CIF.getText().trim();
            String direcc = direccion.getText().trim();
            int cp = Integer.parseInt(codPost.getText().trim());
            String local = localidad.getText().trim();
            String tipJornada = tipJor.getSelectionModel(). getSelectedItem().trim();
            String dniResponsable = dniResp.getText().trim();
            String nombreResp = nomResp.getText().trim();
            String apellidosResp = apResp.getText().trim();
            String dniTL = dniTutLab.getText().trim();
            String nombreTL = nomTL.getText().trim();
            String apellidosTL = apTL.getText().trim();
            String correoTL = emailTL.getText().trim();
            int telfTL = Integer.parseInt(telefonoTL.getText().trim());

            InsertarOmodif objAccGE = new InsertarOmodif(codEmp, nomEmp, cif, direcc, cp, local, tipJornada, dniResponsable, nombreResp, apellidosResp, dniTL, nombreTL, apellidosTL, correoTL, telfTL);

            if (nomEmp.length()>0 && cif.length()>0 && direcc.length()>0 && local.length()>0 && tipJornada.length()>0 && dniResponsable.length()>0 && nombreResp.length()>0 && apellidosResp.length()>0 && dniTL.length()>0 && nombreTL.length()>0 && apellidosTL.length()>0 && correoTL.length()>0) {
                if(eventInsOmod.getSource() == insert) {
                    try { 
                        if (objAccGE.insertar()) {
                            objRT.refrescarTabla();
                            mensajes.setText("Insertado con exito");
                        } else {
                            mensajes.setText("Ya existe una empresa con ese código");
                        }
                    } catch (SQLException ex) {
                        mensajes.setText("Se ha producido un error");
                    }
                }

                if(eventInsOmod.getSource() == modificar) {
                    try {
                        if (objAccGE.modificar()) {
                            objRT.refrescarTabla();
                            mensajes.setText("Modificado con exito");
                        } else {
                            mensajes.setText("No existe ninguna empresa con ese código");
                        }
                    } catch (SQLException ex) {
                        mensajes.setText("Se ha producido un error");
                    }
                }

            } else {
                mensajes.setText("No puede haber campos vacíos");
            }
        } catch (NumberFormatException nfe) {
            mensajes.setText("Formato de número incorrecto");
        }
    }

    @FXML
    //AQUÍ 4
    private void eliminar(ActionEvent eventEliminar) {
        RefreshTable objRT = new RefreshTable(tablaEmpresas, codigoCL, nombreCL, cifCL, direccionCL, cpCL, localidadCL, tipJorCL, dniRespCL, respCL, apeRespCL, dniTutorCL, tutorCL, apeTutorCL, mailTutorCL, telfTutorCL, datos);
        try {
            Integer codEmp = Integer.parseInt(codEmpresa.getText());
            Borrar objBor = new Borrar(codEmp);
            if (objBor.borrar()) {
                objRT.refrescarTabla();
                mensajes.setText("Eliminado con exito");
            } else {
                mensajes.setText("No existe ninguna empresa con ese código");
            }
        } catch (SQLException ex) {
            mensajes.setText("Se ha producido un error");

        } catch (NumberFormatException nfe) {
            mensajes.setText("Formato de número incorrecto");
        }
    }

    @FXML
    private void accionBotAA(ActionEvent eventBotAA) {
        if(eventBotAA.getSource() == botAsigAA) {
            String nomApeAlum = alumnoCombo.getSelectionModel(). getSelectedItem();
            String nomEmpresa = empresaCombo.getSelectionModel(). getSelectedItem();
            String nomTutor = tutorCombo.getSelectionModel(). getSelectedItem();

            Asignacion objAsig = new Asignacion();
            String nomTutLab = objAsig.tutorLaboral(nomEmpresa);

            if (objAsig.asigFinal(nomApeAlum, nomEmpresa, nomTutor)) {
                salida.setText("El alumno "+nomApeAlum+" queda asignado a la empresa "+nomEmpresa+" supervisados por los tutores "+nomTutor+" (docente) y "+nomTutLab+" (laboral)");
            } else {
                salida.setText("Este alumno ya está asignado");
            }
        }
    
    }

    @FXML
    private void refrescarAA(Event eventRefrescarAA) {
        alumnoCombo.getItems().clear();
        empresaCombo.getItems().clear();
        tutorCombo.getItems().clear();
        
        Asignacion objAsig = new Asignacion();
        objAsig.asigCombos(alumnoCombo, empresaCombo, tutorCombo);
        alumnoCombo.getSelectionModel().selectFirst();
        empresaCombo.getSelectionModel().selectFirst();
        tutorCombo.getSelectionModel().selectFirst();
        
        salida.setText("");
    }

    @FXML
    private void accionAyuda(ActionEvent event) {
        Help helpObj = new Help();
        helpObj.setVisible(true);
    }
}