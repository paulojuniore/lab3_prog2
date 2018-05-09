package lab3_prog2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.paulo.lab3.Agenda;
import com.paulo.lab3.Telefone;

/**
 * Classe de testes da classe Agenda usando o JUnit
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

public class AgendaTest {
	
	private Agenda a1;
	private Agenda a2;
	
	private Telefone t1;
	private Telefone t2;
	
	@Before
	public void criaTelefone() {
		t1 = new Telefone("+55", "83", "94002-8922", "TRABALHO");
		t2 = new Telefone("+55", "84", "98932-9231", "CELULAR");
	}
	
	@Before
	public void criaAgenda() {
		a1 = new Agenda();
		a2 = new Agenda();
		a2.cadastrarContato(50, "João", "Pedro", t1, 2);
	}
	
	/**
	 * Testa o cadastro de um contato em uma posição válida e vazia.
	 */
	@Test
	public void testCadastrarContatoPosVazia() {
		assertEquals(a1.cadastrarContato(66, "Jose", "Val", t2, 2),true);
	}
	
	/**
	 * Testa o cadastro de um contato em uma posição já ocupada.
	 */
	@Test
	public void testCadastrarContatoPosExistente() {
		assertEquals(a2.cadastrarContato(50, "Jose", "Val", t2, 2),true);
	}

//	@Test
//	public void testAgenda() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCadastrarContato() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testExibirContato() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testListarContatos() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testEqualsObject() {
//		fail("Not yet implemented");
//	}

}
