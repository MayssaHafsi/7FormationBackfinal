package com.projet.formationCertification.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.formationCertification.dao.DomaineRepository;
import com.projet.formationCertification.dao.NiveauRepository;

import com.projet.formationCertification.entities.Domaine;
import com.projet.formationCertification.entities.Formateur;
import com.projet.formationCertification.entities.Niveau;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NiveauController {
@Autowired
NiveauRepository nvr ;

DomaineRepository tr;



@GetMapping(value="/niveaus")
	public Collection<Niveau> getAll(){
		return nvr.findAll() ; 
	}
@RequestMapping(value="/addNiveau" , method=RequestMethod.POST)
public Niveau add(@RequestBody Niveau d)
{
	return nvr.save(d);
}

@RequestMapping(value="/chercherNiveauTheme/{id}" , method=RequestMethod.GET)
public List<Niveau> findTheme(@PathVariable Long id )
{
	return  nvr.find(id); 
}

@RequestMapping(value="/chercherNiveau/{id}" , method=RequestMethod.GET)
public Niveau findNiveau(@PathVariable Long id )
{
	return  nvr.findNiveau(id); 
}
@PutMapping(value="/updateNiveau/{id}")
public Niveau update(@PathVariable Long id , @RequestBody Niveau c)
{

c.setId(id);
return  nvr.save(c) ;
	
}

@DeleteMapping(value="/deleteNiveau/{id}")
public boolean delete(@PathVariable Long id)
{
	Niveau d = nvr.findNiveau(id);
	
		nvr.delete(d);
return true ;

	
}

@RequestMapping(value="/chercherThemeNiveau" , method=RequestMethod.GET)
public List<Niveau> findThemeNiveau(@RequestParam(name="id",defaultValue="")  Long id )
{
	return  nvr.findThemeNiveau(id); 
}


}
