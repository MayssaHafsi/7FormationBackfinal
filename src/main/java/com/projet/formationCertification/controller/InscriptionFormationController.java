package com.projet.formationCertification.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.formationCertification.dao.InscriptionFormationRepository;
import com.projet.formationCertification.entities.Demandeur;
import com.projet.formationCertification.entities.Domaine;
import com.projet.formationCertification.entities.InscriptionFormation;

@RestController
@CrossOrigin
public class InscriptionFormationController {
@Autowired
	InscriptionFormationRepository inf ;

@GetMapping(value="/inscriptionsF")
public Collection<InscriptionFormation> findAllInscriptionF()
{
	return inf.findAll() ; 
}
@GetMapping(value="/pagerInscriptionF")
public Page<InscriptionFormation> findAllInscriptionFormation(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  inf.findAllPage( new PageRequest(p,size)) ;
			
}
@GetMapping(value="/pagerInscriptionFC")
public Page<InscriptionFormation> findAllInscriptionFormationC(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  inf.findAllPageConfirme( new PageRequest(p,size)) ;
			
}
@GetMapping(value="/pagerInscriptionFR")
public Page<InscriptionFormation> findAllInscriptionFormationR(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  inf.findAllPageRefuse( new PageRequest(p,size)) ;
			
}


@RequestMapping(value="/addInscriptionF" , method=RequestMethod.POST)
public InscriptionFormation add(@RequestBody InscriptionFormation d)
{
	d.setDemandeur(d.getDemandeur());

	return inf.save(d);
}

@PutMapping(value="/updateInscriptionFormation/{id}")
public InscriptionFormation update(@PathVariable Long id , @RequestBody InscriptionFormation c)
{
//c=dr.find(id);
c.setId(id);
return  inf.save(c) ;
	
}
@RequestMapping(value="/chercherInscriptionFormation/{id}" , method=RequestMethod.GET)
public InscriptionFormation findInscription(@PathVariable Long id )
{
	return  inf.find(id); 
}
@RequestMapping(value="/findParFormationsConfirme/{id}" , method=RequestMethod.GET)
public List<InscriptionFormation> findParFormations(@PathVariable Long id )
{
	return  inf.findParFormation(id); 
}

@RequestMapping(value="/findDemandeurInscription/{cin}" , method=RequestMethod.GET)
public List<InscriptionFormation> findDemandeur(@PathVariable String  cin )
{
	return  inf.findDemandeur(cin); 
}


}
