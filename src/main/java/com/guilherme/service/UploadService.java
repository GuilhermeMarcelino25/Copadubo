package com.guilherme.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import com.guilherme.bean.RelatorioDTO;
import com.guilherme.config.FileStorageService;
import com.guilherme.entity.RelatorioEntity;
import com.guilherme.repository.RelatorioRepository;

@Configuration
public class UploadService {

	public List<RelatorioEntity> lerPdf(FileStorageService fileStorageService, MultipartFile file)
			throws InvalidPasswordException, IOException, ParseException {

		String data = null;
		String dateAux[] = null;
		RelatorioEntity relatorio = null;
		ArrayList<RelatorioEntity> relatorios = new ArrayList<RelatorioEntity>();
        List<RelatorioDTO> relatoriosDTO = new ArrayList<RelatorioDTO>();
        RelatorioDTO relatorioDTO = null;
		try (PDDocument document = PDDocument.load(
				new File(fileStorageService.getFileStorageLocation().toString() + "\\" + file.getOriginalFilename()))) {
			document.getClass();
			if (!document.isEncrypted()) {
				PDFTextStripper tStripper = new PDFTextStripper();
				String pdfFileInText = tStripper.getText(document);
				String lines[] = pdfFileInText.split("\\t?\\n");
				int contador = 0;
				int contadorFor = 0;
				for (String line : lines) {
					relatorioDTO = new RelatorioDTO();
					if(line.contains("LIVRO GERAL")) {
						relatorioDTO.setDescricao(line);
						relatoriosDTO.add(relatorioDTO);
						contador++;
						contadorFor++;
						
					}else if (line.startsWith("A") || line.startsWith("B") || line.startsWith("M")) {
						for(int i = contadorFor - 1; i >= (contadorFor - contador); i-- ) {
							relatoriosDTO.get(i).setPosicao(line);
							
						}
						contador = 0;
					} 
					else if (line.contains("/2019a")) {
						data = line;
						dateAux = data.split(" ");
					}else if (line.contains("/2018a")) {
						data = line;
						dateAux = data.split(" ");
					}						
					
				}
			}
		}
		for (int i = 0; i < relatoriosDTO.size(); i++) {
			relatorio = new RelatorioEntity();
			
			relatorio.setDtInicial(dateAux[0].trim());
			relatorio.setDtFinal(splitData(dateAux[1].trim()));
			relatorio.setDescricao(splitDescricao(relatoriosDTO.get(i).getDescricao()));
			relatorio.setPosicao(splitPosicao(relatoriosDTO.get(i).getPosicao()));
			relatorio.setProducao(splitProducao(relatoriosDTO.get(i).getDescricao()));
			relatorio.setLivro(splitLivro(relatoriosDTO.get(i).getDescricao()));
			relatorios.add(relatorio);
		}
		return relatorios;
	}

	private String splitData(String data) {
		data = data.substring(0, data.length() - 1);
		
		return data;
	}

	private String splitLivro(String livro) {
		if (livro != null) {

			if(livro.contains("SAL - FRETE ATE 5 KM")) {
				livro = livro.substring(20, 33);
			}else if(livro.contains("SAL - FRETE ATE 10 KM")) {
				livro = livro.substring(21,  34);
			}if (livro.contains("FRETE ATE 10")) {
				livro = livro.substring(15, 28).trim();
			} else if (livro.contains("FRETE ATE 5")) {
				livro = livro.substring(14, 27).trim();
			}else if (livro.contains("TROCA DE NOTA - ATE 5 KM")) {
				livro = livro.substring(24, 37).trim();
			}else if (livro.contains("TROCA DE NOTA - ATE 10 KM")) {
				livro = livro.substring(25, 38).trim();
			}else if (livro.contains("DESVIO ATE 10KM")) {	
				livro = livro.substring(15, 28).trim();
			}else if (livro.contains("SUDOESTE V P I ACORDO")) {	
				livro = livro.substring(21, 34).trim();
			}else if (livro.contains("SUDOESTE IV PARA IIIL")) {	
				livro = livro.substring(20, 33);
			}else if (livro.contains("SUDOESTE IV PARA IIL")) {	
				livro = livro.substring(19, 32);
			}else if (livro.contains("SUDOESTE IV PARA IL")) {	
				livro = livro.substring(18, 31);
			}else if (livro.contains("FUROLIVRO GERAL")) {	
				livro = livro.substring(4, 17).trim();
			}else if (livro.contains("SUDOESTE III PARA ILIVRO")) {	
				livro = livro.substring(19, 32).trim();
			}else if (livro.contains("SUDOESTE III PARA I - NITRATOLIVRO")) {	
				livro = livro.substring(29, 42).trim();
			}else if (livro.contains("ROCHA ZIN - FERTIPARLIVRO")) {	
				livro = livro.substring(20, 33).trim();
			}else if (livro.contains("ROCHA ZIN - MOSAICLIVRO")) {	
				livro = livro.substring(18, 31).trim();
			}else if (livro.contains("NITRATO ATE 5 KM")) {	
				livro = livro.substring(16, 29).trim();
			}else if (livro.contains("NITRATO ATE 10 KM")) {	
				livro = livro.substring(17,  30);
			}else if (livro.contains("SUDOESTE I PARA II")) {	
				livro = livro.substring(18,  31);
			}else if (livro.contains("SUDOESTE IV P II")) {	
				livro = livro.substring(23,  36);
			}else if (livro.contains("DESVIO ATE 5KM")) {	
				livro = livro.substring(14,  27);
			}else if (livro.contains("NITRATO - TROCA DE NOTA 5")) {	
				livro = livro.substring(28,  41);
			}else if (livro.contains("SUDOESTE III P V ACORDO")) {	
				livro = livro.substring(23,  36);
			}else if (livro.contains("SUDOESTE III PARA II")) {	
				livro = livro.substring(20,  33);
			}else if (livro.contains("HERINGERLIVRO GERAL")) {	
				livro = livro.substring(8,  21);
			}else if (livro.contains("TRANSFERENCIA SUDOESTELIVRO GERAL")) {	
				livro = livro.substring(22,  35);
			}else if (livro.contains("TRANSF SUDOESTE V PARA IVLIVRO GERAL")) {	
				livro = livro.substring(25, 38);
			}else if (livro.contains("FOSPAR INTERNO - DIVERSOSLIVRO GERAL")) {	
				livro = livro.substring(25, 38);
			}
			
		}
		return livro;
	}

	private BigDecimal splitProducao(String producao) {
		
		if(producao != null) {
			
			if(producao.contains("SAL - FRETE ATE 5 KM")) {
				producao = producao.substring(38, producao.length()).trim();
			}else if(producao.contains("SAL - FRETE ATE 10 KM")) {
				producao = producao.substring(39,  producao.length()).trim();
			}else if(producao.contains("FRETE ATE 10")) {
				producao = producao.substring(33,producao.length()).trim();
			}else if(producao.contains("FRETE ATE 5")) {
				producao = producao.substring(32,producao.length()).trim();
			}else if (producao.contains("TROCA DE NOTA - ATE 5 KM")) {
				producao = producao.substring(43, producao.length()).trim();
			}else if (producao.contains("TROCA DE NOTA - ATE 10 KM")) {
				producao = producao.substring(44, producao.length()).trim();
			}else if (producao.contains("DESVIO ATE 10KM")) {
				producao = producao.substring(34, producao.length()).trim();
			}else if (producao.contains("SUDOESTE V P I ACORDO")) {	
				producao = producao.substring(39, producao.length()).trim();
			}else if (producao.contains("SUDOESTE IV PARA IIIL")) {	
				producao = producao.substring(39, producao.length()).trim();
			}else if (producao.contains("SUDOESTE IV PARA IIL")) {	
				producao = producao.substring(38, producao.length()).trim();
			}else if (producao.contains("SUDOESTE IV PARA IL")) {	
				producao = producao.substring(37, producao.length()).trim();
			}else if (producao.contains("FUROLIVRO GERAL")) {	
				producao = producao.substring(22, producao.length()).trim();
			}else if (producao.contains("SUDOESTE III PARA ILIVRO")) {	
				producao = producao.substring(37, producao.length()).trim();
			}else if (producao.contains("SUDOESTE III PARA I - NITRATOLIVRO")) {	
				producao = producao.substring(47,producao.length()).trim();
			}else if (producao.contains("ROCHA ZIN - FERTIPARLIVRO")) {	
				producao = producao.substring(38,producao.length()).trim();
			}else if (producao.contains("ROCHA ZIN - MOSAICLIVRO")) {	
				producao = producao.substring(36, producao.length()).trim();
			}else if (producao.contains("NITRATO ATE 5 KM")) {	
				producao = producao.substring(34,  producao.length()).trim();
			}else if (producao.contains("NITRATO ATE 10 KM")) {	
				producao = producao.substring(35,  producao.length()).trim();
			}else if (producao.contains("SUDOESTE I PARA II")) {	
				producao = producao.substring(36,  producao.length()).trim();
			}else if (producao.contains("SUDOESTE IV P II")) {	
				producao = producao.substring(41,  producao.length()).trim();
			}else if (producao.contains("DESVIO ATE 5KM")) {	
				producao = producao.substring(32,  producao.length()).trim();
			}else if (producao.contains("NITRATO - TROCA DE NOTA 5 KM")) {	
				producao = producao.substring(47,  producao.length()).trim();
			}else if (producao.contains("NITRATO - TROCA DE NOTA 5 KM")) {	
				producao = producao.substring(47,  producao.length()).trim();
			}else if (producao.contains("SUDOESTE III P V ACORDO")) {	
				producao = producao.substring(42,  producao.length()).trim();
			}else if (producao.contains("SUDOESTE III PARA IIL")) {	
				producao = producao.substring(39,  producao.length()).trim();
			}else if (producao.contains("SAL - FRETE ATE 5 KM")) {	
				producao = producao.substring(39,  producao.length()).trim();
			}else if (producao.contains("SAL - FRETE ATE 10 KM")) {	
				producao = producao.substring(40,  producao.length()).trim();
			}else if (producao.contains("HERINGERLIVRO GERAL")) {	
				producao = producao.substring(26,  producao.length()).trim();
			}else if (producao.contains("TRANSFERENCIA SUDOESTELIVRO GERAL")) {	
				producao = producao.substring(41, producao.length()).trim();
			}else if (producao.contains("TRANSF SUDOESTE V PARA IVLIVRO GERAL")) {	
				producao = producao.substring(44, producao.length()).trim();
			}else if (producao.contains("FOSPAR INTERNO - DIVERSOSLIVRO GERAL")) {	
				producao = producao.substring(44, producao.length()).trim();
			}
		}
		return convertStringToBigdecimal(producao);
	}

	private String splitPosicao(String posicao) {
		if(posicao != null) {
			posicao = posicao.substring(0, 5).trim();
		}
	
		return posicao;
	}

	private String splitDescricao(String descricao) {
		
		if(descricao != null) {
			
			if(descricao.contains("SAL - FRETE ATE 5 KM")) {
				descricao = descricao.substring(0,  20);
			}else if(descricao.contains("SAL - FRETE ATE 10 KM")) {
				descricao = descricao.substring(0,  21);
			}else if(descricao.contains("FRETE ATE 10")) {
				descricao = descricao.substring(0,15).trim();
			}else if(descricao.contains("FRETE ATE 5")) {
				descricao = descricao.substring(0,14).trim();
			}else if (descricao.contains("TROCA DE NOTA - ATE 5 KM")) {
				descricao = descricao.substring(0, 24).trim();
			}else if (descricao.contains("TROCA DE NOTA - ATE 10 KM")) {
				descricao = descricao.substring(0, 25).trim();
			}else if (descricao.contains("DESVIO ATE 10KM")) {
				descricao = descricao.substring(0, 15).trim();
			}else if (descricao.contains("SUDOESTE V P I ACORDO")) {	
				descricao = descricao.substring(0, 21);
			}else if (descricao.contains("SUDOESTE IV PARA IIIL")) {	
				descricao = descricao.substring(0, 20);
			}else if (descricao.contains("SUDOESTE IV PARA IIL")) {	
				descricao = descricao.substring(0, 19);
			}else if (descricao.contains("SUDOESTE IV PARA IL")) {	
				descricao = descricao.substring(0, 18);
			}else if (descricao.contains("FUROLIVRO GERAL")) {	
				descricao = descricao.substring(0, 4);
			}else if (descricao.contains("SUDOESTE III PARA ILIVRO")) {	
				descricao = descricao.substring(0, 19);
			}else if (descricao.contains("SUDOESTE III PARA I - NITRATOLIVRO")) {	
				descricao = descricao.substring(0,29);
			}else if (descricao.contains("ROCHA ZIN - FERTIPARLIVRO")) {	
				descricao = descricao.substring(0,20);
			}else if (descricao.contains("ROCHA ZIN - MOSAICLIVRO")) {	
				descricao = descricao.substring(0, 18);
			}else if (descricao.contains("NITRATO ATE 5 KM")) {	
				descricao = descricao.substring(0,  16);
			}else if (descricao.contains("NITRATO ATE 10 KM")) {	
				descricao = descricao.substring(0,  17);
			}else if (descricao.contains("SUDOESTE I PARA II")) {	
				descricao = descricao.substring(0,  18);
			}else if (descricao.contains("SUDOESTE IV P II")) {	
				descricao = descricao.substring(0,  23);
			}else if (descricao.contains("DESVIO ATE 5KM")) {	
				descricao = descricao.substring(0,  14);
			}else if (descricao.contains("NITRATO - TROCA DE NOTA 5")) {	
				descricao = descricao.substring(0,  28);
			}else if (descricao.contains("SUDOESTE III P V ACORDO")) {	
				descricao = descricao.substring(0,  23);
			}else if (descricao.contains("SUDOESTE III PARA II")) {	
				descricao = descricao.substring(0,  20);
			}else if (descricao.contains("HERINGERLIVRO GERAL")) {	
				descricao = descricao.substring(0,  8);
			}else if (descricao.contains("TRANSFERENCIA SUDOESTELIVRO GERAL")) {	
				descricao = descricao.substring(0, 22);
			}else if (descricao.contains("TRANSF SUDOESTE V PARA IVLIVRO GERAL")) {	
				descricao = descricao.substring(0, 25);
			}else if (descricao.contains("FOSPAR INTERNO - DIVERSOSLIVRO GERAL")) {	
				descricao = descricao.substring(0, 25);
			}
		}
		return descricao;
	}

	private BigDecimal convertStringToBigdecimal(String value) {

		BigDecimal bigDecimal = null;
		if (!value.isEmpty() && value != null) {
			Locale in_ID = new Locale("pt", "BR");
			DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance(in_ID);
			nf.setParseBigDecimal(true);
			bigDecimal = (BigDecimal) nf.parse(value.substring(0, value.length() - 2), new ParsePosition(0));
		}

		return bigDecimal;
	}

	public void inserirBd(List<RelatorioEntity> relatorios, RelatorioRepository repository) {
		List<RelatorioEntity> relatorioDao = relatorios;

		repository.saveAll(relatorioDao);
	}
}
