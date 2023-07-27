package exam1ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		menu();
	}
	
	public static String texto = "";
	public static Scanner sc2;
	public static int cont = 0;
	public static File fichero = new File("archivo.txt");
	
	public static void menu() throws IOException {
		try {
			
			
			sc2 = new Scanner(System.in);

			do {
				System.out.println("\n Menu: \n"
						+ "Para añadir un campo introduzca:'a'\n"
						+ "para modificar un campo introduzca:'m'\n"
						+ "para recuperar un campo introduzca:'r'\n"
						+ "para borrar un registro introduzca: 'b'\n"
						+ "para salir introduzca: '.'\n");
				
				texto = sc2.nextLine();
				switch(texto) {
				case "a":
					Escribir();
					break;
				case "m":
					Modificar();
					break;
				case "r":
					leer();
					break;
				case "b":
					borrar();
					break;
				}
			}while(!texto.equals("."));
			System.out.println("salio del programa");
		}catch(Exception ex) {
			System.out.println("error");
		}
	}
	
	@SuppressWarnings("unused")
	public static void borrar() throws IOException { 
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
		String[] linea = null;
		String[] linea2 = null;
		while (leer_fichero.ready() != false) {
			linea = leer_fichero.readLine().split(" ");
			linea2 = leer_fichero.readLine().split(" ");
		}
		leer_fichero.close();
		FileWriter file = new FileWriter(fichero, false);
		for (int i = 0; i < linea.length; i++)
		{
			file.write(linea[i].toString());
		}
		
		file.close();
		FileWriter file2 = new FileWriter(fichero, false);
		for (int i = 0; i < linea.length; i++)
		{
			file2.write(linea[i].toString() + " ");
			
		}
		file2.write("\n");
		file2.close();
	}
	
	@SuppressWarnings("unused")
	public static void Modificar() throws IOException {
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
	
	public static void Escribir() throws IOException {
		Clientes clientes;

		String dni = "";
		String nombre = "";
		String apellido = "";

		fichero = new File("archivo.txt");
		FileOutputStream fileout = new FileOutputStream(fichero, true);
		FileWriter pw = new FileWriter(fichero, true);
		ArrayList<Clientes> lista = new ArrayList<Clientes>();

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
	
		clientes = new Clientes(dni, nombre, apellido);

		lista.add(0, clientes);

		pw.write("DNI:"+ dni + " Nombre:" + nombre + " apellido:" + apellido + "\n");
		pw.close();
		fileout.close();
	}

	public static void leer() throws FileNotFoundException {
		@SuppressWarnings("unused")
		Clientes clientes;
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
