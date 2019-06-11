package pessoas;

import java.io.Serializable;

import java.util.Scanner;

public class Pessoa extends Endereco implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String email;
	private String celular;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}


}
