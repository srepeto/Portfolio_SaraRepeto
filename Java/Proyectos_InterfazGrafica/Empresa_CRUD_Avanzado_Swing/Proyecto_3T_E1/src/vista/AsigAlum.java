package vista;

import modelo.Asignacion;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

public class AsigAlum {
    JFrame marco;

    public AsigAlum (JFrame marco) {
        this.marco = marco;
    }


    public void asigAlumGUI() {

        JPanel principal = new JPanel();

        JPanel agrupCombosText = new JPanel(new BorderLayout());
        agrupCombosText.setBorder(BorderFactory.createEmptyBorder(0, 132, 100,0));

        JPanel elementos = new JPanel(new GridLayout(3,1, 5, 20));
        JPanel text = new JPanel();
        text.setBorder(new EmptyBorder(40,0,0,0));
        JPanel combo1 = new JPanel();
        JPanel combo2 = new JPanel();
        JPanel combo3 = new JPanel();

        JPanel botones = new JPanel();
        botones.setBorder(new EmptyBorder(0,0,40,0));

        JPanel panelBotAlum = new JPanel();
        panelBotAlum.setBorder(new EmptyBorder(95,0,0,0));

        JPanel panelIcono = new JPanel();
        panelIcono.setBorder(new EmptyBorder(250,30,0,0));
        JLabel fondo;
        ImageIcon img = new ImageIcon("res/SAFA.jpg");
        Image img1 = img.getImage();
        Image newImg = img1.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon imgg = new ImageIcon(newImg);
        fondo = new JLabel("",imgg,JLabel.CENTER);

        panelIcono.add(fondo);
        panelIcono.setBorder(BorderFactory.createEmptyBorder(215, 50, 0,0));

        JPanel panelMenu = new JPanel(new FlowLayout());
        panelMenu.setBorder(new EmptyBorder(-5,0,-5,675));

        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Menú");
        JMenuItem ayuda = new JMenuItem("Ayuda");

        menu.add(ayuda);
        barra.add(menu);
        menu.add(ayuda);
        panelMenu.add(barra);

        JLabel eAlumno = new JLabel("Elección de Alumno");
        eAlumno.setBorder(new EmptyBorder(0,0,0,10));
        JComboBox alumno = new JComboBox();
        alumno.setPreferredSize(new Dimension(200,20));
        alumno.setBorder(new EmptyBorder(0,0,0,0));
        JLabel eEmpresa = new JLabel("Elección de Empresa");
        eEmpresa.setBorder(new EmptyBorder(0,0,0,10));
        JComboBox empresa = new JComboBox();
        empresa.setPreferredSize(new Dimension(200,20));
        empresa.setBorder(new EmptyBorder(0,0,0,0));
        JLabel eTutor = new JLabel("Elección de Tutor");
        eTutor.setBorder(new EmptyBorder(0,0,0,25));
        JComboBox tutor = new JComboBox();
        tutor.setPreferredSize(new Dimension(200,20));
        tutor.setBorder(new EmptyBorder(0,0,0,0));
        JTextPane salida = new JTextPane();
        salida.setBackground(Color.LIGHT_GRAY);
        salida.setEditable(false);
        salida.setOpaque(true);
        salida.setPreferredSize(new Dimension (350, 60));
        StyledDocument doc = salida.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        JButton botGestionAA = new JButton("Gestión de Empresas");
        botGestionAA.setFocusable(false);
        botGestionAA.setPreferredSize(new Dimension(240,40));
        botGestionAA.setBorder(new EmptyBorder(0,0,0,0));
        JButton botAsigAA = new JButton("Asignación Alumnos");
        botAsigAA.setSelected(true);
        botAsigAA.setFocusable(false);
        botAsigAA.setPreferredSize(new Dimension(240,40));
        botAsigAA.setBorder(new EmptyBorder(0,0,0,0));
        JButton botFichAA = new JButton("Ficheros a BBDD");
        botFichAA.setFocusable(false);
        botFichAA.setPreferredSize(new Dimension(240,40));
        botFichAA.setBorder(new EmptyBorder(0,0,0,0));

        JButton botAsigAlum = new JButton("Asignar");
        botAsigAlum.setPreferredSize(new Dimension(100,40));

        combo1.add(eAlumno);
        combo1.add(alumno);
        combo2.add(eEmpresa);
        combo2.add(empresa);
        combo3.add(eTutor);
        combo3.add(tutor);

        elementos.add(combo1);
        elementos.add(combo2);
        elementos.add(combo3);

        text.add(salida);

        botones.add(botGestionAA);
        botones.add(botAsigAA);
        botones.add(botFichAA);

        agrupCombosText.add(elementos, BorderLayout.NORTH);
        agrupCombosText.add(text, BorderLayout.CENTER);

        panelBotAlum.add(botAsigAlum);

        principal.add(panelMenu);
        principal.add(botones, BorderLayout.NORTH);
        principal.add(agrupCombosText, BorderLayout.SOUTH);
        principal.add(panelBotAlum);
        principal.add(panelIcono);

        Asignacion objAsig = new Asignacion();
        objAsig.asigCombos(alumno, empresa, tutor);

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

        ActionListener accionBotAA = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == botAsigAA) {
                    //botAsigAA.setSelected(true);
                }
                if(e.getSource() == botAsigAlum) {
                    String nomApeAlum = String.valueOf(alumno.getSelectedItem());
                    String nomEmpresa = String.valueOf(empresa.getSelectedItem());
                    String nomTutor = String.valueOf(tutor.getSelectedItem());

                    String nomTutLab = objAsig.tutorLaboral(nomEmpresa);

                    if (objAsig.asigFinal(nomApeAlum, nomEmpresa, nomTutor)) {
                        salida.setText("El alumno "+nomApeAlum+" queda asignado a la empresa "+nomEmpresa+" supervisados por los tutores "+nomTutor+" (docente) y "+nomTutLab+" (laboral)");
                    } else {
                        salida.setText("Este alumno ya está asignado");
                    }

                }
                if(e.getSource() == botFichAA) {
                    FicherosTabla ObjFT = new FicherosTabla(marco);
                    ObjFT.FichTablaGUI();
                }
                if(e.getSource() == botGestionAA) {
                    GestionEmpresas ObjGE = new GestionEmpresas(marco);
                    ObjGE.GestEmpGUI();
                }
            }
        };

        botFichAA.addActionListener(accionBotAA);
        botAsigAlum.addActionListener(accionBotAA);
        botGestionAA.addActionListener(accionBotAA);

        // -----------------

        marco.setContentPane(principal);
        marco.invalidate();
        marco.setSize(750,475);
        marco.validate();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setResizable(false);
        marco.setVisible(true);
    }
}