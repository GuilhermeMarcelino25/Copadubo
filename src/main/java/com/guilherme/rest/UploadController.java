package com.guilherme.rest;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.guilherme.config.FileStorageService;
import com.guilherme.entity.RelatorioEntity;
import com.guilherme.repository.RelatorioLimited;
import com.guilherme.repository.RelatorioRepository;
import com.guilherme.service.UploadService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/copadubo")
public class UploadController {
	
	@Autowired
    private FileStorageService fileStorageService;
	
	@Autowired
    private RelatorioRepository repository;
	
	@Autowired
	private UploadService uploadService;
    
	 
	@PostMapping(value = "/relatorio")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws InvalidPasswordException, IOException, ParseException {
		
			fileStorageService.storeFile(file);
		    List<RelatorioEntity> relatorio = uploadService.lerPdf(fileStorageService, file);
		    uploadService.inserirBd(relatorio, repository);
        
        return ResponseEntity.status(HttpStatus.OK).body("Inserido");
	}
	
	@GetMapping(value = "/relatorio")
	public List<RelatorioLimited>  get() {		
		
		return repository.findProductionByBiggerValue();

	}

}
