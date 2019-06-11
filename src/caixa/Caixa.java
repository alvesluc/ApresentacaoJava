package caixa;

import java.io.Serializable;

public class Caixa implements Serializable{

	float dinheirocaixa;
	float lucro;
	
	private static final long serialVersionUID = 1L;
	
	public float getDinheirocaixa() {
		return dinheirocaixa;
	}

	public void setDinheirocaixa(float dinheirocaixa) {
		this.dinheirocaixa = dinheirocaixa;
	}

	public float getLucro() {
		return lucro;
	}

	public void setLucro(float lucro) {
		this.lucro = lucro;
	}

	
}
