package com.polytech.gestionEntreprise.gestionEntreprise.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.polytech.gestionEntreprise.gestionEntreprise.entities.Departement;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.EmployeRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.EntrepriseRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class EntrepriseService implements IEntrepriseService{
EntrepriseRepository er;
	

	@Override
	public List<Entreprise> getallEntreprise() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public Entreprise getEntreprise(int id) {
		// TODO Auto-generated method stub
		return er.getById(id);
	}

	@Override
	public void supprimerEntreprise(int id) throws IOException {
     er.deleteById(id);
		
	}


	@Override
	public List<Entreprise> getEntrepriseByMC(String mc) {
		// TODO Auto-generated method stub
		return er.findByNameContains(mc);
	}

	@Override
	public List<Departement> getDepartementByEntreprise(int idc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerImage(Integer id) throws IOException {
    Entreprise entreprise = er.getById(id);
		
		String chemin = System.getProperty("user.dir") + "/src/main/webapp/imagesdata/";
		Path p = Paths.get(chemin,entreprise.getPhoto());
		System.out.println(p);
		Files.delete(p);
		
		
	}

	
	@Override
	public byte[] getImage(int id) throws IOException {
		String nomImage=er.findById(id).get().getPhoto();
		Path p = Paths.get(System.getProperty("user.dir")+"/src/main/webapp/imagesdata/",nomImage);
		return Files.readAllBytes(p);
	}

	@Override
	public String saveImage(MultipartFile mf) throws IOException {
		String nameFile =mf.getOriginalFilename();
		String tab[] = nameFile.split("\\.");
		String fileModif = tab[0] + "_" + System.currentTimeMillis() + "." + tab[1];
		String chemin = System.getProperty("user.dir") + "/src/main/webapp/imagesdata/";
		Path p = Paths.get(chemin,fileModif);
		Files.write(p, mf.getBytes());
		return fileModif;
	}

	@Override
	public void SaveEntreprise(Entreprise e, MultipartFile mf) throws IOException {
		String photo;
		if(mf!=null) {
			photo=saveImage(mf);
			e.setPhoto(photo);
			}
		er.save(e);
		
	}

}






