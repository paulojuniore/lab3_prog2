package lab3_prog2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

import com.paulo.lab3.Telefone;

/**
 * Classe de testes da classe Telefone usando o JUnit.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 * 
 */

public class TelefoneTest {

	Telefone t1;
	Telefone t2;
	Telefone t3;
	
	/**
	 * Criando os telefones
	 */
	@Before
	public void criandoTelefone() {
		t1 = new Telefone("+55", "83", "98845-9039", "CASA");
		t2 = new Telefone("+55", "83", "98726-2172", "TRABALHO");
		t3 = new Telefone("+55", "83", "98845-9039", "CELULAR");
	}
	
	/**
	 * Testa o método toString.
	 */
	@Test
	public void testToString() {
		assertEquals("+55 83 98845-9039", t1.toString());
	}
	
	/**
	 * Testa se dois telefones são iguais. (numero e o ddd são iguais)
	 */
	@Test
	public void testEqualsObject() {
		assertEquals(t1, t3);
	}
	
	/**
	 * Testa se dois telefones são diferentes. (numero e ddd são diferentes)
	 */
	@Test
	public void testNotEqualsObject() {
		assertNotEquals(t1, t2);
	}

	/**
	 * Testa o construtor com o codigoPais nulo.
	 */
	@Test(expected=NullPointerException.class)
	public void testTelefoneCodigoPaisNulo() {
		Telefone telefone = new Telefone(null, "83", "88459039","CELULAR");
	}
	
	/**
	 * Testa o construtor com o codigoPais inválido.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testTelefoneCodigoPaisInvalido() {
		Telefone telefone = new Telefone("", "83", "88459039","CASA");
	}
	
	/**
	 * Testa o construtor com o ddd nulo.
	 */
	@Test(expected=NullPointerException.class)	
	public void testTelefoneDddNulo() {
		Telefone telefone = new Telefone("+55", null, "88459039","TRABALHO");
	}
	
	/**
	 * Testa o construtor com o numero nulo.
	 */
	@Test(expected=NullPointerException.class)
	public void testTelefoneNumeroNulo() {
		Telefone telefone = new Telefone("+55", "83", null,"CASA");
	}
	
	/**
	 * Testa o construtor com o numero inválido.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testTelefoneNumeroInvalido() {
		Telefone telefone = new Telefone("+55", "83", "787-9","CELULAR");
	}
	
	/**
	 * Testa o construtor com o tipo nulo.
	 */
	@Test(expected=NullPointerException.class)
	public void testTelefoneTipoNulo() {
		Telefone telefone = new Telefone("+55", "83", "88459039", null);
	}
	
	/**
	 * Testa o construtor com o tipo inválido.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testTelefoneTipoInvalido() {
		Telefone telefone = new Telefone("+55", "83", "884549032", "EVERYTHING");
	}

}
