package com.polytech.gestionEntreprise.gestionEntreprise.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Contrat;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Employe;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Mission;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.EmployeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository em;
	
	public void ajouterEmploye(Employe employe) {
		em.save(employe);
		
	}


	public List<Employe> getAllEmployes() {
		// TODO Auto-generated method stub
		return em.findAll();
	}



	
	public List<Employe> getEmployeByMC(String mc)  {
		// TODO Auto-generated method stub
		return em.findByprenomContains(mc);
	}
	

	@Override
	public void supprimerEmploye(int id) throws IOException{
		
		em.deleteById(id);
		// TODO Auto-generated method stub
		
		
	}



	public void saveEmploye(Employe e) {
		// TODO Auto-generated method stub
		em.save(e);
	}




	@Override
	public Employe getAllEmploye(int id) {
		// TODO Auto-generated method stub
		return em.getById(id);
	}



		// TODO Auto-generated method stub
		//return em.findById(id).get();
	

	
	//dp.save(d);
}
