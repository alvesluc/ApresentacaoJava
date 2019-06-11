package informacoes;

import java.io.Serializable;

public class Produto implements Serializable {

	/**
	 * Serial implementado automaticamente.
	 */
	private static final long serialVersionUID = -5393150616591201272L;
	// Atributos
	private int id;
	private String nome;
	private float precovenda;
	private int qtde_estoque;


	// Constructor vazio
	public Produto() {

	}

	// Constructor completo
	public Produto(int id, String nome, float precovenda, int qtde_estoque) {
		this.id = id;
		this.nome = nome;
		this.precovenda = precovenda;
		this.qtde_estoque = qtde_estoque;
	}

	// Getteres e Setteres
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

	public float getPrecovenda() {
		return precovenda;
	}

	public void setPrecovenda(float precovenda) {
		this.precovenda = precovenda;
	}

	public int getQtde_estoque() {
		return qtde_estoque;
	}

	public void setQtde_estoque(int qtde_estoque) {
		this.qtde_estoque = qtde_estoque;
	}

	public int cadastrarProduto(int id, String nome, float precovenda, int qtde_estoque) {
		if (id < 0) {
			System.out.println("ID inválido!");
			return 0;
		}
		if (nome.equals(null)) {
			System.out.println("Nome inválido!");
			return 0;
		}
		if (precovenda < 0) {
			System.out.println("Preço inválido!");
			return 0;
		}
		if (qtde_estoque < 0) {
			System.out.println("Quantidade inválida!");
			return 0;
		} else {
			System.out.println("Cadastrado com sucesso!");
			this.setId(id);
			this.setNome(nome);
			this.setPrecovenda(precovenda);
			this.setQtde_estoque(qtde_estoque);
			return 1;
		}
	}

}
