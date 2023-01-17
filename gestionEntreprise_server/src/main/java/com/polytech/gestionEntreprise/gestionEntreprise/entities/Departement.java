package com.polytech.gestionEntreprise.gestionEntreprise.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity
@AllArgsConstructor @NoArgsConstructor
public class Departement {

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;
	
	//@JsonManagedReference 
	
	@ManyToMany
	@JsonIgnore
	private List<Employe> employes;
	
	@OneToMany(mappedBy="departement")
	private List<Mission> missions;
	
	@ManyToOne
	private Entreprise entreprise;

	
}
