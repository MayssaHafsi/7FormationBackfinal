package com.projet.formationCertification.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Demandeur {
	@Id
	@GeneratedValue
    private Long id ;
	private String cin ; 
	private String nom  ;
	private String prenom  ; 
	private String sexe ; 
	private String adresse ;
	private String code_carte ;
	private String email ; 
	private String password ; 
	private String numeroTelephone ; 
	@JsonBackReference(value="demandeur")
	@OneToMany(mappedBy="demandeur")
	private Collection<InscriptionFormation> inscriptionsFormation ; 

	public Collection<InscriptionFormation> getInscriptionsFormation() {
		return inscriptionsFormation;
	}
	public void setInscriptionsFormation(Collection<InscriptionFormation> inscriptionsFormation) {
		this.inscriptionsFormation = inscriptionsFormation;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		
		this.cin = cin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code_carte;
	}
	public void setCode(String code) {
		this.code_carte = code;
	}
	public String getNumeroTelephone() {
		return numeroTelephone;
	}
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public Demandeur() {
		super();
	}
	
}
