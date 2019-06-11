package fornecedores;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

import caixa.ArquivoSerializadoUtil;
import caixa.Caixa;
import caixa.Operacoes;
import informacoes.ArquivoSerializadoUtilInformacoes;
import informacoes.ListaCategoria;
import informacoes.ListaProd;
import informacoes.Produto;

public class Fornecedor {

	public static void adcionarFornecedor() {

		System.out.println("Informe o nome do novo fornecedor: ");
		@SuppressWarnings("resource")

		Scanner leitor = new Scanner(System.in);
		String fornecedor = leitor.nextLine();

		File file = new File("FORNECEDORES\\" + fornecedor);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Fornecedor adcionado!");
			} else {
				System.out.println("Falha na adição do fornecedor!");
			}
		}
	}

	public static void alteraFornecedor(String fornecedor) {
		if (fornecedor.equals("")) {
			System.out.println("Fornecedor inválido.");
		} else if(fornecedor.contains("/")){
			System.out.println("Entrada inválida");
		} else{ File dir = new File("FORNECEDORES/" + fornecedor + "/");
			@SuppressWarnings("resource")
			Scanner leitor = new Scanner(System.in);

			if (!dir.isDirectory()) {
				System.err.println("Esse fornecedor não existe.");
			} else {
				System.out.println("Informe o novo nome do fornecedor: ");
				String novoNome = leitor.nextLine();
				if (novoNome.equals("")) {
					System.out.println("Alteração invalidada.");
				} else {
					File newDir = new File(dir.getParent() + "/" + novoNome);
					dir.renameTo(newDir);
					System.out.println("Alterado com sucesso.");
				}
			}
			
		}
	}

	public static void removeFornecedor(String fornecedor) {
		String folder = "FORNECEDORES/" + fornecedor + "/";
		// delete folder recursively
		recursiveDelete(new File(folder));
	}

	public static void recursiveDelete(File file) {
		// to end the recursive loop
		if (!file.exists())
			return;

		// if directory, go inside and call recursively
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				// call recursively
				recursiveDelete(f);
			}
		}
		// call delete to delete files and empty directory
		file.delete();
		System.out.println("Fornecedor apagado: " + file.getAbsolutePath());
	}

	public static void listaFornecedores() {

		File file = new File("FORNECEDORES/");
		String[] directories = file.list(new FilenameFilter() {
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});

		System.out.println(Arrays.toString(directories));

	}

	public static float compraFornecedor() {
		
		Caixa caixaLoja = (Caixa) ArquivoSerializadoUtil.lerCaixaSerializado();
		float disponivel = caixaLoja.getDinheirocaixa();
		System.out.println("Valor disponível para compra: " + caixaLoja.getDinheirocaixa());
		Scanner leitor = new Scanner(System.in);
		String fornecedor = "";
		String categoria = "";
		
		try {
			System.out.println("Escolha um fornecedor e sua categoria: ");
			listaFornecedores();
			ListaCategoria.listaCategoria();
			
			System.out.println("Fornecedor: ");
			fornecedor = leitor.nextLine();

			System.out.println("Categoria: ");
			categoria = leitor.nextLine();

			File directory = new File("FORNECEDORES/" + fornecedor + "/CATEGORIA/" + categoria + "/");
			int fileCount = (int) directory.list().length;

			for (int i = 1; i <= fileCount; i++) {
				String id = Integer.toString(i);
				ListaProd.fornecer(fornecedor, categoria, id);
			}
		} catch (NullPointerException e) {
			System.out.println("Há uma entrada inválida.");
		}
		
		

		String buscaID;

		float totalPreco = 0;

		System.out.println("Digite o ID do produto que deseja ou 0 para sair:");
		buscaID = leitor.nextLine();

		while (!buscaID.equals("0")) {

			if (disponivel > 0) {
				File existe = new File(
						"FORNECEDORES/" + fornecedor + "/CATEGORIA/" + categoria + "/" + buscaID + ".txt");
				boolean taOk = existe.exists();

				if (taOk) {

					System.out.println("Digite a quantidade que deseja comprar: ");
					int buscaQuant = Integer.parseInt(leitor.nextLine());

					Produto pegarItem = (Produto) ArquivoSerializadoUtilFornecedor.lerArquivoSerializado(fornecedor,
							categoria, buscaID);
					Produto pegarAlterado = pegarItem;

					totalPreco = pegarItem.getPrecovenda() * buscaQuant;

					if (totalPreco > disponivel) {
						System.out.println("Você não tem dinheiro suficiente.");
					} else {
						pegarItem.setQtde_estoque(pegarItem.getQtde_estoque() + buscaQuant);

						boolean gravou = ArquivoSerializadoUtilInformacoes.gravaObjetoSerializado(categoria,
								pegarItem.getId(), pegarAlterado);

						if (gravou) {
							disponivel = disponivel - totalPreco;
							Operacoes.comprarComCaixa(disponivel);

							System.out.println("Operação realizada com sucesso.");
						}

					}

				} else {
					System.out.println("Entre com um valor existente.");
				}
				System.out.println("Digite o ID do produto que deseja ou 0 para sair:");
				buscaID = leitor.nextLine();
			}

		}
		return totalPreco;
	}

}
