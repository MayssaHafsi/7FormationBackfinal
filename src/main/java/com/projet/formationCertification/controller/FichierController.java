package com.projet.formationCertification.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.formationCertification.dao.FichierRepository;
import com.projet.formationCertification.entities.Fichier;
import com.projet.formationCertification.entities.Domaine;


@RestController
@CrossOrigin
public class FichierController {
	@Autowired
	  FichierRepository fileRepository;
	 
	  /*
	   * List All Files
	   */


	  @GetMapping("/api/file1/all")
	  public List<Fichier> getListFiles() {
	    return fileRepository.findAll();
	  }
	  
	  @RequestMapping(value="/api/file1/tous/{id}" , method=RequestMethod.GET)
	  public List<Fichier> findDomaine(@PathVariable Long id )
	  {
	  	return  fileRepository.findFichier(id); 
	  }


	  
	    /*
	     * Download Files
	     */
	  @GetMapping("/api/file1/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
	    Optional<Fichier> fileOptional = fileRepository.findById(id);
	    
	    if(fileOptional.isPresent()) {
	      Fichier file = fileOptional.get();
	      return ResponseEntity.ok()
	          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
	          .body(file.getPic());  
	    }
	    
	    return ResponseEntity.status(404).body(null);
	  }

}
