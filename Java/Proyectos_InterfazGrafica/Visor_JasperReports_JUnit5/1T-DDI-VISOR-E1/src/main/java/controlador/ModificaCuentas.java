package controlador;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Conexion;
import modelo.Cuenta;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


public class ModificaCuentas extends Conexion implements Initializable {

    ArrayList<Cuenta> listaCuentas = new ArrayList<>();

    public int contadorCuentas = 0;
    public boolean identBotNueva = false;
    public Label etiExist;
    public Label etiNueva;
    public TextField numero;
    public TextField titular;
    public TextField fecha;
    public TextField nacionalidad;
    public TextField saldo;
    public Button siguiente;
    public Button atras;
    public Button nueva;
    public Button aceptar;
    public Button cancelar;
    public Button reporte1;
    public Button reporte2;

    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listaCuentas = rellenarArray();
        actualizarDatos();
    }

    public void accionSiguiente() {
        if (contadorCuentas == (listaCuentas.size())-2) {
            identBotNueva = true;
            siguiente.setVisible(false);
            siguiente.setDisable(true);
            nueva.setVisible(true);
            nueva.setDisable(false);
        }

        if (contadorCuentas < (listaCuentas.size())-1) {
            contadorCuentas++;
        }

        if (contadorCuentas > 0) {
            atras.setVisible(true);
            atras.setDisable(false);
        }

        actualizarDatos();
    }

    public void accionAtras() {
        if (identBotNueva) {
            siguiente.setVisible(true);
            siguiente.setDisable(false);
            nueva.setVisible(false);
            nueva.setDisable(true);
            identBotNueva = false;
        }

        if (contadorCuentas > 0) {
            contadorCuentas--;
        }

        if (contadorCuentas == 0) {
            atras.setVisible(false);
            atras.setDisable(true);
        }

        actualizarDatos();
    }

    public void accionNueva() {
        etiExist.setVisible(false);
        etiNueva.setVisible(true);
        numero.clear();
        titular.clear();
        fecha.clear();
        nacionalidad.clear();
        saldo.clear();
        numero.setEditable(true);
        titular.setEditable(true);
        fecha.setEditable(true);
        nacionalidad.setEditable(true);
        saldo.setEditable(true);

        nueva.setVisible(false);
        nueva.setDisable(true);
        atras.setVisible(false);
        atras.setDisable(true);

        aceptar.setVisible(true);
        aceptar.setDisable(false);
        cancelar.setVisible(true);
        cancelar.setDisable(false);
    }

    public void accionAceptar() {

        String redField = "-fx-background-color: #ED6D6D";

        numero.setStyle("");
        titular.setStyle("");
        fecha.setStyle("");
        nacionalidad.setStyle("");
        saldo.setStyle("");

        boolean isValid = true;
        new SimpleDateFormat("yyyy-MM-dd");

        if (!numero.getText().isEmpty() && !isNumeric(numero.getText())) {

            for (Cuenta cuenta : listaCuentas) {
                if (Integer.parseInt(numero.getText()) == cuenta.getNumCuenta()) {
                    isValid = false;
                    numero.setStyle(redField);
                }
            }

        } else {
            isValid = false;
            numero.setStyle(redField);
        }

        if (!titular.getText().isEmpty()) {
            if (!isNumeric(titular.getText())) {
                isValid = false;
                titular.setStyle(redField);
            }
        } else {
            isValid = false;
            titular.setStyle(redField);
        }

        if (!fecha.getText().isEmpty()) {
            if (!validDate(fecha.getText())) {
                isValid = false;
                fecha.setStyle(redField);
            }
        } else {
            isValid = false;
            fecha.setStyle(redField);
        }

        if (!nacionalidad.getText().isEmpty()) {
            if (!isNumeric(nacionalidad.getText())) {
                isValid = false;
                nacionalidad.setStyle(redField);
            }
        } else {
            isValid = false;
            nacionalidad.setStyle(redField);
        }

        if (!saldo.getText().isEmpty()) {
            if (isNumeric(saldo.getText())) {
                isValid = false;
                saldo.setStyle(redField);
            }
        } else {
            isValid = false;
            saldo.setStyle(redField);
        }

        if (isValid) {

            Cuenta newCuenta = new Cuenta(Integer.parseInt(numero.getText()), titular.getText(), fecha.getText(), nacionalidad.getText(), Double.parseDouble(saldo.getText()));
            listaCuentas.add(newCuenta);
            insertarCuenta(newCuenta);
            contadorCuentas++;

            etiNueva.setVisible(false);
            etiExist.setVisible(true);
            numero.setEditable(false);
            titular.setEditable(false);
            fecha.setEditable(false);
            nacionalidad.setEditable(false);
            saldo.setEditable(false);

            aceptar.setVisible(false);
            aceptar.setDisable(true);
            cancelar.setVisible(false);
            cancelar.setDisable(true);

            atras.setVisible(true);
            atras.setDisable(false);
            nueva.setVisible(true);
            nueva.setDisable(false);
        }

    }

    public void accionCancelar() {

        numero.setStyle("");
        titular.setStyle("");
        fecha.setStyle("");
        nacionalidad.setStyle("");
        saldo.setStyle("");

        etiNueva.setVisible(false);
        etiExist.setVisible(true);
        numero.setEditable(false);
        titular.setEditable(false);
        fecha.setEditable(false);
        nacionalidad.setEditable(false);
        saldo.setEditable(false);

        actualizarDatos();

        aceptar.setVisible(false);
        aceptar.setDisable(true);
        cancelar.setVisible(false);
        cancelar.setDisable(true);

        atras.setVisible(true);
        atras.setDisable(false);
        nueva.setVisible(true);
        nueva.setDisable(false);
    }

    public void accionReporte1 () {
        JasperReport archivo1;
        try
        {
            archivo1 = JasperCompileManager.compileReport("Reporte_Basico.jrxml");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("logo_reporte", "logo_reporte.png");
            Conexion con = new Conexion();
            JasperPrint prin = JasperFillManager.fillReport(archivo1,map,con.getConnection());
            JasperExportManager.exportReportToPdfFile(prin,"Reporte_Basico.pdf");
            System.out.println("Reporte creado con éxito");
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "Reporte_Basico.pdf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (JRException e)
        {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void accionReporte2 () {
        JasperReport archivo2;
        try
        {
            archivo2 = JasperCompileManager.compileReport("Reporte_Confeccionado.jrxml");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("logo_reporte", "logo_reporte.png");
            Conexion con = new Conexion();
            JasperPrint prin = JasperFillManager.fillReport(archivo2,map,con.getConnection());
            JasperExportManager.exportReportToHtmlFile(prin,"Reporte_Confeccionado.html");
            System.out.println("Reporte creado con éxito");
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "Reporte_Confeccionado.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (JRException e)
        {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void actualizarDatos () {
        numero.setText(String.valueOf(listaCuentas.get(contadorCuentas).getNumCuenta()));
        titular.setText(listaCuentas.get(contadorCuentas).getTitular());
        fecha.setText(listaCuentas.get(contadorCuentas).getFechaApertura());
        nacionalidad.setText(listaCuentas.get(contadorCuentas).getNac());
        saldo.setText(String.valueOf(listaCuentas.get(contadorCuentas).getSaldo()));
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }

    public boolean validDate(String fecha){
        Date date;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try{
            date = dateFormat.parse(fecha);
            Calendar calendario = Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"));
            calendario.setTime(date);
            int ano = calendario.get(Calendar.YEAR);
            int mes = calendario.get(Calendar.MONTH);
            int dia = calendario.get(Calendar.DAY_OF_MONTH);
            if (mes > 12 || dia > 31 || ano > 2020) {
                return false;
            }
        }catch (ParseException e){
            return false;
        }
        return true;
    }

    public ArrayList<Cuenta> rellenarArray () {
        this.conectarBBDD();
        String sql = "SELECT * FROM cuentas";
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        try {
            statement = this.conexion.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Cuenta nuevaCuenta = new Cuenta();
                nuevaCuenta.setNumCuenta(resultSet.getInt("numero_cuenta"));
                nuevaCuenta.setTitular(resultSet.getString("titular"));
                nuevaCuenta.setFechaApertura(resultSet.getString("fecha_apertura"));
                nuevaCuenta.setNac(resultSet.getString("nacionalidad"));
                nuevaCuenta.setSaldo(resultSet.getDouble("saldo"));

                cuentas.add(nuevaCuenta);
            }

            return cuentas;

        } catch (SQLException ex) {
            System.out.println("Ha habido un error");
        } finally {
            this.cerrarConexion();
        }

        return cuentas;
    }

    public boolean insertarCuenta (Cuenta cuenta) {
        this.conectarBBDD();

        try {
            preparedStatement = conexion.prepareStatement("INSERT INTO cuentas VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, cuenta.getNumCuenta());
            preparedStatement.setString(2, cuenta.getTitular());
            preparedStatement.setString(3, cuenta.getFechaApertura());
            preparedStatement.setString(4, cuenta.getNac());
            preparedStatement.setDouble(5, cuenta.getSaldo());

            int regIns = preparedStatement.executeUpdate();

        }catch (SQLException ex) {
            System.out.println("Ha habido un problema en la insercion");
            return false;
        } finally {
            cerrarConexion();
        }

        return true;
    }


}
