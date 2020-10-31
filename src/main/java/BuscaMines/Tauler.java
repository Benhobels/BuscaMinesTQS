package BuscaMines;

import java.util.Random;

public class Tauler {
	private int n_Columnes;
	private int n_Files;
	private int n_Mines;
	private Casella[][] m_Matriu;
	
	public Tauler()
	{
		int n_Columnes = 0;
		int n_Files = 0;
		int n_Mines = 0;
		Casella[][] m_Matriu = null;
	}
	
	public int getColumnes() {
		return n_Columnes;
	}
	
	public int getFiles() {
		return n_Files;
	}
	
	public int getNumMines() {
		return n_Mines;
	}
	
	public void generarTauler(int dificultat)
	{
		switch(dificultat)
		{
		case 0: //FACIL
			n_Files = 8;
			n_Columnes = 8;
			n_Mines = 10;
			break;
		case 1://NORMAL
			n_Files = 16;
			n_Columnes = 16;
			n_Mines = 40;
			break;
		case 2://DIFICIL
			n_Files = 16;
			n_Columnes = 30;
			n_Mines = 99;
			break;
		default:
			break;
			
		}
		generarMatriu(n_Files,n_Columnes);
		//colocarMines();
	}
	
	private void generarMatriu(int nFil,int nCol)
	{
		m_Matriu = new Casella[nFil][nCol];		
	}
	
	public Casella[][] getMatriu()
	{
		return m_Matriu;
	}
	
	/*private void colocarMines()
	{
		boolean minaFicada = false;
		int filaMina = 0;
		int colMina = 0;
		Random randomFila = new Random();
		Random randomCol = new Random();
		
		for (int i = 0; i <= n_Mines; i++)
		{
			while(!minaFicada)
			{
				filaMina = randomFila.nextInt(n_Files -1);
				colMina = randomCol.nextInt(n_Columnes -1);
				if(m_Matriu[filaMina][colMina].getValor() == 0)
				{
					m_Matriu[filaMina][colMina].setValor(1);
					minaFicada = true;
				}
			}
			minaFicada = false;
		}
	}*/
}
