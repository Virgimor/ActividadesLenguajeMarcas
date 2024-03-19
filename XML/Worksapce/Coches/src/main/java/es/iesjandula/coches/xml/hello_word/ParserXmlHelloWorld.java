package es.iesjandula.coches.xml.hello_word;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class ParserXmlHelloWorld {

	public static void main(String[] args) {
		
		// Create a new factory of documents builder
		// Crear una nueva fábrica de documentos
		DocumentBuilderFactory documentBulderFactory =  DocumentBuilderFactory.newInstance();
		
		try {
			
			// Create a new instance of document builder
			// Crear una nueva instancia del generador de documentos
			DocumentBuilder documentBuilder = documentBulderFactory.newDocumentBuilder();
			
			// Parse and store the XML in the instance of Document
			// Parsear y almacenar el XML en la instancia de Documento 
			Document document = documentBuilder.parse(new File("hello_world.xml"));
			
			// Get the root element
			// Obtener el elemento raíz
			Element rootElement = document.getDocumentElement();
			
			System.out.println("Nombre del elemento raíz ... " + rootElement.getNodeName());
			System.out.println("Valor de elemento raíz ... " + rootElement.getTextContent());
			
		} catch (ParserConfigurationException xmlException) {
			xmlException.printStackTrace();
		} catch (SAXException xmlException){
			xmlException.printStackTrace();
		} catch (IOException xmlException) {
			xmlException.printStackTrace();
		}

	}

}
