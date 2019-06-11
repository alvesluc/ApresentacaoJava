package pessoas;

import java.io.File;

public class RemovePessoa {
	
	public static void removePessoaF(String param) {
				
		File remover = new File("FONTES/CLIENTE/CPF/"+ param + ".txt");
		boolean removeu = remover.delete();
		File remover2 = new File("FONTES/ENDERECO/CPF/"+ param + ".txt");
		boolean removeu2 = remover2.delete();
		
		if(removeu && removeu2) {
			System.out.println("O cadastro do cliente com CPF: " + param + " foi apagado");
		}
	}
	
	public static void removePessoaJ(String param) {
		
		File remover = new File("FONTES/CLIENTE/CNPJ/"+ param + ".txt");
		boolean removeu = remover.delete();
		File remover2 = new File("FONTES/ENDERECO/CNPJ/"+param + ".txt");
		boolean removeu2 = remover2.delete();
		
		if(removeu && removeu2) {
			System.out.println("O cadastro do cliente com CNPJ: " + param + " foi apagado");
		}
	}
	
}
