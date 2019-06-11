package informacoes;

import java.util.Scanner;
import java.io.File;

public class AdcProdManual {

public static void adcionaProduto(){
	@SuppressWarnings("resource")
	Scanner leitor = new Scanner(System.in);

	System.out.println("Primeiro, imforme a categoria do produto: ");
	String categoria = leitor.nextLine();
	
	File file = new File("Categoria\\" + categoria);
	if (!file.exists()) {
		if (file.mkdir()) {
			System.out.println("Categoria " + categoria + " adcionada!");
		} else {
			System.out.println("Falha na criação da categoria!");
		}
	}
	
	int fileCount=file.list().length;
	
	System.out.println("Informe o nome do produto: ");
	String nomeprod = leitor.nextLine();
	if (nomeprod.equals("")) {
		nomeprod = "NomeTemporario";
	}
	Produto produto = new Produto();
	
	produto.setNome(nomeprod);
	int id = ++fileCount;
	produto.setId(id);
	
	try {
		System.out.println("Preço: ");
		float preco = Float.parseFloat(leitor.nextLine());
		produto.setPrecovenda(preco);
		
	} catch (NumberFormatException e) {
		System.out.println("Preço inválido!");
		produto.setPrecovenda(0);
	}
	
	System.out.println("Quantidade: ");
	try {
		int qtd = Integer.parseInt(leitor.nextLine());
		produto.setQtde_estoque(qtd);
	} catch (Exception e) {
		System.out.println("Quantidade inválida!");
		produto.setQtde_estoque(0);
	}
	

	// Gravar o objeto de um jeito muito mais limpo
	boolean gravou = ArquivoSerializadoUtilInformacoes.gravaObjetoSerializado(categoria, produto.getId(), produto);

	if (gravou) {
		System.out.println(nomeprod + " adicionado com sucesso!");
	} else {
		System.out.println("O produto não foi adicionado.");
	}

}

}
