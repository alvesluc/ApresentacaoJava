package informacoes;

import java.io.File;
import java.util.Scanner;

public class AdcCategoria {
	
	public static void adcionaCategoria() {
		
		System.out.println("Informe a categoria a ser adcionada: ");
		@SuppressWarnings("resource")
		
		Scanner leitor = new Scanner(System.in);
		String categoria = leitor.nextLine();
		
		File file = new File("Categoria\\" + categoria);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Categoria adcionada!");
			} else {
				System.out.println("Falha na criação da categoria!");
			}
		}
		
	}

}
