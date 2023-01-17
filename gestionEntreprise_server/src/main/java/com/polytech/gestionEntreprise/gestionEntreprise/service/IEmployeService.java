package com.polytech.gestionEntreprise.gestionEntreprise.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Departement;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Employe;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
@Service
public interface IEmployeService {
	List<Employe> getAllEmployes();
	Employe getAllEmploye(int id);
	
	void saveEmploye(Employe e);
	public void supprimerEmploye(int id) throws IOException;
	List<Employe> getEmployeByMC(String mc);
	public void ajouterEmploye(Employe employe);
	
}
