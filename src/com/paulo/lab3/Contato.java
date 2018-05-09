package com.paulo.lab3;

import java.util.Arrays;

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
	private Telefone[] telefones = new Telefone[3];
	
	/**
	 * Representa a posição atual do telefone
	 */
	private int posicaoTelefone = 1; 
	
	/**
	 * Representa o nível de Amizade do telefone (1-Distante; 2-Colega; 3-Amigo; 4-Amigão; 5-Irmão)
	 */
	private int nivelAmizade;
	
	/**
	 * Constrói um contato a partir do nome, sobrenome e telefone.
	 * 
	 * @param nome : nome do contato
	 * @param sobrenome : sobrenome do contato
	 * @param telefone : telefone do contato
	 */
	public Contato(int posicao, String nome, String sobrenome, Telefone telefone, int nivelAmizade) {
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
	 * Sobrescreve o método equals. 
	 * Verifica a igualdade de dois contatos a partir do nome.
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
	@Override
	public String toString() {
		return String.format("%s %s - %s - Tipo de Amizade: %s%n", this.nome, this.sobrenome, Arrays.toString(telefones),
				tipoNivelAmizade(nivelAmizade));
	}
	
}
