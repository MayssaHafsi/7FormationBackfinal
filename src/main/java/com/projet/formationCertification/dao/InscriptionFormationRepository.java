package com.projet.formationCertification.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.Domaine;
import com.projet.formationCertification.entities.InscriptionFormation;

public interface InscriptionFormationRepository extends JpaRepository<InscriptionFormation, Long> {
	@Query("SELECT u FROM InscriptionFormation u WHERE u.id = :status")
	InscriptionFormation find(
	  @Param("status") Long id);
	
	
	
	
	@Query("SELECT v FROM InscriptionFormation v WHERE v.etat='EN ATTENTE' ")
	Page<InscriptionFormation> findAllPage(Pageable p );
	
	

	@Query("SELECT v FROM InscriptionFormation v WHERE v.etat='CONFIRME' ")
	Page<InscriptionFormation> findAllPageConfirme(Pageable p );
	
	@Query("SELECT v FROM InscriptionFormation v WHERE v.etat='REFUSE' ")
	Page<InscriptionFormation> findAllPageRefuse(Pageable p );
	//AND v.formationNC.nbrPlaceReserve <= v.formationNC.capacite
	@Query("SELECT u FROM InscriptionFormation u WHERE u.formationNC.id = :status and u.etat='CONFIRME'")
	List<InscriptionFormation> findParFormation(
	  @Param("status") Long id);
	
	
	@Query("SELECT u FROM InscriptionFormation u WHERE u.demandeur.cin = :status and u.etat='CONFIRME' ")
	List<InscriptionFormation> findDemandeur(
	  @Param("status") String id);
}
