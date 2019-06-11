package informacoes;

import java.io.File;
import java.util.Scanner;

public class SystemVenda {

	public static float vender(String categoria) {

		float totalConta = 0;

		Scanner buscar = new Scanner(System.in);

		try {
			File directory = new File("CATEGORIA/" + categoria + "/");
			Produto produto = new Produto();
			int fileCount = (int) directory.list().length;

			for (int i = 1; i <= fileCount; i++) {
				String id = Integer.toString(i);
				ListaProd.listar(categoria, id);
			}

		} catch (NullPointerException e) {
			System.out.println("Categoria inválida");
			return 0;
		}

		String buscaID;

		float totalPreco;

		System.out.println("Digite o ID do produto que deseja ou 0 para sair:");
		buscaID = buscar.nextLine();

		while (!buscaID.equals("0")) {

			File existe = new File("CATEGORIA/" + categoria + "/" + buscaID + ".txt");
			boolean taOk = existe.exists();

			if (taOk) {
				int buscaQuant = 0;
				try {
					System.out.println("Digite a quantidade que deseja:");
					buscaQuant = Integer.parseInt(buscar.nextLine());

				} catch (NumberFormatException e) {
					System.out.println("Entrada inválida");
					buscaQuant = 0;
				}

				Produto pegarItem = (Produto) ArquivoSerializadoUtilInformacoes.lerArquivoSerializado(categoria,
						buscaID);
				Produto pegarAlterado = pegarItem;
				if (buscaQuant <= pegarItem.getQtde_estoque()) {
					totalPreco = pegarItem.getPrecovenda() * buscaQuant;
					pegarItem.setQtde_estoque(pegarItem.getQtde_estoque() - buscaQuant);

					boolean gravou = ArquivoSerializadoUtilInformacoes.gravaObjetoSerializado(categoria,
							pegarItem.getId(), pegarAlterado);

					if (gravou) {
						System.out.println("\n");
					}
					totalConta = totalConta + totalPreco;
					System.out.println("Total: " + totalPreco);

				} else {
					System.out.println("Quantidade maior que a disponibilizada pelo estoque.");
					return 0;
				}

			} else {
				System.out.println("Entre com um valor existente.");
			}
			System.out.println("Digite o ID do produto que deseja, ou 0 para sair :");
			buscaID = buscar.nextLine();

		}

		return totalConta;
	}

}
