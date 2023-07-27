package Practica_Tema_2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Estructura {
	public static int numcampos;
	public static ArrayList<String> nomcampo = new ArrayList<String>();
	public static ArrayList<String> tamcampo = new ArrayList<String>();
	static String texto;
	public static int lengthregistro;
	
	
	public static void genestructura() 
	{
		lengthregistro=0;
		
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);	
		
		System.out.println("Introduce el número de campos de tu fichero: ");
		numcampos = input.nextInt();
		
		//Escribo la estructura de los campos
		for (int x = 0 ; x < numcampos; x++)
		{
			System.out.println("Nombre del Campo: " + (x + 1));
			texto= input.next();
			nomcampo.add(texto);
			System.out.println("Tamaño del Campo: " + (x+1));
			texto = input.next();
			tamcampo.add(texto);
			lengthregistro = lengthregistro + Integer.parseInt(tamcampo.get(x));
		}
		
		// Reviso la estructura de los campos.
		for (int x = 0 ; x < nomcampo.size(); x++)
		{
			System.out.println("El campo " + x + " tiene una extensión de " + tamcampo.get(x) + " y nombre " + nomcampo.get(x));	
		}
		System.out.println();
		System.out.println("Un registro tiene una extension de : " + (lengthregistro * 2) + " bytes");
		System.out.println();
	}
	
	public static ArrayList<String> registros= new ArrayList<String>();
	public static ArrayList<String> registrosleidos= new ArrayList<String>();

	public static String registro="";
	public static String cadena="";
	static Scanner entrada=new Scanner(System.in);
	static int opcion;
	public static File fichero = new File("archivo.txt");
	
    public static void escribirfich() throws IOException {
    	
    	fichero = new File("archivo.txt");
		FileOutputStream fileout = new FileOutputStream(fichero, true);
		FileWriter pw = new FileWriter(fichero, true);
    	
		for (int x = 0; x < registros.size(); x++) 
    	{
    		char[] cad = registros.get(x).toCharArray();//convierte la cadena del array de registros en array de caracteres
	 
    		for(int i=0; i < cad.length; i++)
    			pw.write(cad[i]); //se va escribiendo un car�cter	
    	}
    	pw.close();  //cerrar fichero
    	fileout.close();
     }
       
     public static void registrar() throws IOException {
    	 StringBuffer sb= null; 
   		 System.out.println("Vamos a registrar datos");
    	   
   		 for (int x=0; x<Estructura.numcampos; x++)
    	 { 
    		 System.out.println("Introduce " + Estructura.nomcampo.get(x)+ " SON " + Estructura.tamcampo.get(x) + " caracteres");
   			 cadena=entrada.next();
    		 registro= registro+cadena;
    		 sb=new StringBuffer(registro);
    		 sb.setLength(Estructura.lengthregistro/2);
    	 }
    	 registros.add(registro);
    	 registro="";
     }


     public static void recuperarfich() throws IOException{
    	 @SuppressWarnings("unused")
    	 String[] [] celdas= new String[Estructura.numcampos] [];
    	 
    	 @SuppressWarnings("unused")
    	 int recorridoenr=0;//La uso para saber por donde voy leyendo del registro.
    	 
    	 ArrayList<String> registrosrecuperados = new ArrayList<String>();
    	 File fichero = new File("C:\\Users\\alber\\OneDrive\\Escritorio\\LIBROS\\FPINFORMATICA\\IGFORMACION\\Acceso a Datos\\TEMA2\\Programandoficheros.dat");//declara fichero 
	   	 FileReader fr = new FileReader(fichero); //crear el flujo de salida. Si existe borra lo que hab�a FileWriter(fichero, true) 
	   	 
	   	 @SuppressWarnings({ "unused", "resource" })
	   	 BufferedReader br = new BufferedReader(new FileReader(fichero)); 
	   	 //declara el fichero de acceso aleatorio
	   	 @SuppressWarnings("resource")
	   	 RandomAccessFile file = new RandomAccessFile(fichero, "r");
   		
   		
	   		long posicion; 
	   		char registrorecuperado[] = new char[Estructura.lengthregistro];
	   		char aux; 
	   		posicion = 0; //para situarnos al principio
	   	 	while (file.getFilePointer() != file.length()) 
	   	 	{
	   	 		file.seek(posicion); //nos posicionamos en posicion (inicio del archivo)
	   	 		//recorro uno a uno los caracteres del registro
	   	 		for (int i = 0; i < Estructura.lengthregistro; i++) 
	   	 			{ 
	   	 			aux = (char)file.readByte(); 
	   	 			registrorecuperado[i] = aux; //los voy guardando en el array
	   	 			}
	   	 			//convierto a String el array registrorecuperado
	   	 		String r = new String(registrorecuperado);
	   	 		registrosrecuperados.add(r);
	   	 		//convierto a String los diferentes campos
	   	 		/*for(int x =0; x< ProgFich.numcampos; x++)
		   	 		{
		   	 		celdas[x]= new String[ProgFich.nomcampo.size()];
		   	 		for(int z=0; z<ProgFich.nomcampo.size(); z++)
		   	 			{
		   	 			celdas[x][z]= r.substring(recorridoenr,(recorridoenr+Integer.parseInt(ProgFich.tamcampo.get(z))));
		   	 			recorridoenr=recorridoenr+Integer.parseInt(ProgFich.tamcampo.get(z));
		   	 			}
		   	 		recorridoenr=0;
		   	 		}
	   	 		
	   	 		
	   	 		//Vamos a mostrar la matriz celdas para ver si recuperamos los datos
	   	 		
	   	 	   for(int x =0; x< ProgFich.numcampos; x++)
		 		{for(int z=0; z<ProgFich.nomcampo.size(); z++)
		 			{
		 			System.out.println(celdas[x][z]+ " ");
		 			}
		 		 System.out.println();	
		 		}
	   	 		//me posiciono para el sig registro, cada empleado ocupa */
	   	 		posicion= posicion + Estructura.lengthregistro; 
	   	 
	   	 }//fin bucle while
	   	 for (int x=0; x < registrosrecuperados.size();x++)  
	     {
	    	 System.out.println(registrosrecuperados.get(x)); 
	     }
	   		fr.close();//cerrar fichero
       }
}
