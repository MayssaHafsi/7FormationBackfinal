package com.projet.formationCertification.dao;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.projet.formationCertification.entities.Domaine;
import com.projet.formationCertification.entities.Formateur;

public interface DomaineRepository extends JpaRepository<Domaine, Long> {
	@Query("SELECT u FROM Domaine u WHERE u.id = :status")
	Domaine find(
	  @Param("status") Long id);

	
	
	
	@Query("SELECT v FROM Domaine v")
	Page<Domaine> findAllPage(Pageable p );
	
	
	@Query("SELECT u FROM Domaine u WHERE u.nom like :status")
Page<Domaine> findNom(
	  @Param("status") String mc,Pageable p );
}
