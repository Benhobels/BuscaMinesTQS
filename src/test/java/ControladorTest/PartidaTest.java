package ControladorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Controlador.Partida;
import Modelo.Casella;
import Modelo.GeneradorTablero;
import Modelo.TableroRandom;
import Modelo.Tauler;
import Vista.Player;

public class PartidaTest {
	/*
	// 1- test en el que el usuario selecciona una dificultad válida
		@Test
		public void testSelectDificultadValida() {
			Player p = new MockPlayer();
			int dificultad = p.seleccionarDificultad();
			assertEquals(dificultad, 1);
			GeneradorTablero rand = new TableroRandom();
			Tauler T = new Tauler(rand);
			assertTrue(T.comprobarDificultad(dificultad));
		}
		
		// 2- test en el que el usuario selecciona una dificultad no válida 
		@Test
		public void testSelectDificultadInvalida()
		{
			Player p = new MockPlayerWrong();
			int dificultad = p.seleccionarDificultad();
			assertEquals(dificultad, 4);
			GeneradorTablero rand = new TableroRandom();
			Tauler T = new Tauler(rand);
			assertFalse(T.comprobarDificultad(dificultad));
		}
		
		// 3- test en el que el usuario selecciona una casilla válida 
		@Test
		public void testSelectCasilla() {
			Player p = new MockPlayer();
			int[] tirada = new int[3];
			tirada = p.seleccionarTirada();
			assertEquals(tirada[0], 3);
			assertEquals(tirada[1], 6);
			assertEquals(tirada[2], 1);
			GeneradorTablero rand = new TableroRandom();
			Tauler T = new Tauler(rand);
			T.generarTauler(1);
			assertTrue(T.comprobarFila(tirada[0]));
			assertTrue(T.comprobarColumna(tirada[1]));
			assertTrue(T.comprobarAccion(tirada[2]));
		}
		
		// 4- test en el que el usuario selecciona una casilla inválida -- fuera de rango --
		@Test
		public void testSelectCasillaInvalida() {
			Player p = new MockPlayerWrong();
			int[] tirada = new int[3];
			tirada = p.seleccionarTirada();
			assertEquals(tirada[0], 17);
			assertEquals(tirada[1], 17);
			assertEquals(tirada[2], 0);
			GeneradorTablero rand = new TableroRandom();
			Tauler T = new Tauler(rand);
			T.generarTauler(1);
			assertFalse(T.comprobarFila(tirada[0]));
			assertFalse(T.comprobarColumna(tirada[1]));
			assertFalse(T.comprobarAccion(tirada[2]));
		}
		*/
		@Test
		public void testSelectDificultadValida() {
			Partida P = new MockPlayer();
			P.seleccionarDificultad();
			Tauler T = P.getTablero();
			assertEquals(T.getFiles(),16);
			assertEquals(T.getColumnes(),16);
			assertEquals(T.getNumMines(),40);
		}
		
		@Test
		public void testAbrirCasilla() {
			Partida p = new MockPlayer();
			p.seleccionarDificultad();
			p.seleccionarTirada();
			Tauler T = p.getTablero();
			Casella[][] C = T.getMatriuPlayer();
			assertNotNull(C[2][5].getValor());
			assertTrue(C[2][5].getAbierta());
		}
}
