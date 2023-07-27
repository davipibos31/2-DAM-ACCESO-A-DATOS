package Tema2_Ejercicio2;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		int numero;
	    	try{
	        	numero = 'a';
	        	System.out.println("Todo ok ");
	    	} catch(NumberFormatException ex){
	        	System.out.println("Excepcion: " + ex.getMessage());
	    	} finally {
	            System.out.println("En Acceso a Datos, controlamos nuestro errores");
	    	}
	}
}