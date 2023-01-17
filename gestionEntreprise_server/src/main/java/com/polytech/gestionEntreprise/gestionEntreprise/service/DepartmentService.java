package com.polytech.gestionEntreprise.gestionEntreprise.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Departement;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.DepartementRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.EmployeRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class DepartmentService implements IDepartmentService {
	DepartementRepository dp;
	@Override
	public void addDepartment(Departement dep) {
		
		dp.save(dep);
	}

	@Override
	public List<Departement> allDepartement() {
		// TODO Auto-generated method stub
		return dp.findAll();
	}

	@Override
	public void DeleteDepartement(int id) {
		dp.deleteById(id);
		
	}

	@Override
	public void SaveDepartement(Departement d) {
		// TODO Auto-generated method stub
		dp.save(d);
	}

	@Override
	public List<Departement> getDepartementByMC(String mc) {
		// TODO Auto-generated method stub
		return dp.findByNameContains(mc);
	}



	@Override
	public Departement getAllDepartement(int id) {
		// TODO Auto-generated method stub
		return  dp.getById(id);
	}



}
