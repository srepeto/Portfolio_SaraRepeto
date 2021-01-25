package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Tabla {

    JFrame marco;

    public Tabla (JFrame marco) {
        this.marco = marco;
    }

    public void TablaGUI () {
        JPanel panelFichTab = new JPanel();
        panelFichTab.setLayout(new FlowLayout());

        JPanel panelBotFT = new JPanel(new GridLayout(1,3,5,0));
        //panelBotFT.setBorder(new EmptyBorder(70, 5, 0, 5));
        JButton botGestionFT = new JButton("Gestión Empresas");
        botGestionFT.setPreferredSize(new Dimension(330,40));
        botGestionFT.setBorder(new EmptyBorder(0,0,0,0));
        JButton botAsigFT = new JButton("Asignación Alumnos");
        botAsigFT.setPreferredSize(new Dimension(330,40));
        botAsigFT.setBorder(new EmptyBorder(0,0,0,0));
        JButton botFichFT = new JButton("Ficheros a tabla");
        botFichFT.setPreferredSize(new Dimension(330,40));
        botFichFT.setBorder(new EmptyBorder(0,0,0,0));

        panelBotFT.add(botGestionFT);
        panelBotFT.add(botAsigFT);
        panelBotFT.add(botFichFT);

        panelFichTab.add(panelBotFT, BorderLayout.NORTH);
        JPanel panel7 = new JPanel(new BorderLayout());
        panel7.setBorder(new EmptyBorder(20,0,0,0));
        panelFichTab.add(panel7);
        refreshTable(panel7);

        // -------- ACCIONES DE BOTONES -----------

        ActionListener accionBotFT = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == botAsigFT) {
                    AsigAlum ObjAA = new AsigAlum(marco);
                    ObjAA.asigAlumGUI();
                }
                if(e.getSource() == botFichFT) {
                    FicherosTabla ObjFT = new FicherosTabla(marco);
                    ObjFT.FichTablaGUI();
                }
                if(e.getSource() == botGestionFT) {
                    GestionEmpresas ObjGE = new GestionEmpresas(marco);
                    ObjGE.GestEmpGUI();
                }
            }
        };

        botFichFT.addActionListener(accionBotFT);
        botAsigFT.addActionListener(accionBotFT);
        botGestionFT.addActionListener(accionBotFT);

        // -----------------

        marco.setContentPane(panelFichTab);
        marco.invalidate();
        marco.setSize(1000,500);
        marco.validate();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setResizable(false);
        marco.setVisible(true);
    }

    public void refreshTable(JPanel p7) {
        p7.removeAll();
        JTable table = cargarTabla();
        table.setBounds(230, 15, 700, 100);
        JScrollPane mac = new JScrollPane(table);
        mac.setPreferredSize(new Dimension(925, 365));
        p7.add(mac);
    }

    public JTable cargarTabla() {
        try {
            final String usuario = "root";
            final String contrasenia = "root";

            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Proy3TE1", usuario, contrasenia);
            String consulta = "SELECT CodEmpresa, Nombre, CIF, Dirección, CP, Localidad, TipoJornada, DNIResp, NombreResp, ApellidosResp, DNITL, NombreTL, ApellidosTL, MailTL, TelefonoTL FROM empresas";

            Statement stmt = conexBd.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            return new JTable(construirModeloDeTabla(rs));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public TableModel construirModeloDeTabla(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }
}