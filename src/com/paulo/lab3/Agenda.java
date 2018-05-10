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
	public void cadastrarContato(int posicao, String nome, String sobrenome, Telefone telefone, int nivelAmizade) throws NumberFormatException, IllegalArgumentException, NullPointerException {
		if(posicao < 1 || posicao > 100) {
			throw new ArrayIndexOutOfBoundsException("POSIÇÃO INVÁLIDA!\n");
		}
		contatos[posicao - 1] = new Contato(posicao, nome, sobrenome, telefone, nivelAmizade);
		System.out.println("CADASTRO REALIZADO!\n");
	}
	
	/**
	 * Exibe um contato já existente.
	 * 
	 * @return : String que representa o contato buscado.
	 */
	public String exibirContato(int pos) {
		return contatos[pos-1].toString(); 
	}
	
	/**
	 * Não possui valor de retorno.
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
	@Override
	public boolean equals(Object agenda) {
		return this.contatos.equals(((Agenda) agenda).getContatos());
	}
	
}
