package ModeloTest;

import Modelo.Casella;
import Modelo.GeneradorTablero;

//MockBordesCoverage: mock utilizado para realizarStatement Coverage de los bordes restantes (que no se han comprovado con TDD)
public class MockBordesCoverage implements GeneradorTablero{
	public Casella[][] generarMinas(int filas, int columnas, int minas) {
        Casella[][] matriz = new Casella[filas][columnas];
        
        //Aquest bucle hauria de anar fora potser
        for(int i = 0; i < filas; i++) {
        	for(int j = 0; j < columnas; j++) {
        		matriz[i][j] = new Casella();
        	}
        }
        
        matriz[0][0].setValor(9);
        matriz[0][7].setValor(9);
        matriz[7][0].setValor(9);
        matriz[7][7].setValor(9);
        matriz[0][2].setValor(9);
        matriz[0][4].setValor(9);
        matriz[0][5].setValor(9);
        matriz[3][1].setValor(9);
        matriz[5][1].setValor(9);
        matriz[5][4].setValor(9);
        
        return matriz;
    }
}
