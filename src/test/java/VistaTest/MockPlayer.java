package VistaTest;

import Vista.Player;

public class MockPlayer implements Player {
	public int seleccionarDificultad() {
		return 1; // dificultad normal
	}
	
	public int[] seleccionarTirada() {
		int[] tirada = new int[3];
		tirada[0] = 3; // fila
		tirada[1] = 6; // columna
		tirada[2] = 1;
		return tirada;
	}
}
