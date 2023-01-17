package com.polytech.gestionEntreprise.gestionEntreprise.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Mission;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.EmployeRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IEntrepriseService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.MissionService;

@CrossOrigin("*")

@RestController
@RequestMapping("/restapiEntreprise")


public class MissionRestController {

	@Autowired 
	
	MissionService ms;
	@GetMapping("/getallMissions")
	@JsonProperty(access = Access.WRITE_ONLY)
	@JsonIgnore
	public List<Mission> allMission(){
	
		return ms.allMission();
	}

	
	
	
	
}
