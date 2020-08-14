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

import com.projet.formationCertification.dao.CoursRepository;
import com.projet.formationCertification.entities.Cours;
import com.projet.formationCertification.entities.Domaine;


@RestController
@CrossOrigin
public class DownloadFileController {
	@Autowired
	  CoursRepository fileRepository;
	 
	  /*
	   * List All Files
	   */


	  @GetMapping("/api/file/all")
	  public List<Cours> getListFiles() {
	    return fileRepository.findAll();
	  }
	  
	  @RequestMapping(value="/api/file/tous/{id}" , method=RequestMethod.GET)
	  public List<Cours> findDomaine(@PathVariable Long id )
	  {
	  	return  fileRepository.findCours(id); 
	  }


	  
	    /*
	     * Download Files
	     */
	  @GetMapping("/api/file/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
	    Optional<Cours> fileOptional = fileRepository.findById(id);
	    
	    if(fileOptional.isPresent()) {
	      Cours file = fileOptional.get();
	      return ResponseEntity.ok()
	          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
	          .body(file.getPic());  
	    }
	    
	    return ResponseEntity.status(404).body(null);
	  }

}
