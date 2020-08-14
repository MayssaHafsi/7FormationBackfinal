package com.projet.formationCertification.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.Cours;
import com.projet.formationCertification.entities.Domaine;

public interface CoursRepository extends JpaRepository<Cours, Long> {
	@Query("SELECT u FROM Cours u WHERE u.id = :status")
	Cours find(
	  @Param("status") Long id);
	
	
	@Query("SELECT u FROM Cours u WHERE u.formationCours.id = :status")
	List<Cours> findCours(
	  @Param("status") Long id);
}
