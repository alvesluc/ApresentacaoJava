package pessoas;

import java.io.File;
import java.util.Scanner;

public class Increment {

	public static void Cadastrar() {
		
		String tipoPessoa = "";
		
		@SuppressWarnings("resource")
		Scanner logar = new Scanner(System.in);
		PessoaFisica pessoaf = new PessoaFisica();
		PessoaJuridica pessoaj = new PessoaJuridica();
		Endereco endereco = new Endereco();

		System.out.println("Informe os seguintes dados: ");
		System.out.println("\t\tSeu nome: ");
		String nomePessoa = logar.nextLine();
		
		System.out.println("Email: ");
		String emailPessoa = logar.nextLine();
		
		System.out.println("\t\tCelular: ");
		String celularPessoa = logar.nextLine();
		
		System.out.println("Agora vou precisar do seu endereço.");

		System.out.println("Estado: ");
		String uf = logar.nextLine();

		System.out.println("Cidade: ");
		String cidade = logar.nextLine();

		System.out.println("Rua: ");
		String rua = logar.nextLine();

		System.out.println("Bairro: ");
		String bairro = logar.nextLine();

		System.out.println("Número: ");
		String numero = logar.nextLine();

		System.out.println("CEP: ");
		String cep = logar.nextLine();

		System.out.println("Complemento: ");
		String complemento = logar.nextLine();

		int fileCount = 0;
		
		System.out.println("Selecione o tipo de pessoa:" + "\n1 - Pessoa Física" + "\n2 - Pessoa Jurídica");
		tipoPessoa = logar.nextLine();
		
		switch (tipoPessoa) {
		case "1":
			File directorycpf = new File("Fontes/Cliente/CPF/");
			fileCount = directorycpf.list().length;
			break;
		case "2":
			File directorycnpj = new File("Fontes/Cliente/CNPJ/");
			fileCount = directorycnpj.list().length;			
			break;
		default:
			System.out.println("Opção inválida.");
			break;
		}
		
		
		if (tipoPessoa.equals("1")) {
			String usar = pessoaf.indruzirDados(++fileCount, nomePessoa, emailPessoa, celularPessoa, uf, cidade, rua, bairro, numero, cep, complemento);
			boolean gravou = ArquivoSerializadoUtil.gravaPessoaSerializado(1, 1, usar, pessoaf);

			if (gravou) {
				System.out.println("Arquivo gravado com sucesso!");
			}
			boolean finalizar = ArquivoSerializadoUtil.gravaPessoaSerializado(2, 1, usar, endereco);

			if (finalizar) {
				System.out.println("Cadastro realizado com êxito.");
			}

		} else if (tipoPessoa.equals("2")) {
			
			String usar = pessoaj.indruzirDados(++fileCount, nomePessoa, emailPessoa, celularPessoa, uf, cidade, rua, bairro, numero, cep, complemento);
			boolean gravou = ArquivoSerializadoUtil.gravaPessoaSerializado(1, 2, usar, pessoaj);

			if (gravou) {
				System.out.println("Arquivo gravado com sucesso!");
			}
			
			boolean finalizar = ArquivoSerializadoUtil.gravaPessoaSerializado(2, 2, usar, endereco);

			if (finalizar) {
				System.out.println("Cadastro realizado com êxito.");
			}

		}


	}

}
