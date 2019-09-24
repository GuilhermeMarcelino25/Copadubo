package com.guilherme.descricao;

import java.math.BigDecimal;

public class Context {

	private Parser parser;

	public Context(Parser parser) {
		this.parser = parser;
	}

	public String executeLivro(String dados) {
		return parser.splitLivro(dados);
	}
	
	public String executeDescricao(String dados) {
		return parser.splitDescricao(dados);
	}
	
	public BigDecimal executeProducao(String dados) {
		return parser.splitProducao(dados);
	}
	
	public String executePosicao(String dados) {
		return parser.splitPosicao(dados);
	}
	



	public static Context getContext(String descricao) {
		Context ctx = null;

		if (descricao.contains("SAL - FRETE ATE 5 KM")) {
			ctx = new Context(new SalFrete5Km());
		} else if (descricao.contains("SAL - FRETE ATE 10 KM")) {
			ctx = new Context(new SalFrete10Km());
		} else if (descricao.contains("FRETE ATE 10")) {
			ctx = new Context(new Frete10Km());
		} else if (descricao.contains("FRETE ATE 5")) {
			ctx = new Context(new Frete5Km());
		} else if (descricao.contains("TROCA DE NOTA - ATE 5 KM")) {
			ctx = new Context(new TrocaNF5KM());
		} else if (descricao.contains("TROCA DE NOTA - ATE 10 KM")) {
			ctx = new Context(new TrocaNF10Km());
		} else if (descricao.contains("DESVIO ATE 10KM")) {
			ctx = new Context(new Desvio10KM());
		} else if (descricao.contains("SUDOESTE V P I ACORDO")) {
			ctx = new Context(new SudoesteVPIAcordo());
		} else if (descricao.contains("SUDOESTE IV PARA IIIL")) {
			ctx = new Context(new SudoesteIVPIII());
		} else if (descricao.contains("SUDOESTE IV PARA IIL")) {
			ctx = new Context(new SudoesteIVPIIL());
		} else if (descricao.contains("SUDOESTE IV PARA IL")) {
			ctx = new Context(new SudoesteIVPI());
		} else if (descricao.contains("FUROLIVRO GERAL")) {
			ctx = new Context(new FuroLivroGeral());
		} else if (descricao.contains("SUDOESTE III PARA I")) {
			ctx = new Context(new SudoesteIIIPI());
		} else if (descricao.contains("SUDOESTE III PARA I - NITRATO")) {
			ctx = new Context(new SudoesteIIIPINitrato());
		} else if (descricao.contains("ROCHA ZIN - FERTIPAR")) {
			ctx = new Context(new RochaZinFertipar());
		} else if (descricao.contains("ROCHA ZIN - MOSAIC")) {
			ctx = new Context(new RochaZinMosaic());
		} else if (descricao.contains("NITRATO ATE 5 KM")) {
			ctx = new Context(new Nitrato5KM());
		} else if (descricao.contains("NITRATO ATE 10 KM")) {
			ctx = new Context(new Nitrato10Km());
		} else if (descricao.contains("SUDOESTE I PARA II")) {
			ctx = new Context(new SudoesteIPII());
		} else if (descricao.contains("SUDOESTE IV P II")) {
			ctx = new Context(new SudoesteIVPII());
		} else if (descricao.contains("DESVIO ATE 5KM")) {
			ctx = new Context(new Desvio5KM());
		} else if (descricao.contains("NITRATO - TROCA DE NOTA 5")) {
			ctx = new Context(new NitratoTrocaNF5Km());
		} else if (descricao.contains("SUDOESTE III P V ACORDO")) {
			ctx = new Context(new SudoesteIIIPVAcordo());
		} else if (descricao.contains("SUDOESTE III PARA II")) {
			ctx = new Context(new SudoesteIIIPII());
		} else if (descricao.contains("HERINGERLIVRO GERAL")) {
			ctx = new Context(new HeringerLivroGeral());
		} else if (descricao.contains("TRANSFERENCIA SUDOESTELIVRO GERAL")) {
			ctx = new Context(new TransferenciaSudoesteLivroGeral());
		} else if (descricao.contains("TRANSF SUDOESTE V PARA IVLIVRO GERAL")) {
			ctx = new Context(new TransfSudoesteVPIV());
		} else if (descricao.contains("FOSPAR INTERNO - DIVERSOSLIVRO GERAL")) {
			ctx = new Context(new FosparInternoDiversos());
		}

		return ctx;
	}
}