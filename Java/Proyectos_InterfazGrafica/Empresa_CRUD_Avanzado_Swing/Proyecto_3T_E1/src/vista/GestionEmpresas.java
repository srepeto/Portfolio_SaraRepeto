package vista;

import modelo.Borrar;
import modelo.InsertarOmodif;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.sql.*;

public class GestionEmpresas {
    JFrame marco;

    public GestionEmpresas (JFrame marco) {
        this.marco = marco;
    }

    public void GestEmpGUI () {

        // ----------------- Creamos los elementos del JFrame--------------------

        JPanel principal = new JPanel(new BorderLayout());
        principal.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));

        //PANEL BOTONES ARRIBA
        JPanel panel8 = new JPanel(new GridLayout(1,3,5,0));


        JButton botGestionGE = new JButton("Gestion Empresas ");
        botGestionGE.setPreferredSize(new Dimension(260,40));
        botGestionGE.setBorder(new EmptyBorder(0,0,0,0));
        botGestionGE.setSelected(true);
        botGestionGE.setFocusable(false);
        JButton botAsigGE = new JButton("Asignacion Alumnos ");
        botAsigGE.setPreferredSize(new Dimension(260,40));
        botAsigGE.setBorder(new EmptyBorder(0,0,0,0));
        botAsigGE.setFocusable(false);
        JButton botFichGE = new JButton("Ficheros a BBDD");
        botFichGE.setPreferredSize(new Dimension(260,40));
        botFichGE.setBorder(new EmptyBorder(0,0,0,0));
        botFichGE.setFocusable(false);

        panel8.add(botGestionGE);
        panel8.add(botAsigGE);
        panel8.add(botFichGE);

        //PANELES SECCIONES
        JPanel panelEtiEmpresa = new JPanel();
        panelEtiEmpresa.setBorder(new EmptyBorder(20,0,0,0));
        JPanel panelEmpresa = new JPanel(new GridLayout(1,3,10,0));
        JPanel panel1EM = new JPanel(new GridLayout(3,2,-20,0));
        panel1EM.setBorder(new EmptyBorder(0,10,0,0));
        JPanel panel2EM = new JPanel(new GridLayout(3,2,-10,0));
        panel2EM.setBorder(new EmptyBorder(0,0,0,0));
        JPanel panel3EM = new JPanel();
        panel3EM.setBorder(new EmptyBorder(20,0,0,0));

        JPanel panelEtiResponsable = new JPanel();
        panelEtiResponsable.setBorder(new EmptyBorder(20,0,0,0));
        JPanel panelResponsable = new JPanel(new GridLayout(1,3));
        JPanel panel1RES = new JPanel(new GridLayout(1,2,-20,0));
        panel1RES.setBorder(new EmptyBorder(0,10,0,10));
        JPanel panel2RES = new JPanel(new GridLayout(1,2,-20,0));
        panel2RES.setBorder(new EmptyBorder(0,10,0,10));
        JPanel panel3RES = new JPanel(new GridLayout(1,2,-20,0));
        panel3RES.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));

        JPanel panelEtiTutor = new JPanel();
        panelEtiTutor.setBorder(new EmptyBorder(20,0,0,0));
        JPanel panelTutor = new JPanel(new GridLayout(1,3));
        JPanel panel1TUTOR = new JPanel(new GridLayout(2,2,-20,0));
        panel1TUTOR.setBorder(new EmptyBorder(0,10,0,10));
        JPanel panel2TUTOR = new JPanel(new GridLayout(2,2,-20,0));
        panel2TUTOR.setBorder(new EmptyBorder(0,10,0,10));
        JPanel panel3TUTOR = new JPanel();
        panel3TUTOR.setBorder(BorderFactory.createEmptyBorder(0,30,0,0));

        //PANEL MENSAJE
        JPanel panelMensaje = new JPanel();
        panelMensaje.setBorder(new EmptyBorder(30,325,20,0));

        //PANEL BOTONES ABAJO
        JPanel panel5 = new JPanel();
        panel5.setBorder(new EmptyBorder(0,0,0,100));
        panel5.setBorder(BorderFactory.createEmptyBorder(0, 180, 3,0));
        panel5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 7));

        JButton insert = new JButton("Insertar");
        JButton modificar = new JButton("Modificar");
        JButton borrar = new JButton("Borrar");
        JButton btnVerTabla = new JButton("Ver tabla con los registros");

        panel5.add(insert);
        panel5.add(modificar);
        panel5.add(borrar);
        panel5.add(btnVerTabla);

        //PANEL ICONO
        JPanel panelIcono = new JPanel();
        panelIcono.setBorder(new EmptyBorder(10,107,0,0));
        JLabel fondo;
        ImageIcon img = new ImageIcon("res/SAFA.jpg");
        Image img1 = img.getImage();
        Image newImg = img1.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon imgg = new ImageIcon(newImg);
        fondo = new JLabel("",imgg,JLabel.CENTER);

        panelIcono.add(fondo);

        JPanel panelMenu = new JPanel(new FlowLayout());
        panelMenu.setBorder(new EmptyBorder(-5,0,-5,0));

        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Menú");
        JMenuItem ayuda = new JMenuItem("Ayuda");

        menu.add(ayuda);
        barra.add(menu);
        menu.add(ayuda);
        panelMenu.add(barra);
        principal.add(panelMenu);

        //ELEMENTOS

        Font fuente = new Font("Calibri", Font.BOLD,15);
        JLabel etiEmpresa = new JLabel("EMPRESA");
        etiEmpresa.setFont(fuente.deriveFont(fuente.getAttributes()));
        etiEmpresa.setForeground(new Color(17, 148, 145));
        JLabel etiResponsable = new JLabel("RESPONSABLE");
        etiResponsable.setFont(fuente.deriveFont(fuente.getAttributes()));
        etiResponsable.setForeground(new Color(17, 148, 145));
        JLabel etiTutor = new JLabel("TUTOR LABORAL");
        etiTutor.setFont(fuente.deriveFont(fuente.getAttributes()));
        etiTutor.setForeground(new Color(17, 148, 145));
        JLabel texto = new JLabel("Codigo: ");
        JLabel texto1NE = new JLabel("Nombre: ");
        JLabel mensajes = new JLabel("Mensaje para incidencias");
        mensajes.setForeground(new Color(199, 13, 13));
        mensajes.setBorder(new EmptyBorder(10,0,0,100));
        JLabel ct = new JLabel("DNI:");
        ct.setBorder(new EmptyBorder(0,0,0,30));
        JLabel tutorLab = new JLabel("Nombre:");
        JLabel ape = new JLabel("Apellidos:");
        ape.setBorder(BorderFactory.createEmptyBorder(0,15,0,0));
        JLabel correo = new JLabel("Email:");
        correo.setBorder(BorderFactory.createEmptyBorder(0,15,0,0));
        JLabel dniR = new JLabel("DNI:");
        dniR.setBorder(new EmptyBorder(0,50,0,0));
        JLabel jor = new JLabel("Jornada:");
        JLabel nomr = new JLabel("Nombre:");
        JLabel apr = new JLabel("Apellidos:");
        apr.setBorder(new EmptyBorder(0,20,0,0));
        JLabel ter = new JLabel("Teléfono:");
        JLabel ses = new JLabel("CIF:");
        JLabel not = new JLabel("Direccion");
        not.setBorder(BorderFactory.createEmptyBorder(0,30,0,20));
        JLabel nta = new JLabel("CP");
        nta.setBorder(BorderFactory.createEmptyBorder(0,30,0,20));
        JLabel lol = new JLabel("Localidad");
        lol.setBorder(BorderFactory.createEmptyBorder(0,30,0,20));
        JTextField dniTutLab = new JTextField(10);
        JComboBox jornada = new JComboBox();
        jornada.addItem("Partida");
        jornada.addItem("Continua");
        JTextField dniResp = new JTextField(10);
        JTextField nomTL = new JTextField(10);
        JTextField apeTL = new JTextField(10);
        JTextField nomResp = new JTextField(10);
        JTextField apeResp = new JTextField(10);
        JTextField emailTL = new JTextField(10);
        JTextField telfTL = new JTextField(10);
        JTextField codEmpresa = new JTextField(10);
        JTextField NEmpresa = new JTextField(10);
        JTextField CIF = new JTextField(10);
        JTextField Direccion = new JTextField(5);
        JTextField CP = new JTextField(5);
        JTextField Localidad = new JTextField(5);

        // ----------------- Insertamos los elementos en el panel principal --------------------

        marco.add(principal);
        principal.add(panel8);
        panelEtiEmpresa.add(etiEmpresa);

        panel1EM.add(texto);
        panel1EM.add(codEmpresa);
        panel1EM.add(texto1NE);
        panel1EM.add(NEmpresa);
        panel1EM.add(ses);
        panel1EM.add(CIF);

        panel2EM.add(not);
        panel2EM.add(Direccion);
        panel2EM.add(nta);
        panel2EM.add(CP);
        panel2EM.add(lol);
        panel2EM.add(Localidad);

        panel3EM.add(jor);
        panel3EM.add(jornada);

        panelEmpresa.add(panel1EM);
        panelEmpresa.add(panel2EM);
        panelEmpresa.add(panel3EM);

        panelEtiResponsable.add(etiResponsable);

        panel1RES.add(nomr);
        panel1RES.add(nomResp);

        panel2RES.add(apr);
        panel2RES.add(apeResp);

        panel3RES.add(dniR);
        panel3RES.add(dniResp);

        panelResponsable.add(panel1RES);
        panelResponsable.add(panel2RES);
        panelResponsable.add(panel3RES);

        panelEtiTutor.add(etiTutor);

        panel1TUTOR.add(tutorLab);
        panel1TUTOR.add(nomTL);
        panel1TUTOR.add(ter);
        panel1TUTOR.add(telfTL);

        panel2TUTOR.add(ape);
        panel2TUTOR.add(apeTL);
        panel2TUTOR.add(correo);
        panel2TUTOR.add(emailTL);

        panel3TUTOR.add(ct);
        panel3TUTOR.add(dniTutLab);

        panelTutor.add(panel1TUTOR);
        panelTutor.add(panel2TUTOR);
        panelTutor.add(panel3TUTOR);

        panelMensaje.add(mensajes);

        principal.add(panelEtiEmpresa);
        principal.add(panelEmpresa);
        principal.add(panelEtiResponsable);
        principal.add(panelResponsable);
        principal.add(panelEtiTutor);
        principal.add(panelTutor);
        principal.add(panelMensaje);
        principal.add(panel5);
        principal.add(panelIcono);

        File fichero = new File("help/help_set.hs");
        try {
            URL hsURL = fichero.toURI().toURL();
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            HelpBroker hb = helpset.createHelpBroker();
            hb.enableHelpOnButton(ayuda, "inicio", helpset);
            ayuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        } catch (Exception e) {
            System.out.println(e);
        }

        // -------- ACCIONES DE BOTONES -----------

        ActionListener accionBotGE = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == botAsigGE) {
                    AsigAlum ObjAA = new AsigAlum(marco);
                    ObjAA.asigAlumGUI();
                }
                if(e.getSource() == botFichGE) {
                    FicherosTabla ObjFT = new FicherosTabla(marco);
                    ObjFT.FichTablaGUI();
                }
                if(e.getSource() == botGestionGE) {
                    GestionEmpresas ObjGE = new GestionEmpresas(marco);
                    ObjGE.GestEmpGUI();
                }
            }
        };

        ActionListener verTabla = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnVerTabla) {
                    Tabla ObjTabla = new Tabla(marco);
                    ObjTabla.TablaGUI();
                }
            }
        };

        ActionListener insOmod = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    Integer codEmp = Integer.parseInt(codEmpresa.getText().trim());
                    String nomEmp = NEmpresa.getText().trim();
                    String cif = CIF.getText().trim();
                    String direccion = Direccion.getText().trim();
                    int codPost = Integer.parseInt(CP.getText().trim());
                    String localidad = Localidad.getText().trim();
                    String tipJornada = jornada.getSelectedItem().toString().trim();
                    String dniResponsable = dniResp.getText().trim();
                    String nombreResp = nomResp.getText().trim();
                    String apellidosResp = apeResp.getText().trim();
                    String dniTL = dniTutLab.getText().trim();
                    String nombreTL = nomTL.getText().trim();
                    String apellidosTL = apeTL.getText().trim();
                    String correoTL = emailTL.getText().trim();
                    int telefonoTL = Integer.parseInt(telfTL.getText().trim());

                    InsertarOmodif objAccGE = new InsertarOmodif(codEmp, nomEmp, cif, direccion, codPost, localidad,
                            tipJornada, dniResponsable, nombreResp, apellidosResp, dniTL, nombreTL, apellidosTL, correoTL, telefonoTL);

                    if (nomEmp.length()>0 && cif.length()>0 && direccion.length()>0 && localidad.length()>0 && tipJornada.length()>0 && dniResponsable.length()>0
                            && nombreResp.length()>0 && apellidosResp.length()>0 && dniTL.length()>0 && nombreTL.length()>0 && apellidosTL.length()>0 && correoTL.length()>0) {

                        if(e.getSource() == insert) {
                            try {
                                if (objAccGE.insertar()) {
                                    marco.setVisible(false);
                                    //refreshTable(panel7);
                                    marco.setVisible(true);
                                    mensajes.setText("Insertado con exito");
                                } else {
                                    mensajes.setText("Ya existe una empresa con ese código");
                                }
                            } catch (SQLException ex) {
                                mensajes.setText("Se ha producido un error");
                            }
                        }

                        if(e.getSource() == modificar) {
                            try {
                                if (objAccGE.modificar()) {
                                    marco.setVisible(false);
                                    //refreshTable(panel7);
                                    marco.setVisible(true);
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
        };

        ActionListener eliminar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer codEmp = Integer.parseInt(codEmpresa.getText());
                    Borrar objBor = new Borrar(codEmp);

                    if (objBor.borrar()) {
                        marco.setVisible(false);
                        //refreshTable(panel7);
                        marco.setVisible(true);
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
        };

        insert.addActionListener(insOmod);
        modificar.addActionListener(insOmod);
        borrar.addActionListener(eliminar);

        botFichGE.addActionListener(accionBotGE);
        botAsigGE.addActionListener(accionBotGE);
        botGestionGE.addActionListener(accionBotGE);
        btnVerTabla.addActionListener(verTabla);

        // -----------------

        marco.setContentPane(principal);
        marco.invalidate();
        marco.setSize(800,620);
        marco.validate();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setResizable(false);
        marco.setVisible(true);
    }
}