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
import org.xml.sax.SAXException;

import es.iesjandula.coches.Coche;

public class WriterXmlCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Coche coche = null;

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

		try {

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			FileOutputStream output = new FileOutputStream("car_out.xml");

			Document document = documentBuilder.newDocument();

			Element carsElement = document.createElement("coches");

			Element carElement = document.createElement("coche");

			Element carMarkElement = document.createElement("marca");
			carMarkElement.setTextContent(coche.getMarca());

			Element carModelElement = document.createElement("modelo");
			carModelElement.setTextContent(coche.getModelo());

			Element carkilometersElement = document.createElement("kilometro");
			carkilometersElement.setTextContent(String.valueOf(coche.getKilometros()));

			// Add the previous elements to 'carElement'
			carElement.appendChild(carMarkElement);
			carElement.appendChild(carModelElement);
			carElement.appendChild(carkilometersElement);

			// Create a child element "motor"
			Element carEngineElement = document.createElement("motor");

			// Create child element 'caballos' and add the value
			Element carEngineRevolutionsElement = document.createElement("caballos");
			carEngineRevolutionsElement.setTextContent(String.valueOf(coche.getMotor().getCaballos()));

			// Create child element 'tipo' and add the value
			Element carEngineTypeElement = document.createElement("tipo");
			carEngineTypeElement.setTextContent(coche.getMotor().getTipo());

			// Add the previous elements to 'carEngine'
			carEngineElement.appendChild(carEngineRevolutionsElement);
			carEngineElement.appendChild(carEngineTypeElement);

			// Add the element 'carEngine' to 'car'
			carElement.appendChild(carEngineElement);

			// Add the element 'car' to 'cars'
			carsElement.appendChild(carElement);

			// Add 'carElement' to the document
			document.appendChild(carsElement);

			writeXml(document, output);

		} catch (ParserConfigurationException xmlException) {
			xmlException.printStackTrace();
		} catch (SAXException xmlException) {
			xmlException.printStackTrace();
		} catch (IOException xmlException) {
			xmlException.printStackTrace();
		}

	}

	private static void writeXml(Document document, OutputStream output) throws SAXException  {

		// Create a new factory of documents builder
		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		

		// This is the source information that it would be store ...
		DOMSource xmlAsObject = new DOMSource(document);

		// ... here, in the stream result
		StreamResult xmlAsFile = new StreamResult(output);

		
	}

}
