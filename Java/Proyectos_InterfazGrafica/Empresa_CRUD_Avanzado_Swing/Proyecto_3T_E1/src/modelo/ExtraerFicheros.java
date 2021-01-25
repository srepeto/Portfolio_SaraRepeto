package modelo;

import java.io.*;
import java.sql.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ExtraerFicheros {

    public void FichXML() throws SQLException {
        Connection conexBd = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/proy3te1", "root", "root");

            InputStream fichXML = this.getClass().getResourceAsStream("/tutoresSAFA.xml");

            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fichXML);
                doc.getDocumentElement().normalize();

                NodeList tutores = doc.getElementsByTagName("tutordoc");

                for (int cont = 0; cont < tutores.getLength(); cont++) {
                    Node nodo = tutores.item(cont);

                    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) nodo;
                        String codTut = element.getElementsByTagName("codtut").item(0).getTextContent();
                        String nomAp = element.getElementsByTagName("nomap").item(0).getTextContent();
                        String correo = element.getElementsByTagName("correo").item(0).getTextContent();
                        String telefono = element.getElementsByTagName("telefono").item(0).getTextContent();

                        Statement compPK = conexBd.createStatement();
                        ResultSet resul = compPK.executeQuery("SELECT * FROM tutoresdocentes WHERE CodigoTutor = "+codTut);

                        if (resul.next()==true) {
                            System.out.println("Ya existe un tutor de código "+ codTut);
                        } else {
                            PreparedStatement st = conexBd.prepareStatement("INSERT INTO tutoresdocentes VALUES (?,?,?,?)");
                            st.setInt(1, Integer.parseInt(codTut));
                            st.setString(2, nomAp);
                            st.setString(3, correo);
                            st.setInt(4, Integer.parseInt(telefono));

                            st.executeUpdate();
                        }

                    }
                }

            } catch(Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException | ClassNotFoundException se) {
        } finally {
            if (conexBd != null)
                try {
                    conexBd.close();
                } catch (SQLException ignore) {}
        }
    }


    public void FichDat () {

        Connection conexBd = null;

        try {

            Class.forName("org.mariadb.jdbc.Driver");
            conexBd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/Proy3TE1", "root", "root");

            RandomAccessFile fichero = null;

            try {

                fichero = new RandomAccessFile("res/alumnos2CFS.dat", "r");
                fichero.seek(fichero.getFilePointer());

                while (true) {
                    int codAlum = fichero.readInt();
                    String DNI = fichero.readUTF();
                    String nombre = fichero.readUTF();
                    String apellidos = fichero.readUTF();
                    String fechaNac = fichero.readUTF();

                    Statement compPK = conexBd.createStatement();
                    ResultSet resul = compPK.executeQuery("SELECT * FROM alumnos WHERE CodigoAlumno = "+codAlum);

                    if (resul.next()==true) {
                        System.out.println("Ya existe un alumno de código "+ codAlum);
                    } else {
                        PreparedStatement st = conexBd.prepareStatement("INSERT INTO alumnos VALUES (?,?,?,?,?)");
                        st.setInt(1, codAlum);
                        st.setString(2, DNI);
                        st.setString(3, nombre);
                        st.setString(4, apellidos);
                        st.setDate(5, Date.valueOf(fechaNac));

                        st.executeUpdate();
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (EOFException eofe) {
            }catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException | ClassNotFoundException se) {
        } finally {
            if (conexBd != null)
                try {
                    conexBd.close();
                } catch (SQLException ignore) {}
        }

    }


}
