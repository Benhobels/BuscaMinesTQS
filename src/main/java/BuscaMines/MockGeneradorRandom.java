package BuscaMines;

public class MockGeneradorRandom implements GeneradorTablero{
    
	public Casella[][] generarMinas(int filas, int columnas, int minas) {
        Casella[][] matriz = new Casella[filas][columnas];
        
        //Aquest bucle hauria de anar fora potser
        for(int i = 0; i < filas; i++) {
        	for(int j = 0; j < columnas; j++) {
        		matriz[i][j] = new Casella();
        	}
        }
        
        matriz[0][0].setValor(9);
        matriz[0][4].setValor(9);
        matriz[1][4].setValor(9);
        matriz[3][5].setValor(9);
        matriz[2][7].setValor(9);
        matriz[4][2].setValor(9);
        matriz[4][7].setValor(9);
        matriz[6][1].setValor(9);
        matriz[6][4].setValor(9);
        matriz[7][6].setValor(9);
        
        return matriz;
    }
}