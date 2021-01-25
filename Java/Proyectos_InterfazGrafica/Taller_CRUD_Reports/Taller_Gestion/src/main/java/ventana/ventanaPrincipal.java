
package ventana;

import com.formdev.flatlaf.FlatDarculaLaf;
import conexion.Conexion;
import dao.OperariosDao;
import dao.TrabajosDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import validacion.ValidarCampos;
import vo.Operario;
import vo.Trabajo;

public class ventanaPrincipal extends javax.swing.JFrame {
    TrabajosDao acciones = new TrabajosDao();
    OperariosDao accionesOp = new OperariosDao();
    Trabajo trabajo = new Trabajo();
    Operario operario = new Operario();
    ValidarCampos validar = new ValidarCampos();
    String[] titulosTrabajos = {"idtrabajo", "idoperario", "tipotrabajo", "descripcion", "numhoras", "costematerial", "preciototal", "estado", "comienzo", "fin"};
    String[] titulosOperarios = {"idoperario", "DNI", "Nombre", "Apellidos", "Dirección", "Teléfono"};
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    //DefaultTableModel modeloTabla;
    
    public ventanaPrincipal() {
        setTitle("Gestión del taller");
        setResizable(false);
        initComponents();
        cambiarLookAndFeel();
        construirTablaTrabajos();       
    }  
    
    private void construirTablaTrabajos () {       
        String datos [][] = obtenerDatosTrabajos();
        
        //modeloTabla = new DefaultTableModel(datosUnOperario, titulosTrabajos);
        tabla = new JTable(datos, titulosTrabajos);
        panelTabla.setViewportView(tabla);        
    }
    
    private String[][] obtenerDatosTrabajos () {
        ArrayList<Trabajo> todosTrabajos = acciones.obtenerTodos();
        String [][] datos = new String[todosTrabajos.size()][10];
        
        for (int i = 0; i < todosTrabajos.size(); i++) {
            datos [i][0] = todosTrabajos.get(i).getIdtrabajo()+"";
            datos [i][1] = todosTrabajos.get(i).getIdoperario()+"";
            datos [i][2] = todosTrabajos.get(i).getTipotrabajo();
            datos [i][3] = todosTrabajos.get(i).getDescripcion();
            datos [i][4] = todosTrabajos.get(i).getNumhoras()+"";
            datos [i][5] = todosTrabajos.get(i).getPreciomaterial()+"";
            datos [i][6] = todosTrabajos.get(i).getPrecio()+"";
            datos [i][7] = todosTrabajos.get(i).getEstado();
            datos [i][8] = todosTrabajos.get(i).getFechacomienzo();
            datos [i][9] = todosTrabajos.get(i).getFechafin();           
            
        }
        
        return datos;
    }

    private void construirTablaUnRegistro(Trabajo trabajo) {
        String datosUno [][] = new String [1][10];
        
        datosUno [0][0] = trabajo.getIdtrabajo()+"";
        datosUno [0][1] = trabajo.getIdoperario()+"";
        datosUno [0][2] = trabajo.getTipotrabajo();
        datosUno [0][3] = trabajo.getDescripcion();
        datosUno [0][4] = trabajo.getNumhoras()+"";
        datosUno [0][5] = trabajo.getPreciomaterial()+"";
        datosUno [0][6] = trabajo.getPrecio()+"";
        datosUno [0][7] = trabajo.getEstado();
        datosUno [0][8] = trabajo.getFechacomienzo();
        datosUno [0][9] = trabajo.getFechafin();
        
        //modeloTabla = new DefaultTableModel(datosUno, titulosTrabajos);
        tabla = new JTable(datosUno, titulosTrabajos);
        panelTabla.setViewportView(tabla);
    }
    
    private void consTablaTrabajosOperario (ArrayList <Trabajo> listaTrabajos) {
        String [][] datosUnOperario = new String[listaTrabajos.size()][10];
        
        for (int i = 0; i < listaTrabajos.size(); i++) {
            datosUnOperario [i][0] = listaTrabajos.get(i).getIdtrabajo()+"";
            datosUnOperario [i][1] = listaTrabajos.get(i).getIdoperario()+"";
            datosUnOperario [i][2] = listaTrabajos.get(i).getTipotrabajo();
            datosUnOperario [i][3] = listaTrabajos.get(i).getDescripcion();
            datosUnOperario [i][4] = listaTrabajos.get(i).getNumhoras()+"";
            datosUnOperario [i][5] = listaTrabajos.get(i).getPreciomaterial()+"";
            datosUnOperario [i][6] = listaTrabajos.get(i).getPrecio()+"";
            datosUnOperario [i][7] = listaTrabajos.get(i).getEstado();
            datosUnOperario [i][8] = listaTrabajos.get(i).getFechacomienzo();
            datosUnOperario [i][9] = listaTrabajos.get(i).getFechafin();            
        }
       
        tabla = new JTable(datosUnOperario, titulosTrabajos);
        panelTabla.setViewportView(tabla);
    }
    
        private void construirTablaOperarios () {       
        String datos [][] = obtenerDatosOperarios();
        
        //modeloTabla = new DefaultTableModel(datosUnOperario, titulosTrabajos);
        tabla = new JTable(datos, titulosOperarios);
        panelTabla.setViewportView(tabla);        
    }
    
    private String[][] obtenerDatosOperarios () {
        ArrayList<Operario> todosOperarios = accionesOp.obtenerTodos();
        String [][] datos = new String[todosOperarios.size()][6];
        
        for (int i = 0; i < todosOperarios.size(); i++) {
            datos [i][0] = todosOperarios.get(i).getIdoperario()+"";
            datos [i][1] = todosOperarios.get(i).getDni()+"";
            datos [i][2] = todosOperarios.get(i).getNombre();
            datos [i][3] = todosOperarios.get(i).getApellidos();
            datos [i][4] = todosOperarios.get(i).getDireccion()+"";
            datos [i][5] = todosOperarios.get(i).getTelefono()+"";             
        }
        
        return datos;
    }
    
    public void rellenarFieldsTrabajo (Trabajo trabajo) {
        idT.setValue(trabajo.getIdtrabajo());
        idOpT.setValue(trabajo.getIdoperario());
        comboTipoT.setSelectedItem(trabajo.getTipotrabajo());
        descT.setText(trabajo.getDescripcion());
        horasT.setValue(trabajo.getNumhoras());
        preciomaterialT.setText(trabajo.getPreciomaterial()+"");
        precioT.setText(trabajo.getPrecio()+"");        
        estadoT.setSelectedItem(trabajo.getEstado());
        comienzoT.setText(trabajo.getFechacomienzo());
        finT.setText(trabajo.getFechafin());
    }
    
    public void ponerFieldsEnBlanco () {
        idT.setValue(0);
        //idOpT.setValue(0);
        comboTipoT.setSelectedIndex(0);
        descT.setText("");
        horasT.setValue(0);
        preciomaterialT.setText("0.0");
        precioT.setText("0.0");        
        estadoT.setSelectedIndex(0);
        comienzoT.setText("");
        finT.setText("0000-00-00");
    }
    
    public float calcularPrecio () {
        float preciofinal=0;
        float horas = Float.valueOf(horasT.getValue().toString());
        float preciomaterial = Float.parseFloat(preciomaterialT.getText());
        
        if (comboTipoT.getSelectedItem().equals("Reparación mecánica")) {
            preciofinal = (float) ((horas*30) + (preciomaterial*1.5));
        }
        if (comboTipoT.getSelectedItem().equals("Chapa y pintura")) {
            preciofinal = (horas*30) + (preciomaterial*2);
        }
        if (comboTipoT.getSelectedItem().equals("Revisión")) {
            preciofinal = (horas*30);
            if (preciofinal!=0) {
                preciofinal = preciofinal + 20;
            }
        }
        
        return preciofinal;
    }
    
    public boolean noCamposEnBlanco () {
        
        if (descT.getText().isEmpty() || preciomaterialT.getText().isEmpty() || comienzoT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hay campos sin rellenar", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public void resetFieldsReportes () {
        fieldComienzo.setText("");
        fieldDNI.setText("");
        fieldFin.setText("");
        spinnerIDop.setValue(0);
        fieldComienzo.setEnabled(false);
        fieldDNI.setEnabled(false);
        fieldFin.setEnabled(false);
        spinnerIDop.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabpane = new javax.swing.JTabbedPane();
        paneTrabajos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        idT = new javax.swing.JSpinner();
        idOpT = new javax.swing.JSpinner();
        descT = new javax.swing.JTextField();
        horasT = new javax.swing.JSpinner();
        estadoT = new javax.swing.JComboBox<>();
        finT = new javax.swing.JFormattedTextField();
        consTrabajo = new javax.swing.JButton();
        consOpT = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        comboTipoT = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        precioT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        preciomaterialT = new javax.swing.JTextField();
        mostrarTodos = new javax.swing.JButton();
        insertarT = new javax.swing.JButton();
        modificarT = new javax.swing.JButton();
        comienzoT = new javax.swing.JTextField();
        eliminarT = new javax.swing.JButton();
        paneOperarios = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        fieldApellidos = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        fieldDNIop = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        fieldDireccion = new javax.swing.JTextField();
        fieldTelefono = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        botInsOperario = new javax.swing.JButton();
        paneReportes = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        comboReportes = new javax.swing.JComboBox<>();
        fieldDNI = new javax.swing.JTextField();
        labelDNI = new javax.swing.JLabel();
        labelComienzo = new javax.swing.JLabel();
        fieldComienzo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        fieldFin = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        botReporte = new javax.swing.JButton();
        spinnerIDop = new javax.swing.JSpinner();
        panelTabla = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paneTrabajos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                paneTrabajosComponentShown(evt);
            }
        });

        jLabel1.setText("ID Trabajo");

        jLabel2.setText("ID Operario");

        jLabel3.setText("Descripción");

        jLabel4.setText("Horas");

        jLabel6.setText("Estado");

        jLabel7.setText("Fin");

        jLabel8.setText("Comienzo");

        estadoT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En espera", "En proceso", "Finalizado" }));

        finT.setEditable(false);
        finT.setText("0000-00-00");

        consTrabajo.setText("Consultar y rellenar");
        consTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consTrabajoActionPerformed(evt);
            }
        });

        consOpT.setText("Consultar");
        consOpT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consOpTActionPerformed(evt);
            }
        });

        jLabel9.setText("Tipo de Trabajo");

        comboTipoT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reparación mecánica", "Chapa y pintura", "Revisión" }));

        jLabel5.setText("Precio");

        precioT.setEditable(false);
        precioT.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioT.setText("0.0");

        jLabel10.setText("Coste material");

        preciomaterialT.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        preciomaterialT.setText("0.0");

        mostrarTodos.setText("Mostrar todos los registros");
        mostrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTodosActionPerformed(evt);
            }
        });

        insertarT.setText("Insertar");
        insertarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarTActionPerformed(evt);
            }
        });

        modificarT.setText("Modificar");
        modificarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarTActionPerformed(evt);
            }
        });

        eliminarT.setText("Eliminar");
        eliminarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneTrabajosLayout = new javax.swing.GroupLayout(paneTrabajos);
        paneTrabajos.setLayout(paneTrabajosLayout);
        paneTrabajosLayout.setHorizontalGroup(
            paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTrabajosLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mostrarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paneTrabajosLayout.createSequentialGroup()
                        .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(31, 31, 31)
                        .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estadoT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(paneTrabajosLayout.createSequentialGroup()
                                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(paneTrabajosLayout.createSequentialGroup()
                                        .addComponent(idOpT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(consOpT))
                                    .addComponent(horasT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(precioT, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(preciomaterialT, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(paneTrabajosLayout.createSequentialGroup()
                                        .addComponent(idT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(consTrabajo))
                                    .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(comienzoT, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(finT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(descT)))
                    .addGroup(paneTrabajosLayout.createSequentialGroup()
                        .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(insertarT))
                        .addGap(26, 26, 26)
                        .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboTipoT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(paneTrabajosLayout.createSequentialGroup()
                                .addComponent(modificarT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eliminarT)
                                .addGap(28, 28, 28)))))
                .addGap(106, 106, 106))
        );
        paneTrabajosLayout.setVerticalGroup(
            paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTrabajosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(mostrarTodos)
                .addGap(27, 27, 27)
                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consTrabajo))
                .addGap(18, 18, 18)
                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idOpT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consOpT))
                .addGap(18, 18, 18)
                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboTipoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(descT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(horasT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(preciomaterialT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(precioT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(estadoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comienzoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(finT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(paneTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertarT)
                    .addComponent(modificarT)
                    .addComponent(eliminarT))
                .addGap(24, 24, 24))
        );

        tabpane.addTab("Trabajos", paneTrabajos);

        paneOperarios.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                paneOperariosComponentShown(evt);
            }
        });

        jLabel15.setText("Nombre");

        jLabel16.setText("Apellidos");

        jLabel17.setText("DNI");

        jLabel18.setText("Dirección");

        jLabel19.setText("Teléfono");

        botInsOperario.setText("Insertar");
        botInsOperario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botInsOperarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneOperariosLayout = new javax.swing.GroupLayout(paneOperarios);
        paneOperarios.setLayout(paneOperariosLayout);
        paneOperariosLayout.setHorizontalGroup(
            paneOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneOperariosLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(paneOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneOperariosLayout.createSequentialGroup()
                        .addComponent(botInsOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(paneOperariosLayout.createSequentialGroup()
                        .addGroup(paneOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(28, 28, 28)
                        .addGroup(paneOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldDNIop, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(fieldNombre)
                            .addComponent(fieldApellidos)
                            .addComponent(fieldDireccion)
                            .addComponent(fieldTelefono))
                        .addGap(154, 154, 154))))
        );
        paneOperariosLayout.setVerticalGroup(
            paneOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneOperariosLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(paneOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(fieldDNIop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(fieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(fieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(fieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(botInsOperario)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        tabpane.addTab("Operarios", paneOperarios);

        paneReportes.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                paneReportesComponentShown(evt);
            }
        });

        jLabel11.setText("Tipo de reporte");

        comboReportes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas las reparaciones", "Todos los trabajadores", "Trabajador por DNI", "Reparación por fecha de comienzo", "Reparación por fecha de fin", "Reparación por operario" }));
        comboReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboReportesActionPerformed(evt);
            }
        });

        labelDNI.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDNI.setText("DNI");
        labelDNI.setOpaque(true);

        labelComienzo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelComienzo.setText("Fecha comienzo");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Fecha fin");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("ID Operario");

        botReporte.setText("Generar Reporte");
        botReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneReportesLayout = new javax.swing.GroupLayout(paneReportes);
        paneReportes.setLayout(paneReportesLayout);
        paneReportesLayout.setHorizontalGroup(
            paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneReportesLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneReportesLayout.createSequentialGroup()
                        .addGroup(paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelComienzo)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fieldFin, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldComienzo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerIDop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(botReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        paneReportesLayout.setVerticalGroup(
            paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneReportesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDNI))
                .addGap(18, 18, 18)
                .addGroup(paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelComienzo)
                    .addComponent(fieldComienzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(fieldFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(paneReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(spinnerIDop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(botReporte)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        tabpane.addTab("Reportes", paneReportes);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        panelTabla.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabpane, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabpane)
            .addComponent(panelTabla, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paneOperariosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_paneOperariosComponentShown
        construirTablaOperarios();
    }//GEN-LAST:event_paneOperariosComponentShown

    private void consTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consTrabajoActionPerformed
        trabajo = acciones.obtenerTrabajo((int)idT.getValue());
        if (trabajo.getIdtrabajo()!=null) {
            construirTablaUnRegistro(trabajo);
            rellenarFieldsTrabajo(trabajo);
        } else {
            JOptionPane.showMessageDialog(null, "No hay ningún trabajo con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_consTrabajoActionPerformed

    private void consOpTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consOpTActionPerformed
        operario = accionesOp.obtenerOperario((int)idOpT.getValue());
        if (operario.getIdoperario()!=null) {
            ArrayList <Trabajo> listatrabajos = acciones.obtenerTrabajosOperario((int)idOpT.getValue());
            if (listatrabajos.size()!=0) {
                consTablaTrabajosOperario(listatrabajos);
                ponerFieldsEnBlanco();
            } else {
                JOptionPane.showMessageDialog(null, "Este operario no tiene asignado ningún trabajo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este operario no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_consOpTActionPerformed

    private void modificarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarTActionPerformed
        trabajo = acciones.obtenerTrabajo((int)idT.getValue());         
        if (trabajo.getIdtrabajo()!=null) {
            operario = accionesOp.obtenerOperario((int)idOpT.getValue());
            if (operario.getIdoperario()!=null) {
                if (!trabajo.getEstado().equals("Finalizado")) {
                    if (noCamposEnBlanco()) {
                        if (validar.camposTrabajoValidos(preciomaterialT.getText(), comienzoT.getText())) {
                            trabajo.setIdtrabajo((int)idT.getValue());
                            trabajo.setIdoperario((int)idOpT.getValue());
                            trabajo.setTipotrabajo(comboTipoT.getSelectedItem()+"");
                            trabajo.setDescripcion(descT.getText());
                            trabajo.setNumhoras((int)horasT.getValue());
                            trabajo.setPreciomaterial(Float.parseFloat(preciomaterialT.getText()));
                            trabajo.setPrecio(calcularPrecio());
                            precioT.setText(calcularPrecio()+"");
                            trabajo.setEstado(estadoT.getSelectedItem()+"");               
                            trabajo.setFechacomienzo(comienzoT.getText());

                            if (estadoT.getSelectedItem().equals("Finalizado")) {
                                Date date = new Date();
                                trabajo.setFechafin(formatoFecha.format(date));
                            } else {
                                trabajo.setFechafin(finT.getText());
                            }

                            if (acciones.modificar(trabajo)) {
                                construirTablaUnRegistro(trabajo);
                                JOptionPane.showMessageDialog(null, "Trabajo modificado", "Información", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Este trabajo no puede ser modificado porque ya ha sido finalizado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este operario no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay ningún trabajo con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_modificarTActionPerformed
        
    private void mostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTodosActionPerformed
        construirTablaTrabajos();
        ponerFieldsEnBlanco();
        idOpT.setValue(0);
    }//GEN-LAST:event_mostrarTodosActionPerformed

    private void insertarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarTActionPerformed
        operario = accionesOp.obtenerOperario((int)idOpT.getValue());
        if (operario.getIdoperario()!=null) {
            if (noCamposEnBlanco()) {
                if (validar.camposTrabajoValidos(preciomaterialT.getText(), comienzoT.getText())) {
                    trabajo.setIdoperario((int)idOpT.getValue());
                    trabajo.setTipotrabajo(comboTipoT.getSelectedItem()+"");
                    trabajo.setDescripcion(descT.getText());
                    trabajo.setNumhoras((int)horasT.getValue());
                    trabajo.setPreciomaterial(Float.parseFloat(preciomaterialT.getText()));
                    trabajo.setPrecio(calcularPrecio());
                    precioT.setText(calcularPrecio()+"");
                    trabajo.setEstado(estadoT.getSelectedItem()+"");               
                    trabajo.setFechacomienzo(comienzoT.getText());
                    if (estadoT.getSelectedItem().equals("Finalizado")) {
                        Date date = new Date();
                        trabajo.setFechafin(formatoFecha.format(date));
                    } else {
                        trabajo.setFechafin(finT.getText());
                    }
                    if (acciones.insertar(trabajo)) {
                        ponerFieldsEnBlanco();
                        idOpT.setValue(0);
                        construirTablaTrabajos();
                        JOptionPane.showMessageDialog(null, "Trabajo insertado", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este operario no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_insertarTActionPerformed

    private void eliminarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTActionPerformed
        String[] opciones = {"Si", "No"};        
        trabajo = acciones.obtenerTrabajo((int)idT.getValue());
        if (trabajo.getIdtrabajo()!=null) {
            int dialogResult = JOptionPane.showOptionDialog(null, "¿Estás segur@?","Eliminar trabajo con ID " + idT.getValue(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);            
            if(dialogResult == JOptionPane.YES_OPTION){
                acciones.eliminar((int)idT.getValue());
                ponerFieldsEnBlanco();
                idOpT.setValue(0);
                construirTablaTrabajos();
                JOptionPane.showMessageDialog(null, "Trabajo eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay ningún trabajo con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarTActionPerformed

    private void botReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botReporteActionPerformed
        if(comboReportes.getSelectedItem().equals("Todas las reparaciones")){
            try {
                JasperReport archivo = JasperCompileManager.compileReport("Todas_reparaciones.jrxml");
                Map <String, Object> map = new HashMap<>();
                map.put("parLogo", "logotipo.jpg");
                Conexion con = new Conexion();
                JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
                JasperExportManager.exportReportToPdfFile(prin, "Todas_reparaciones.pdf");
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "Todas_reparaciones.pdf");
            } catch (JRException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(comboReportes.getSelectedItem().equals("Todos los trabajadores")){
            try {
                JasperReport archivo = JasperCompileManager.compileReport("Todos_trabajadores.jrxml");
                Map <String, Object> map = new HashMap<>();
                map.put("parLogo", "logotipo.jpg");
                Conexion con = new Conexion();
                JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
                JasperExportManager.exportReportToPdfFile(prin, "Todos_trabajadores.pdf");
                Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "Todos_trabajadores.pdf");
            } catch (JRException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(comboReportes.getSelectedItem().equals("Trabajador por DNI")){
            if (!fieldDNI.getText().isEmpty()) {
                if (!validar.esNumero(fieldDNI.getText())) {
                    try {
                        JasperReport archivo = JasperCompileManager.compileReport("Trabajador_DNI.jrxml");
                        Map <String, Object> map = new HashMap<>();
                        map.put("parDNI", fieldDNI.getText());
                        map.put("parLogo", "logotipo.jpg");
                        Conexion con = new Conexion();
                        JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
                        JasperExportManager.exportReportToPdfFile(prin, "Trabajador_DNI.pdf");
                        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "Trabajador_DNI.pdf");
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "DNI incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe rellenar el campo solicitado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(comboReportes.getSelectedItem().equals("Reparación por fecha de comienzo")){
            if (!fieldComienzo.getText().isEmpty()) {
                if (validar.esFecha(fieldComienzo.getText())) {
                    try {
                        JasperReport archivo = JasperCompileManager.compileReport("Reparacion_FechaComienzo.jrxml");
                        Map <String, Object> map = new HashMap<>();
                        map.put("parFechaComienzo", fieldComienzo.getText());
                        map.put("parLogo", "logotipo.jpg");
                        Conexion con = new Conexion();
                        JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
                        JasperExportManager.exportReportToPdfFile(prin, "Reparacion_FechaComienzo.pdf");
                        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "Reparacion_FechaComienzo.pdf");
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Formato de Fecha incorrecto. Ejemplo: 2020-10-31", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe rellenar el campo solicitado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(comboReportes.getSelectedItem().equals("Reparación por fecha de fin")){
            if (!fieldFin.getText().isEmpty()) {
                if (validar.esFecha(fieldFin.getText())) {
                    try {
                        JasperReport archivo = JasperCompileManager.compileReport("Reparacion_FechaFin.jrxml");
                        Map <String, Object> map = new HashMap<>();
                        map.put("parFechaFin", fieldFin.getText());
                        map.put("parLogo", "logotipo.jpg");
                        Conexion con = new Conexion();
                        JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
                        JasperExportManager.exportReportToPdfFile(prin, "Reparacion_FechaFin.pdf");
                        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "Reparacion_FechaFin.pdf");
                    } catch (JRException ex) {
                        JOptionPane.showMessageDialog(null, "Error al generar el informe", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al abrir el informe", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Formato de Fecha incorrecto. Ejemplo: 2020-10-31", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe rellenar el campo solicitado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(comboReportes.getSelectedItem().equals("Reparación por operario")){
            operario = accionesOp.obtenerOperario((int)spinnerIDop.getValue());
            if (operario.getIdoperario()!=null) {
                ArrayList <Trabajo> listatrabajos = acciones.obtenerTrabajosOperario((int)spinnerIDop.getValue());
                if (listatrabajos.size()!=0) {
                    try {
                        JasperReport archivo = JasperCompileManager.compileReport("Reparacion_porOperario.jrxml");
                        Map <String, Object> map = new HashMap<>();
                        map.put("parIDop", spinnerIDop.getValue());
                        map.put("parLogo", "logotipo.jpg");
                        Conexion con = new Conexion();
                        JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
                        JasperExportManager.exportReportToPdfFile(prin, "Reparacion_porOperario.pdf");
                        Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "Reparacion_porOperario.pdf");
                    } catch (JRException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Este operario no tiene asignado ningún trabajo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este operario no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botReporteActionPerformed

    private void comboReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboReportesActionPerformed
        if (comboReportes.getSelectedItem().equals("Todas las reparaciones")) {            
            resetFieldsReportes();
        }
        if (comboReportes.getSelectedItem().equals("Todos los trabajadores")) {
            resetFieldsReportes();
        }
        if(comboReportes.getSelectedItem().equals("Trabajador por DNI")) {
            resetFieldsReportes();
            fieldDNI.setEnabled(true);
        }
        if(comboReportes.getSelectedItem().equals("Reparación por fecha de comienzo")) {
            resetFieldsReportes();
            fieldComienzo.setEnabled(true);
        }
        if(comboReportes.getSelectedItem().equals("Reparación por fecha de fin")) {
            resetFieldsReportes();
            fieldFin.setEnabled(true);
        }
        if(comboReportes.getSelectedItem().equals("Reparación por operario")) {
            resetFieldsReportes();
            spinnerIDop.setEnabled(true);
        }
    }//GEN-LAST:event_comboReportesActionPerformed

    private void paneReportesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_paneReportesComponentShown
        comboReportes.setSelectedItem("Todas las reparaciones");        
    }//GEN-LAST:event_paneReportesComponentShown

    private void paneTrabajosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_paneTrabajosComponentShown
        construirTablaTrabajos();
    }//GEN-LAST:event_paneTrabajosComponentShown

    private void botInsOperarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botInsOperarioActionPerformed
        if (!fieldDNIop.getText().isEmpty() && !fieldNombre.getText().isEmpty() && !fieldApellidos.getText().isEmpty() && !fieldDireccion.getText().isEmpty() && !fieldTelefono.getText().isEmpty()) {
            if (validar.camposOperarioValidos(fieldDNIop.getText(), fieldNombre.getText(), fieldApellidos.getText(), fieldDireccion.getText(), fieldTelefono.getText())) {
                operario.setDni(fieldDNIop.getText());
                operario.setNombre(fieldNombre.getText());
                operario.setApellidos(fieldApellidos.getText());
                operario.setDireccion(fieldDireccion.getText());
                operario.setTelefono(fieldTelefono.getText());
                accionesOp.insertar(operario);
                construirTablaOperarios();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay campos sin rellenar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botInsOperarioActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaPrincipal().setVisible(true);
            }
        });       
        
    }
    
    private void cambiarLookAndFeel () {
        try {
            UIManager.setLookAndFeel(FlatDarculaLaf.class.getCanonicalName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Throwable e) {
                JOptionPane.showConfirmDialog(this, "Error estableciendo LookAndFeel");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botInsOperario;
    private javax.swing.JButton botReporte;
    private javax.swing.JComboBox<String> comboReportes;
    private javax.swing.JComboBox<String> comboTipoT;
    private javax.swing.JTextField comienzoT;
    private javax.swing.JButton consOpT;
    private javax.swing.JButton consTrabajo;
    private javax.swing.JTextField descT;
    private javax.swing.JButton eliminarT;
    private javax.swing.JComboBox<String> estadoT;
    private javax.swing.JTextField fieldApellidos;
    private javax.swing.JTextField fieldComienzo;
    private javax.swing.JTextField fieldDNI;
    private javax.swing.JTextField fieldDNIop;
    private javax.swing.JTextField fieldDireccion;
    private javax.swing.JTextField fieldFin;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldTelefono;
    private javax.swing.JFormattedTextField finT;
    private javax.swing.JSpinner horasT;
    private javax.swing.JSpinner idOpT;
    private javax.swing.JSpinner idT;
    private javax.swing.JButton insertarT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelComienzo;
    private javax.swing.JLabel labelDNI;
    private javax.swing.JButton modificarT;
    private javax.swing.JButton mostrarTodos;
    private javax.swing.JPanel paneOperarios;
    private javax.swing.JPanel paneReportes;
    private javax.swing.JPanel paneTrabajos;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTextField precioT;
    private javax.swing.JTextField preciomaterialT;
    private javax.swing.JSpinner spinnerIDop;
    private javax.swing.JTable tabla;
    private javax.swing.JTabbedPane tabpane;
    // End of variables declaration//GEN-END:variables
}


