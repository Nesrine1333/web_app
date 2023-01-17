package com.polytech.gestionEntreprise.gestionEntreprise.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Contrat;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Employe;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Mission;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.ContratRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.DepartementRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.EmployeRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.service.EmployeServiceImpl;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IContratService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IDepartmentService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IEmployeService;

import lombok.AllArgsConstructor;



@Controller
@RequestMapping("/Entreprise")
@AllArgsConstructor
public class IControllerEmployeImpl  {
	EmployeServiceImpl em;
	IEmployeService emp;
	IContratService cs;
	IDepartmentService dp;
	DepartementRepository dr;
	ContratRepository cr;
	EmployeRepository er;
	@GetMapping(value = "/getAllEmployes")
   
	public String getAllEmployes(Model m) {
		List<Employe>liste=em.getAllEmployes();
		
		m.addAttribute("liste",em.getAllEmployes());
	//	m.addAttribute("Employe",liste)
		
		m.addAttribute("departments",dr.findAll() );
		m.addAttribute("Contrat",cr.findAll());
		m.addAttribute("departments", "All Departments");
		m.addAttribute("Contrat", "All Contrats");
		
		m.addAttribute("Departement",dp.allDepartement());
		return "employe";
	}
	
	
	@GetMapping("/supprimerEmploye/{id}")
	public String supprimerEmp(@PathVariable int id) throws IOException {
		em.supprimerEmploye(id);
		return "redirect:/Entreprise/getAllEmployes";
	}
	
	
	
	
	
	
	
	@PostMapping("/saveEmploye")
	public String saveEmploye(@ModelAttribute Employe e, Model m)
	{
		Integer id = e.getId();
		em.saveEmploye(e);
		if (id != null) {
			return "redirect:/Entreprise/getAllEmployes";
		} else {
			m.addAttribute("message", "added successfuly");
			m.addAttribute("departments",dp.allDepartement());
			m.addAttribute("contrat",cs.getallContrat());
			return "AjouterEmploye";
		}
	
	
	
}
	

	
	
	
	
	@GetMapping("/ajouterEmploye")
	public String ajouterEmploye(Model m) {
		m.addAttribute("departments",dp.allDepartement());
		m.addAttribute("contrat",cs.getallContrat());
		return "AjouterEmploye";
	}
	
	
	


	
	
	
	
	
	
	@GetMapping("/Employemc")
	public String Employemc(@RequestParam String mc , Model m) {
		List<Employe>liste=er.findByprenomContains(mc);
		m.addAttribute("liste",liste);
		return "employe";
		
		
		
	}
	@GetMapping("/modifierEmploye/{idp}")
	public String modifierEmploye(Model m, @PathVariable("idp") int id) {
		m.addAttribute("liste", em.getAllEmploye(id));
		
		m.addAttribute("departments",dp.allDepartement());
		m.addAttribute("contrat",cs.getallContrat());
		return "AjouterEmploye";

	}
	

	
	
	}
