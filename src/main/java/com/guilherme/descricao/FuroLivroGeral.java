package com.guilherme.descricao;

import java.math.BigDecimal;

public class FuroLivroGeral extends Utils implements Parser {

	@Override
	public String splitLivro(String dados) {
		String livro = dados.substring(4, 17).trim();
		return livro;
	}

	@Override
	public String splitDescricao(String dados) {
		String descricao = dados.substring(0, 4);
		return descricao;
	}

	@Override
	public BigDecimal splitProducao(String dados) {
		String producao = dados.substring(22, dados.length()).trim();
		return convertStringToBigdecimal(producao);
	}
	
	@Override
	public String splitPosicao(String dados) {
		return getPosition(dados);
	}

}
