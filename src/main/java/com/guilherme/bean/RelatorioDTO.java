package com.guilherme.bean;

public class RelatorioDTO {
	
	private Long id;
	private String dtInicial;
	private String dtFinal;
	private String posicao;
	private String descricao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDtInicial() {
		return dtInicial;
	}
	public void setDtInicial(String dtInicial) {
		this.dtInicial = dtInicial;
	}
	public String getDtFinal() {
		return dtFinal;
	}
	public void setDtFinal(String dtFinal) {
		this.dtFinal = dtFinal;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
