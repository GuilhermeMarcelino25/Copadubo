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
import com.guilherme.descricao.Context;
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
				new File(fileStorageService.getFileStorageLocation().toString() + "/" + file.getOriginalFilename()))) {
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
			Context ctx = Context.getContext(relatoriosDTO.get(i).getDescricao());
			
			relatorio.setDtInicial(dateAux[0].trim());
			relatorio.setDtFinal(splitData(dateAux[1].trim()));
			relatorio.setDescricao(ctx.executeDescricao(relatoriosDTO.get(i).getDescricao()));
			relatorio.setPosicao(ctx.executePosicao(relatoriosDTO.get(i).getPosicao()));
			relatorio.setProducao(ctx.executeProducao(relatoriosDTO.get(i).getDescricao()));
			relatorio.setLivro(ctx.executeLivro(relatoriosDTO.get(i).getDescricao()));

			relatorios.add(relatorio);
		}
		return relatorios;
	}

	private String splitData(String data) {
		data = data.substring(0, data.length() - 1);
		
		return data;
	}

	
	public void inserirBd(List<RelatorioEntity> relatorios, RelatorioRepository repository) {
		List<RelatorioEntity> relatorioDao = relatorios;
		System.out.println("inserindo...");
		System.out.println("Tamanho : " + relatorioDao.size());
		try {
		repository.saveAll(relatorioDao);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("inseriu.");
	}
}
