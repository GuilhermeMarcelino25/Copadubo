package com.guilherme.descricao;

import java.math.BigDecimal;

public class TrocaNF5KM extends Utils implements Parser{

	@Override
	public String splitLivro(String dados) {
		String livro = dados.substring(24, 37).trim();
		return livro;
	}

	@Override
	public String splitDescricao(String dados) {
		String descricao = dados.substring(0, 24).trim();
		return descricao;
	}

	@Override
	public BigDecimal splitProducao(String dados) {
		String producao = dados.substring(43, dados.length()).trim();
		return convertStringToBigdecimal(producao);
	}
	
	@Override
	public String splitPosicao(String dados) {
		return getPosition(dados);
	}

}
