package es.iesjandula.coches.xml.hello_word;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParserAlumnos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

		try {

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document document = documentBuilder.parse(new File("entrada_alumnos.xml"));

			Element rootElementEntrada = document.getDocumentElement();

			NodeList nodeListAlum = rootElementEntrada.getElementsByTagName("alumno");
			// Array de alumno
			Alumno[] arrayAlumnos = new Alumno[nodeListAlum.getLength()];

			for (int i = 0; i < nodeListAlum.getLength(); i++) {

				Element nodeAlum = (Element) nodeListAlum.item(i);

				if(Boolean
						.valueOf(nodeAlum.getElementsByTagName("unidadesPendientes").item(0).getTextContent())== true) {
					String nombre = nodeAlum.getAttribute("nombre");
					int edad = Integer.valueOf(nodeAlum.getAttribute("edad"));
					double calificacion = Double
							.valueOf(nodeAlum.getElementsByTagName("calificacion").item(0).getTextContent());
					boolean unidadesPendientes = Boolean
							.valueOf(nodeAlum.getElementsByTagName("unidadesPendientes").item(0).getTextContent());

					
					// 
					arrayAlumnos[i] = new Alumno(nombre, edad, calificacion, unidadesPendientes);
					
					System.out.println(arrayAlumnos[i]);
				}
				
			}
			Arrays.sort(arrayAlumnos);
			System.out.println(arrayAlumnos);
			

			FileOutputStream output = new FileOutputStream("salida-alumnos.txt");

			Document documentExit = documentBuilder.newDocument();

			Element rootElementExit = document.createElement("alumnos");

			rootElementExit.setTextContent("Hola mundo!");

			documentExit.appendChild(rootElementExit);

			writeXml(documentExit, output);

		} catch (ParserConfigurationException xmlException) {
			xmlException.printStackTrace();
		} catch (SAXException xmlException) {
			xmlException.printStackTrace();
		} catch (TransformerException xmlException) { 
			xmlException.printStackTrace();
		} catch (IOException xmlException) {
			xmlException.printStackTrace();
		}

	}

	private static void writeXml(Document document, OutputStream output) throws TransformerException {

		// Create a new factory of documents builder
		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		// Create a new instrance of transformer
		Transformer transformer = transformerFactory.newTransformer();

		// This is the source information that it would be store ...
		DOMSource xmlAsObject = new DOMSource(document);

		// ... here, in the stream result
		StreamResult xmlAsFile = new StreamResult(output);

		// Transform objects to file
		transformer.transform(xmlAsObject, xmlAsFile);
	}

}
