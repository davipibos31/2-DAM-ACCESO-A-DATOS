package net.codejava.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sede")
public class Sede {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //La opción más usada con MySQL
	@Column(name="id_sede")
	private int id_sede;

	@Column(name="nom_sede")
	private String nom_sede;

	public int getId_sede() {
		return id_sede;
	}

	public void setId_sede(int id_sede) {
		this.id_sede = id_sede;
	}

	public String getNom_sede() {
		return nom_sede;
	}

	public void setNom_sede(String nom_sede) {
		this.nom_sede = nom_sede;
	}
	
}