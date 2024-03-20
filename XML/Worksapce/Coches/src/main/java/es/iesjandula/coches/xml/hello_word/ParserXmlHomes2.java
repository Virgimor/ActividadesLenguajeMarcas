package es.iesjandula.coches.xml.hello_word;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParserXmlHomes2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a new factory of documents builder
				// Crear una nueva fábrica de documentos
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				
				try {
					
					// Create a new instance of document builder
					// Crear una nueva instancia del generador de documentos
					DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
					
					// Parse and store the XML in the instance of Document
					// Parsear y almacenar el XML en la instancia de Documento
					Document document = documentBuilder.parse(new File("homes.xml"));
					
					// This rootElement is ... casas
					// Este rootElement es ... casas
					Element rootElement = document.getDocumentElement();
					
					// Get the list of "casa"
					// Obtener la lista de "casa"
					NodeList nodeListHome = rootElement.getElementsByTagName("casa");
					for(int i=0; i<nodeListHome.getLength(); i++) {
						
						// Get the first element of the list
						// Obtener el primer elemento de la lista
						Element nodeHome = (Element) nodeListHome.item(i);
						
						// Get text from node values
						// Obtener texto de los valores de los nodos
												// Dame el valor del atributo.con nombre().dame su contenido
						String ciudad        = nodeHome.getAttribute("ciudad");
						String tipo          = nodeHome.getAttribute("tipo");
						int metrosCuadrados  = Integer.valueOf(nodeHome.getAttribute("metrosCuadrados"));
						int plantas          = Integer.valueOf(nodeHome.getAttribute("plantas"));
						int habitaciones     = Integer.valueOf(nodeHome.getAttribute("plantas"));
						boolean zonasComunes = Boolean.valueOf(nodeHome.getAttribute("zonasComunes"));
						
						System.out.println("Ciudad: " + ciudad + ", tipo: " + tipo + ", metrosCuadrados: " + metrosCuadrados + ", plantas: " + plantas + 
								", habitaciones: " + habitaciones + ", zonasComunes: " + zonasComunes);
					}
					
				} catch (ParserConfigurationException | SAXException | IOException e){
					e.printStackTrace();
				}

	}

}
