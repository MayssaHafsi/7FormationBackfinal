package com.projet.formationCertification.controller;

import java.util.Date;
import java.util.List;


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
import com.projet.formationCertification.entities.Formation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@CrossOrigin
public class FormationController {
@Autowired
FormationRepository frm ;
@GetMapping(value="/formations")
public List<Formation> getAll()
{
	return frm.findAcceuil() ; 
}
@GetMapping(value="/formation")
public List<Formation> get()
{
	return frm.findAll() ; 
}

@GetMapping(value="/pagerChercherFormationTheme")
public Page<Formation> chercherTheme(@RequestParam(name="mct",defaultValue="") String mc , @RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  frm.findTheme("%"+mc+"%", new PageRequest(p,size)) ;
			
}

@GetMapping(value="/pagerChercherFormationDomaine")
public Page<Formation> chercherDomaine(@RequestParam(name="mcd",defaultValue="") String mc , @RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  frm.findDomaine("%"+mc+"%", new PageRequest(p,size)) ;
			
}



@GetMapping(value="/pagerChercherFormationThemeC")
public Page<Formation> chercherThemeC(@RequestParam(name="mct",defaultValue="") String mc , @RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  frm.findThemeC("%"+mc+"%", new PageRequest(p,size)) ;
			
}

@GetMapping(value="/pagerChercherFormationDomaineC")
public Page<Formation> chercherDomaineC(@RequestParam(name="mcd",defaultValue="") String mc , @RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  frm.findDomaineC("%"+mc+"%", new PageRequest(p,size)) ;
			
}





@GetMapping(value="/ChercherformationDate")
public List<Formation> getAllFD(@RequestParam(name="datedebut") Date datedebut , 
		@RequestParam(name="datefin") Date datefin)
{
	return frm.findDate(datedebut, datefin) ; 
}


@GetMapping(value="/formationsCon")
public Page<Formation> getAllC(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="6") int size)
{
	return frm.findCondition(new PageRequest(p, size)) ; 
}

@RequestMapping(value="/addFormation" , method=RequestMethod.POST)	
public Formation save(@RequestBody Formation f)
{	 
	return frm.save(f) ; 
}

@GetMapping(value="/pagerFormation")
public Page<Formation> findAllDomaines(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  frm.findAllPage( new PageRequest(p,size)) ;
			
}
@RequestMapping(value="/chercherFormationG/{id}" , method=RequestMethod.GET)
public Formation findDomaine(@PathVariable Long id )
{
	return  frm.find(id); 
}
@RequestMapping(value="/chercherf/{id}" , method=RequestMethod.GET)
public 	List<Formation> findThemef(@PathVariable Long id )
{
	return  frm.findFormationTheme(id); 
}

@RequestMapping(value="/chercherd/{id}" , method=RequestMethod.GET)
public 	List<Formation> findf(@PathVariable Long id )
{
	return  frm.findf(id); 
}
@GetMapping(value="/pagerFC")
public Page<Formation> findAllFormationC(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  frm.findAllPageFC( new PageRequest(p,size)) ;
			
}

@GetMapping(value="/pagerFNC")
public Page<Formation> findAllFormationNC(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  frm.findAllPageFNC( new PageRequest(p,size)) ;
			
}



@GetMapping(value="/pagerFCC")
public Page<Formation> findAllFormationCC(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  frm.findAllPageFCC( new PageRequest(p,size)) ;
			
}

@GetMapping(value="/pagerFNCC")
public Page<Formation> findAllFormationNCC(@RequestParam(name="page",defaultValue="0") int p , 
		@RequestParam(name="size",defaultValue="3") int size)

{
	return  frm.findAllPageFNCC( new PageRequest(p,size)) ;
			
}

@PutMapping(value="/updateFormation/{id}")
	public Formation update(@PathVariable Long id , @RequestBody Formation c)
	{
	//c=dr.find(id);
	c.setId(id);
	return  frm.save(c) ;
		

}
@DeleteMapping(value="/deleteFormation/{id}")
	public boolean delete(@PathVariable String id)
	{
		Formation d =frm.find(Long.parseLong(id));
		if (d!=null)
		{
	frm.delete(d);
	return true ;
	}
		else {
			return false ; 
		}
	}
  

@RequestMapping(value="/nonPaye/{id}" , method=RequestMethod.GET)
public void nonPaye(@PathVariable Long id )
{
   Formation f= frm.find(id);
    f.setEtatPay("Non Payé"); 
}
@RequestMapping(value="/Paye/{id}" , method=RequestMethod.GET)
public void paye(@PathVariable Long id )
{
   Formation f= frm.find(id);
    f.setEtatPay("Payé"); 
}
@RequestMapping(value="/Nouveau/{id}" , method=RequestMethod.GET)
public void nouveau(@PathVariable Long id )
{
   Formation f= frm.find(id);
    f.setEtat("nouveau"); 
}
@RequestMapping(value="/Ancien/{id}" , method=RequestMethod.GET)
public void ancien(@PathVariable Long id )
{
   Formation f= frm.find(id);
    f.setEtat("ancien"); 
}
	


}
