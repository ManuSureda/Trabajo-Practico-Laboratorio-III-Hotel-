package interfaces;

import java.io.IOException;

public interface IArchivar {
	
	void escribirArchivoHabitaciones() throws IOException;
	void escribirArchivoReservas() throws IOException;
	void escribirArchivoUsuario() throws IOException;
}
