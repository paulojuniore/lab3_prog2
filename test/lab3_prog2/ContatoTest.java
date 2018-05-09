package lab3_prog2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.paulo.lab3.Contato;
import com.paulo.lab3.Telefone;

/**
 * Classe de testes da classe Contato usando o JUnit.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

public class ContatoTest {
	private Contato c1;
	private Contato c2;
	private Contato c3;
	
	private Telefone t1;
	private Telefone t2;
	
	/**
	 * Cria objetos do tipo Telefone a partir dos construtores.
	 */
	@Before
	public void criaTelefone() {
		t1 = new Telefone("+55", "83", "98845-9039", "CASA");
		t2 = new Telefone("+55", "83", "98726-3479", "CELULAR");
	}
	
	/**
	 * Cria objetos do tipo Contato a partir dos construtores.
	 */
	@Before
	public void criaContato(){
		c1 = new Contato(100, "Paulo", "Felipe Silva", t1, 5);
		c2 = new Contato(50, "Paulo", "Junior", t2, 3);
		c3 = new Contato(30, "Vinicius", "Barbosa Pereira", t2, 1);
	}
	
	/**
	 * Testa o método equals para dois contatos.
	 * Dois contatos são iguais se possuem o mesmo nome.
	 */
	@Test
	public void testEqualsObject() {
		assertEquals(c1, c2);
	}
	
	/**
	 * Testa a negação do método equals para dois contatos.
	 */
	@Test
	public void testNotEqualsObject() {
		assertNotEquals(c1, c3);
	}

	/**
	 *  Testa o método toString da classe Contato.
	 */
	@Test
	public void testToString() {
		assertEquals("Paulo Felipe Silva - [+55 83 98845-9039, null, null] - Tipo de Amizade: Irmão" + System.lineSeparator(), c1.toString());
		assertEquals("Paulo Junior - [+55 83 98726-3479, null, null] - Tipo de Amizade: Amigo" + System.lineSeparator(), c2.toString());
	}

}
