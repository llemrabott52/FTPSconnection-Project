package com.monetique.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Parameter {   
	// IntrmediareDest = "C:\Users\stadigital\Documents\IntermediareLogDoc";

@Id
@GeneratedValue
	Long id;
    public String urlIntermediaire;
    
    
    public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	
	
	public void setUrlIntermediaire(String urlIntermediaire) {
		this.urlIntermediaire = urlIntermediaire;
	}
	public String getUrlIntermediaire() {
		return urlIntermediaire;
	}
   
   
   
   
   
   
   
   
}
