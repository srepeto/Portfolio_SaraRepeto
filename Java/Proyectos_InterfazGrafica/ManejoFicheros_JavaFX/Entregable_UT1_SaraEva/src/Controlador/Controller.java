package Controlador;

import Modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    File fichSeleccionado, directSeleccionado;

    public Pane paneCabecera;

    //Elemento Pane gestión de ficheros
    public Pane paneGestion;
    public Button botPaneCrear;
    public Button botSelFich;
    public Button botBorrar;
    public Button botCifrar;
    public Button botCopia;
    public Button botINFO;
    public Button botVerCont;
    public Button botEditCont;
    public Button botGuardar;
    public Button botContPal;
    public Button botContVoc;
    public TextField fieldRutaFich;
    public TextArea areaTexto;
    public Label etiGuia;
    public Label etiConfirm;
    public Label etiError;

    //Elementos Pane copia de fichero
    public Pane paneNuevoFichCF;
    public Button botUbicacionCF;
    public TextField fieldRutaUbicCF;
    public Label etiNuevoErrorCF;
    public Label etiNuevoConfirmCF;
    public TextField fieldNombreCF;
    public Button botNuevoFichCF;
    public Button botVolverCF;

    //Elementos Pane creación de nuevo fichero
    public Pane paneNuevoFich;
    public TextField fieldNombre;
    public Button botUbicacion;
    public TextField fieldRutaUbic;
    public Button botNuevoFich;
    public Label etiNuevoError;
    public Label etiNuevoConfirm;
    public Button botVolver;


    //PANE GESTIÓN DE FICHEROS

    //Botón para seleccionar fichero
    public void accionSelFich(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TEXT Files (*.txt)", "*.txt"));
        File selectedFile = fc.showOpenDialog(null);
        //Este if controlar la excepción de no haber elegido finalmente ningún fichero
        if (selectedFile==null) {
            return;
        }
        fichSeleccionado = selectedFile;
        fieldRutaFich.setText(fichSeleccionado.getAbsolutePath());
    }

    //Botón para borrar el fichero seleccionado
    public void accionBorrar(ActionEvent actionEvent) {
        if (fichSeleccionado == null) { //Se comprueba que se haya seleccionado un fichero
            etiPrimeroSelFich();
        } else {
            if (fichSeleccionado.exists()) { //Se comprueba si el fichero existe
                resetEtiAreaGuardar();
                Borrar objBorrar = new Borrar(fichSeleccionado);
                if (objBorrar.BorrarFichero()) {
                    etiConfirm.setText("Fichero borrado correctamente");
                    etiConfirm.setVisible(true);
                } else if (!objBorrar.BorrarFichero()) {
                    etiError.setText("Ha habido un problema al borrar el fichero");
                    etiError.setVisible(true);
                }
            } else {
                etiFichNoExiste();
            }
        }
    }

    //Botón para cifrar el archivo
    public void accionCifrar(ActionEvent actionEvent) throws IOException {
        if (fichSeleccionado == null) {
            etiPrimeroSelFich();
        } else {
            if (fichSeleccionado.exists()) {
                resetEtiAreaGuardar();
                CifrarFichero objCifrado = new CifrarFichero(fichSeleccionado);
                objCifrado.cifrado();
                etiConfirm.setText("Fichero cifrado correctamente");
                etiConfirm.setVisible(true);
            } else {
                etiFichNoExiste();
            }
        }
    }

    //Botón para mostrar la INFO del fichero
    public void accionMostrarINFO(ActionEvent actionEvent) {
        if (fichSeleccionado == null) {
            etiPrimeroSelFich();
        } else {
            if (fichSeleccionado.exists()) {
                resetEtiAreaGuardar();
                MostrarINFO objINFO = new MostrarINFO(fichSeleccionado);
                String [] infoFich = objINFO.obtenerInfo();
                areaTexto.setText("Nombre: " + infoFich[0] + "\nExtensión: " + infoFich[1] + "\nRuta absoluta: " + infoFich[2] + "\nTamaño: " + infoFich[3] + "\nÚltima modificación: " + infoFich[4]);
                etiGuia.setText("Mostrando la INFO del fichero elegido");
                etiGuia.setVisible(true);
            } else {
                etiFichNoExiste();
            }
        }
    }

    //Botón para mostrar el contenido del fichero
    public void accionVerCont(ActionEvent actionEvent) {
        if (fichSeleccionado == null) {
            etiPrimeroSelFich();
        } else {
            if (fichSeleccionado.exists()) {
                resetEtiAreaGuardar();
                VerContenido objVerCont = new VerContenido(fichSeleccionado);
                String contenido = objVerCont.leerContenido();
                areaTexto.setText(contenido);
                etiGuia.setText("Mostrando el contenido del fichero");
                etiGuia.setVisible(true);
            } else {
                etiFichNoExiste();
            }
        }
    }

    //Botón para editar el contenido del fichero
    public void accionEditarCont(ActionEvent actionEvent) {
        if (fichSeleccionado == null) {
            etiPrimeroSelFich();
        } else {
            if (fichSeleccionado.exists()) {
                areaTexto.setEditable(true);
                etiConfirm.setVisible(false);
                etiError.setVisible(false);
                etiGuia.setText("Ahora puedes editar el contenido del fichero");
                etiGuia.setVisible(true);
                botGuardar.setVisible(true);
                botGuardar.setDisable(false);

                VerContenido objVerCont = new VerContenido(fichSeleccionado);
                String contenido = objVerCont.leerContenido();
                areaTexto.setText(contenido);
            } else {
                etiFichNoExiste();
            }
        }
    }

    //Botón para guardar los cambios tras haber editado el contenido
    public void accionGuardar(ActionEvent actionEvent) throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(fichSeleccionado));
        escritor.write(areaTexto.getText());
        escritor.close();

        etiGuia.setVisible(false);
        etiError.setVisible(false);
        etiConfirm.setText("Los cambios han sido guardados correctamente");
        etiConfirm.setVisible(true);
    }

    //Botón para contar el número de palabras que hay
    public void accionContPalabras(ActionEvent actionEvent) {
        if (fichSeleccionado == null) {
            etiPrimeroSelFich();
        } else {
            if (fichSeleccionado.exists()) {
                resetEtiAreaGuardar();
                ContarPalabras objContar = new ContarPalabras(fichSeleccionado);
                objContar.CuentaPalabras();
                etiGuia.setText("Mostrando el número de palabras");
                etiGuia.setVisible(true);
                int contador = objContar.CuentaPalabras();
                areaTexto.setText("Son " + contador + " palabras");
            } else {
                etiFichNoExiste();
            }
        }
    }

    //Botón para contar cuántas veces aparece cada vocal
    public void accionContVocales(ActionEvent actionEvent) {
        if (fichSeleccionado == null) {
            etiPrimeroSelFich();
        } else {
            if (fichSeleccionado.exists()) {
                resetEtiAreaGuardar();
                etiGuia.setText("Mostrando el número de veces que aparece cada vocal");
                etiGuia.setVisible(true);

                ContarVocales objContVoc = new ContarVocales(fichSeleccionado);
                int[] contador = objContVoc.cuentavocales();
                areaTexto.setText("A \t=\t " + contador[0]);
                areaTexto.appendText("\nE \t=\t " + contador[1]);
                areaTexto.appendText("\nI \t=\t " + contador[2]);
                areaTexto.appendText("\nO \t=\t " + contador[3]);
                areaTexto.appendText("\nU \t=\t " + contador[4]);
            } else {
                etiFichNoExiste();
            }
        }
    }


    //PANE CREACIÓN DE NUEVO FICHERO

    //Botón para cambiar al Pane de creación de nuevo fichero
    public void accionPaneCrear(ActionEvent actionEvent) throws IOException {
        directSeleccionado = null;
        resetEtiAreaGuardar();
        etiGuia.setText("Selecciona el fichero y elige la acción a realizar");
        etiGuia.setVisible(true);
        paneGestion.setVisible(false);
        paneGestion.setDisable(true);
        //Aseguramos que los fields estarán en blanco
        fieldRutaUbic.clear();
        fieldNombre.clear();
        paneNuevoFich.setVisible(true);
        paneNuevoFich.setDisable(false);
        etiNuevoError.setVisible(false);
        etiNuevoConfirm.setVisible(false);

                /* Otra manera sería crear otro .fxml y cambiar la escena, pero aquí no lo hemos creido oportuno. Sería así:
        Parent parentCreacion = FXMLLoader.load(getClass().getResource("../Vista/sceneNuevoFich.fxml"));
        Scene sceneCreacion = new Scene(parentCreacion);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(sceneCreacion);
        window.show();*/
    }

    //Botón para seleccionar la ubicación del nuevo fichero
    public void accionSelUbic(ActionEvent actionEvent) {
        DirectoryChooser dc = new DirectoryChooser();
        directSeleccionado = dc.showDialog(null);
        //Este if controlar la excepción de no haber elegido ninguna ubicación
        if (directSeleccionado==null) {
            return;
        }
        fieldRutaUbic.setText(directSeleccionado.getAbsolutePath());
    }

    //Botón que creará el nuevo fichero
    public void accionCrearFich(ActionEvent actionEvent) throws IOException {
        if (directSeleccionado == null) {
            etiNuevoError.setText("No ha seleccionado la ubicación");
            etiNuevoError.setVisible(true);
        } else {
            CrearNuevo objNuevoFich = new CrearNuevo(directSeleccionado, fieldNombre.getText());
            File fichNuevo = objNuevoFich.crearNuevoFich();
            if (fichNuevo.createNewFile()) {
                etiNuevoError.setVisible(false);
                etiNuevoConfirm.setText("Fichero creado correctamente");
                etiNuevoConfirm.setVisible(true);
            } else {
                etiNuevoConfirm.setVisible(false);
                etiNuevoError.setText("El fichero ya existe");
                etiNuevoError.setVisible(true);
            }
        }
    }

    //Botón que nos hará volver a gestión de ficheros desde el Pane de crear fichero
    public void accionVolver(ActionEvent actionEvent) {
        paneGestion.setVisible(true);
        paneGestion.setDisable(false);
        paneNuevoFich.setVisible(false);
        paneNuevoFich.setDisable(true);
    }



    //PANE DE REALIZAR COPIA DEL FICHERO

    //Botón que nos llevará al Pane de copiar archivo
    public void accionPaneCopiar(ActionEvent actionEvent) {
        if (fichSeleccionado == null) {
            etiPrimeroSelFich();
        } else {
            if (fichSeleccionado.exists()) {
                directSeleccionado = null;
                resetEtiAreaGuardar();
                etiGuia.setText("Selecciona el fichero y elige la acción a realizar");
                etiGuia.setVisible(true);
                paneGestion.setVisible(false);
                paneGestion.setDisable(true);
                //Aseguramos que los fields estarán en blanco
                fieldRutaUbicCF.clear();
                fieldNombreCF.clear();
                paneNuevoFichCF.setVisible(true);
                paneNuevoFichCF.setDisable(false);
                etiNuevoErrorCF.setVisible(false);
                etiNuevoConfirmCF.setVisible(false);
            } else {
                etiFichNoExiste();
            }
        }
    }

    //Botón para seleccionar dónde se va a realizar la copia
    public void accionSelUbicCF(ActionEvent actionEvent) {
        DirectoryChooser dc = new DirectoryChooser();
        directSeleccionado = dc.showDialog(null);
        if (directSeleccionado==null) {
            return;
        }
        fieldRutaUbicCF.setText(directSeleccionado.getAbsolutePath());
    }

    //Botón que creará la copia en el directorio previamente seleccionado
    public void accionCopiarFich(ActionEvent actionEvent) throws  IOException {
        if (directSeleccionado == null) {
            etiNuevoErrorCF.setText("No ha seleccionado la ubicación");
            etiNuevoErrorCF.setVisible(true);
        } else {
            if (fichSeleccionado.exists()) {
                etiNuevoConfirmCF.setVisible(false);
                etiNuevoErrorCF.setVisible(false);
                File fichNuevo = new File(directSeleccionado.getAbsolutePath() + "\\" + fieldNombreCF.getText() + ".txt");
                if (fichNuevo.exists()) {
                    etiNuevoErrorCF.setText("El fichero ya existe");
                    etiNuevoErrorCF.setVisible(true);
                } else {
                    Copiar objCopiar = new Copiar(fichSeleccionado, fichNuevo);
                    objCopiar.copiarFich();
                    etiNuevoConfirmCF.setText("Fichero copiado correctamente");
                    etiNuevoConfirmCF.setVisible(true);
                }
            } else {
                etiNuevoConfirmCF.setVisible(false);
                etiNuevoErrorCF.setText("El fichero no existe");
                etiNuevoErrorCF.setVisible(true);
            }
        }
    }

    //Botón que nos hará volver a gestión de ficheros desde el Pane de copiar fichero
    public void accionVolverCF(ActionEvent actionEvent) {
        paneGestion.setVisible(true);
        paneGestion.setDisable(false);
        paneNuevoFichCF.setVisible(false);
        paneNuevoFichCF.setDisable(true);
    }



    //FUNCIONES PARA SIMPLIFICAR EL CÓDIGO

    public void etiPrimeroSelFich () {
        etiConfirm.setVisible(false);
        etiError.setVisible(false);
        etiGuia.setText("Primero debe seleccionar un fichero");
        etiGuia.setVisible(true);
    }

    public void etiFichNoExiste () {
        etiGuia.setVisible(false);
        etiConfirm.setVisible(false);
        etiError.setText("El fichero no existe");
        etiError.setVisible(true);
    }

    public void resetEtiAreaGuardar() {
        etiError.setVisible(false);
        etiConfirm.setVisible(false);
        etiGuia.setVisible(false);
        botGuardar.setVisible(false);
        botGuardar.setDisable(true);
        areaTexto.clear();
        areaTexto.setEditable(false);
    }

}
