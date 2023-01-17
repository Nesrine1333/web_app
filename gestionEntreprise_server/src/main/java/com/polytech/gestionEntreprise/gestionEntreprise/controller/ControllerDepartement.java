package com.polytech.gestionEntreprise.gestionEntreprise.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.polytech.gestionEntreprise.gestionEntreprise.entities.Departement;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Employe;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Mission;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.EntrepriseRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IContratService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IDepartmentService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IEmployeService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IEntrepriseService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IMissionService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/Entreprise")
@AllArgsConstructor

public class ControllerDepartement {
	IDepartmentService dp;
	IEmployeService em;
	EntrepriseRepository er;
	IMissionService ms;
	IEntrepriseService es;
	@GetMapping("/getAllDepartement")
	public String listeDepartement(Model m) {
		List<Departement> liste =dp.allDepartement();
		m.addAttribute("Departement", liste);
		m.addAttribute("Employe", em.getAllEmployes());
		
		m.addAttribute("Mission",ms.allMission());
		m.addAttribute("Entreprise", es.getallEntreprise());
	
		
		return "listeDepartement";
	}
	@GetMapping("/DepartementParEntreprise")
	public String getDepartementParMC(@RequestParam("Entreprise") int idc,Model m) {
		m.addAttribute("Entreprises", es.getallEntreprise());
		if(idc==0) {
			m.addAttribute("Departements", dp.allDepartement());
			return "redirect:/Entreprise/getAllDepartement";
		}else {
			m.addAttribute("Departements", es.getDepartementByEntreprise(idc));
			m.addAttribute("Entreprise",er.getById(idc).getName());
			return "listeDepartement";
		}
	}
	
	@GetMapping("/ajouterDepartement")
	public String addDepartment(Model m) {
		
		m.addAttribute("Employe",em.getAllEmployes());
		m.addAttribute("Mission",ms.allMission());
		m.addAttribute("Entreprise",es.getallEntreprise());
		
		return "ajouterDepartement";
	}
	
	
	
	@GetMapping("/Departementmc")
	public String Departementmc(@RequestParam String mc , Model m) {
		List<Departement>liste=dp.getDepartementByMC(mc);
		m.addAttribute("Departement", liste);
		return "listeDepartement";
		
		
		
	}
	

	
	@GetMapping("/supprimerDepartment/{id}")
	public String suprrimerDepartment(@PathVariable int id) throws IOException {
		dp.DeleteDepartement(id);
		return "redirect:/Entreprise/getAllDepartement";
	}
	
	
	@PostMapping("/saveDepartment")
	public String saveDepartement(@ModelAttribute Departement d ,Model m)
			 {
		Integer id = d.getId();
		dp.SaveDepartement(d);
		if (id != null) {
			return "redirect:/Entreprise/getAllDepartement";
		} else {
			m.addAttribute("message", "added successfuly");
			m.addAttribute("Employe",em.getAllEmployes());
			m.addAttribute("Mission",ms.allMission());
			m.addAttribute("Entreprise",es.getallEntreprise());
			return "ajouterDepartement";
		}
	}
	
	
	

	
	
	
	@GetMapping("/modifierDepartment/{id}")
	public String modifierDepartment(Model m,@PathVariable("id")int id){
		m.addAttribute("Departement",dp.getAllDepartement(id));
		m.addAttribute("Employe",em.getAllEmployes());
		m.addAttribute("Mission",ms.allMission());
		m.addAttribute("Entreprise",es.getallEntreprise());
		return "ajouterDepartement";
	}
	
}
