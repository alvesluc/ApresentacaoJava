package pessoas;

import java.io.Serializable;
import java.util.Scanner;

public class PessoaJuridica extends Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public void introduzirCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}
	

	public String indruzirDados(int id, String nome, String email, String celular, String uf, String cidade,
			String rua, String bairro, String numero, String cep, String complemento) {
		// TODO Auto-generated method stub
		
		Scanner logar = new Scanner(System.in);
		
		System.out.println("Informe seu CNPJ:");
		String cnpj = logar.nextLine();
		
		if(cnpj.equals("")) {
			cnpj = Integer.toString(id);
		}
		
		this.setCnpj(cnpj);
		this.setNome(nome);
		this.setId(id);
		this.setEmail(email);
		this.setCelular(celular);
		this.setUf(uf);
		this.setCidade(cidade);
		this.setRua(rua);
		this.setBairro(bairro);
		this.setNumero(numero);
		this.setCep(cep);
		this.setComplemento(complemento);
	
		return cnpj;
		
	}
	
}

