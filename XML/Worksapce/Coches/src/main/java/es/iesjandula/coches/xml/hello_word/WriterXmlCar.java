package es.iesjandula.coches.xml.hello_word;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import es.iesjandula.coches.Coche;

public class WriterXmlCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Coche coche = null ;
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		
		try {
			
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			FileOutputStream output = new FileOutputStream("car_out.xml");
			
			Document document = documentBuilder.newDocument();
			
			Element carsElement = document.createElement("coches");
			
			Element carElement = document.createElement("coche");
			
			Element carMarkElemnt = document.createElement("marca");
			carMarkElemnt.setTextContent(coche.getMarca());
			
			Element carModelElement = document.createElement("modelo");
			carModelElement.setTextContent(coche.getModelo());
			
			Element carkilometersElement = document.createElement("kilometro");
			carkilometersElement.setTextContent(String.valueOf(coche.getKilometros()));
			
			// Add the previous elements to 'carElement'
			
		} catch (ParserConfigurationException xmlException){
			xmlException.printStackTrace();
		} catch (SAXException xmlException) {
			xmlException.printStackTrace();
		} catch (IOException xmlException) {
			xmlException.printStackTrace();
		}

	}

}
