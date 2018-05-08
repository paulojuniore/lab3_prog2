package lab3_prog2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.paulo.lab3.Contato;

public class ContatoTest {
	private Contato c1;
	private Contato c2;
	private Contato c3;
	
	@Before
	public void criaContato(){
		c1 = new Contato(100, "Paulo", "Felipe Silva", "83-986614243");
		c2 = new Contato(50, "Paulo", "Junior", "83-988459039");
		c3 = new Contato(30, "Vinicius", "Barbosa Pereira", "83-982136266");
	}
	
	@Test
	public void testEqualsObject() {
		assertEquals(c1, c2);
	}
	
	@Test
	public void testNotEqualsObject() {
		assertNotEquals(c1, c3);
	}

	@Test
	public void testToString() {
		assertEquals("Paulo Felipe Silva - 83-986614243" + System.lineSeparator(), c1.toString());
		assertEquals("Paulo Junior - 83-988459039" + System.lineSeparator(), c2.toString());
	}

}
