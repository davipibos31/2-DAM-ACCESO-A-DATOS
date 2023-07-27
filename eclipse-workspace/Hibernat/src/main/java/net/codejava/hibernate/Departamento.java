package net.codejava.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //La opción más usada con MySQL
	@Column(name="id_depto")
	private int id_depto;

	public int getId_depto() {
		return id_depto;
	}

	public void setId_depto(int id_depto) {
		this.id_depto = id_depto;
	}

	public String getNom_depto() {
		return nom_depto;
	}

	public void setNom_depto(String nom_depto) {
		this.nom_depto = nom_depto;
	}

	public String getId_sede() {
		return id_sede;
	}

	public void setId_sede(String id_sede) {
		this.id_sede = id_sede;
	}

	@Column(name="nom_depto")
	private String nom_depto;

	@Column(name="id_sede")
	private String id_sede;
}