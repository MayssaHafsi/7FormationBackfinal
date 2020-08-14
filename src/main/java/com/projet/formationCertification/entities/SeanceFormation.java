package com.projet.formationCertification.entities;




import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SeanceFormation { 
	@Id
	@GeneratedValue
private long id ;
	@Temporal(TemporalType.DATE)
private Date datejour ;
private String  heuredebut ; 
private String heurefin ; 
private String salle ; 

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_Formation_Formateur")
private FormationFormateur formationFormateur ; 


public SeanceFormation() {
	super();
}





public String getSalle() {
	return salle;
}





public void setSalle(String salle) {
	this.salle = salle;
}





public Date getDatejour() {
	return datejour;
}




public void setDatejour(Date datejour) {
	this.datejour = datejour;
}




public FormationFormateur getFormationFormateur() {
	return formationFormateur;
}

public void setFormationFormateur(FormationFormateur formationFormateur) {
	this.formationFormateur = formationFormateur;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getHeuredebut() {
	return heuredebut;
}
public void setHeuredebut(String heuredebut) {
	this.heuredebut = heuredebut;
}
public String getHeurefin() {
	return heurefin;
}
public void setHeurefin(String heurefin) {
	this.heurefin = heurefin;
}



}
