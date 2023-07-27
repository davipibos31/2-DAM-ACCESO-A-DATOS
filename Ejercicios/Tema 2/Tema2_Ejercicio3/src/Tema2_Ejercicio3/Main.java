package Tema2_Ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
//import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) {
		
		
		String nomFich  = "fich.txt";
		
		try (BufferedReader fbr = new BufferedReader(new FileReader(nomFich))) {
			int i = 0;
			String linea = fbr.readLine();
			while (linea != null) {
				System.out.format("[%5d] %s", i++, nomFich);
				System.out.println();
				linea = fbr.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("No existe fichero " + nomFich);
		} catch (IOException e) {
			System.out.println("Error de E/S:  " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Scanner entrada = null;
        String linea;
        int numeroDeLinea = 1;
        boolean contiene = false;
        Scanner sc = new Scanner(System.in);

        //Para seleccionar el archivo
        //JFileChooser j = new JFileChooser();
        //j.showOpenDialog(j);

        //Introducimos el texto a buscar
        System.out.print("Introduce texto a buscar: ");
        String texto = sc.nextLine();

        try {
            //guardamos el path del fichero en la variable ruta
            //String ruta = j.getSelectedFile().getAbsolutePath();
            //creamos un objeto File asociado al fichero seleccionado
            File f = new File("fich.txt");
            //creamos un Scanner para leer el fichero
            entrada = new Scanner(f);
            //mostramos el nombre del fichero
            System.out.println("Archivo: " + f.getName());
            //mostramos el texto a buscar
            System.out.println("Texto a buscar: " + texto);
            while (entrada.hasNext()) { //mientras no se llegue al final del fichero
                linea = entrada.nextLine();  //se lee una línea
                if (linea.contains(texto)) {   //si la línea contiene el texto buscado se muestra por pantalla         
                    System.out.println("Linea " + numeroDeLinea + ": " + linea);
                    contiene = true;
                }
                numeroDeLinea++; //se incrementa el contador de líneas
            }
            if(!contiene){ //si el archivo no contienen el texto se muestra un mensaje indicándolo

                System.out.println(texto + " no se ha encontrado en el archivo");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println(e.toString() + "No ha seleccionado ningún archivo");
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
	}

}
