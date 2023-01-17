package com.polytech.gestionEntreprise.gestionEntreprise.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Mission;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.MissionRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class MissionService implements IMissionService {
	MissionRepository ms;
	

	
	

	@Override
	public void SaveMission(Mission m) {
		ms.save(m);
		
	}

	@Override
	public void addMission(Mission m) {
		ms.save(m);
		
	}

	@Override
	public List<Mission> getallMission(int id) {
		// TODO Auto-generated method stub
		return ms.findAll();
	}

	@Override
	public List<Mission> allMission() {
		// TODO Auto-generated method stub
		return ms.findAll();
	}
	


	public List<Mission> getMissionByMC(String mc)  {
		// TODO Auto-generated method stub
		return ms.findByNameContains(mc); 
	}

	@Override
	public void supprimerMission(int id) throws IOException {
		ms.deleteById(id);
		
	}
	@Override
	public Mission getMission(int id) {
		// TODO Auto-generated method stub
		return ms.getById(id);
	}

}

