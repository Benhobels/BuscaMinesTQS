package Modelo;

public class Tauler {
	private int n_Columnas;
	private int n_Filas;
	private int n_Minas;
	private Casella[][] m_Matriz;
	private Casella[][] m_MatrizJugador;
	private static GeneradorTablero m_Rand;
	
	/*
	public Tauler()
	{
		n_Columnas = 0;
		n_Filas = 0;
		n_Minas = 0;
		Casella[][] m_Matriz = null;
		Casella[][] m_MatrizJugador = null;
		m_Rand = null;
	}
	NOTA: Constructor por defecto no útil debido al uso de los mocks
	*/
	
	public int getColumnes() {
		return n_Columnas;
	}
	
	public int getFiles() {
		return n_Filas;
	}
	
	public int getNumMines() {
		return n_Minas;
	}
	
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
	
	public Casella[][] getMatriu()
	{
		return m_Matriz;
	}
	
	public Casella[][] getMatriuPlayer()
	{
		return m_MatrizJugador;
	}
	
	public Tauler(GeneradorTablero r)
	{
		n_Columnas = 0;
		n_Filas = 0;
		n_Minas = 0;
		Casella[][] m_Matriz = null;
		Casella[][] m_MatrizJugador = null;
		m_Rand = r;
	}	
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
	
	private void restaurarMinas() {
		for(int i = 0; i < n_Filas; i++) {
			for(int j = 0; j < n_Columnas; j++) {
				if(m_Matriz[i][j].getValor() > 8) {
					m_Matriz[i][j].setValor(9);
				}
			}
		}
	}
	
	public int getValorCasella(int fila, int columna) {
		return m_Matriz[fila][columna].getValor();
	}
	
	private void generarMatrizJugador(int nFil,int nCol)
	{
		m_MatrizJugador = new Casella[nFil][nCol];
		for(int i = 0; i < nFil; i++)
			for(int j = 0; j < nCol; j++)
				m_MatrizJugador[i][j] = new Casella();
	}
	
	public void abrirCasilla(int fila, int col)
	{
	
		if(m_Matriz[fila][col].getValor() != 0)
		{
			//si el valor de la casilla seleccionada es diferente de 0
			if(m_MatrizJugador[fila][col].getAbierta() == false)
			{
				// si la casilla aún no se ha abierto
				m_MatrizJugador[fila][col].setValor(m_Matriz[fila][col].getValor());
				m_MatrizJugador[fila][col].setAbierta(true);
			}
			return;
		}
		
		if(m_MatrizJugador[fila][col].getAbierta() == false)
		{
			if((fila == 0 || fila == n_Filas - 1 ) && (col == 0 || col == n_Columnas -1))
			{
				//si se trata de una esquina
				m_MatrizJugador[fila][col].setAbierta(true);
				abrirEsquina(fila,col);
			}
			else 
			{
				if(fila == 0 || fila == n_Filas -1 || col == 0 || col == n_Columnas -1)
				{
					//si se trata de un borde
					m_MatrizJugador[fila][col].setAbierta(true);
					abrirBorde(fila,col);
				}
				else
				{
					//si se trata de una casilla central
					m_MatrizJugador[fila][col].setAbierta(true);
					abrirCentro(fila,col);
				}
			}			
		}	
		m_MatrizJugador[fila][col].setValor(0);
	}
	
	private void abrirEsquina(int fila, int col)
	{
		// se encarga de abrir las casillas que rodean una casilla que se encuentra en una esquina del tablero
		if(fila == 0) 
		{
			if(col == n_Columnas -1 ) 
			{
				//esquina superior derecha
				abrirCasilla(fila, col -1);
				abrirCasilla(fila+1, col);
				abrirCasilla(fila+1, col-1);
			}
			else 
			{
				//esquina superior izquierda
				abrirCasilla(fila, col+1);
				abrirCasilla(fila+1, col);
				abrirCasilla(fila+1, col+1);
			}
		}
		else 
		{
			if(col == n_Columnas -1)
			{
				//esquina inferior derecha
				abrirCasilla(fila-1, col);
				abrirCasilla(fila-1, col-1);
				abrirCasilla(fila, col-1);
			}
			else
			{
				//esquina inferior izquierda
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
			//borde superior
			abrirCasilla(fila, col +1); 
			abrirCasilla(fila, col -1); 
			abrirCasilla(fila+1, col +1);
			abrirCasilla(fila+1, col);
			abrirCasilla(fila+1, col -1);
		}
		else if(col == n_Columnas -1)
		{
			//borde derecha
			abrirCasilla(fila -1, col);
			abrirCasilla(fila -1, col -1);
			abrirCasilla(fila, col -1);
			abrirCasilla(fila +1, col);
			abrirCasilla(fila +1, col -1);
		}
		else if(fila == n_Filas -1)
		{
			//borde inferior
			abrirCasilla(fila, col +1);
			abrirCasilla(fila, col -1);
			abrirCasilla(fila -1, col +1);
			abrirCasilla(fila -1, col);
			abrirCasilla(fila -1, col -1);
		}
		else
		{
			//borde izquierda
			abrirCasilla(fila -1, col);
			abrirCasilla(fila +1, col);
			abrirCasilla(fila +1, col+1);
			abrirCasilla(fila, col+1);
			abrirCasilla(fila -1, col+1);
		}									
	}
	
	public int getValorCasillaAbierta(int fila, int columna)
	{
		return m_MatrizJugador[fila][columna].getValor();
	}
	
	public boolean getCasillaAbierta(int fila,int columna)
	{
		return m_MatrizJugador[fila][columna].getAbierta();
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
	
	public boolean comprobarDificultad(int dif)
	{
		if(dif > 2 || dif < 0)
			return false;
		return true;
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
		if(accion == 1 || accion == 2) // 1 es abrir / 2 es colocar bandera 
			return true;
		return false;
	}
	
	public void tiradaJugador(int fila, int columna, int accion)
	{
		if(comprobarFila(fila) && comprobarColumna(columna) && comprobarAccion(accion))
			//restamos 1 porque el jugdor puede escoger a partir de 1 y no de 0
			abrirCasilla(fila-1,columna-1);
	}
	
	public void comprobarCreacion(int dificultad)
	{
		if(comprobarDificultad(dificultad))
			generarTauler(dificultad);	
	}
}
