package com.polytech.gestionEntreprise.gestionEntreprise.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Departement;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.EmployeRepository;

import lombok.AllArgsConstructor;

@Service
public interface IDepartmentService {

	public void addDepartment(Departement dep);	
	public List<Departement> allDepartement();
	public void DeleteDepartement(int id);
	
	void SaveDepartement(Departement d);
	List<Departement> getDepartementByMC(String mc);
	Departement getAllDepartement(int id);
	
	
	
	
	
}
