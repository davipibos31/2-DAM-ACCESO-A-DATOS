package Tema2_Ejercicio1;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
		String ruta = ".";
		String exc = "";
		String wrt = "";
		String rd = "";
		if (args.length >= 1)
			ruta = args[0];
		
		File fich = new File(ruta);
		
		if (!fich.exists())
			System.out.println("No existe el fichero o directorio ("+ruta+").");
		else {
			if (fich.isFile()) {
				System.out.println(ruta + "es un fichero.");
			} else {
				System.out.println(ruta + "/ es un directorio: ");
				File[] ficheros = fich.listFiles(); // Ojo ficheros o directorios
				for (File f : ficheros) {
					String textoDescr = f.isDirectory() ? "/": f.isFile() ? "_" : "?";
					
					if (f.canExecute()) {
						 exc = "x";
					} else {
						exc = "-";
					}
					if (f.canWrite()) {
						 wrt = "w";
					} else {
						wrt = "-";
					}
					if (f.canRead()) {
						 rd = "r";
					} else {
						rd = "-";
					}
					
					long ms = f.lastModified();
					Date d = new Date(ms);
					Calendar c = new GregorianCalendar();
					c.setTime(d);
					
					String dia = Integer.toString(c.get(Calendar.DATE));
					String mes = Integer.toString((c.get(Calendar.MONTH) + 1)) ;
					String annio = Integer.toString(c.get(Calendar.YEAR));
					String hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
					String minuto = Integer.toString(c.get(Calendar.MINUTE));
					String segundo = Integer.toString(c.get(Calendar.SECOND));
					
					System.out.println("(" + textoDescr + ") " + rd + wrt + exc +
							" " + dia + "/" + mes + "/" + annio + " " + hora + ":" + minuto + ":" + segundo + 
							" " + f.length() + " " + f.getName());
				}
			}
		}
	}
}
