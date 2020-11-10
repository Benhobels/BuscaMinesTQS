package ControladorTest;

import Controlador.Partida;
import Modelo.GeneradorTablero;
import Modelo.TableroRandom;
import Modelo.Tauler;

public class MockPlayerWrong implements Partida {
	
	public Tauler TableroPartida;
	
	public MockPlayerWrong() {
		GeneradorTablero rand = new TableroRandom();
		TableroPartida = new Tauler(rand);
	}
	
	public void seleccionarDificultadIncorrecta() {
		TableroPartida.comprobarCreacion(4);
	}
	
	public void seleccionarDificultad() {
		TableroPartida.comprobarCreacion(1);
	}
		
	public Tauler getTablero()
	{
		return TableroPartida;
	}
	
	public void seleccionarTirada() {
		int[] tirada = new int[3];
		tirada[0] = 17; // fila
		tirada[1] = -3; // columna
		tirada[2] = 1;
		TableroPartida.tiradaJugador(tirada[0],tirada[1],tirada[2]);
	}
}