package BuscaMines;

public class MockPlayerWrong implements Player {
	public int seleccionarDificultad() {
		return 4; // dificultad invalida
	}
	
	public int[] seleccionarCasilla() {
		int[] posiciones = new int[2];
		posiciones[0] = 17; // fila
		posiciones[1] = 17; // columna
		return posiciones;
	}
}