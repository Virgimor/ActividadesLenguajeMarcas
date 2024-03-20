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

public class ParserXmlMultipleCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create a new factory of documents builder
				// 
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				
				try {
					// Create a new instance of document builder
					// Crear una nueva instancia del generador de documentos
					DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
					
					// Parse and store the XML in the instance of Document
					// Parsear y almacenar el XML en la instancia de Documento
					Document document = documentBuilder.parse(new File("car2.xml"));
					
					// This rootElement is ... coches
					// Este rootElement es ... coches
					Element rootElement = document.getDocumentElement();
					
					// Get the list of "coche"
					// Obtener la lista de "coche
					NodeList nodeListCar = rootElement.getElementsByTagName("coche");
					
					for(int i=0; i<nodeListCar.getLength(); i++) {
						
						// Get the first element of the list
						// Obtener el primer elemento de la lista
						// Para obterner el segundo coche del XML es item(1)
						Element nodeCar = (Element) nodeListCar.item(i);
						// Creamos otra Lista para las marcas
						NodeList nodeListMarca = nodeCar.getElementsByTagName("marca");
						// Get text from node values
						// Obtener texto de los valores de los nodos
						for(int j=0; j<nodeListMarca.getLength(); j++) {
							String marca      =nodeListMarca.item(j).getTextContent();
							
							System.out.println("Marca: " + marca);
							
						}
						String modelo     = nodeCar.getElementsByTagName("modelo").item(0).getTextContent();
						String kilometros = nodeCar.getElementsByTagName("kilometro").item(0).getTextContent();
						
						System.out.println("Modelo: " + modelo + ", kilometros: " + kilometros);
						
						// Get the element "motor"
						// Obtener el elemento "motor
						NodeList nodeListMotor = nodeCar.getElementsByTagName("motor");
						for (int k=0; k<nodeListMotor.getLength(); k++) {
							// Get the first element of the list
							// Obtener el primer elemento de la lista
							Element nodeMotor = (Element) nodeListMotor.item(k);
							
							String caballos   = nodeMotor.getElementsByTagName("caballos").item(0).getTextContent();
							String tipo       = nodeMotor.getElementsByTagName("tipo").item(0).getTextContent();
						}
						
						
					}
					
				} catch (ParserConfigurationException e){
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

	}

}
