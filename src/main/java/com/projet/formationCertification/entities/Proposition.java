package com.projet.formationCertification.entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.*;


@Entity

public class Proposition {
@Id
@GeneratedValue
private Long id ; 
private Date dateProposition ; 
private String description ;
private String etat;
private String type;
private String entreprise;

@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
@JoinColumn(name = "id_demandeur")

private Demandeur demandeur ;

public Proposition() {
	super();
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getEntreprise() {
	return entreprise;
}
public void setEntreprise(String entreprise) {
	this.entreprise = entreprise;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Date getDateProposition() {
	return dateProposition;
}
public void setDateProposition(Date dateProposition) {
	this.dateProposition = dateProposition;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Demandeur getDemandeur() {
	return demandeur;
}
public void setDemandeur(Demandeur demandeur) {
	this.demandeur = demandeur;
} 
public String getEtat() {
	return etat  ;
}
public void setEtat(String etat ) {
	this. etat= etat;
}

}
