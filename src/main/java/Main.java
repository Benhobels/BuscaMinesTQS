import Controlador.Partida;
import Controlador.RealPlayer;
import ScannerMock.IScanner;
import ScannerMock.RealScanner;

public class Main {
	
	public static void main(String[] args) {
		
		RealScanner sc = new RealScanner();
		
		Partida P = new RealPlayer(sc);
		
		while(P.getTablero().getFiles() == 0 && P.getTablero().getColumnes()==0)
		{
			P.seleccionarDificultad();
		}
		P.mostrarTablero();
		while(!P.FiPartida()) 
		{
			P.seleccionarTirada();
			P.mostrarTablero();
		}
	}

	
}
