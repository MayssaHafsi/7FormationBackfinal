package com.projet.formationCertification.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Niveau {
	@Id
	@GeneratedValue
private Long id ; 
private String nom ; 



@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_theme")
private Domaine themeNiveau ;





public Niveau() {
	super();
	// TODO Auto-generated constructor stub
}


public Domaine getThemeNiveau() {
	return themeNiveau;
}


public void setThemeNiveau(Domaine themeNiveau) {
	this.themeNiveau = themeNiveau;
}


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}




}
