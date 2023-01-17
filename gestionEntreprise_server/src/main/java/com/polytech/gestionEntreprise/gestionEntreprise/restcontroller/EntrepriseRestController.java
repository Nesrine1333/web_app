package com.polytech.gestionEntreprise.gestionEntreprise.restcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Employe;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.EmployeRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IEntrepriseService;

@CrossOrigin("*")

@RestController
@RequestMapping("/restapiEntreprise")



public class EntrepriseRestController {

	@Autowired 
	IEntrepriseService es;
	@Autowired 
	EmployeRepository em;
	
	@GetMapping("/allEntreprises")
	@JsonProperty(access = Access.WRITE_ONLY)
	@JsonIgnore
	public List<Entreprise> getAllEmployes() {
		
		return es.getallEntreprise();
	}

	
	@GetMapping("/get/{id}")
	public  Entreprise getEntrepriseid(@PathVariable("id") Integer id){
		return es.getEntreprise(id);
		}

	
	
	@GetMapping(path="/getImage/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@PathVariable("id") int id) throws IOException {
		return es.getImage(id);
	}
	
	
	
}
	
	
	
	
	
	
	

