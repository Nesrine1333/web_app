package com.polytech.gestionEntreprise.gestionEntreprise.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.polytech.gestionEntreprise.gestionEntreprise.entities.Contrat;



public interface ContratRepository extends JpaRepository<Contrat, Integer>{
	List<Contrat> findBytypeContratContains(String mc);
} 
