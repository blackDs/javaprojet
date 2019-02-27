package com.c5.core;

import java.util.Date;

public class Alimentaire extends Article {
	
	private Date dateExpiration;
		
	public Alimentaire(int idArticle, String nomArticle,
			double prixArticle, String typeArticle, String fournisseur,Date dateExpiration) {
		
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur);
		this.setDateExpiration(dateExpiration);
		
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	

}
