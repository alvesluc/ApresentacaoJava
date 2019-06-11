package pessoas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Serializar e deserializar qualquer tipo de objeto
public class ArquivoSerializadoUtil {

	// Gravar arquivo serializado
	static FileOutputStream fos;
	static ObjectOutputStream oos;

	public static boolean gravaPessoaSerializado(int ident,int tipo, String nome, Serializable objeto) {

		try {
			if(ident == 1) {
				
				if(tipo == 1) {
					fos = new FileOutputStream("Fontes/Cliente/CPF/"+ nome +".txt");
					oos = new ObjectOutputStream(fos);
					
					oos.writeObject(objeto);
					oos.close();
					fos.close();
				
				}else if(tipo == 2) {
					fos = new FileOutputStream("Fontes/Cliente/CNPJ/"+ nome +".txt");
					oos = new ObjectOutputStream(fos);
					
					oos.writeObject(objeto);
					oos.close();
					fos.close();
				}
					
			}else if(ident == 2){
				
				if(tipo == 1) {
					fos = new FileOutputStream("Fontes/Endereco/CPF/"+ nome +".txt");
					oos = new ObjectOutputStream(fos);
					
					oos.writeObject(objeto);
					oos.close();
					fos.close();
				
				}else if (tipo == 2) {
					fos = new FileOutputStream("Fontes/Endereco/CNPJ/"+ nome +".txt");
					oos = new ObjectOutputStream(fos);
					
					oos.writeObject(objeto);
					oos.close();
					fos.close();
					
				}
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			System.out.println("Arquivo não encontrado");

			return false;

		} catch (IOException e) {
			// TODO Auto-generated catch block

			// Pode cair na PROVA!
			// unrechable -> trecho de codigo que nunca vai ser alcançado
			// return false; --> erro de compilação (sempre que nao é alcançado)

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

	public static Object lerPessoaSerializado(int ident, String local, String nome) {

		try {
			if(ident == 1) {
				
			
					fis = new FileInputStream("Fontes/Cliente/"+local+"/"+ nome + ".txt");
					ois = new ObjectInputStream(fis);
					
					Object o = ois.readObject();
					ois.close();
					fis.close();
					System.out.println("Ta ok.");
					return o;
			
			}else if(ident == 2){
				fis = new FileInputStream("Fontes/Cliente/Endereco/"+ local + "/"+ nome +".txt");	
				ois = new ObjectInputStream(fis);
				
				Object o = ois.readObject();
				ois.close();
				fis.close();
				System.out.println("Ta ok.");
				return o;
				}
		} catch (FileNotFoundException e) {

			System.out.println("Arquivo não encontrado");

		} catch (IOException e) {

			System.out.println("Erro ao tentar acessar arquivo.");

		} catch (ClassNotFoundException e) {

			System.out.println("Classe não existe.");

		} finally {
			fis = null;
			ois = null;
		}
		return null;
	}
	
	public static boolean gravaUsuarioSerializado(String nome, String senha, Serializable objeto) {

		try {
			
			fos = new FileOutputStream("Fontes/Usuario/"+ nome +"-"+ senha +".txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(objeto);
			oos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			System.out.println("Arquivo não encontrado");

			return false;

		} catch (IOException e) {
			// TODO Auto-generated catch block

			// Pode cair na PROVA!
			// unrechable -> trecho de codigo que nunca vai ser alcançado
			// return false; --> erro de compilação (sempre que nao é alcançado)

			System.out.println("Erro ao acessar arquivo!");

			return false;
		} finally {
			fos = null;
			oos = null;
		}

		return true;
	}

}
