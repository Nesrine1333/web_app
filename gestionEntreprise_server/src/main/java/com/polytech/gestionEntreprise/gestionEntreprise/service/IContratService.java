package com.polytech.gestionEntreprise.gestionEntreprise.service;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Contrat;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Employe;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.EmployeRepository;

import lombok.AllArgsConstructor;
@Service

public interface IContratService {
	void SaveContrat(Contrat c);
	List<Contrat> getallContrat();
	Contrat getAllContrat(int reference);
	void supprimerContrat(int id) throws IOException ;
	
}
