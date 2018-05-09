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
	 * @param contato : representa um contato que contém nome, sobrenome e telefone.
	 * @param pos : representa a posição do contato na agenda.
	 */
	public void cadastrarContato(Contato contato) {
		if(contato.getPosicao() < 1 || contato.getPosicao() > 100) {
			throw new ArrayIndexOutOfBoundsException("POSIÇÃO INVÁLIDA!");
		}
		contatos[contato.getPosicao() - 1] = contato;
		System.out.println("CADASTRO REALIZADO!\n");
	}
	
	/**
	 * Não possui valor de retorno.
	 * 
	 * Exibe um contato já existente
	 */
	public void exibirContato(int pos) {
		if(contatos[pos-1] == null || pos < 1 || pos > 100)
			System.out.println("POSIÇÃO INVÁLIDA!\n");
		else {
			System.out.println(contatos[pos-1].toString());
		}
	}
	
	/**
	 * NÃ£o possui valor de retorno.
	 * 
	 * Exibe uma lista dos contatos já cadastrados até o momento.
	 */
	public void listarContatos() {
		for (int i = 0; i < contatos.length; i++) {
			if(contatos[i] != null)
				System.out.printf("%d - %s %s%n", contatos[i].getPosicao(), contatos[i].getNome(), contatos[i].getSobrenome());
		}
		System.out.println();
	}
	
	/**
	 * Sobrescreve o método equals. 
	 * Verifica a igualdade de duas agendas.
	 * 
	 * @param agenda : recebe um objeto de um tipo mais geral.
	 * @return : um boolean que representa a igualdade entre duas agendas. 
	 */
	public boolean equals(Object agenda) {
		return this.contatos.equals(((Agenda) agenda).getContatos());
	}
	
}
