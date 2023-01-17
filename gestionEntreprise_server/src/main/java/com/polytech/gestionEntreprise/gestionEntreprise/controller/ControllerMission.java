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

import com.polytech.gestionEntreprise.gestionEntreprise.entities.Departement;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Entreprise;
import com.polytech.gestionEntreprise.gestionEntreprise.entities.Mission;
import com.polytech.gestionEntreprise.gestionEntreprise.repository.MissionRepository;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IDepartmentService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IEmployeService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IEntrepriseService;
import com.polytech.gestionEntreprise.gestionEntreprise.service.IMissionService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/Entreprise")
@AllArgsConstructor
public class ControllerMission {
	
IMissionService im;
IDepartmentService dp;
IEntrepriseService em;
MissionRepository mr;

@GetMapping("/getAllMission")
public String listeMission(Model m) {
	List<Mission> liste =im.allMission();
	m.addAttribute("Mission",liste);
	m.addAttribute("Departement", liste);
	//m.addAttribute("Entreprise", liste);
	return "listeMission";
}


@GetMapping("/ajouterMission")
public String ajoutMission(Model m) {
	m.addAttribute("Departement",dp.allDepartement());
	m.addAttribute("Entreprise",em.getallEntreprise());
	return "ajouterMission";
}


@GetMapping("/Missionmc")
public String Missionmc(@RequestParam String mc , Model m) {
	List<Mission>liste=mr.findByNameContains(mc);
	m.addAttribute("Mission",liste);
	
	return "listeMission";
	
	
	
}



@PostMapping("/saveMission")
public String saveMission(@ModelAttribute Mission mi,Model m) {
		
	Integer id = mi.getId();
	im.SaveMission(mi);
	if (id != null) {
		return "redirect:/Entreprise/getAllMission";
	} else {
		m.addAttribute("message","added");
		m.addAttribute("Departement",dp.allDepartement());
		return "ajouterMission";
	}
}
@GetMapping("/supprimerMission/{id}")
public String suprrimerMission(@PathVariable int id) throws IOException  {
	im.supprimerMission(id);
	
	return "redirect:/Entreprise/getAllMission";
}




@GetMapping("/modifierMission/{idp}")
public String modifierMission(Model m, @PathVariable("idp") int id) {
	m.addAttribute("Mission",im.getMission(id));
	m.addAttribute("Departement",dp.allDepartement());
	
	return "ajouterMission";

}	







}
