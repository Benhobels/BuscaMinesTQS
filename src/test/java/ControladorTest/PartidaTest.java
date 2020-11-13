package ControladorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Controlador.Partida;
import Modelo.Casella;
import Modelo.GeneradorTablero;
import Modelo.TableroRandom;
import Modelo.Tauler;

public class PartidaTest {

		// 1- Test que se encarga de comprobar una dificultad válida con el modelo
		@Test
		public void testSelectDificultadValida() {
			Partida P = new MockPlayer();
			P.seleccionarDificultad();
			Tauler T = P.getTablero();
			assertEquals(T.getFiles(),16);
			assertEquals(T.getColumnes(),16);
			assertEquals(T.getNumMines(),40);
		}
		
		// 2- Partición equivalente: Test que se encarga de abrir una casilla válida con el modelo
		@Test
		public void testAbrirCasilla() {
			Partida p = new MockPlayer();
			p.seleccionarDificultad();
			p.seleccionarTirada();
			Tauler T = p.getTablero();
			Casella[][] C = T.getMatriuPlayer();
			assertTrue(C[2][5].getAbierta());
		}
		
		// 3- Decision Coverage + Condition Coverage + Valor Límite: test que se encarga de comprobar una dificultad inválida con el modelo
		@Test
		public void testSelectDificultadIncorrecta() {
			Partida P = new MockPlayer();
			P.seleccionarDificultadIncorrecta();
			Tauler T = P.getTablero();
			assertEquals(T.getFiles(),0);
			assertEquals(T.getColumnes(),0);
			assertEquals(T.getNumMines(),0);
		}
		
		// 3- Decision Coverage + Condition Coverage + Valor Límite: test que se encarga de abrir una casilla inválida con el modelo
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
		
		// 4-Condition Coverage: test que se encarga de tirar dos veces en el mismo sitio ( y comprobar que la segunda tirada no haga nada con el modelo)
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
		
		// 5- TDD + Partición Equivalente: test que se encarga de poner una bandera con el modelo
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
		
		// 6- TDD + Partición Equivalente: test que se encarga de quitar una bandera con el modelo
		@Test
		public void testQuitarBandera() {
			Partida p = new MockPlayer();
			p.seleccionarDificultad();
			p.seleccionarTiradaBandera();
			Tauler T = p.getTablero();
			Casella[][] C = T.getMatriuPlayer();
			assertFalse(C[2][5].getAbierta());
			assertTrue(C[2][5].getBandera());
			p.seleccionarTiradaBandera();
			assertFalse(C[2][5].getAbierta());
			assertFalse(C[2][5].getBandera());
		}
}
