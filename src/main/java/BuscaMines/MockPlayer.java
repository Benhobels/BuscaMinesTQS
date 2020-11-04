package BuscaMines;

public class MockPlayer implements Player {
	public int seleccionarDificultad() {
		return 1; // dificultad normal
	}
	
	public int[] seleccionarCasilla() {
		int[] posiciones = new int[2];
		posiciones[0] = 3; // fila
		posiciones[1] = 6; // columna
		return posiciones;
	}
}
