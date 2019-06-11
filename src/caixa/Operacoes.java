package caixa;

import java.io.File;

import caixa.ArquivoSerializadoUtil;
import caixa.Caixa;

public class Operacoes {

	public static void totalCaixa(float noCaixa) {

		Caixa caixaAntigo = (Caixa) ArquivoSerializadoUtil.lerCaixaSerializado();
		Caixa caixaTotal = caixaAntigo;

		float caixaAtual = caixaTotal.getDinheirocaixa();
		caixaAtual = caixaAtual + noCaixa;

		caixaTotal.setDinheirocaixa(caixaAtual);

		boolean gravou = ArquivoSerializadoUtil.alteraCaixaSerializado(caixaTotal);

		if (gravou) {
			System.out.println("\n");
		}
	}

	public static void valorCaixa() {

		File directory = new File("CAIXA/Caixa.txt");

		boolean verif = directory.exists();

		if (verif) {

			Caixa caixaLeitura = (Caixa) ArquivoSerializadoUtil.lerCaixaSerializado();

			System.out.println("Total no caixa: " + caixaLeitura.getDinheirocaixa());

		}
	}

	public static void comprarComCaixa(float valorCompra) {

		Caixa caixaAntigo = (Caixa) ArquivoSerializadoUtil.lerCaixaSerializado();
		Caixa caixaTotal = caixaAntigo;

		float caixaAtual = caixaTotal.getDinheirocaixa();
		caixaAtual = caixaAntigo.getDinheirocaixa() - valorCompra;

		caixaTotal.setDinheirocaixa(caixaAtual);

		boolean gravou = ArquivoSerializadoUtil.alteraCaixaSerializado(caixaTotal);

		if (gravou) {
			System.out.println("Compra realizada com sucesso.");
		}
	}

	public static float gerarLucro(float valor) {
		
		Caixa lucroAntigo = (Caixa) ArquivoSerializadoUtil.lerCaixaSerializado();
		Caixa lucroTotal = lucroAntigo;

		float lucroAtual = lucroTotal.getLucro();
		lucroAtual = lucroAtual + valor;

		lucroTotal.setLucro(lucroAtual);

		ArquivoSerializadoUtil.alteraCaixaSerializado(lucroTotal);
		
		return lucroAtual;

	}
	
	public static void mostraLucro() {
		File directory = new File("CAIXA/Lucro.txt");

		boolean verif = directory.exists();

		if (verif) {

			Caixa lucroLeitura = (Caixa) ArquivoSerializadoUtil.lerCaixaSerializado();

			System.out.println("\nLucro total: " + lucroLeitura.getLucro());

		}
	}

}