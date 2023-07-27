package Tema2_Ejercicio4;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) throws IOException {
		 File fichero = new File ("AleatorioEmple.dat");
		 //declara el fichero de acceso aleatorio
		 RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		 //arrays con los datos
		 String apellido[] = {"FERNANDEZ","GIL","LOPEZ","RAMOS",
		 "SEVILLA","CASILLA", "REY"};//apellidos
		 int dep[] = {10, 20, 10, 10, 30, 30, 20}; //departamentos
		 Double salario[]={1000.45, 2400.60, 3000.0, 1500.56,
		 2200.0, 1435.87, 2000.0};//salarios

		 StringBuffer buffer = null;//buffer para almacenar apellido
		 int n=apellido.length;//numero de elementos del array

		 for (int i=0;i<n; i++){ //recorro los arrays
			 file.writeInt(i+1); //uso i+1 para identificar empleado
			 buffer = new StringBuffer( apellido[i] );
			 buffer.setLength(10); //10 caracteres para el apellido
			 file.writeChars(buffer.toString());//insertar apellido
			 file.writeInt(dep[i]); //insertar departamento
			 file.writeDouble(salario[i]);//insertar salario
		 }
		 file.close(); //cerrar fichero
		 
		 
		 leerficheros();
	}
	
	public static void leerficheros() throws IOException {
		File fichero = new File ("AleatorioEmple.dat");
				 //declara el fichero de acceso aleatorio
				 RandomAccessFile file = new RandomAccessFile(fichero, "r");
				 //
				 int id, dep, posicion;
				 Double salario;
				 char apellido[] = new char[10], aux;
				 posicion = 0; //para situarnos al principio
				 while (file.getFilePointer() != file.length()) {
				 file.seek(posicion); //nos posicionamos en posicion
				 id = file.readInt(); // obtengo id de empleado

				 //recorro uno a uno los caracteres del apellido
				 for (int i = 0; i < apellido.length; i++) {
				 aux = file.readChar();
				 apellido[i] = aux; //los voy guardando en el array
				 }
				 //convierto a String el array
				 String apellidos = new String(apellido);
				 dep = file.readInt(); //obtengo dep
				 salario = file.readDouble(); //obtengo salario

				 if(id >0)
				 System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f%n",
				 id, apellidos.trim(), dep, salario);

				 //me posiciono para el sig empleado, cada empleado ocupa 36 bytes
				 posicion= posicion + 36;

				 }//fin bucle while

				 file.close(); //cerrar fichero
				 }
	}