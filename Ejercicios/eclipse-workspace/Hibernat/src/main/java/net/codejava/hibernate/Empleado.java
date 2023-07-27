package net.codejava.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //La opción más usada con MySQL
	@Column(name="dni")
	private int dni;

	@Column(name="nom_emp")
	private String nom_emp;

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNom_emp() {
		return nom_emp;
	}

	public void setNom_emp(String nom_emp) {
		this.nom_emp = nom_emp;
	}

	public String getId_depto() {
		return id_depto;
	}

	public void setId_depto(String id_depto) {
		this.id_depto = id_depto;
	}

	@Column(name="id_depto")
	private String id_depto;
}
