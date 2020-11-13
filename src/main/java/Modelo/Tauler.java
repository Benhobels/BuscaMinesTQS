package Modelo;

public class Tauler {
	private int n_Columnas;
	private int n_Filas;
	private int n_Minas;
	private Casella[][] m_Matriz;
	private Casella[][] m_MatrizJugador;
	private static GeneradorTablero m_Rand;
	private int n_contadorCasillasAbiertas;
	
	// constructor de Tauler: el parámetro "r" permite el uso de los distintos mocks para el testing
	public Tauler(GeneradorTablero r)
	{
		n_Columnas = 0;
		n_Filas = 0;
		n_Minas = 0;
		Casella[][] m_Matriz = null;
		Casella[][] m_MatrizJugador = null;
		m_Rand = r;
		n_contadorCasillasAbiertas = 0;
		
	}	
	
	// getters:
	public int getColumnes() {
		return n_Columnas;
	}
	
	public int getFiles() {
		return n_Filas;
	}
	
	public int getNumMines() {
		return n_Minas;
	}
	
	// getter que devuelve el tablero con los valores de la partida
	public Casella[][] getMatriu()
	{
		return m_Matriz;
	}
	
	// getter que devuelve el tablero que ve el jugador
	public Casella[][] getMatriuPlayer()
	{
		return m_MatrizJugador;
	}
	
	public int getValorCasella(int fila, int columna) {
		return m_Matriz[fila][columna].getValor();
	}
	
	// getter que devuelve el numero de casillas abiertas por el jugador (sin contar minas)
	public int getContadorCasillasAbiertas()
	{
		return n_contadorCasillasAbiertas;
	}
	
	// getter que devuelve el valor de una casilla abierta por el usuario
	public int getValorCasillaAbierta(int fila, int columna)
	{
		return m_MatrizJugador[fila][columna].getValor();
	}
	
	// getter que devuelve si la casilla ha sido abierta por el jugador
	public boolean getCasillaAbierta(int fila,int columna)
	{
		return m_MatrizJugador[fila][columna].getAbierta();
	}
	
	// genera el tablero de la partida en función de la dificultad escogida
	public void generarTauler(int dificultat)
	{
		switch(dificultat)
		{
		case 0: //FACIL
			n_Filas = 8;
			n_Columnas = 8;
			n_Minas = 10;
			break;
		case 1://NORMAL
			n_Filas = 16;
			n_Columnas = 16;
			n_Minas = 40;
			break;
		default://DIFICIL
			n_Filas = 16;
			n_Columnas = 30;
			n_Minas = 99;
			break;
		}
		generarMatriu(n_Filas,n_Columnas);
		generarMatrizJugador(n_Filas,n_Columnas);
		colocarMinas();
	}
	
	private void generarMatriu(int nFil,int nCol)
	{
		m_Matriz = new Casella[nFil][nCol];
	}
	
	private void generarMatrizJugador(int nFil,int nCol)
	{
		m_MatrizJugador = new Casella[nFil][nCol];
		for(int i = 0; i < nFil; i++)
			for(int j = 0; j < nCol; j++)
				m_MatrizJugador[i][j] = new Casella();
	}
	
	// colocarMinas(): se encarga de colocar las minas en el tablero a través del TableroRandom o de un mock
	private void colocarMinas() {
		m_Matriz = m_Rand.generarMinas(n_Filas, n_Columnas, n_Minas);
		colocarEsquinas();
		colocarBordes();
		colocarAlrededores();
		restaurarMinas();
	}
	
	private void colocarEsquinas() {
		// se encarga de generar los valores de alrededor de las minas situadas en las esquinas
		if(m_Matriz[0][0].getValor() > 8) {
			// esquina superior izquierda
			m_Matriz[0][1].setValor(m_Matriz[0][1].getValor()+1);
			m_Matriz[1][0].setValor(m_Matriz[1][0].getValor()+1);
			m_Matriz[1][1].setValor(m_Matriz[1][1].getValor()+1);
		}
		if(m_Matriz[0][n_Columnas-1].getValor() > 8) {
			// esquina superior derecha
			m_Matriz[0][n_Columnas-2].setValor(m_Matriz[0][n_Columnas-2].getValor()+1);
			m_Matriz[1][n_Columnas-1].setValor(m_Matriz[1][n_Columnas-1].getValor()+1);
			m_Matriz[1][n_Columnas-2].setValor(m_Matriz[1][n_Columnas-2].getValor()+1);
		}
		if(m_Matriz[n_Filas-1][0].getValor() > 8) {
			// esquina inferior izquierda
			m_Matriz[n_Filas-2][0].setValor(m_Matriz[n_Filas-2][0].getValor()+1);
			m_Matriz[n_Filas-1][1].setValor(m_Matriz[n_Filas-1][1].getValor()+1);
			m_Matriz[n_Filas-2][1].setValor(m_Matriz[n_Filas-2][1].getValor()+1);
		}
		if(m_Matriz[n_Filas-1][n_Columnas-1].getValor() > 8) {
			// esquina inferior derecha
			m_Matriz[n_Filas-1][n_Columnas-2].setValor(m_Matriz[n_Filas-1][n_Columnas-2].getValor()+1);
			m_Matriz[n_Filas-2][n_Columnas-2].setValor(m_Matriz[n_Filas-2][n_Columnas-2].getValor()+1);
			m_Matriz[n_Filas-2][n_Columnas-1].setValor(m_Matriz[n_Filas-2][n_Columnas-1].getValor()+1);
		}
	}
	
	private void colocarBordes() {
		// se encarga de generar los valores de alrededor de las minas situadas en los bordes
		for(int j = 1; j < n_Columnas-1; j++) {
			if(m_Matriz[0][j].getValor() > 8) {
				// borde superior (sin esquinas)
				m_Matriz[0][j-1].setValor(m_Matriz[0][j-1].getValor()+1);
				m_Matriz[0][j+1].setValor(m_Matriz[0][j+1].getValor()+1);
				m_Matriz[1][j-1].setValor(m_Matriz[1][j-1].getValor()+1);
				m_Matriz[1][j].setValor(m_Matriz[1][j].getValor()+1);
				m_Matriz[1][j+1].setValor(m_Matriz[1][j+1].getValor()+1);
			}
			if(m_Matriz[n_Filas-1][j].getValor() > 8) {
				// borde inferior (sin esquinas)
				m_Matriz[n_Filas-1][j-1].setValor(m_Matriz[n_Filas-1][j-1].getValor()+1);
				m_Matriz[n_Filas-1][j+1].setValor(m_Matriz[n_Filas-1][j+1].getValor()+1);
				m_Matriz[n_Filas-2][j-1].setValor(m_Matriz[n_Filas-2][j-1].getValor()+1);
				m_Matriz[n_Filas-2][j].setValor(m_Matriz[n_Filas-2][j].getValor()+1);
				m_Matriz[n_Filas-2][j+1].setValor(m_Matriz[n_Filas-2][j+1].getValor()+1);
			}
		}
		for(int i = 1; i < n_Filas-1; i++) {
			if(m_Matriz[i][0].getValor() > 8) {
				// borde izquierdo (sin esquinas)
				m_Matriz[i-1][0].setValor(m_Matriz[i-1][0].getValor()+1);
				m_Matriz[i+1][0].setValor(m_Matriz[i+1][0].getValor()+1);
				m_Matriz[i-1][1].setValor(m_Matriz[i-1][1].getValor()+1);
				m_Matriz[i][1].setValor(m_Matriz[i][1].getValor()+1);
				m_Matriz[i+1][1].setValor(m_Matriz[i+1][1].getValor()+1);
			}
			if(m_Matriz[i][n_Columnas-1].getValor() > 8) {
				// borde derecho (sin esquinas)
				m_Matriz[i-1][n_Columnas-1].setValor(m_Matriz[i-1][n_Columnas-1].getValor()+1);
				m_Matriz[i+1][n_Columnas-1].setValor(m_Matriz[i+1][n_Columnas-1].getValor()+1);
				m_Matriz[i-1][n_Columnas-2].setValor(m_Matriz[i-1][n_Columnas-2].getValor()+1);
				m_Matriz[i][n_Columnas-2].setValor(m_Matriz[i][n_Columnas-2].getValor()+1);
				m_Matriz[i+1][n_Columnas-2].setValor(m_Matriz[i+1][n_Columnas-2].getValor()+1);
			}
		}
	}
	
	private void colocarAlrededores() {
		for(int i = 1; i < n_Filas-1; i++) {
			for(int j = 1; j < n_Columnas-1; j++) {
				if(m_Matriz[i][j].getValor() > 8) {
					// posiciones centrales 
					m_Matriz[i-1][j-1].setValor(m_Matriz[i-1][j-1].getValor()+1);
					m_Matriz[i-1][j].setValor(m_Matriz[i-1][j].getValor()+1);
					m_Matriz[i-1][j+1].setValor(m_Matriz[i-1][j+1].getValor()+1);
					m_Matriz[i][j-1].setValor(m_Matriz[i][j-1].getValor()+1);
					m_Matriz[i][j+1].setValor(m_Matriz[i][j+1].getValor()+1);
					m_Matriz[i+1][j-1].setValor(m_Matriz[i+1][j-1].getValor()+1);
					m_Matriz[i+1][j].setValor(m_Matriz[i+1][j].getValor()+1);
					m_Matriz[i+1][j+1].setValor(m_Matriz[i+1][j+1].getValor()+1);
				}
			}
		}
	}
	
	// se encarga de asegurar que el valor de las minas sea 9
	private void restaurarMinas() {
		for(int i = 0; i < n_Filas; i++) {
			for(int j = 0; j < n_Columnas; j++) {
				if(m_Matriz[i][j].getValor() > 8) {
					m_Matriz[i][j].setValor(9);
				}
			}
		}
	}
	
	public void abrirCasilla(int fila, int col)
	{
	
		if(m_Matriz[fila][col].getValor() != 0)
		{
			//si el valor de la casilla seleccionada es diferente de 0
			if(m_MatrizJugador[fila][col].getAbierta() == false && m_MatrizJugador[fila][col].getBandera() == false)
			{
				// si la casilla aún no se ha abierto
				m_MatrizJugador[fila][col].setValor(m_Matriz[fila][col].getValor());
				m_MatrizJugador[fila][col].setAbierta(true);
				n_contadorCasillasAbiertas = n_contadorCasillasAbiertas + 1;
			}
			return;
		}
		
		if(m_MatrizJugador[fila][col].getAbierta() == false)
		{
			if((fila == 0 || fila == n_Filas - 1 ) && (col == 0 || col == n_Columnas -1))
			{
				// si se trata de una esquina
				m_MatrizJugador[fila][col].setAbierta(true);
				n_contadorCasillasAbiertas = n_contadorCasillasAbiertas + 1;
				abrirEsquina(fila,col);
			}
			else 
			{
				if(fila == 0 || fila == n_Filas -1 || col == 0 || col == n_Columnas -1)
				{
					// si se trata de un borde
					m_MatrizJugador[fila][col].setAbierta(true);
					n_contadorCasillasAbiertas = n_contadorCasillasAbiertas + 1;
					abrirBorde(fila,col);
				}
				else
				{
					// si se trata de una casilla central
					m_MatrizJugador[fila][col].setAbierta(true);
					n_contadorCasillasAbiertas = n_contadorCasillasAbiertas + 1;
					abrirCentro(fila,col);
				}
			}			
		}	
	}
	
	private void abrirEsquina(int fila, int col)
	{
		// se encarga de abrir las casillas que rodean una casilla que se encuentra en una esquina del tablero
		if(fila == 0) 
		{
			if(col == n_Columnas -1 ) 
			{
				// esquina superior derecha
				abrirCasilla(fila, col -1);
				abrirCasilla(fila+1, col);
				abrirCasilla(fila+1, col-1);
			}
			else 
			{
				// esquina superior izquierda
				abrirCasilla(fila, col+1);
				abrirCasilla(fila+1, col);
				abrirCasilla(fila+1, col+1);
			}
		}
		else 
		{
			if(col == n_Columnas -1)
			{
				// esquina inferior derecha
				abrirCasilla(fila-1, col);
				abrirCasilla(fila-1, col-1);
				abrirCasilla(fila, col-1);
			}
			else
			{
				// esquina inferior izquierda
				abrirCasilla(fila-1, col);
				abrirCasilla(fila-1, col+1);
				abrirCasilla(fila, col+1);
			}
		}	
	}
	
	private void abrirBorde(int fila, int col)
	{
		// se encarga de abrir las casillas que rodean una casilla de algun borde del tablero
		if(fila == 0)
		{
			// borde superior
			abrirCasilla(fila, col +1); 
			abrirCasilla(fila, col -1); 
			abrirCasilla(fila+1, col +1);
			abrirCasilla(fila+1, col);
			abrirCasilla(fila+1, col -1);
		}
		else if(col == n_Columnas -1)
		{
			// borde derecha
			abrirCasilla(fila -1, col);
			abrirCasilla(fila -1, col -1);
			abrirCasilla(fila, col -1);
			abrirCasilla(fila +1, col);
			abrirCasilla(fila +1, col -1);
		}
		else if(fila == n_Filas -1)
		{
			// borde inferior
			abrirCasilla(fila, col +1);
			abrirCasilla(fila, col -1);
			abrirCasilla(fila -1, col +1);
			abrirCasilla(fila -1, col);
			abrirCasilla(fila -1, col -1);
		}
		else
		{
			// borde izquierda
			abrirCasilla(fila -1, col);
			abrirCasilla(fila +1, col);
			abrirCasilla(fila +1, col+1);
			abrirCasilla(fila, col+1);
			abrirCasilla(fila -1, col+1);
		}									
	}
	
	private void abrirCentro(int fila, int col)
	{
		// se encarga de abrir las casillas que rodean una casilla central
		abrirCasilla(fila-1, col-1);
		abrirCasilla(fila-1, col);
		abrirCasilla(fila-1, col+1);
		abrirCasilla(fila, col-1);
		abrirCasilla(fila, col+1);
		abrirCasilla(fila+1, col-1);
		abrirCasilla(fila+1, col);
		abrirCasilla(fila+1, col+1);
	}
	
	// comporbarX(): se encargan de comprovar que los valores introducidos por el usuario sean válidos
	public boolean comprobarDificultad(int dif)
	{
		if(dif > 2 || dif < 0)
			return false;
		return true;
	}
	
	public void comprobarCreacion(int dificultad)
	{
		// se encarga de generar el tablero en función de la dificultad escogida
		if(comprobarDificultad(dificultad))
			generarTauler(dificultad);	
	}
	
	public boolean comprobarFila(int fila)
	{
		if(fila > 0 && fila <= n_Filas)
			return true;
		return false;
	}
	
	public boolean comprobarColumna(int col)
	{
		if(col > 0 && col <= n_Columnas)
			return true;
		return false;
	}
	
	public boolean comprobarAccion(int accion)
	{
		// 1 = abrir casilla, 2 = colocar/quitar bandera
		if(accion == 1 || accion == 2) 
			return true;
		return false;
	}
	
	// se encarga de llevar a cabo la tirada del jugador
	public void tiradaJugador(int fila, int columna, int accion)
	{
		if(comprobarFila(fila) && comprobarColumna(columna) && comprobarAccion(accion)) {
			//restamos 1 porque el jugdor puede escoger a partir de 1 (y no de 0)
			if(accion == 1)
				abrirCasilla(fila-1,columna-1);
			else {
				// corresponde a poner/quitar una bandera
				if(!m_MatrizJugador[fila-1][columna-1].getBandera() && !m_MatrizJugador[fila-1][columna-1].getBandera())
						colocarBandera(fila-1,columna-1);
				else
					quitarBandera(fila-1,columna-1);
			}
		}
	}
	
	
	private void colocarBandera(int fila,int columna)
	{
		m_MatrizJugador[fila][columna].setBandera(true);
	}
	
	private void quitarBandera(int fila,int columna)
	{
		m_MatrizJugador[fila][columna].setBandera(false);
	}

}
