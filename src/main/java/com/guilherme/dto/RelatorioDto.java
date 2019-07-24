package com.guilherme.dto;

import java.math.BigDecimal;


public class RelatorioDto {

	private String posicao;
	private BigDecimal producao;
	
	

	public RelatorioDto(String posicao, BigDecimal producao) {
		super();
		this.posicao = posicao;
		this.producao = producao;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public BigDecimal getProducao() {
		return producao;
	}

	public void setProducao(BigDecimal producao) {
		this.producao = producao;
	}

}
