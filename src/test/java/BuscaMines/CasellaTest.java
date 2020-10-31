package BuscaMines;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasellaTest {

	@Test
	public void testSetCasellaMina() {
	// Valor = 0...8 (numero minas alrededor), 9 (mina) 
		Casella C = new Casella();
		C.setValor(1);
		assertEquals(C.getValor(), 9);
	}
	
	@Test
	public void testSetCasellaLliure() {
	// Valor = 1 mina, 0 = casella lliure
		Casella C = new Casella();
		C.setValor(0);
		assertEquals(C.getValor(), 0);
	}

}
