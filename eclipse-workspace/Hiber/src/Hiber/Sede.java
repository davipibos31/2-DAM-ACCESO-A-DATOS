package Hiber;

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
}