package Tema6_Ejercicio2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {
	public static File fichero = new File("archivo.bak");

	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			
			Element elClientes = doc.createElement("clientes");
			doc.appendChild(elClientes);
			
			Element elCliente = doc.createElement("cliente");
			elCliente.setAttribute("DNI", "89012344E");
			Element elApell = doc.createElement("apellidos");
			elApell.appendChild(doc.createTextNode("ROJAS"));
			elCliente.appendChild(elApell);
			Element elValidez = doc.createElement("validez");
			elValidez.setAttribute("estado", "borrado");
			elValidez.setAttribute("timestamp", "1528286082");
			elCliente.appendChild(elValidez);
			
			elClientes.appendChild(elCliente);
			
			DOMSource domSource = new DOMSource(doc);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			StringWriter sw = new StringWriter();
			StreamResult sr = new StreamResult(sw);
			transformer.transform(domSource,sr);
			System.out.println(sw.toString());
			
			// Busca el DNI y cambia los apellidos
			
			
			if (elCliente.getAttribute("DNI") == "89012344E") {
				elCliente.removeChild(elApell);
				Element elApell2 = doc.createElement("apellidos");
				elApell2.appendChild(doc.createTextNode("apellidoNuevo"));
				elCliente.appendChild(elApell2);
				elClientes.appendChild(elCliente);
				
				
				
				DOMSource domSource2 = new DOMSource(doc);
				Transformer transformer2 = TransformerFactory.newInstance().newTransformer();
				transformer2.setOutputProperty(OutputKeys.METHOD, "xml");
				transformer2.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				transformer2.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer2.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
				
				// Guarda la copia en un archivo .bak
				
				StringWriter sw2 = new StringWriter();
				StreamResult sr2 = new StreamResult(sw2);
				transformer2.transform(domSource2,sr2);
				System.out.println(sw2.toString());
				
				fichero = new File("archivo.bak");
				FileOutputStream fileout = new FileOutputStream(fichero, true);
				FileWriter pw = new FileWriter(fichero, true);
				
				pw.append(sw2.toString());
				
				pw.close();
				fileout.close();
			}
		} catch(ParserConfigurationException e) {
			System.err.println(e.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
