package pessoas;

import java.io.File;

public class ListaPessoa {

	public static void listaPF(String id) {

		File directory = new File("FONTES/CLIENTE/CPF/"+ id + ".txt");

		boolean verif = directory.exists();

		if (verif) {

			PessoaFisica pessoaF = (PessoaFisica)ArquivoSerializadoUtil.lerPessoaSerializado(1, "CPF", id);

			System.out.println("CPF         -- " + pessoaF.getCpf());
			System.out.println("NOME        -- " + pessoaF.getNome());
			System.out.println("EMAIL       -- " + pessoaF.getEmail());
			System.out.println("CELULAR     -- " + pessoaF.getCelular());
			System.out.println("ESTADO      -- " + pessoaF.getUf());
			System.out.println("CIDADE      -- " + pessoaF.getCidade());
			System.out.println("RUA         -- " + pessoaF.getRua());
			System.out.println("NUMERO      -- " + pessoaF.getNumero());
			System.out.println("BAIRRO      -- "+ pessoaF.getBairro());
			System.out.println("COMPLEMENTO -- " + pessoaF.getComplemento());
			System.out.println("CEP         -- " + pessoaF.getCep());

			
		}

	}

	public static void listaPJ(String id) {

		File directory = new File("FONTES/CLIENTE/CNPJ/"+ id + ".txt");

		boolean verif = directory.exists();
		
		if (verif) {

			PessoaJuridica pessoaJ = (PessoaJuridica) ArquivoSerializadoUtil.lerPessoaSerializado(1, "CNPJ", id);

			System.out.println("CNPJ        -- " + pessoaJ.getCnpj());
			System.out.println("EMPRESA     -- " + pessoaJ.getNome());
			System.out.println("EMAIL       -- " + pessoaJ.getEmail());
			System.out.println("TELEFONE    -- " + pessoaJ.getCelular());
			System.out.println("ESTADO      -- " + pessoaJ.getUf());
			System.out.println("CIDADE      -- " + pessoaJ.getCidade());
			System.out.println("RUA         -- " + pessoaJ.getRua());
			System.out.println("NUMERO      -- " + pessoaJ.getNumero());
			System.out.println("BAIRRO      -- "+ pessoaJ.getBairro());
			System.out.println("COMPLEMENTO -- " + pessoaJ.getComplemento());
			System.out.println("CEP         -- " + pessoaJ.getCep());

		}

	}
}
