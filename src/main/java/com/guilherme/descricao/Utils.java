package com.guilherme.descricao;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class Utils {
	
	
	protected BigDecimal convertStringToBigdecimal(String value) {

		BigDecimal bigDecimal = null;
		if (!value.isEmpty() && value != null) {
			Locale in_ID = new Locale("pt", "BR");
			DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(in_ID);
			nf.setParseBigDecimal(true);
			bigDecimal = (BigDecimal) nf.parse(value.substring(0, value.length() - 2), new ParsePosition(0));
		}

		return bigDecimal;
	}
	
	
	protected String getPosition(String posicao) {
		if(posicao != null) {
			posicao = posicao.substring(0, 5).trim();
		}
		return posicao;
	}

}
