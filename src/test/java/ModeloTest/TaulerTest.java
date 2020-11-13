package ModeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Casella;
import Modelo.GeneradorTablero;
import Modelo.TableroRandom;
import Modelo.Tauler;

// MockGeneradorTDD = mock utilizado para la estrategia TDD
// MockBordesCoverage = mock utilizado para la estrategia Statement Coverage de los bordes del tablero
// MockEsquinasCoverage = mock utilizado para la estrategia Statement Coverage de las esquinas del tablero

public class TaulerTest {

	// test necesarios para aplicar la estrategia TDD:
	
	// 1 - TDD: test para generar el tablero del nivel fácil
	@Test
	public void testGenerarTaulerFacil() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		assertEquals(T.getFiles(), 8);
		assertEquals(T.getColumnes(), 8);
		assertEquals(T.getNumMines(), 10);
	}
	
	// 2- TDD: test para generar el tablero del nivel normal
	@Test
	public void testGenerarTaulerNormal() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(1);
		assertEquals(T.getFiles(), 16);
		assertEquals(T.getColumnes(), 16);
		assertEquals(T.getNumMines(), 40);
	}
	
	// 3- TDD: test para generar el tablero del nivel difícil
	@Test
	public void testGenerarTaulerDificil() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(2);
		assertEquals(T.getFiles(), 16);
		assertEquals(T.getColumnes(), 30);
		assertEquals(T.getNumMines(), 99);
	}
	
	// 4- TDD: test para colocar las minas dentro de la matriz 
	@Test
	public void testColocarMinas() {
		GeneradorTablero rand = new MockGeneradorTDD();
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
	
	// 5- TDD: test para generar los números de alrededor de las minas
	@Test
	public void testGenerarTablero() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		// comprobamos casilla fila 4 columna 6 --> mina
		assertEquals(T.getValorCasella(3, 5), 9);
		// comprobamos casilla fila 4 columna 7
		assertEquals(T.getValorCasella(3, 6), 3);
		// comprobamos cassilla fila 4 columna 5
		assertEquals(T.getValorCasella(3, 4), 1);
		// comprobamos casilla fila 5 columna 6
		assertEquals(T.getValorCasella(4, 5), 1);
		// comprobamos casilla fila 5 columna 7
		assertEquals(T.getValorCasella(4, 6), 2);
		// comprobamos casilla fila 5 columna 5
		assertEquals(T.getValorCasella(4, 4), 1);
		// comprobamos casilla fila 3 columna 6
		assertEquals(T.getValorCasella(2, 5), 2);
		// comprobamos casilla fila 3 columna 7
		assertEquals(T.getValorCasella(2, 6), 2);
		// comprobamos casilla fila 3 columna 5
		assertEquals(T.getValorCasella(2, 4), 2);
	}
	
	// 6- TDD + Valor Frontera: test para abrir la esquina superior derecha (y su respectiva expansión)
	@Test
	public void testAbrirEsquinaSuperiorDerecha() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(0,7);
		//comprobamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(0,7), 0);
		//comprobamos que el tablero se haya expandido correctamente
		assertEquals(T.getValorCasillaAbierta(0,6), 0);
		assertEquals(T.getValorCasillaAbierta(0,5), 2);
		assertEquals(T.getValorCasillaAbierta(1,5), 2);
		assertEquals(T.getValorCasillaAbierta(1,6), 1);
		assertEquals(T.getValorCasillaAbierta(1,7), 1);
		assertFalse(T.getCasillaAbierta(0, 4));
	}
	
	// 7- TDD + Valor frontera: test para abrir la esquina inferior derecha (no se debe expandir!)
	@Test
	public void testAbrirEsquinaInferiorDerecha() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(7,7);
		//comprobamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(7,7), 1);
		//comprobamos que el tablero se haya expandido correctamente
		assertFalse(T.getCasillaAbierta(6, 7));
		assertFalse(T.getCasillaAbierta(7, 6));
		assertFalse(T.getCasillaAbierta(6, 6));
	}
	
	// 8- TDD + Valor frontera: test para abrir la esquina superior izquierda (y su respectiva expansión)
	@Test
	public void testAbrirEsquinaSuperiorIzquierda() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(0,0);
		//comprobamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(0,0), 9);
		//comprobamos que el tablero se haya expandido correctamente
		assertFalse(T.getCasillaAbierta(0, 1));
		assertFalse(T.getCasillaAbierta(1, 0));
		assertFalse(T.getCasillaAbierta(1, 1));
	}
	
	// 9- TDD + Partición Equivalente: test para abrir una casilla central (y su respectiva expansión)
	@Test
	public void testAbrirCasillaMedio() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(2,1);
		//comprobamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(2,1), 0);
		//comprobamos que el tablero se haya expandido correctamente
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
	
	// Acto seguido, generamos diferentes mocks con el fin de realizar Statement Coverage (y Decision Coverage, Condition Coverage)
	
	// MockBordesCoverage: este mock constará de minas en las esquinas y nos permitirá expandir los bordes restantes
	
	// 10- Decision Coverage + Condition Coverage + Partición Equivalente: test para abrir una casilla del borde derecho (y comprobar su expansión)
	@Test
	public void TestStatementCoverageBordeDerecha() {
		GeneradorTablero rand = new MockBordesCoverage();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(3,7);
		//comprobamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(3,7), 0);
		//comprobamos que el tablero se haya expandido correctamente
		assertEquals(T.getValorCasillaAbierta(1,7), 1);
		assertEquals(T.getValorCasillaAbierta(1,6), 2);
		assertEquals(T.getValorCasillaAbierta(1,5), 2);
		assertEquals(T.getValorCasillaAbierta(1,4), 2);
		assertEquals(T.getValorCasillaAbierta(1,3), 2);
		assertEquals(T.getValorCasillaAbierta(1,2), 1);
		assertEquals(T.getValorCasillaAbierta(2,2), 1);
		assertEquals(T.getValorCasillaAbierta(3,2), 1);
		assertEquals(T.getValorCasillaAbierta(4,2), 2);
		assertEquals(T.getValorCasillaAbierta(4,3), 1);
		assertEquals(T.getValorCasillaAbierta(4,4), 1);
		assertEquals(T.getValorCasillaAbierta(4,5), 1);
		assertEquals(T.getValorCasillaAbierta(5,5), 1);
		assertEquals(T.getValorCasillaAbierta(6,5), 1);
		assertEquals(T.getValorCasillaAbierta(6,6), 1);
		assertEquals(T.getValorCasillaAbierta(6,7), 1);
		assertEquals(T.getValorCasillaAbierta(2,6), 0);
		assertEquals(T.getValorCasillaAbierta(2,3), 0);
	}
	
	// 11- Decision Coverage + Condition Coverage + Partición Equivalente: test para abrir casilla del borde inferior (y comprobar su expansión)
	@Test 
	public void TestStatementCoverageBordeInferior() {
		GeneradorTablero rand = new MockBordesCoverage();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(7,4);
		//comprobamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(7,4), 0);
		//comprobamos que el tablero se haya expandido correctamente
		assertEquals(T.getValorCasillaAbierta(7,6), 1);
		assertEquals(T.getValorCasillaAbierta(6,6), 1);
		assertEquals(T.getValorCasillaAbierta(7,5), 0);
		assertEquals(T.getValorCasillaAbierta(6,5), 1);
		assertEquals(T.getValorCasillaAbierta(6,4), 1);
		assertEquals(T.getValorCasillaAbierta(7,3), 0);
		assertEquals(T.getValorCasillaAbierta(6,3), 1);
		assertEquals(T.getValorCasillaAbierta(7,2), 0);
		assertEquals(T.getValorCasillaAbierta(6,2), 1);
		assertEquals(T.getValorCasillaAbierta(7,1), 1);
		assertEquals(T.getValorCasillaAbierta(6,1), 2);
	}
	
	// MockEsquinasCoverage: este mock no constará de minas en las esquinas y nos permitirá expandir a través de estas
	
	// 12- Decision Coverage + Condition Coverage + Valor frontera: test para abrir esquina inferior derecha (y comprobar su expansión) 
	@Test
	public void TestStatementCoverageEsquinaInferiorDerecha() {
		GeneradorTablero rand = new MockEsquinasCoverage();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(7, 7);
		//comprovamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(7,7), 0);
		//comprovamos que el tablero se haya expandido correctamente
		assertEquals(T.getValorCasillaAbierta(0,4), 1);
		assertEquals(T.getValorCasillaAbierta(1,4), 2);
		assertEquals(T.getValorCasillaAbierta(1,5), 1);
		assertEquals(T.getValorCasillaAbierta(1,6), 1);
		assertEquals(T.getValorCasillaAbierta(2,6), 1);
		assertEquals(T.getValorCasillaAbierta(3,6), 1);
		assertEquals(T.getValorCasillaAbierta(4,6), 1);
		assertEquals(T.getValorCasillaAbierta(5,6), 1);
		assertEquals(T.getValorCasillaAbierta(6,6), 2);
		assertEquals(T.getValorCasillaAbierta(7,6), 1);
		assertEquals(T.getValorCasillaAbierta(6,7), 0);
		assertEquals(T.getValorCasillaAbierta(3,7), 0);
	}
	
	// 13- Decision Coverage + Condition Coverage + Valor frontera: test para abrir esquina inferior izquierda (y comprobar su expansión)
	@Test
	public void TestStatementCoverageEsquinaInferiorIzquierda() {
		GeneradorTablero rand = new MockEsquinasCoverage();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(7, 0);
		//comprovamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(7,0), 0);
		//comprovamos que el tablero se haya expandido correctamente
		assertEquals(T.getValorCasillaAbierta(6,0), 1);
		assertEquals(T.getValorCasillaAbierta(6,1), 3);
		assertEquals(T.getValorCasillaAbierta(7,1), 1);
	}
	
	// 14- Decision Coverage + Condition Coverage: test para abrir esquina superior izquierda (y comprobar su expansión)
	@Test
	public void TestStatementCoverageEsquinaSuperiorIzquierda() {
		GeneradorTablero rand = new MockEsquinasCoverage();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(0, 0);
		//comprovamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(0,0), 0);
		//comprovamos que el tablero se haya expandido correctamente
		assertEquals(T.getValorCasillaAbierta(0,1), 0);
		assertEquals(T.getValorCasillaAbierta(0,2), 1);
		assertEquals(T.getValorCasillaAbierta(1,0), 1);
		assertEquals(T.getValorCasillaAbierta(1,1), 1);
		assertEquals(T.getValorCasillaAbierta(1,2), 2);
	}
	
	// Test con generación de tableros aleatorios siguiendo TDD:
	
	// 15- TDD: test para crear tablero nivel facil aleatorio
    @Test
    public void TestRandomTableroFacil() {
        GeneradorTablero rand = new TableroRandom();
        Tauler T = new Tauler(rand);
        T.generarTauler(0);
        Casella[][] Matriz= T.getMatriu();
        int contadorMinas = 0;
        for(int i= 0; i < T.getFiles(); i++)
            for(int j= 0; j < T.getColumnes(); j++)
            {
                if(Matriz[i][j].getValor() == 9)
                    contadorMinas++;
            }
        assertEquals(10, contadorMinas);

    }

    // 16- TDD: test para crear tablero nivel normal aleatorio
    @Test
    public void TestRandomTableroNormal() {
        GeneradorTablero rand = new TableroRandom();
        Tauler T = new Tauler(rand);
        T.generarTauler(1);
        Casella[][] Matriz= T.getMatriu();
        int contadorMinas = 0;
        for(int i= 0; i < T.getFiles(); i++)
        {
            for(int j= 0; j < T.getColumnes(); j++)
            {
                if(Matriz[i][j].getValor() == 9)
                {
                    contadorMinas++;
                }
            }

        }

        assertEquals(40, contadorMinas);

    }

    // 17- TDD: test para crear tablero nivel dificil aleatorio
    @Test
    public void TestRandomTableroDificil() {
        GeneradorTablero rand = new TableroRandom();
        Tauler T = new Tauler(rand);
        T.generarTauler(2);
        Casella[][] Matriz= T.getMatriu();
        int contadorMinas = 0;
        for(int i= 0; i < T.getFiles(); i++)
            for(int j= 0; j < T.getColumnes(); j++)
            {
                if(Matriz[i][j].getValor() == 9)
                    contadorMinas++;
            }
        assertEquals(99, contadorMinas);

    }
    
    // Test para comprovar las acciones del jugador, usando TDD:
    
    // 18- TDD + Partición equivalente: test para comprovar una dificultad válida introducida por el usuario
    @Test
    public void TestComprobarDificultadValida() {
    	GeneradorTablero rand = new TableroRandom();
        Tauler T = new Tauler(rand);
        assertTrue(T.comprobarDificultad(0));
    }
    
    // 19- Decision Coverage + Condition Coverage + Valor límite: test para comprobar una dificultad inválida introducida por el usuario
    @Test
    public void TestComprobarDificultadInvalida() {
    	GeneradorTablero rand = new TableroRandom();
        Tauler T = new Tauler(rand);
        assertFalse(T.comprobarDificultad(5));
    }
    
    // 20- TDD + Valores Frontera: test para comprobar una fila válida introducida por el usuario
    @Test
    public void TestComprobarFilaValida() {
    	GeneradorTablero rand = new TableroRandom();
        Tauler T = new Tauler(rand);
        T.generarTauler(0);
        assertTrue(T.comprobarFila(1));
    }
    
    // 21- Decision Coverage + Condition Coverage + Valor Limite: test para comprobar una fila inválida introducida por el usuario
    @Test
    public void TestComprobarFilaInvalida() {
    	GeneradorTablero rand = new TableroRandom();
        Tauler T = new Tauler(rand);
        T.generarTauler(0);
        assertFalse(T.comprobarColumna(9));
    }
    
    // 22- TDD + Partición equivalente: test para comprovar una columna válida introducida por el usuario
    @Test
    public void TestComprobarColumnaValida() {
    	GeneradorTablero rand = new TableroRandom();
        Tauler T = new Tauler(rand);
        T.generarTauler(0);
        assertTrue(T.comprobarColumna(5));
    }
    
    // 23- Decision Coverage + Condition Coverage + Valor límite: test para comprovar una columna inválida introducida por el usuario
    @Test
    public void TestComprobarColumnaInvalida() {
    	GeneradorTablero rand = new TableroRandom();
        Tauler T = new Tauler(rand);
        T.generarTauler(0);
        assertFalse(T.comprobarColumna(9));
    }
    
    // 24- TDD + Partición Equivalente: test para comprovar una acción válida introducida por el usuario
    @Test
    public void TestComprobarAccionValida() {
    	GeneradorTablero rand = new TableroRandom();
        Tauler T = new Tauler(rand);
        assertTrue(T.comprobarAccion(2));
    }
    
    // 25- Decision Coverage + Condition Coverage + Valor límite: test para comprovar una acción inválida introducida por el usuario
    @Test
    public void TestComprobarAccionInvalida() {
    	GeneradorTablero rand = new TableroRandom();
        Tauler T = new Tauler(rand);
        T.generarTauler(0);
        assertFalse(T.comprobarAccion(0));
    }
    
    // 26- TDD + Valor frontera: test para comprobar que se ha expandido correctamente el tablero
    @Test
    public void TestComprobarCasillasAbiertas() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(0, 7);
		// comprobamos que se ha expandido correctamente
		assertEquals(T.getContadorCasillasAbiertas(), 6);
    }
    
    // 27- Decision Coverage + Condition Coverage + Valores Frontera + Valores Límites: test para comprobar todas las condiciones de la función comporbarFila()
    @Test
    public void TestStatementCoverageComprobarFila() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		// valores frontera
		assertTrue(T.comprobarFila(1));
		assertTrue(T.comprobarFila(8));
		// valores límite
		assertFalse(T.comprobarFila(-1));
		assertFalse(T.comprobarFila(9));
    }
    
    // 28- Decision Coverage + Condition Coverage + Valores límite + Valores frontera: test para comprobar todas las condiciones de la función comporbarColumna()
    @Test
    public void TestStatementCoverageComprobarColumna() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		// valores frontera
		assertTrue(T.comprobarColumna(1));
		assertTrue(T.comprobarColumna(8));
		// valores límite
		assertFalse(T.comprobarColumna(-1));
		assertFalse(T.comprobarColumna(9));
    }
    
    // 29- Decision Coverage + Condition Coverage + Valores Frontera + Valores límite: test para comprobar todas las condiciones de la función comporbarDificultad()
    @Test
    public void TestStatementCoverageComprobarDificultad() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		// valores frontera
		assertTrue(T.comprobarDificultad(0));
		assertTrue(T.comprobarDificultad(2));
		// valores límite
		assertFalse(T.comprobarDificultad(-1));
		assertFalse(T.comprobarDificultad(4));
    }
    
    // 30- Decision Coverage + Condition Coverage + Valores Frontera + Valores límite: test para comprobar todas las condiciones de la función comporbarAccion()
    @Test
    public void TestStatementCoverageComprobarAccion() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		// valores frontera
		assertTrue(T.comprobarAccion(1));
		assertTrue(T.comprobarAccion(2));
		// valores límite
		assertFalse(T.comprobarAccion(-1));
		assertFalse(T.comprobarAccion(3));
    }
    
    // 31- TDD + Partición Equivalente: test para comprobar la función comporbarCreacion() que se encarga de crear el tablero
    @Test
    public void TestComprobarCreacion() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.comprobarCreacion(0);
		// comprobamos que los diferentes aspectos del tablero se han creado correctamente
		assertEquals(T.getFiles(), 8);
		assertEquals(T.getColumnes(), 8);
		assertEquals(T.getNumMines(), 10);
		
    }
    
    // 32- Decision Coverage + Condition Coverage +  Valor límite: test para comprobar todas las condiciones de la función comporbarCreacion()
    @Test
    public void TestPathCoverageComprobarCreacionInvalida() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.comprobarCreacion(4);
		// comprobamos que los diferentes aspectos del tablero se han creado correctamente
		assertEquals(T.getFiles(), 0);
		assertEquals(T.getColumnes(), 0);
		assertEquals(T.getNumMines(), 0);
    }
    
    // 33- TDD: test para comprobar el uso de las banderas (poner + quitar)
    @Test
    public void TestPathCoverageComprovarBandera() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.comprobarCreacion(0);
		T.tiradaJugador(1, 1, 2);
		Casella[][] MatrizJugador = T.getMatriuPlayer();
		// comprovamos que se haya colocado una bandera en la casilla 
		assertTrue(MatrizJugador[0][0].getBandera());
		T.tiradaJugador(1, 1, 2);
		MatrizJugador = T.getMatriuPlayer();
		// comprovamos que se haya retirado la bandera en la casilla 
		assertFalse(MatrizJugador[0][0].getBandera());
    }
    
    // 34- Decision Coverage + Condition Coverage: test para comprobar posibles tiradas del jugador
    @Test
    public void TestStatementCoverageTiradaJugador() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.comprobarCreacion(0);
		T.tiradaJugador(1, 1, 1);
		Casella[][] MatrizJugador = T.getMatriuPlayer();
		// comprobamos que se haya abierto la casilla  
		assertTrue(MatrizJugador[0][0].getAbierta());
		T.tiradaJugador(8, 8, 3);
		MatrizJugador = T.getMatriuPlayer();
		// comprobamos que no se haya realizado nada al respecto (acción inválida)
		assertFalse(MatrizJugador[7][7].getAbierta());
    }
    
    // 35- Decision Coverage + Condition Coverage + Valores Límite: test para comprobar tiradas inválidas por parte del jugador
    @Test
    public void TestStatementCoverageTiradaJugadorIncorrecta() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.comprobarCreacion(0);
		T.tiradaJugador(1, 9, 1);
		// comprobamos que no se haya abierto ninguna casilla (columna inválida)
		assertEquals(T.getContadorCasillasAbiertas(), 0);
		T.tiradaJugador(9, 1, 1);
		// comprobamos que no se haya realizado nada al respecto (fila inválida)
		assertEquals(T.getContadorCasillasAbiertas(), 0);
    }
    
    // 36- Decision Coverage + Condition Coverage + Particion Equivalente: test que comprueba que no es posible poner una bandera en una casilla abierta
    @Test
    public void TestStatementCoverageTiradaBandera() {
		GeneradorTablero rand = new MockGeneradorTDD();
		Tauler T = new Tauler(rand);
		T.comprobarCreacion(0);
		T.tiradaJugador(1, 1, 1);
		Casella[][] M = T.getMatriuPlayer();
		// comprobamos que no se haya abierto ninguna casilla 
		assertTrue(M[0][0].getAbierta());
		T.tiradaJugador(1, 1, 1);
		// comprobamos que no se haya puesto bandera en la casilla
		assertTrue(M[0][0].getAbierta());
		assertFalse(M[0][0].getBandera());
    }
}
