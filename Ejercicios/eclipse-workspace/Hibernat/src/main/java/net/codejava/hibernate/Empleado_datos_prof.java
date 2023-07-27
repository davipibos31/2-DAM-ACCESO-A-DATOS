package net.codejava.hibernate;

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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSueldo_bruto_anual() {
		return sueldo_bruto_anual;
	}

	public void setSueldo_bruto_anual(String sueldo_bruto_anual) {
		this.sueldo_bruto_anual = sueldo_bruto_anual;
	}

	@Column(name="sueldo_bruto_anual")
	private String sueldo_bruto_anual;
}