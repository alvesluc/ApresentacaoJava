package pessoas;

import java.util.Scanner;
import java.io.File;

public class LerArquivoV2 {

	public static void lerArquivo() {
		PessoaFisica pessoaf = new PessoaFisica();
		PessoaJuridica pessoaj = new PessoaJuridica();
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Informe o CPF ou CNPJ");
		String nomeArquivo = leitor.nextLine();
		
		File verif1 = new File("Fontes/Cliente/CPF/"+nomeArquivo+".txt");
		boolean existe = verif1.exists();
		
		if (existe) {
			
			PessoaFisica leituraF = (PessoaFisica) ArquivoSerializadoUtil.lerPessoaSerializado(1, "CPF", nomeArquivo);
			
			System.out.println("\nCPF");
			
			System.out.println("1 - " + leituraF.getCpf());
			System.out.println("2 - " + leituraF.getNome());
			System.out.println("3 - " + leituraF.getEmail());
			System.out.println("4 - " + leituraF.getCelular());
			
			
			
		}else {
		
			PessoaJuridica leituraJ = (PessoaJuridica) ArquivoSerializadoUtil.lerPessoaSerializado(1,"CNPJ", nomeArquivo);
			
			System.out.println("\nCNPJ");
			System.out.println("1 - " +leituraJ.getCnpj());
			System.out.println("2 - " +leituraJ.getNome());
			System.out.println("3 - " +leituraJ.getEmail());
			System.out.println("4 - " +leituraJ.getCelular());
			
			
		}
		
		


	}

}
