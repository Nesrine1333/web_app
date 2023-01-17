package com.polytech.gestionEntreprise.gestionEntreprise.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Contrat;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Mission;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.ContratRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.EmployeRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ContratService implements IContratService{
	ContratRepository cr;

	@Override
	public void SaveContrat(Contrat c) {
	
		cr.save(c);
	}

	@Override
	public List<Contrat> getallContrat() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	
	

	@Override
	public void supprimerContrat(int id) throws IOException{
	cr.deleteById(id);
		
	}
	public List<Contrat> getContratByMC(String mc)  {
		// TODO Auto-generated method stub
		return cr.findBytypeContratContains(mc);
	}

	@Override
	public Contrat getAllContrat(int reference) {
		// TODO Auto-generated method stub
		return cr.getReferenceById(reference);
	}
	
}
