package es.iesjandula.coches.xml.hello_word;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ConvertHelloWorldAXml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a new factory of documents builder
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		
		try {
			
			//Create a new instance of document builder
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			// This is the file to be written as XML
			FileOutputStream output = new FileOutputStream("hello_world_out.xml");
			
			// Create a document that contains the XML structure
			Document document = documentBuilder.newDocument();
			
			// Create a root element
			Element rootElement = document.createElement("mi_etiqueta_raiz");
			
			rootElement.setTextContent("Hola mundo!");
			
			//Add to the document
			document.appendChild(rootElement);
			
			writeXml(document, output);
			
		} catch (ParserConfigurationException | TransformerException | IOException xmlException) {
			xmlException.printStackTrace();
		}

	}
	private static void writeXml(Document document, OutputStream output) throws TransformerException{
		
		// Create a new factory of documents builder
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		
		// Create a new instrance of transformer
		Transformer transformer = transformerFactory.newTransformer();
		
		//This is the source information that it would be store ...
		DOMSource xmlAsObject = new DOMSource(document);
		
		// ... here, in the stream result
		StreamResult xmlAsFile = new StreamResult(output);
		
		// Transform objects to file
		transformer.transform(xmlAsObject, xmlAsFile);
	}

}
