package com.projet.formationCertification.controller;

import java.util.Collection;


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

import com.projet.formationCertification.dao.FormateurRepository;
import com.projet.formationCertification.entities.Formateur;

@RestController
@CrossOrigin
public class FormateurController  {

	@Autowired
	FormateurRepository fr ; 
	@GetMapping(value="/formateurs")
	public Collection<Formateur> findAll()
	{
		return fr.findAll() ; 
	}

	@RequestMapping(value="/addFormateur" , method=RequestMethod.POST)
	public Formateur saveFormateur(@RequestBody Formateur f) throws Exception
	{
	
		return	fr.save(f) ;
	}
	@GetMapping(value="/pagerFormateur")
	public Page<Formateur> findAllFormateur(@RequestParam(name="page",defaultValue="0") int p , 
			@RequestParam(name="size",defaultValue="3") int size)

	{
		return  fr.findAllPage( new PageRequest(p,size)) ;
				
	}
	
	@GetMapping(value="/pagerChercherFormateur")
	public Page<Formateur> chercher(@RequestParam(name="cin",defaultValue="") String mc , @RequestParam(name="page",defaultValue="0") int p , 
			@RequestParam(name="size",defaultValue="1") int size)

	{
		return  fr.findPageFormateur("%"+mc+"%", new PageRequest(p,size)) ;
				
	}
	
	

	@RequestMapping(value="/chercherFormateur/{cin}" , method=RequestMethod.GET)
	public Formateur findFormateurParCin(@PathVariable String cin )
	{
		return  fr.find(cin); 
	}
	@RequestMapping(value="/chercherFormateur1/{email}" , method=RequestMethod.GET)
	public Formateur findFormateurParEmail(@PathVariable String email )
	{
		return  fr.find1(email); 
	}


	@RequestMapping(value="/chercherRecrutement/{email}" , method=RequestMethod.GET)
	public Formateur findEmail(@PathVariable String email )
	{
			return  fr.findEmail(email); 
	}
	
	
	@PutMapping(value="/updateFormateurs/{email}")
	public Formateur update(@PathVariable String email, @RequestBody Formateur c)
	{

	c.setEmail(email);
	return  fr.save(c) ;
		
	}
	@RequestMapping(value="/confirmeRecrutement/{email}" , method=RequestMethod.GET)
    public void confirmer(@PathVariable String email )
   {
   Formateur f= fr.find(email);
    f.setEtat("confirmer"); 
   }
   @RequestMapping(value="/supprimerecrutement/{email}" , method=RequestMethod.GET)
   public void supprimer(@PathVariable String email )
  {
   Formateur f= fr.find(email);
    f.setEtat("supprimer"); 
  }


}
