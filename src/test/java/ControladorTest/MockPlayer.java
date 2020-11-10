package ControladorTest;

import Controlador.Partida;
import Modelo.GeneradorTablero;
import Modelo.TableroRandom;
import Modelo.Tauler;
import Vista.Player;

public class MockPlayer implements Partida {
	
	public Tauler TableroPartida;
	
	public MockPlayer() {
		GeneradorTablero rand = new TableroRandom();
		TableroPartida = new Tauler(rand);
	}
	
	public void seleccionarDificultad() {
		TableroPartida.generarTauler(1); // dificultad normal
	}
	
	public Tauler getTablero()
	{
		return TableroPartida;
	}
	
	public int[] seleccionarTirada() {
		int[] tirada = new int[3];
		tirada[0] = 3; // fila
		tirada[1] = 6; // columna
		tirada[2] = 1;
		return tirada;
	}
}
