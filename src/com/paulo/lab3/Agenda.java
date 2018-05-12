package com.paulo.lab3;

/**
 * Representa uma Agenda de contatos.
 * Toda Agenda possui um conjunto de contatos.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */
public class Agenda {
	
	/**
	 * Representa o conjunto de contatos. inicialmente vazia
	 */
	private Contato[] contatos;
	
	/**
	 * Constrói uma Agenda, que inicializa um conjunto de 100 contatos com (null) 
	 */
	public Agenda() {
		contatos = new Contato[100];
	}
	
	/**
	 * Retorna os contatos da agenda.
	 * 
	 * @return : contatos da agenda.
	 */
	public Contato[] getContatos() {
		return contatos;
	}
	
	/**
	 * Não possui valor de retorno.
	 * 
	 * Cadastra um novo contato, todo contato possui uma posição, nome, sobrenome e telefone
	 * 
	 * @param posicao : representa a posição do contato na agenda.
	 * @param nome : representa o nome do contato.
	 * @param sobrenome : representa o sobrenome do contato.
	 * @param telefone : representa o telefone do contato.
	 * @param nivelAmizade : representa o nível de amizade de um contato.
	 * 
	 * @return : retorna um boolean que representa se a operação teve sucesso ou não.
	 */
	public boolean cadastrarContato(int posicao, String nome, String sobrenome, Telefone telefone, int nivelAmizade) throws NumberFormatException, IllegalArgumentException, NullPointerException {
		if(posicao >= 1 && posicao <= 100) {
			contatos[posicao - 1] = new Contato(posicao, nome, sobrenome, telefone, nivelAmizade);
			System.out.println("CADASTRO REALIZADO!\n");
			return true;
		}
		return false;
	}
	
	/**
	 * Exibe um contato já existente através de sua posição.
	 * 
	 * @param pos : a posição a qual deseja imprimir o contato.
	 * 
	 * @return : String que representa o contato buscado.
	 */
	public String exibirContato(int pos) {
		return contatos[pos-1].toString(); 
	}
	
	/**
	 * 
	 * Exibe uma lista dos contatos já cadastrados até o momento.
	 */
	public String listarContatos() {
		String saida = "";
		for (int i = 0; i < contatos.length; i++) {
			if (!(contatos[i] == null)) {
				saida += (i + 1) + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + System.lineSeparator();
			}	
		}
		return saida;
	}
	
	/**
	 * Sobrescreve o método equals. 
	 * Verifica a igualdade de duas agendas, duas agendas são iguais se possuem os mesmos contatos nas mesmas posições.
	 * 
	 * @param agenda : recebe um objeto de um tipo mais geral.
	 * @return : retorna um boolean que representa a igualdade entre duas agendas. 
	 */
	@Override
	public boolean equals(Object agenda) {
		return this.contatos.equals(((Agenda) agenda).getContatos());
	}
	
}
