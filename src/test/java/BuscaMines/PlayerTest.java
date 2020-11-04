package BuscaMines;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testSelectDificultadNormal() {
		Player p = new MockPlayer();
		int dificultad = 0;
		dificultad = p.seleccionarDificultad();
		assertEquals(dificultad, 1);
	}
	

	

}
