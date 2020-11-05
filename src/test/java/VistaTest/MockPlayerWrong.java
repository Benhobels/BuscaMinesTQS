package VistaTest;

import Vista.Player;

public class MockPlayerWrong implements Player {
	public int seleccionarDificultad() {
		return 4; // dificultad invalida
	}
	
	public int[] seleccionarTirada() {
		int[] tirada = new int[3];
		tirada[0] = 17; // fila
		tirada[1] = 17; // columna
		tirada[2] = 0;
		return tirada;
	}
}