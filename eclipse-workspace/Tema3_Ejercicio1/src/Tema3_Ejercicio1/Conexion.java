package Tema3_Ejercicio1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Conexion {
	
	Connection conn1;
	
	public void conexion() {
		
		conn1 = null;

		try {
			String url1 = "jdbc:mysql://localhost:3306/ejercicio1";
			String user = "root";
			String password = "root";
			conn1 = DriverManager.getConnection(url1, user, password);

			if (conn1 != null)
				System.out.println("Conectado a ejercicio 1");
		} catch (SQLException ex) {
			System.out.println("Error al conectar a la base de datos");
		}
	}

	public void cerrarconexion() {
		try {
			conn1.close();
			System.out.println("conexion cerrada");
		} catch (SQLException ex) {
			System.out.println("error al cerrar conexion");
			ex.printStackTrace();
		}
	}
	
	public void creartabla() {
		try {
			String url1 = "jdbc:mysql://localhost:3306/ejercicio1";
			String user = "root";
			String password = "root";
			conn1 = DriverManager.getConnection(url1, user, password);
		
			Statement stm = conn1.createStatement();
				stm.execute("CREATE TABLE CLIENTES (DNI CHAR(9) NOT NULL," 
			+ " APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5)," 
			+ " PRIMARY KEY (DNI));");
				
				System.out.println("Tabla creado correctamente");
		} catch (SQLException ex) {
			System.out.println("Error al conectar a la base de datos");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	public void insertardatos() {
		try {
			String url1 = "jdbc:mysql://localhost:3306/ejercicio1";
			String user = "root";
			String password = "root";
			conn1 = DriverManager.getConnection(url1, user, password);
		
			Statement stm = conn1.createStatement();
				stm.executeUpdate("INSERT INTO CLIENTES (DNI,APELLIDOS,CP) VALUES " 
						+ "('78901234X', 'NADALES', '44126'),"
						+ "('89012345E', 'HOJAS', null),"
						+ "('56789012B', 'SAMPER', '29730'),"
						+ "('09876543K', 'LAMIQUIZ', null);");
				
				stm.executeUpdate("DELETE FROM CLIENTES WHERE DNI = '09876543K';");

				System.out.println("Filas insertadas correctamente");
		} catch (SQLException ex) {
			System.out.println("Error al conectar a la base de datos");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	public void consultasclientes() {
		try {
			String url1 = "jdbc:mysql://localhost:3306/ejercicio1";
			String user = "root";
			String password = "root";
			conn1 = DriverManager.getConnection(url1, user, password);
		
			Statement stm = conn1.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM CLIENTES");
			
			 int i = 1;
			while (rs.next() ) {
				System.out.println("[" + (i++) + "]");
				System.out.println("DNI: " + rs.getString("DNI"));
				System.out.println("APELLIDOS: " + rs.getString("APELLIDOS"));
				System.out.println("CP: " + rs.getString("CP"));
			}
			rs = stm.executeQuery("SELECT * FROM CLIENTES WHERE DNI='78901234X'");
			
			i = 1;
			while (rs.next()) {
				System.out.println("DNI: " + rs.getString("DNI"));
				System.out.println("APELLIDOS: " + rs.getString("APELLIDOS"));
				System.out.println("CP: " + rs.getString("CP"));
				System.out.println();
			}
			rs = stm.executeQuery("SELECT * FROM CLIENTES WHERE DNI='89012345E'");
			i = 1;
			while (rs.next()) {
				System.out.println("DNI: " + rs.getString("DNI"));
				System.out.println("APELLIDOS: " + rs.getString("APELLIDOS"));
				System.out.println("CP: " + rs.getString("CP"));
				System.out.println();
			}
			rs = stm.executeQuery("SELECT * FROM CLIENTES WHERE DNI='56789012B'");
			i = 1;
			while (rs.next()) {
				System.out.println("DNI: " + rs.getString("DNI"));
				System.out.println("APELLIDOS: " + rs.getString("APELLIDOS"));
				System.out.println("CP: " + rs.getString("CP"));
				System.out.println();
			}
			
		} catch (SQLException ex) {
			System.out.println("Error al conectar a la base de datos");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	public void transacciones() {
		try {
			String url1 = "jdbc:mysql://localhost:3306/ejercicio1";
			String user = "root";
			String password = "root";
			conn1 = DriverManager.getConnection(url1, user, password);
		
			PreparedStatement sInsert = conn1.prepareStatement("INSERT INTO "
					+ "CLIENTES (DNI,APELLIDOS,CP) VALUES (?,?,?);");
			conn1.setAutoCommit(false);
			
			int i = 0;
			sInsert.setString(++i, "54320198V");
			sInsert.setString(++i, "CARVAJAL");
			sInsert.setString(++i, "10109");
			sInsert.executeUpdate();
			
			sInsert.setString(i = 1, "76543210S");
			sInsert.setString(++i, "MARQUEZ");
			sInsert.setString(++i, "46987");
			sInsert.executeUpdate();
			
			sInsert.setString(i = 1, "90123456A");
			sInsert.setString(++i, "MOLINA");
			sInsert.setString(++i, "35153");
			sInsert.executeUpdate();
			
			conn1.commit();
			
		} catch (SQLException ex) {
			System.out.println("Error al conectar a la base de datos");
			try {
				conn1.rollback();
			} catch(Exception er) {
				System.err.println("ERROR haciendo ROOLBACK");
				er.printStackTrace(System.err);
			}
		} catch (Exception e) {
			System.err.println("ERROR de conexión");
			e.printStackTrace(System.err);
		}
	}
	
	public void sintransacciones() {
		try {
			String url1 = "jdbc:mysql://localhost:3306/ejercicio1";
			String user = "root";
			String password = "root";
			conn1 = DriverManager.getConnection(url1, user, password);
		
			PreparedStatement sInsert = conn1.prepareStatement("INSERT INTO "
					+ "CLIENTES (DNI,APELLIDOS,CP) VALUES (?,?,?);");
			
			int i = 0;
			sInsert.setString(++i, "54320198V");
			sInsert.setString(++i, "CARVAJAL");
			sInsert.setString(++i, "10109");
			sInsert.executeUpdate();
			
			sInsert.setString(i = 1, "76543210S");
			sInsert.setString(++i, "MARQUEZ");
			sInsert.setString(++i, "46987");
			sInsert.executeUpdate();
			
			sInsert.setString(i = 1, "90123456A");
			sInsert.setString(++i, "MOLINA");
			sInsert.setString(++i, "35153");
			sInsert.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println("Error al conectar a la base de datos");
		} catch (Exception e) {
			System.err.println("ERROR de conexión");
			e.printStackTrace(System.err);
		}
	}
	
	public void funcionsacarapellidos() {
		try {
			String url1 = "jdbc:mysql://localhost:3306/ejercicio1";
			String user = "root";
			String password = "root";
			conn1 = DriverManager.getConnection(url1, user, password);
		
			CallableStatement calstm = conn1.prepareCall("{? = call funcionalmacenada(?)}");

			calstm.registerOutParameter(1, Types.VARCHAR);
			calstm.setString(2,"78901234X");
			calstm.execute();
			String resultado = calstm.getString(1);
			System.out.println(resultado);
			
		} catch (SQLException ex) {
			System.out.println("Error al conectar a la base de datos");
		} catch (Exception e) {
			System.err.println("ERROR de conexión");
			e.printStackTrace(System.err);
		}
	}
	
	public void proceduresacarapellidos() {
		try {
			String url1 = "jdbc:mysql://localhost:3306/ejercicio1";
			String user = "root";
			String password = "root";
			conn1 = DriverManager.getConnection(url1, user, password);
		
			CallableStatement calstm = conn1.prepareCall("{call sacarApellidos(?)}");

			
			calstm.setString(1,"78901234X");
			calstm.execute();

			ResultSet rs = calstm.getResultSet();
			
			int nCli = 0;
			while (rs.next()) {
				System.out.println("[" + (++nCli) + "]");
				System.out.println("APELLIDOS: " + rs.getString("APELLIDOS"));
			}
			
		} catch (SQLException ex) {
			System.out.println("Error al conectar a la base de datos");
		} catch (Exception e) {
			System.err.println("ERROR de conexión");
			e.printStackTrace(System.err);
		}
	}
}