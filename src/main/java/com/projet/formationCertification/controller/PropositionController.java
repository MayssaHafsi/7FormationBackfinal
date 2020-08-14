package com.projet.formationCertification.controller;

import java.util.Date;
import java.util.List;

import javax.swing.PopupFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.projet.formationCertification.dao.FormationRepository;
import com.projet.formationCertification.dao.PropositionRepository;
import com.projet.formationCertification.entities.Formation;
import com.projet.formationCertification.entities.Proposition;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@CrossOrigin
public class PropositionController {
@Autowired
PropositionRepository pfm ;

@GetMapping(value="/propositions")
public List<Proposition> getAll()
{
	return pfm.findAll() ; 
}

@RequestMapping(value="/addproposition" , method=RequestMethod.POST)	
public Proposition saveProp(@RequestBody Proposition p)throws Exception
{	 
	return pfm.saveAndFlush(p) ; 
}
@RequestMapping(value="/chercherProposition/{id}" , method=RequestMethod.GET)
public Proposition findProposition(@PathVariable Long id )
{
	return  pfm.find(id); 
}

@PutMapping(value="/updateProposition/{id}")
public Proposition update(@PathVariable Long id , @RequestBody Proposition p)
{
//c=dr.find(id);
p.setId(id);
return  pfm.save(p) ;
	
}

	
	

@GetMapping(value="/pagerChercherProposition")
public Page<Proposition> chercherTypeProposition(@RequestParam(name="type",defaultValue="") String mc , @RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  pfm.findType("%"+mc+"%", new PageRequest(p,size)) ;
			
}



@RequestMapping(value="/confirmeproposition/{id}" , method=RequestMethod.GET)
public void confirmer(@PathVariable Long id )
{
   Proposition p= pfm.find(id);
    p.setEtat("confirmer"); 
}
@RequestMapping(value="/supprimeproposition/{id}" , method=RequestMethod.GET)
public void supprimer(@PathVariable Long id )
{
   Proposition p= pfm.find(id);
    p.setEtat("supprimer"); 
}

@DeleteMapping(value="/deleteProposition/{id}")
	public boolean deleteProposition(@PathVariable String id)
	{
		Proposition p =pfm.find(Long.parseLong(id));
		if (p!=null)
		{
	pfm.delete(p);
	return true ;
	}
		else {
			return false ; 
		}
	}






}
