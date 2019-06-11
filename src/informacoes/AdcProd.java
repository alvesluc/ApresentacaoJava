package informacoes;

import java.io.File;

public class AdcProd {

	public static void introduzirProd(int id, String nome, float precovenda, int quant_estoque) {

		Produto produto = new Produto();

		int novoId = verificarId(id);
		String categoria = "Exemplos";
		produto.setId(novoId);
		produto.setNome(nome);
		produto.setPrecovenda(precovenda);
		produto.setQtde_estoque(quant_estoque);

		// Gravar o objeto de um jeito muito mais limpo
		boolean gravou = ArquivoSerializadoUtilInformacoes.gravaObjetoSerializado(categoria, produto.getId(), produto);

		if (gravou) {
			System.out.println("Arquivo gravado com sucesso!");
		}
	}

	public static int verificarId(int id) {
		// File directory = new File("PRODUTOS/");

		for (int i = 1; i <= id; i++) {

			File directory = new File("PRODUTOS/" + i + ".txt");
			boolean novoId = directory.exists(); // Existence

//			Files.exists(path)  // Existence
			if (!novoId) {
				return i;
			}
		}

		System.out.println("Deu certo");
		return ++id;

	}
}
