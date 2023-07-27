package Hiber;

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

	@Column(name="nom_depto")
	private String nom_depto;

	@Column(name="id_sede")
	private String id_sede;
}