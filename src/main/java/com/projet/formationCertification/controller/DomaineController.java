package com.projet.formationCertification.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import com.projet.formationCertification.dao.FormationRepository;

import com.projet.formationCertification.entities.Domaine;
import com.projet.formationCertification.entities.Formateur;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DomaineController {
@Autowired
DomaineRepository dr ; 
@Autowired
FormationRepository fr ;


@GetMapping(value="/domaines")
public Collection<Domaine> findAllDomaine()
{
	return dr.findAll() ; 
}
@GetMapping(value="/pager")
public Page<Domaine> findAllDomaines(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  dr.findAllPage( new PageRequest(p,size)) ;
			
}

@GetMapping(value="/pagerChercherDomaineNom")
public Page<Domaine> chercherNom(@RequestParam(name="nom",defaultValue="") String mc , @RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  dr.findNom("%"+mc+"%", new PageRequest(p,size)) ;
			
}


@RequestMapping(value="/addDomaine" , method=RequestMethod.POST)
public Domaine add(@RequestBody Domaine d)
{
	return dr.save(d);
}
@PutMapping(value="/updateDomaine/{id}")
public Domaine update(@PathVariable Long id , @RequestBody Domaine c)
{
//c=dr.find(id);
c.setId(id);
return  dr.save(c) ;
	
}
@DeleteMapping(value="/deleteDomaine/{id}")
public boolean delete(@PathVariable Long id)
{
	Domaine d = dr.find(id);
	
dr.delete(d);
return true ;

	
}
@RequestMapping(value="/chercher/{id}" , method=RequestMethod.GET)
public Domaine findDomaine(@PathVariable Long id )
{
	return  dr.find(id); 
}




}
