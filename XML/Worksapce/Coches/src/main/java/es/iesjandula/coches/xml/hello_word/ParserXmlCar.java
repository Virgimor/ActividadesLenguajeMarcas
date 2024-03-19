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

public class ParserXmlCar {

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
			Document document = documentBuilder.parse(new File("car.xml"));
			
			// This rootElement is ... coches
			// Este rootElement es ... coches
			Element rootElement = document.getDocumentElement();
			
			// Get the list of "coche"
			// Obtener la lista de "coche
			NodeList nodeListCar = rootElement.getElementsByTagName("coche");
			
			// Get the first element of the list
			// Obtener el primer elemento de la lista
			Element nodeCar = (Element) nodeListCar.item(0);
			
			// Get text from node values
			// Obtener texto de los valores de los nodos
			String marca      = nodeCar.getElementsByTagName("marca").item(0).getTextContent();
			String modelo     = nodeCar.getElementsByTagName("modelo").item(0).getTextContent();
			String kilometros = nodeCar.getElementsByTagName("kilometros").item(0).getTextContent();
			
			System.out.println("Marca: " + marca + ", modelo: " + modelo + ", kilometros: " + kilometros);
			
			// Get the element "motor"
			// Obtener el elemento "motor
			NodeList nodeListMotor = nodeCar.getElementsByTagName("motor");
			
			// Get the first element of the list
			// Obtener el primer elemento de la lista
			Element nodeMotor = (Element) nodeListMotor.item(0);
			
			String caballos   = nodeMotor.getElementsByTagName("caballos").item(0).getTextContent();
			String tipo       = nodeMotor.getElementsByTagName("tipo").item(0).getTextContent();
			
		} catch (ParserConfigurationException | SAXException | IOException e){
			e.printStackTrace();
		}

	}

}
