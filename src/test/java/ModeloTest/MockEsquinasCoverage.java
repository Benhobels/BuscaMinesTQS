package ModeloTest;

import Modelo.Casella;
import Modelo.GeneradorTablero;

//mock utilizado para realizar el Path Coverage y Decision Coverage de los esquinas restantes que no se han comprovado con TDD
public class MockEsquinasCoverage implements GeneradorTablero{
	public Casella[][] generarMinas(int filas, int columnas, int minas) {
        Casella[][] matriz = new Casella[filas][columnas];
        
        //Aquest bucle hauria de anar fora potser
        for(int i = 0; i < filas; i++) {
        	for(int j = 0; j < columnas; j++) {
        		matriz[i][j] = new Casella();
        	}
        }
        
        matriz[0][3].setValor(9);
        matriz[2][1].setValor(9);
        matriz[2][5].setValor(9);
        matriz[3][0].setValor(9);
        matriz[5][1].setValor(9);
        matriz[5][2].setValor(9);
        matriz[5][5].setValor(9);
        matriz[6][3].setValor(9);
        matriz[7][2].setValor(9);
        matriz[7][5].setValor(9);
        
        return matriz;
    }
}
