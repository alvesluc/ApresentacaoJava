package pessoas;

import java.util.Scanner;

public class AlteraPessoa extends Pessoa {
	
	private static final long serialVersionUID = 1L;
		
	public static void alteraPessoaF(String param) {

			String opcao;
			String menu;
			Scanner leitor = new Scanner(System.in);

			do {
				
				PessoaFisica pessoaFLeitura = (PessoaFisica) ArquivoSerializadoUtil.lerPessoaSerializado(1, "CPF", param);
				PessoaFisica pessoaFAlterado = pessoaFLeitura;
				System.out.println("\nNOME        : " + 		pessoaFLeitura.getNome());
				System.out.println("EMAIL       : " + 		pessoaFLeitura.getEmail());
				System.out.println("CELULAR     : " + 	pessoaFLeitura.getCelular());
				System.out.println("UF          : " + 		pessoaFLeitura.getUf());
				System.out.println("CIDADE      : " + 	pessoaFLeitura.getCidade());
				System.out.println("RUA         : " + 		pessoaFLeitura.getRua() + ",Nº " + pessoaFLeitura.getNumero());
				System.out.println("BAIRRO      : " + 	pessoaFLeitura.getBairro());
				System.out.println("CEP         : " + 		pessoaFLeitura.getCep());
				System.out.println("COMPLEMENTO : " + 			pessoaFLeitura.getComplemento() + "\n");

				
				System.out.println("Alterar informação de " + pessoaFLeitura.getNome() + " ?"
						+ "\n1- SIM"
						+ "\n2- NÃO");

				opcao = leitor.nextLine();
				
				if (opcao.equals("1")) {
					
					System.out.println("Qual das seguintes informações você deseja alterar?" + "\n1- NOME" + "\n2- EMAIL"
									+ "\n3- CELULAR" + "\n4- UF" + "\n5- CIDADE" + "\n6- RUA" + "\n7- BAIRRO" + "\n8- NUMERO"
									+ "\n9- CEP" + "\n10- COMPLEMENTO");
					menu = leitor.nextLine();
					switch (menu) {
					case "1":
						System.out.println("O nome atual é: " + pessoaFLeitura.getNome() + "\n" + "Insira o novo nome: ");
						String nome = leitor.nextLine();
						pessoaFLeitura.setNome(nome);
						System.out.println("Novo nome: " + pessoaFLeitura.getNome());
						break;
					case "2":
						System.out.println("O email atual é: " + pessoaFLeitura.getEmail() + "\n" + "Insira o novo email: ");
						String email = leitor.nextLine();
						pessoaFLeitura.setEmail(email);
						System.out.println("Novo email: " + pessoaFLeitura.getEmail());
						break;
					case "3":
						System.out.println("O celular atual é: " + pessoaFLeitura.getCelular()+ "\n" + "Insira o novo celular: ");
						String celular = leitor.nextLine();
						pessoaFLeitura.setCelular(celular);
						System.out.println("Novo celular: " + pessoaFLeitura.getCelular());
						break;
					case "4":
						System.out.println("O UF atual é: " + pessoaFLeitura.getUf()+ "\n" + "Insira o novo UF: ");
						String uf = leitor.nextLine();
						pessoaFLeitura.setCelular(uf);
						System.out.println("Novo UF: " + pessoaFLeitura.getUf());
						break;
					case "5":
						System.out.println("A cidade atual é: " + pessoaFLeitura.getCidade()+ "\n" + "Insira a nova cidade: ");
						String cidade = leitor.nextLine();
						pessoaFLeitura.setCelular(cidade);
						System.out.println("Nova cidade: " + pessoaFLeitura.getCidade());
						break;
					case "6":
						System.out.println("A rua atual é: " + pessoaFLeitura.getRua()+ "\n" + "Insira a nova rua: ");
						String rua = leitor.nextLine();
						pessoaFLeitura.setCelular(rua);
						System.out.println("Nova rua: " + pessoaFLeitura.getRua());
						break;
					case "7":
						System.out.println("O bairro atual é: " + pessoaFLeitura.getBairro()+ "\n" + "Insira o novo bairro: ");
						String bairro = leitor.nextLine();
						pessoaFLeitura.setCelular(bairro);
						System.out.println("Novo bairro: " + pessoaFLeitura.getBairro());
						break;
					case "8":
						System.out.println("O numero atual é: " + pessoaFLeitura.getNumero()+ "\n" + "Insira o novo numero: ");
						String numero = leitor.nextLine();
						pessoaFLeitura.setCelular(numero);
						System.out.println("Novo numero: " + pessoaFLeitura.getNumero());
						break;
					case "9":
						System.out.println("O CEP atual é: " + pessoaFLeitura.getCep()+ "\n" + "Insira o novo CEP: ");
						String cep = leitor.nextLine();
						pessoaFLeitura.setCelular(cep);
						System.out.println("Novo CEP: " + pessoaFLeitura.getCep());
						break;
					case "10":
						System.out.println("O complemento atual é: " + pessoaFLeitura.getComplemento()+ "\n" + "Insira o novo complemento: ");
						String complemento = leitor.nextLine();
						pessoaFLeitura.setCelular(complemento);
						System.out.println("Novo complemento: " + pessoaFLeitura.getComplemento());
						break;
					default:
						System.out.println("Por favor, selecione uma opção válida.");
						break;
					}
					boolean gravou = ArquivoSerializadoUtil.gravaPessoaSerializado(1, 1, param, pessoaFAlterado);

					if (gravou) {
						System.out.println(pessoaFLeitura.getNome() + " alterado com sucesso!");
					} else {
						System.out.println("A alteração não pôde ser realizada.");
					}
				}

			} while (!opcao.equals("2"));
		}
		
	
	public static void alteraPessoaJ(String param) {
		String opcao;
		String menu;
		Scanner leitor = new Scanner(System.in);

		do {
			
			PessoaJuridica pessoaJLeitura = (PessoaJuridica) ArquivoSerializadoUtil.lerPessoaSerializado(1, "CNPJ", param);
			PessoaJuridica pessoaJAlterado = pessoaJLeitura;
			System.out.println("\nNOME        : " + 		pessoaJLeitura.getNome());
			System.out.println("EMAIL       : " + 		pessoaJLeitura.getEmail());
			System.out.println("CELULAR     : " + 	pessoaJLeitura.getCelular());
			System.out.println("UF          : " + 		pessoaJLeitura.getUf());
			System.out.println("CIDADE      : " + 	pessoaJLeitura.getCidade());
			System.out.println("RUA         : " + 		pessoaJLeitura.getRua() + ", Nº " + pessoaJLeitura.getNumero());
			System.out.println("BAIRRO      : " + 	pessoaJLeitura.getBairro());
			System.out.println("CEP         : " + 		pessoaJLeitura.getCep());
			System.out.println("COMPLEMENTO : " + 			pessoaJLeitura.getComplemento() + "\n");

			
			System.out.println("Alterar informação de " + pessoaJLeitura.getNome() + " ?"
					+ "\n1- SIM"
					+ "\n2- NÃO");

			opcao = leitor.nextLine();
			
			if (opcao.equals("1")) {
				
				System.out.println("Qual das seguintes informações você deseja alterar?" + "\n1- NOME" + "\n2- EMAIL"
								+ "\n3- CELULAR" + "\n4- UF" + "\n5- CIDADE" + "\n6- RUA" + "\n7- BAIRRO" + "\n8- NUMERO"
								+ "\n9- CEP" + "\n10- COMPLEMENTO");
				menu = leitor.nextLine();
				switch (menu) {
				case "1":
					System.out.println("O nome atual é: " + pessoaJLeitura.getNome() + "\n" + "Insira o novo nome: ");
					String nome = leitor.nextLine();
					pessoaJLeitura.setNome(nome);
					System.out.println("Novo nome: " + pessoaJLeitura.getNome());
					break;
				case "2":
					System.out.println("O email atual é: " + pessoaJLeitura.getEmail() + "\n" + "Insira o novo email: ");
					String email = leitor.nextLine();
					pessoaJLeitura.setEmail(email);
					System.out.println("Novo email: " + pessoaJLeitura.getEmail());
					break;
				case "3":
					System.out.println("O celular atual é: " + pessoaJLeitura.getCelular()+ "\n" + "Insira o novo celular: ");
					String celular = leitor.nextLine();
					pessoaJLeitura.setCelular(celular);
					System.out.println("Novo celular: " + pessoaJLeitura.getCelular());
					break;
				case "4":
					System.out.println("O UF atual é: " + pessoaJLeitura.getUf()+ "\n" + "Insira o novo UF: ");
					String uf = leitor.nextLine();
					pessoaJLeitura.setCelular(uf);
					System.out.println("Novo UF: " + pessoaJLeitura.getUf());
					break;
				case "5":
					System.out.println("A cidade atual é: " + pessoaJLeitura.getCidade()+ "\n" + "Insira a nova cidade: ");
					String cidade = leitor.nextLine();
					pessoaJLeitura.setCelular(cidade);
					System.out.println("Nova cidade: " + pessoaJLeitura.getCidade());
					break;
				case "6":
					System.out.println("A rua atual é: " + pessoaJLeitura.getRua()+ "\n" + "Insira a nova rua: ");
					String rua = leitor.nextLine();
					pessoaJLeitura.setCelular(rua);
					System.out.println("Nova rua: " + pessoaJLeitura.getRua());
					break;
				case "7":
					System.out.println("O bairro atual é: " + pessoaJLeitura.getBairro()+ "\n" + "Insira o novo bairro: ");
					String bairro = leitor.nextLine();
					pessoaJLeitura.setCelular(bairro);
					System.out.println("Novo bairro: " + pessoaJLeitura.getBairro());
					break;
				case "8":
					System.out.println("O numero atual é: " + pessoaJLeitura.getNumero()+ "\n" + "Insira o novo numero: ");
					String numero = leitor.nextLine();
					pessoaJLeitura.setCelular(numero);
					System.out.println("Novo numero: " + pessoaJLeitura.getNumero());
					break;
				case "9":
					System.out.println("O CEP atual é: " + pessoaJLeitura.getCep()+ "\n" + "Insira o novo CEP: ");
					String cep = leitor.nextLine();
					pessoaJLeitura.setCelular(cep);
					System.out.println("Novo CEP: " + pessoaJLeitura.getCep());
					break;
				case "10":
					System.out.println("O complemento atual é: " + pessoaJLeitura.getComplemento()+ "\n" + "Insira o novo complemento: ");
					String complemento = leitor.nextLine();
					pessoaJLeitura.setCelular(complemento);
					System.out.println("Novo complemento: " + pessoaJLeitura.getComplemento());
					break;
				default:
					System.out.println("Por favor, selecione uma opção válida.");
					break;
				}
				boolean gravou = ArquivoSerializadoUtil.gravaPessoaSerializado(1, 1, param, pessoaJAlterado);

				if (gravou) {
					System.out.println(pessoaJLeitura.getNome() + " alterado com sucesso!");
				} else {
					System.out.println("A alteração não pôde ser realizada.");
				}
			}

		} while (!opcao.equals("2"));
	}

}