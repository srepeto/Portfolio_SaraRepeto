package vista;

import java.io.File;
import java.net.URL;
import java.sql.*;
import controlador.TestGestionSAFA;
import modelo.ExtraerFicheros;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FicherosTabla {
    JFrame marco;

    public FicherosTabla (JFrame marco) {
        this.marco = marco;
    }

    public void FichTablaGUI () {
        JPanel panelFichTab = new JPanel();
        panelFichTab.setBorder(new EmptyBorder(0,-35,0,0));

        Icon logoMariaDB = new ImageIcon(TestGestionSAFA.class.getResource("/Fich_tabla.png"));
        JLabel etiLogoMariaDB = new JLabel(logoMariaDB);
        etiLogoMariaDB.setBorder(new EmptyBorder(70, 40, 40, 40));

        JPanel panelBotFT = new JPanel(new GridLayout(1,3,5,0));
        //panelBotFT.setBorder(new EmptyBorder(70, 5, 0, 5));
        JButton botGestionFT = new JButton("Gestión Empresas");
        botGestionFT.setPreferredSize(new Dimension(270,40));
        botGestionFT.setBorder(new EmptyBorder(0,40,0,0));
        JButton botAsigFT = new JButton("Asignación Alumnos");
        botAsigFT.setPreferredSize(new Dimension(270,40));
        botAsigFT.setBorder(new EmptyBorder(0,0,0,0));
        JButton botFichFT = new JButton("Ficheros a BBDD");
        botFichFT.setPreferredSize(new Dimension(270,40));
        botFichFT.setBorder(new EmptyBorder(0,0,0,0));
        botFichFT.setSelected(true);
        botFichFT.setFocusable(false);

        JButton botFichTab = new JButton("Importar info a BBDD");
        botFichTab.setPreferredSize(new Dimension(157,30));

        JPanel panelIcono = new JPanel();
        panelIcono.setBorder(new EmptyBorder(10,300,0,0));
        JLabel fondo;
        ImageIcon img = new ImageIcon("res/SAFA.jpg");
        Image img1 = img.getImage();
        Image newImg = img1.getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon imgg = new ImageIcon(newImg);
        fondo = new JLabel("",imgg,JLabel.CENTER);

        JPanel panelBoton = new JPanel();
        panelBoton.add(botFichTab);

        JPanel panelMenu = new JPanel(new FlowLayout());
        panelMenu.setBorder(new EmptyBorder(-5,-5,-5,680));

        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Menú");
        JMenuItem ayuda = new JMenuItem("Ayuda");

        menu.add(ayuda);
        barra.add(menu);
        menu.add(ayuda);
        panelMenu.add(barra);

        panelIcono.add(fondo);
        panelIcono.setBorder(BorderFactory.createEmptyBorder(7,460,0,0));
        panelBoton.setBorder(BorderFactory.createEmptyBorder(0,120,40,0));

        panelBotFT.add(botGestionFT);
        panelBotFT.add(botAsigFT);
        panelBotFT.add(botFichFT);

        panelFichTab.add(panelMenu);
        panelFichTab.add(panelBotFT, BorderLayout.NORTH);
        panelFichTab.add(etiLogoMariaDB, BorderLayout.CENTER);
        panelFichTab.add(panelBoton, BorderLayout.SOUTH);
        panelFichTab.add(panelIcono);

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

        ActionListener accionBotFT = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == botAsigFT) {
                    AsigAlum ObjAA = new AsigAlum(marco);
                    ObjAA.asigAlumGUI();
                }
                if(e.getSource() == botFichTab) {
                    try {
                        ExtraerFicheros objFT = new ExtraerFicheros();
                        objFT.FichXML();
                        objFT.FichDat();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                if(e.getSource() == botGestionFT) {
                    GestionEmpresas ObjGE = new GestionEmpresas(marco);
                    ObjGE.GestEmpGUI();
                }
            }
        };

        botFichTab.addActionListener(accionBotFT);
        botAsigFT.addActionListener(accionBotFT);
        botGestionFT.addActionListener(accionBotFT);

        // -----------------

        marco.setContentPane(panelFichTab);
        marco.invalidate();
        marco.setSize(800,525);
        marco.validate();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setResizable(false);
        marco.setVisible(true);
    }

}
