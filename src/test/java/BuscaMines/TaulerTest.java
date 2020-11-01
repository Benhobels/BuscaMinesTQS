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
	
	@Test
	public void testAbrirEsquinaSuperiorDerecha() {
		GeneradorRandom rand = new MockGeneradorRandom();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(0,7);
		//comprovamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(0,7), 0);
		//comprovamos que el tablero se haya expandido correctamente
		assertEquals(T.getValorCasillaAbierta(0,6), 0);
		assertEquals(T.getValorCasillaAbierta(0,5), 2);
		assertEquals(T.getValorCasillaAbierta(1,5), 2);
		assertEquals(T.getValorCasillaAbierta(1,6), 1);
		assertEquals(T.getValorCasillaAbierta(1,7), 1);
		assertFalse(T.getCasillaAbierta(0, 4));
	}
	
	@Test
	public void testAbrirEsquinaInferiorDerecha() {
		GeneradorRandom rand = new MockGeneradorRandom();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(7,7);
		//comprovamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(7,7), 1);
		//comprovamos que el tablero se haya expandido correctamente
		assertFalse(T.getCasillaAbierta(6, 7));
		assertFalse(T.getCasillaAbierta(7, 6));
		assertFalse(T.getCasillaAbierta(6, 6));
	}
	
	@Test
	public void testAbrirEsquinaSuperiorIzquierda() {
		GeneradorRandom rand = new MockGeneradorRandom();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(0,0);
		//comprovamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(0,0), 9);
		//comprovamos que el tablero se haya expandido correctamente
		assertFalse(T.getCasillaAbierta(0, 1));
		assertFalse(T.getCasillaAbierta(1, 0));
		assertFalse(T.getCasillaAbierta(1, 1));
	}
	
	@Test
	public void testAbrirCasillaMedio() {
		GeneradorRandom rand = new MockGeneradorRandom();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(2,1);
		//comprovamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(2,1), 0);
		//comprovamos que el tablero se haya expandido correctamente
		assertEquals(T.getValorCasillaAbierta(0,1), 1);
		assertEquals(T.getValorCasillaAbierta(0,2), 0);
		assertEquals(T.getValorCasillaAbierta(0,3), 2);
		assertEquals(T.getValorCasillaAbierta(1,0), 1);
		assertEquals(T.getValorCasillaAbierta(1,1), 1);
		assertEquals(T.getValorCasillaAbierta(1,2), 0);
		assertEquals(T.getValorCasillaAbierta(1,3), 2);
		assertEquals(T.getValorCasillaAbierta(2,0), 0);
		assertEquals(T.getValorCasillaAbierta(2,2), 0);
		assertEquals(T.getValorCasillaAbierta(2,3), 1);
		assertEquals(T.getValorCasillaAbierta(3,0), 0);
		assertEquals(T.getValorCasillaAbierta(3,1), 1);
		assertEquals(T.getValorCasillaAbierta(3,2), 1);
		assertEquals(T.getValorCasillaAbierta(3,3), 1);
		assertEquals(T.getValorCasillaAbierta(4,0), 0);
		assertEquals(T.getValorCasillaAbierta(4,1), 1);
		assertEquals(T.getValorCasillaAbierta(5,0), 1);
		assertEquals(T.getValorCasillaAbierta(5,1), 2);
		assertFalse(T.getCasillaAbierta(5, 2));
		assertFalse(T.getCasillaAbierta(0, 0));
	}
	
}
