package com.projet.formationCertification.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.Formation;
import com.projet.formationCertification.entities.Niveau;

public interface NiveauRepository extends JpaRepository<Niveau, Long> {
	@Query("SELECT u FROM Niveau u WHERE u.themeNiveau.id = :status")
	List<Niveau> find(
	  @Param("status") Long id);
	
	@Query("SELECT u FROM Niveau u WHERE u.id = :status")
	Niveau findNiveau(
	  @Param("status") Long id);
	
	
	@Query("SELECT u FROM Niveau u WHERE u.themeNiveau.id = :status")
	List<Niveau> findThemeNiveau(
	  @Param("status") Long id);
}
