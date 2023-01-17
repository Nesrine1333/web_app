package com.polytech.gestionEntreprise.gestionEntreprise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Departement;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;

public interface DepartementRepository extends JpaRepository<Departement, Integer>{
	List<Departement> findByNameContains(String mc);
}
