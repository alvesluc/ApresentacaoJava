package fornecedores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



// Serializar e deserializar qualquer tipo de objeto
public class ArquivoSerializadoUtilFornecedor {

	// Gravar arquivo serializado
	static FileOutputStream fos;
	static ObjectOutputStream oos;

	public static boolean gravaObjetoSerializado(String fornecedor, int id, Serializable objeto) {

		try {

			fos = new FileOutputStream("Fornecedores/" + fornecedor + "/" + id + ".txt");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(objeto);
			oos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			System.out.println("Arquivo n�o encontrado");

			return false;

		} catch (IOException e) {
			// TODO Auto-generated catch block

			// Pode cair na PROVA!
			// unrechable -> trecho de codigo que nunca vai ser alcan�ado
			// return false; --> erro de compila��o (sempre que nao � alcan�ado)

			System.out.println("Erro ao acessar arquivo!");

			return false;
		} finally {
			fos = null;
			oos = null;
		}

		return true;
	}

	// Ler arquivo serializado
	static FileInputStream fis;
	static ObjectInputStream ois;

	public static Object lerArquivoSerializado(String fornecedor, String categoria , String id) {

		try {
					
			fis = new FileInputStream("FORNECEDORES/" + fornecedor + "/" + "CATEGORIA/" + categoria + "/" + id + ".txt");
			ois = new ObjectInputStream(fis);

			Object o = ois.readObject();
			ois.close();
			fis.close();
			return o;

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo n�o encontrado");

		} catch (IOException e) {
			System.out.println("Erro ao tentar acessar arquivo.");

		} catch (ClassNotFoundException e) {
			System.out.println("Classe n�o existe.");

		} finally {
			fis = null;
			ois = null;
			
		}

		return null;
	}
	

}
