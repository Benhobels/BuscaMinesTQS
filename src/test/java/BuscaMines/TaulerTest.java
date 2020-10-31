package BuscaMines;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaulerTest {

	@Test
	public void testGenerarTaulerFacil() {
		Tauler T = new Tauler();
		T.generarTauler(0);
		assertEquals(T.getFiles(), 8);
		assertEquals(T.getColumnes(), 8);
		assertEquals(T.getNumMines(), 10);
	}
	
	@Test
	public void testGenerarTaulerNormal() {
		Tauler T = new Tauler();
		T.generarTauler(1);
		assertEquals(T.getFiles(), 16);
		assertEquals(T.getColumnes(), 16);
		assertEquals(T.getNumMines(), 40);
	}
	
	@Test
	public void testGenerarTaulerDificil() {
		Tauler T = new Tauler();
		T.generarTauler(2);
		assertEquals(T.getFiles(), 16);
		assertEquals(T.getColumnes(), 30);
		assertEquals(T.getNumMines(), 99);
	}
	
	@Test
	public void testGenerarMatriu() {
		Tauler T = new Tauler();
		Casella[][] m = new Casella[16][16]; 
		T.generarTauler(1);
		assertEquals(T.getMatriu(),m);
	}
	
	@Test
	public void testColocarMinas() {
		GeneradorRandom rand = new MockGeneradorRandom();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		assertEquals(T.getValorCasella(0, 0), 9);
		assertEquals(T.getValorCasella(0, 4), 9);
		assertEquals(T.getValorCasella(1, 4), 9);
		assertEquals(T.getValorCasella(3, 5), 9);
		assertEquals(T.getValorCasella(2, 7), 9);
		assertEquals(T.getValorCasella(4, 2), 9);
		assertEquals(T.getValorCasella(4, 7), 9);
		assertEquals(T.getValorCasella(6, 1), 9);
		assertEquals(T.getValorCasella(6, 4), 9);
		assertEquals(T.getValorCasella(7, 6), 9);
		
	}
	
	@Test
	public void testGenerarTablero() {
		GeneradorRandom rand = new MockGeneradorRandom();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		// comprovamos casilla fila 4 columna 6 --> mina
		assertEquals(T.getValorCasella(3, 5), 9);
		// comprovamos casilla fila 4 columna 7
		assertEquals(T.getValorCasella(3, 6), 3);
		// comprovamos cassilla fila 4 columna 5
		assertEquals(T.getValorCasella(3, 4), 1);
		// comprovamos casilla fila 5 columna 6
		assertEquals(T.getValorCasella(4, 5), 1);
		// comprovamos casilla fila 5 columna 7
		assertEquals(T.getValorCasella(4, 6), 2);
		// comprovamos cassilla fila 5 columna 5
		assertEquals(T.getValorCasella(4, 4), 1);
		// comprovamos casilla fila 3 columna 6
		assertEquals(T.getValorCasella(2, 5), 2);
		// comprovamos casilla fila 3 columna 7
		assertEquals(T.getValorCasella(2, 6), 2);
		// comprovamos cassilla fila 3 columna 5
		assertEquals(T.getValorCasella(2, 4), 2);
	}
	/*
	@Test
	public void testGenerarMatriuMines() {
		Tauler T = new Tauler();
		T.generarTauler(1);
		Casella[][] m = T.getMatriu(); 
		int contadorMines = 0;
		for(int i = 0; i < T.getFiles(); i++)
			for(int j = 0; j < T.getColumnes(); j++)
			{
				if(m[i][j].getValor() == 1)
					contadorMines++;
			}
		assertEquals(40,contadorMines);
	}
	*/

}
