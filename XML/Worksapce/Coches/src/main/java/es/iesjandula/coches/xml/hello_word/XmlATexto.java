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

public class XmlATexto 
{
	public static void main(String[] args) 
	{
		// Create a new factory of documents builder
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			
		try 
		{

			// Create a new instance of document builder
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	
			// Parse and store the XML in the instance of Document
			Document document = documentBuilder.parse(new File("entrada_alumnos.xml"));
			
			Document document2 = documentBuilder.newDocument();
			FileOutputStream output = new FileOutputStream("salida-alumnos.txt");
	
			// This rootElement is ... alumnos
				
			Element rootElement = document.getDocumentElement();
				
				
				
			
			// Get the list of "alumno"
			NodeList nodeListAlumnos = rootElement.getElementsByTagName("alumno");
			
			String textoFinal = "";
			
			Alumno[] alumnos = new Alumno[nodeListAlumnos.getLength()];
			
			for (int i = 0; i < nodeListAlumnos.getLength(); i++) {
				// Get the first element of the list
				Element nodeAlumno = (Element) nodeListAlumnos.item(i);

				// Get text from node values
				String nombre = String.valueOf(nodeAlumno.getAttributes().getNamedItem("nombre").getTextContent());
				int edad = Integer.valueOf(nodeAlumno.getAttributes().getNamedItem("edad").getTextContent());
				Double calificacion = Double
						.valueOf(nodeAlumno.getElementsByTagName("calificacion").item(0).getTextContent());
				boolean unidadesPendientes = Boolean
						.parseBoolean(nodeAlumno.getElementsByTagName("unidadesPendientes").item(0).getTextContent());
				alumnos[i] = new Alumno(nombre, edad, calificacion, unidadesPendientes);
				System.out.println("nombre: " + nombre + ", edad: " + edad + ", calificacion: " + calificacion
						+ ", unidadesPendientes" + unidadesPendientes);
				textoFinal += ("nombre: " + nombre + ", edad: " + edad + ", calificacion: " + calificacion
						+ ", unidadesPendientes" + unidadesPendientes + "\n");

			}
			
			/*for (int i = 0; i < alumnos.length; i++) 
			{

				for (int j = i + 1; j < alumnos.length; j++) 
				{

					if (alumnos[i].getNombre().compareTo(alumnos[j].getNombre()) > 0) 
					{

						Alumno temp = alumnos[i];
						alumnos[i] = alumnos[j];
						alumnos[j] = temp;
					}
				}
			}*/
			Arrays.sort(alumnos);
			for (int i = 0; i < alumnos.length; i++) {
				if (!alumnos[i].isAsignaturasPendientes()) {
					textoFinal += alumnos[i].toString() + "\n";
				}
			}
			Alumno alumnoNullMax= new Alumno("nombre", 0,Integer.MIN_VALUE,false);
			Alumno alumnoNullMin= new Alumno("nombre", 0,Integer.MAX_VALUE,false);
			Alumno alumMax = alumnoNullMax;
			Alumno alumMin = alumnoNullMin;
			int sumaAlum = 0;
			double mediaEdad = 0;
			double sumaCalificaciones=0;
			double mediaCalificaciones = 0;
			for(int i=0; i<alumnos.length; i++) {
				
				
				
				if(alumnos[i].getCalificacion()<alumMin.getCalificacion()) {
					alumMin=alumnos[i];
				}
				if(alumnos[i].getCalificacion()>alumMax.getCalificacion()) {
					alumMax=alumnos[i];
				}
				
				sumaAlum+= alumnos[i].getEdad();
				mediaEdad = sumaAlum / alumnos.length;
			
				sumaCalificaciones+=alumnos[i].getCalificacion();
				mediaCalificaciones= sumaCalificaciones/alumnos.length;
			}
			textoFinal += "-----Datos Alumnos-----" + "\n" ;
			textoFinal+= "El alumno con la mayor nota es: " + alumMax.getNombre() + " con nota: " + alumMax.getCalificacion() + "\n" 
			+ "El alumno con la menor nota es: " + alumMin.getNombre() + " con nota: " + alumMin.getCalificacion() + "\n";
			textoFinal+= "La media de edad de los alumnos es: " + mediaEdad+ "\n";
			textoFinal+= "La media de calificaciones de los alumnos es: " + mediaCalificaciones + "\n";
			
			
			
			Element rootElement2 = document2.createElement("mi_etiqueta_raíz");

			rootElement2.setTextContent(textoFinal);

			document2.appendChild(rootElement2);

			writeXml(document2, output);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeXml(Document document, OutputStream output) throws TransformerException {

		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		Transformer transformer = transformerFactory.newTransformer();

		DOMSource xmlAsObject = new DOMSource(document);

		StreamResult xmlAsFile = new StreamResult(output);

		transformer.transform(xmlAsObject, xmlAsFile);
	}
}
