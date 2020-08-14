package com.projet.formationCertification.entities;

import java.util.Collection;

public class Salle {
private Long id ;
private String capacite ; 
private String nom ; 
private String etat ;
private Collection<SeanceFormation> seances ;
public Salle() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCapacite() {
	return capacite;
}
public void setCapacite(String capacite) {
	this.capacite = capacite;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public Collection<SeanceFormation> getSeances() {
	return seances;
}
public void setSeances(Collection<SeanceFormation> seances) {
	this.seances = seances;
} 


}
