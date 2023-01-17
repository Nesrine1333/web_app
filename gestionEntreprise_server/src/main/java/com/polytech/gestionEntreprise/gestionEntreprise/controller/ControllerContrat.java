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

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Contrat;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Mission;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.ContratRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.DepartementRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.service.EmployeServiceImpl;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IContratService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IDepartmentService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IEmployeService;

import lombok.AllArgsConstructor;


@Controller
@RequestMapping("/Entreprise")
@AllArgsConstructor
public class ControllerContrat {
IContratService cr;
IEmployeService em;
ContratRepository cp;
@GetMapping("/allContrat")

public String listeContrat(Model m) {
	List<Contrat> liste = cr.getallContrat();
	m.addAttribute("Contrat", liste);
	m.addAttribute("Contrat", cr.getallContrat());
	m.addAttribute("Employe", em.getAllEmployes());
	return "listContrat";
}


@GetMapping("/ajouterContrat")
public String ajoutContrat(Model m) {
	m.addAttribute("Employe",em.getAllEmployes());
	return "ajouterContrat";
}
@GetMapping("/supprimer/{id}")
public String suprrimerContrat(@PathVariable int id) throws IOException {
	cr.supprimerContrat(id);
	return "redirect:/Entreprise/allContrat";

}
@GetMapping("/Contratmc")
public String Contratmc(@RequestParam String mc , Model m) {
	List<Contrat> liste =cp.findBytypeContratContains(mc);
	m.addAttribute("Contrat", liste);
	return "listContrat";
	
	
	
}


@PostMapping("/saveContrat")
public String saveContrat(@ModelAttribute Contrat cm, Model m) {
	Integer id = cm.getReference();
	cr.SaveContrat(cm);
	if (id != null) {
		return "redirect:/Entreprise/allContrat";
	} else {
		m.addAttribute("message", "added successfuly");
		m.addAttribute("Employe",em.getAllEmployes());
		return "ajouterContrat";
	}
}



@GetMapping("/modifierContrat/{idp}")
public String modifierContrat(Model m, @PathVariable("idp") int reference) {
	m.addAttribute("Contrat", cr.getAllContrat(reference));
	m.addAttribute("Employe",em.getAllEmployes());
	//m.addAttribute("Employe",em.getAllEmployes());
	
	return "ajouterContrat";

}	
}
