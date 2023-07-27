package Practica_Tema_3;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		Principal c1 = new Principal();
		
		c1.principal();
		//constructor.pedirTabla();
		//constructor.insertardatos("123", "david", "111");
		
		GestorProyectos c2 = new GestorProyectos(); 
		c2.conectar2();
		//c2.nuevoEmpleado("12333","dad");
		
		//DateTimeFormatter datefor=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//LocalDateTime now=LocalDateTime.now();

		//String F_INICIO = datefor.format(now);
		
		//c1.insertardatos("000000", "pepe", "02010");
		//String pattern = "yyyy-MM-dd";
		//SimpleDateFormat simpledateformat = new SimpleDateFormat(pattern);
		//c2.nuevoEmpleado("567", "dav");
		//int test = c2.Insertarproyecto("proyecto 3", "567", null, "2020-12-12");
		//System.out.println("El ID del proyecto es: " + test);
		
		//c2.Insertarproyecto("proyecto 1", "567", null, "2020-12-12");
		//c2.AsignarEmpleado("567", 11, "2022-12-14", "2020-12-12");
		c1.menu();
	}

}
