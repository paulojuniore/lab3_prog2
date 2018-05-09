package com.paulo.lab3;
import java.util.Scanner;

/**
 * Representa o Menu de um sistema para realizar operações em uma agenda de contatos.
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
					//System.out.print("Contato> ");
					//pos = Integer.parseInt(scan.nextLine());
					//agenda.exibirContato(pos);
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
	 * Exibe o menu com as opções de agenda.
	 * 
	 * @param scan : Objeto scan que faz a leitura de uma operação na agenda.
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
	
	public static void consultasPersonalizadas() {
		System.out.println("--- MODOS DE EXIBIÇÃO ---");
		System.out.println("(1) - Por nome.");
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
			
			case 2:
				System.out.print("Posição> ");
				int pos = Integer.parseInt(scan.nextLine());
				agenda.exibirContato(pos);
		}
	}

}
