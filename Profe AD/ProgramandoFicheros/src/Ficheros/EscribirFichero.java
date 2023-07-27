package Ficheros;
import java.io.*;
import java.util.*;
public class EscribirFichero {
	
	
	public static ArrayList<String> registros= new ArrayList<String>();
	public static ArrayList<String> registrosleidos= new ArrayList<String>();

	public static String registro="";
	public static String cadena="";
	static Scanner entrada=new Scanner(System.in);
	static int opcion;
	public static void main(String[] args) throws IOException {
		while(true) {
		 System.out.println("Introduce la opcion que desees:");
		 System.out.println("1 para modificar la estructura del registro");
		 System.out.println("2 para registrar nuevos registros");
		 System.out.println("3 para escribir el fichero");
		 System.out.println("4 para recuperar el fichero");
		 opcion=entrada.nextInt();
		switch(opcion)
		{
		case 1: ProgFich.genestructura();
				break;
		case 2: registrar();	
				break;
		case 3: escribirfich();
				break;
		case 4: recuperarfich();
		}
	}
}
       public static void escribirfich() throws IOException{
   
        File fichero = new File("C:\\Users\\alber\\OneDrive\\Escritorio\\LIBROS\\FPINFORMATICA\\IGFORMACION\\Acceso a Datos\\TEMA2\\Programandoficheros.dat");//declara fichero 
		FileWriter fic = new FileWriter(fichero); //crear el flujo de salida. Si existe borra lo que había FileWriter(fichero, true) 
		for (int x=0; x< registros.size(); x++) 
		{
			char[] cad = registros.get(x).toCharArray();//convierte la cadena del array de registros en array de caracteres
	 
			 for(int i=0; i<cad.length; i++)
			 fic.write(cad[i]); //se va escribiendo un carácter	
		}
		fic.close();  //cerrar fichero	 												
       }
       
       public static void registrar() throws IOException{
    	   StringBuffer sb= null; 
   		   System.out.println("Vamos a registrar datos");
    	   
   		   for (int x=0; x<ProgFich.numcampos; x++)
    	   {
   			   
    		   System.out.println("Introduce " + ProgFich.nomcampo.get(x)+ " SON " + ProgFich.tamcampo.get(x) + " caracteres");
   			   cadena=entrada.next();
    		   registro= registro+cadena;
    		   sb=new StringBuffer(registro);
    		   sb.setLength(ProgFich.lengthregistro/2);
    	   }
    	   registros.add(registro);
    	   registro="";
       }


       public static void recuperarfich() throws IOException{
	    	String[] [] celdas= new String[ProgFich.numcampos] [];
	    	int recorridoenr=0;//La uso para saber por donde voy leyendo del registro.
	    	ArrayList<String> registrosrecuperados = new ArrayList<String>();
	    	File fichero = new File("C:\\Users\\alber\\OneDrive\\Escritorio\\LIBROS\\FPINFORMATICA\\IGFORMACION\\Acceso a Datos\\TEMA2\\Programandoficheros.dat");//declara fichero 
	   		FileReader fr = new FileReader(fichero); //crear el flujo de salida. Si existe borra lo que había FileWriter(fichero, true) 
	   		BufferedReader br = new BufferedReader(new FileReader(fichero)); 
	   		//declara el fichero de acceso aleatorio
	   		RandomAccessFile file = new RandomAccessFile(fichero, "r");
	   		//
   		
   		
	   		long posicion; 
	   		char registrorecuperado[] = new char[ProgFich.lengthregistro];
	   		char aux; 
	   		posicion = 0; //para situarnos al principio
	   	 	while (file.getFilePointer() != file.length()) 
	   	 	{
	   	 		file.seek(posicion); //nos posicionamos en posicion (inicio del archivo)
	   	 		//recorro uno a uno los caracteres del registro
	   	 		for (int i = 0; i < ProgFich.lengthregistro; i++) 
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
	   	 		posicion= posicion + ProgFich.lengthregistro; 
	   	 
	   	 }//fin bucle while
	   	 for (int x=0; x < registrosrecuperados.size();x++)  
	     {
	    	 System.out.println(registrosrecuperados.get(x)); 
	     }
	   		fr.close();//cerrar fichero
       }
}
