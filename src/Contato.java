
/**
 * Representa um Contato que faz parte de uma Agenda.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */
public class Contato {
		
	/**
	 * Representa a posição do contato na agenda.
	 */
	private int posicao;
	
	/**
	 * Representa o nome do contato na agenda.
	 */
	private String nome;
	
	/**
	 * Representa o sobrenome do contato na agenda.
	 */
	private String sobrenome;
	
	/**
	 * Representa o telefone do contato na agenda.
	 */
	private String telefone;
	
	/**
	 * Constrói um contato a partir do nome, sobrenome e telefone.
	 * 
	 * @param nome : nome do contato
	 * @param sobrenome : sobrenome do contato
	 * @param telefone : telefone do contato
	 */
	public Contato(int posicao, String nome, String sobrenome, String telefone) {
		this.posicao = posicao;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	/**
	 * Retorna a posição de um contato.
	 * 
	 * @return : a posição de um contato.
	 */
	public int getPosicao() {
		return posicao;
	}
	
	/**
	 * Altera a posição de um contato.
	 * 
	 * @param posicao : a posição de um contato na agenda.
	 */
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	/**
	 * Retorna o nome de um contato.
	 * 
	 * @return : o nome do contato.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Altera o nome do contato.
	 * 
	 * @param nome : nome do contato.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o sobrenome do contato.
	 * 
	 * @return : o sobrenome do contato.
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	
	/**
	 * Altera o sobrenome do contato.
	 * 
	 * @param sobrenome : sobrenome do contato.
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	/**
	 * Retorna o telefone do contato.
	 * 
	 * @return : o telefone do contato.
	 */
	public String getTelefone() {
		return telefone;
	}
	
	/**
	 * Altera o telefone do contato.
	 * 
	 * @param telefone : telefone do contato.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * Sobrescreve o método equals. 
	 * Verifica a igualdade de dois contatos.
	 * 
	 * @param contato : recebe um objeto de um tipo mais geral.
	 * @return : um boolean que representa a igualdade entre dois contatos. 
	 */
	@Override
	public boolean equals(Object contato) {
		return this.nome.equals(((Contato) contato).getNome());
	}
	
	/**
	 * Representação String de um objeto Contato no formato: NOME SOBRENOME - TELEFONE
	 */
	public String toString() {
		return String.format("%s %s - %s%n", nome, sobrenome, telefone);
	}
	
}
