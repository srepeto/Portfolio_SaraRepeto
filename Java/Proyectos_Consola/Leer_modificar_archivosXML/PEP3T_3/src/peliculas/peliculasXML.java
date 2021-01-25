package peliculas;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.util.Random;
import java.util.Scanner;

public class peliculasXML {
    Scanner sc = new Scanner(System.in);

    public void menuOP1 () {
        System.out.println("1) Presentar el documento XML completo");
        System.out.println("2) Añadir nuevo nodo al documento");
        System.out.println("3) Modificar datos de un nodo del documento");
        System.out.println("4) Eliminar un nodo concreto del documento");
        System.out.println("5) Salir\n");
    }

    public void menuOp2 () {
        System.out.println("1) Al principio");
        System.out.println("2) Al final");
        System.out.println("3) En un punto intermedio\n");
    }

    public void presentarXML () {
        File fichXML = new File("src/peliculas.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fichXML);
            doc.getDocumentElement().normalize();

            System.out.println("\n========================");
            Element raiz = doc.getDocumentElement();
            System.out.println("\t   PELÍCULAS");
            System.out.println("========================\n");

            NodeList peliculas = doc.getElementsByTagName("pelicula");
            for (int cont = 0; cont < peliculas.getLength(); cont++) {
                Node nodo = peliculas.item(cont);
                System.out.println("Película "+(cont+1)+"\n");
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("Título: "+element.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Guionista: "+element.getElementsByTagName("guionista").item(0).getTextContent());
                    System.out.println("Productora: "+element.getElementsByTagName("productora").item(0).getTextContent());
                    System.out.println("Director: "+element.getElementsByTagName("director").item(0).getTextContent());
                    System.out.println("Actor: "+element.getElementsByTagName("actor").item(0).getTextContent());
                    System.out.println("Sinopsis: "+element.getElementsByTagName("sinopsis").item(0).getTextContent()+"\n");
                    System.out.println("------------------------\n");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void addNode (int op2) {
        File fichXML = new File("src/peliculas.xml");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fichXML);
            Element elemRaiz = doc.getDocumentElement();

            System.out.println("Introduzca los datos que van a formar el nodo:\n");
            System.out.print("Título: ");
            String tit = sc.nextLine();
            System.out.print("Guionista: ");
            String guion = sc.nextLine();
            System.out.print("Productora: ");
            String prod = sc.nextLine();
            System.out.print("Director: ");
            String dir = sc.nextLine();
            System.out.print("Actor: ");
            String act = sc.nextLine();
            System.out.print("Sinopsis: ");
            String sinop = sc.nextLine();


            Element pelicula = doc.createElement("pelicula");

            Element titulo = doc.createElement("titulo");
            titulo.appendChild(doc.createTextNode(tit));

            Element guionista = doc.createElement("guionista");
            guionista.appendChild(doc.createTextNode(guion));

            Element productora = doc.createElement("productora");
            productora.appendChild(doc.createTextNode(prod));

            Element director = doc.createElement("director");
            director.appendChild(doc.createTextNode(dir));

            Element actor = doc.createElement("actor");
            actor.appendChild(doc.createTextNode(act));

            Element sinopsis = doc.createElement("sinopsis");
            sinopsis.appendChild(doc.createTextNode(sinop));


            switch (op2) {
                case 1:
                    elemRaiz.insertBefore(pelicula, elemRaiz.getFirstChild());
                    pelicula.appendChild(titulo);
                    pelicula.appendChild(guionista);
                    pelicula.appendChild(productora);
                    pelicula.appendChild(director);
                    pelicula.appendChild(actor);
                    pelicula.appendChild(sinopsis);
                    break;
                case 2:
                    elemRaiz.appendChild(pelicula);
                    pelicula.appendChild(titulo);
                    pelicula.appendChild(guionista);
                    pelicula.appendChild(productora);
                    pelicula.appendChild(director);
                    pelicula.appendChild(actor);
                    pelicula.appendChild(sinopsis);
                    break;
                case 3:
                    NodeList lista = doc.getElementsByTagName("pelicula");
                    Random rdm = new Random();
                    int numRandom = rdm.nextInt(lista.getLength());
                    if (numRandom<1) {
                        numRandom=1;
                    }
                    Node nodo = lista.item(numRandom);

                    elemRaiz.insertBefore(pelicula, nodo);
                    pelicula.appendChild(titulo);
                    pelicula.appendChild(guionista);
                    pelicula.appendChild(productora);
                    pelicula.appendChild(director);
                    pelicula.appendChild(actor);
                    pelicula.appendChild(sinopsis);
                    break;
            }

            System.out.println("\nNodo insertado\n");

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult fileResult = new StreamResult(new File("src/peliculas.xml"));
            transformer.transform(source, fileResult);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void modifyNode (int op3) {
        File fichXML = new File("src/peliculas.xml");
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(fichXML);
            doc.getDocumentElement().normalize();
            Node peliculas = doc.getFirstChild();
            NodeList listaPelis = peliculas.getChildNodes();
            int i;

            System.out.println("Rellene con los nuevos datos:\n");
            System.out.print("Título: ");
            String tit = sc.nextLine();
            System.out.print("Guionista: ");
            String guion = sc.nextLine();
            System.out.print("Productora: ");
            String prod = sc.nextLine();
            System.out.print("Director: ");
            String dir = sc.nextLine();
            System.out.print("Actor: ");
            String act = sc.nextLine();
            System.out.print("Sinopsis: ");
            String sinop = sc.nextLine();

            switch (op3) {
                case 1:
                    Node primeraPeli = listaPelis.item(0);
                    NodeList datosPrimeraPeli = primeraPeli.getChildNodes();
                    for (i=0; i<datosPrimeraPeli.getLength(); i++) {
                        Node cadaDato = datosPrimeraPeli.item(i);
                        modifyText(cadaDato, tit, guion, prod, dir, act, sinop);
                    }
                    break;
                case 2:
                    Node ultimaPeli = listaPelis.item(listaPelis.getLength()-1);
                    NodeList datosUltimaPeli = ultimaPeli.getChildNodes();
                    for (i=0; i<datosUltimaPeli.getLength(); i++) {
                        Node cadaDato = datosUltimaPeli.item(i);
                        modifyText(cadaDato, tit, guion, prod, dir, act, sinop);
                    }
                    break;
                case 3:
                    Random rdm = new Random();
                    int numRandom = rdm.nextInt(listaPelis.getLength()-1);
                    if (numRandom<1) {
                        numRandom=1;
                    }
                    Node peliInterm = listaPelis.item(numRandom);
                    NodeList datosPeliInterm = peliInterm.getChildNodes();
                    for (i=0; i<datosPeliInterm.getLength(); i++) {
                        Node cadaDato = datosPeliInterm.item(i);
                        modifyText(cadaDato, tit, guion, prod, dir, act, sinop);
                    }
                    break;
            }

            System.out.println("\nDatos del nodo modificados\n");

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult fileResult = new StreamResult(new File("src/peliculas.xml"));
            transformer.transform(source, fileResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifyText (Node cadaDato, String tit, String guion, String prod, String dir, String act, String sinop) {
        if ("titulo".equals(cadaDato.getNodeName())) {
            cadaDato.setTextContent(tit);
        }
        if ("guionista".equals(cadaDato.getNodeName())) {
            cadaDato.setTextContent(guion);
        }
        if ("productora".equals(cadaDato.getNodeName())) {
            cadaDato.setTextContent(prod);
        }
        if ("director".equals(cadaDato.getNodeName())) {
            cadaDato.setTextContent(dir);
        }
        if ("actor".equals(cadaDato.getNodeName())) {
            cadaDato.setTextContent(act);
        }
        if ("sinopsis".equals(cadaDato.getNodeName())) {
            cadaDato.setTextContent(sinop);
        }
    }

    public void deleteNode (int op4) {
        File fichXML = new File("src/peliculas.xml");
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(fichXML);
            doc.getDocumentElement().normalize();
            Node peliculas = doc.getFirstChild();
            NodeList listaPelis = peliculas.getChildNodes();
            int i;

            switch (op4) {
                case 1:
                    Node primeraPeli = listaPelis.item(0);
                    primeraPeli.getParentNode().removeChild(primeraPeli);
                    break;
                case 2:
                    Node ultimaPeli = listaPelis.item(listaPelis.getLength()-1);
                    ultimaPeli.getParentNode().removeChild(ultimaPeli);
                    break;
                case 3:
                    Random rdm = new Random();
                    int numRandom = rdm.nextInt(listaPelis.getLength()-1);
                    if (numRandom<1) {
                        numRandom=1;
                    }
                    Node peliInterm = listaPelis.item(numRandom);
                    peliInterm.getParentNode().removeChild(peliInterm);
                    break;
            }

            System.out.println("Nodo eliminado\n");

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult fileResult = new StreamResult(new File("src/peliculas.xml"));
            transformer.transform(source, fileResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
