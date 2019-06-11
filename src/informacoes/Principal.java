package informacoes;

import java.io.File;
import java.util.Scanner;

import caixa.Operacoes;
import fornecedores.Fornecedor;
import pessoas.AlteraPessoa;
import pessoas.Increment;
import pessoas.ListaInfo;
import pessoas.ListaPessoa;
import pessoas.RemovePessoa;
import pessoas.Usuario;

public class Principal {

	public static void main(String[] args) {
		
		//Inicialização de variáveis globais.
		float contaTotal = 0;
		String categoria = "";
		int verif;

		Scanner leitor = new Scanner(System.in);

		System.out.println("Bem Vindo ao CyberCafé!");
		
		
		do {
			verif = Usuario.fazerLogin();
			if(verif == 1) {
				
				System.out.println("Login realizado com sucesso!\n");
					
			String opcaoMenu;
			do {
				System.out.println(
						"Qual Função deseja ultilizar?" + 
						"\n*------------MENU-------------*" +
						"\n|1 - Ir às compras	      |" +
						"\n|2 - Informações    	      |" +
						"\n|3 - Reabastecimento 	      |" +
						"\n|0 - Fechar		      |"+
						"\n*-----------------------------*");

				opcaoMenu = leitor.nextLine();

				switch (opcaoMenu) {
				case "1":
					System.out.println("Informe a categoria do produto: ");
					ListaCategoria.listaCategoria();
					categoria = leitor.nextLine();
					contaTotal = contaTotal + SystemVenda.vender(categoria);
					System.out.println("A conta final foi: " + contaTotal);
					Operacoes.totalCaixa(contaTotal);
					Operacoes.valorCaixa();
					Operacoes.gerarLucro(contaTotal);
					break;
				case "2":
					System.out.println(
							"\nQual função deseja utilizar?" + 
							"\n*------------MENU-------------*" +
							"\n|1 - Adicionar	              |" +
							"\n|2 - Remover    	      |" +
							"\n|3 - Alterar 	              |" +
							"\n|4 - Listar                   |"+
							"\n|5 - Lucro total              |"+
							"\n|0 - Voltar		      |"+
							"\n*-----------------------------*");

					System.out.println("O que você deseja fazer?");
					String opcaoFuncao = leitor.nextLine();
					
					switch (opcaoFuncao) {
					case "1":
						do {
						System.out.println(
								"\nO que você deseja adcionar?" + 
								"\n*------------MENU-------------*" +
								"\n|1 - Produto	              |" +
								"\n|2 - Categoria    	      |" +
								"\n|3 - Cliente 	              |" +
								"\n|4 - Fornecedor		      |"+
								"\n|0 - Voltar		      |"+
								"\n*-----------------------------*");

						opcaoFuncao = leitor.nextLine();
						
						if(opcaoFuncao.equals("1")) {
							ListaCategoria.listaCategoria();
							AdcProdManual.adcionaProduto();
						}else if(opcaoFuncao.equals("2")) {
							AdcCategoria.adcionaCategoria();
						}else if(opcaoFuncao.equals("3")) {
							Increment.Cadastrar();
						}else if(opcaoFuncao.equals("4")) {
							Fornecedor.adcionarFornecedor();
						}else if(opcaoFuncao.equals("0")) {
							System.out.println("Voltando para o menu...");
							break;
						}else {
							System.out.println("Opção inválida!");
						}
						}while(!opcaoFuncao.equals("0"));
						break;
					case "2":
						do {
						System.out.println(
								"\nO que você deseja remover?" + 
								"\n*------------MENU-------------*" +
								"\n|1 - Produto	              |" +
								"\n|2 - Categoria    	      |" +
								"\n|3 - Cliente 	              |" +
								"\n|4 - Fornecedor		      |"+
								"\n|0 - Voltar		      |" +
								"\n*-----------------------------*");

						opcaoFuncao = leitor.nextLine();
						
						if(opcaoFuncao.equals("1")) {
							ListaCategoria.listaCategoria();
							
							System.out.println("Informe a categoria do produto a ser removido: ");
							categoria = leitor.nextLine();
							try {
								File directory = new File("CATEGORIA/" + categoria + "/");
								int fileCount = (int) directory.list().length;

								for (int i = 1; i <= fileCount; i++) {
									String id = Integer.toString(i);
									ListaProd.listar(categoria, id);
								}
								try {
									System.out.println("Remover produto: ");
									int id = Integer.parseInt(leitor.nextLine());
									RemoveProd.remove(categoria, id);									
								} catch (NumberFormatException e) {
									// TODO: handle exception
								}

							} catch (NullPointerException e) {
								System.out.println("Categoria inválida.");
							}
							
						}else if(opcaoFuncao.equals("2")) {
							ListaCategoria.listaCategoria();
							try {
								System.out.println("Informe a categoria que será removida: ");
								String categoriaR = leitor.nextLine();
								RemoveCategoria.removeCategoria(categoriaR);
									
							} catch (NumberFormatException e) {
								System.out.println("Opção inválida!");
							}
							
						}else if(opcaoFuncao.equals("3")) {

							System.out.println("O cliente a ser removido é identificado por: "
									+ "\n1 - CPF"
									+ "\n2 - CNPJ");
							try {
								String documento = leitor.nextLine();
								if (documento.equals("1")) {
									ListaInfo.listaInfoCPF();
									System.out.println("Informe o CPF do cliente que você deseja remover informações.");
									String cpf = leitor.nextLine();
									RemovePessoa.removePessoaF(cpf);
									
								}else if (documento.equals("2")) {
									ListaInfo.listaInfoCNPJ();
									System.out.println("Informe o CNPJ do cliente que você deseja remover informações.");
									String cnpj = leitor.nextLine();
									RemovePessoa.removePessoaJ(cnpj);
								}
							} catch (NumberFormatException e) {
								System.out.println("Entrada inválida.");
							}
							
							
						}else if(opcaoFuncao.equals("4")) {
							Fornecedor.listaFornecedores();
							try {
								System.out.println("Informe o fornecedor que será removido: ");
								String fornecedorR = leitor.nextLine();
								Fornecedor.removeFornecedor(fornecedorR);
							
							} catch (NumberFormatException e) {
								System.out.println("Entrada inválida.");
							}
						}else if(opcaoFuncao.equals("0")) {
							System.out.println("Voltando para o menu...");
							break;
						}else {
							System.out.println("Opção inválida!");
						}
						}while(!opcaoFuncao.equals("0"));
						break;
					case "3":
						do {
							System.out.println(
								"\nO que você deseja alterar?" + 
								"\n*------------MENU-------------*" +
								"\n|1 - Produto	              |" +
								"\n|2 - Categoria    	      |" +
								"\n|3 - Cliente 	              |" +
								"\n|4 - Fornecedor		      |"+
								"\n|0 - Voltar		      |"+
								"\n*-----------------------------*");

							opcaoFuncao = leitor.nextLine();
						
							if(opcaoFuncao.equals("1")) {
								ListaCategoria.listaCategoria();
								try {
									
								} catch (Exception e) {
									// TODO: handle exception
								}
								AlteraProd.alteraProd();
							}else if(opcaoFuncao.equals("2")) {
								ListaCategoria.listaCategoria();
								System.out.println("Informe a categoria a ser alterada: ");
								String categoriaA = leitor.nextLine();
								AlteraCategoria.alteraCategoria(categoriaA);
							}else if(opcaoFuncao.equals("3")) {
								System.out.println("O cliente a ser alterado é identificado por: "
										+ "\n1 - CPF"
										+ "\n2 - CNPJ");
								String documento = leitor.nextLine();
								if (documento.equals("1")) {
									ListaInfo.listaInfoCPF();
									System.out.println("Informe o CPF do cliente que você deseja alterar as informações.");
									String cpf = leitor.nextLine();
									try {
										AlteraPessoa.alteraPessoaF(cpf);
										
									} catch (NullPointerException e) {
										System.out.println("Entrada inválida.");
									}
								
								}else if (documento.equals("2")) {
									ListaInfo.listaInfoCNPJ();
									System.out.println("Informe o CNPJ do cliente que você deseja ver as informações.");
									String cnpj = leitor.nextLine();
									try {
										AlteraPessoa.alteraPessoaJ(cnpj);		
										
									} catch (NullPointerException e) {
										System.out.println("Entrada inválida.");
									}
								
								}
							}else if(opcaoFuncao.equals("4")) {
							
								Fornecedor.listaFornecedores();
								System.out.println("Informe o fornecedor a ser alterado: ");
								String fornecedorA = leitor.nextLine();
								Fornecedor.alteraFornecedor(fornecedorA);
								
							
							}else if(opcaoFuncao.equals("0")) {
								System.out.println("Voltando para o menu...");
							}
						
						}while(!opcaoFuncao.equals("0"));
						break;
					case "4":
						do {
						System.out.println(
								"\nO que você deseja listar?" + 
								"\n*------------MENU-------------*" +
								"\n|1 - Produtos	              |" +
								"\n|2 - Categorias    	      |" +
								"\n|3 - Clientes	              |" +
								"\n|4 - Fornecedor		      |"+
								"\n|0 - Voltar		      |"+
								"\n*-----------------------------*");

						System.out.println("O que você deseja fazer?");
						opcaoFuncao = leitor.nextLine();
						if(opcaoFuncao.equals("1")) {
							
							System.out.println("Informe a categoria dos produtos a serem listados: ");
							ListaCategoria.listaCategoria();
							try {
								String categoriaL = leitor.nextLine();
								File directory = new File("CATEGORIA/" + categoriaL + "/");
					
								int fileCount = (int)directory.list().length;			
								for(int i = 1; i <= fileCount; i++) {
									String id = Integer.toString(i);
									ListaProd.listar(categoriaL, id);
									
								}				
							} catch (NullPointerException e) {
								System.out.println("Categoria inválida.");
							}

						}else if(opcaoFuncao.equals("2")) {
							System.out.println("Essas são as categorias existentes:");
							ListaCategoria.listaCategoria();
						}else if(opcaoFuncao.equals("3")) {
							System.out.println("Escolha o identificador do cliente: "
									+ "\n1 - CPF"
									+ "\n2 - CNPJ");
							String documento = leitor.nextLine();
							if (documento.equals("1")) {
								ListaInfo.listaInfoCPF();
								System.out.println("Informe o CPF do cliente que você deseja ver as informações.");
								String cpf = leitor.nextLine();
								ListaPessoa.listaPF(cpf);
							}else if (documento.equals("2")) {
								ListaInfo.listaInfoCNPJ();
								System.out.println("Informe o CNPJ do cliente que você deseja ver as informações.");
								String cnpj = leitor.nextLine();
								ListaPessoa.listaPJ(cnpj);
							}else {
								System.out.println("Indentificador inválido.");
							}
						}else if(opcaoFuncao.equals("4")) {
							System.out.println("Esses são os fornecedores existentes:");
							Fornecedor.listaFornecedores();
						}else if(opcaoFuncao.equals("0")) {
							System.out.println("Voltando para o menu...");
							break;
						}else {
							System.out.println("Opção inválida!");
						}
						}while(!opcaoFuncao.equals("0"));
						break;
					case "5":
						Operacoes.mostraLucro();
						break;
					case "0":	
						System.out.println("\nVoltando ao menu principal...");
						break;
					default:
						System.out.println("Opção inválida!");
						break;
					}
					
					break;
				case "3":
					float gasto = Fornecedor.compraFornecedor();
					gasto = gasto * -1;
					Operacoes.gerarLucro(gasto);
					break;

				case "0":
					System.out.println("Você saiu.");

					break;

				default:

					System.out.println("Opção inválida!");
					break;
				}
			} while (!opcaoMenu.equals("0"));
			Operacoes.valorCaixa();
		
		}
		else {
			System.out.println("Credenciais inválidas!");
		}
		}while(verif != 1);
		leitor.close();
	}
}
