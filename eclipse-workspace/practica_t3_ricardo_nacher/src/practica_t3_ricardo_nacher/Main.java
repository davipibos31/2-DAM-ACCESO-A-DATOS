import java.util.Date;

public class Main {

	public static void main(String[] args) {
			idk constructor= new idk();
			constructor.principal();
			//constructor.insertarlibro("IT", "2", "editox", "123456", "1900");
			//constructor.deletelibro();
			//constructor.actulizarlibro("dracula", "draculas");
			//constructor.insertarsocio("pepe", "pepe", "23", "doctor ust", "34245563456");
			//constructor.deletesocio();
			//constructor.actulizarsocio("ALEX", "alex");
			//constructor.consultasocios();
			//constructor.consultasocio("apellido","n");
			//constructor.consultaLibro("autor", "editox");
			//constructor.consultalibros();
			constructor.prestarlibro("2021-12-07", "2021-01-10", "dracula", "Ricardo");
			constructor.cerrarconexion();
		}
}
