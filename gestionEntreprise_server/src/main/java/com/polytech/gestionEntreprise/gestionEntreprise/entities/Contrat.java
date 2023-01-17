package com.polytech.gestionEntreprise.gestionEntreprise.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity
@AllArgsConstructor @NoArgsConstructor
public class Contrat   {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer reference;
	private String typeContrat;
	private float salaire;
	@OneToOne(mappedBy="contrat")
	private Employe employe;

	

	
	
	
}
