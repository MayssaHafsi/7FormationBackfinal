package com.projet.formationCertification.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Devis{
   @Id
    @GeneratedValue
    private Long id ;
    
    private int nb_participants;
    private String entreprise;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_demandeur")

    private Demandeur demandeur ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_formation")

    private Formation formationRecherche ;
    
    private String etat;
    
  
    public Devis()
    {
        super();
    }

    public Formation getformationRecherche() {
        return formationRecherche;
    }
    public void setformationRecherche(Formation formationRecherche ) {
        this.formationRecherche = formationRecherche;
    }
    public int getnb_participants() {
        return nb_participants ;
    }
    public void setnb_participants(int nb_participants ) {
        this.nb_participants = nb_participants;
    }
    public Demandeur getDemandeur() {
        return demandeur;
    }
    public void setDemandeur(Demandeur demandeur) {
       
        this.demandeur = demandeur;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
       
        this.id = id;
    }
    
    public String getEtat() {
        return etat  ;
    }
    public void setEtat(String etat ) {
        this. etat= etat;
    }
    public String getEntreprise() {
        return entreprise  ;
    }
    public void setEntreprise(String entreprise ) {
        this. entreprise= entreprise;
    }
    
	
	
}
