package Practica_Tema_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Proyecto {
	String nombre = "";
	String nifjefe = "";
	String fecha_ini = "";
	String fecha_fin = "";
	
	public Proyecto() {
		super();
	}

	public Proyecto(String nifjefe) {
		super();
		this.nifjefe = nifjefe;
	}

	public Proyecto(String nombre, String nifjefe, String fecha_ini, String fecha_fin) {
		super();
		this.nombre = nombre;
		this.nifjefe = nifjefe;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNifjefe() {
		return nifjefe;
	}

	public void setNifjefe(String nifjefe) {
		this.nifjefe = nifjefe;
	}

	public String getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(String fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	public static List<AsignacionEmpAProyecto> list;
	
	AsignacionEmpAProyecto asg2 = new AsignacionEmpAProyecto();
	
	
	
	public void getListAsigEmpleados() throws SQLException {
		Connection conn1;
		
				String url1="jdbc:mysql://localhost:3306/practica3";
				String user="root";
				String password="root";
				conn1=DriverManager.getConnection(url1,user, password);
		
		
        
     // Preparamos la consulta
        Statement s = conn1.createStatement();
        ResultSet rs = s.executeQuery ("select * from asig_proyectos");

        ResultSetMetaData rsmd = null;

        rsmd = rs.getMetaData();
        int columnas = rsmd.getColumnCount();

            while(rs.next()){
				AsignacionEmpAProyecto row = new AsignacionEmpAProyecto();

                for(int i=1; i<=columnas;i++){
                    row.getDNI_NIF_EMP();
                    row.getNUM_PROY();
                    row.getF_INICIO();
                    row.getF_FIN();

                }

            }  

	}
}
