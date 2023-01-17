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
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Departement;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Employe;
import com.polytech.gestionEntreprise.gestionEntreprise.service.DepartmentService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.EmployeServiceImpl;

@CrossOrigin("*")

@RestController
@RequestMapping("/restapiEntreprise")


public class DepartementRestController {
	@Autowired 
	DepartmentService dp;
	@GetMapping("/getallDepartement")
	//@JsonProperty(access = Access.WRITE_ONLY)
//	@JsonIgnore
	public List<Departement> allDepartement() {
		
		return dp.allDepartement();
	}
}
