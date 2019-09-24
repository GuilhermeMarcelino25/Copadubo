package com.guilherme.descricao;

import java.math.BigDecimal;

public interface Parser{
	
	 public String splitLivro(String dados);
	 public String splitDescricao(String dados);
	 public BigDecimal splitProducao(String dados);
	 public String splitPosicao(String dados);

}
