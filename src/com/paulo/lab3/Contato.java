package com.paulo.lab3;

import java.util.Arrays;

/**
 * Representa um Contato que faz parte de uma Agenda.
 * Todo contato possui uma posi��o, nome, sobrenome, um objeto Telefone, uma posi��o de telefone entre os 3
 * telefones poss�veis e um n�vel de amizade.
 * 
 * @author Paulo Mendes da Silva J�nior - 117210922
 *
 */
public class Contato {
		
	/**
	 * Representa a posi��o do contato na agenda.
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
	private Telefone[] telefones = new Telefone[3];
	
	/**
	 * Representa a posi��o atual do telefone
	 */
	private int posicaoTelefone = 1; 
	
	/**
	 * Representa o n�vel de Amizade do telefone (1-Distante; 2-Colega; 3-Amigo; 4-Amig�o; 5-Irm�o)
	 */
	private int nivelAmizade;
	
	/**
	 * Constr�i um contato a partir da posi��o, nome, sobrenome, telefone e n�vel de amizade.
	 * 
	 * @param posicao : indica a posi��o do contato na agenda.
	 * @param nome : nome do contato
	 * @param sobrenome : sobrenome do contato
	 * @param telefone : telefone do contato
	 * @param nivelAmizade : inteiro entre 1 e 5, inclusive. que representa o n�vel de amizade de um contato.
	 */
	public Contato(int posicao, String nome, String sobrenome, Telefone telefone, int nivelAmizade) {
		if(nome == null || sobrenome == null || telefone == null)
			throw new NullPointerException();
			
		if(nome.trim().isEmpty())
			throw new IllegalArgumentException("Nome inválido.\n");
			
		if(sobrenome.trim().isEmpty())
			throw new IllegalArgumentException("Sobrenome inválido.\n");
			
		if(telefone.getNumero().trim().isEmpty())
			throw new IllegalArgumentException("Telefone inválido.\n");
			
		if(nivelAmizade < 1 || nivelAmizade > 5)
			throw new IllegalArgumentException("Nível de amizade inválido.\n");
		
		this.posicao = posicao;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefones[0] = telefone;
		this.nivelAmizade = nivelAmizade;
	}
	
	/**
	 * Retorna a posi��o de um contato.
	 * 
	 * @return : a posi��o de um contato.
	 */
	public int getPosicao() {
		return posicao;
	}
	
	/**
	 * Altera a posi��o de um contato.
	 * 
	 * @param posicao : a posi��o de um contato na agenda.
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
	public Telefone getTelefone(int posicao) {
		return telefones[posicao];
	}
	
	/**
	 * Retorna o nivel de amizade do contato. de 1 a 5.
	 * 
	 * @return : o nivel de amizade.
	 */
	public int getNivelAmizade() {
		return nivelAmizade;
	}
	
	/**
	 * retorna o n�vel de amizade do contato.
	 * 
	 * @param nivelAmizade : representa o n�vel de amizade, inteiro entre 1 e 5, inclusive.
	 * 
	 * @return : Retorna uma String do nivel de amizade. 
	 */
	private static String tipoNivelAmizade(int nivelAmizade) {
		switch(nivelAmizade) {
			case 1: return "Distante";
			case 2: return "Colega";
			case 3: return "Amigo";
			case 4: return "Amig�o";
			case 5: return "Irm�o";
			default: return "";
		}
	}
	
	/**
	 * Vincula um novo numero de telefone a um contato j� existente.
	 * 
	 * @param telefone : representa um objeto Telefone que cont�m todas as informa��es de um contato.
	 * 
	 * @return : um boolean que representa o �xito ou n�o na opera��o.
	 */
	public boolean insereContato(Telefone telefone) {
		if(posicaoTelefone < 3) {
			telefones[posicaoTelefone++] = telefone;
			return true;
		}
		return false;
	}
	
	/**
	 * Sobrescreve o m�todo equals. 
	 * Verifica a igualdade de dois contatos a partir do nome.
	 * 
	 * @param contato : recebe um objeto de um tipo mais geral.
	 * @return : um boolean que representa a igualdade entre dois contatos. Dois contatos s�o iguais se possuem o mesmo nome. 
	 */
	@Override
	public boolean equals(Object contato) {
		return this.nome.equals(((Contato) contato).getNome());
	}
	
	/**
	 * Representa��o String de um objeto Contato no formato: NOME SOBRENOME - [TELEFONES..] - NIVEL DE AMIZADE
	 */
	@Override
	public String toString() {
		return String.format("%s %s - %s - Tipo de Amizade: %s" + System.lineSeparator(), this.nome, this.sobrenome, Arrays.toString(telefones),
				tipoNivelAmizade(nivelAmizade));
	}
	
}
