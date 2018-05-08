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
	private static final String EXIBIR = "E";
	private static final String SAIR = "S";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean continua = true;
		Agenda agenda = new Agenda();
		
		while(continua) {
			String valor = exibirMenu(scan);
			switch(valor) {
				case(CADASTRAR):
					System.out.print("Posição: ");
					int pos = scan.nextInt();
					if(pos < 1 || pos > 100) {
						System.out.println("POSIÇÃO INVÁLIDA!\n");
						break;
					}
					System.out.print("Nome: ");
					String nome = scan.next();
					System.out.print("Sobrenome: ");
					String sobrenome = scan.next();
					System.out.print("Telefone: ");
					String telefone = scan.next();
						
					Contato contato = new Contato(pos, nome, sobrenome, telefone);
					agenda.cadastrarContato(contato);
					break;
					
				case(LISTAR):
					agenda.listarContatos();
					break;
					
				case(EXIBIR):
					System.out.print("Contato> ");
					pos = scan.nextInt();
					agenda.exibirContato(pos);
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
	public static String exibirMenu(Scanner scan) {
		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(S)air\n");
		System.out.print("Opção> ");
		return scan.next();
	}

}
