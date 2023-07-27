package Practica_Tema_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

@SuppressWarnings("unused")
public class GestorProyectos {
	Connection conn1;
	
	public void conectar2() {
	
		try {
			String url1="jdbc:mysql://localhost:3306/practica3";
			String user="root";
			String password="root";
			conn1=DriverManager.getConnection(url1,user, password);
		}catch(SQLException ex) {
			System.out.println("error al conectar a la base de datos");
		}
	}

	public boolean nuevoEmpleado(String dni, String nombre)  throws SQLException  {

		boolean creado=true;

		String values=String.format("value ('%s','%s');", dni,nombre);
		System.out.println(values);

		try {
			Statement sta=conn1.createStatement();
			sta.executeUpdate("Insert into empleados "+ values);
			sta.close();

		}catch(SQLException ex) {
			creado=false;
			System.out.println("error al hacer el insert");
			ex.printStackTrace();
		}
		return creado;
	}


	public int Insertarproyecto( String nombre, String nifjefe, String fecha_ini, String fecha_fin )  throws SQLException  {
		int res = 0;

		if(fecha_ini == null) {
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			fecha_ini = dateFormat.format(now);
		}

		String values = String.format("(NOMBRE, DNI_NIF_JEFE_PROY, F_INICIO, F_FIN) VALUES ('%s','%s','%s', ?);", nombre,nifjefe,fecha_ini);

		String query = "insert into proyectos"+ values;

		try {
			PreparedStatement stmt = conn1.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			if(fecha_fin == null) {
				stmt.setNull(1, java.sql.Types.DATE);
			} else {
				stmt.setString(1, fecha_fin);
			}
			stmt.executeUpdate();
			ResultSet results = stmt.getGeneratedKeys();
			results.next();
			res = results.getInt(1); // el ID, es decir, el autoincremento
			stmt.close();

		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}

	public void AsignarEmpleado(String DNI_NIF_EMP, int NUM_PROY,String F_INICIO,String F_FIN ) throws SQLException {

		if(F_INICIO==null) {
			DateTimeFormatter datefor=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now=LocalDateTime.now();

			F_INICIO=datefor.format(now);
		}

		String values=String.format("(DNI_NIF_EMP,NUM_PROY,F_INICIO ,F_FIN) VALUES ('%s','%s','%s', ?);",DNI_NIF_EMP, NUM_PROY,F_INICIO,F_FIN);


		String query = "insert into asig_proyectos"+ values;
		PreparedStatement stmt=conn1.prepareStatement(query);
		if(F_FIN==null) {

			stmt.setNull(1,java.sql.Types.DATE);
		}else {

			stmt.setString(1, F_FIN);
		}

		stmt.executeUpdate();

	}
}