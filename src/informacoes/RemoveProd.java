package informacoes;

import java.io.File;

public class RemoveProd {

	public static void remove(String categoria, int id) {

		File usar = new File("CATEGORIA/" + categoria + "/");

		int ultimo = usar.list().length;
		String ultimoA = Integer.toString(ultimo);
		
		if (id <= usar.list().length) {
			File lastFile = new File("CATEGORIA/" + categoria + "/" + ultimo + ".txt");

			File remover = new File("CATEGORIA/" + categoria + "/" + id + ".txt");

			Produto produtoLeitura = (Produto) ArquivoSerializadoUtilInformacoes.lerArquivoSerializado(categoria,
					ultimoA);

			produtoLeitura.getId();
			produtoLeitura.getNome();
			produtoLeitura.getPrecovenda();
			produtoLeitura.getQtde_estoque();

			boolean saber = remover.delete();

			AdcProd.introduzirProd(ultimo, produtoLeitura.getNome(), produtoLeitura.getPrecovenda(),
					produtoLeitura.getQtde_estoque());

			boolean saber2 = lastFile.delete();

			if (saber && saber2) {

				System.out.println("Tudo ok.");
			}

		} else {
			System.out.println("Opção inválida!");
		}

	}
}
