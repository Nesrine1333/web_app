package com.polytech.gestionEntreprise.gestionEntreprise.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Employe;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
import com.polytech.gestionEntreprise.gestionEntreprise.service.DepartmentService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.EmployeServiceImpl;
import com.polytech.gestionEntreprise.gestionEntreprise.service.EntrepriseService;

import lombok.AllArgsConstructor;
@CrossOrigin("*")

@RestController
@RequestMapping("/restapiEntreprise")


public class EmployeRestController {
	@Autowired 
	EmployeServiceImpl em;
	@GetMapping("/getallEmploye")
	//@JsonProperty(access = Access.WRITE_ONLY)
	//@JsonIgnore
	public List<Employe> getAllEmployes() {
		
		return em.getAllEmployes();
	}

}
