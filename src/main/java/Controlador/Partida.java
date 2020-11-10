package Controlador;

import Modelo.GeneradorTablero;
import Modelo.TableroRandom;
import Modelo.Tauler;

public interface Partida {
	
	public abstract void seleccionarDificultad();
	
	public abstract Tauler getTablero();
	
	public abstract void seleccionarTirada();
	
	public abstract void seleccionarTiradaIncorrecta();

	public abstract void seleccionarDificultadIncorrecta();
	
	public abstract void seleccionarTiradaBandera();
	
	// començarPartida --> que ha de cridar el crearTauler(dificultad esollida per usuari)
	
	// gestionarSeleccio --> que haura de cridar al comprovarFila, comprovarColumna, comprovarAccio
	// ha de controlar ell les comporvacions de fila i tot aixo??
	
	// fiPartida --> que tingui el getter de la matriu jugador i busqui si s'ha destapar un 9
	
	
}
