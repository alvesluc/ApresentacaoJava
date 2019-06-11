package informacoes;

import java.io.File;

import fornecedores.ArquivoSerializadoUtilFornecedor;

public class ListaProd {

	public static void listar(String categoria, String id) {

		File directory = new File("CATEGORIA/" + categoria + "/" + id + ".txt");

		boolean verif = directory.exists();

		if (verif) {

			Produto produtoLeitura = (Produto) ArquivoSerializadoUtilInformacoes.lerArquivoSerializado(categoria, id);

			System.out.println(produtoLeitura.getId() + " --- " + produtoLeitura.getNome() + " --- R$"
					+ produtoLeitura.getPrecovenda() + ", estoque: " + produtoLeitura.getQtde_estoque());

		}
	}

	public static void fornecer(String fornecedor, String categoria, String id) {

		File directory = new File("FORNECEDORES/" + fornecedor + "/" + "CATEGORIA/" + categoria + "/" + id + ".txt");

		boolean verif = directory.exists();

		if (verif) {

			Produto produtoLeitura = (Produto) ArquivoSerializadoUtilInformacoes.lerArquivoSerializado(categoria , id);

			System.out.println(produtoLeitura.getId() + " --- " + produtoLeitura.getNome() + " --- R$"
					+ produtoLeitura.getPrecovenda());

		}
	}
}
