package com.projet.formationCertification.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.formationCertification.dao.DemandeurRepository;
import com.projet.formationCertification.entities.Demandeur;


@RestController
@CrossOrigin
public class DemandeurController {

	@Autowired
	DemandeurRepository dmr ;
	
	@GetMapping(value="/demandeurs")
	public Collection<Demandeur> findAllDemandeur()
	{
		return dmr.findAll() ; 
	}
	@RequestMapping(value="/addDemandeur" , method=RequestMethod.POST)
	public Demandeur add(@RequestBody Demandeur d)
	{
		return dmr.save(d);
	}
	@GetMapping(value="/findDemandeur")
	public Demandeur find(@RequestParam(name="cinr") String cinr)
	{
		return dmr.find(cinr) ; 
	}
	@GetMapping(value="/findDemandeurParCin/{cin}")
	public Demandeur findParCin(@PathVariable String cin)
	{
		return dmr.findParCin(cin) ; 
	}


	@GetMapping(value="/findEmail/{email}")
	public List<Demandeur> findParEmail(@PathVariable String email)
	{
		return dmr.findParEmail(email) ; 
	}
	
	
}
