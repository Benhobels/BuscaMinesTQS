package ModeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Casella;

public class CasellaTest {

	// 1- TDD: test que comprueba el valor de una casilla (en este caso: mina)
	@Test
	public void testSetCasellaMina() {
	// Valor = 0...8 (numero minas alrededor), 9 (mina) 
		Casella C = new Casella();
		C.setValor(9);
		assertEquals(C.getValor(), 9);
	}
	
	// 1- TDD: test que comprueba el valor de una casilla (en este caso: no mina)
	@Test
	public void testSetCasellaLliure() {
	// Valor = 1 mina, 0 = casella lliure
		Casella C = new Casella();
		C.setValor(0);
		assertEquals(C.getValor(), 0);
	}

}
