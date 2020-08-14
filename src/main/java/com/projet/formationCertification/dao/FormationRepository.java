package com.projet.formationCertification.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.Domaine;
import com.projet.formationCertification.entities.Formation;


import com.projet.formationCertification.entities.Niveau;

public interface FormationRepository extends JpaRepository<Formation,Long> {
	@Query("SELECT v FROM Formation v")
	Page<Formation> findAllPage(Pageable p );
	@Query("SELECT u FROM Formation u WHERE u.id = :status")
	Formation find(
	  @Param("status") Long id);
	
	
	@Query("SELECT u FROM Formation u WHERE u.dateLimiteInscription > CURRENT_DATE AND u.nbrPlaceReserve < u.capacite  ")
	Page<Formation> findCondition(Pageable p)	;

	
	@Query("SELECT u FROM Formation u WHERE u.domaine.id = :status")
	List<Formation> findFormationDomaine(
	  @Param("status") Long id);

	  @Query("SELECT u FROM Formation u WHERE u.id = :status")
	List<Formation> findf(
	  @Param("status") Long id);

	@Query("SELECT u FROM Formation u WHERE u.acceuil like 'oui'")
	  List<Formation> findAcceuil();
	
	@Query("SELECT u FROM Formation u WHERE u.domaine.id = :status")
	List<Formation> findFormationTheme(
	  @Param("status") Long id);

	 
	
	@Query("SELECT u FROM Formation u WHERE u.datedebut >= :status AND u.datefin <= :df")
	List<Formation> findDate(
	  @Param("status") Date datedebut,@Param("df") Date datefin);
	
	@Query("SELECT v FROM Formation v WHERE v.type='FNC' ")
	Page<Formation> findAllPageFNC(Pageable p );
	
	
	@Query("SELECT v FROM Formation v WHERE v.type='FC' ")
	Page<Formation> findAllPageFC(Pageable p );
	
	

	@Query("SELECT v FROM Formation v WHERE v.type='FNC' AND v.dateLimiteInscription > CURRENT_DATE AND v.nbrPlaceReserve < v.capacite  ")
	Page<Formation> findAllPageFNCC(Pageable p );
	
	
	@Query("SELECT v FROM Formation v WHERE v.type='FC' AND v.dateLimiteInscription > CURRENT_DATE AND v.nbrPlaceReserve < v.capacite  ")
	Page<Formation> findAllPageFCC(Pageable p );
	
	
	
	@Query("SELECT u FROM Formation u WHERE u.theme.nom like :status")
	Page<Formation> findTheme(
		  @Param("status") String mc,Pageable p );
	
	
	@Query("SELECT u FROM Formation u WHERE u.domaine.nom like :status")
	Page<Formation> findDomaine(
		  @Param("status") String mc,Pageable p );
	
	
	
	
	

	@Query("SELECT u FROM Formation u WHERE u.theme.nom like :status  AND u.dateLimiteInscription > CURRENT_DATE AND u.nbrPlaceReserve < u.capacite ")
	Page<Formation> findThemeC(
		  @Param("status") String mc,Pageable p );
	
	
	@Query("SELECT u FROM Formation u WHERE u.domaine.nom like :status  AND u.dateLimiteInscription > CURRENT_DATE AND u.nbrPlaceReserve < u.capacite ")
	Page<Formation> findDomaineC(
		  @Param("status") String mc,Pageable p );
	
}
