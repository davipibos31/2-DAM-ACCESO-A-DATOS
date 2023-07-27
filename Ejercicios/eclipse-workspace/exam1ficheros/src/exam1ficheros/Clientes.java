package exam1ficheros;

public class Clientes {
	
	public String DNI;
	public String nombre;
	public String apellidos;
	
	public Clientes(String dNI, String nombre, String apellidos) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public Clientes() {
		super();
	}
	
	public String getDNI() {
		return DNI;
	}
	
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}