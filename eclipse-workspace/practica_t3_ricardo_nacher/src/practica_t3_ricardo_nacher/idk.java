public class idk {
	
	Connection conn1;
	
	public  void principal() {
		conn1=null;
		
		try {
			String url1="jdbc:mysql://localhost:3306/practica2";
			String user="root";
			String password="admin";
			conn1=DriverManager.getConnection(url1,user,password);
			if(conn1!=null) {
				System.out.println("conectado a practica2");
			}
		}catch(SQLException ex) {
			System.out.println("error: direccion no valida o usuario/clave");
			ex.printStackTrace();
		}
	}

	public void cerrarconexion() {

		try {
			conn1.close();
			System.out.println("conexion cerrada");
		}catch(SQLException ex) {
			System.out.println("error");
			ex.printStackTrace();
		}
	}
	
	public  void insertarlibro (String nombre, String cant,String editorial, String nPag, String anyoEdicion) {
		
		String values = String.format("VALUE ('%s','%s','%s','%s','%s');", nombre, cant, editorial, nPag, anyoEdicion);
		System.out.println(values);
		try {
			Statement sta=conn1.createStatement();
			//sta.executeUpdate("INSERT INTO libros " + "VALUE ('lord of the rings','3','editext','123132','2020');");
			sta.executeUpdate("INSERT INTO libros " + values);
			sta.close();
		}catch(SQLException ex) {
			System.out.println("error al hacer el insert");
			ex.printStackTrace();
		}
	}

	public void deletelibro() {
		try {
			Statement sta= conn1.createStatement();
			int count=sta.executeUpdate("delete from libros where titulo='draculas'");
		
		}catch(SQLException ex) {
			System.out.println("error al hacer el delete");
			ex.printStackTrace();
		}
	}
	/**
	 * Sirve para actualizar el titulo de un libro
	 * @param titulonuevo el titulo nuevo del libro
	 * @param tituloviejo el titulo viejo del libro
	 */

	public void actulizarlibro(String titulonuevo, String tituloviejo) {
		String query=String.format("update libros set titulo='%s' where titulo='%s'", titulonuevo, tituloviejo);

		try {
			
			Statement sta=conn1.createStatement();
			int count=sta.executeUpdate(query);
			
		}catch(SQLException ex) {
			System.out.println("error al consultar");
			ex.printStackTrace();
		}
	}

	public  void insertarsocio (String nombre, String apellido, String edad, String dir, String tlf) {
		String values = String.format("VALUE ('%s','%s','%s','%s','%s');", nombre, apellido, edad, dir, tlf);
		//System.out.println(values);
		try {
			Statement sta=conn1.createStatement();
			sta.executeUpdate("INSERT INTO socios " + values);
			sta.close();
		}catch(SQLException ex) {
			System.out.println("error al hacer el insert");
			ex.printStackTrace();
		}
	}

	public void deletesocio() {
		try {
			
			Statement sta= conn1.createStatement();
			int count=sta.executeUpdate("delete from socios where edad='23'");
		
		}catch(SQLException ex) {
			System.out.println("error al hacer el delete");
			ex.printStackTrace();
		}
	}
	
	public void actulizarsocio(String newNomb, String oldNom ) {
		String query = String.format("update socios set nombre='%s' where nombre='%s'", newNomb, oldNom);
		try {
			Statement sta=conn1.createStatement();
			int count=sta.executeUpdate(query);
		}catch(SQLException ex) {
			System.out.println("error al consultar");
			ex.printStackTrace();
		}
	}
	
	// public void consltaLibro(String autor)
	// public void consultaLibro(String titulo)
	public void consultaLibro(String tituloOautor, String busqueda) {
		
		try {
			if(tituloOautor.equals("titulo")) {
				String query = "SELECT * FROM  libros WHERE titulo like ?";
				PreparedStatement pst = conn1.prepareStatement(query);
				busqueda += "%";
				pst.setString(1, busqueda);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					System.out.println("Titulo:" + rs.getString("titulo")+  
					", Numero de ejemplares:" + rs.getString("numero de ejemplares")+
					",Editorial:" + rs.getString("editorial")+
					",Numero de paginas:"+ rs.getString("numero de paginas")+
					",Año de edicion:"+rs.getString("año de edicion") );
				}
				rs.close();
				pst.close();
			}
			else if(tituloOautor.equals("autor")) {
				String query = "SELECT * FROM  libros WHERE editorial like ?";
				PreparedStatement pst = conn1.prepareStatement(query);
				busqueda += "%";
				pst.setString(1, busqueda);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					System.out.println("Titulo:" + rs.getString("titulo")+  
					", Numero de ejemplares:" + rs.getString("numero de ejemplares")+
					",Editorial:" + rs.getString("editorial")+
					",Numero de paginas:"+ rs.getString("numero de paginas")+
					",Año de edicion:"+rs.getString("año de edicion") );
				}
				rs.close();
				pst.close();
			}
			
		}catch(SQLException ex) {
			
			System.out.println("erorr al realizar la consulta");
			ex.printStackTrace();
		}
	}

public void consultasocio(String nombreoapellido, String busqueda) {
		
		try {
			if(nombreoapellido.equals("nombre")) {
				String query = "SELECT * FROM  socios WHERE nombre like ?";
				PreparedStatement pst = conn1.prepareStatement(query);
				busqueda += "%";
				pst.setString(1, busqueda);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					System.out.println("Nombre:" + rs.getString("nombre")+  
							",Apellido:" + rs.getString("apellidos")+
							",Edad:" + rs.getString("Edad")+
							",Direccion:"+ rs.getString("direccion")+
							",Telefono::"+rs.getString("telefono") );
				}
				rs.close();
				pst.close();
			}
			else if(nombreoapellido.equals("apellido")) {
				String query = "SELECT * FROM  socios WHERE apellidos like ?";
				PreparedStatement pst = conn1.prepareStatement(query);
				busqueda += "%";
				pst.setString(1, busqueda);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					System.out.println("Nombre:" + rs.getString("nombre")+  
							",Apellido:" + rs.getString("apellidos")+
							",Edad:" + rs.getString("Edad")+
							",Direccion:"+ rs.getString("direccion")+
							",Telefono::"+rs.getString("telefono") ) ;
				}
				rs.close();
				pst.close();
			}
			
		}catch(SQLException ex) {
			System.out.println("erorr al realizar la consulta");
			ex.printStackTrace();
		}
	}
	
	
	public void consultalibros() {
		
		try {
			String query = "SELECT * FROM  libros";
			PreparedStatement pst = conn1.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println("Titulo:" + rs.getString("titulo")+  
				", Numero de ejemplares:" + rs.getString("numero de ejemplares")+
				",Editorial:" + rs.getString("editorial")+
				",Numero de paginas:"+ rs.getString("numero de paginas")+
				",Año de edicion:"+rs.getString("año de edicion") );
			}
			rs.close();
			pst.close();
		}catch(SQLException ex) {
			System.out.println("erorr al realizar la consulta");
			ex.printStackTrace();
		}
	}

	public void consultasocios() {
		
		try {
			//String query = "SELECT * FROM  socios WHERE nombre like ?";
			String query = "SELECT * FROM  socios";
			PreparedStatement pst = conn1.prepareStatement(query);
			//pst.setString(1, "R%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println("Nombre:" + rs.getString("nombre")+  
				",Apellido:" + rs.getString("apellidos")+
				",Edad:" + rs.getString("Edad")+
				",Direccion:"+ rs.getString("direccion")+
				",Telefono::"+rs.getString("telefono") );
			}
			rs.close();
			pst.close();
			
		}catch(SQLException ex) {
			System.out.println("erorr al realizar la consulta");
			ex.printStackTrace();
		}
	}

	public  void prestarlibro (String fechaini, String fechafin, String libros,String socio) {
	
		String values = String.format("(FECHA_INICIO, FECHA_FIN, libros_titulo, socio_nombre) VALUES ('%s','%s','%s','%s');", fechaini, fechafin, libros, socio);
		System.out.println(values);
		
		try {
			Statement sta=conn1.createStatement();
			sta.executeUpdate("INSERT INTO prestamo " + values);
			
			sta.close();
		}catch(SQLException ex) {
			System.out.println("error al hacer el insert");
			ex.printStackTrace();
		}
	}
}