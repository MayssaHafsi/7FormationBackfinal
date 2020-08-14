package com.projet.formationCertification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.formationCertification.dao.SeanceFormationDao;
import com.projet.formationCertification.entities.Formation;
import com.projet.formationCertification.entities.FormationFormateur;
import com.projet.formationCertification.entities.SeanceFormation;

@RestController
@CrossOrigin
public class SeanceFormationController {

	@Autowired
	SeanceFormationDao sfr ; 
	
	@RequestMapping(value="/addSeance" , method=RequestMethod.POST)
	public SeanceFormation save(@RequestBody SeanceFormation sf) {
		return sfr.save(sf); 
		
	}
		@RequestMapping(value="/findSeanceFormateur/{id}" , method=RequestMethod.GET)
		public List<SeanceFormation> findSeanceFormateur(@PathVariable Long id)
		{
			return sfr.findSeanceFormateur(id) ; 
		}
		@RequestMapping(value="/findSeanceFormation/{id}" , method=RequestMethod.GET)
		public List<SeanceFormation> findSeanceFormaation(@PathVariable Long id)
		{
			return sfr.findSeanceFormations(id) ; 
		}
		
		@PutMapping(value="/updateSeanceFormation/{id}")
		public SeanceFormation update(@PathVariable Long id, @RequestBody SeanceFormation c)
		{

		c.setId(id);
		return  sfr.save(c) ;
			
		}
		@DeleteMapping(value="/deleteSeanceFormation/{id}")
		public boolean delete(@PathVariable Long id)
		{
			SeanceFormation d = sfr.find(id);
		
		sfr.delete(d);
		return true ;
		
			
		}
		@RequestMapping(value="/chercherSeance/{id}" , method=RequestMethod.GET)
		public SeanceFormation findSeance(@PathVariable Long id )
		{
			return  sfr.find(id); 
		}
	}
	

