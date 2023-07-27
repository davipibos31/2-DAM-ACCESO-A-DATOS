package Hiber;

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

	@Column(name="id_depto")
	private String id_depto;
}
