package com.guilherme.descricao;

import java.math.BigDecimal;

public class SudoesteIVPIIL extends Utils implements Parser{

	@Override
	public String splitLivro(String dados) {
		String livro = dados.substring(19, 32);
		return livro;
	}

	@Override
	public String splitDescricao(String dados) {
		String descricao = dados.substring(0, 19);
		return descricao;
	}

	@Override
	public BigDecimal splitProducao(String dados) {
		String producao = dados.substring(38, dados.length()).trim();
		return convertStringToBigdecimal(producao);
	}
	
	@Override
	public String splitPosicao(String dados) {
		return getPosition(dados);
	}

}
