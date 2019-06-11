package informacoes;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class ListaCategoria {

	public static void listaCategoria() {
		
		File file = new File("CATEGORIA/");
		String[] directories = file.list(new FilenameFilter() {
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		
		System.out.println(Arrays.toString(directories));
		
	}
	
}
