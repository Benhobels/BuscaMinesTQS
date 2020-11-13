package Controlador;

import Modelo.GeneradorTablero;
import Modelo.TableroRandom;
import Modelo.Tauler;
import Vista.Interficie;

// Interficie que se encarga de simular la interacción con el usuario, útil para el uso de los Mocks
public interface Partida {
	
	public abstract void seleccionarDificultad();
	
	public abstract Tauler getTablero();
	
	public abstract void seleccionarTirada();
	
	public abstract void seleccionarTiradaIncorrecta();

	public abstract void seleccionarDificultadIncorrecta();
	
	public abstract void seleccionarTiradaBandera();
	
	public abstract boolean FiPartida();
	
	public abstract void mostrarTablero();
	
}
