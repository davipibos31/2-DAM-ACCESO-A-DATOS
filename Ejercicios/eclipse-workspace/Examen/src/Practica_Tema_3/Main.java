package Practica_Tema_3;


import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		Principal c1 = new Principal();
		
		c1.principal();
		//constructor.pedirTabla();																				//Ejercicio 1 y 2
		//constructor.insertardatos("123", "david", "111");
		
		GestorProyectos c2 = new GestorProyectos(); 
		c2.conectar2();
		//c2.nuevoEmpleado("12333","dad");
		
		//DateTimeFormatter datefor=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//LocalDateTime now=LocalDateTime.now();
																										
		//String F_INICIO = datefor.format(now);
		
		//c1.insertardatos("000000", "pepe", "02010");																//Ejercicio 3
		//String pattern = "yyyy-MM-dd";
		//SimpleDateFormat simpledateformat = new SimpleDateFormat(pattern);
		//c2.nuevoEmpleado("567", "dav");
		//int test = c2.Insertarproyecto("proyecto 3", "567", null, "2020-12-12");
		//System.out.println("El ID del proyecto es: " + test);
		
		//c2.Insertarproyecto("proyecto 1", "567", null, "2020-12-12");
		//c2.AsignarEmpleado("567", 11, "2022-12-14", "2020-12-12");
		
		Empleado e1 = new Empleado();
		Proyecto p1 = new Proyecto();
		AsignacionEmpAProyecto asg1 = new AsignacionEmpAProyecto();
		c2.conectar2();
		e1.setDni("3456");
		e1.setNombre("david22");
		//c2.nuevoEmpleado(e1.getDni(), e1.getNombre());
		
		p1.setNombre("proyecto 4");
		p1.setNifjefe("3456");																								//Ejercicio 4
		p1.setFecha_ini(null);
		p1.setFecha_fin("2020-12-12");
		//c2.Insertarproyecto(p1.getNombre(), p1.getNifjefe(), p1.getFecha_ini(), p1.getFecha_fin());
		
		asg1.setDNI_NIF_EMP("3456");
		asg1.setNUM_PROY(18);
		asg1.setF_INICIO("2022-12-14");
		asg1.setF_FIN("2020-12-12");
		//c2.AsignarEmpleado(asg1.getDNI_NIF_EMP(), asg1.getNUM_PROY(), asg1.getF_INICIO(), asg1.getF_FIN());
		
		
		p1.getListAsigEmpleados();																							//Ejercicio 5
		
		c1.menu();
	}
}
