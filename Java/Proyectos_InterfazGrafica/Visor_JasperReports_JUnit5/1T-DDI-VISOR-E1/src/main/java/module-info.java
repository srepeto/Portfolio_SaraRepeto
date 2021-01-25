module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;

    opens vista to javafx.fxml;
    exports controlador;
}