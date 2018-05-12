package lab3_prog2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
		a2.cadastrarContato(50, "Filipe", "Gomes", t1, 2);
	}
	
	@Before
	public void criaAgendaDiferente() {
		a2 = new Agenda();
		a2.cadastrarContato(24, "Paulo", "Junior", t1, 2);
	}
	
	/**
	 * Testa o cadastro de um contato em uma posição válida e vazia.
	 */
	@Test
	public void testCadastrarContatoPosVazia() {
		assertEquals(a2.cadastrarContato(33, "Jose", "Val", t2, 2), true);
	}
	
	/**
	 * Testa o cadastro de um contato em uma posição já ocupada.
	 */
	@Test
	public void testCadastrarContatoPosExistente() {
		assertEquals(a2.cadastrarContato(20, "Jose", "Val", t2, 2), true);
	}
	
	/**
	 * Testa o cadastro de um contato em uma posição inválida.
	 */
	@Test
	public void testCadastrarContatoPosInvalida() {
		assertEquals(a1.cadastrarContato(0, "Paulo", "Jr", t1, 2), false);
	}
	
	/**
	 * Testa o cadastro de um contato em uma posição válida.
	 */
	public void testCadastrarContatoValida() {
		assertEquals(a1.cadastrarContato(100, "Junior", "Pereira", t1, 5), true);
	}
	
	/**
	 * Testa o método listarContatos.
	 */
	@Test
	public void testListarContatos() {
		a2.cadastrarContato(9, "Julio", "Garcia", t2, 2);
		a2.cadastrarContato(10, "Leo", "Messi", t1, 2);
		System.out.println(a2.listarContatos());
		assertEquals(a2.listarContatos(), "9 - Julio Garcia\n10 - Leo Messi\n50 - Filipe Gomes\n");
	}

	/**
	 * Testa o método equals.
	 * Duas agendas são iguais se tiverem os mesmos contatos nas mesmas posi��es.
	 */
	@Test
	public void testEqualsObject() {
		assertNotEquals(a1, a2);
	}
	
}
