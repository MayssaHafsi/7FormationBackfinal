package com.projet.formationCertification.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class FormationFormateur {
	@Id
	@GeneratedValue
private Long id ; 
	//@JsonBackReference
	 @ManyToOne(fetch = FetchType.EAGER)
private Formation formation ;
//	@JsonBackReference
	 @ManyToOne(fetch = FetchType.EAGER)
private Formateur formateur ; 
	@Temporal(TemporalType.DATE)
private Date datedebut  ; 
	@Temporal(TemporalType.DATE)
private Date datefin ;
	
	@OneToMany(mappedBy = "formationFormateur")
	@JsonBackReference(value="formationFormateur")
	private Collection<SeanceFormation> seances ;

	

	public Collection<SeanceFormation> getSeances() {
		return seances;
	}

	public void setSeances(Collection<SeanceFormation> seances) {
		this.seances = seances;
	}

public Formation getFormation() {
	return formation;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
public void setFormation(Formation formation) {
	this.formation = formation;
}
public Formateur getFormateur() {
	return formateur;
}
public void setFormateur(Formateur formateur) {
	this.formateur = formateur;
}
public Date getDatedebut() {
	return datedebut;
}
public void setDatedebut(Date datedebut) {
	this.datedebut = datedebut;
}
public Date getDatefin() {
	return datefin;
}
public void setDatefin(Date datefin) {
	this.datefin = datefin;
}
public FormationFormateur() {
	super();
	// TODO Auto-generated constructor stub
} 

}
