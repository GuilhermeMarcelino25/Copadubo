package com.guilherme.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Relatorio")
public class RelatorioEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(name = "dtInicial")
	private String dtInicial;
	@Column(name = "dtFinal")
	private String dtFinal;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "livro")
	private String livro;
	@Column(name = "posicao")
	private String posicao;
	@Column(name = "producao")
	private BigDecimal producao;

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

	public BigDecimal getProducao() {
		return producao;
	}

	public void setProducao(BigDecimal producao) {
		this.producao = producao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}
}