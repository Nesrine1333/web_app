package com.polytech.gestionEntreprise.gestionEntreprise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.polytech.gestionEntreprise.gestionEntreprise.entities.Employe;


public interface EmployeRepository extends JpaRepository<Employe, Integer> {
	List<Employe> findByprenomContains(String mc);
}
