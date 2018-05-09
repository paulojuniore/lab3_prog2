package com.paulo.lab3;
import java.util.Scanner;

/**
 * Representa um sistema de gerenciamento de contatos em uma Agenda.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */
public class Menu {
	
	private static final String CADASTRAR = "C";
	private static final String LISTAR = "L";
	private static final String INSERIRNOVOTELEFONE = "I";
	private static final String EXIBIR = "E";
	private static final String SAIR = "S";
	
	private static Scanner scan = new Scanner(System.in);
	private static Agenda agenda = new Agenda();

	public static void main(String[] args) {
		
		boolean continua = true;
		
		while(continua) {
			String valor = exibirMenu();
			switch(valor) {
				case(CADASTRAR):
					System.out.print("Posição: ");
					int pos = Integer.parseInt(scan.nextLine());
					if(pos < 1 || pos > 100) {
						System.out.println("POSIÇÃO INVÁLIDA!\n");
						break;
					}
					System.out.print("Nome: ");
					String nome = scan.nextLine();
					System.out.print("Sobrenome: ");
					String sobrenome = scan.nextLine();
					System.out.println("Nível de Amizade: (1-Distante; 2-Colega; 3-Amigo; 4-Amigão; 5-Irmão) ");
					int nivelAmizade = Integer.parseInt(scan.nextLine());
					Telefone telefone = criaTelefone();
					
					try {
						Contato contato = new Contato(pos, nome, sobrenome, telefone, nivelAmizade);
						agenda.cadastrarContato(contato);
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println(e.getMessage());
					}
					
					break;
					
				case(LISTAR):
					agenda.listarContatos();
					break;
					
				case(INSERIRNOVOTELEFONE):
					break;
					
				case(EXIBIR):
					consultasPersonalizadas();
					break;
					
				case(SAIR):
					continua = false;
					break;
				
				default:
					System.out.println("OPÇÃO INVÁLIDA!\n");
					break;			
			}
		}
	}
	
	/**
	 * Exibe o menu com as opções comuns de uma agenda.
	 * 
	 * @return : Contém uma entrada de operação no final do método.
	 */
	public static String exibirMenu() {
		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(S)air\n");
		System.out.print("Opção> ");
		return scan.nextLine().toUpperCase();
	}
	
	/**
	 * Contém as entradas dos dados para o telefone, como código do país, ddd, número e tipo de contato.
	 * 
	 * @return : retorna um objeto do tipo Telefone para o seu chamador. 
	 */
	public static Telefone criaTelefone() {
		System.out.println("---Telefone---");
		System.out.print("Código do País: ");
		String codigo = scan.nextLine();
		System.out.print("DDD: ");
		String ddd = scan.nextLine();
		System.out.print("Número: ");
		String numero = scan.nextLine();
		System.out.println("Tipo (CELULAR, TRABALHO ou CASA): ");
		String tipo = scan.nextLine();
		
		Telefone telefone = new Telefone(codigo, ddd, numero, tipo);
		return telefone;
	}
	
	/**
	 * Menu que contém diversos tipos de consulta, para que o usuário escolha a que preferir.
	 * As operações são realizadas interna/externamente através da composição de classes.
	 *
	 */
	public static void consultasPersonalizadas() {
		System.out.println("--- MODOS DE EXIBIÇÃO ---");
		System.out.println("(1) - Pelo nome.");
		System.out.println("(2) - Pelo contato.");
		System.out.println("(3) - Pelo nível de amizade.");
		System.out.println("(4) - Quantidade de amigos com determinado nível de amizade.");
		System.out.println("(5) - Média de amizade da agenda.");
		System.out.println();
		
		System.out.print("Opção> ");
		int op = Integer.parseInt(scan.nextLine());
		
		switch(op) {
			case 1:
				System.out.print("Nome> ");
				String nome = scan.nextLine();
				int cont = 0;
				for (int i = 0; i < agenda.getContatos().length; i++) {
					if(agenda.getContatos()[i] != null) {
						if(agenda.getContatos()[i].getNome().equals(nome)) {
							System.out.print(agenda.getContatos()[i].toString());
							cont++;
						}	
					}	
				}
				if(cont == 0) {
					System.out.println("Nenhum contato foi encontrado.");
				}
				System.out.println();
				break;
			
			case 2:
				System.out.print("Posição> ");
				int pos = Integer.parseInt(scan.nextLine());
				agenda.exibirContato(pos);
				break;
				
			case 3:
				System.out.print("Nível de Amizade> ");
				int nivel = scan.nextInt();
				cont = 0;
				for (int i = 0; i < agenda.getContatos().length; i++) {
					if(agenda.getContatos()[i] != null) {
						if(agenda.getContatos()[i].getNivelAmizade() == nivel) {
							System.out.print(agenda.getContatos()[i].toString());
							cont++;
						}	
					}	
				}
				if(cont == 0) {
					System.out.println("Nenhum contato foi encontrado.");
				}
				System.out.println();
				break;
			
			case 4:
				System.out.println("Nível de Amizade:> ");
				nivel = scan.nextInt();
				cont = 0;
				for (int i = 0; i < agenda.getContatos().length; i++) {
					if(agenda.getContatos()[i] != null) {
						if(agenda.getContatos()[i].getNivelAmizade() == nivel) {
							cont++;
						}	
					}	
				}
				System.out.println("Número de contatos com o nível de amizade " + nivel + " é -> " + cont + "\n");
				break;
				
			case 5:
				int soma = 0, qtd_contatos = 0;
				for (int i = 0; i < agenda.getContatos().length; i++) {
					if(agenda.getContatos()[i] != null) {
						soma += agenda.getContatos()[i].getNivelAmizade();
						qtd_contatos++;
					}	
				}
				if(qtd_contatos != 0)
					System.out.println("A média de amizade da agenda é: " + (soma / qtd_contatos) + "\n");
				else
					System.out.println("A agenda está vazia!\n");
				break;
			
			default:
				System.out.println("Comando Inválido!\n");
				
		}
	}

}
