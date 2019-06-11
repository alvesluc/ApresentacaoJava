package informacoes;

import java.io.File;
import java.util.Scanner;

public class AlteraCategoria {

	public static void alteraCategoria(String categoria) {
		if (categoria.equals("")) {
			System.out.println("Categoria inv�lida.");
		} else if (categoria.contains("/")) {
		} else {
			File dir = new File("CATEGORIA/" + categoria + "/");
			@SuppressWarnings("resource")
			Scanner leitor = new Scanner(System.in);

			if (!dir.isDirectory()) {
				System.err.println("Essa categoria n�o existe.");
			} else {
				System.out.println("Informe o novo nome da categoria: ");
				String novoNome = leitor.nextLine();
				if (novoNome.equals("")) {
					System.out.println("Altera��o invalidada.");
				} else {
					File newDir = new File(dir.getParent() + "/" + novoNome);
					dir.renameTo(newDir);
				}
			}
		}
	}
}
