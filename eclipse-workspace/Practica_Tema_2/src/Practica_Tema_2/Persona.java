package Practica_Tema_2;

public class Persona {

	public String DNI;
	public String nombre;
	public String apellidos;
	
	
	public Persona(String dNI, String nombre, String apellidos) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	} 
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}
	
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}