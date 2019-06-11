package informacoes;

import java.util.Scanner;

public class LerProdutos {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		System.out.println("Informe a categoria do arquivo: ");
		String categoria = leitor.nextLine();
		System.out.println("Informe o ID do arquivo: ");
		String id = leitor.nextLine();
		Produto produtoLeitura = (Produto) ArquivoSerializadoUtilInformacoes.lerArquivoSerializado(categoria, id);

		System.out.println(produtoLeitura.getId());
		System.out.println(produtoLeitura.getNome());
		System.out.println(produtoLeitura.getPrecovenda());
		System.out.println(produtoLeitura.getQtde_estoque());

		leitor.close();
	}

}
