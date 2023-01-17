package com.polytech.gestionEntreprise.gestionEntreprise.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity
@AllArgsConstructor @NoArgsConstructor
public class Entreprise {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String photo;
	@OneToMany(mappedBy="entreprise", cascade=CascadeType.ALL)

	//private List<Departement> departements = new ArrayList<>();
	@JsonIgnore
	private List<Departement> departements;
}
