package pessoas;

import java.io.Serializable;
import java.util.Scanner;

public class PessoaFisica extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void introduzirCPF(String cpf) {
		
		this.cpf = cpf;
		
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String indruzirDados(int id, String nome, String email, String celular, String uf, String cidade,
			String rua, String bairro, String numero, String cep, String complemento) {
		// TODO Auto-generated method stub
		
		Scanner logar = new Scanner(System.in);
		
		System.out.println("Informe seu CPF:");
		String cpf = logar.nextLine();
		
		if(cpf.equals("")) {
			cpf = Integer.toString(id);
		}
		this.setCpf(cpf);
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
	
		return cpf;
		
	}
	
}
