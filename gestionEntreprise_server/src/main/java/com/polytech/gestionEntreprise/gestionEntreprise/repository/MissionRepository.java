package com.polytech.gestionEntreprise.gestionEntreprise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer>{
	List<Mission> findByNameContains(String mc);
}
