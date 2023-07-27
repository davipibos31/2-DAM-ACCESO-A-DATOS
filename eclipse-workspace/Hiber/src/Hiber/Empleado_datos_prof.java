package Hiber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleado_datos_prof")
public class Empleado_datos_prof {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //La opción más usada con MySQL
	@Column(name="dni")
	private int dni;

	@Column(name="categoria")
	private String categoria;

	@Column(name="sueldo_bruto_anual")
	private String sueldo_bruto_anual;
}