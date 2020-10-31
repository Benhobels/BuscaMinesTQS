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
