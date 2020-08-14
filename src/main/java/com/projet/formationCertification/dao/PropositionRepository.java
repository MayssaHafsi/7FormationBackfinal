package com.projet.formationCertification.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.Proposition;

public interface PropositionRepository extends JpaRepository<Proposition, Long> {
	
	@Query("SELECT u FROM Proposition u WHERE u.id = :status")
	Proposition find(@Param("status") Long id);

	@Query("SELECT u FROM Proposition u WHERE u.type like :status")
	Page<Proposition> findType(
		  @Param("status") String mc,Pageable p );

}
