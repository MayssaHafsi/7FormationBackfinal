package com.projet.formationCertification.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.Fichier;


public interface FichierRepository extends JpaRepository<Fichier, Long> {
	@Query("SELECT u FROM Fichier u WHERE u.id = :status")
	Fichier find(
	  @Param("status") Long id);
	
	
	@Query("SELECT u FROM Fichier u WHERE u.formateurfichier.id = :status")
	List<Fichier> findFichier(
	  @Param("status") Long id);
}
