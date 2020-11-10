package Vista;

import Modelo.Casella;

public class Interficie {
	
	public void mostrarTablero(Casella[][] tablero, int filas, int columnas)
	{
		for (int i = 0; i < filas; i++)
		{
			System.out.println("------------------------------------------- \n");
			for(int j= 0; j < columnas; j++)
			{
				System.out.println("| ");
				if(tablero[i][j].getValor() != 0 && tablero[i][j].getAbierta()) 
				{
					if(tablero[i][j].getValor() == 9)
						System.out.println("* ");
					else
						System.out.println(tablero[i][j].getValor());
				}
				else
					if(tablero[i][j].getAbierta())
						System.out.println("  ");
					else
						System.out.println("X ");
			}
			System.out.println(" |");
		}
			
		
	}
}
