package com.projet.formationCertification.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.FormationFormateur;
import com.projet.formationCertification.entities.SeanceFormation;

public interface SeanceFormationDao extends JpaRepository<SeanceFormation, Long> {
	@Query("SELECT u FROM SeanceFormation u WHERE u.formationFormateur.id = :status")
	List<SeanceFormation> findSeanceFormateur(
	  @Param("status") Long id);
	

	@Query("SELECT u FROM SeanceFormation u WHERE u.formationFormateur.formation.id = :status")
	List<SeanceFormation> findSeanceFormations(
	  @Param("status") Long id);
	

	@Query("SELECT u FROM SeanceFormation u WHERE u.id = :status")
	SeanceFormation find(
	  @Param("status") Long id);
	

}
