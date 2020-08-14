package com.projet.formationCertification.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class InscriptionFormation {
	@Id
	@GeneratedValue
private Long id ;
private String etat ;
@Temporal(TemporalType.DATE)
private Date dateInscription ; 
//@JsonBackReference
 @ManyToOne(fetch = FetchType.EAGER )
private Formation formationNC ; 
	//@JsonBackReference
 @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
private Demandeur demandeur ;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public Date getDateInscription() {
	return dateInscription;
}
public void setDateInscription(Date dateInscription) {
	this.dateInscription = dateInscription;
}
public Formation getFormationNC() {
	return formationNC;
}
public void setFormationNC(Formation formation) {
	this.formationNC = formation;
}
public Demandeur getDemandeur() {
	return demandeur;
}
public void setDemandeur(Demandeur demandeur) {
	this.demandeur = demandeur;
}
public InscriptionFormation() {
	super();
} 

}
