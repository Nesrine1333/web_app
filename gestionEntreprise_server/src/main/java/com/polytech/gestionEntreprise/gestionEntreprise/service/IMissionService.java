package com.polytech.gestionEntreprise.gestionEntreprise.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Departement;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Mission;
@Service
public interface IMissionService {
	public void addMission(Mission m);	
	void SaveMission(Mission m) ;
	List<Mission> getallMission(int id);
	public List<Mission> allMission();
	void supprimerMission(int id) throws IOException ;
	Mission getMission(int id);
}
