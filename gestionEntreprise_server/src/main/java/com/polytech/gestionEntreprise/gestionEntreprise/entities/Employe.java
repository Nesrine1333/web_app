package com.polytech.gestionEntreprise.gestionEntreprise.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @Entity
@AllArgsConstructor @NoArgsConstructor
public class Employe  {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String prenom;
	
	private String nom;
	
	private String email;


	
	
	
	@JsonIgnore
	@ManyToMany(mappedBy="employes",fetch=FetchType.EAGER )

	private List<Departement> departements;
	
	@JsonIgnore
	
	@OneToOne(cascade=CascadeType.ALL)
	private Contrat contrat;
	
	
	

}
