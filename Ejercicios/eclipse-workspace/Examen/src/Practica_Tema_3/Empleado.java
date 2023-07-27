package Practica_Tema_3;

public class Empleado {

	String nombre = "";
	String dni = "";
	
	public Empleado() {
		super();
	}

	public Empleado(String dni) {
		super();
		this.dni = dni;
	}

	public Empleado(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}