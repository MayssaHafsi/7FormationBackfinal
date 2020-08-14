package com.projet.formationCertification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projet.formationCertification.dao.FichierRepository;
import com.projet.formationCertification.dao.FormateurRepository;
import com.projet.formationCertification.dao.FormationRepository;
import com.projet.formationCertification.dao.CoursRepository;
import com.projet.formationCertification.entities.Fichier;
import com.projet.formationCertification.entities.Formateur;
import com.projet.formationCertification.entities.Cours;

@RestController
@CrossOrigin
public class UploadFileController {
	  @Autowired
	  FichierRepository fileRepository;

	  @Autowired
	  CoursRepository fileRepository1;
	 
	  @Autowired
	FormateurRepository ic ;

	@Autowired
	FormationRepository ik ;
	    /*
	     * MultipartFile Upload
	     */
	    @PostMapping("/api1/file1/upload1/{email}")
	    public String uploadMultipartFile(@RequestParam("file") MultipartFile file,@PathVariable String email) {
	      try {
	 Fichier filemode=new Fichier(); 
	filemode.setFormateurfichier(ic.find1(email));
	 filemode.setMimetype(file.getContentType());
	 filemode.setName(file.getOriginalFilename());
	 filemode.setPic(file.getBytes());
	        // save file to PostgreSQL
	     //   Cours filemode = new Cours(file.getOriginalFilename(), file.getContentType(), file.getBytes());
	        fileRepository.save(filemode);
	        return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
	    } catch (  Exception e) {
	      return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
	    }    
		}
		
		@PostMapping("/api/file/upload/{id}")
		  public String uploadMultipartFile(@RequestParam("file") MultipartFile file,@PathVariable Long id) {
			try {
	   Cours filemode=new Cours(); 
	  filemode.setFormationCours(ik.find(id));
	   filemode.setMimetype(file.getContentType());
	   filemode.setName(file.getOriginalFilename());
	   filemode.setPic(file.getBytes());
			  // save file to PostgreSQL
		   //   Cours filemode = new Cours(file.getOriginalFilename(), file.getContentType(), file.getBytes());
			  fileRepository1.save(filemode);
			  return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		  } catch (  Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		  }    
		  }
		  
		  @DeleteMapping(value="/api/file/delete/{id}")
		  public boolean delete(@PathVariable Long id)
		  {
			  Cours d = fileRepository1.find(id);
			  if (d!=null)
			  {
		  fileRepository1.delete(d);
		  return true ;
		  }
			  else {
				  return false ; 
			  }
		  }

	    
	    
}
