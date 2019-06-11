package pessoas;

import java.util.Scanner;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;

public class EntrarConta {

	public static void main(String[] args) {

		// Variaveis para cadastro
		String lg, pass;
		// Variaveis para verificar login
		// String id,password;

		Scanner logar = new Scanner(System.in);
		// Scanner logarInt = new Scanner(System.in);

		System.out.println("Bem Vindo ao CyberCafé, faça login ou cadastre em nosso Sistema:");

		int vez;
		
		do {
			Scanner logarMenu = new Scanner(System.in);
			
			System.out.println("\n\nEscolha uma das opções disponíveis."
					 + "\n1 - Cadastrar Usuário"
					 + "\n2 - Fazer Login de Usuário"
					 + "\n0 - Para Sair");
	
	

			
			vez = logarMenu.nextInt();
			switch (vez) {
			case 1:
				
				Usuario usuario = new Usuario();
				System.out.println("\t\tLogin: ");	
				lg = logar.nextLine();

				System.out.println("\t\tSenha: ");
				pass = logar.nextLine();
				boolean ok = ArquivoSerializadoUtil.gravaUsuarioSerializado(lg, pass, usuario);
				
				if (ok) {
					System.out.println("Usuário cadastrado com êxito.");
					
					
				}else {
					System.out.println("Vai roubar outro.");
				}

				
				break;
			case 2:
				int verif = Usuario.fazerLogin();
				
				if(verif == 1) {
					System.out.println("Você está logado.\n\n");
					
					int escolha;
					
					do {
						escolha = 0;	
						System.out.println("\n\nEscolha uma das opções disponíveis."
										 + "\n1 - Comprar "
										 + "\n2 - Fazer Login"
										 + "\n3 - Vizualizar Informações"
										 + "\n0 - Para Sair");
						vez = logarMenu.nextInt();
						
						switch (vez) {	
						case 1:
									System.out.println("Sem Função no momento. ");	
							break;

						case 2:
							
							System.out.println("Cadastrando Cliente:");
							
								Increment.Cadastrar();
							break;
						
						case 3:
							Usuario.ler();
							break;
						case 0:
							vez = 100;
							
							break; 

						default:
							System.out.println("Digite uma opcao válida.");
							break;
						}

					} while (vez!= 100);

					
					
				}else {
					System.out.println("Vai roubar outro.");
				}
				break;
			default:
				System.out.println("Só introduza valores pedido.\n Sabe ler não?");
				break;
			}
			
		
			}while(vez!=0);
		

}
}
