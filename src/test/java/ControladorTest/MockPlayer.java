package ControladorTest;

import Controlador.Partida;
import Modelo.GeneradorTablero;
import Modelo.TableroRandom;
import Modelo.Tauler;

public class MockPlayer implements Partida {
	
	public Tauler TableroPartida;
	
	public MockPlayer() {
		GeneradorTablero rand = new TableroRandom();
		TableroPartida = new Tauler(rand);
	}
	
	public void seleccionarDificultad() {
		TableroPartida.comprobarCreacion(1);
	}
	
	public void seleccionarDificultadIncorrecta() {
		TableroPartida.comprobarCreacion(4);
	}
	
	public Tauler getTablero()
	{
		return TableroPartida;
	}
	
	public void seleccionarTirada() {
		int[] tirada = new int[3];
		tirada[0] = 3; // fila
		tirada[1] = 6; // columna
		tirada[2] = 1;
		TableroPartida.tiradaJugador(tirada[0],tirada[1],tirada[2]);
	}
	
	public void seleccionarTiradaIncorrecta() {
		int[] tirada = new int[3];
		tirada[0] = 16; // fila
		tirada[1] = -1; // columna
		tirada[2] = 1;
		TableroPartida.tiradaJugador(tirada[0],tirada[1],tirada[2]);
	}
	
	public void seleccionarTiradaBandera() {
		int[] tirada = new int[3];
		tirada[0] = 3; // fila
		tirada[1] = 6; // columna
		tirada[2] = 2;
		TableroPartida.tiradaJugador(tirada[0],tirada[1],tirada[2]);
	}
}
