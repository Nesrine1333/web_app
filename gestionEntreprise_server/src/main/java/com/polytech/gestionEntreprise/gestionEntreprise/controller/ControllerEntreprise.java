package com.polytech.gestionEntreprise.gestionEntreprise.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Departement;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.EntrepriseRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.service.DepartmentService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.EntrepriseService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IDepartmentService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IEmployeService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/Entreprise")
@AllArgsConstructor

public class ControllerEntreprise {

EntrepriseService es;
DepartmentService ds;	
EntrepriseRepository er;
@GetMapping("/getAllEntreprise")

public String listeEntreprise(Model m) {
	
	List<Entreprise> liste =es.getallEntreprise();
	m.addAttribute("Entreprise", es.getallEntreprise());
	m.addAttribute("Departement", liste);
	m.addAttribute("Departement",ds.allDepartement());

	return "listeEntreprise";
}

	
	
@GetMapping("/ajouterEntreprise")
public String addEntreprise(Model m) {
	m.addAttribute("Departement",ds.allDepartement());
	
	return "ajouterEntreprise";
}
@GetMapping("/departementmc")
public String Produitmc(@RequestParam String mc , Model m) {
	List<Entreprise>liste=es.getEntrepriseByMC(mc);
	m.addAttribute("Entreprise",liste);
	return "listeEntreprise";
}

@PostMapping("/saveEntreprise")
public String saveDepartement(@ModelAttribute Entreprise E ,@RequestParam("file") MultipartFile mf,Model m) throws IOException
		 {
	Integer id = E.getId();
	es.SaveEntreprise(E,mf);
	if (id != null) {
		return "redirect:/Entreprise/getAllEntreprise";
	} else {
		m.addAttribute("message", "added successfuly");
		m.addAttribute("Departement",ds.allDepartement());
		
		return "ajouterEntreprise";
	}
}




@GetMapping("/supprimerEntreprise/{id}")
public String suprrimerEntreprise(@PathVariable int id) throws IOException  {

	es.supprimerEntreprise(id);

	// TODO Auto-generated catch block



	return "redirect:/Entreprise/getAllEntreprise";
}

@GetMapping("/modifierEntreprise/{idp}")
public String modifierEntreprise(Model m, @PathVariable("idp") int id) {
	m.addAttribute("Entreprise", es.getEntreprise(id));
	
	
	return "ajouterEntreprise";

}	
}
