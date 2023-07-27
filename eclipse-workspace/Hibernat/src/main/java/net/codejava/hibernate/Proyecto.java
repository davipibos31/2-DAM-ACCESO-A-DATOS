package net.codejava.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proyecto")
public class Proyecto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //La opción más usada con MySQL
	@Column(name="id_proy")
	private int id_proy;

	@Column(name="f_inicio")
	private String f_inicio;

	@Column(name="f_fin")
	private String f_fin;

	@Column(name="nom_proy")
	private String nom_proy;

	public int getId_proy() {
		return id_proy;
	}

	public void setId_proy(int id_proy) {
		this.id_proy = id_proy;
	}

	public String getF_inicio() {
		return f_inicio;
	}

	public void setF_inicio(String f_inicio) {
		this.f_inicio = f_inicio;
	}

	public String getF_fin() {
		return f_fin;
	}

	public void setF_fin(String f_fin) {
		this.f_fin = f_fin;
	}

	public String getNom_proy() {
		return nom_proy;
	}

	public void setNom_proy(String nom_proy) {
		this.nom_proy = nom_proy;
	}
	
}
