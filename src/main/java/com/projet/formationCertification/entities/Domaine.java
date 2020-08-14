package com.projet.formationCertification.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Domaine {
@Id
@GeneratedValue
	private Long id ; 
private String nom ; 
@OneToMany(mappedBy = "domaine")
//@JsonIgnoreProperties(value = "domaine", allowGetters = true, allowSetters = true)
@JsonBackReference(value="domaine")
private Collection<Formation> formations ;


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
public Collection<Formation> getFormations() {
	return formations;
}
public void setFormations(Collection<Formation> formations) {
	this.formations = formations;
}
public Domaine() {
	super();
}

}
