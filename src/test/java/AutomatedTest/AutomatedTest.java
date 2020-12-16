package AutomatedTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Controlador.Partida;
import Controlador.RealPlayer;
import ScannerMock.IScanner;
import ScannerMock.ScannerMock;

public class AutomatedTest {

	private void mostrarPartida(Partida p) {

		p.seleccionarDificultad();
		
		p.mostrarTablero();
		while(!p.FiPartida()) 
		{
			p.seleccionarTirada();
			
			p.mostrarTablero();
		}
		
		
	}
	
	private void abrirCasilla(ScannerMock sc, String fila, String col) {
		sc.addLine(fila);
		sc.addLine(col);
		sc.addLine("1");
	}
	private void ponerBandera(ScannerMock sc, String fila, String col) {
		sc.addLine(fila);
		sc.addLine(col);
		sc.addLine("2");
	}
	@Test
	public void ganarPartida() {
		ScannerMock sc = new ScannerMock();
		Partida p = new RealPlayer(sc);
		//seleccionar dificultad
		sc.addLine("0");
		
		abrirCasilla(sc, "3", "3");	
		
		ponerBandera(sc, "1", "1");
		ponerBandera(sc, "5", "3");
		
		abrirCasilla(sc, "7", "1");
		abrirCasilla(sc, "8", "1");		
		abrirCasilla(sc, "8", "2");		
		
		ponerBandera(sc, "7", "2");		
		
		abrirCasilla(sc, "6", "3");		
		abrirCasilla(sc, "7", "3");		
		abrirCasilla(sc, "8", "3");		
		abrirCasilla(sc, "7", "4");		
		abrirCasilla(sc, "6", "4");		
		abrirCasilla(sc, "8", "4");		
		abrirCasilla(sc, "5", "4");		
		
		ponerBandera(sc, "1", "5");		
		ponerBandera(sc, "2", "5");		
		
		abrirCasilla(sc, "3", "5");		
		abrirCasilla(sc, "1", "8");		
		abrirCasilla(sc, "8", "5");		
		abrirCasilla(sc, "4", "5");		
		abrirCasilla(sc, "5", "5");		
		abrirCasilla(sc, "6", "5");	
		
		ponerBandera(sc, "7", "5");		
		
		abrirCasilla(sc, "6", "6");		
		abrirCasilla(sc, "7", "6");		
		abrirCasilla(sc, "8", "6");		
		abrirCasilla(sc, "6", "7");		
		abrirCasilla(sc, "6", "8");		
		abrirCasilla(sc, "7", "8");		
		abrirCasilla(sc, "8", "8");		
		abrirCasilla(sc, "7", "7");	
		
		
		ponerBandera(sc, "8", "7");		
		
		abrirCasilla(sc, "5", "6");
		abrirCasilla(sc, "5", "7");		
		
		ponerBandera(sc, "5", "8");
		ponerBandera(sc, "4", "6");
		
		abrirCasilla(sc, "3", "6");
		abrirCasilla(sc, "3", "7");
		
		ponerBandera(sc, "3", "8");
		
		abrirCasilla(sc, "4", "7");
		abrirCasilla(sc, "4", "8");
		
		mostrarPartida(p);

		assertTrue(p.FiPartida());
		
	}
	
	@Test
	public void perderPartida() {
		ScannerMock sc = new ScannerMock();
		Partida p = new RealPlayer(sc);
		//seleccionar dificultad
		sc.addLine("0");
		
		abrirCasilla(sc, "3", "3");	
		
		ponerBandera(sc, "1", "1");
		ponerBandera(sc, "5", "3");
		
		abrirCasilla(sc, "7", "1");
		abrirCasilla(sc, "8", "1");		
		abrirCasilla(sc, "8", "2");		
		
		ponerBandera(sc, "7", "2");		
		
		abrirCasilla(sc, "6", "3");		
		abrirCasilla(sc, "7", "3");		
		abrirCasilla(sc, "8", "3");		
		abrirCasilla(sc, "7", "4");		
		abrirCasilla(sc, "6", "4");		
		abrirCasilla(sc, "8", "4");		
		abrirCasilla(sc, "5", "4");		
		
		ponerBandera(sc, "1", "5");		
		ponerBandera(sc, "2", "5");		
		
		abrirCasilla(sc, "3", "5");		
		abrirCasilla(sc, "1", "8");		
		abrirCasilla(sc, "8", "5");		
		abrirCasilla(sc, "4", "5");		
		abrirCasilla(sc, "5", "5");		
		abrirCasilla(sc, "6", "5");	
		
		ponerBandera(sc, "7", "5");		
		
		abrirCasilla(sc, "6", "6");		
		abrirCasilla(sc, "7", "6");		
		abrirCasilla(sc, "8", "6");		
		abrirCasilla(sc, "6", "7");		
		abrirCasilla(sc, "6", "8");		
		abrirCasilla(sc, "7", "8");		
		abrirCasilla(sc, "8", "8");		
		abrirCasilla(sc, "7", "7");		
		
		abrirCasilla(sc, "8", "7");
		
		mostrarPartida(p);

		assertTrue(p.FiPartida());
		
	}
	
	@Test
	public void ganarPartidaSinBanderas() {
		ScannerMock sc = new ScannerMock();
		Partida p = new RealPlayer(sc);
		//seleccionar dificultad
		sc.addLine("0");
		
		abrirCasilla(sc, "3", "3");
		abrirCasilla(sc, "7", "1");
		abrirCasilla(sc, "8", "1");		
		abrirCasilla(sc, "8", "2");
		abrirCasilla(sc, "6", "3");		
		abrirCasilla(sc, "7", "3");		
		abrirCasilla(sc, "8", "3");		
		abrirCasilla(sc, "7", "4");		
		abrirCasilla(sc, "6", "4");		
		abrirCasilla(sc, "8", "4");		
		abrirCasilla(sc, "5", "4");
		abrirCasilla(sc, "3", "5");		
		abrirCasilla(sc, "1", "8");		
		abrirCasilla(sc, "8", "5");		
		abrirCasilla(sc, "4", "5");		
		abrirCasilla(sc, "5", "5");		
		abrirCasilla(sc, "6", "5");
		abrirCasilla(sc, "6", "6");		
		abrirCasilla(sc, "7", "6");		
		abrirCasilla(sc, "8", "6");		
		abrirCasilla(sc, "6", "7");		
		abrirCasilla(sc, "6", "8");		
		abrirCasilla(sc, "7", "8");		
		abrirCasilla(sc, "8", "8");		
		abrirCasilla(sc, "7", "7");
		abrirCasilla(sc, "5", "6");
		abrirCasilla(sc, "5", "7");	
		abrirCasilla(sc, "3", "6");
		abrirCasilla(sc, "3", "7");		
		abrirCasilla(sc, "4", "7");
		abrirCasilla(sc, "4", "8");
		
		mostrarPartida(p);
		
		assertTrue(p.FiPartida());
	}
	
	@Test
	public void perderPartidaSinBanderas() {
		ScannerMock sc = new ScannerMock();
		Partida p = new RealPlayer(sc);
		//seleccionar dificultad
		sc.addLine("0");
		
		abrirCasilla(sc, "3", "3");	
		abrirCasilla(sc, "7", "1");
		abrirCasilla(sc, "8", "1");		
		abrirCasilla(sc, "8", "2");	
		abrirCasilla(sc, "6", "3");		
		abrirCasilla(sc, "7", "3");		
		abrirCasilla(sc, "8", "3");		
		abrirCasilla(sc, "7", "4");		
		abrirCasilla(sc, "6", "4");		
		abrirCasilla(sc, "8", "4");		
		abrirCasilla(sc, "5", "4");
		abrirCasilla(sc, "3", "5");		
		abrirCasilla(sc, "1", "8");	
		abrirCasilla(sc, "7", "5");
		
		
		mostrarPartida(p);
		
		assertTrue(p.FiPartida());
	}
}
