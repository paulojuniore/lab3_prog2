package com.paulo.lab3;
import java.util.Scanner;

/**
 * Representa um sistema de gerenciamento de contatos em uma Agenda, contém alguns métodos auxiliares
 * que realizam as leituras de dados, tratamento de exceções, e assim os dados tratados são passados 
 * para os métodos das classes auxiliares para concretizar a operação.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */
public class Menu {
	
	private static final String CADASTRAR = "C";
	private static final String LISTAR = "L";
	private static final String ADICIONARTELEFONE = "A";
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
					cadastrarContato();
					break;
					
				case(LISTAR):
					System.out.println(agenda.listarContatos());
					break;
					
				case(ADICIONARTELEFONE):
					inserirNovoContato();
					break;
					
				case(EXIBIR):
					consultasPersonalizadas();
					break;
					
				case(SAIR):
					continua = false;
					break;
				
				default:
					System.out.println("Opção Inválida!\n");
					break;			
			}
		}
	}
	
	/**
	 * Exibe o menu com as opções comuns em uma agenda.
	 * 
	 * @return : Contém uma entrada de operação no final do método no formato String.
	 */
	public static String exibirMenu() {
		System.out.println("(C)adastrar Contato");
		System.out.println("(A)dicionar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(S)air\n");
		System.out.print("Opção> ");
		return scan.nextLine().toUpperCase();
	}
	
	/**
	 * Cadastra um contato na agenda. Pode gerar exceções caso seja passado algum valor inválido.
	 * Como por exemplo: uma posição inexistente na agenda ou um nível de amizade inválido.
	 * 
	 */
	public static void cadastrarContato() {
		int posicao;
		System.out.print("Posição: ");	
		try {
			posicao = Integer.parseInt(scan.nextLine());
			if(posicao <= 0 || posicao > 100) {
				System.out.println("Posição Inválida!\n");
				return;
			}
		}
		catch(NumberFormatException n) {
			System.out.println("A posição não foi digitada!\n");
			return;
		}		
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		System.out.print("Sobrenome: ");
		String sobrenome = scan.nextLine();
		System.out.print("Nível de Amizade: (1-Distante; 2-Colega; 3-Amigo; 4-Amigão; 5-Irmão) ");
		int nivelAmizade = 0;
		try {
			nivelAmizade = Integer.parseInt(scan.nextLine());
		}	
		catch(NumberFormatException n1) {
			System.out.println("O nível de amizade é inválido!\n");
			return;
		}
		
		Telefone telefone = null;
		try {
			telefone = criaTelefone();
			agenda.cadastrarContato(posicao, nome, sobrenome, telefone, nivelAmizade);
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	/**
	 * Método auxiliar da classe contato que possui as entradas de dados e tratamento de valores inválidos.
	 * Insere um novo contato em uma posição já existente na agenda, caso a posição atual seja menor que 3.
	 * 
	 */
	public static void inserirNovoContato() {
		int pos = 0;
		System.out.print("Contato> ");
		try {
			pos = Integer.parseInt(scan.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Dado inválido!\n");
			return;
		}
		
		if(agenda.getContatos()[pos-1] != null) {
			Telefone telefone = null;
			try {
				telefone = criaTelefone();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return;
			}
			if(agenda.getContatos()[pos-1].insereContato(telefone))
				System.out.println("Atualização Realizada!\n");
			else
				System.out.println("Quantidade Máxima de Contatos Excedida!\n");
		}
		else {
			System.out.println("Posição Inválida!\n");
		}
	}
	
	/**
	 * Contém as entradas dos dados para o telefone, como código do país, ddd, número e tipo de contato.
	 * Método pode lançar exceções caso ocorram dados inválidos.
	 * 
	 * @return : retorna um objeto do tipo Telefone para o seu chamador. 
	 * 
	 */
	public static Telefone criaTelefone() throws Exception {
		System.out.println("\n--- TELEFONE ---");
		System.out.print("Código do País: ");
		String codigo = scan.nextLine();
		System.out.print("DDD: ");
		String ddd = scan.nextLine();
		System.out.print("Número: ");
		String numero = scan.nextLine();
		System.out.print("Tipo (CELULAR, TRABALHO ou CASA): ");
		String tipo = scan.nextLine().toUpperCase();
		
		Telefone telefone = new Telefone(codigo, ddd, numero, tipo);
		return telefone;
	}
	
	/**
	 * Menu que contém diversos tipos de consulta, para que o usuário escolha a que preferir.
	 * As operações são realizadas interna/externamente através da composição de classes.
	 * 1 - Consulta pelo nome do contato;
	 * 2 - Consulta pela posição do contato;
	 * 3 - Consulta pelo nível de amizade;
	 * 4 - Consulta pela quantidade de amigos com determinado nível de amizade;
	 * 5 - Consulta da média de amizade da agenda.
	 *
	 */
	public static void consultasPersonalizadas() {
		System.out.println("\n--- MODOS DE EXIBIÇÃO ---");
		System.out.println("(1) - Pelo nome.");
		System.out.println("(2) - Pelo contato.");
		System.out.println("(3) - Pelo nível de amizade.");
		System.out.println("(4) - Quantidade de amigos com determinado nível de amizade.");
		System.out.println("(5) - Média de amizade da agenda.");
		System.out.println();
		
		System.out.print("Opção> ");
		int op = 0;
		try {
			op = Integer.parseInt(scan.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Opção inválida!\n");
			return;
		}
		
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
				try {
					int pos = Integer.parseInt(scan.nextLine());
					if(pos >= 1 && pos <= 100 && agenda.getContatos()[pos-1] != null)
						System.out.println(agenda.exibirContato(pos));
					else
						System.out.println("Posição Inválida!\n");
				}
				catch(NumberFormatException e) {
					System.out.println("Posição Inválida\n");
				}
				break;
				
			case 3:
				System.out.print("Nível de Amizade> ");
				try {
					int nivel = Integer.parseInt(scan.nextLine());
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
				}
				catch(NumberFormatException e) {
					System.out.println("Dado inválido!");
				}	
				System.out.println();
				break;
			
			case 4:
				System.out.print("Nível de Amizade> ");
				try {
					int nivel = Integer.parseInt(scan.nextLine());
					cont = 0;
					for (int i = 0; i < agenda.getContatos().length; i++) {
						if(agenda.getContatos()[i] != null) {
							if(agenda.getContatos()[i].getNivelAmizade() == nivel) {
								cont++;
							}	
						}	
					}
					System.out.println("Número de contatos com o nível de amizade " + nivel + " é: " + cont + "\n");
				}
				catch(NumberFormatException e) {
					System.out.println("Dado inválido!\n");
				}				
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
