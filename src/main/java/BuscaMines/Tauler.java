package BuscaMines;

import java.util.Random;

public class Tauler {
	private int n_Columnas;
	private int n_Filas;
	private int n_Minas;
	private Casella[][] m_Matriz;
	private static GeneradorRandom m_Rand;
	
	public Tauler()
	{
		int n_Columnas = 0;
		int n_Filas = 0;
		int n_Minas = 0;
		Casella[][] m_Matriz = null;
		m_Rand = null;
	}
	
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
		case 2://DIFICIL
			n_Filas = 16;
			n_Columnas = 30;
			n_Minas = 99;
			break;
		default:
			// missatge d'error o algo --- try catch
			break;
			
		}
		generarMatriu(n_Filas,n_Columnas);
		if(m_Rand != null) {
			// preguntar si es necesario debido al nuevo constructor del Mock
			colocarMinas();
		}
	}
	
	private void generarMatriu(int nFil,int nCol)
	{
		m_Matriz = new Casella[nFil][nCol];
	}
	
	public Casella[][] getMatriu()
	{
		return m_Matriz;
	}
	
	public Tauler(GeneradorRandom r)
	{
		int n_Columnas = 0;
		int n_Filas = 0;
		int n_Minas = 0;
		Casella[][] m_Matriz = null;
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
		for(int i = 0; i < n_Filas-1; i++) {
			for(int j = 0; j < n_Columnas-1; j++) {
				if(m_Matriz[i][j].getValor() > 8) {
					m_Matriz[i][j].setValor(9);
				}
			}
		}
	}
	
	public int getValorCasella(int fila, int columna) {
		return m_Matriz[fila][columna].getValor();
	}
}
