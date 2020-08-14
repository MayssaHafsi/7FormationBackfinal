package com.projet.formationCertification.dao;

import java.text.Normalizer.Form;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.projet.formationCertification.entities.Domaine;
import com.projet.formationCertification.entities.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, String> {
	
	@Query("SELECT v FROM Formateur v")
	Page<Formateur> findAllPage(Pageable p );
	
	@Query("SELECT u FROM Formateur u WHERE u.cin = :status")
	Formateur find(
	  @Param("status") String cin);

	  @Query("SELECT u FROM Formateur u WHERE u.email = :status")
	Formateur find1(
	  @Param("status") String email);
	
	@Query("SELECT u FROM Formateur u WHERE u.cin like :status")
Page<Formateur> findPageFormateur(
	  @Param("status") String mc,Pageable p );

	  @Query("SELECT u FROM Formateur u WHERE u.email = :status")
	  Formateur findEmail(
		@Param("status") String email);

	}
