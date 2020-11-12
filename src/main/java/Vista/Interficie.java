package Vista;

import Modelo.Casella;

public class Interficie {
	
	public void mostrarTablero(Casella[][] tablero, int filas, int columnas)
	{
		System.out.print("     ");
		for(int x = 0; x < columnas; x++) {
			System.out.print((x+1) + "  ");
			if((x+1) < 10) {
				System.out.print(" ");
			}
		}
		System.out.println();
		for (int i = 0; i < filas; i++)
		{
			if(filas == 8 && columnas == 8) {
				System.out.println("   -------------------------------- ");
			}
			else if(filas == 16 && columnas == 16){
				System.out.println("   -----------------------------------------------------------------");
			}
			else {
				System.out.println("   ------------------------------------------------------------------------------------------------------------------------");
			}
			System.out.print(i+1 + " ");
			if((i+1) < 10)
				System.out.print(" ");
			for(int j= 0; j < columnas; j++)
			{
				System.out.print("| ");
				if(!tablero[i][j].getBandera())
				{
					if(tablero[i][j].getValor() != 0 && tablero[i][j].getAbierta()) 
					{
						if(tablero[i][j].getValor() == 9)
							System.out.print("* ");
						else
							System.out.print(tablero[i][j].getValor() + " ");
					}
					else
						if(tablero[i][j].getAbierta())
							System.out.print("  ");
						else
							System.out.print("X ");
				}
				else
					System.out.print("P ");
			}
			System.out.println("|");
		}
		if(filas == 8 && columnas == 8) {
			System.out.println("   -------------------------------- ");
		}
		else if(filas == 16 && columnas == 16){
			System.out.println("   -----------------------------------------------------------------");
		}
		else {
			System.out.println("   ------------------------------------------------------------------------------------------------------------------------");
		}
	}
}
