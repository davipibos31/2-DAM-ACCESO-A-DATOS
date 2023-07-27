package exam1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {

	Connection conn1;

	public void principal() {
		conn1 = null;

		try {
			String url1 = "jdbc:mysql://localhost:3306/examen1evaluacion";
			String user = "root";
			String password = "root";
			conn1 = DriverManager.getConnection(url1, user, password);

			if (conn1 != null) {
				System.out.println("conectado a examen 1º Evaluacion");
			}
		} catch (SQLException ex) {
			System.out.println("error al conectar a la base de datos");
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

	public void insertardatos(String dni, String apellidos,String cp ){
		String values=String.format("value ('%s','%s','%s');", dni,apellidos,cp);
		System.out.println(values);
		try {
		Statement sta=conn1.createStatement();
		sta.executeUpdate("Insert into clientes "+ values);
		sta.close();
		}catch(SQLException ex) {
		System.out.println("error al hacer el insert");
		ex.printStackTrace();
		}
	}

	public String pedirTabla() {
		System.out.println("Las tablas son clientes: ");
		System.out.println("Que tabla quieres: ");
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		//rs.next();
		String introletra=sc.nextLine();
		return introletra;
	}
	
	public void menu() {
		Boolean sig = false;
		Boolean ant = false;
		Boolean num = false;
		Integer pos = 0;
		
		try {
			Statement stmt = conn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String tabla = pedirTabla();
			String query =  "SELECT * FROM " + tabla;
			ResultSet rs = stmt.executeQuery(query);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String introletra = "";
			do {
				if (sig) {
					if (rs.next() != false) {
						System.out.print("Fila " + rs.getRow() + ": ");
						for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
							System.out.print(rs.getMetaData().getColumnName(i)+ ":" + rs.getString(i) + " ");}
					} else {
						System.out.println("No existe el siguiente numero");
					}
					sig = false;
				} else if (ant) {
					if (rs.previous() != false) {
						System.out.print("Fila " + rs.getRow() + ": ");
						for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
							System.out.print(rs.getMetaData().getColumnName(i)+ ":" + rs.getString(i) + " ");
							}
					} else {
						System.out.println("No existe el anterior numero");
					}
					ant = false;
				} else if (num) {
					if (rs.absolute(pos) != false) {
						System.out.print("Fila " + rs.getRow() + ": ");
						for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
							System.out.print(rs.getMetaData().getColumnName(i)+ ":" + rs.getString(i) + " ");
							}
					} else {
						System.out.println("No existe el indice del numero");
					}
					num = false;
				}
				System.out.println("\nPara avanzar pulse k, para el anterior pulse d, para ir al número de la fila puse el numero de la fila y para terminar pulse .");
				introletra = sc.nextLine();

				switch (introletra) {
					case "k":
						// rs.next();
						sig = true;
						ant = false;
						break;
					case "d":
						// rs.previous();
						ant = true;
						sig = false;
						break;
					default:
						if (introletra.matches("\\d+")) {
							pos = Integer.parseInt(introletra);
							num = true;
							sig = false;
							ant = false;
						}
						break;
					}
			} while (!introletra.equals("."));
			System.out.println("salio del programa");
		} catch (SQLException ex) {
			// System.out.println("comando incorrecto, posicion no existe");
			ex.printStackTrace();
		}
	}
}