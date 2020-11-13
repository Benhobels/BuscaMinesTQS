package Controlador;

import java.util.Scanner;
import Controlador.Partida;
import Modelo.Casella;
import Modelo.GeneradorTablero;
import Modelo.TableroRandom;
import Modelo.Tauler;
import Vista.Interficie;

// clase que se encarga de controlar la interacción con el jugador
public class RealPlayer implements Partida {
	
	private Interficie Pantalla;
	
	public Tauler TableroPartida;
	private int LastRow = 0;
	private int LastCol = 0;
	
	public RealPlayer() {
		GeneradorTablero rand = new TableroRandom();
		TableroPartida = new Tauler(rand);
		Pantalla = new Interficie();
	}
	
	public void seleccionarDificultad() {
		 
		System.out.println ("Introducir dificultad: \n");
		System.out.println ("0 = Facil / 1 = Normal / 2 = Dificil \n");
		String dificultad = "";
		Scanner seleccion = new Scanner (System.in);
		dificultad = seleccion.nextLine();
		int dif = 0;
		try {
		  dif = Integer.parseInt(dificultad);
		  TableroPartida.comprobarCreacion(dif);
		} catch (NumberFormatException ex){
			return;
		}
		
	}
	
	public void seleccionarDificultadIncorrecta() {
		return;
	}
	
	public Tauler getTablero()
	{
		return TableroPartida;
	}
	
	public void seleccionarTirada() {
		int[] tirada = new int[3];
		System.out.println ("Introducir tirada: fila/columna/accion \n");
		System.out.println ("Accion: 1 = Abrir casilla / 2 = Bandera / 2 en casilla con bandera = Quitar bandera \n");
		
		String[] comandos = new String[3];
		Scanner comando = new Scanner (System.in);
		
		for (int i = 0; i < 3; i++)
		{
			comandos[i] = comando.nextLine();
			try {
			  tirada[i] = Integer.parseInt(comandos[i]);
			} catch (NumberFormatException ex){
				return;
			}
		}
	
		TableroPartida.tiradaJugador(tirada[0],tirada[1],tirada[2]);
		if(tirada[0] < TableroPartida.getFiles()+2 &&  tirada[0] > 0) {
			LastRow = tirada[0] - 1;
		}
		if(tirada[1] < TableroPartida.getColumnes()+2 &&  tirada[1] > 0) {
			LastCol = tirada[1] - 1;
		}
	}
		
	
	public void seleccionarTiradaIncorrecta() {
		return;
	}
	
	public void seleccionarTiradaBandera() {
		return;
	}
	
	public boolean FiPartida() {
		Casella [][] tableroJugador = TableroPartida.getMatriuPlayer();
		if(tableroJugador[LastRow][LastCol].getValor() == 9 && tableroJugador[LastRow][LastCol].getAbierta())
		{
			System.out.println("Has pisado una mina, has perdido!!");
			return true;
		}
		else
		{
			int casillasTotales = TableroPartida.getFiles() * TableroPartida.getColumnes();
			casillasTotales = casillasTotales - TableroPartida.getNumMines();
			if(TableroPartida.getContadorCasillasAbiertas() == casillasTotales)
			{
				System.out.println("Has abierto todas las casillas sin pisar una mina,"
						+ " has ganado!!");
				return true;
			}
		}
		return false;
		
	}

	public void mostrarTablero() {
		Pantalla.mostrarTablero(TableroPartida.getMatriuPlayer(), TableroPartida.getFiles(),TableroPartida.getColumnes());
	}
}
