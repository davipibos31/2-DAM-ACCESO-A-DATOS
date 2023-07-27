package Practica_Tema_3;

public class AsignacionEmpAProyecto {

	String DNI_NIF_EMP = "";
	int NUM_PROY = 0;
	String F_INICIO = "";
	String F_FIN = "";
	
	public AsignacionEmpAProyecto() {
		super();
	}

	public AsignacionEmpAProyecto(int nUM_PROY) {
		super();
		NUM_PROY = nUM_PROY;
	}

	public AsignacionEmpAProyecto(String dNI_NIF_EMP, int nUM_PROY, String f_INICIO, String f_FIN) {
		super();
		DNI_NIF_EMP = dNI_NIF_EMP;
		NUM_PROY = nUM_PROY;
		F_INICIO = f_INICIO;
		F_FIN = f_FIN;
	}

	public String getDNI_NIF_EMP() {
		return DNI_NIF_EMP;
	}

	public void setDNI_NIF_EMP(String dNI_NIF_EMP) {
		DNI_NIF_EMP = dNI_NIF_EMP;
	}

	public int getNUM_PROY() {
		return NUM_PROY;
	}

	public void setNUM_PROY(int nUM_PROY) {
		NUM_PROY = nUM_PROY;
	}

	public String getF_INICIO() {
		return F_INICIO;
	}

	public void setF_INICIO(String f_INICIO) {
		F_INICIO = f_INICIO;
	}

	public String getF_FIN() {
		return F_FIN;
	}

	public void setF_FIN(String f_FIN) {
		F_FIN = f_FIN;
	}
	
	
}
