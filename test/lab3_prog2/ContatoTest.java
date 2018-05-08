package lab3_prog2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.paulo.lab3.Contato;

public class ContatoTest {
	private Contato c1;
	
	@Before
	public void criaContato(){
		Contato c1 = new Contato(100, "Pedro", "Felipe", "83-986614243");
	}
	
	@Test
	public void testContato() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		assertEquals("Pedro Felipe - 83-986614243" + System.lineSeparator(), c1.toString());
	}

}
