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
	
	// 2- TDD: test que comprueba el valor de una casilla (en este caso: no mina)
	@Test
	public void testSetCasellaLliure() {
	// Valor = 1 mina, 0 = casella lliure
		Casella C = new Casella();
		C.setValor(0);
		assertEquals(C.getValor(), 0);
	}
	
	// 3- TDD: test que comprueba si la casilla esta abierta
	@Test
	public void testSetCasellaAbierta() {
		Casella C = new Casella();
		C.setAbierta(true);;
		assertTrue(C.getAbierta());
	}
	
	// 4- TDD: test que comprueba si la casilla contiene una bandera
	@Test
	public void testSetCasellaBandera() {
		Casella C = new Casella();
		C.setBandera(true);;
		assertTrue(C.getBandera());
	}

}
