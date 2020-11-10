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
			assertTrue(C[2][5].getAbierta());
		}
		
		@Test
		public void testSelectDificultadIncorrecta() {
			Partida P = new MockPlayer();
			P.seleccionarDificultadIncorrecta();
			Tauler T = P.getTablero();
			assertEquals(T.getFiles(),0);
			assertEquals(T.getColumnes(),0);
			assertEquals(T.getNumMines(),0);
		}
		
		@Test
		public void testAbrirCasillaIncorrecta() {
			Partida p = new MockPlayer();
			p.seleccionarDificultad();
			p.seleccionarTiradaIncorrecta();
			Tauler T = p.getTablero();
			Casella[][] C = T.getMatriuPlayer();
			for(int i = 0; i < T.getFiles(); i++)
				for(int j=0; j < T.getColumnes(); j++)
					assertFalse(C[i][j].getAbierta());
		}
		
		//test dos tirar dos veces en el mismo sitio
		@Test
		public void testAbrirCasillaDosVeces() {
			Partida p = new MockPlayer();
			p.seleccionarDificultad();
			p.seleccionarTirada();
			Tauler T = p.getTablero();
			Casella[][] C = T.getMatriuPlayer();
			assertTrue(C[2][5].getAbierta());
			p.seleccionarTirada();
			assertTrue(C[2][5].getAbierta());
		}
		
		@Test
		public void testPonerBandera() {
			Partida p = new MockPlayer();
			p.seleccionarDificultad();
			p.seleccionarTiradaBandera();
			Tauler T = p.getTablero();
			Casella[][] C = T.getMatriuPlayer();
			assertFalse(C[2][5].getAbierta());
			assertTrue(C[2][5].getBandera());
		}
		
		@Test
		public void testQuitarBandera() {
			Partida p = new MockPlayer();
			p.seleccionarDificultad();
			p.seleccionarTiradaBandera();
			Tauler T = p.getTablero();
			Casella[][] C = T.getMatriuPlayer();
			assertFalse(C[2][5].getAbierta());
			assertTrue(C[2][5].getBandera());
			p.seleccionarTiradaQuitarBandera();
			assertFalse(C[2][5].getAbierta());
			assertFalse(C[2][5].getBandera());
		}
}
