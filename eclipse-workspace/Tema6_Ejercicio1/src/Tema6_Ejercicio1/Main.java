package Tema6_Ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Main {

	private static final String INDENT_NIVEL = "  ";
	public static File fichero = new File("archivo.txt");
	
	public static void main(String[] args) {
		String nomFich;
		if (args.length < 1) {
			System.out.println("indicar por favor nombre de fichero");
			return;
		} else {
			nomFich = args[0];
		}
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringComments(true);
		dbf.setIgnoringElementContentWhitespace(true);
		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document domDoc = db.parse(new File(nomFich));
			muestraNodo(domDoc, 0, System.out);
			
		} catch (FileNotFoundException | SAXException | ParserConfigurationException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void muestraNodo(Node nodo, int nivel, PrintStream ps) throws IOException {
		if (nodo.getNodeType() == Node.TEXT_NODE) {
			String text = nodo.getNodeValue();
			if (text.trim().length() == 0) {
				return;
			}
		}
		
		String str = "";
		String str2 = "";
		
		fichero = new File("archivo.txt");
		FileOutputStream fileout = new FileOutputStream(fichero, true);
		FileWriter pw = new FileWriter(fichero, true);
		
		for (int i = 0; i < nivel; i++) {
			str = INDENT_NIVEL;
			//str2 = INDENT_NIVEL;
			ps.print(INDENT_NIVEL);
			//pw.write(INDENT_NIVEL);
		}
		
		switch (nodo.getNodeType()) {
			case Node.DOCUMENT_NODE:
				Document doc = (Document) nodo;
				str = str + "\nDocumento DOM, Versión: " + doc.getXmlVersion() + ", codificación: " + doc.getXmlEncoding();
				str2 = "\nDocumento DOM, Versión: " + doc.getXmlVersion() + ", codificación: " + doc.getXmlEncoding();
				ps.println("\nDocumento DOM, Versión: " + doc.getXmlVersion() + ", codificación: " + doc.getXmlEncoding());
				//pw.append("\nDocumento DOM, Versión: " + doc.getXmlVersion() + ", codificación: " + doc.getXmlEncoding());
			break;
			case Node.ELEMENT_NODE:
				str = str + "<" + nodo.getNodeName();
				str2 = "<" + nodo.getNodeName();
				ps.print("<" + nodo.getNodeName());
				//pw.append("\n<" + nodo.getNodeName());
				NamedNodeMap listaAtr = nodo.getAttributes();
				for (int i = 0; i < listaAtr.getLength(); i++) {
					Node atr = listaAtr.item(i);
					str = str + " @" + atr.getNodeName() + "[" + atr.getNodeValue() + "]";
					str2 = " @" + atr.getNodeName() + "[" + atr.getNodeValue() + "]";
					ps.print(" @" + atr.getNodeName() + "[" + atr.getNodeValue() + "]");
					//pw.append(" @" + atr.getNodeName() + "[" + atr.getNodeValue() + "]");
				}
				str = str + ">";
				str2 = ">";
				ps.print(">");
				//pw.append(">");
			break;
			case Node.TEXT_NODE:
				str = str + nodo.getNodeName() + "[" + nodo.getNodeValue() + "]";
				str2 = nodo.getNodeName() + "[" + nodo.getNodeValue() + "]";
				ps.println(nodo.getNodeName() + "[" + nodo.getNodeValue() + "]");
				//pw.append("\n" + nodo.getNodeName() + "[" + nodo.getNodeValue() + "]");
			break;
			default:
				ps.println("(nodo de tipo: " + nodo.getNodeType() + "]");
				str = str + "(nodo de tipo: " + nodo.getNodeType() + "]";
				str2 = "(nodo de tipo: " + nodo.getNodeType() + "]";
				//pw.append("(nodo de tipo: " + nodo.getNodeType() + "]");
		}
		
		NodeList nodosHijos = nodo.getChildNodes();
		for (int i = 0; i < nodosHijos.getLength(); i++) {
			muestraNodo(nodosHijos.item(i), nivel + 1, ps);
		}
		String strSinEspacios = str.replaceAll("  ","\n");
		//String[] st = strSinEspacios.split("\n");
				
				pw.write(strSinEspacios);
		
		for (int index = 0; index <= str.length(); index++)
		{
			//pw.write(st[index]);
		    //System.out.println(st[index]);
		}
		
		
		//pw.write(entero);
		pw.close();
		fileout.close();
	}
}