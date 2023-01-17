package com.polytech.gestionEntreprise.gestionEntreprise.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Departement;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
@Service
public interface IEntrepriseService {

	void SaveEntreprise(Entreprise e,MultipartFile mf)throws IOException;
	List<Entreprise> getallEntreprise();
	Entreprise getEntreprise(int id);
	void supprimerEntreprise(int id) throws IOException ;
	public List<Departement> getDepartementByEntreprise(int idc);
	List<Entreprise> getEntrepriseByMC(String mc);
	void supprimerImage(Integer id) throws IOException;

    String saveImage(MultipartFile mf) throws IOException;
	
	byte[] getImage(int id) throws IOException;
}
