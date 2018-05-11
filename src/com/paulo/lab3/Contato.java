package com.paulo.lab3;

import java.util.Arrays;

/**
 * Representa um Contato que faz parte de uma Agenda.
 * Todo contato possui uma posição, nome, sobrenome, um objeto Telefone, uma posição de telefone entre os 3
 * telefones possíveis e um nível de amizade.
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
	private Telefone[] telefones = new Telefone[3];
	
	/**
	 * Representa a posição atual do telefone na agenda.
	 */
	private int posicaoTelefone = 1; 
	
	/**
	 * Representa o nível de Amizade do telefone (1-Distante; 2-Colega; 3-Amigo; 4-Amigão; 5-Irmão)
	 */
	private int nivelAmizade;
	
	
	/**
	 * Constrói um contato a partir da posição, nome, sobrenome, telefone e nível de amizade.
	 * 
	 * @param posicao : indica a posição do contato na agenda.
	 * @param nome : nome do contato
	 * @param sobrenome : sobrenome do contato
	 * @param telefone : telefone do contato
	 * @param nivelAmizade : inteiro entre 1 e 5, inclusive. que representa o nível de amizade de um contato.
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
	 * retorna o nível de amizade do contato.
	 * 
	 * @param nivelAmizade : representa o nível de amizade, inteiro entre 1 e 5, inclusive.
	 * 
	 * @return : Retorna uma String do nivel de amizade. 
	 */
	private static String tipoNivelAmizade(int nivelAmizade) {
		switch(nivelAmizade) {
			case 1: return "Distante";
			case 2: return "Colega";
			case 3: return "Amigo";
			case 4: return "Amigão";
			case 5: return "Irmão";
			default: return "";
		}
	}
	
	/**
	 * Vincula um novo numero de telefone a um contato já existente.
	 * 
	 * @param telefone : representa um objeto Telefone que contém todas as informações de um contato.
	 * 
	 * @return : um boolean que representa o êxito ou não na operação.
	 */
	public boolean insereContato(Telefone telefone) {
		if(posicaoTelefone < 3) {
			telefones[posicaoTelefone++] = telefone;
			return true;
		}
		return false;
	}
	
	/**
	 * Sobrescreve o método equals. 
	 * Verifica a igualdade de dois contatos a partir do nome.
	 * 
	 * @param contato : recebe um objeto de um tipo mais geral.
	 * @return : um boolean que representa a igualdade entre dois contatos. Dois contatos são iguais se possuem o mesmo nome. 
	 */
	@Override
	public boolean equals(Object contato) {
		return this.nome.equals(((Contato) contato).getNome());
	}
	
	/**
	 * Representação String de um objeto Contato no formato: NOME SOBRENOME - [TELEFONES..] - NIVEL DE AMIZADE
	 */
	@Override
	public String toString() {
		return String.format("%s %s - %s - Tipo de Amizade: %s" + System.lineSeparator(), this.nome, this.sobrenome, Arrays.toString(telefones),
				tipoNivelAmizade(nivelAmizade));
	}
	
}
