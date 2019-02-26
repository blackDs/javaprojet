package com.c5.core;

import java.util.Date;

public class Conserver extends Alimentaire {
	private double stock;	
	private Date dateFabrication;
	private enum emballage{liquide,embalee}
		
	public Conserver(int idArticle, String nomArticle, double prixArticle, String typeArticle, String fournisseur,
			Date dateExpiration,Date dateFabrication,emballage emballage) {
		
		super(idArticle, nomArticle, prixArticle, typeArticle, fournisseur, dateExpiration);
		this.dateFabrication=dateFabrication;
		emballage=emballage;
	
	}

	public Date getDateFabrication() {
		return dateFabrication;
	}

	public void setDateFabrication(Date dateFabrication) {
		this.dateFabrication = dateFabrication;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

}
