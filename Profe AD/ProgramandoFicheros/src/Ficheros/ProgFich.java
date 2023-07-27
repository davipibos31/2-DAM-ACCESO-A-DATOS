package Ficheros;

import java.util.*;

public class ProgFich {
	public static int numcampos;
	public static ArrayList<String> nomcampo = new ArrayList<String>();
	public static ArrayList<String> tamcampo = new ArrayList<String>();
	static String texto;
	public static int lengthregistro;
	
	
	
	
	
	public static void genestructura() 
	{
		lengthregistro=0;
		Scanner input=new Scanner(System.in);	
		System.out.println("Dime el número de campos de tu fichero");
		numcampos= input.nextInt();
		//Escribo la estructura de los campos
		for (int x = 0 ; x<numcampos; x++)
		{
			System.out.println("Nombre del Campo " + (x+1));
			texto= input.next();
			nomcampo.add(texto);
			System.out.println("Tamaño del Campo " + (x+1));
			texto= input.next();
			tamcampo.add(texto);
			lengthregistro=lengthregistro+Integer.parseInt(tamcampo.get(x));
		}
		
		// Reviso la estructura de los campos.
		for (int x = 0 ; x<nomcampo.size(); x++)
		{
			System.out.println("el campo " + x + " tiene una extensión de " + tamcampo.get(x) + " y nombre " + nomcampo.get(x));	
		}
		System.out.println("un registro tiene una extension de : " +(lengthregistro*2)+ " bytes");
	}
	
	
}
