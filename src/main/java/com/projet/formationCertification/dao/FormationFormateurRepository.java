package com.projet.formationCertification.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.FormationFormateur;

public interface FormationFormateurRepository extends JpaRepository<FormationFormateur, Long> {
	@Query("SELECT u FROM FormationFormateur u WHERE u.formation.id = :status GROUP BY u.formateur.cin")
	List<FormationFormateur> findFormateur(
	  @Param("status") Long id);
	
	
	@Query("SELECT u FROM FormationFormateur u WHERE u.formation.id = :status")
	Page<FormationFormateur> findAllPage(@Param("status") Long id ,  Pageable p );
	
	
	
	
	@Query("SELECT u FROM FormationFormateur u WHERE u.id = :status")
	FormationFormateur find(@Param("status") Long id);
}
