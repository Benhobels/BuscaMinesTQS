package BuscaMines;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	// 1- test en el que el usuario selecciona una dificultad válida
	@Test
	public void testSelectDificultadValida() {
		Player p = new MockPlayer();
		int dificultad = p.seleccionarDificultad();
		assertEquals(dificultad, 1);
		Tauler T = new Tauler();
		assertTrue(T.comprobarDificultad(dificultad));
	}
	
	// 2- test en el que el usuario selecciona una dificultad no válida --try catch?---
	@Test
	public void testSelectDificultadInvalida()
	{
		Player p = new MockPlayerWrong();
		int dificultad = p.seleccionarDificultad();
		assertEquals(dificultad, 4);
		Tauler T = new Tauler();
		assertFalse(T.comprobarDificultad(dificultad));
	}
	
	// 3- test en el que el usuario selecciona una casilla válida 
	@Test
	public void testSelectCasilla() {
		Player p = new MockPlayer();
		int[] posCasilla = new int[2];
		posCasilla = p.seleccionarCasilla();
		assertEquals(posCasilla[0], 3);
		assertEquals(posCasilla[1], 6);	
	}
	
	// 4- test en el que el usuario selecciona una casilla inválida -- fuera de rango --
	
	// 5- test en el que el usuario selecciona una casilla inválida -- ya abierta --
	
	// 6- test en el que el propio usuario entra un valor --cin de usuario--

	

}
