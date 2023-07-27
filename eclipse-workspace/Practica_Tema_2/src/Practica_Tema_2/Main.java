package Practica_Tema_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws IOException {
		menu();
	}
	public static String texto = "";
	public static Scanner sc2;
	public static int cont = 0;
	public static void menu() throws IOException {
		try {
			
			
			sc2 = new Scanner(System.in);

			do {
				System.out.println("\n Menu: \n"
						+ "Para añadir un campo introduzca:'a'\n"
						+ "para modificar un campo introduzca:'m'\n"
						+ "para recuperar un campo introduzca:'r'\n"
						+ "para generar estructura introduzca: 'g'\n"
						+ "para borrar un registro introduzca: 'b'\n"
						+ "para ordenar el fichero introduzca 'o'\n"
						+ "para salir introduzca: '.'\n");
				
				texto = sc2.nextLine();
				switch(texto) {
				case "a":
					es();
					break;
				case "m":
					Modificar();
					break;
				case "r":
					leer();
					break;
				case "g":
					cont = 1;
					Estructura.genestructura();
					break;
				case "b":
					borrar();
					break;
				case "o":
					ordenar();
					break;
				}
			}while(!texto.equals("."));
			System.out.println("salio del programa");
		}catch(Exception ex) {
			System.out.println("error");
		}
	}
	
	
	public static void ordenar() throws IOException { //ejercicio 5
		File fin = new File("archivo.txt");
		File fout = new File("sorted.txt");
		FileInputStream fis = new FileInputStream(fin);
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedReader in = new BufferedReader(new InputStreamReader(fis));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

		String aLine;
		ArrayList<String> al = new ArrayList<String> ();


		int i = 0;
		while ((aLine = in.readLine()) != null) {
			//get the lines you want, here I don't want something starting with - or empty
			if (!aLine.trim().startsWith("-") && aLine.trim().length() > 0) {
				al.add(aLine);
				i++;
			}
		}

		Collections.sort(al);
		//output sorted content to a file
		for (String s : al) {
		    System.out.println(s);
		    out.write(s);
			out.newLine();
			out.write("-----------------------------------------");
			out.newLine();
		}

		in.close();
		out.close();
		
		
		
		File fin2 = new File("archivo2.txt");
		File fout2 = new File("sorted.txt");
		FileInputStream fis2 = new FileInputStream(fin2);
		FileOutputStream fos2 = new FileOutputStream(fout2);

		BufferedReader in2 = new BufferedReader(new InputStreamReader(fis2));
		BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(fos2));

		String aLine2;
		ArrayList<String> al2 = new ArrayList<String> ();


		int i2 = 0;
		while ((aLine2 = in2.readLine()) != null) {
			//get the lines you want, here I don't want something starting with - or empty
			if (!aLine2.trim().startsWith("-") && aLine2.trim().length() > 0) {
				al2.add(aLine2);
				i2++;
			}
		}

		Collections.sort(al2);
		//output sorted content to a file
		for (String s2 : al2) {
		    System.out.println(s2);
		    out2.write(s2);
			out2.newLine();
			out2.write("-----------------------------------------");
			out2.newLine();
		}

		in2.close();
		out2.close();
	}
	
	public static void borrar() throws IOException { // ejercicio 3
		String dni_clave = "";
		String campo_modificar = "";
		String nuevo_dat = "";
		String viejo = "";
		String fichAnt = "";
		String nuevo = "";
		String nuevo2 = "";
		
		@SuppressWarnings("resource")
		Scanner s2 = new Scanner(System.in);

		System.out.println("introduce un dni");
		dni_clave = s2.nextLine();
		System.out.println("¿Quieres eliminar? Introduce si o no");
		campo_modificar = s2.nextLine().toLowerCase();

		BufferedReader leer_fichero = new BufferedReader(new FileReader(fichero));
		
	
		while (leer_fichero.ready() != false) {
			String[] linea;

			linea = leer_fichero.readLine().split(" ");

			if (linea[0].equals("DNI:" + dni_clave)) {
				nuevo_dat = "*";
				viejo = linea[0] + " " + linea[1] + " " + linea[2];
				if (campo_modificar.equals("si")) {
					nuevo = nuevo_dat + viejo + "\n";
					nuevo2 = nuevo_dat + viejo + "\n";
				} else if (campo_modificar.equals("no")) {
					nuevo = viejo;
					nuevo2 = viejo + "\n";
				}
			}
		}
		
		
		leer_fichero.close();
		FileWriter file = new FileWriter(fichero, true);
		FileWriter file2 = new FileWriter(fichero2, true); // ejercicio 4
		file.write(nuevo);
		file.close();		
		
		
		file2.write(nuevo);
		file2.close();
	}
	
	public static void es() throws IOException { 
		if(cont == 1) {
			Estructura.escribirfich(); // ejercicio 2
			
		}
		else if (cont == 0) {
			Escribir();
		}
	}
	
	public static void Modificar() throws IOException { //ejercicio 1
		String dni_clave = "";
		String campo_modificar = "";
		String nuevo_dat = "";
		String viejo = "";
		String fichAnt = "";
		String nuevo = "";
		
		@SuppressWarnings("resource")
		Scanner s2 = new Scanner(System.in);

		System.out.println("introduce un dni");
		dni_clave = s2.nextLine();
		System.out.println("introduce el campo a modificar");
		campo_modificar = s2.nextLine().toLowerCase();

		BufferedReader leer_fichero = new BufferedReader(new FileReader(fichero));

		while (leer_fichero.ready() != false) {
			String[] linea;

			linea = leer_fichero.readLine().split(" ");

			if (linea[0].equals("DNI:" + dni_clave)) {
				System.out.println("intro nuevo  dato");
				nuevo_dat = s2.nextLine();
				viejo = linea[0] + " " + linea[1] + " " + linea[2];

				if (campo_modificar.equals("dni")) {
					nuevo = "DNI:" + nuevo_dat + " " + linea[1] + " " + linea[2] + "\n";
					
				} else if (campo_modificar.equals("nombre")) {
					nuevo = linea[0] + " " + "NOMBRE:" + nuevo_dat + " " + linea[2] + "\n";
				} else if (campo_modificar.equals("apellido")) {
					nuevo = linea[0] + " " + linea[1] + " " + "APELLIDO:" + nuevo_dat + "\n";
				}
			}
		}
		
		leer_fichero.close();
		FileWriter file = new FileWriter(fichero, true);
		
		file.write(nuevo);
		file.close();
	}
	public static File fichero2 = new File("archivo2.txt");
	public static File fichero = new File("archivo.txt");
	
	public static void Escribir() throws IOException { // ejercicio 1
		Persona persona;

		String dni = "";
		String nombre = "";
		String apellido = "";

		fichero = new File("archivo.txt");
		FileOutputStream fileout = new FileOutputStream(fichero, true);
		FileWriter pw = new FileWriter(fichero, true);
		ArrayList<Persona> lista = new ArrayList<Persona>();

		System.out.println("introduce el dni");
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		dni = scn.nextLine();

		System.out.println("introduce el nombre");
		@SuppressWarnings("resource")
		Scanner nm = new Scanner(System.in);
		nombre = nm.nextLine();

		System.out.println("introduce el apellido");
		@SuppressWarnings("resource")
		Scanner ap = new Scanner(System.in);
		apellido = ap.nextLine();
	
		persona = new Persona(dni, nombre, apellido);

		lista.add(0, persona);

		pw.write("DNI:"+ dni + " Nombre:" + nombre + " apellido:" + apellido + "\n");
		pw.close();
		fileout.close();
	}

	public static void leer() throws FileNotFoundException { // ejercicio 1
		Persona persona;
		String dni_clve = "";
		System.out.println("elige el dni:");
		@SuppressWarnings("resource")
		Scanner s2 = new Scanner(System.in);
		dni_clve = s2.nextLine();

		@SuppressWarnings("resource")
		BufferedReader leer_fichero = new BufferedReader(new FileReader(fichero));

		try {
			while (leer_fichero.ready()) {
				String[] linea;

				linea = leer_fichero.readLine().split(" ");

				if (linea[0].equals("DNI:" + dni_clve)) {

					System.out.println(linea[0] + " " + linea[1] + " " + linea[2]);
				}
			}
		} catch (Exception e) {				
			System.out.println("Error: " + e);
		}
	}
}