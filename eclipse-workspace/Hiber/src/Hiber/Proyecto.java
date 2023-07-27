package Hiber;

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
}
