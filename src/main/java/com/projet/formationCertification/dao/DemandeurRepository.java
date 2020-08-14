package com.projet.formationCertification.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projet.formationCertification.entities.Demandeur;


public interface DemandeurRepository extends JpaRepository<Demandeur, Long> {
	@Query("SELECT u FROM Demandeur u WHERE u.cin = :status")
	Demandeur find(
	  @Param("status") String cin);
	
	@Query("SELECT u FROM Demandeur u WHERE u.cin = :status")
	Demandeur findParCin(
	  @Param("status")String cin);

	  @Query("SELECT u FROM Demandeur u WHERE u.email = :status")
	List<Demandeur> findParEmail(
	  @Param("status")String email);

}
