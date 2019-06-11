package informacoes;

import java.io.File;
import java.util.Scanner;

public class Increment {
	
	public static void Cadastrar() {
			
			
		    File directory = new File("PRODUTOS/");
		    
		    Scanner logar = new Scanner(System.in);
		    
		    
		    int fileCount = (int)directory.list().length;
		    
		    
		    System.out.println("File Count:"+ fileCount);
		    
		    
			
			
			System.out.println("Agora gostaria que Vossa senhoria colocasse seus dados.");
		
		
			System.out.println("\t\tSeu nome: ");
			String nomeProduto = logar.nextLine();
			
			System.out.println("\t\t Preço: ");
			float precoProduto = Float.parseFloat(logar.nextLine());
			
			System.out.println("\t\tQuantidade de produtos: ");
			int quantProduto = Integer.parseInt(logar.nextLine());
	
			AdcProd.introduzirProd(fileCount, nomeProduto, precoProduto, quantProduto);
			//logar.close();
		}

	}

