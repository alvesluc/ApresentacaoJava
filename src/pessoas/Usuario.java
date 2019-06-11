package pessoas;
import java.io.File;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Usuario extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private String[] login = new String[1];
	// private String[] senha = new String[1];

	static ArrayList<String> Login = new ArrayList<String>();
	static ArrayList<String> Senha = new ArrayList<String>();

	public ArrayList<String> getLogin() {
		return Login;
	}

	public void setLogin(ArrayList<String> login) {
		Login = login;
	}

	public ArrayList<String> getSenha() {
		return Senha;
	}

	public void setSenha(ArrayList<String> senha) {
		Senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static int fazerLogin() {
		
		String id, password;
		Scanner logar = new Scanner(System.in);
		// Fazer login
		
	
			System.out.println("\t\tInforme o Login: ");
			id = logar.nextLine();
			System.out.println("\t\tInforme a Senha: ");
			password = logar.nextLine();
			
			File identU = new File("Fontes/Usuario/"+ id +"-"+ password + ".txt");
			boolean ident = identU.exists();
			
			if(ident) {

				return 1;	
			}
		
	
	
		return 0;
}

	public static void ler() {

		LerArquivoV2.lerArquivo();
	}


}