package BuscaMines;

import static org.junit.Assert.*;

import org.junit.Test;

// MockGeneradorTauler = utilizado para la estrategia TDD
// MockBordesCoverage = utilizado para la estrategia Path Coverage de los bordes del tablero
// MockEsquinasCoverage = utilizado para la estrategia Path Coverage de las esquinas del tablero

public class TaulerTest {

	// test necesarios para aplicar la estrategia TDD:
	
	// 1 - test para generar el tablero del nivel fácil
	@Test
	public void testGenerarTaulerFacil() {
		
		Tauler T = new Tauler();
		T.generarTauler(0);
		assertEquals(T.getFiles(), 8);
		assertEquals(T.getColumnes(), 8);
		assertEquals(T.getNumMines(), 10);
	}
	
	// 2- test para generar el tablero del nivel normal
	@Test
	public void testGenerarTaulerNormal() {
		Tauler T = new Tauler();
		T.generarTauler(1);
		assertEquals(T.getFiles(), 16);
		assertEquals(T.getColumnes(), 16);
		assertEquals(T.getNumMines(), 40);
	}
	
	// 3- test para generar el tablero del nivel difícil
	@Test
	public void testGenerarTaulerDificil() {
		Tauler T = new Tauler();
		T.generarTauler(2);
		assertEquals(T.getFiles(), 16);
		assertEquals(T.getColumnes(), 30);
		assertEquals(T.getNumMines(), 99);
	}
	
	// 4- test para generar la matriz que representa el tablero
	@Test
	public void testGenerarMatriu() {
		Tauler T = new Tauler();
		Casella[][] m = new Casella[16][16]; 
		T.generarTauler(1);
		assertEquals(T.getMatriu(),m);
	}
	
	// 5- test para colocar las minas dentro de la matriz (utilizamos MockGeneradorRandom)
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
	
	// 6- test para generar los numeros de alrededor de las minas
	@Test
	public void testGenerarTablero() {
		GeneradorTablero rand = new MockGeneradorTDD();
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
		// comprovamos casilla fila 5 columna 5
		assertEquals(T.getValorCasella(4, 4), 1);
		// comprovamos casilla fila 3 columna 6
		assertEquals(T.getValorCasella(2, 5), 2);
		// comprovamos casilla fila 3 columna 7
		assertEquals(T.getValorCasella(2, 6), 2);
		// comprovamos casilla fila 3 columna 5
		assertEquals(T.getValorCasella(2, 4), 2);
	}
	
	// 7- test para abrir la esquina superior derecha (y su respectiva expansión)
	@Test
	public void testAbrirEsquinaSuperiorDerecha() {
		GeneradorTablero rand = new MockGeneradorTDD();
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
	
	// 8- test para abrir la esquina inferior derecha (no se debe expandir!)
	@Test
	public void testAbrirEsquinaInferiorDerecha() {
		GeneradorTablero rand = new MockGeneradorTDD();
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
	
	// 9- test para abrir esquina superior izquierda (y su respectiva expansión)
	@Test
	public void testAbrirEsquinaSuperiorIzquierda() {
		GeneradorTablero rand = new MockGeneradorTDD();
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
	
	// 10- test para abrir una casilla central (y su respectiva expansión)
	@Test
	public void testAbrirCasillaMedio() {
		GeneradorTablero rand = new MockGeneradorTDD();
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
	
	// Acto seguido, generamos diferentes mocks con el fin de realizar Path Coverage (y Decision Coverage)
	
	// MockBordesCoverage: este mock constará de minas en las esquinas y nos permitirá expandir los bordes restantes
	
	// 11 - test para abrir una casilla del borde derecho (y comprovar su expansión)
	@Test
	public void TestPathCoverageBordeDerecha() {
		GeneradorTablero rand = new MockBordesCoverage();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(3,7);
		//comprovamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(3,7), 0);
		//comprovamos que el tablero se haya expandido correctamente
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
	
	// 12- test para abrir casilla del borde inferior (y comprovar su expansión)
	@Test 
	public void TestPathCoverageBordeInferior() {
		GeneradorTablero rand = new MockBordesCoverage();
		Tauler T = new Tauler(rand);
		T.generarTauler(0);
		T.abrirCasilla(7,4);
		//comprovamos que la casilla seleccionada se abre con el valor correcto
		assertEquals(T.getValorCasillaAbierta(7,4), 0);
		//comprovamos que el tablero se haya expandido correctamente
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
	
	// MockEsquinasCoverage: este mock no constará de minas en las esquinas y nos permitirá expandir estas
	
	// 13- test para abrir esquina inferior derecha (y comprovar su expansión) 
	@Test
	public void TestDecisionCoverageEsquinaInferiorDerecha() {
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
	
	// 14- test para abrir esquina inferior izquierda (y comprovar su expansión)
	@Test
	public void TestDecisionCoverageEsquinaInferiorIzquierda() {
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
	
	// 15- test para abrir esquina superior izquierda (y comprovar su expansión)
	@Test
	public void TestDecisionCoverageEsquinaSuperiorIzquierda() {
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
	
	//Test con generacion de tableros aleatorios siguiendo TDD
	
	// 16- test para crear tablero nivel facil aleatorio
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

    // 17- test para crear tablero nivel normal aleatorio
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

    // 18- test para crear tablero nivel dificil aleatorio
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
}
