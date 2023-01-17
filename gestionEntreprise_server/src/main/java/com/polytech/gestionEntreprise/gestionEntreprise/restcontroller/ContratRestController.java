package com.polytech.gestionEntreprise.gestionEntreprise.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Contrat;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Employe;
import com.polytech.gestionEntreprise.gestionEntreprise.service.ContratService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.EmployeServiceImpl;

@CrossOrigin("*")

@RestController
@RequestMapping("/restapiEntreprise")

public class ContratRestController {
	@Autowired 
	ContratService cs;
	@GetMapping("/getallContrat")
	//@JsonProperty(access = Access.WRITE_ONLY)
	@JsonIgnore
	public List<Contrat> getAllContrats() {
		
		return cs.getallContrat();
	}
}
